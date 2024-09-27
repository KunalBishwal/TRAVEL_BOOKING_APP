package travel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.image.BufferedImage;

public class Splash {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SplashFrame splashFrame = new SplashFrame();
            splashFrame.setVisible(true);
        });
    }
}

class SplashFrame extends JFrame {
    private static final int INITIAL_WIDTH = 300;
    private static final int INITIAL_HEIGHT = 225;
    private static final int FINAL_WIDTH = 1030;
    private static final int FINAL_HEIGHT = 750;
    private static final int ANIMATION_DURATION = 2000; // Reduced to 2 seconds for faster animation
    private static final int TIMER_DELAY = 15; // Timer delay in milliseconds
    private static final int PAUSE_DURATION = 1000; // Duration of pause in milliseconds

    private BufferedImage image;
    private JLabel imageLabel;
    private JLabel welcomeText;
    private Timer timer;
    private Timer pauseTimer;

    SplashFrame() {
        // Initialize frame properties
        setLayout(null);
        setUndecorated(true);
        setSize(INITIAL_WIDTH, INITIAL_HEIGHT);
        setLocationRelativeTo(null);

        // Load the image and prepare the BufferedImage for smoother rendering
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/resources/splash.jpg"));
        image = new BufferedImage(FINAL_WIDTH, FINAL_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        g2d.drawImage(imageIcon.getImage(), 0, 0, FINAL_WIDTH, FINAL_HEIGHT, null);
        g2d.dispose();

        // Create a label for the image
        imageLabel = new JLabel(new ImageIcon(image));
        imageLabel.setBounds(0, 0, INITIAL_WIDTH, INITIAL_HEIGHT);
        add(imageLabel);

        // Add welcome text
        welcomeText = new JLabel("WELCOME TO THE APP", SwingConstants.CENTER);
        welcomeText.setFont(new Font("Arial", Font.BOLD, 36));
        welcomeText.setForeground(Color.WHITE);
        welcomeText.setBounds(0, INITIAL_HEIGHT - 80, INITIAL_WIDTH, 50);
        add(welcomeText);

        // Set up the timer for animation
        timer = new Timer(TIMER_DELAY, new ActionListener() {
            private int step = 0;
            private final int totalSteps = ANIMATION_DURATION / TIMER_DELAY;

            @Override
            public void actionPerformed(ActionEvent e) {
                step++;
                if (step > totalSteps) {
                    timer.stop();
                    // Start the pause timer after animation ends
                    pauseTimer.start();
                } else {
                    double progress = (double) step / totalSteps;
                    int newWidth = (int) (INITIAL_WIDTH + progress * (FINAL_WIDTH - INITIAL_WIDTH));
                    int newHeight = (int) (INITIAL_HEIGHT + progress * (FINAL_HEIGHT - INITIAL_HEIGHT));

                    // Update size and position
                    setSize(newWidth, newHeight);
                    setLocationRelativeTo(null);

                    imageLabel.setBounds(0, 0, newWidth, newHeight);
                    welcomeText.setBounds(0, newHeight - 80, newWidth, 50);

                    // Update welcome text based on progress
                    welcomeText.setText("Loading... " + (int)(progress * 100) + "%");
                    welcomeText.repaint();  // Redraw the welcomeText label to reflect the new text
                    revalidate();           // Refresh the frame to ensure layout changes are reflected
                }
            }
        });

        // Set up the timer for pause
        pauseTimer = new Timer(PAUSE_DURATION, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pauseTimer.stop();
                setVisible(false);
                new Login().setVisible(true);
            }
        });

        timer.start();
    }
}
