package controller;

import model.ImageVoiture;
import model.dao.ImageVoitureDAO;

import java.util.List;

public class ImageController {
    private final ImageVoitureDAO imageDAO = new ImageVoitureDAO();

    public void addImage(ImageVoiture image) {
        imageDAO.addImage(image);
    }

    public List<String> getImagesByVoitureId(int voitureId) {
        return imageDAO.getImagesByVoitureId(voitureId);
    }
}
