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