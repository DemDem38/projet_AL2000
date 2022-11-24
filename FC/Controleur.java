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
            case "BluRayRendu":
                break;
            case "BluRayDefectueux":
                break;
            case "Abonnement":
                System.out.println(c.getNom());
                System.out.println(c.getPrenom());
                System.out.println(c.getLogin());
                System.out.println(c.getPassword());
                System.out.println(c.getAdresse());
                break;
            default:
                return false;
        }
        return true;
    }    
}
