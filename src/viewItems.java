import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Font;
import javax.swing.JButton;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import java.awt.Frame;


import vendlify.GlobalVariables;


public class viewItems extends javax.swing.JInternalFrame {
    
    private javax.swing.JDesktopPane jDesktopPanel;

    
    private static final String DB_URL = "jdbc:mysql://localhost:3306/vendlify";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    
    // Method to fetch the user ID from the database based on email
    public static int getUserIdFromEmail(String email) {
        int userId = 0;

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            String sql = "SELECT id FROM vendors WHERE email = ?";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, email);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        userId = resultSet.getInt("id");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed, e.g., log it or show an error message
        }

        return userId;
    }
    
    // Populate the vendor table with data from the vendors table
    private void populateItemsTable() {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Fetch the email of the logged-in vendor
            String loggedInVendorEmail = GlobalVariables.getUserEmail();

            // Fetch the vendor ID based on the email
            int vendorId = getUserIdFromEmail(loggedInVendorEmail);

            // Use a prepared statement to execute the SQL query
            String sql = "SELECT name, category, price, in_stock FROM vendor_items WHERE vendor_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, vendorId);

                // Execute the query and get the result set
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    // Create a DefaultTableModel to store the data for the JTable
                    DefaultTableModel tableModel = (DefaultTableModel) view_items_table.getModel();
                    tableModel.setRowCount(0); // Clear existing data

                    // Iterate over the result set and populate the table model
                    while (resultSet.next()) {
                        Object[] rowData = {
                            resultSet.getString("name"),
                            resultSet.getString("category"),
                            resultSet.getDouble("price"),
                            resultSet.getInt("in_stock")
                        };
                        tableModel.addRow(rowData);
                    }
                }
            }

            // Close the database connection
            connection.close();
        } catch (SQLException ex) {
            // Handle any SQL exceptions
            ex.printStackTrace(); // Log or display the exception
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public viewItems() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        jDesktopPanel = new javax.swing.JDesktopPane();

        populateItemsTable();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        view_items_table = new javax.swing.JTable();
        search_input = new javax.swing.JTextField();
        search_btn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setTitle("View all Items");

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        view_items_table.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        view_items_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "Category", "Price", "In Stock"
            }
        ));
        view_items_table.setGridColor(new java.awt.Color(255, 255, 255));
        view_items_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                view_items_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(view_items_table);

        search_input.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N

        search_btn.setBackground(new java.awt.Color(255, 255, 255));
        search_btn.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        search_btn.setText("Search");
        search_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_btnActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 21)); // NOI18N
        jLabel5.setText("All Items");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 811, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(223, 223, 223)
                        .addComponent(search_input, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(search_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_btn)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(228, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void view_items_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_view_items_tableMouseClicked
        DefaultTableModel tableModel = (DefaultTableModel) view_items_table.getModel();

        String itemName = tableModel.getValueAt(view_items_table.getSelectedRow(), 0).toString();
        String itemCategory = tableModel.getValueAt(view_items_table.getSelectedRow(), 1).toString();
        String itemInStock = tableModel.getValueAt(view_items_table.getSelectedRow(), 3).toString();

        // Fetch item id from the database
        String userEmail = GlobalVariables.getUserEmail();        
        int vendorId = getUserIdFromEmail(userEmail);

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vendlify", "root", "")) {
            String sql = "SELECT id FROM vendor_items WHERE vendor_id = ? AND name = ? AND category = ? AND in_stock = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, vendorId);
                preparedStatement.setString(2, itemName);
                preparedStatement.setString(3, itemCategory);
                preparedStatement.setString(4, itemInStock);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        int vendor_item_id = resultSet.getInt("id");
                        // Create and show the ItemDialog
                        ItemDialog itemDialog = new ItemDialog((Frame)null, "Update Item", true, vendor_item_id);
                        itemDialog.setVisible(true);

                        // After updating, you might want to refresh the table
                        populateItemsTable();
                    } else {
                        JOptionPane.showMessageDialog(this, "Item details not found!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_view_items_tableMouseClicked

    private void search_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_btnActionPerformed
        // Get the search query from the text field
        String searchQuery = search_input.getText().trim();

        if (!searchQuery.isEmpty()) {
            boolean itemsFound = false; // Flag to check if items were found

            try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
                // Fetch the email of the logged-in vendor
                String loggedInVendorEmail = GlobalVariables.getUserEmail();

                // Fetch the vendor ID based on the email
                int vendorId = getUserIdFromEmail(loggedInVendorEmail);

                // Use a prepared statement to execute the SQL query with a LIKE clause
                String sql = "SELECT name, category, price, in_stock FROM vendor_items WHERE vendor_id = ? AND (name LIKE ? OR category LIKE ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setInt(1, vendorId);
                    preparedStatement.setString(2, "%" + searchQuery + "%");
                    preparedStatement.setString(3, "%" + searchQuery + "%");

                    // Execute the query and get the result set
                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        // Create a DefaultTableModel to store the data for the JTable
                        DefaultTableModel tableModel = (DefaultTableModel) view_items_table.getModel();
                        tableModel.setRowCount(0); // Clear existing data

                        // Iterate over the result set and populate the table model
                        while (resultSet.next()) {
                            itemsFound = true; // Set the flag to true
                            Object[] rowData = {
                                    resultSet.getString("name"),
                                    resultSet.getString("category"),
                                    resultSet.getDouble("price"),
                                    resultSet.getInt("in_stock")
                            };
                            tableModel.addRow(rowData);
                        }
                    }
                }

                // Check if items were found
                if (!itemsFound) {
                    // No items found
                    JOptionPane.showMessageDialog(this, "Item not found.", "Information", JOptionPane.INFORMATION_MESSAGE);
                }

                // Close the database connection
                connection.close();
            } catch (SQLException ex) {
                // Handle any SQL exceptions
                ex.printStackTrace(); // Log or display the exception
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            // If the search query is empty, display all items
            populateItemsTable();
        }
    }//GEN-LAST:event_search_btnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton search_btn;
    private javax.swing.JTextField search_input;
    private javax.swing.JTable view_items_table;
    // End of variables declaration//GEN-END:variables
}
