import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.Objects;



public class VendorDialog extends JDialog {
    private JTextField vendorNameField;
    private JTextField vendorEmailField;
    private JTextField vendorPhoneNoField;
    private JComboBox<String> vendorLocationDropdown;
    
    public VendorDialog(Frame parent, String title, boolean modal, int vendorId) {
        super(parent, title, modal);

        // Set background color to white
        getContentPane().setBackground(Color.WHITE);

        // Initialize components
        vendorNameField = new JTextField(20);
        vendorEmailField = new JTextField(20);
        vendorPhoneNoField = new JTextField(20);

        // Set font
        Font font = new Font("Trebuchet MS", Font.PLAIN, 16);
        vendorNameField.setFont(font);
        vendorEmailField.setFont(font);
        vendorPhoneNoField.setFont(font);

        String[] categories = {"S 1", "S 2", "S 3", "S 4", "S 5", "S 6", "S 7", "S 8", "S 9", "S 10", "S 11", "S 12"};
        vendorLocationDropdown = new JComboBox<>(categories);
        vendorLocationDropdown.setFont(font);

        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");

        updateButton.setFont(font);
        deleteButton.setFont(font);

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateVendor(vendorId);
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteVendor(vendorId);
            }
        });

        // Set layout manager (GridLayout for better arrangement)
        setLayout(new GridLayout(6, 2, 10, 10));
        // Add components to the layout
        add(new JLabel("Full Name:"));
        add(vendorNameField);
        add(new JLabel("Email:"));
        add(vendorEmailField);
        add(new JLabel("Phone Number:"));
        add(vendorPhoneNoField);
        add(new JLabel("Location:"));
        add(vendorLocationDropdown);
        add(updateButton);
        add(deleteButton);

        // Fetch and populate item details if vendorItemId is provided
        if (vendorId > 0) {
            fetchAndPopulateVendorDetails(vendorId);
        }

        pack();
        setLocationRelativeTo(parent);
    }

    private void fetchAndPopulateVendorDetails(int vendorId) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vendlify", "root", "")) {
            String sql = "SELECT full_name, email, location, phone_no, item_categories FROM vendors WHERE id = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, vendorId);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        // Populate the fields with the fetched data
                        vendorNameField.setText(resultSet.getString("full_name"));
                        vendorEmailField.setText(resultSet.getString("email"));
                        vendorPhoneNoField.setText(resultSet.getString("phone_no"));
                        String category = resultSet.getString("item_categories");
                        vendorLocationDropdown.setSelectedItem(category);
                    } else {
                        // Handle the case where item details are not found
                        JOptionPane.showMessageDialog(this, "Vendor details not found!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateVendor(int vendorId) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vendlify", "root", "")) {
            String sql = "UPDATE vendors SET full_name = ?, email = ?, phone_no = ?, location = ? WHERE id = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, vendorNameField.getText());
                preparedStatement.setString(2, vendorEmailField.getText());
                preparedStatement.setString(3, vendorPhoneNoField.getText());
                preparedStatement.setString(4, Objects.requireNonNull(vendorLocationDropdown.getSelectedItem()).toString());
                preparedStatement.setInt(5, vendorId);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Vendor details updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    dispose(); // Close the dialog after successful update
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to update vendor details!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteVendor(int vendorId) {
        int confirmResult = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this vendor?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);

        if (confirmResult == JOptionPane.YES_OPTION) {
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vendlify", "root", "")) {
                String sql = "DELETE FROM vendors WHERE id = ?";

                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setInt(1, vendorId);

                    int rowsAffected = preparedStatement.executeUpdate();

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(this, "Vendor deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        dispose(); // Close the dialog after successful deletion
                    } else {
                        JOptionPane.showMessageDialog(this, "Failed to delete vendor!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
