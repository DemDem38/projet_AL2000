package FC;

import UI.CollecteurEvenements;
import UI.Commande;

public class Controleur implements CollecteurEvenements {
    AL2000 machine;
    public Controleur(AL2000 al2000) {
        machine = al2000;
    }

    @Override
    public boolean commande(Commande c) {
        System.out.println(c.getCommande());
        switch(c.getCommande()){
            case "connexion":
                System.out.println(c.getLogin());
                System.out.println(c.getPassword());
                break;
            case "louer":
                System.out.println(c.getSupport());
                break;
            case "demandeBluRay":
                break;
            default:
                return false;
        }
        return true;
    }    
}
