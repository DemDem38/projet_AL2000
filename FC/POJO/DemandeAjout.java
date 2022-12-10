package FC.POJO;

public class DemandeAjout {
    protected int demandeAjoutID, abonneID;
    protected int filmID;
    public DemandeAjout(int demandeAjoutID, int abonneID, int filmID) {
        this.demandeAjoutID = demandeAjoutID;
        this.abonneID = abonneID;
        this.filmID = filmID;
    }

    public DemandeAjout(int abonneID, int filmID) {
        this.abonneID = abonneID;
        this.filmID = filmID;
    }

    public int getDemandeAjoutID() {
        return demandeAjoutID;
    }
    public void setDemandeAjoutID(int demandeAjoutID) {
        this.demandeAjoutID = demandeAjoutID;
    }
    public int getAbonneID() {
        return abonneID;
    }
    public void setAbonneID(int abonneID) {
        this.abonneID = abonneID;
    }
    public int getfilmID() {
        return filmID;
    }
    public void setfilmID(int filmID) {
        this.filmID = filmID;
    }

    public String toSQL() {
        return abonneID + ", " + filmID;
    }

    @Override
    public String toString() {
        return "demandeAjoutID = " + demandeAjoutID + "\nabonneID = " + abonneID + ", \nfilmID = " + filmID;
    }
}
