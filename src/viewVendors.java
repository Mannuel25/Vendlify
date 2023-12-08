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


public class viewVendors extends javax.swing.JInternalFrame {

    private javax.swing.JDesktopPane jDesktopPanel;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/vendlify";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    
    // Populate the items table with data from the vendor_items table
    private void populateVendorsTable() {
        // Populate the vendor table with data from the vendors table
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Use a prepared statement to execute the SQL query
            String sql = "SELECT * FROM vendors WHERE user_role = 'vendor'";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // Execute the query and get the result set
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    // Create a DefaultTableModel to store the data for the JTable
                    DefaultTableModel tableModel = (DefaultTableModel) view_vendors_table.getModel();
                    tableModel.setRowCount(0); // Clear existing data

                    // Iterate over the result set and populate the table model
                    while (resultSet.next()) {
                        Object[] rowData = {
                            resultSet.getString("full_name"),
                            resultSet.getString("email"),
                            resultSet.getString("location"),
                            resultSet.getString("phone_no"),
                            resultSet.getString("item_categories")
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
    
    
    public viewVendors() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        jDesktopPanel = new javax.swing.JDesktopPane();

        populateVendorsTable();
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        view_vendors_table = new javax.swing.JTable();
        search_input = new javax.swing.JTextField();
        search_btn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setResizable(true);
        setTitle("View all Vendors");

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        view_vendors_table.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        view_vendors_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Full Name", "Email", "Location", "Phone number", "Categories"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        view_vendors_table.setGridColor(new java.awt.Color(255, 255, 255));
        view_vendors_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                view_vendors_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(view_vendors_table);

        search_input.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N

        search_btn.setBackground(new java.awt.Color(255, 255, 255));
        search_btn.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        search_btn.setText("Search");
        search_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_btnActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 21)); // NOI18N
        jLabel1.setText("All Vendors");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(265, 265, 265)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(search_input, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(search_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 904, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_btn)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(181, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void view_vendors_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_view_vendors_tableMouseClicked
        DefaultTableModel tableModel = (DefaultTableModel) view_vendors_table.getModel();

        String vendorName = tableModel.getValueAt(view_vendors_table.getSelectedRow(), 0).toString();
        String vendorEmail = tableModel.getValueAt(view_vendors_table.getSelectedRow(), 1).toString();

        
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vendlify", "root", "")) {
            String sql = "SELECT id FROM vendors WHERE full_name = ? AND email = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, vendorName);
                preparedStatement.setString(2, vendorEmail);
                

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        int vendor_item_id = resultSet.getInt("id");
                        // Create and show the ItemDialog
                        VendorDialog vendorDialog = new VendorDialog((Frame)null, "Update Vendor", true, vendor_item_id);
                        vendorDialog.setVisible(true);

                        // After updating, you might want to refresh the table
                        populateVendorsTable();
                    } else {
                        JOptionPane.showMessageDialog(this, "Vendor details not found!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_view_vendors_tableMouseClicked

    private void search_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_btnActionPerformed
        // Get the search query from the text field
        String searchQuery = search_input.getText().trim();

        if (!searchQuery.isEmpty()) {
            boolean itemsFound = false; // Flag to check if items were found

            try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
                // Fetch the email of the logged-in vendor
//                String loggedInVendorEmail = GlobalVariables.getUserEmail();

                // Fetch the vendor ID based on the email
//                int vendorId = getUserIdFromEmail(loggedInVendorEmail);

                // Use a prepared statement to execute the SQL query with a LIKE clause
                String sql = "SELECT full_name, email, phone_no, location, item_categories FROM vendors WHERE (full_name LIKE ? OR email LIKE ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//                    preparedStatement.setInt(1, vendorId);
                    preparedStatement.setString(1, "%" + searchQuery + "%");
                    preparedStatement.setString(2, "%" + searchQuery + "%");

                    // Execute the query and get the result set
                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        // Create a DefaultTableModel to store the data for the JTable
                        DefaultTableModel tableModel = (DefaultTableModel) view_vendors_table.getModel();
                        tableModel.setRowCount(0); // Clear existing data

                        // Iterate over the result set and populate the table model
                        while (resultSet.next()) {
                            itemsFound = true; // Set the flag to true
                            Object[] rowData = {
                                resultSet.getString("full_name"),
                                resultSet.getString("email"),
                                resultSet.getString("phone_no"),
                                resultSet.getString("location"),
                                resultSet.getString("item_categories")

                            };
                            tableModel.addRow(rowData);
                        }
                    }
                }

                // Check if items were found
                if (!itemsFound) {
                    // No items found
                    JOptionPane.showMessageDialog(this, "Vendor not found.", "Information", JOptionPane.INFORMATION_MESSAGE);
                }

                // Close the database connection
                connection.close();
            } catch (SQLException ex) {
                // Handle any SQL exceptions
                ex.printStackTrace(); // Log or display the exception
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            // If the search query is empty, display all vendors
            populateVendorsTable();
        }
    }//GEN-LAST:event_search_btnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton search_btn;
    private javax.swing.JTextField search_input;
    private javax.swing.JTable view_vendors_table;
    // End of variables declaration//GEN-END:variables
}
