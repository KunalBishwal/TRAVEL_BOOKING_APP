package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Signup extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JButton b1, b2;
    private JComboBox comboBox;


    public static void main(String[] args) {
        new Signup().setVisible(true);
    }

    public Signup() {
        setBounds(600, 250, 700, 406);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set modern font globally
        UIManager.put("Label.font", new Font("SansSerif", Font.PLAIN, 14));
        UIManager.put("Button.font", new Font("SansSerif", Font.PLAIN, 14));

        contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Gradient background (top to bottom)
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                GradientPaint gp = new GradientPaint(0, 0, Color.CYAN, 0, getHeight(), new Color(70, 130, 180));
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Rounded border for modern feel
        contentPane.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180), 2, true));

        JLabel lblUsername = new JLabel("Username :");
        lblUsername.setForeground(Color.DARK_GRAY);
        lblUsername.setFont(new Font("Arial", Font.BOLD, 14));
        lblUsername.setBounds(99, 86, 92, 26);
        contentPane.add(lblUsername);

        JLabel lblName = new JLabel("Name :");
        lblName.setForeground(Color.DARK_GRAY);
        lblName.setFont(new Font("Arial", Font.BOLD, 14));
        lblName.setBounds(99, 123, 92, 26);
        contentPane.add(lblName);

        JLabel lblPassword = new JLabel("Password :");
        lblPassword.setForeground(Color.DARK_GRAY);
        lblPassword.setFont(new Font("Arial", Font.BOLD, 14));
        lblPassword.setBounds(99, 160, 92, 26);
        contentPane.add(lblPassword);

        JLabel lblAnswer = new JLabel("Answer :");
        lblAnswer.setForeground(Color.DARK_GRAY);
        lblAnswer.setFont(new Font("Arial", Font.BOLD, 14));
        lblAnswer.setBounds(99, 234, 92, 26);
        contentPane.add(lblAnswer);

        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] { "Your NickName?", "Your Lucky Number?",
                "Your child SuperHero?", "Your childhood Name ?" }));
        comboBox.setBounds(265, 202, 148, 20);
        contentPane.add(comboBox);

        JLabel lblSecurityQuestion = new JLabel("Security Question :");
        lblSecurityQuestion.setForeground(Color.DARK_GRAY);
        lblSecurityQuestion.setFont(new Font("Arial", Font.BOLD, 14));
        lblSecurityQuestion.setBounds(99, 197, 140, 26);
        contentPane.add(lblSecurityQuestion);

        ImageIcon c1 = new ImageIcon(getClass().getResource("/resources/signup.png"));

        Image i1 = c1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);

        JLabel l6 = new JLabel(i2);
        l6.setBounds(460, 70, 200, 200);
        contentPane.add(l6);

        textField = new JTextField();
        textField.setBounds(265, 91, 148, 20);
        textField.setBorder(BorderFactory.createLineBorder(new Color(176, 224, 230), 2, true)); // Rounded border
        contentPane.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(265, 128, 148, 20);
        textField_1.setBorder(BorderFactory.createLineBorder(new Color(176, 224, 230), 2, true)); // Rounded border
        contentPane.add(textField_1);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(265, 165, 148, 20);
        textField_2.setBorder(BorderFactory.createLineBorder(new Color(176, 224, 230), 2, true)); // Rounded border
        contentPane.add(textField_2);

        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(265, 239, 148, 20);
        textField_3.setBorder(BorderFactory.createLineBorder(new Color(176, 224, 230), 2, true)); // Rounded border
        contentPane.add(textField_3);

        b1 = new JButton("Create");
        b1.addActionListener(this);
        b1.setFont(new Font("Arial", Font.BOLD, 13));
        b1.setBounds(140, 289, 100, 30);
        b1.setBackground(new Color(46, 139, 87));
        b1.setForeground(Color.WHITE);
        b1.setBorder(BorderFactory.createLineBorder(new Color(46, 139, 87), 2, true));
        b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        contentPane.add(b1);

        b2 = new JButton("Back");
        b2.addActionListener(this);
        b2.setFont(new Font("Arial", Font.BOLD, 13));
        b2.setBounds(300, 289, 100, 30);
        b2.setBackground(new Color(205, 92, 92));
        b2.setForeground(Color.WHITE);
        b2.setBorder(BorderFactory.createLineBorder(new Color(205, 92, 92), 2, true));
        b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        contentPane.add(b2);

        JPanel panel = new JPanel();
        panel.setForeground(new Color(34, 139, 34));
        panel.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 0), 2), "Create-Account",
                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(34, 139, 34)));
        panel.setBounds(31, 30, 640, 310);
        panel.setOpaque(false); // Transparent background to see gradient
        contentPane.add(panel);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            Conn con = new Conn();

            if (ae.getSource() == b1) {
                String sql = "insert into account(username, name, password, question, answer) values(?, ?, ?, ?, ?)";

                PreparedStatement st = con.c.prepareStatement(sql);

                st.setString(1, textField.getText());
                st.setString(2, textField_1.getText());
                st.setString(3, textField_2.getText());
                st.setString(4, (String) comboBox.getSelectedItem());
                st.setString(5, textField_3.getText());

                int i = st.executeUpdate();
                if (i > 0) {
                    JOptionPane.showMessageDialog(null, "Account Created Successfully ");
                }

                textField.setText("");
                textField_1.setText("");
                textField_2.setText("");
                textField_3.setText("");
            }
            if (ae.getSource() == b2) {
                this.setVisible(false);
                new Login().setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
