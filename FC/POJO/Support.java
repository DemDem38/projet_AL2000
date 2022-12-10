package FC.POJO;
public abstract class Support {
    protected int supportID;
    protected int filmID;
    @Override
    public String toString() {
        return "ID = " + supportID + ", filmID = " + filmID + "\n\n";
    }
    public int getFilmID() {
        return filmID;
    }
    public void setFilmID(int filmID) {
        this.filmID = filmID;
    }
    public abstract String toSQL();

    public int getSupportID() {
        return supportID;
    }
    public void setSupportID(int supportID) {
        this.supportID = supportID;
    }
}
