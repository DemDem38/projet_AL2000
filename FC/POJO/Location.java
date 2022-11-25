package FC.POJO;

import java.sql.Timestamp;

public class Location {
    protected Timestamp dateDebut,dateFin;
    protected int supportID, abonneID, locationID;
    Etat etat;

    public Location(int locationID, int supportID, Timestamp dd, Timestamp df, int abonneID, String etat) {
        this.locationID = locationID;
        this.supportID = supportID;
        dateDebut = dd;
        dateFin = df;
        this.abonneID = abonneID;
        switch(etat) {
            case "enCours":
                this.etat = Etat.enCours;
            break;
            case "Inspection":
                this.etat = Etat.Inspection;
            break;
            case "Termine":
                this.etat = Etat.Termine;
            break;
        }
    }

    public Timestamp getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Timestamp dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Timestamp getDateFin() {
        return dateFin;
    }

    public void setDateFin(Timestamp dateFin) {
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
    
    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    public String toSQL() {
        return supportID + "," + dateDebut + "," + dateFin + "," + abonneID + "," + etat;
    }

    @Override
    public String toString() {
        return "Location [dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", supportID=" + supportID + ", abonneID="
                + abonneID + ", locationID=" + locationID + ", etat=" + etat + "]";
    }
}
