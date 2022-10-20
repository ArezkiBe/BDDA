
public class ColInfo {
  private String nom;
  private String type;

  // Constructeur
  private ColInfo(String nom, String type) {
    this.nom = nom;
    this.type = type;
  }

  public void SetNom(String nom) {
    this.nom = nom;
  }

  public void SetType(String type) {
    this.type = type;
  }

  public String getNom() {
    return nom;
  }

  public String getType() {
    return type;
  }

}