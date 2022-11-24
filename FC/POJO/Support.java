package FC.POJO;
public abstract class Support {
    protected int ID;
    protected String nomFilm;
    @Override
    public String toString() {
        return "ID = " + ID + ", nomFilm = " + nomFilm + "\n\n";
    }
    public int getID() {
        return ID;
    }
    public void setID(int iD) {
        ID = iD;
    }
    public String getNomFilm() {
        return nomFilm;
    }
    public void setNomFilm(String nomFilm) {
        this.nomFilm = nomFilm;
    }
    
    
}
