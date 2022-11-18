package FC.POJO;
public abstract class Support {
    protected int ID;
    protected String nomFilm;
    @Override
    public String toString() {
        return "ID = " + ID + ", nomFilm = " + nomFilm + "\n\n";
    }
    
}
