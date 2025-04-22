package util;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class ImageUtil {
    public static ImageIcon resizeImage(String path, int width, int height) {
        ImageIcon icon = new ImageIcon(path);
        Image img = icon.getImage();
        Image resized = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resized);
    }

    public static File[] chooseImages(Component parent) {
        JFileChooser chooser = new JFileChooser();
        chooser.setMultiSelectionEnabled(true);
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int result = chooser.showOpenDialog(parent);
        return result == JFileChooser.APPROVE_OPTION ? chooser.getSelectedFiles() : null;
    }
}
