package model.dao;

import model.Voiture;
import util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VoitureDAO {

    public List<Voiture> getAllVoitures() {
        List<Voiture> voitures = new ArrayList<>();
        String sql = "SELECT * FROM voiture";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Voiture v = new Voiture();
                v.setId(rs.getInt("id"));
                v.setModele(rs.getString("modele"));
                v.setNbPlaces(rs.getInt("nb_places"));
                v.setNumeroChassis(rs.getString("numero_chassis"));
                v.setMatricule(rs.getString("matricule"));
                v.setProprietaire(rs.getString("proprietaire"));
                voitures.add(v);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return voitures;
    }

    public int addVoiture(Voiture voiture) {
        String sql = "INSERT INTO voiture (modele, nb_places, numero_chassis, matricule, proprietaire) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, voiture.getModele());
            stmt.setInt(2, voiture.getNbPlaces());
            stmt.setString(3, voiture.getNumeroChassis());
            stmt.setString(4, voiture.getMatricule());
            stmt.setString(5, voiture.getProprietaire());

            int affected = stmt.executeUpdate();
            if (affected > 0) {
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) return rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

    public Voiture getVoitureById(int id) {
        String sql = "SELECT * FROM voiture WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Voiture v = new Voiture();
                v.setId(id);
                v.setModele(rs.getString("modele"));
                v.setNbPlaces(rs.getInt("nb_places"));
                v.setNumeroChassis(rs.getString("numero_chassis"));
                v.setMatricule(rs.getString("matricule"));
                v.setProprietaire(rs.getString("proprietaire"));
                return v;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
