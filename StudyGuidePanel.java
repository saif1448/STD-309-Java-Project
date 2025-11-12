import javax.swing.*;
import java.awt.*;

public class StudyGuidePanel extends JPanel {
    
    private QuizApp parentApp;
    
    public StudyGuidePanel(QuizApp app) {
        this.parentApp = app;
        setLayout(new BorderLayout());
        setBackground(QuizApp.BACKGROUND_COLOR);
        
        // Header Panel
        JPanel headerPanel = createHeaderPanel();
        
        // Content Panel (placeholder for now - you'll add content later)
        JPanel contentPanel = createContentPanel();
        
        // Bottom Button Panel
        JPanel bottomPanel = createBottomPanel();
        
        add(headerPanel, BorderLayout.NORTH);
        add(contentPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }
    
    private JPanel createHeaderPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(QuizApp.PRIMARY_COLOR);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        
        JLabel titleLabel = new JLabel("Study Guide - Boolean Logic");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setForeground(Color.WHITE);
        
        panel.add(titleLabel, BorderLayout.WEST);
        
        return panel;
    }
    
    private JPanel createContentPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(QuizApp.WHITE);
        
        JLabel placeholderLabel = new JLabel("<html><div style='text-align: center;'>" +
                "<h2>Study Guide Content Will Be Added Here</h2>" +
                "<p style='margin-top: 20px; font-size: 14px;'>This section will contain detailed learning materials about Boolean Logic.</p>" +
                "</div></html>");
        placeholderLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        placeholderLabel.setForeground(QuizApp.TEXT_COLOR);
        
        panel.add(placeholderLabel);
        
        return panel;
    }
    
    private JPanel createBottomPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        panel.setBackground(QuizApp.BACKGROUND_COLOR);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        
        // Back Button
        JButton backButton = createStyledButton("← Back", QuizApp.TEXT_COLOR);
        backButton.setPreferredSize(new Dimension(150, 45));
        backButton.addActionListener(e -> parentApp.showIntroduction());
        
        // Start Quiz Button
        JButton startQuizButton = createStyledButton("Start Quiz →", QuizApp.SECONDARY_COLOR);
        startQuizButton.setPreferredSize(new Dimension(150, 45));
        startQuizButton.addActionListener(e -> parentApp.showQuiz());
        
        panel.add(backButton);
        panel.add(startQuizButton);
        
        return panel;
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
        
        // Hover effect
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(bgColor.darker());
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(bgColor);
            }
        });
        
        return button;
    }
}
