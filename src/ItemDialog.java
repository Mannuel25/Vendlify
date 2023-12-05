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

public class ItemDialog extends JDialog {
    private JTextField itemNameField;
    private JTextField itemPriceField;
    private JTextField itemInStockField;
    private JComboBox<String> categoryDropdown;

    public ItemDialog(Frame parent, String title, boolean modal, int vendorItemId) {
        super(parent, title, modal);

        // Set background color to white
        getContentPane().setBackground(Color.WHITE);

        // Initialize components
        itemNameField = new JTextField(20);
        itemPriceField = new JTextField(20);
        itemInStockField = new JTextField(20);

        // Set font
        Font font = new Font("Trebuchet MS", Font.PLAIN, 14);
        itemNameField.setFont(font);
        itemPriceField.setFont(font);
        itemInStockField.setFont(font);

        String[] categories = {"Food", "Drinks", "Perfumes & Deodorants", "Stationaries", "Snacks", "Toiletries"};
        categoryDropdown = new JComboBox<>(categories);
        categoryDropdown.setFont(font);

        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");

        updateButton.setFont(font);
        deleteButton.setFont(font);

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateItem(vendorItemId);
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteItem(vendorItemId);
            }
        });

        // Set layout manager (GridLayout for better arrangement)
        setLayout(new GridLayout(6, 2, 10, 10));

        // Add components to the layout
        add(new JLabel("Item Name:"));
        add(itemNameField);
        add(new JLabel("Price:"));
        add(itemPriceField);
        add(new JLabel("In Stock:"));
        add(itemInStockField);
        add(new JLabel("Category:"));
        add(categoryDropdown);
        add(updateButton);
        add(deleteButton);

        // Fetch and populate item details if vendorItemId is provided
        if (vendorItemId > 0) {
            fetchAndPopulateItemDetails(vendorItemId);
        }

        pack();
        setLocationRelativeTo(parent);
    }

    private void fetchAndPopulateItemDetails(int vendorItemId) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vendlify", "root", "")) {
            String sql = "SELECT name, price, in_stock, category FROM vendor_items WHERE id = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, vendorItemId);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        // Populate the fields with the fetched data
                        itemNameField.setText(resultSet.getString("name"));
                        itemPriceField.setText(resultSet.getString("price"));
                        itemInStockField.setText(resultSet.getString("in_stock"));
                        String category = resultSet.getString("category");
                        categoryDropdown.setSelectedItem(category);
                    } else {
                        // Handle the case where item details are not found
                        JOptionPane.showMessageDialog(this, "Item details not found!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateItem(int vendorItemId) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vendlify", "root", "")) {
            String sql = "UPDATE vendor_items SET name = ?, price = ?, in_stock = ?, category = ? WHERE id = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, itemNameField.getText());
                preparedStatement.setString(2, itemPriceField.getText());
                preparedStatement.setString(3, itemInStockField.getText());
                preparedStatement.setString(4, Objects.requireNonNull(categoryDropdown.getSelectedItem()).toString());
                preparedStatement.setInt(5, vendorItemId);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Item updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    dispose(); // Close the dialog after successful update
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to update item!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteItem(int vendorItemId) {
        int confirmResult = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this item?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);

        if (confirmResult == JOptionPane.YES_OPTION) {
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vendlify", "root", "")) {
                String sql = "DELETE FROM vendor_items WHERE id = ?";

                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setInt(1, vendorItemId);

                    int rowsAffected = preparedStatement.executeUpdate();

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(this, "Item deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        dispose(); // Close the dialog after successful deletion
                    } else {
                        JOptionPane.showMessageDialog(this, "Failed to delete item!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
