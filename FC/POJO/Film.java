package FC.POJO;

import java.util.Arrays;

public class Film {
    protected String nom,categorie,synopsis,realisateur;
    protected String[] acteurs;

    public Film(String n, String c, String s, String r, String[] a) {
        nom = n;
        categorie = c;
        synopsis = s;
        realisateur = r;
        acteurs = a;
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

    public String[] getActeurs() {
        return acteurs;
    }

    public void setActeurs(String[] acteurs) {
        this.acteurs = acteurs;
    }

    @Override
    public String toString() {
        return "nom = " + nom + 
        ", \ncategorie = " + categorie 
        + ", \nsynopsis = " + synopsis 
        + ", \nrealisateur = " + realisateur 
        + ", \nacteurs = " + Arrays.toString(acteurs)
        + "\n\n";
    }
    
    
}
