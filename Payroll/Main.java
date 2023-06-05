package Payroll;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {

    public static void main(String[] args) throws  IOException {
        
        LoginForm login = new LoginForm();
        login.show();
        
    }
    
    Connection con = MyConnection.getConnection();
    PreparedStatement pst;
    ResultSet rs;
    
    public static int adminId;
    public static String empId;
    
    public boolean checkUsername(String username){
        
        boolean checkUser = false;
        String query = "SELECT * FROM `accounts` WHERE username=?";
        
        try{
            pst = con.prepareStatement(query);
            pst.setString(1, username);
            
            rs = pst.executeQuery();
            
            if(rs.next()){
                checkUser = true;
            }
            
        }catch(Exception e){
//            JOptionPane.showMessageDialog(null, e);
        }
        return checkUser;
    }
    
    public boolean checkPassword(String password){
        
        boolean checkPass = false;
        String query = "SELECT * FROM `accounts` WHERE `password`=?";
        
        try{
           pst = con.prepareStatement(query);
           pst.setString(2, password);
           
           rs = pst.executeQuery();
           
           if(rs.next()){
               checkPass = true;
           }
            
        }catch(Exception e){
//            JOptionPane.showMessageDialog(null, e);
        }    
        return checkPass;    
    }
    

}
