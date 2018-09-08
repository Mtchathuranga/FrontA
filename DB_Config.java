/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbtest;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Mtchathuranga
 */
public class DB_Config {
    private static String url = "jdbc:mysql://localhost/test";    
    private static String driverName = "com.mysql.jdbc.Driver";   
    private static String username = "root";   
    private static String password = "";
    private static Connection con;
    private static String urlstring;
    private Statement st;
    private ResultSet rsltSt;
    private int rslt;
    private String Query;
    
    public static Connection getConnection() {
        try {            
            Class.forName(driverName);
            try {
                con = (Connection) DriverManager.getConnection(url, username, password);
            } catch (SQLException ex) {
                // log an exception. fro example:               
                System.out.println("Failed to create the database connection."); 
            }
        } catch (ClassNotFoundException ex) {
            // log an exception. for example:
            System.out.println("Driver not found."); 
        }
        return con;
    }
    
    public void openCon() throws SQLException
    {
            st = con.createStatement();
    }
    
    public void closeCon() throws SQLException
    {
            con.close();
    }
    
    public int Insert_Dlt_Update(String Query){
        try {
            openCon();
            rslt = st.executeUpdate(Query);           
            closeCon();
        } catch (Exception e) {            
            e.printStackTrace();
        }
        return rslt;    
    }
    
    public ResultSet getData(String Query){
        try {
            openCon();
            rsltSt = st.executeQuery(Query);
            while (rsltSt.next()) {                 
                             
            }
            closeCon();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsltSt;
    
    }
}
