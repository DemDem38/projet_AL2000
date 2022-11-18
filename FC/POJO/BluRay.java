package FC.POJO;
public class BluRay extends Support{

    public BluRay(int id, String nf) {
        this.ID = id;
        this.nomFilm = nf;
    }

    @Override
    public String toString() {
        return "BluRay : " + super.toString();
    }
}
