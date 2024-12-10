package LibrarySystem;

import javax.swing.*;

import LibrarySystem.Business.UserFactory;
import LibrarySystem.Model.Data;
import LibrarySystem.Model.User;
import LibrarySystem.Model.Util;

import java.awt.*;
import java.util.HashMap;
import java.util.List;

public class LibraryApp {

    private static JFrame frame;
    private static JPanel loginPanel;
    private static JTextField usernameField;
    private static JPasswordField passwordField;
    private static JComboBox<String> roleComboBox;
    private static HashMap<String, String> userRoles = new HashMap<>(); // St

    public static void main(String[] args) {
        userRoles.put("librarian", "Librarian");
        userRoles.put("admin", "Admin");
        userRoles.put("adminlibrarian", "Admin,Librarian");
        UserFactory.createTestUsers();
        SwingUtilities.invokeLater(LibraryApp::createAndShowLogin);
    }

    // Create and display the login page
    private static void createAndShowLogin() {
        frame = new JFrame("Library Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600); // Increased the size to accommodate the image
        frame.setLocationRelativeTo(null); // Center the window

        // Login Panel
        loginPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Username
        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 1;
        loginPanel.add(usernameLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        loginPanel.add(usernameField, gbc);

        // Password
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);
        gbc.gridx = 0;
        gbc.gridy = 2;
        loginPanel.add(passwordLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        loginPanel.add(passwordField, gbc);

        // Login button
        JButton loginButton = new JButton("Login");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        loginPanel.add(loginButton, gbc);

        // ActionListener for login button
        addLoginButtonListener(loginButton);

        frame.getContentPane().add(loginPanel);
        frame.setVisible(true);
    }

    private static void addLoginButtonListener(JButton butn) {
        butn.addActionListener(evt -> {
            String user = usernameField.getText().trim();
            String pwd = new String(passwordField.getPassword()).trim();

            if (user.isEmpty() || pwd.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Username and password cannot be empty", "Login Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                User loggedInUser = UserFactory.login(user, pwd);
                if (loggedInUser != null) {
                    Data.currentAuth = loggedInUser.authorization;
                    Dashboard.createAdminDashboard(Data.currentAuth.toString());
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid credentials. Please try again.", "Login Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(frame, "Login error: " + e.getMessage(), "Login Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
