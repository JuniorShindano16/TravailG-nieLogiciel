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
public class Comptable {
      Connexion cnx= new Connexion();
    String Matricule , NomCompt,PostnomComt, PrenomCompt, SexeCompte;

    public String getMatricule() {
        return Matricule;
    }

    public void setMatricule(String Matricule) {
        this.Matricule = Matricule;
    }

    public String getNomCompt() {
        return NomCompt;
    }

    public void setNomCompt(String NomCompt) {
        this.NomCompt = NomCompt;
    }

    public String getPostnomComt() {
        return PostnomComt;
    }

    public void setPostnomComt(String PostnomComt) {
        this.PostnomComt = PostnomComt;
    }

    public String getPrenomCompt() {
        return PrenomCompt;
    }

    public void setPrenomCompt(String PrenomCompt) {
        this.PrenomCompt = PrenomCompt;
    }

    public String getSexeCompte() {
        return SexeCompte;
    }

    public void setSexeCompte(String SexeCompte) {
        this.SexeCompte = SexeCompte;
    }
  
 public void AjouterComptable (){
      try {
          String req = "insert into comptable(matricule,nom,postnom,prenom,sexe) values ('"+getMatricule()+"','"+getNomCompt()+"','"+getPostnomComt()+"','"+getPrenomCompt()+"','"+getSexeCompte()+"') ";
          cnx.mis_a_jour(req);
      } catch (Exception e) {
          System.out.println("ERROR:"+e.getMessage());
      }
  
  } 
  public void SupprimerComptable (){
       String req = "delete from enseignant where comptable='"+getMatricule()+"' ";
        cnx.mis_a_jour(req);
  }
         public void RemplirComptable (JTable jt ,String req){
      try {
          //Nombre de ligne 
          int ligne = 0;
          cnx.selection(req);
          while (cnx.Rs.next()) {              
              ligne++;
          }
          //Mettre les donnees dans un tableau
          
          Object data [][] = new Object[ligne][5];
          ligne =0;
          cnx.selection(req);
          while (cnx.Rs.next()) {              
             data [ligne][0]= cnx.Rs.getString(1);
             data [ligne][1]= cnx.Rs.getString(2);
             data [ligne][2]= cnx.Rs.getString(3);
             data [ligne][3]= cnx.Rs.getString(4);
              data [ligne][4]= cnx.Rs.getString(5);
             ligne++;
          }
          
          //Mettre les titres 
          
          String titre []= {"MATRICULE","NOM","POSTNOM","PRENOM","SEXE"};
          jt.setModel(new DefaultTableModel(data,titre));
      } catch (Exception e) {
          System.out.println("ERROR:"+e.getMessage());
      }
  }                   
    
}
