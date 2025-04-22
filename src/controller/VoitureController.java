package controller;

import model.Voiture;
import model.dao.VoitureDAO;

import java.util.List;

public class VoitureController {
    private final VoitureDAO voitureDAO = new VoitureDAO();

    public List<Voiture> getAllVoitures() {
        return voitureDAO.getAllVoitures();
    }

    public int ajouterVoiture(Voiture voiture) {
        return voitureDAO.addVoiture(voiture);
    }

    public Voiture getVoitureById(int id) {
        return voitureDAO.getVoitureById(id);
    }
}
