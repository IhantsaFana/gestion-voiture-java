package model.dao;

import model.ImageVoiture;
import util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImageVoitureDAO {

    public void addImage(ImageVoiture image) {
        String sql = "INSERT INTO image_voiture (voiture_id, path) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, image.getVoitureId());
            stmt.setString(2, image.getPath());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> getImagesByVoitureId(int voitureId) {
        List<String> images = new ArrayList<>();
        String sql = "SELECT path FROM image_voiture WHERE voiture_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, voitureId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                images.add(rs.getString("path"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return images;
    }
}
