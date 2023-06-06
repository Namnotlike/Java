/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TTC
 */
public class DBContext {
    private Connection conn = null;

//    public DBContext() {
//        try {
//            String user = "sa";
//            String password = "123456789";
//            String url = "jdbc:sqlserver://localhost\\NAM_PHAM:1433;databaseName=qlsp";
//            Class.forName("com.microsoft.sqlsever.jdbc.SQLServerDriver");
//            conn = DriverManager.getConnection(url, user, password);
//        } catch (ClassNotFoundException | SQLException ex) {
//            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
//        }    
        public DBContext() {
        try {
        String IP="localhost";
        String instanceName="NAM_PHAM";
        String port="1433";
        String uid="sa";
        String pwd="12345";
        String db="qlsp";
        String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url="jdbc:sqlserver://" +IP+"\\"+ instanceName+":"+port
                 +";databasename="+db+";user="+uid+";password="+pwd;
        Class.forName(driver);
        conn=DriverManager.getConnection(url);       
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection coon) {
        this.conn = coon;
    }
    
    public void close() throws SQLException{
        if (conn != null) {
            conn.close();
        }
    }
}
