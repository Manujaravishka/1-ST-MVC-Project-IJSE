package edu.ijse.mvc.db;
 
 import java.sql.Connection;
 import java.sql.DriverManager;
 import java.sql.SQLException;
 
 /**
  *
  * @author anjana
  */
 public class DBConnaction {
     private static DBConnaction dBConnection;
     
     private Connection connaction;
     
     private DBConnaction() throws ClassNotFoundException, SQLException{
         Class.forName("com.mysql.cj.jdbc.Driver");
         connaction = DriverManager.getConnection("jdbc:mysql://localhost:3306/Supermarket", "root", "password");
     }
     
     public static DBConnaction getInstance()  throws ClassNotFoundException, SQLException{
         if(dBConnection == null){
             dBConnection = new DBConnaction();
         }
         return dBConnection;
     }
     
     public Connection getConnection(){
         return connaction;
     }
 }