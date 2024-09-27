package travel.management.system;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

public class GooglePayIntegration extends JFrame {

    public GooglePayIntegration() {
        // Button for paying with Google Pay
        JButton payWithGoogleButton = new JButton("Pay with Google Pay");

        payWithGoogleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openGooglePayPage();
            }
        });

        // Back button to go back to Payment class
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Payment().setVisible(true);  // Open the Payment window
                setVisible(false);  // Close the current window
            }
        });

        // Setting layout and adding buttons
        setLayout(null);
        payWithGoogleButton.setBounds(100, 100, 200, 50);
        backButton.setBounds(100, 200, 200, 50);  // Back button position
        add(payWithGoogleButton);
        add(backButton);

        // Frame properties
        setTitle("Google Pay Integration");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Method to open the Google Pay web page
    private void openGooglePayPage() {
        try {
            URI googlePayUri = new URI("USE YOUR OWN URL");
            java.awt.Desktop.getDesktop().browse(googlePayUri);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Unable to open Google Pay page.");
        }
    }

    public static void main(String[] args) {
        new GooglePayIntegration().setVisible(true);
    }
}
