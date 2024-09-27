package travel.management.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;
import java.awt.event.*;

public class ForgotPassword extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTextField t1, t2, t3, t4, t5;
    private JButton b1, b2, b3;

    public static void main(String[] args) {
        new ForgotPassword().setVisible(true);
    }

    public ForgotPassword() {
        // Set frame properties
        setBounds(500, 200, 900, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Gradient background using a custom JPanel
        contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gp = new GradientPaint(0, 0, Color.CYAN, getWidth(), getHeight(), Color.MAGENTA);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Labels
        JLabel l1 = new JLabel("Username");
        l1.setFont(new Font("Arial", Font.BOLD, 14));
        l1.setForeground(Color.WHITE);
        l1.setBounds(109, 83, 150, 29);
        contentPane.add(l1);

        JLabel l2 = new JLabel("Name");
        l2.setFont(new Font("Arial", Font.BOLD, 14));
        l2.setForeground(Color.WHITE);
        l2.setBounds(109, 122, 150, 21);
        contentPane.add(l2);

        JLabel l3 = new JLabel("Your Security Question");
        l3.setFont(new Font("Arial", Font.BOLD, 14));
        l3.setForeground(Color.WHITE);
        l3.setBounds(109, 154, 180, 27);
        contentPane.add(l3);

        JLabel l4 = new JLabel("Answer");
        l4.setFont(new Font("Arial", Font.BOLD, 14));
        l4.setForeground(Color.WHITE);
        l4.setBounds(109, 192, 150, 21);
        contentPane.add(l4);

        JLabel l5 = new JLabel("Password");
        l5.setFont(new Font("Arial", Font.BOLD, 14));
        l5.setForeground(Color.WHITE);
        l5.setBounds(109, 224, 150, 21);
        contentPane.add(l5);

        // Text fields
        t1 = new JTextField();
        t1.setBounds(280, 83, 160, 25);
        contentPane.add(t1);

        t2 = new JTextField();
        t2.setEditable(false);
        t2.setBounds(280, 122, 160, 25);
        contentPane.add(t2);

        t3 = new JTextField();
        t3.setEditable(false);
        t3.setBounds(280, 154, 200, 25);
        contentPane.add(t3);

        t4 = new JTextField();
        t4.setBounds(280, 192, 160, 25);
        contentPane.add(t4);

        t5 = new JTextField();
        t5.setEditable(false);
        t5.setBounds(280, 224, 160, 25);
        contentPane.add(t5);

        // Image with more space
        ImageIcon c1 = new ImageIcon(getClass().getResource("/resources/forgotpassword.jpg"));
        Image i1 = c1.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH); // Increased size
        ImageIcon i2 = new ImageIcon(i1);
        JLabel l6 = new JLabel(i2);
        l6.setBounds(550, 70, 250, 250); // Adjusted position to avoid overlap
        contentPane.add(l6);

        // Buttons with rounded edges
        b1 = createCustomButton("Search", 450, 83);
        b2 = createCustomButton("Recover", 450, 192);
        b3 = createCustomButton("Back", 230, 270);

        contentPane.add(b1);
        contentPane.add(b2);
        contentPane.add(b3);

        // Panel with rounded edges and border
        JPanel panel = new JPanel();
        panel.setBounds(50, 50, 500, 300); // Increased size to accommodate larger image
        panel.setBackground(new Color(0, 0, 0, 50));
        panel.setOpaque(false);
        panel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true)); // Rounded border
        contentPane.add(panel);
    }

    // Helper function to create buttons with rounded edges
    private JButton createCustomButton(String text, int x, int y) {
        JButton button = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
                super.paintComponent(g);
            }
        };
        button.setBounds(x, y, 120, 30);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setBackground(Color.BLACK);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorder(BorderFactory.createEmptyBorder());
        button.addActionListener(this);
        return button;
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            Conn con = new Conn();
            if (ae.getSource() == b1) {
                String sql = "select * from account where username=?";
                PreparedStatement st = con.c.prepareStatement(sql);
                st.setString(1, t1.getText());
                ResultSet rs = st.executeQuery();

                while (rs.next()) {
                    t2.setText(rs.getString("name"));
                    t3.setText(rs.getString("question"));
                }
            }
            if (ae.getSource() == b2) {
                String sql = "select * from account where answer=?";
                PreparedStatement st = con.c.prepareStatement(sql);
                st.setString(1, t4.getText());
                ResultSet rs = st.executeQuery();

                while (rs.next()) {
                    t5.setText(rs.getString("password"));
                }
            }
            if (ae.getSource() == b3) {
                this.setVisible(false);
                new Login().setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
