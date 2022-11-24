import FC.AL2000;
import FC.Controleur;
import UI.MainFrame;

public class Main {

    public static void main(String[] args) {
        AL2000 model = new AL2000();
        Controleur controleur = new Controleur(model);
        MainFrame.demarrer(model, controleur);
    }

}
