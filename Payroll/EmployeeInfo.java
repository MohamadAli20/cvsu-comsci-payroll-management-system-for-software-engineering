/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Payroll;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author LIM
 */
public class EmployeeInfo extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public EmployeeInfo(){
        initComponents();

        // This place the JFrame at the center of the secreen
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, size.height/2-getHeight()/2);
        
        // Display admin ID, value from main class
        lblAdminId.setText(String.valueOf(Main.adminId));
        
        // Display information the selected employee in EmployeeInfo
        selectedEmployeeInfo();
        
        ImageIcon icon = new ImageIcon("src\\Image\\company_logo.png");
        this.setIconImage(icon.getImage());
        
    }
    
    Connection con = MyConnection.getConnection();
    PreparedStatement pst;
    ResultSet rs;
    
    public void selectedEmployeeInfo(){
        tfSearch.setText(Main.empId);
        
        try{
            String query = "SELECT * FROM employee_info WHERE id=?";
            pst = con.prepareStatement(query);
            pst.setString(1, tfSearch.getText());
            rs = pst.executeQuery();
            
            if(rs.next()){
                String id = rs.getString("id");
                tfEmpId.setText(id);

                String firstname = rs.getString("firstname");
                tfFirstname.setText(firstname);

                String lastname = rs.getString("lastname");
                tfLastname.setText(lastname);

                String middlename = rs.getString("middlename");
                tfMiddlename.setText(middlename);

                String dob = rs.getString("dob");
                ((JTextField)dcDob.getDateEditor().getUiComponent()).setText(dob);

                // set radio button based on retrieved gender
                String gender = rs.getString("gender");
                if(gender.equals("Male")){
                    rbMale.setSelected(true);
                    rbFemale.setSelected(false);
                }else{
                    rbFemale.setSelected(true);
                    rbMale.setSelected(false);
                }

                String email = rs.getString("email");
                tfEmail.setText(email);

                String pPhone = rs.getString("personal_phone");
                tfPersonalPhone.setText(pPhone);

                String hPhone = rs.getString("home_phone");
                tfHomePhone.setText(hPhone);

                String address = rs.getString("address");
                tfAddress.setText(address);

                String postalCode = rs.getString("postalcode");
                tfPostalcode.setText(postalCode);

                String basicSalary = rs.getString("basic_salary");
                tfBasicSalary.setText(basicSalary);

                String jobTitle = rs.getString("jobtitle");
                tfJobtitle.setText(jobTitle);

                String status = rs.getString("status");
                tfStatus.setText(status);

                String dateHired = rs.getString("date_hired");
                ((JTextField)dcDateHired.getDateEditor().getUiComponent()).setText(dateHired);

                byte[] image = rs.getBytes("image");
                ImageIcon imageIcon = new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH));
                lblImage.setIcon(imageIcon);
            }

        }catch(Exception e){
             
        }
    }
    public void clearTextField(){
        tfSearch.setText("");
        tfEmpId.setText("");
        tfFirstname.setText("");
        tfLastname.setText("");
        tfMiddlename.setText("");
        ((JTextField)dcDob.getDateEditor().getUiComponent()).setText("");
        rbMale.setSelected(false);
        rbFemale.setSelected(false);
        tfEmail.setText("");
        tfPersonalPhone.setText("");
        tfHomePhone.setText("");
        tfAddress.setText("");
        tfPostalcode.setText("");
        tfBasicSalary.setText("");
        tfJobtitle.setText("");
        tfStatus.setText("");
        ((JTextField)dcDateHired.getDateEditor().getUiComponent()).setText("");
        ImageIcon icon = new ImageIcon("src\\Image\\defaultprofile.png");
        lblImage.setIcon(icon);
    }
    
    public boolean checkTextField(){
        String firstName = tfFirstname.getText();
        String lastName = tfLastname.getText();
        String middleName = tfMiddlename.getText();
        String dob = ((JTextField)dcDob.getDateEditor().getUiComponent()).getText();
        String email = tfEmail.getText();
        String pp = tfPersonalPhone.getText();
        String hp = tfHomePhone.getText();
        String address = tfAddress.getText();
        String pc = tfPostalcode.getText();
        String jobTitle = tfJobtitle.getText();
        String status = tfStatus.getText();
        String bs = tfBasicSalary.getText();
        String dateHired = ((JTextField)dcDateHired.getDateEditor().getUiComponent()).getText();
        
        
        if(!firstName.equals("") && !lastName.equals("") && !middleName.equals("") && !dob.equals("") &&
           !email.equals("") && !pp.equals("") && !hp.equals("") && !address.equals("") && !pc.equals("") && 
           !jobTitle.equals("") && !status.equals("") && !bs.equals("") && !dateHired.equals("")){
            return true;
        }else{
            return false;
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        lblAdminId = new javax.swing.JLabel();
        btnHome = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tfSearch = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        btnAttach = new javax.swing.JButton();
        tfBasicSalary = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        tfJobtitle = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        tfStatus = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        btnAddrecord = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        dcDateHired = new com.toedter.calendar.JDateChooser();
        jLabel17 = new javax.swing.JLabel();
        lblImage = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tfEmpId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfFirstname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfLastname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfMiddlename = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        rbMale = new javax.swing.JRadioButton();
        rbFemale = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tfPersonalPhone = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tfHomePhone = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tfAddress = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        tfPostalcode = new javax.swing.JTextField();
        dcDob = new com.toedter.calendar.JDateChooser();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Employee Information");
        setResizable(false);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(null);

        jLabel16.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel16.setText("Admin logged in:");
        jPanel3.add(jLabel16);
        jLabel16.setBounds(778, 30, 120, 30);

        lblAdminId.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jPanel3.add(lblAdminId);
        lblAdminId.setBounds(900, 30, 30, 30);

        btnHome.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnHome.setText("HOME");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });
        jPanel3.add(btnHome);
        btnHome.setBounds(80, 30, 90, 30);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel1.setText("Search:");
        jPanel3.add(jLabel1);
        jLabel1.setBounds(269, 30, 60, 30);

        tfSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfSearchKeyReleased(evt);
            }
        });
        jPanel3.add(tfSearch);
        tfSearch.setBounds(330, 30, 260, 30);

        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel9.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 21, -1, -1));

        btnAttach.setBackground(new java.awt.Color(238, 238, 238));
        btnAttach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/add-image.png"))); // NOI18N
        btnAttach.setBorder(null);
        btnAttach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAttachActionPerformed(evt);
            }
        });
        jPanel9.add(btnAttach, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 50, 50));
        jPanel9.add(tfBasicSalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 280, 30));

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel13.setText("Job title:");
        jPanel9.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, 30));
        jPanel9.add(tfJobtitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 280, 30));

        jLabel14.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel14.setText("Status:");
        jPanel9.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, -1, 30));
        jPanel9.add(tfStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 280, 30));

        jLabel15.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel15.setText("Date hired:");
        jPanel9.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, 30));

        btnAddrecord.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        btnAddrecord.setText("ADD RECORD");
        btnAddrecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddrecordActionPerformed(evt);
            }
        });
        jPanel9.add(btnAddrecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 430, 130, 38));

        btnUpdate.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel9.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 490, 130, 38));

        btnClear.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        btnClear.setText("CLEAR");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel9.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 430, 130, 38));

        btnDelete.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        btnDelete.setText("DELETE");
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMouseClicked(evt);
            }
        });
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel9.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 490, 130, 38));

        dcDateHired.setPreferredSize(new java.awt.Dimension(64, 24));
        jPanel9.add(dcDateHired, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, 280, 30));

        jLabel17.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel17.setText("Basic salary:");
        jPanel9.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, 30));

        lblImage.setBackground(new java.awt.Color(255, 255, 255));
        lblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/defaultprofile.png"))); // NOI18N
        lblImage.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel9.add(lblImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 220, 190));

        jPanel3.add(jPanel9);
        jPanel9.setBounds(560, 110, 400, 560);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel2.setText("Employee ID:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, 30));
        jPanel2.add(tfEmpId, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 274, 30));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel3.setText("Firstname:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 66, -1, 35));
        jPanel2.add(tfFirstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 274, 30));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel4.setText("Lastname:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 119, -1, 30));
        jPanel2.add(tfLastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 274, 30));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel5.setText("Middlename:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 167, -1, 30));
        jPanel2.add(tfMiddlename, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 274, 30));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel6.setText("Date of birth:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, -1, 30));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel7.setText("Gender:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, -1, 30));

        rbMale.setText("Male");
        rbMale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMaleActionPerformed(evt);
            }
        });
        jPanel2.add(rbMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, -1, 30));

        rbFemale.setText("Female");
        rbFemale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbFemaleActionPerformed(evt);
            }
        });
        jPanel2.add(rbFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, -1, 30));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel8.setText("E-mail:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, -1, 30));
        jPanel2.add(tfEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, 274, 30));

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel9.setText("Personal phone no.:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, 30));
        jPanel2.add(tfPersonalPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, 274, 30));

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel10.setText("Home phone no.:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, -1, 30));
        jPanel2.add(tfHomePhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 410, 274, 30));

        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel11.setText("Address:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 460, -1, 30));
        jPanel2.add(tfAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 460, 274, 30));

        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel12.setText("Postal code:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 510, -1, 30));

        tfPostalcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPostalcodeActionPerformed(evt);
            }
        });
        jPanel2.add(tfPostalcode, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 510, 274, 30));
        jPanel2.add(dcDob, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 274, 30));

        jPanel3.add(jPanel2);
        jPanel2.setBounds(80, 100, 450, 560);

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel3.add(jSeparator1);
        jSeparator1.setBounds(80, 80, 880, 20);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1013, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        clearTextField();
        Employee empForm = new Employee();
        this.hide();
        empForm.show();
        
    }//GEN-LAST:event_btnHomeActionPerformed

    private void tfSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSearchKeyReleased
        String search = tfSearch.getText();
        
        if(!search.equals("")){
            try{
                String query = "SELECT * FROM employee_info WHERE id=?";
                pst = con.prepareStatement(query);
                pst.setString(1, search);
                rs = pst.executeQuery();

                if(rs.next()){
                    String id = rs.getString("id");
                    tfEmpId.setText(id);

                    String firstname = rs.getString("firstname");
                    tfFirstname.setText(firstname);

                    String lastname = rs.getString("lastname");
                    tfLastname.setText(lastname);

                    String middlename = rs.getString("middlename");
                    tfMiddlename.setText(middlename);

                    String dob = rs.getString("dob");
                    ((JTextField)dcDob.getDateEditor().getUiComponent()).setText(dob);

                    // set radio button based on retrieved gender
                    String gen = rs.getString("gender");
                    if(gen.equals("Male")){
                        rbMale.setSelected(true);
                        rbFemale.setSelected(false);
                    }else{
                        rbFemale.setSelected(true);
                        rbMale.setSelected(false);
                    }

                    String email = rs.getString("email");
                    tfEmail.setText(email);

                    String pPhone = rs.getString("personal_phone");
                    tfPersonalPhone.setText(pPhone);

                    String hPhone = rs.getString("home_phone");
                    tfHomePhone.setText(hPhone);

                    String address = rs.getString("address");
                    tfAddress.setText(address);

                    String postalCode = rs.getString("postalcode");
                    tfPostalcode.setText(postalCode);

                    String basicSalary = rs.getString("basic_salary");
                    tfBasicSalary.setText(basicSalary);

                    String jobTitle = rs.getString("jobtitle");
                    tfJobtitle.setText(jobTitle);

                    String status = rs.getString("status");
                    tfStatus.setText(status);

                    String dateHired = rs.getString("date_hired");
                    ((JTextField)dcDateHired.getDateEditor().getUiComponent()).setText(dateHired);

                    byte[] image = rs.getBytes("image");
                    ImageIcon imageIcon = new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH));
                    lblImage.setIcon(imageIcon);
                }    
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        }else{
            clearTextField();
        }
        
    }//GEN-LAST:event_tfSearchKeyReleased

    private void tfPostalcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPostalcodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPostalcodeActionPerformed

    private void rbFemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbFemaleActionPerformed
        gender = "Female";
        rbFemale.setSelected(true);
        rbMale.setSelected(false);
    }//GEN-LAST:event_rbFemaleActionPerformed

    private void rbMaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMaleActionPerformed
        gender = "Male";
        rbMale.setSelected(true);
        rbFemale.setSelected(false);
    }//GEN-LAST:event_rbMaleActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if(!(tfSearch.getText().equals(""))){
            int x = JOptionPane.showConfirmDialog(null, "Are you sure to delete the employee information?", "Delete data", JOptionPane.YES_NO_OPTION);
            if(x == 0){
                try{
                    String query = "DELETE FROM employee_info WHERE id=?";

                    pst = con.prepareStatement(query);
                    pst.setString(1, tfEmpId.getText());
                    pst.execute();

                    try{
                        // Retrieve admin_id and admin_name that will match to the inputted username in login form
                        String query2 = "SELECT * FROM `accounts` WHERE id=?";
                        pst = con.prepareStatement(query2);
                        pst.setString(1, lblAdminId.getText());
                        rs = pst.executeQuery();

                        if(rs.next()){
                            // Get current time and date
                            Calendar cal = new GregorianCalendar();
                            int month = cal.get(Calendar.MONTH);
                            int year = cal.get(Calendar.YEAR);
                            int day = cal.get(Calendar.DAY_OF_MONTH);

                            int second = cal.get(Calendar.SECOND);
                            int minute = cal.get(Calendar.MINUTE);
                            int hour = cal.get(Calendar.HOUR);

                            // retrieved data
                            String adminId = rs.getString("id");
                            String adminName = rs.getString("name");
                            String date = ((month+1)+"/"+day+"/"+year);
                            String time = ((hour+00)+":"+(minute+00)+":"+(second+00));

                            // for description
                            String desc = "Deleted information. Emp name: "+tfFirstname.getText()+" "+tfLastname.getText();

                            // Insert retrieved data into account login
                            String query3 = "INSERT INTO `account_login`(`admin_id`, `admin_name`, `login_date`, `login_time`, `description`) VALUES (?, ?, ?, ?, ?)";
                            pst = con.prepareStatement(query3);
                            pst.setString(1, adminId);
                            pst.setString(2, adminName);
                            pst.setString(3, date);
                            pst.setString(4, time);
                            pst.setString(5, desc);

                            pst.execute();

                            clearTextField();

                            JOptionPane.showMessageDialog(null, "Employee information deleted");
                        }
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null, e);
                    }
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
                }
            }  
        }else{
                JOptionPane.showMessageDialog(null, "No employee information is displayed.");
        }  
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnDeleteMouseClicked

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clearTextField();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int x = JOptionPane.showConfirmDialog(null, "Are you sure you want to update the employee information?", "Update data", JOptionPane.YES_NO_OPTION);
        if(x == 0){
            if(checkTextField() == true){
                try{
                    String idEmp = tfEmpId.getText();
                    String fname = tfFirstname.getText();
                    String lname = tfLastname.getText();
                    String mname = tfMiddlename.getText();
                    String dob = ((JTextField)dcDob.getDateEditor().getUiComponent()).getText();
                    String email = tfEmail.getText();
                    String personalPhone = tfPersonalPhone.getText();
                    String homePhone = tfHomePhone.getText();
                    String address = tfAddress.getText();
                    String postalcode = tfPostalcode.getText(); 
                    String basicSalary = tfBasicSalary.getText();
                    String jobtitle = tfJobtitle.getText();
                    String status = tfStatus.getText();
                    String dateHired = ((JTextField)dcDateHired.getDateEditor().getUiComponent()).getText();

                    String query = "UPDATE employee_info SET id='"+idEmp+"', firstname='"+fname+"', lastname='"+lname+"', middlename='"+mname+"', dob='"+dob+"',"
                    + " gender='"+gender+"', email='"+email+"', personal_phone='"+personalPhone+"', home_phone='"+homePhone+"', address='"+address+"', postalcode='"+postalcode+"',"
                    + "basic_salary='"+basicSalary+"', jobtitle='"+jobtitle+"', status='"+status+"', date_hired='"+dateHired+"' WHERE id='"+idEmp+"' ";
                    pst = con.prepareStatement(query);
                    pst.execute();
                    JOptionPane.showMessageDialog(null, "Employee information updated!");

                    try{
                        // Retrieve admin_id and admin_name that will match to the inputted username in login form
                        String query2 = "SELECT * FROM `accounts` WHERE id=?";
                        pst = con.prepareStatement(query2);
                        pst.setString(1, lblAdminId.getText());
                        rs = pst.executeQuery();

                        if(rs.next()){
                            // Get current time and date
                            Calendar cal = new GregorianCalendar();
                            int month = cal.get(Calendar.MONTH);
                            int year = cal.get(Calendar.YEAR);
                            int day = cal.get(Calendar.DAY_OF_MONTH);

                            int second = cal.get(Calendar.SECOND);
                            int minute = cal.get(Calendar.MINUTE);
                            int hour = cal.get(Calendar.HOUR);

                            // retrieved data
                            String adminId = rs.getString("id");
                            String adminName = rs.getString("name");
                            String date = ((month+1)+"/"+day+"/"+year);
                            String time = ((hour+00)+":"+(minute+00)+":"+(second+00));
                            
                            try{
                                String query3 = "SELECT firstname, lastname FROM employee_info WHERE id=?";
                                pst = con.prepareStatement(query3);
                                pst.setString(1, tfEmpId.getText());
                                rs = pst.executeQuery();
                                
                                rs.next();
                                
                                String name = rs.getString("firstname") +" "+rs.getString("lastname");
                                // for description
                                String desc = "Updated information. Emp name: "+name;

                                // Insert retrieved data into account login
                                String query4 = "INSERT INTO `account_login`(`admin_id`, `admin_name`, `login_date`, `login_time`, `description`) VALUES (?, ?, ?, ?, ?)";
                                pst = con.prepareStatement(query4);
                                pst.setString(1, adminId);
                                pst.setString(2, adminName);
                                pst.setString(3, date);
                                pst.setString(4, time);
                                pst.setString(5, desc);

                                pst.execute();
                                
                            }catch(Exception e){
                                JOptionPane.showMessageDialog(null, e);
                            }
                        }

                    }catch(Exception e){

                    }
                }catch(Exception e){

                }
                try{
                    // Update image
                    File image = new File(filename);
                    FileInputStream fix = new FileInputStream(image);
                    byte[] buf = new byte[(int)image.length()];
                    fix.read(buf);

                    String query = "UPDATE employee_info SET image=? WHERE id='"+tfEmpId.getText()+"' " ;

                    pst = con.prepareStatement(query);
                    pst.setBytes(1, buf);
                    pst.executeUpdate();
                    pst.close();

                }catch(Exception e){

                }
            }else{
                JOptionPane.showMessageDialog(null, "Please complete the information.");
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnAddrecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddrecordActionPerformed
        String firstName = tfFirstname.getText();
        String lastName = tfLastname.getText();
        String middleName = tfMiddlename.getText();
        String dob = ((JTextField)dcDob.getDateEditor().getUiComponent()).getText();
        String email = tfEmail.getText();
        String pp = tfPersonalPhone.getText();
        String hp = tfHomePhone.getText();
        String address = tfAddress.getText();
        String pc = tfPostalcode.getText();
        String jobTitle = tfJobtitle.getText();
        String status = tfStatus.getText();
        String bs = tfBasicSalary.getText();
        String dateHired = ((JTextField)dcDateHired.getDateEditor().getUiComponent()).getText();
        
        int x = JOptionPane.showConfirmDialog(null, "Are you sure you want to add the employee information?", "Add data", JOptionPane.YES_NO_OPTION);
        if(x == 0){
            if(checkTextField() == true){    
                try{
                    System.out.println(dob.length());
                    String query1  = "SELECT * FROM employee_info WHERE firstname=? AND middlename=? AND lastname=?";
                    pst = con.prepareStatement(query1);
                    pst.setString(1, firstName);
                    pst.setString(2, middleName);
                    pst.setString(3, lastName);
                    rs = pst.executeQuery();

                    if(rs.next()){
                        JOptionPane.showMessageDialog(null, "Employee information already exists in the database.");
                    }
                    else{
                        try{
                            String query = "INSERT INTO employee_info (firstname, lastname, middlename, dob, gender, email, personal_phone, home_phone, address, postalcode, jobtitle, status, basic_salary, date_hired, image) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                            pst = con.prepareStatement(query);
                            pst.setString(1, firstName);
                            pst.setString(2, lastName);
                            pst.setString(3, middleName);
                            pst.setString(4, dob);
                            pst.setString(5, gender);
                            pst.setString(6, email);
                            pst.setString(7, pp);
                            pst.setString(8, hp);
                            pst.setString(9, address);
                            pst.setString(10, pc);
                            pst.setString(11, jobTitle);
                            pst.setString(12, status);
                            pst.setString(13, bs);
                            pst.setString(14, dateHired);
                            pst.setBytes(15, person_image);

                            pst.execute();
                            JOptionPane.showMessageDialog(null, "Employee information saved!");
                            
                            try{
                                // Retrieve admin_id and admin_name that will match to the inputted username in login form
                                String query2 = "SELECT * FROM `accounts` WHERE id=?";
                                pst = con.prepareStatement(query2);
                                pst.setString(1, lblAdminId.getText());
                                rs = pst.executeQuery();

                                if(rs.next()){
                                    // Get current time and date
                                    Calendar cal = new GregorianCalendar();
                                    int month = cal.get(Calendar.MONTH);
                                    int year = cal.get(Calendar.YEAR);
                                    int day = cal.get(Calendar.DAY_OF_MONTH);

                                    int second = cal.get(Calendar.SECOND);
                                    int minute = cal.get(Calendar.MINUTE);
                                    int hour = cal.get(Calendar.HOUR);

                                    // retrieved data
                                    String adminId = rs.getString("id");
                                    String adminName = rs.getString("name");
                                    String date = ((month+1)+"/"+day+"/"+year);
                                    String time = ((hour+00)+":"+(minute+00)+":"+(second+00));
                                    
                                    // for description
                                    String desc = "Added information. Emp name: "+tfFirstname.getText()+" "+tfLastname.getText();

                                    // Insert retrieved data into account login
                                    String query3 = "INSERT INTO `account_login`(`admin_id`, `admin_name`, `login_date`, `login_time`, `description`) VALUES (?, ?, ?, ?, ?)";
                                    pst = con.prepareStatement(query3);
                                    pst.setString(1, adminId);
                                    pst.setString(2, adminName);
                                    pst.setString(3, date);
                                    pst.setString(4, time);
                                    pst.setString(5, desc);

                                    pst.execute();
                                }    
                            }catch(Exception e){
                                JOptionPane.showMessageDialog(null, e);
                            }
                        }catch(Exception e){
                            JOptionPane.showMessageDialog(null, e);
                        }
                    }    
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Please complete the information.");
            }
    }//GEN-LAST:event_btnAddrecordActionPerformed
}
    private void btnAttachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAttachActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();

        filename = f.getAbsolutePath();
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_DEFAULT));
        lblImage.setIcon(imageIcon);

        try{

            File image = new File(filename);
            FileInputStream fix = new FileInputStream(image);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];

            for(int number; (number = fix.read(buf)) != -1;){
                bos.write(buf, 0, number);
            }
            person_image = bos.toByteArray();
            
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_btnAttachActionPerformed

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
            java.util.logging.Logger.getLogger(EmployeeInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeInfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddrecord;
    private javax.swing.JButton btnAttach;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnUpdate;
    private com.toedter.calendar.JDateChooser dcDateHired;
    private com.toedter.calendar.JDateChooser dcDob;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAdminId;
    private javax.swing.JLabel lblImage;
    private javax.swing.JRadioButton rbFemale;
    private javax.swing.JRadioButton rbMale;
    private javax.swing.JTextField tfAddress;
    private javax.swing.JTextField tfBasicSalary;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfEmpId;
    private javax.swing.JTextField tfFirstname;
    private javax.swing.JTextField tfHomePhone;
    private javax.swing.JTextField tfJobtitle;
    private javax.swing.JTextField tfLastname;
    private javax.swing.JTextField tfMiddlename;
    private javax.swing.JTextField tfPersonalPhone;
    private javax.swing.JTextField tfPostalcode;
    private javax.swing.JTextField tfSearch;
    private javax.swing.JTextField tfStatus;
    // End of variables declaration//GEN-END:variables
    
    String filename = null;
    byte[] person_image = null;
    private String gender;
}
