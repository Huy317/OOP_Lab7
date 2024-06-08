/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cd_store;

/**
 *
 * @author Student
 */
import javax.swing.*;
import java.awt.*;
public class newCDDialog extends JDialog {
    private JTextField txtId, txtTitle, txtPrice, txtYearOfRelease;
    private JButton btnAdd, btnClear, btnCancel;
    private JRadioButton rbVCD, rbCD;
    private CDManager manager = new CDManager();
    protected CD cdToAdd;
    protected boolean isSaving = false;
    public newCDDialog(Frame owner, String title) {
        super(owner, title);
        this.setSize(600,600);
        this.setLocation(200,200);
        this.setLayout(new GridLayout(7,1));

        JPanel panel1 = new JPanel(new FlowLayout());
        JLabel idLabel = new JLabel("CD ID");
        txtId = new JTextField(20);
        panel1.add(idLabel);panel1.add(txtId);


        JPanel panel2 = new JPanel(new FlowLayout());
        JLabel titleLabel = new JLabel("CD Title");
        txtTitle = new JTextField(20);
        panel2.add(titleLabel);panel2.add(txtTitle);

        JPanel panel3 = new JPanel(new FlowLayout());
        JLabel collectionLabel = new JLabel("CD Collection");
        String[] coll = {"movie","music","game"};
        JComboBox<String> collectionBox = new JComboBox<>(coll);
        JLabel typeLabel = new JLabel("CD Type");
        ButtonGroup group = new ButtonGroup();
        rbVCD = new JRadioButton("VCD");
        rbCD  = new JRadioButton("CD");
        group.add(rbVCD);group.add(rbCD);
        panel3.add(collectionLabel);panel3.add(collectionBox);panel3.add(typeLabel);panel3.add(rbVCD);panel3.add(rbCD);

        JPanel panel4 = new JPanel(new FlowLayout());
        JLabel priceLabel = new JLabel("CD Price");
        txtPrice = new JTextField(20);
        panel4.add(priceLabel);panel4.add(txtPrice);

        JLabel yearOfReleaseLabel = new JLabel("CD Year of Release");
        yearOfReleaseLabel.setHorizontalAlignment(JLabel.CENTER);

        JPanel panel5 = new JPanel(new FlowLayout());
        txtYearOfRelease = new JTextField(20);
        btnAdd = new JButton("Add");
        btnAdd.addActionListener((e)->{
            if (checkInput()){
                String type;
                if (rbVCD.isSelected()){
                    type = "VCD";
                }else{
                    type = "CD";
                }
                cdToAdd = new CD(txtId.getText(),collectionBox.getSelectedItem().toString(),type,txtTitle.getText(),Double.parseDouble(txtPrice.getText()),Integer.parseInt(txtYearOfRelease.getText()));
                isSaving = true;
                this.setVisible(false);
            } 
        });
        panel5.add(txtYearOfRelease);panel5.add(btnAdd);

        JPanel panel6 = new JPanel(new FlowLayout());
        btnClear = new JButton("Clear");
        btnCancel = new JButton("Cancel");
        btnCancel.addActionListener((e)->{
            isSaving = false;
            this.setVisible(false);
        });
        btnClear.addActionListener((e)->{
            clear();
        });
        


        panel6.add(btnClear);panel6.add(btnCancel);
        this.add(panel1);this.add(panel2);this.add(panel3);this.add(panel4);
        this.add(yearOfReleaseLabel);this.add(panel5);this.add(panel6);
        //this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
    }
   

    public boolean checkInput(){
        if (txtId.getText().equals("") || txtTitle.getText().equals("") || txtPrice.getText().equals("")||txtYearOfRelease.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Please fill in all information", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            double d = Double.parseDouble(txtPrice.getText());
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Please input only numbers as Price", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            double d = Double.parseDouble(txtYearOfRelease.getText());
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Please input only numbers as Year", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    public void clear(){
        txtId.setText("");
        txtTitle.setText("");
        txtPrice.setText("");
        txtYearOfRelease.setText("");
    }
}

