package model;

import java.util.List;

public class Voiture {
    private int id;
    private String modele;
    private int nbPlaces;
    private String numeroChassis;
    private String matricule;
    private String proprietaire;
    private List<String> images;

    // Constructeurs
    public Voiture() {}

    public Voiture(int id, String modele, int nbPlaces, String numeroChassis, String matricule, String proprietaire, List<String> images) {
        this.id = id;
        this.modele = modele;
        this.nbPlaces = nbPlaces;
        this.numeroChassis = numeroChassis;
        this.matricule = matricule;
        this.proprietaire = proprietaire;
        this.images = images;
    }

    public Voiture(String modele, int nbPlaces, String numeroChassis, String matricule, String proprietaire) {
        this.modele = modele;
        this.nbPlaces = nbPlaces;
        this.numeroChassis = numeroChassis;
        this.matricule = matricule;
        this.proprietaire = proprietaire;
    }

    // Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public int getNbPlaces() {
        return nbPlaces;
    }

    public void setNbPlaces(int nbPlaces) {
        this.nbPlaces = nbPlaces;
    }

    public String getNumeroChassis() {
        return numeroChassis;
    }

    public void setNumeroChassis(String numeroChassis) {
        this.numeroChassis = numeroChassis;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(String proprietaire) {
        this.proprietaire = proprietaire;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    // toString (utile pour debug ou logs)
    @Override
    public String toString() {
        return "Voiture{" +
                "id=" + id +
                ", modele='" + modele + '\'' +
                ", nbPlaces=" + nbPlaces +
                ", numeroChassis='" + numeroChassis + '\'' +
                ", matricule='" + matricule + '\'' +
                ", proprietaire='" + proprietaire + '\'' +
                ", images=" + images +
                '}';
    }
}
