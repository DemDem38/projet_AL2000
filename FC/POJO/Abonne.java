package FC.POJO;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Abonne
 */
public class Abonne {
    protected String nom,prenom,email,adresse,tel;
    private int mdp;
    protected ArrayList<String> restrictions;
    protected int solde, ID;

    public Abonne(int id, String n, String p, String e, String a, String t, ArrayList<String> r, int s, int mdp) {
        ID = id;
        nom = n;
        prenom = p;
        adresse = a;
        email = e;
        tel = t;
        this.mdp = mdp;
        solde = s;
        restrictions = r;
    }

    public Abonne(String n, String p, String e, String a, String t, ArrayList<String> r, int s, int mdp) {
        nom = n;
        prenom = p;
        adresse = a;
        email = e;
        tel = t;
        this.mdp = mdp;
        solde = s;
        restrictions = r;
    }
    /*Methodes */
     public void demanderFilm(Film film) {
        /* Permet de domander un film qui n'est pas dans le catalogue
         * Accès a la base de données pour vérifier que le film n'est pas présent
         * Pré-enregistrer la location de l'utilisateur actuel sur ce film ??
         */
     }

     public Location[] consulterHistorique() {
        /*Doit retourner une liste de location faites par l'utilisateur actuel
         * this
         * Acces a la base de données nécessaire
         */
        return null;
     }

     public void RetournerBluray(Film film,boolean defecteux) {
        /*
         * Permet a l'utilisateur de rendre une location qu'il a faite
         * en se basant sur le film qu'il met dans la machine
         * Accès base de donnée pour trouver la location (Via locationDAO ??)
         */
     }

     public void CreerCompteEnfant(String nom,String prenom, ArrayList<String> restriction){
        /*Permet de crée un compte enfant avec une liste de restrcition
         * Si un compte abonnée a une liste de restriction non vide alors
         * il est considérer comme un compte enfant, il ne peux donc
         * pas crée lui même un compte enfant 
         * TODO A VERFIER !!!
         */
     }

     /*Getteur et Setteur */
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
 
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getMdp() {
        return mdp;
    }

    public void setMdp(int mdp) {
        this.mdp = mdp;
    }

    public ArrayList<String> getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(ArrayList<String> restrictions) {
        this.restrictions = restrictions;
    }
    
    public int getSolde() {
        return solde;
    }
    public void setSolde(int solde) {
        this.solde = solde;
    }
    
    public String toSQL(){
        String s ="";
        s = "'" + nom + "','" + prenom + "','" + email + "','" + adresse + "','" + tel + "', '" + String.join(", ", restrictions) + "'," +  solde + "," + mdp;
        return s;
    }

    @Override
    public String toString() {
        return "ID = " + ID + "\nnom = " + nom + ", \nprenom = " + prenom + ", \nemail = " + email + ", \nadresse = " + adresse  + ", \ntel = "
                + tel + ", \nrestrictions = " + restrictions.toString() + ", \nsolde = " + solde + ", \nmdp = " + mdp + "\n\n";
    }
    public int getID() {
        return ID;
    }
    public void setID(int iD) {
        ID = iD;
    }
    
}