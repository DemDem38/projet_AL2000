package UI;

import javax.swing.SwingUtilities;

public class testUI implements Runnable {

    public void run() {
        mainFrame frame = new mainFrame();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new testUI());
    }
}
