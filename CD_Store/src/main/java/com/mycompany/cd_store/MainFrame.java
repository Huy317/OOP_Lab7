/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.cd_store;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Student
 */
public class MainFrame extends javax.swing.JFrame {
    
    private CDManager manager = new CDManager();
    private CDModel model = new CDModel();

    /**
     * Creates new form Frame
     */
    public MainFrame() {
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

        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnNewCD = new javax.swing.JButton();
        btnBackup = new javax.swing.JButton();
        btnRestore = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        combobox = new javax.swing.JComboBox<>();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(470, 600));

        btnNewCD.setText("New CD");
        btnNewCD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewCDActionPerformed(evt);
            }
        });
        jPanel1.add(btnNewCD);

        btnBackup.setText("Backup");
        btnBackup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackupActionPerformed(evt);
            }
        });
        jPanel1.add(btnBackup);

        btnRestore.setText("Restore");
        btnRestore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestoreActionPerformed(evt);
            }
        });
        jPanel1.add(btnRestore);

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        jPanel1.add(btnRefresh);

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btnDelete);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        table.setModel(this.model);
        jScrollPane1.setViewportView(table);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        combobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Title", "Collection", "Type", "Price" }));
        jPanel2.add(combobox);

        txtSearch.setColumns(20);
        jPanel2.add(txtSearch);

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        jPanel2.add(btnSearch);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackupActionPerformed
        JFileChooser fc = new JFileChooser("D:\\");
        int option = fc.showSaveDialog(null);
        if (option == JFileChooser.APPROVE_OPTION) {
            manager.writeTo(fc.getCurrentDirectory() + "CD.eiu");
        }
    }//GEN-LAST:event_btnBackupActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int selected = table.getSelectedRow();
        if (selected != -1) {
            int answer = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this row?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (answer == JOptionPane.YES_OPTION) {
                manager.removeCD(selected);
                refreshModel();
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String searchCategory = combobox.getSelectedItem().toString();
        String para = txtSearch.getText();
        if (!para.equals("")) {
            ArrayList<CD> listCD = manager.searchBy(searchCategory, para);
            clearModel();
            fillModel(listCD);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnNewCDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewCDActionPerformed
        newCDDialog dlg = new newCDDialog(this, "new CD");
        dlg.setModal(true);
        dlg.setVisible(true);
        if (dlg.isSaving) {
            if (manager.addCD(dlg.cdToAdd)) {
                JOptionPane.showMessageDialog(null, "CD added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                dlg.dispose();
                refreshModel();
            } else {
                JOptionPane.showMessageDialog(null, "another CD with the same ID exist", "Couldn't add", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_btnNewCDActionPerformed

    private void btnRestoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestoreActionPerformed
        JFileChooser fc = new JFileChooser("D:\\");
        FileNameExtensionFilter filter = new FileNameExtensionFilter(".EIU Files", "eiu");
        fc.setFileFilter(filter);
        int option = fc.showOpenDialog(null);
        if (option == JFileChooser.APPROVE_OPTION) {
            manager.readFrom(fc.getSelectedFile().getAbsolutePath());
            refreshModel();
        }
    }//GEN-LAST:event_btnRestoreActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        refreshModel();
    }//GEN-LAST:event_btnRefreshActionPerformed
    
    private void refreshModel() {
        clearModel();
        fillModel();
    }
    
    private void fillModel() {
        for (CD cd : manager.getCDList()) {
            String[] rowData = {cd.getTitle(), cd.getCollection(), cd.getType(), cd.getPrice() + ""};
            model.addRow(rowData);
        }
    }
    
    private void fillModel(ArrayList<CD> listCD) {
        for (CD cd : listCD) {
            String[] rowData = {cd.getTitle(), cd.getCollection(), cd.getType(), cd.getPrice() + ""};
            model.addRow(rowData);
        }
    }
    
    private void clearModel() {
        if (model != null) {
            model.setRowCount(0);
        }
    }

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
            java.util.logging.Logger.getLogger(MainFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
            
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
            
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
            
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBackup;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNewCD;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnRestore;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> combobox;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
