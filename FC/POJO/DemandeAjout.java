package FC.POJO;

public class DemandeAjout {
    protected int abonneID;
    protected String nomFilm;
    public DemandeAjout(int abonneID, String nomFilm) {
        this.abonneID = abonneID;
        this.nomFilm = nomFilm;
    }
    public int getAbonneID() {
        return abonneID;
    }
    public void setAbonneID(int abonneID) {
        this.abonneID = abonneID;
    }
    public String getNomFilm() {
        return nomFilm;
    }
    public void setNomFilm(String nomFilm) {
        this.nomFilm = nomFilm;
    }
}
