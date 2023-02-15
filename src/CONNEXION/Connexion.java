/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONNEXION;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author shindano
 */
public class Connexion {
    String url = "jdbc:mysql://localhost:3306/releves_distribution";
        String user = "root";
        String pwd = "";
        
        private Connection connec;
        private Statement cmd;
        public ResultSet Rs;
        
        public Connexion (){
            try {
                 connec = DriverManager.getConnection(url, user, pwd);
            } catch (Exception e) {
                System.out.println("ERROR:"+e.getMessage());
            }
        }
        
         public void mis_a_jour (String req ){
            
            try {
                cmd = connec.createStatement();
                cmd.execute(req);
                
            } catch (Exception e) {
                System.out.println("ERROR:"+e.getMessage());
            }
        }
        
        public void selection (String req){
            try {
                cmd = connec. createStatement();
                Rs = cmd.executeQuery(req);
            } catch (Exception e) {
                System.out.println("ERROR:"+e.getMessage());
            }
        }
        
        public Connection conx (){
        
        return connec;
        }

}
