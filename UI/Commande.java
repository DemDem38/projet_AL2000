package UI;

public class Commande {
    private final String commande;
    private String login;
    private String password;
    private String support;

    public Commande(String commande){
        this.commande = commande;
    }

    public String getCommande() {
        return commande;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSupport() {
        return support;
    }

    public void setSupport(String support) {
        this.support = support;
    }
}
