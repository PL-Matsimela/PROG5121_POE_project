/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.assignmentchatapp;
import javax.swing.*;

/**
 *
 * @author RC_Student_lab
 */
public class AssignmentChatapp {

    public static void main(String[] args) {
        // Use the Event Dispatch Thread to initialize the Swing components
        SwingUtilities.invokeLater(() -> UserAuthApp.run());
    }

    public static class UserAuthApp {
        // In-memory variables to store registered user info
        private static String registeredUsername = null;
        private static String registeredPassword = null;
        private static String registeredCellphone = null;

        // Method to start the authentication process
        public static void run() {
            while (true) {
                String[] options = {"Register", "Login", "Exit"};
                int choice = JOptionPane.showOptionDialog(null, "Choose an option", "User Authentication",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

                switch (choice) {
                    case 0 -> register();
                    case 1 -> login();
                    case 2 -> {
                        JOptionPane.showMessageDialog(null, "Goodbye!");
                        System.exit(0);
                    }
                    default -> JOptionPane.showMessageDialog(null, "Invalid choice.");
                }
            }
        }

        // Method to register a new user
        private static void register() {
            String username;
            String password;
            String cellphone;

            // Username validation
            while (true) {
                username = JOptionPane.showInputDialog("Enter a username:");
                if (username == null) return; // Cancelled
                if (username.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Username cannot be empty.");
                } else {
                    break;
                }
            }

            // Password validation
            while (true) {
                password = JOptionPane.showInputDialog("Enter a password (at least 6 characters):");
                if (password == null) return; // Cancelled
                if (password.length() < 6) {
                    JOptionPane.showMessageDialog(null, "Password must be at least 6 characters.");
                } else {
                    break;
                }
            }

            // Cellphone validation
            while (true) {
                cellphone = JOptionPane.showInputDialog("Enter a cellphone number:");
                if (cellphone == null) return; // Cancelled
                if (cellphone.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Cellphone number cannot be empty.");
                } else {
                    break;
                }
            }

            // Save the user info
            registeredUsername = username;
            registeredPassword = password;
            registeredCellphone = cellphone;

            JOptionPane.showMessageDialog(null, "Registration successful!");
        }

        // Method to login the user
        private static void login() {
            String username;
            String password;

            // Username input
            username = JOptionPane.showInputDialog("Enter your username:");
            if (username == null) return; // Cancelled

            // Password input
            password = JOptionPane.showInputDialog("Enter your password:");
            if (password == null) return; // Cancelled

            // Validate login
            if (username.equals(registeredUsername) && password.equals(registeredPassword)) {
                JOptionPane.showMessageDialog(null, "Login successful!");
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password.");
            }
        }
    }
}
