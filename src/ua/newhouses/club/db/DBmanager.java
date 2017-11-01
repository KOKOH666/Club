package ua.newhouses.club.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class DBmanager {

    private static Connection conn;
    private static InitialContext ic;
    private static DataSource ds;
	
	

    public static Connection getConnection() {
        try {
            ic = new InitialContext();
            ds = (DataSource) ic.lookup("java:comp/env/jdbc/Auto");
            conn = ds.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DBmanager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(DBmanager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return conn;
    }
     
}
