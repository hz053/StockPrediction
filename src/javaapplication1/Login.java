/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import sun.misc.BASE64Encoder;
import javax.swing.Timer;
import java.sql.Timestamp;
/**
 *
 * @author rasikh
 */
public class Login extends javax.swing.JFrame {
public Timer timer = null;
public static String user;
public static Timestamp time = new Timestamp(System.currentTimeMillis());
    /**
     * Creates new form Login
     */
     
    public Login() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
    }
    //String secretKey;
    twoFactor t = new twoFactor();
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelClose = new javax.swing.JLabel();
        jLabelMin = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        register = new javax.swing.JButton();
        submit = new javax.swing.JButton();

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("X");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(248, 148, 6));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Login");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 10, 51, 22);

        jLabelClose.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabelClose.setForeground(new java.awt.Color(255, 255, 255));
        jLabelClose.setText("X");
        jLabelClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelClose.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabelCloseMouseDragged(evt);
            }
        });
        jLabelClose.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jLabelCloseFocusGained(evt);
            }
        });
        jLabelClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCloseMouseClicked(evt);
            }
        });
        jPanel1.add(jLabelClose);
        jLabelClose.setBounds(375, 6, 12, 22);

        jLabelMin.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabelMin.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMin.setText("-");
        jLabelMin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMinMouseClicked(evt);
            }
        });
        jPanel1.add(jLabelMin);
        jLabelMin.setBounds(352, 6, 11, 22);

        jPanel2.setBackground(new java.awt.Color(44, 62, 80));
        jPanel2.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(236, 240, 241));
        jLabel5.setText("Password:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(30, 120, 130, 30);

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(236, 240, 241));
        jLabel6.setText("Username:");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(30, 70, 130, 30);

        username.setBackground(new java.awt.Color(108, 122, 137));
        username.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        username.setForeground(new java.awt.Color(228, 241, 254));
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        jPanel2.add(username);
        username.setBounds(130, 70, 210, 30);

        password.setBackground(new java.awt.Color(108, 122, 137));
        password.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        password.setForeground(new java.awt.Color(228, 241, 254));
        jPanel2.add(password);
        password.setBounds(130, 120, 210, 30);

        register.setBackground(new java.awt.Color(242, 38, 19));
        register.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        register.setForeground(new java.awt.Color(255, 255, 255));
        register.setText("Register");
        register.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        register.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerMouseClicked(evt);
            }
        });
        register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerActionPerformed(evt);
            }
        });
        jPanel2.add(register);
        register.setBounds(220, 190, 100, 40);

        submit.setBackground(new java.awt.Color(89, 171, 227));
        submit.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        submit.setForeground(new java.awt.Color(255, 255, 255));
        submit.setText("Submit");
        submit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        submit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                submitMouseClicked(evt);
            }
        });
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        jPanel2.add(submit);
        submit.setBounds(80, 190, 100, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public boolean searchuser(String user, String pass) {
        try {
            SetConnection conn = new SetConnection();
            Connection connect = SetConnection.conn;
            Statement stm = connect.createStatement();
            
            String sql = "select * from user where username='"+user+"' and password='"+pass+"'";
            
            ResultSet rs = stm.executeQuery(sql);
            if(rs.next()) {
                return true;
            }
            connect.close();
        }
        catch (Exception e) {}
        return false;
    }
    public static synchronized String encrypt(String plaintext, String algorithm, String encoding) throws Exception {
        MessageDigest msgDigest = null;
        String hashValue = null;
        try {
            msgDigest = MessageDigest.getInstance(algorithm);
            msgDigest.update(plaintext.getBytes(encoding));
            byte rawByte[] = msgDigest.digest();
            hashValue = (new BASE64Encoder()).encode(rawByte);
            
        } catch (NoSuchAlgorithmException e) {
            System.out.println("No Such Algorithm Exists");
        } catch (UnsupportedEncodingException e) {
            System.out.println("The encoding is not supported");
        }
        return hashValue;
    }
    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void jLabelCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabelCloseMouseClicked

    private void jLabelMinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinMouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabelMinMouseClicked

    private void jLabelCloseFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jLabelCloseFocusGained
        
    }//GEN-LAST:event_jLabelCloseFocusGained

    private void jLabelCloseMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseMouseDragged

    }//GEN-LAST:event_jLabelCloseMouseDragged

    private void registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerActionPerformed
        
    }//GEN-LAST:event_registerActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        
    }//GEN-LAST:event_submitActionPerformed

    private void registerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerMouseClicked
        Registration reg = new Registration();
        reg.setVisible(true);
        reg.pack();
        reg.setLocationRelativeTo(null);
        reg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_registerMouseClicked
    
    public boolean twofactoryes(String user) {
        try {
            SetConnection conn = new SetConnection();
            Connection connect = SetConnection.conn;
            Statement stm = connect.createStatement();
            
            String sql = "select * from user where username='"+user+"' and twofactor='YES'";
            
            ResultSet rs = stm.executeQuery(sql);
            if(rs.next()) {
                return true;
            }
            connect.close();
        }
        catch (Exception e) {}
        return false;
    }
    
    public String getsecretkey(String user) {
        try {
            SetConnection conn = new SetConnection();
            Connection connect = SetConnection.conn;
            Statement stm = connect.createStatement();
            
            String sql = "select secretkey from twofactor where user='"+user+"'";
            
            ResultSet rs = stm.executeQuery(sql);
            if(rs.next()) {
                return rs.getString("secretkey");
            }
            connect.close();
        }
        catch (Exception e) {}
        return "testing..";
    }
    
    public void verifywithsecretkey() {
           String next = JOptionPane.showInputDialog("Please enter 6 digits code for verification:");
                        if(next == null) {
                           
                        }
                else {
        //verification part
                    String lastCode = null;
                    while (true) {
                        String code = t.getTOTPCode(getsecretkey(username.getText()));
                            if (!code.equals(lastCode)) {
                // output a new 6 digit code
                                while (!next.equals(code)) {
                                    next = JOptionPane.showInputDialog("\t Incorrect code! Please try again: ");
                            if(next == null) {
                                break;
                            }
                           }
                    if(next!=null && next.equals(code)) {
                        JOptionPane.showMessageDialog(null, "Successfully verified for user: "+username.getText());
                        next = code;
                    //access to admin panel
                    if(username.getText().equalsIgnoreCase("admin")) {
                        System.out.println("admin...");
                        user = username.getText();
                        Admin adm = new Admin();
                        adm.setVisible(true);
                        adm.pack();
                        adm.setLocationRelativeTo(null);
                        adm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        this.dispose();
                        break;
                    }
                    else {
                        user = username.getText();
                        Main main = new Main();
                        main.setVisible(true);
                        main.pack();
                        main.setLocationRelativeTo(null);
                        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        this.dispose();
                        break;
                    }
                    }
                    else if(next == null) {
                        break;
                    }
            }
                lastCode = code;
            try {
            Thread.sleep(1000);
            } catch (InterruptedException e) {};
            }
                        }
                        
    }
    
    private void submitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitMouseClicked
            String p = password.getText();
            String ep = "";
            try {
                ep = ""+encrypt(p,"SHA-256","UTF-16").toString();
            }
            catch (Exception ex) {
               
            }
            
            if(!searchuser(username.getText(),ep)) {
                JOptionPane.showMessageDialog(null, "Could not login:\nCheck Username and Password");
            }
             else if(username.getText().equalsIgnoreCase("admin")){
                 if(twofactoryes("admin")) {
                    verifywithsecretkey();              
                }
                 else {
                     //access without 2 factor (disabled)
                     JOptionPane.showMessageDialog(null, "Warning! Low Security: 2 Factor is disabled");                        
                     user = username.getText();
                        Admin adm = new Admin();
                        adm.setVisible(true);
                        adm.pack();
                        adm.setLocationRelativeTo(null);
                        adm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        this.dispose();
                 }
            }
                 
            else {
                 if(twofactoryes(username.getText())) {
                    verifywithsecretkey();
                }
                 else {
                     JOptionPane.showMessageDialog(null, "Warning! Low Security: 2 Factor is disabled");
                        user = username.getText();        
                        Main main = new Main();
                        main.setVisible(true);
                        main.pack();
                        main.setLocationRelativeTo(null);
                        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        this.dispose();
                 }
            }
        
        /**/
    }//GEN-LAST:event_submitMouseClicked

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelClose;
    private javax.swing.JLabel jLabelMin;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField password;
    private javax.swing.JButton register;
    private javax.swing.JButton submit;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
