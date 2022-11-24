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
        // TODO Auto-generated method stub
        return false;
    }    
}
