package com.meession.common;


import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 
 
public class DBConnection { 
    // 瀹氫箟鏁版嵁搴撻┍鍔ㄧ▼搴� 1
    private static final String DBDRIVER = "com.mysql.jdbc.Driver"; 
    // 瀹氫箟鏁版嵁搴撹繛鎺ュ湴鍧� 
    
   // jdbc:mysql://localhost:3306/Peoples?autoReconnect=true&useSSL=false
    private static final String DBURL = "jdbc:mysql://localhost:3306/Timer?autoReconnect=true&useSSL=false"; 
    // 瀹氫箟鏁版嵁搴撹繛鎺ョ敤鎴峰�? 
    private static final String DBUSER = "root"; 
    // 瀹氫箟鏁版嵁搴撹繛鎺ュ瘑鐮� 
    private static final String DBPASS = "123456"; 
    private Connection conn = null; 
   
    public DBConnection() { 
        try { 
            // 鏁版嵁搴撳姞杞介┍鍔ㄧ▼搴� 
            Class.forName(DBDRIVER); 
        } catch (ClassNotFoundException e) { 
            e.printStackTrace(); 
        } 
 
        try { 
            // 鏁版嵁搴撹繛鎺� 
            conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS); 
        } catch (SQLException e) { 
            e.printStackTrace(); 
        } 
    } 
 
    public Connection getConnection() { 
        return this.conn; 
    } 
 
    public void close() { 
        if (this.conn != null) { 
            try { 
                this.conn.close(); 
            } catch (SQLException e) { 
                e.printStackTrace(); 
            } 
        } 
    } 
} 
