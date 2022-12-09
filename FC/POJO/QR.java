package FC.POJO;
import java.text.SimpleDateFormat;
import java.util.Date;

public class QR extends Support{
    protected String dateExpiration;

    public QR(int id, int filmID, String dateExpiration) {
        this.filmID = filmID;
        this.supportID = id;
        this.dateExpiration = dateExpiration;
    }

    public QR(int filmID) {
        this.filmID = filmID;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateExpiration = sdf.format(new Date(System.currentTimeMillis()+1000*60*60*12));
        // A la création, le QR code dure 12 heures
    }

    @Override
    public String toSQL() {
        return filmID + ", 'QRCode','" + dateExpiration + "'";
    }

    @Override
    public String toString() {
        return "QRCode : " + "dateExpiration : "+ dateExpiration + super.toString();
    }
    
}
