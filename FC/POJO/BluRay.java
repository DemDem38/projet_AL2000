package FC.POJO;
public class BluRay extends Support{

    public BluRay(int id, int filmID) {
        this.supportID = id;
        this.filmID = filmID;
    }

    @Override
    public String toSQL() {
        return super.toSQL() + "BluRay";
    }

    @Override
    public String toString() {
        return "BluRay : " + super.toString();
    }
}
