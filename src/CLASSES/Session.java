/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLASSES;
import CONNEXION.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author shindano
 */
public class Session {
     Connexion cnx= new Connexion();
    String IndiceAnnee ,Libelle ;

    public String getIndiceAnnee() {
        return IndiceAnnee;
    }

    public void setIndiceAnnee(String IndiceAnnee) {
        this.IndiceAnnee = IndiceAnnee;
    }

    public String getLibelle() {
        return Libelle;
    }

    public void setLibelle(String Libelle) {
        this.Libelle = Libelle;
    }
     public void AjouterSession (){
      try {
          String req = "insert into sesssion(indiceAnnee,libelle) values ('"+getIndiceAnnee()+"','"+getLibelle()+"') ";
          cnx.mis_a_jour(req);
      } catch (Exception e) {
          System.out.println("ERROR:"+e.getMessage());
      }
  
  }
     
         public void RemplirSession (JTable jt ,String req){
      try {
          //Nombre de ligne 
          int ligne = 0;
          cnx.selection(req);
          while (cnx.Rs.next()) {              
              ligne++;
          }
          //Mettre les donnees dans un tableau
          
          Object data [][] = new Object[ligne][2];
          ligne =0;
          cnx.selection(req);
          while (cnx.Rs.next()) {              
             data [ligne][0]= cnx.Rs.getString(1);
             data [ligne][1]= cnx.Rs.getString(2);            
             ligne++;
          }
          
          //Mettre les titres 
          
          String titre []= {"ANNEE ACADEMIQUE","LIBELLE"};
          jt.setModel(new DefaultTableModel(data,titre));
      } catch (Exception e) {
          System.out.println("ERROR:"+e.getMessage());
      }
  } 
}
