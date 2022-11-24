package UI;

import javax.swing.SwingUtilities;

public class testUI implements Runnable {

    public void run() {
        MainFrame frame = new MainFrame();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new testUI());
    }
}
