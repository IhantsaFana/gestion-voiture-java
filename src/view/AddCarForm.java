package view;

import controller.ImageController;
import controller.VoitureController;
import model.ImageVoiture;
import model.Voiture;
import util.ImageUtil;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class AddCarForm extends JFrame {

    private JTextField modeleField, nbPlacesField, chassisField, matriculeField, proprietaireField;
    private File[] selectedImages;
    private HomePage homePage; // Référence à la HomePage

    // Constructeur modifié pour accepter la référence de HomePage
    public AddCarForm(HomePage homePage) {
        this.homePage = homePage;  // Initialisation de la HomePage

        setTitle("Ajouter une Voiture");
        setSize(400, 500);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(0, 1, 10, 10));

        modeleField = new JTextField();
        nbPlacesField = new JTextField();
        chassisField = new JTextField();
        matriculeField = new JTextField();
        proprietaireField = new JTextField();

        add(new JLabel("Modèle:"));
        add(modeleField);
        add(new JLabel("Nombre de places:"));
        add(nbPlacesField);
        add(new JLabel("Numéro de châssis:"));
        add(chassisField);
        add(new JLabel("Matricule:"));
        add(matriculeField);
        add(new JLabel("Propriétaire:"));
        add(proprietaireField);

        JButton btnImages = new JButton("Choisir Images");
        btnImages.addActionListener(e -> {
            selectedImages = ImageUtil.chooseImages(this);
        });
        add(btnImages);

        JButton btnAjouter = new JButton("Ajouter");
        btnAjouter.addActionListener(e -> ajouterVoiture());
        add(btnAjouter);

        setVisible(true);
    }

    private void ajouterVoiture() {
        VoitureController vc = new VoitureController();
        ImageController ic = new ImageController();

        Voiture v = new Voiture(
            modeleField.getText(),
            Integer.parseInt(nbPlacesField.getText()),
            chassisField.getText(),
            matriculeField.getText(),
            proprietaireField.getText()
        );

        int voitureId = vc.ajouterVoiture(v);
        if (voitureId > 0 && selectedImages != null) {
            for (File file : selectedImages) {
                ic.addImage(new ImageVoiture(voitureId, file.getAbsolutePath()));
            }
        }

        JOptionPane.showMessageDialog(this, "Voiture ajoutée !");
        
        // Rafraîchir la HomePage après l'ajout de la voiture
        homePage.loadVoitures(new VoitureController(), new ImageController());

        this.dispose(); // Fermer le formulaire d'ajout
    }
}
