package view.components;

import util.ImageUtil;

import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {
    public ImagePanel(String path) {
        setLayout(new BorderLayout());
        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(ImageUtil.resizeImage(path, 200, 150));
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        add(imageLabel, BorderLayout.CENTER);
    }
}
