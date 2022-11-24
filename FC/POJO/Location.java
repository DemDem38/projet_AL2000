package FC.POJO;
import java.sql.Date;

public class Location {
    protected Date dateDebut,dateFin;
    protected int supportID, abonneID;
    Etat etat;

    public Location(int supportID, int abonneID) {
        this.supportID = supportID;
        this.abonneID = abonneID;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public int getSupportID() {
        return supportID;
    }

    public void setSupportID(int supportID) {
        this.supportID = supportID;
    }

    public int getAbonneID() {
        return abonneID;
    }

    public void setAbonneID(int abonneID) {
        this.abonneID = abonneID;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }
}
