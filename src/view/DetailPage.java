package view;

import controller.ImageController;
import controller.VoitureController;
import model.Voiture;
import view.components.ImagePanel;

import javax.swing.*;
import java.awt.*;

public class DetailPage extends JFrame {

    public DetailPage(int voitureId) {
        setTitle("Détails de la voiture");
        setSize(600, 400);
        setLocationRelativeTo(null);

        VoitureController vc = new VoitureController();
        ImageController ic = new ImageController();
        Voiture v = vc.getVoitureById(voitureId);

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Modèle : " + v.getModele()));
        panel.add(new JLabel("Nombre de places : " + v.getNbPlaces()));
        panel.add(new JLabel("N° de châssis : " + v.getNumeroChassis()));
        panel.add(new JLabel("Matricule : " + v.getMatricule()));
        panel.add(new JLabel("Propriétaire : " + v.getProprietaire()));

        add(panel, BorderLayout.WEST);

        JPanel imagesPanel = new JPanel(new FlowLayout());
        for (String path : ic.getImagesByVoitureId(voitureId)) {
            imagesPanel.add(new ImagePanel(path));
        }
        add(new JScrollPane(imagesPanel), BorderLayout.CENTER);

        setVisible(true);
    }
}
