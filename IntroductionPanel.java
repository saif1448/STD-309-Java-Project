import javax.swing.*;
import java.awt.*;

public class IntroductionPanel extends JPanel {
    
    private QuizApp parentApp;
    
    public IntroductionPanel(QuizApp app) {
        this.parentApp = app;
        setLayout(new GridBagLayout());
        setBackground(QuizApp.BACKGROUND_COLOR);
        
        // Main content panel - centered
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(QuizApp.BACKGROUND_COLOR);
        contentPanel.setMaximumSize(new Dimension(700, 600));
        
        // Title Section
        JPanel titlePanel = createTitlePanel();
        
        // Welcome Message Section
        JPanel messagePanel = createMessagePanel();
        
        // Button Section
        JPanel buttonPanel = createButtonPanel();
        
        // Add vertical spacing
        contentPanel.add(Box.createVerticalStrut(20));
        contentPanel.add(titlePanel);
        contentPanel.add(Box.createVerticalStrut(20));
        contentPanel.add(messagePanel);
        contentPanel.add(Box.createVerticalStrut(25));
        contentPanel.add(buttonPanel);
        contentPanel.add(Box.createVerticalStrut(20));
        
        // Center the content panel
        add(contentPanel);
    }
    
    private JPanel createTitlePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(QuizApp.BACKGROUND_COLOR);
        
        // Main Title
        JLabel titleLabel = new JLabel("Introduction to Boolean Logic");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
        titleLabel.setForeground(QuizApp.PRIMARY_COLOR);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        // Subtitle
        JLabel subtitleLabel = new JLabel("Master the Fundamentals of Programming Logic");
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        subtitleLabel.setForeground(QuizApp.TEXT_COLOR);
        subtitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(8));
        panel.add(subtitleLabel);
        
        return panel;
    }
    
    private JPanel createMessagePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(QuizApp.WHITE);
        panel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(220, 220, 220), 1),
            BorderFactory.createEmptyBorder(20, 30, 20, 30)
        ));
        
        // Welcome text - more concise
        String[] messages = {
            "Welcome to the Boolean Logic Learning System!",
            "",
            "Boolean logic is the foundation of computer programming.",
            "In this interactive course, you will:",
            "",
            "  • Learn about Boolean values (True and False)",
            "  • Understand comparison operators (==, !=, <, >, <=, >=)",
            "  • Master logical operators (and, or, not)",
            "  • Practice with real-world coding examples",
            "",
            "The quiz has three difficulty levels:",
            "  • Easy - Basic concepts (15 questions)",
            "  • Medium - Code analysis (10 questions)",
            "  • Hard - Error detection (5 questions)",
            "",
            "Score 75% or higher to advance. You can retry wrong answers!"
        };
        
        for (String message : messages) {
            JLabel label = new JLabel(message);
            if (message.isEmpty()) {
                label.setText(" ");
            }
            
            if (message.startsWith("  •")) {
                label.setFont(new Font("Arial", Font.PLAIN, 13));
                label.setForeground(QuizApp.TEXT_COLOR);
            } else if (message.contains("Easy") || message.contains("Medium") || message.contains("Hard")) {
                label.setFont(new Font("Arial", Font.BOLD, 13));
                label.setForeground(QuizApp.TEXT_COLOR);
            } else {
                label.setFont(new Font("Arial", Font.PLAIN, 14));
                label.setForeground(QuizApp.TEXT_COLOR);
            }
            
            label.setAlignmentX(Component.LEFT_ALIGNMENT);
            panel.add(label);
            panel.add(Box.createVerticalStrut(3));
        }
        
        return panel;
    }
    
    private JPanel createButtonPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        panel.setBackground(QuizApp.BACKGROUND_COLOR);
        
        // Start Learning Button
        JButton startButton = createStyledButton("Start Learning", QuizApp.SECONDARY_COLOR);
        startButton.setPreferredSize(new Dimension(200, 50));
        startButton.addActionListener(e -> parentApp.showStudyGuide());
        
        panel.add(startButton);
        
        return panel;
    }
    
    private JButton createStyledButton(String text, Color bgColor) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 16));
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
