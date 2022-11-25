package FC.POJO;

import java.util.ArrayList;
import java.util.Arrays;

public class Film {
    protected int filmID;
    protected String nom,categorie,synopsis,realisateur;
    protected ArrayList<String> acteurs;

    public Film(int id, String n, String c, String s, String r, ArrayList<String> a) {
        filmID = id;
        nom = n;
        categorie = c;
        synopsis = s;
        realisateur = r;
        acteurs = a;
    }
    public int getFilmID() {
        return filmID;
    }
    public void setFilmID(int id) {
        filmID = id;
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

    public ArrayList<String> getActeurs() {
        return acteurs;
    }

    public void setActeurs(ArrayList<String> acteurs) {
        this.acteurs = acteurs;
    }

    public String toSQL(){
        String s ="";
        s = nom + "," + categorie + "," + synopsis + "," + realisateur + "," + String.join(",", acteurs);
        return s;
    }

    @Override
    public String toString() {
        return "nom = " + nom + 
        ", \ncategorie = " + categorie 
        + ", \nsynopsis = " + synopsis 
        + ", \nrealisateur = " + realisateur 
        + ", \nacteurs = " + acteurs.toString()
        + "\n\n";
    }
}
