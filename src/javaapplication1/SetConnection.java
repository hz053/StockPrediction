/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.*;
import java.util.HashSet;
import javax.swing.JOptionPane;
/**
 *
 * @author rasikh
 */
public class SetConnection {
    static Connection conn;
    
    String url = "jdbc:mysql://localhost:3306/project";
    String user = "root";
    String pass = "root";
    String driver = "com.mysql.jdbc.Driver";
    
    public SetConnection() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pass);
            System.out.println("Connected");
            
            
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Could not connect");
        }
    }
}   
