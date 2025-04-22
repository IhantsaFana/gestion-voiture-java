package view.components;

import model.Voiture;
import util.ImageUtil;

import javax.swing.*;
import java.awt.*;

public class CarCard extends JPanel {
    public CarCard(Voiture voiture, String imagePath) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.GRAY));
        setPreferredSize(new Dimension(200, 250));

        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(ImageUtil.resizeImage(imagePath, 180, 140));
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        add(imageLabel, BorderLayout.NORTH);

        JLabel title = new JLabel(voiture.getModele(), SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 14));
        add(title, BorderLayout.CENTER);
    }
}
