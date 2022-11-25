package FC.POJO;
import java.util.Date;

public class QR extends Support{
    protected Date dateExpiration;

    public QR(int id) {
        this.supportID = id;
    }

    @Override
    public String toSQL() {
        return super.toSQL() + "QRCode";
    }
    
}
