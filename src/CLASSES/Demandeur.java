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
public class Demandeur {
    Connexion cnx= new Connexion();

    public String getNumeroId() {
        return NumeroId;
    }

    public void setNumeroId(String NumeroId) {
        this.NumeroId = NumeroId;
    }

    public String getNomDem() {
        return NomDem;
    }

    public void setNomDem(String NomDem) {
        this.NomDem = NomDem;
    }

    public String getPostnomDem() {
        return PostnomDem;
    }

    public void setPostnomDem(String PostnomDem) {
        this.PostnomDem = PostnomDem;
    }

    public String getPrenomDem() {
        return PrenomDem;
    }

    public void setPrenomDem(String PrenomDem) {
        this.PrenomDem = PrenomDem;
    }

    public String getSexeDem() {
        return SexeDem;
    }

    public void setSexeDem(String SexeDem) {
        this.SexeDem = SexeDem;
    }

    public String getStatutDem() {
        return StatutDem;
    }

    public void setStatutDem(String StatutDem) {
        this.StatutDem = StatutDem;
    }

    public String getDateDem() {
        return DateDem;
    }

    public void setDateDem(String DateDem) {
        this.DateDem = DateDem;
    }

    public String getComptableReference() {
        return ComptableReference;
    }

    public void setComptableReference(String ComptableReference) {
        this.ComptableReference = ComptableReference;
    }
    String NumeroId , NomDem,PostnomDem, PrenomDem, SexeDem,StatutDem,DateDem,ComptableReference;
    
     public void AjouterDemandeur (){
      try {
          String req = "insert into demandeur(numeroId,nomdem,postnomdem,prenomdem,sexedem,statut,date,comptabledemandeur) values ('"+getNumeroId()+"','"+getNomDem()+"','"+getPostnomDem()+"','"+getPrenomDem()+"','"+getSexeDem()+"','"+getStatutDem()+"','"+getDateDem()+"','"+getComptableReference()+"') ";
          cnx.mis_a_jour(req);
      } catch (Exception e) {
          System.out.println("ERROR:"+e.getMessage());
      }
  
  }
     public void RemplirDemandeur (JTable jt ,String req){
      try {
          //Nombre de ligne 
          int ligne = 0;
          cnx.selection(req);
          while (cnx.Rs.next()) {              
              ligne++;
          }
          //Mettre les donnees dans un tableau
          
          Object data [][] = new Object[ligne][8];
          ligne =0;
          cnx.selection(req);
          while (cnx.Rs.next()) {              
             data [ligne][0]= cnx.Rs.getString(1);
             data [ligne][1]= cnx.Rs.getString(2);
             data [ligne][2]= cnx.Rs.getString(3);
             data [ligne][3]= cnx.Rs.getString(4);
              data [ligne][4]= cnx.Rs.getString(5);
              data [ligne][5]= cnx.Rs.getString(6);
              data [ligne][6]= cnx.Rs.getString(7);
              data [ligne][7]= cnx.Rs.getString(8);
              
             ligne++;
          }
          
          //Mettre les titres 
          
          String titre []= {"NUMERO ID","NOM","POSTNOM","PRENOM","SEXE","STATUT","DATE","MATRICULE COMPTABLE"};
          jt.setModel(new DefaultTableModel(data,titre));
      } catch (Exception e) {
          System.out.println("ERROR:"+e.getMessage());
      }
  } 
    
    
}
