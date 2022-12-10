package FC.POJO;
public class BluRay extends Support{

    public BluRay(int id, int filmID) {
        this.supportID = id;
        this.filmID = filmID;
    }

    public BluRay(int filmID) {
        this.filmID = filmID;
    }

    @Override
    public String toSQL() {
        return filmID + ", 'BluRay'," + null;
    }

    @Override
    public String toString() {
        return "BluRay : " + super.toString();
    }
}
