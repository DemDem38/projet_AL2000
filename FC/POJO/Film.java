package FC.POJO;
import java.util.List;

public class Film {
    protected String nom,categorie,synopsis,realisateur;
    protected List<String> acteur;

    public Film() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    public List<String> getActeur() {
        return acteur;
    }

    public void setActeur(List<String> acteur) {
        this.acteur = acteur;
    }
    
}
