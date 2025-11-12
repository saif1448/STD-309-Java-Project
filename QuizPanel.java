import javax.swing.*;
import java.awt.*;
import java.util.List;

public class QuizPanel extends JPanel {
    
    private QuizApp parentApp;
    private QuizState quizState;
    
    private JLabel categoryLabel;
    private JLabel progressLabel;
    private JLabel scoreLabel;
    private JLabel questionLabel;
    private JRadioButton[] optionButtons;
    private ButtonGroup buttonGroup;
    private JButton submitButton;
    private JButton nextButton;
    private JLabel feedbackLabel;
    
    private List<Question> currentQuestions;
    private int currentQuestionIndex;
    private Question currentQuestion;
    
    public QuizPanel(QuizApp app) {
        this.parentApp = app;
        this.quizState = app.getQuizState();
        
        setLayout(new BorderLayout());
        setBackground(QuizApp.BACKGROUND_COLOR);
        
        // Header
        add(createHeaderPanel(), BorderLayout.NORTH);
        
        // Question area
        add(createQuestionPanel(), BorderLayout.CENTER);
        
        // Bottom buttons
        add(createBottomPanel(), BorderLayout.SOUTH);
    }
    
    private JPanel createHeaderPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(QuizApp.PRIMARY_COLOR);
        panel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
        
