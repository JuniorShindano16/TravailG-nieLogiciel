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
public class IndiceReleve {
    Connexion cnx= new Connexion();
    String DemandeReleve ,SessionReleve ;

    public String getDemandeReleve() {
        return DemandeReleve;
    }

    public void setDemandeReleve(String DemandeReleve) {
        this.DemandeReleve = DemandeReleve;
    }

    public String getSessionReleve() {
        return SessionReleve;
    }

    public void setSessionReleve(String SessionReleve) {
        this.SessionReleve = SessionReleve;
    }
    
     public void AjouterIndiceReleve (){
      try {
          String req = "insert into indicereleve(demandeurReleve,sessionReleve) values ('"+getDemandeReleve()+"','"+getSessionReleve()+"') ";
          cnx.mis_a_jour(req);
      } catch (Exception e) {
          System.out.println("ERROR:"+e.getMessage());
      }
  
  } 
     
         public void RemplirIndiceReleve (JTable jt ,String req){
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
          
          String titre []= {"NUMERO ID DEMANDEUR","ANNEE ACADEMIQUE"};
          jt.setModel(new DefaultTableModel(data,titre));
      } catch (Exception e) {
          System.out.println("ERROR:"+e.getMessage());
      }
  } 
}
