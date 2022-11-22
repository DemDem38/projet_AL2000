package FC;

import UI.collecteurEvenements;

public class Controleur implements collecteurEvenements {
    AL2000 machine;
    public Controleur(AL2000 al2000) {
        machine = al2000;
    }

    @Override
    public boolean commande(UI.commande c) {
        // TODO Auto-generated method stub
        return false;
    }    
}
