/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbtest;
import com.mysql.jdbc.Connection;
import dbtest.DB_Config;
import java.sql.ResultSet;
/**
 *
 * @author Mtchathuranga
 */
public class DbTest {
    /**
     * @param args the command line arguments
     */
    private ResultSet rs;
    public static void main(String[] args) {
        
        // TODO code application logic here        
        DB_Config db = new DB_Config();
        Connection retCon = db.getConnection();
        System.out.println(retCon);
        System.out.println(db.getData("select * from table1"));
    }
    
}
