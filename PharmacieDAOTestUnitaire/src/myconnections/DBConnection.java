/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myconnections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.PropertyResourceBundle;

/**
 *
 * @author huggy
 */
public class DBConnection {
    private static Connection dbConnect = null;

  private DBConnection(){}   
     
     
     
     public static Connection getConnection() {
        if (dbConnect!=null)return dbConnect;
        PropertyResourceBundle properties = 
                (PropertyResourceBundle) PropertyResourceBundle.getBundle("resources.application");
        String serverName = properties.getString("cours.DB.server");
        String dbName = properties.getString("cours.DB.database");
        String username = properties.getString("cours.DB.login");
        String password = properties.getString("cours.DB.password");
        String dbPort = properties.getString("cours.DB.port");
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            String url = "jdbc:oracle:thin:@//" + serverName + ":" + dbPort + "/" + dbName;
            dbConnect = DriverManager.getConnection(url, username, password);
            return dbConnect;

        } catch (Exception e) {
            System.out.println("erreur de connexion " + e);
            e.printStackTrace();
            return null;
        }
    }
    
    public static void closeConnection(){
       
        try{
            
            dbConnect.close();
           
        }
        catch(Exception e){
            System.out.println("erreur de fermeture de connexion "+e);
                    
        }
         dbConnect=null;
     }

}
