import java.util.ArrayList;

public class RelationInfo {
  private String nom_relation;
  private int nb_colonne;
  private ArrayList<ColInfo> colonne;

  public RelationInfo RelationInfo(String nom,int nb){
    nom_relation=nom;
    nb_colonne=nb;
    
  }
  
  
  
  public void Set_NomRelation(String nom) {
    nom_relation = nom;
  }

  public String get_NomRelation() {
    return nom_relation;
  }

  public int get_NbColonne() {
    return nb_colonne;
  }


}