package gestionVoiture;

import javax.swing.SwingUtilities;
import view.HomePage;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new HomePage();
        });
    }
}
