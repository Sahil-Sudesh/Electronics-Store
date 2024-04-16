package Employees;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Splash extends JFrame {
    
    private JProgressBar progressBar;
    private Timer timer;
    private int progress;

    Splash() {
        getContentPane().setBackground(Color.WHITE);
        setUndecorated(true); // Remove window decorations (title bar, borders)
        setLayout(new BorderLayout());
        
        // Logo panel with rotating icon
        JPanel logoPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                // Rotate the logo
                g2d.rotate(Math.toRadians(progress), getWidth() / 2, getHeight() / 2);
                ImageIcon logoIcon = new ImageIcon(getClass().getResource("1280px-OOP.svg.png"));
                g2d.drawImage(logoIcon.getImage(), getWidth() / 4, getHeight() / 4, getWidth() / 2, getHeight() / 2, this);
                g2d.dispose();
            }
        };
        add(logoPanel, BorderLayout.CENTER);
        
        // Progress bar at the bottom
        progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        progressBar.setForeground(Color.BLUE);
        add(progressBar, BorderLayout.SOUTH);
        
        // Set up timer for animation
        timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                progress++;
                progressBar.setValue(progress);
                if (progress >= 100) {
                    timer.stop();
                    dispose(); // Close splash screen when progress reaches 100%
                    new Login(); // Open login screen
                }
                repaint(); // Update the rotating logo
            }
        });
        timer.start();
        
        setSize(400, 300);
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);
    }

    public static void main(String[] args) {
        new Splash();
    }
}