        // Left: Category badge
        categoryLabel = new JLabel("Easy");
        categoryLabel.setFont(new Font("Arial", Font.BOLD, 18));
        categoryLabel.setForeground(Color.WHITE);
        categoryLabel.setOpaque(true);
        categoryLabel.setBackground(QuizApp.SECONDARY_COLOR);
        categoryLabel.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        
        // Center: Progress
        progressLabel = new JLabel("Question 1 / 15");
        progressLabel.setFont(new Font("Arial", Font.BOLD, 16));
        progressLabel.setForeground(Color.WHITE);
        progressLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        // Right: Score
        scoreLabel = new JLabel("Score: 0 / 15");
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 16));
        scoreLabel.setForeground(Color.WHITE);
        
        panel.add(categoryLabel, BorderLayout.WEST);
        panel.add(progressLabel, BorderLayout.CENTER);
        panel.add(scoreLabel, BorderLayout.EAST);
        
        return panel;
    }
    
    private JPanel createQuestionPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(QuizApp.BACKGROUND_COLOR);
        
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(QuizApp.WHITE);
        contentPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(220, 220, 220), 1),
            BorderFactory.createEmptyBorder(30, 40, 30, 40)
        ));
        contentPanel.setPreferredSize(new Dimension(700, 400));
        
        // Question text
        questionLabel = new JLabel();
        questionLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        questionLabel.setForeground(QuizApp.TEXT_COLOR);
        questionLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        contentPanel.add(questionLabel);
        contentPanel.add(Box.createVerticalStrut(20));
        
        // Options
        buttonGroup = new ButtonGroup();
        optionButtons = new JRadioButton[4];
        
        for (int i = 0; i < 4; i++) {
            optionButtons[i] = new JRadioButton();
            optionButtons[i].setFont(new Font("Arial", Font.PLAIN, 14));
            optionButtons[i].setForeground(QuizApp.TEXT_COLOR);
            optionButtons[i].setBackground(QuizApp.WHITE);
            optionButtons[i].setAlignmentX(Component.LEFT_ALIGNMENT);
            optionButtons[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
            buttonGroup.add(optionButtons[i]);
            contentPanel.add(optionButtons[i]);
            contentPanel.add(Box.createVerticalStrut(10));
        }
        
        contentPanel.add(Box.createVerticalStrut(10));
        
        // Feedback label
        feedbackLabel = new JLabel(" ");
        feedbackLabel.setFont(new Font("Arial", Font.BOLD, 14));
        feedbackLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        contentPanel.add(feedbackLabel);
        
        panel.add(contentPanel);
        return panel;
    }
    
    private JPanel createBottomPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 15));
        panel.setBackground(QuizApp.BACKGROUND_COLOR);
        
        submitButton = createStyledButton("Submit Answer", QuizApp.SECONDARY_COLOR);
        submitButton.setPreferredSize(new Dimension(150, 45));
        submitButton.addActionListener(e -> checkAnswer());
        
        nextButton = createStyledButton("Next Question", QuizApp.PRIMARY_COLOR);
        nextButton.setPreferredSize(new Dimension(150, 45));
        nextButton.setEnabled(false);
        nextButton.addActionListener(e -> nextQuestion());
        
        panel.add(submitButton);
        panel.add(nextButton);
        
        return panel;
    }
    
    public void startQuiz() {
        currentQuestions = quizState.getCurrentQuestions();
        currentQuestionIndex = 0;
        updateHeader();
        displayQuestion();
    }
    
    private void displayQuestion() {
        if (currentQuestionIndex >= currentQuestions.size()) {
            showCategoryResult();
            return;
        }
        
        currentQuestion = currentQuestions.get(currentQuestionIndex);
        
        // Update question text
        questionLabel.setText("<html>" + currentQuestion.getQuestion() + "</html>");
        
        // Update options
        String[] options = currentQuestion.getOptions();
        for (int i = 0; i < optionButtons.length && i < options.length; i++) {
            optionButtons[i].setText((char)('a' + i) + ") " + options[i]);
            optionButtons[i].setSelected(false);
            optionButtons[i].setEnabled(true);
            optionButtons[i].setForeground(QuizApp.TEXT_COLOR);
        }
        
        // Reset UI
        feedbackLabel.setText(" ");
        submitButton.setEnabled(true);
        nextButton.setEnabled(false);
        
        // Update progress
        progressLabel.setText("Question " + (currentQuestionIndex + 1) + " / " + currentQuestions.size());
    }
    
    private void checkAnswer() {
        // Find selected option
        int selectedIndex = -1;
        for (int i = 0; i < optionButtons.length; i++) {
            if (optionButtons[i].isSelected()) {
                selectedIndex = i;
                break;
            }
        }
        
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(this, 
                "Please select an answer!", 
                "No Selection", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Check if correct
        boolean isCorrect = (selectedIndex == currentQuestion.getCorrectAnswerIndex());
        quizState.recordAnswer(currentQuestion, isCorrect);
        
        // Show feedback
        if (isCorrect) {
            feedbackLabel.setText("✓ Correct!");
            feedbackLabel.setForeground(QuizApp.SECONDARY_COLOR);
        } else {
            int correctIndex = currentQuestion.getCorrectAnswerIndex();
            feedbackLabel.setText("✗ Incorrect! Correct answer: " + 
                (char)('a' + correctIndex) + ") " + 
                currentQuestion.getOptions()[correctIndex]);
            feedbackLabel.setForeground(QuizApp.ACCENT_COLOR);
        }
        
        // Disable options and submit
        for (JRadioButton btn : optionButtons) {
            btn.setEnabled(false);
        }
        submitButton.setEnabled(false);
        nextButton.setEnabled(true);
        
        // Update score
        updateHeader();
    }
    
    private void nextQuestion() {
        currentQuestionIndex++;
        displayQuestion();
    }
    
    private void updateHeader() {
        categoryLabel.setText(quizState.getCurrentCategory() + 
            (quizState.isRetryMode() ? " (Retry)" : ""));
        scoreLabel.setText("Score: " + quizState.getCurrentScore() + " / " + quizState.getCurrentTotal());
    }
    
    private void showCategoryResult() {
        double percentage = quizState.getCurrentPercentage();
        boolean passed = quizState.hasPassedCurrentCategory();
        
        String message = String.format(
            "Category: %s\n\nScore: %d / %d (%.1f%%)\n\n%s",
            quizState.getCurrentCategory(),
            quizState.getCurrentScore(),
            quizState.getCurrentTotal(),
            percentage,
            passed ? "Great job! You passed!" : "You need 75% to pass. Let's retry the questions you got wrong."
        );
        
        String[] options = passed ? 
            new String[]{"Continue", "Back to Menu"} : 
            new String[]{"Retry Wrong Answers", "Back to Menu"};
        
        int choice = JOptionPane.showOptionDialog(
            this,
            message,
            "Category Complete",
            JOptionPane.DEFAULT_OPTION,
            passed ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.WARNING_MESSAGE,
            null,
            options,
            options[0]
        );
        
        if (choice == 0) {
            if (passed) {
                if (quizState.isQuizComplete()) {
                    showFinalCertificate();
                } else {
                    quizState.exitRetryMode();
                    quizState.moveToNextCategory();
                    startQuiz();
                }
            } else {
                quizState.enterRetryMode();
                startQuiz();
            }
        } else {
            parentApp.showIntroduction();
        }
    }
    
    private void showFinalCertificate() {
        String message = "🎉 Congratulations! 🎉\n\n" +
            "You have successfully completed all levels of the\n" +
            "Boolean Logic Quiz!\n\n" +
            "You've mastered:\n" +
            "✓ Easy - Basic concepts\n" +
            "✓ Medium - Code analysis\n" +
            "✓ Hard - Error detection\n\n" +
            "Great work!";
        
        JOptionPane.showMessageDialog(
            this,
            message,
            "Quiz Complete!",
            JOptionPane.INFORMATION_MESSAGE
        );
        
        parentApp.showIntroduction();
    }
    
    private JButton createStyledButton(String text, Color bgColor) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 15));
        button.setForeground(Color.WHITE);
        button.setBackground(bgColor);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setOpaque(true);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (button.isEnabled()) {
                    button.setBackground(bgColor.darker());
                }
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(bgColor);
            }
        });
        
        return button;
    }
}
