package model;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;  
public class MyDatabase {  
      private  Connection con;  
      public Connection getCon() {  
            return con;  
      }  
      public MyDatabase(String dbUrl,String username,String password) {  
            try {  
                  this.con = DriverManager.getConnection(dbUrl,username,password);  
            } catch (SQLException e) {  
                  // TODO Auto-generated catch block  
                  e.printStackTrace();  
            }  
      }  
} 