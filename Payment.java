package travel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Payment extends JFrame {

    public Payment() {
        setLayout(null);
        setBounds(600, 220, 800, 600);  // Frame size

        // Change the label to indicate Google Pay
        JLabel label = new JLabel("Pay using Google Pay");
        label.setFont(new Font("Raleway", Font.BOLD, 36));  // Adjust font size
        label.setBounds(50, 20, 700, 50);  // Increase width and height to accommodate larger text
        add(label);

        // Change image to Google Pay image (make sure the image exists in your resources)
        ImageIcon i7 = new ImageIcon(getClass().getResource("/resources/googlepay.png"));  // Update image path
        Image i8 = i7.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);  // Resize image for better fit
        ImageIcon i9 = new ImageIcon(i8);
        JLabel l4 = new JLabel(i9);
        l4.setBounds(200, 120, 400, 300);  // Center the image
        add(l4);

        // Pay button action to open GooglePayIntegration class
        JButton pay = new JButton("Pay");
        pay.setFont(new Font("Arial", Font.PLAIN, 18));  // Set button font size
        pay.setBounds(320, 450, 100, 40);  // Position and size the button
        pay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new GooglePayIntegration().setVisible(true);  // Open GooglePayIntegration class
                setVisible(false);  // Close current window
            }
        });
        add(pay);

        JButton back = new JButton("Back");
        back.setFont(new Font("Arial", Font.PLAIN, 18));  // Set button font size
        back.setBounds(440, 450, 100, 40);  // Position and size the button
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);  // Close the window
            }
        });
        add(back);

        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Payment().setVisible(true);
    }
}
