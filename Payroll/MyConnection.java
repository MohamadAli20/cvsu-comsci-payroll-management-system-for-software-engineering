package Payroll;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class MyConnection {
    
    public static Connection getConnection(){
        
        
         
        String jdbcURL = "jdbc:h2:./database/company_db";
        String username = "sa";
        String password = "1";
        
        Connection con;
        try{
            Class.forName("org.h2.Driver");
            con = DriverManager.getConnection(jdbcURL, username, password);
            return con;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
        
    }

}
