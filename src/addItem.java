import javax.swing.plaf.basic.BasicInternalFrameUI;
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
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import vendlify.GlobalVariables;


public class addItem extends javax.swing.JInternalFrame {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/vendlify";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    public addItem() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        category = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        item_price = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        in_stock = new javax.swing.JTextField();
        item_category = new javax.swing.JComboBox();
        add_item_btn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setTitle("Add an Item");

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel1.setText("Name");

        category.setBackground(new java.awt.Color(255, 255, 255));
        category.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        category.setText("Category");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel4.setText("Price");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel3.setText("In Stock");

        item_price.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        item_price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_priceActionPerformed(evt);
            }
        });

        name.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });

        in_stock.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        in_stock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                in_stockActionPerformed(evt);
            }
        });

        item_category.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        item_category.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Food", "Drinks", "Snacks", "Stationaries", "Perfumes & Deodorants", "Toiletries" }));

        add_item_btn.setBackground(new java.awt.Color(0, 153, 0));
        add_item_btn.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        add_item_btn.setForeground(new java.awt.Color(255, 255, 255));
        add_item_btn.setText("Add");
        add_item_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_item_btnMouseClicked(evt);
            }
        });
        add_item_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_item_btnActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 21)); // NOI18N
        jLabel5.setText("Add an Item");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(category, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(106, 106, 106)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(item_category, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(item_price, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(in_stock, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(280, 280, 280)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(299, 299, 299)
                        .addComponent(add_item_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(1532, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(category, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(item_category, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(item_price, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(in_stock, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addComponent(add_item_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1000, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void item_priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_item_priceActionPerformed

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void in_stockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_in_stockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_in_stockActionPerformed
    
    
    // Method to save the item information to the vendor_items table
    private void saveItemToDatabase(int userId, String itemName, String category, double price, int stock) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Use userId as the foreign key to associate the item with the vendor
            String sql = "INSERT INTO vendor_items (vendor_id, name, category, price, in_stock) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, userId);
                preparedStatement.setString(2, itemName);
                preparedStatement.setString(3, category);
                preparedStatement.setDouble(4, price);
                preparedStatement.setInt(5, stock);

                // Execute the SQL statement to insert the item
                preparedStatement.executeUpdate();
                JOptionPane.showMessageDialog(this, "Item added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }

            // Close the database connection
            connection.close();
        } catch (SQLException ex) {
            // Handle any SQL exceptions
            ex.printStackTrace(); // Log or display the exception
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Method to fetch the user ID from the database based on email
    private int getUserIdFromEmail(String email) {
        int userId = -1; // Default value in case the user ID is not found or an error occurs

        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            String sql = "SELECT id FROM vendors WHERE email = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, email);

                // Execute the query and get the result set
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    // Check if the result set has a row
                    if (resultSet.next()) {
                        // Get the user ID from the result set
                        userId = resultSet.getInt("id");
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

        return userId;
    }


    private void add_item_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_item_btnActionPerformed
        // Get the item details from the form
        String itemName = name.getText();
        String category = (String) item_category.getSelectedItem();
        double price = Double.parseDouble(item_price.getText());
        int stock = Integer.parseInt(in_stock.getText());

        // Get the logged-in user's email from the GlobalVariable
        String userEmail = GlobalVariables.getUserEmail();

        // Fetch the user ID from the database based on the email
        int userId = getUserIdFromEmail(userEmail); // method to fetch the user ID from the database

        // Save the item information to the vendor_items table
        saveItemToDatabase(userId, itemName, category, price, stock); // method to save the item to the database
    }//GEN-LAST:event_add_item_btnActionPerformed

    private void add_item_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_item_btnMouseClicked
    }//GEN-LAST:event_add_item_btnMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_item_btn;
    private javax.swing.JLabel category;
    private javax.swing.JTextField in_stock;
    private javax.swing.JComboBox item_category;
    private javax.swing.JTextField item_price;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField name;
    // End of variables declaration//GEN-END:variables
}
