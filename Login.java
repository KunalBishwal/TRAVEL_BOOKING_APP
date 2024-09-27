package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    private JPanel panel;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton b1, b2, b3;

    public Login() {
        setTitle("Login");
        setBounds(450, 200, 750, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set custom background color (gradient)
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                int width = getWidth();
                int height = getHeight();
                // Gradient from light blue to dark blue
                Color color1 = new Color(176, 224, 230);
                Color color2 = new Color(70, 130, 180);
                GradientPaint gp = new GradientPaint(0, 0, color1, 0, height, color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, width, height);
            }
        };
        panel.setLayout(null);
        setContentPane(panel);

        // Username label
        JLabel l1 = new JLabel("Username:");
        l1.setBounds(150, 100, 100, 30);
        l1.setFont(new Font("Arial", Font.BOLD, 16));
        l1.setForeground(Color.WHITE); // Make text white to contrast with the background
        panel.add(l1);

        // Password label
        JLabel l2 = new JLabel("Password:");
        l2.setBounds(150, 150, 100, 30);
        l2.setFont(new Font("Arial", Font.BOLD, 16));
        l2.setForeground(Color.WHITE);
        panel.add(l2);

        // Text field for username
        textField = new JTextField();
        textField.setBounds(260, 100, 180, 30);
        textField.setFont(new Font("Arial", Font.PLAIN, 14));
        textField.setBorder(BorderFactory.createLineBorder(new Color(176, 224, 230), 2, true)); // Rounded border
        panel.add(textField);

        // Password field
        passwordField = new JPasswordField();
        passwordField.setBounds(260, 150, 180, 30);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 14));
        passwordField.setBorder(BorderFactory.createLineBorder(new Color(176, 224, 230), 2, true)); // Rounded border
        panel.add(passwordField);

        // Login button with rounded edges
        b1 = new JButton("Login");
        b1.setFont(new Font("Arial", Font.BOLD, 14));
        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(46, 139, 87));
        b1.setBounds(200, 220, 120, 40);
        b1.setFocusPainted(false);
        b1.setBorder(BorderFactory.createLineBorder(new Color(46, 139, 87), 2, true));
        b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b1.addActionListener(this);
        panel.add(b1);

        // SignUp button with rounded edges
        b2 = new JButton("SignUp");
        b2.setFont(new Font("Arial", Font.BOLD, 14));
        b2.setForeground(Color.WHITE);
        b2.setBackground(new Color(139, 69, 19));
        b2.setBounds(340, 220, 120, 40);
        b2.setFocusPainted(false);
        b2.setBorder(BorderFactory.createLineBorder(new Color(139, 69, 19), 2, true));
        b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b2.addActionListener(this);
        panel.add(b2);

        // Forgot Password button with rounded edges
        b3 = new JButton("Forgot Password");
        b3.setFont(new Font("Arial", Font.BOLD, 12));
        b3.setForeground(Color.WHITE);
        b3.setBackground(new Color(205, 92, 92));
        b3.setBounds(250, 280, 180, 40);
        b3.setFocusPainted(false);
        b3.setBorder(BorderFactory.createLineBorder(new Color(205, 92, 92), 2, true));
        b3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b3.addActionListener(this);
        panel.add(b3);

        // Adding image to the panel
        ImageIcon c1 = new ImageIcon(getClass().getResource("/resources/login.png"));
        Image i1 = c1.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel l6 = new JLabel(i2);
        l6.setBounds(480, 100, 150, 150);
        panel.add(l6);

        // Optional: Set a sleek font for the entire application
        UIManager.put("Label.font", new Font("Arial", Font.PLAIN, 14));
        UIManager.put("Button.font", new Font("Arial", Font.PLAIN, 14));
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            Boolean status = false;
            try {
                Conn con = new Conn();
                String sql = "select * from account where username=? and password=?";
                PreparedStatement st = con.c.prepareStatement(sql);

                st.setString(1, textField.getText());
                st.setString(2, passwordField.getText());

                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    this.setVisible(false);
                    new Loading(textField.getText()).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Login or Password!");
                }

            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        if (ae.getSource() == b2) {
            setVisible(false);
            Signup su = new Signup();
            su.setVisible(true);
        }

        if (ae.getSource() == b3) {
            setVisible(false);
            ForgotPassword forgot = new ForgotPassword();
            forgot.setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Login().setVisible(true);
    }
}
