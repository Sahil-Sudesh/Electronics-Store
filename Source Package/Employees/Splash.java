package Employees;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Splash extends JFrame {
    
    private JProgressBar progressBar;
    private Timer timer;
    private int progress;

    Splash() {
        getContentPane().setBackground(Color.GRAY);
        setUndecorated(true); // Remove window decorations (title bar, borders)
        setLayout(new BorderLayout());
        JLabel heading = new JLabel("    Employee Management System");
        heading.setBounds(60, 30, 1000, 60);
        heading.setFont(new Font("serif", Font.PLAIN, 50));
        heading.setForeground(Color.black);
        heading.setHorizontalAlignment(SwingConstants.LEFT);
        add(heading);
        
        // Logo panel with centered icon
        ImageIcon logoIcon = new ImageIcon(getClass().getResource("1280px-OOP.svg.png"));
        JLabel logoLabel = new JLabel(logoIcon);
        logoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(logoLabel, BorderLayout.CENTER);
        
        // Progress bar at the bottom
        progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        progressBar.setForeground(Color.BLUE);
        add(progressBar, BorderLayout.SOUTH);
        
        // Set up timer for progress animation
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
            }
        });
        timer.start();
        
        setSize(800, 400);
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);
    }
}

