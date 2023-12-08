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

public class myprofile extends javax.swing.JInternalFrame {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/vendlify";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    // Helper method to populate checkbox categories
    private void populateCheckboxFromCategories(String categoriesString) {
        // Split the categories string into an array
        if (categoriesString != null) {
            String[] categories = categoriesString.split(", ");

            // Check the corresponding checkboxes based on the categories array
            for (String category : categories) {
                switch (category) {
                    case "Food":
                        food.setSelected(true);
                        break;
                    case "Drinks":
                        drinks.setSelected(true);
                        break;
                    case "Perfumes & Deodorants":
                        perfumes.setSelected(true);
                        break;
                    case "Toiletries":
                        toiletries.setSelected(true);
                        break;
                    case "Snacks":
                        snacks.setSelected(true);
                        break;
                    case "Stationaries":
                        stationaries.setSelected(true);
                        break;
                }
            }
        }
    }
    
    // Method to fetch and populate user details
    private void fetchAndPopulateUserDetails(String userEmail) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Use the userEmail to fetch user details from the database
            String sql = "SELECT * FROM vendors WHERE email = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, userEmail);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        // Populate the form fields with user details
                        full_name.setText(resultSet.getString("full_name"));
                        email.setText(resultSet.getString("email"));
                        phone_no.setText(resultSet.getString("phone_no"));
                        location.setSelectedItem(resultSet.getString("location"));
                        phone_no.setText(resultSet.getString("phone_no"));

                        String categoriesString = resultSet.getString("item_categories");
                        populateCheckboxFromCategories(categoriesString);

