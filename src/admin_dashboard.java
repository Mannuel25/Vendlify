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


import vendlify.GlobalVariables;


public class admin_dashboard extends javax.swing.JFrame {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/vendlify";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    
    
    public admin_dashboard() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        my_profile = new javax.swing.JPanel();
        my_profile_label = new javax.swing.JLabel();
        view_items_panel = new javax.swing.JPanel();
        view_vendors_label = new javax.swing.JLabel();
        logout_panel = new javax.swing.JPanel();
        logout_label = new javax.swing.JLabel();
        add_item_panel = new javax.swing.JPanel();
        add_vendor_label = new javax.swing.JLabel();
        jDesktopPanel = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin Dashboard");
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(32767, 32767));

        jPanel5.setBackground(new java.awt.Color(102, 102, 255));

        my_profile.setBackground(new java.awt.Color(255, 255, 255));
        my_profile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                my_profileMousePressed(evt);
            }
        });

        my_profile_label.setBackground(new java.awt.Color(255, 255, 255));
        my_profile_label.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        my_profile_label.setText("My Profile");
        my_profile_label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                my_profile_labelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout my_profileLayout = new javax.swing.GroupLayout(my_profile);
        my_profile.setLayout(my_profileLayout);
        my_profileLayout.setHorizontalGroup(
            my_profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(my_profileLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(my_profile_label, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
        );
        my_profileLayout.setVerticalGroup(
            my_profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(my_profile_label, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );

        view_items_panel.setBackground(new java.awt.Color(255, 255, 255));

        view_vendors_label.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        view_vendors_label.setText("View Vendors");
        view_vendors_label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                view_vendors_labelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout view_items_panelLayout = new javax.swing.GroupLayout(view_items_panel);
        view_items_panel.setLayout(view_items_panelLayout);
        view_items_panelLayout.setHorizontalGroup(
            view_items_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(view_items_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(view_vendors_label, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
        );
        view_items_panelLayout.setVerticalGroup(
            view_items_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(view_vendors_label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        logout_panel.setBackground(new java.awt.Color(255, 255, 255));

        logout_label.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        logout_label.setText("Logout");
        logout_label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logout_labelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout logout_panelLayout = new javax.swing.GroupLayout(logout_panel);
        logout_panel.setLayout(logout_panelLayout);
        logout_panelLayout.setHorizontalGroup(
            logout_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logout_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logout_label, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
        );
        logout_panelLayout.setVerticalGroup(
            logout_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logout_label, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        add_item_panel.setBackground(new java.awt.Color(255, 255, 255));

        add_vendor_label.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        add_vendor_label.setText("Add a vendor");
        add_vendor_label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_vendor_labelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout add_item_panelLayout = new javax.swing.GroupLayout(add_item_panel);
        add_item_panel.setLayout(add_item_panelLayout);
        add_item_panelLayout.setHorizontalGroup(
            add_item_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(add_item_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(add_vendor_label, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
        );
        add_item_panelLayout.setVerticalGroup(
            add_item_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(add_vendor_label, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        jDesktopPanel.setBackground(new java.awt.Color(255, 255, 255));
        jDesktopPanel.setPreferredSize(new java.awt.Dimension(500, 1500));

        javax.swing.GroupLayout jDesktopPanelLayout = new javax.swing.GroupLayout(jDesktopPanel);
        jDesktopPanel.setLayout(jDesktopPanelLayout);
        jDesktopPanelLayout.setHorizontalGroup(
            jDesktopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 946, Short.MAX_VALUE)
        );
        jDesktopPanelLayout.setVerticalGroup(
            jDesktopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(my_profile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(logout_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(view_items_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(add_item_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 946, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(my_profile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(view_items_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(add_item_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                .addComponent(logout_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
            .addComponent(jDesktopPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void my_profile_labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_my_profile_labelMouseClicked
        // Fetch user details from the database
        String userEmail = GlobalVariables.getUserEmail();

        // Check if the user is logged in
        if (!userEmail.isEmpty()) {
            // Open myprofile form and pass the user email
            adminProfile amdinProfileForm = new adminProfile(userEmail);
            jDesktopPanel.removeAll();
            jDesktopPanel.add(amdinProfileForm).setVisible(true);
        } else {
            // User is not logged in, show an error message or handle accordingly
            JOptionPane.showMessageDialog(this, "User not logged in!", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_my_profile_labelMouseClicked

    private void my_profileMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_my_profileMousePressed

    }//GEN-LAST:event_my_profileMousePressed

    private void view_vendors_labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_view_vendors_labelMouseClicked
        // Open the viewItems form
        viewVendors viewVendorsForm = new viewVendors();

        // Add the viewItems form to the desktop pane
        jDesktopPanel.removeAll();
        jDesktopPanel.add(viewVendorsForm).setVisible(true);

    }//GEN-LAST:event_view_vendors_labelMouseClicked

    private void add_vendor_labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_vendor_labelMouseClicked

        addVendor add_vendorForm = new addVendor();
        jDesktopPanel.removeAll();
        jDesktopPanel.add(add_vendorForm).setVisible(true);
    }//GEN-LAST:event_add_vendor_labelMouseClicked

    private void logout_labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logout_labelMouseClicked
        int choice = JOptionPane.showConfirmDialog(this, "Are you sure you want to log out?", "Log Out", JOptionPane.YES_NO_OPTION);
    
        if (choice == JOptionPane.YES_OPTION) {
            // clear off the saved the logged-in user email
            GlobalVariables.setUserEmail("");
            // Close the current frame or window (assuming it's a JFrame)
            this.dispose();
            // Display a logout message
            JOptionPane.showMessageDialog(this, "Logout successful!", "Log Out", JOptionPane.INFORMATION_MESSAGE);

            // Navigate to the login page
            loginPage loginPage = new loginPage();
            loginPage.setVisible(true);

            
        }
    }//GEN-LAST:event_logout_labelMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(admin_dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admin_dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admin_dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admin_dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin_dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel add_item_panel;
    private javax.swing.JLabel add_vendor_label;
    private javax.swing.JDesktopPane jDesktopPanel;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel logout_label;
    private javax.swing.JPanel logout_panel;
    private javax.swing.JPanel my_profile;
    private javax.swing.JLabel my_profile_label;
    private javax.swing.JPanel view_items_panel;
    private javax.swing.JLabel view_vendors_label;
    // End of variables declaration//GEN-END:variables
}
