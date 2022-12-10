package FC.POJO;

public class Location {
    protected String dateDebut,dateFin;
    protected int supportID, abonneID, locationID;
    Etat etat;

    public Location(int locationID, int supportID, String dd, String df, int abonneID, String etat) {
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

    public Location(int supportID, int abonneID) {
        this.supportID = supportID;
        this.abonneID = abonneID;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
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
        return supportID + ",'" + dateDebut + "','" + dateFin + "'," + abonneID + ",'" + etat + "'";
    }

    @Override
    public String toString() {
        return "locationID = " + locationID + 
        ", \nsupportID = " + supportID 
        + ", \ndateDebut = " + dateDebut 
        + ", \ndateFin = " + dateFin 
        + ", \nabonneID = " + abonneID
        + ", \netat = " + etat
        + "\n\n";
    }
}
