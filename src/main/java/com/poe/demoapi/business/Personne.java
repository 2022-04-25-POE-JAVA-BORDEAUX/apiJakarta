package com.poe.demoapi.business;

public class Personne {
    
    private Long id;
    private String prenom;
    private String nom;

    public Personne() {
    }
    public Personne(String prenom, String nom) {
        this.prenom = prenom;
        this.nom = nom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Personne{" + "id=" + id + ", prenom=" + prenom + ", nom=" + nom + '}';
    }
}
