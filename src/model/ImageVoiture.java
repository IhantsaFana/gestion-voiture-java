package model;

public class ImageVoiture {
    private int id;
    private int voitureId;
    private String path;

    // Constructeurs
    public ImageVoiture() {}

    public ImageVoiture(int voitureId, String path) {
        this.voitureId = voitureId;
        this.path = path;
    }

    public ImageVoiture(int id, int voitureId, String path) {
        this.id = id;
        this.voitureId = voitureId;
        this.path = path;
    }

    // Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVoitureId() {
        return voitureId;
    }

    public void setVoitureId(int voitureId) {
        this.voitureId = voitureId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    // toString
    @Override
    public String toString() {
        return "ImageVoiture{" +
                "id=" + id +
                ", voitureId=" + voitureId +
                ", path='" + path + '\'' +
                '}';
    }
}
