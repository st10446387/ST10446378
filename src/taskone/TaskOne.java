/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package taskone;

/**
 *
 * @author kevin
 */
import javax.swing.*;

import java.util.HashMap;
import java.util.Map;

public class TaskOne {
private static Map<String, String> registeredUsers = new HashMap<>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
  
      
        boolean loggedIn = false;

        while (true) {
            String[] options = {"Register", "Login", "Exit"};
            int choice = JOptionPane.showOptionDialog(null,
                    "Choose an option:",
                    "Welcome",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    options,
                    options[0]);

            if (choice == JOptionPane.CLOSED_OPTION || choice == 2) {
                break; // User clicked Cancel or closed the dialog
            }

            if (choice == 0) {
                JTextField usernameField = new JTextField();
                JPasswordField passwordField = new JPasswordField();

                Object[] message = {
                        "Username:", usernameField,
                        "Password:", passwordField
                };

                int option = JOptionPane.showConfirmDialog(null, message, "Register", JOptionPane.OK_CANCEL_OPTION);

                if (option == JOptionPane.OK_OPTION) {
                    String username = usernameField.getText();
                    String password = new String(passwordField.getPassword());

                    if (isValidUsername(username) && validatePassword(password)) {
                        registeredUsers.put(username, password);
                        JOptionPane.showMessageDialog(null, "Registration successful!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Username or password is invalid format. Please make sure:\n- Username is not longer than 5 characters and contains an underscore.\n- Password has at least 8 characters, a number, a capital letter, and a special character.");
                    }
                }
            } else if (choice == 1) {
                JTextField usernameField = new JTextField();
                JPasswordField passwordField = new JPasswordField();

                Object[] message = {
                        "Username:", usernameField,
                        "Password:", passwordField
                };

                int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);

                if (option == JOptionPane.OK_OPTION) {
                    String username = usernameField.getText();
                    String password = new String(passwordField.getPassword());

                    if (registeredUsers.containsKey(username) && registeredUsers.get(username).equals(password)) {
                        JOptionPane.showMessageDialog(null, "Login successful!");
                        loggedIn = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid username or password!");
                    }
                }
            }

            if (loggedIn) {
                break;
            }
        }
    }

    private static boolean isValidUsername(String username) {
        return username.length() <= 5 && username.contains("_");
    }

    private static boolean validatePassword(String password) {
        return password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*\\d.*") && password.matches(".*[!@#$%^&*()].*");
    }
    }
    

