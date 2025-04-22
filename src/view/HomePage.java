package view;

import controller.ImageController;
import controller.VoitureController;
import model.Voiture;
import view.components.CarCard;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class HomePage extends JFrame {

    private JPanel listPanel; // Panel qui contient toutes les voitures

    public HomePage() {
        setTitle("Liste des Voitures");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialisation des contrôleurs
        VoitureController vc = new VoitureController();
        ImageController ic = new ImageController();

        // Initialisation du panel qui contient les voitures
        listPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 20));

        // Charger les voitures
        loadVoitures(vc, ic);

        // Ajouter un bouton pour ajouter une nouvelle voiture
        JButton addBtn = new JButton("Ajouter une voiture");
        addBtn.addActionListener(e -> new AddCarForm(this));

        // Ajouter le panel à la fenêtre principale
        add(new JScrollPane(listPanel), BorderLayout.CENTER);
        add(addBtn, BorderLayout.SOUTH);

        setVisible(true);
    }

    // Méthode pour charger les voitures dans le panel
    public void loadVoitures(VoitureController vc, ImageController ic) {
        listPanel.removeAll(); // Nettoyer le panel avant de rajouter les voitures

        List<Voiture> voitures = vc.getAllVoitures();

        for (Voiture v : voitures) {
            List<String> images = ic.getImagesByVoitureId(v.getId());
            String image = images.isEmpty() ? "" : images.get(0);
            CarCard card = new CarCard(v, image);
            card.setCursor(new Cursor(Cursor.HAND_CURSOR));
            card.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    new DetailPage(v.getId());
                }
            });
            listPanel.add(card);
        }

        listPanel.revalidate();  // Revalider le panel après modification
        listPanel.repaint();     // Repeindre le panel
    }
}
