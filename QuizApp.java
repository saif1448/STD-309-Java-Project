import javax.swing.*;
import java.awt.*;
import java.util.List;

public class QuizApp extends JFrame {
    
    private QuizState quizState;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    
    // Color scheme
    public static final Color PRIMARY_COLOR = new Color(74, 144, 226);      // Blue
    public static final Color SECONDARY_COLOR = new Color(80, 200, 120);    // Emerald
    public static final Color ACCENT_COLOR = new Color(255, 107, 107);      // Coral
    public static final Color BACKGROUND_COLOR = new Color(245, 247, 250);  // Light Gray
    public static final Color TEXT_COLOR = new Color(44, 62, 80);           // Dark Gray
    public static final Color WHITE = Color.WHITE;
    
    public QuizApp() {
        setTitle("Boolean Logic Learning System");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Initialize quiz state
        quizState = new QuizState();
        List<Question> allQuestions = QuestionLoader.loadQuestions("Questions.csv");
        quizState.loadQuestions(allQuestions);
        
        // Setup card layout for different screens
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        mainPanel.setBackground(BACKGROUND_COLOR);
        
        // Add panels
        mainPanel.add(new IntroductionPanel(this), "intro");
        mainPanel.add(new StudyGuidePanel(this), "study");
        
        QuizPanel quizPanel = new QuizPanel(this);
        mainPanel.add(quizPanel, "quiz");
        
        add(mainPanel);
        
        // Show introduction page
        cardLayout.show(mainPanel, "intro");
        
        setVisible(true);
    }
    
    private JPanel createPlaceholderPanel(String text) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(BACKGROUND_COLOR);
        
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 28));
        label.setForeground(TEXT_COLOR);
        
        panel.add(label, BorderLayout.CENTER);
        
        return panel;
    }
    
    public void showIntroduction() {
        cardLayout.show(mainPanel, "intro");
    }
    
    public void showStudyGuide() {
        cardLayout.show(mainPanel, "study");
    }
    
    public void showQuiz() {
        // Get the quiz panel and start it
        for (Component comp : mainPanel.getComponents()) {
            if (comp instanceof QuizPanel) {
                ((QuizPanel) comp).startQuiz();
                break;
            }
        }
        cardLayout.show(mainPanel, "quiz");
    }
    
    public QuizState getQuizState() {
        return quizState;
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new QuizApp());
    }
}
