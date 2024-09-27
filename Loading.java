package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Loading extends JFrame implements Runnable {

    private JPanel contentPane;
    private JProgressBar progressBar;
    Connection conn;
    String username;
    int s;
    Thread th;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Loading("").setVisible(true));
    }

    public void setUploading() {
        setVisible(false);
        th.start();
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 200; i++) {
                s = s + 1;
                int m = progressBar.getMaximum();
                int v = progressBar.getValue();
                if (v < m) {
                    progressBar.setValue(progressBar.getValue() + 1);
                } else {
                    i = 201;
                    setVisible(false);
                    new Home(username).setVisible(true);
                }
                Thread.sleep(50);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Loading(String username) {
        this.username = username;
        th = new Thread(this);

        // Frame settings
        setBounds(600, 300, 600, 400);
        setUndecorated(true);
        setLayout(new BorderLayout());

        // Custom rounded panel
        contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundIcon = new ImageIcon(getClass().getResource("/resources/loading_background.jpg"));
                Image backgroundImage = backgroundIcon.getImage();
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        contentPane.setLayout(null);
        add(contentPane, BorderLayout.CENTER);

        // Create a rounded border for the panel
        contentPane.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255), 3, true)); // Rounded border

        // Title Label with rounded border and custom font
        JLabel titleLabel = new JLabel("Travel and Tourism Application");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Montserrat", Font.BOLD, 30));
        titleLabel.setBounds(50, 30, 500, 35);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Padding inside label
        contentPane.add(titleLabel);

        // Progress Bar with curved edges
        progressBar = new JProgressBar();
        progressBar.setFont(new Font("Roboto", Font.BOLD, 14));
        progressBar.setStringPainted(true);
        progressBar.setBounds(130, 150, 340, 30);
        progressBar.setBackground(new Color(255, 255, 255, 80)); // Translucent background
        progressBar.setForeground(new Color(72, 209, 204)); // Custom progress color

        // Use a rounded border for the progress bar
        progressBar.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true)); // Rounded border
        contentPane.add(progressBar);

        // Loading Label with rounded border
        JLabel loadingLabel = new JLabel("Please Wait...");
        loadingLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
        loadingLabel.setForeground(Color.WHITE);
        loadingLabel.setBounds(240, 200, 150, 30);
        loadingLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // Padding inside label
        contentPane.add(loadingLabel);

        // Panel to provide some margin from the edges
        JPanel marginPanel = new JPanel();
        marginPanel.setBounds(10, 10, 580, 380);
        marginPanel.setOpaque(false);
        contentPane.add(marginPanel);

        setUploading();
    }
}
