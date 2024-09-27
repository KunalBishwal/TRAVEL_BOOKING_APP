package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class About extends JFrame implements ActionListener {

    JButton exitButton;
    JLabel titleLabel;
    TextArea infoTextArea;
    String projectInfo;

    public About() {
        // Set up the frame layout and properties
        setLayout(null);
        getContentPane().setBackground(new Color(60, 63, 65));  // Set background color

        // Title label
        titleLabel = new JLabel("About Project");
        titleLabel.setBounds(130, 10, 300, 50);
        titleLabel.setForeground(new Color(255, 69, 0)); // Set color for title
        titleLabel.setFont(new Font("Serif", Font.BOLD, 30));  // Font styling
        add(titleLabel);

        // Project Information
        projectInfo = "The objective of the Travel and Tourism Management System "
                + "project is to develop a system that automates the processes "
                + "and activities related to travel management.\n\n"
                + "This application helps users access information about "
                + "their travel destinations, book tours with ease, and "
                + "manage all travel-related operations seamlessly.\n\n"
                + "Advantages of the Project:\n"
                + "• Provides accurate and real-time information\n"
                + "• Reduces manual work and paperwork\n"
                + "• Streamlined booking process\n"
                + "• Sends booking confirmations and notifications\n"
                + "• Ensures a user-friendly environment with helpful prompts";

        // TextArea for displaying the project info
        infoTextArea = new TextArea(projectInfo, 10, 40, Scrollbar.VERTICAL);
        infoTextArea.setEditable(false);
        infoTextArea.setBounds(30, 80, 440, 300);
        infoTextArea.setFont(new Font("SansSerif", Font.PLAIN, 16));
        infoTextArea.setBackground(new Color(230, 230, 250));  // Light lavender background
        infoTextArea.setForeground(Color.BLACK);  // Text color
        add(infoTextArea);

        // Exit Button with rounded borders and styling
        exitButton = new JButton("Exit");
        exitButton.setBounds(180, 400, 120, 40);
        exitButton.setForeground(Color.WHITE);
        exitButton.setBackground(new Color(255, 69, 0));  // Orange button color
        exitButton.setFont(new Font("Arial", Font.BOLD, 18));
        exitButton.setBorder(new RoundedBorder(20));  // Rounded borders
        exitButton.addActionListener(this);
        add(exitButton);

        // Frame settings
        setBounds(600, 220, 500, 500);
        setTitle("About Travel Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Rounded border class for the button
    class RoundedBorder implements javax.swing.border.Border {
        private int radius;

        public RoundedBorder(int radius) {
            this.radius = radius;
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(radius, radius, radius, radius);
        }

        @Override
        public boolean isBorderOpaque() {
            return true;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.setColor(Color.WHITE);
            g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }
    }

    // Close the window when the button is clicked
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exitButton) {
            dispose();
        }
    }

    public static void main(String[] args) {
        new About();
    }
}
