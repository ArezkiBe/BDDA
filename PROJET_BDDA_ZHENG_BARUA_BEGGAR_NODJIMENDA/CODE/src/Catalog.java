import java.util.ArrayList;

public final class Catalog {
  private ArrayList<RelationInfo> Tableau_Relation;
  private int Compteur_Relation;

  // CONSTRUCTEUR DE CATALOG (On part sur un constructeur par defaut donc pas
  // besoin de le definir):

  // On creer une instance unique de CATALOG
  public static Catalog Catalogue = new Catalog();

  // A COMPLETER PLUS TARD
  public void Init() {

  }

  // A COMPLETER PLUS TARD
  public void Finish() {

  }

  // AJOUTER UNE RELATION DANS LA LISTE
  public void AddRelationInfo(RelationInfo relation) {
    Tableau_Relation.add(relation);
    Compteur_Relation += 1;
  }

  public RelationInfo getRelation(String Nom_Relation) {
    for (int i = 0; i < Tableau_Relation.size(); i++) {
      if (Tableau_Relation.get(i).get_NomRelation().equals(Nom_Relation)){
        return Tableau_Relation.get(i);
      }
      
    }
  return null;
}