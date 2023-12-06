import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PasswordResetDialog extends JDialog {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/vendlify";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private String userEmail;
    private JPasswordField oldPasswordField;
    private JPasswordField newPasswordField;

    public PasswordResetDialog(JFrame parent, String userEmail) {
        super(parent, "Password Reset", true);
        this.userEmail = userEmail;
        initComponents();
    }

    private void initComponents() {
        // Set dialog properties
        setLayout(new BorderLayout());
        setSize(400, 200);
        setLocationRelativeTo(null);

        // Create components
        oldPasswordField = new JPasswordField();
        newPasswordField = new JPasswordField();
        JButton resetButton = new JButton("Reset");
        resetButton.setBackground(new Color(0, 128, 0)); // Green background
        resetButton.setForeground(Color.white);
        resetButton.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));

        // Create labels
        JLabel oldPasswordLabel = new JLabel("Old Password:");
        JLabel newPasswordLabel = new JLabel("New Password:");

        // Set layout
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.add(oldPasswordLabel);
        panel.add(oldPasswordField);
        panel.add(newPasswordLabel);
        panel.add(newPasswordField);
        panel.add(new JLabel()); // Placeholder
        panel.add(resetButton);

        // Add action listener to the reset button
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performPasswordReset();
            }
        });

        // Add the panel to the dialog
        add(panel, BorderLayout.CENTER);
    }
    
    private static String hashPassword(String password) {
        try {
            // Create a MessageDigest instance for SHA-256
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // Add password bytes to digest
            md.update(password.getBytes());

            // Get the hashed password bytes
            byte[] hashedBytes = md.digest();

            // Convert the byte array to a hexadecimal string
            StringBuilder stringBuilder = new StringBuilder();
            for (byte hashedByte : hashedBytes) {
                stringBuilder.append(Integer.toString((hashedByte & 0xff) + 0x100, 16).substring(1));
            }

            return stringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            // Handle the exception or rethrow it
            e.printStackTrace();
            return null;
        }
    }
    

    private void performPasswordReset() {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            char[] passwordChars1 = oldPasswordField.getPassword();
            String userPassword1 = new String(passwordChars1);
            char[] passwordChars2 = newPasswordField.getPassword();
            String userPassword2 = new String(passwordChars2);

            changePassword(connection, userEmail, userPassword1, userPassword2);

            // Close the database connection
            connection.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void changePassword(Connection connection, String email, String oldPassword, String newPassword) {
        try {
            // Check if the old password matches the one in the database for the given email
            if (isOldPasswordCorrect(connection, email, oldPassword)) {
                // Hash the new password
                String hashedNewPassword = hashPassword(newPassword);

                // Update the password in the database
                updatePassword(connection, email, hashedNewPassword);

                JOptionPane.showMessageDialog(this, "Password reset successful!", "Success", JOptionPane.INFORMATION_MESSAGE);

                // Close the dialog after successful reset
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Incorrect old password. Password reset failed.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NoSuchAlgorithmException | SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean isOldPasswordCorrect(Connection connection, String email, String enteredOldPassword) throws SQLException, NoSuchAlgorithmException {
        // Fetch the hashed password from the database for the given email
        String hashedPasswordFromDatabase = getHashedPassword(connection, email);

        // Hash the entered old password
        String hashedEnteredOldPassword = hashPassword(enteredOldPassword);

        // Compare the hashed passwords
        return hashedPasswordFromDatabase.equals(hashedEnteredOldPassword);
    }

    private String getHashedPassword(Connection connection, String email) throws SQLException {
        String sql = "SELECT password FROM vendors WHERE email = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, email);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getString("password");
                }
            }
        }
        return null;
    }

    private void updatePassword(Connection connection, String email, String newPassword) throws SQLException {
        String sql = "UPDATE vendors SET password = ? WHERE email = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, newPassword);
            preparedStatement.setString(2, email);
            preparedStatement.executeUpdate();
        }
    }

    public static void main(String[] args) {
        // Example usage
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JButton showDialogButton = new JButton("Show Password Reset Dialog");
            frame.add(showDialogButton);
            frame.setSize(400, 200);
            frame.setLocationRelativeTo(null);

            showDialogButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String userEmail = "user@example.com"; // Replace with the actual user email
                    PasswordResetDialog dialog = new PasswordResetDialog(frame, userEmail);
                    dialog.setVisible(true);
                }
            });

            frame.setVisible(true);
        });
    }
}
