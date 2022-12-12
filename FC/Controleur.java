package FC;

import FC.POJO.Etat;
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
                machine.connexion(c.getLogin(), c.getPassword());
                break;
            case "louer":
                System.out.println(c.getSupport());   
                machine.createLocation(c.getSupport());
                break;
            case "demandeBluRay":
                break;
            case "BluRayRendu":
                machine.updateLocation(c.getLocation(),Etat.Termine);
                break;
            case "BluRayDefectueux":
                machine.updateLocation(c.getLocation(),Etat.Inspection);
                break;
            case "abonnement":
                machine.abonner(c.getNom(), c.getPrenom(), c.getLogin(), c.getPassword(), c.getAdresse(), c.getTelephone(),c.getSolde());
                break;
            default:
                return false;
        }
        return true;
    }    
}