                         full_name.setEnabled(false);
                         email.setEnabled(false);
                    } else {
                        // Handle the case where user details are not found
                        JOptionPane.showMessageDialog(this, "User details not found!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }

            // Close the database connection
            connection.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Constructor that takes the user email as a parameter
    public myprofile(String userEmail) {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);

        // Fetch user details based on the userEmail and populate the form
        fetchAndPopulateUserDetails(userEmail);
    }

   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        full_name = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        phone_no = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        drinks = new javax.swing.JCheckBox();
        toiletries = new javax.swing.JCheckBox();
        snacks = new javax.swing.JCheckBox();
        perfumes = new javax.swing.JCheckBox();
        food = new javax.swing.JCheckBox();
        stationaries = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        update_btn = new javax.swing.JButton();
        location = new javax.swing.JComboBox();
        reset_password_btn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setTitle("My Profile");
        setPreferredSize(new java.awt.Dimension(2250, 1500));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel1.setText("Full Name");

        full_name.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        full_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                full_nameActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel2.setText("Email Address");

        email.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel3.setText("Phone Number");

        phone_no.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        phone_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phone_noActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel4.setText("Location");

        drinks.setBackground(new java.awt.Color(255, 255, 255));
        drinks.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        drinks.setText("Drinks");

        toiletries.setBackground(new java.awt.Color(255, 255, 255));
        toiletries.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        toiletries.setText("Toiletries");

        snacks.setBackground(new java.awt.Color(255, 255, 255));
        snacks.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        snacks.setText("Snacks");
        snacks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                snacksActionPerformed(evt);
            }
        });

        perfumes.setBackground(new java.awt.Color(255, 255, 255));
        perfumes.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        perfumes.setText("Perfumes & Deodorants");

        food.setBackground(new java.awt.Color(255, 255, 255));
        food.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        food.setText("Food");
        food.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                foodActionPerformed(evt);
            }
        });

        stationaries.setBackground(new java.awt.Color(255, 255, 255));
        stationaries.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        stationaries.setText("Stationaries");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel5.setText("What do you sell?");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 13)); // NOI18N
        jLabel6.setText("(Select all that apply)");

        update_btn.setBackground(new java.awt.Color(0, 153, 0));
        update_btn.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        update_btn.setForeground(new java.awt.Color(255, 255, 255));
        update_btn.setText("Update");
        update_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_btnActionPerformed(evt);
            }
        });

        location.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        location.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "S1", "S 2", "S 3", "S 4", "S 5", "S 6", "S 7", "S 9", "S 10", "S 11", "S 12" }));

        reset_password_btn.setBackground(new java.awt.Color(102, 102, 255));
        reset_password_btn.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        reset_password_btn.setForeground(new java.awt.Color(255, 255, 255));
        reset_password_btn.setText("Reset Password");
        reset_password_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset_password_btnActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 1, 21)); // NOI18N
        jLabel7.setText("My Profile");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(location, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phone_no, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(full_name, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(305, 305, 305)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(stationaries)
                                    .addComponent(food))
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(update_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(121, 121, 121)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(drinks)
                            .addComponent(perfumes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(reset_password_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(toiletries)
                            .addComponent(snacks))))
                .addContainerGap(1532, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(full_name, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(email, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phone_no, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(location, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(food)
                    .addComponent(drinks)
                    .addComponent(snacks))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stationaries)
                    .addComponent(perfumes)
                    .addComponent(toiletries))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(update_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reset_password_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(955, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void full_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_full_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_full_nameActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void phone_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phone_noActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phone_noActionPerformed

    private void snacksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_snacksActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_snacksActionPerformed

    private void foodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_foodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_foodActionPerformed

    private void update_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_btnActionPerformed
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Fetch user details from the database
            String userEmail = GlobalVariables.getUserEmail();

            // Use the userEmail to fetch user details from the database
            String sql = "SELECT * FROM vendors WHERE email = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, userEmail);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        
                        // Get the new values from the form
                        String newLocation = location.getSelectedItem().toString();
                        String newPhoneNo = phone_no.getText();

                        // Initialize an empty StringBuilder to store the selected items
                        StringBuilder selectedCategories = new StringBuilder();

                        // Check each checkbox and append its label to the StringBuilder if selected
                        if (food.isSelected()) {
                            selectedCategories.append("Food, ");
                        }
                        if (drinks.isSelected()) {
                            selectedCategories.append("Drinks, ");
                        }
                        if (perfumes.isSelected()) {
                            selectedCategories.append("Perfumes & Deodorants, ");
                        }
                        if (stationaries.isSelected()) {
                            selectedCategories.append("Stationaries, ");
                        }
                        if (snacks.isSelected()) {
                            selectedCategories.append("Snacks, ");
                        }
                        if (toiletries.isSelected()) {
                            selectedCategories.append("Toiletries, ");
                        }

                        // Remove the trailing comma and space if there are selected items
                        if (selectedCategories.length() > 0) {
                            selectedCategories.setLength(selectedCategories.length() - 2);
                        }

                        // Now 'selectedCategories' contains the comma-separated string of selected items
                        String selectedCategoriesString = selectedCategories.toString();

                        // Update the database with new values
                        String updateSql = "UPDATE vendors SET location = ?, phone_no = ?, item_categories = ? WHERE email = ?";
                        try (PreparedStatement updateStatement = connection.prepareStatement(updateSql)) {
                            updateStatement.setString(1, newLocation);
                            updateStatement.setString(2, newPhoneNo);
                            updateStatement.setString(3, selectedCategoriesString);
                            updateStatement.setString(4, userEmail);
                            updateStatement.executeUpdate();

                            // Display success message or perform other actions
                            JOptionPane.showMessageDialog(this, "Your details have been updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        // Handle the case where user details are not found
                        JOptionPane.showMessageDialog(this, "Your details were not found!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }

            // Close the database connection
            connection.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_update_btnActionPerformed

    private void reset_password_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_password_btnActionPerformed
        // Get the parent frame of myprofile
        Container parent = this.getParent();
        while (!(parent instanceof JFrame) && parent != null) {
            parent = parent.getParent();
        }

        if (parent instanceof JFrame) {
            String userEmail = GlobalVariables.getUserEmail();
            // Instantiate the PasswordResetDialog with the user email
            PasswordResetDialog passwordResetDialog = new PasswordResetDialog((JFrame) parent, userEmail);

            // Set the dialog visibility to true
            passwordResetDialog.setVisible(true);
        } else {
            // Handle the case when a JFrame parent is not found
            System.err.println("Error: Unable to find JFrame parent.");
        }
    }//GEN-LAST:event_reset_password_btnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox drinks;
    private javax.swing.JTextField email;
    private javax.swing.JCheckBox food;
    private javax.swing.JTextField full_name;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JComboBox location;
    private javax.swing.JCheckBox perfumes;
    private javax.swing.JTextField phone_no;
    private javax.swing.JButton reset_password_btn;
    private javax.swing.JCheckBox snacks;
    private javax.swing.JCheckBox stationaries;
    private javax.swing.JCheckBox toiletries;
    private javax.swing.JButton update_btn;
    // End of variables declaration//GEN-END:variables
}
