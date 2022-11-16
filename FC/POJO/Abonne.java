package FC.POJO;
import java.util.Date;
import java.util.List;

/**
 * Abonne
 */
public class Abonne extends Client{
    protected String nom,prenom,adresse,email,tel;
    private String mdp; //TODO A modifier en HASH
    protected Date dateNaissance;
    protected List<String> restrictions;

     public Abonne() {
        
     }
     /*Methodes */
     public void demanderFilm(Film film) {
        /* Permet de domander un film qui n'est pas dans le catalogue
         * Accès a la base de données pour vérifier que le film n'est pas présent
         * Pré-enregistrer la location de l'utilisateur actuel sur ce film ??
         */
     }

     public List<Location> consulterHistorique() {
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

     public void CreerCompteEnfant(String nom,String prenom, List<String> restriction){
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

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public List<String> getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(List<String> restrictions) {
        this.restrictions = restrictions;
    }
    
}