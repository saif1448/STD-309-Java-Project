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
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(QuizApp.WHITE);
        
        // Create scrollable content
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(QuizApp.WHITE);
        contentPanel.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));
        
        // Add all study guide sections
        addSection(contentPanel, "What is a Boolean?", createWhatIsBooleanContent());
        addSection(contentPanel, "Purpose of Booleans", createPurposeContent());
        addSection(contentPanel, "Comparison Operators", createComparisonOperatorsContent());
        addSection(contentPanel, "Assignment Operators", createAssignmentOperatorsContent());
        addSection(contentPanel, "Boolean Operators", createBooleanOperatorsContent());
        addSection(contentPanel, "If/Else Statements", createIfElseContent());
        addSection(contentPanel, "Nested If/Else", createNestedIfElseContent());
        addSection(contentPanel, "Key Points to Remember", createKeyPointsContent());
        
        // Wrap in scroll pane
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.setPreferredSize(new Dimension(800, 500));
        
        panel.add(scrollPane, BorderLayout.CENTER);
        return panel;
    }
    
    private void addSection(JPanel parent, String title, JPanel content) {
        // Section title
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(QuizApp.PRIMARY_COLOR);
        titleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));
        
        parent.add(titleLabel);
        parent.add(content);
        
        // Add separator line
        JSeparator separator = new JSeparator();
        separator.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1));
        separator.setForeground(new Color(220, 220, 220));
        parent.add(Box.createVerticalStrut(15));
        parent.add(separator);
        parent.add(Box.createVerticalStrut(10));
    }
    
    private JPanel createWhatIsBooleanContent() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(QuizApp.WHITE);
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        String[] content = {
            "• A boolean is a data type in Python and most programming languages.",
            "• It can only hold two possible values: True or False",
            "• There is no value in between. Just true or false.",
            "",
            "Think of booleans like a yes or no question:",
            "• \"Is the light on?\" → Yes = True, No = False",
            "• \"Is it raining?\" → Yes = True, No = False"
        };
        
        for (String text : content) {
            addContentLine(panel, text, false);
        }
        
        // Add code example
        addCodeExample(panel, 
            "Code Example:",
            "is_raining = True\nis_sunny = False",
            "Explanation: is_raining = True means it is raining\nis_sunny = False means it is not sunny"
        );
        
        return panel;
    }
    
    private JPanel createPurposeContent() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(QuizApp.WHITE);
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        addContentLine(panel, "Booleans are used to make decisions in programs - like whether a student", false);
        addContentLine(panel, "passes or fails, to answer yes/no questions, or to check if a condition is met.", false);
        addContentLine(panel, "", false);
        
        addCodeExample(panel,
            "Example:",
            "score = 85\npassed = score >= 75\nprint(passed)",
            "Output: True\n85 is greater than or equal to 75, so the expression evaluates to True."
        );
        
        return panel;
    }
    
    private JPanel createComparisonOperatorsContent() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(QuizApp.WHITE);
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        addContentLine(panel, "Comparison operators compare values and return a Boolean (True or False)", false);
        addContentLine(panel, "", false);
        
        String[] operators = {
            "==    equal to                    2 == 2 → True",
            "!=    not equal                   2 != 1 → True", 
            ">     greater than               10 > 7 → True",
            "<     less than                   2 < 1 → False",
            ">=    greater than or equal to    5 >= 5 → True",
            "<=    less than or equal to       4 <= 4 → True"
        };
        
        for (String op : operators) {
            addContentLine(panel, op, true);
        }
        
        return panel;
    }
    
    private JPanel createAssignmentOperatorsContent() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(QuizApp.WHITE);
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        addContentLine(panel, "Assignment operators assign or give a value to a variable", false);
        addContentLine(panel, "", false);
        
        String[] operators = {
            "=     assign a value              x = 5",
            "+=    add and assign              x += 3  (means x = x + 3)",
            "-=    subtract and assign         x -= 3  (means x = x - 3)",
            "*=    multiply and assign         x *= 2  (means x = x * 2)",
            "/=    divide and assign           x /= 2  (means x = x / 2)"
        };
        
        for (String op : operators) {
            addContentLine(panel, op, true);
        }
        
        return panel;
    }
    
    private JPanel createBooleanOperatorsContent() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(QuizApp.WHITE);
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        addContentLine(panel, "Boolean operators combine conditions or modify True/False values", false);
        addContentLine(panel, "", false);
        
        addContentLine(panel, "and - Both conditions must be true:", false);
        addContentLine(panel, "    True and True → True", true);
        addContentLine(panel, "    True and False → False", true);
        addContentLine(panel, "", false);
        
        addContentLine(panel, "or - At least one condition must be true:", false);
        addContentLine(panel, "    True or False → True", true);
        addContentLine(panel, "    False or False → False", true);
        addContentLine(panel, "", false);
        
        addContentLine(panel, "not - Reverses the value:", false);
        addContentLine(panel, "    not True → False", true);
        addContentLine(panel, "    not False → True", true);
        
        addCodeExample(panel,
            "Example:",
            "age = 15\nhas_ticket = True\ncan_enter = age >= 13 and has_ticket\nprint(can_enter)",
            "Output: True\nBoth conditions are True, so 'and' makes the whole expression True."
        );
        
        return panel;
    }
    
    private JPanel createIfElseContent() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(QuizApp.WHITE);
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        addCodeExample(panel,
            "Example 1 - Light Check:",
            "light_on = False\nif not light_on:\n    print(\"The room is dark.\")\nelse:\n    print(\"The light is on.\")",
            "Output: The room is dark.\nSince light_on is False, 'not light_on' becomes True."
        );
        
        addCodeExample(panel,
            "Example 2 - Grade Check:",
            "score = 78\nif score >= 75:\n    print(\"You passed!\")\nelse:\n    print(\"Try again next time.\")",
            "Output: You passed!\n78 ≥ 75 is True, so the first block runs."
        );
        
        addContentLine(panel, "💡 Tip: Always end if/else lines with a colon (:) and indent the next line!", false);
        
        return panel;
    }
    
    private JPanel createNestedIfElseContent() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(QuizApp.WHITE);
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        addContentLine(panel, "Nested if means one if statement inside another.", false);
        addContentLine(panel, "", false);
        
        addCodeExample(panel,
            "Example - Game Power-Up:",
            "has_key = True\nhas_shield = True\nlevel = 5\n\nif has_key:\n    print(\"You unlocked the gate!\")\n    if has_shield and level >= 5:\n        print(\"Bonus unlocked: Super Armor!\")\n    else:\n        print(\"Keep going for shield bonus.\")",
            "Output:\nYou unlocked the gate!\nBonus unlocked: Super Armor!"
        );
        
        addContentLine(panel, "Key points:", false);
        addContentLine(panel, "• Python runs the inner if only if the outer one is True", false);
        addContentLine(panel, "• Indentation (spacing) shows which if belongs to which block", false);
        
        return panel;
    }
    
    private JPanel createKeyPointsContent() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(QuizApp.WHITE);
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        String[] points = {
            "• Booleans only have two values: True or False",
            "• They're often the result of comparisons like >, <, ==, or !=",
            "• Boolean operators (and, or, not) combine multiple conditions", 
            "• = means assign, while == means compare",
            "• Booleans are used in if, elif, and else to make decisions",
            "• Don't forget colons after if/elif/else statements!",
            "• Make sure to indent your code correctly"
        };
        
        for (String point : points) {
            addContentLine(panel, point, false);
        }
        
        return panel;
    }
    
    private void addContentLine(JPanel parent, String text, boolean isCode) {
        JLabel label = new JLabel(text);
        if (isCode) {
            label.setFont(new Font("Courier New", Font.PLAIN, 12));
            label.setForeground(new Color(0, 100, 0));
        } else {
            label.setFont(new Font("Arial", Font.PLAIN, 14));
            label.setForeground(QuizApp.TEXT_COLOR);
        }
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        parent.add(label);
        parent.add(Box.createVerticalStrut(3));
    }
    
    private void addCodeExample(JPanel parent, String title, String code, String explanation) {
        parent.add(Box.createVerticalStrut(10));
        
        // Title
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 14));
        titleLabel.setForeground(QuizApp.PRIMARY_COLOR);
        titleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        parent.add(titleLabel);
        parent.add(Box.createVerticalStrut(5));
        
        // Code block
        JPanel codePanel = new JPanel();
        codePanel.setLayout(new BoxLayout(codePanel, BoxLayout.Y_AXIS));
        codePanel.setBackground(new Color(248, 248, 248));
        codePanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
            BorderFactory.createEmptyBorder(10, 15, 10, 15)
        ));
        codePanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        String[] codeLines = code.split("\n");
        for (String line : codeLines) {
            JLabel codeLabel = new JLabel(line);
            codeLabel.setFont(new Font("Courier New", Font.PLAIN, 13));
            codeLabel.setForeground(new Color(0, 0, 150));
            codeLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            codePanel.add(codeLabel);
        }
        
        parent.add(codePanel);
        parent.add(Box.createVerticalStrut(8));
        
        // Explanation
        String[] explanationLines = explanation.split("\n");
        for (String line : explanationLines) {
            JLabel explLabel = new JLabel(line);
            explLabel.setFont(new Font("Arial", Font.ITALIC, 13));
            explLabel.setForeground(new Color(100, 100, 100));
            explLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            parent.add(explLabel);
        }
        
        parent.add(Box.createVerticalStrut(15));
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
