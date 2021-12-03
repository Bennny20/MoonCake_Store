/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phientq.utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author phien
 */
public class DBUtils implements Serializable{
    
    public static Connection makeConnect() throws ClassNotFoundException, SQLException{
        Connection con = null; 
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=LAB321_P0019_SE140851_2"; 
                      //"jdbc:sqlserver://localhost:1433;databaseName=userManagement"
        con = DriverManager.getConnection(url, "sa", "123");
        return con;
    }
}
