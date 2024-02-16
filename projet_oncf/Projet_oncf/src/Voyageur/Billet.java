package Voyageur;

import Administrateur.CarteReduction;

public class Billet {
    private int id; // Identifiant unique du billet
    private String classe;
    private String destination;
    private double prix;
    @SuppressWarnings("unused")
    private CarteReduction id_carteReduction; // Ajout de la référence à la carte de réduction

    public Billet(int id, String classe, String destination, double prix, CarteReduction id_carteReduction) {
        this.id = id;
        this.classe = classe;
        this.destination = destination;
        this.id_carteReduction = id_carteReduction; // Affectation de la carte de réduction
        // Vérification si une carte de réduction est associée
        if (id_carteReduction != null) {
            // Réduction de 30% sur le prix si une carte de réduction est associée
            this.prix = prix - (0.3 * prix);
        } else {
            this.prix = prix; // Sinon, prix inchangé
        }
    }

    public int getId() {
        return id;
    }

    public String getClasse() {
        return classe;
    }

    public String getDestination() {
        return destination;
    }

    public double getPrix() {
        return prix;
    }

    // Getter pour la carte de réduction
    public CarteReduction getCarteReduction() {
        return carteReduction;
    }

    @Override
    public String toString() {
        return "Billet{" +
                "classe='" + classe + '\'' +
                ", destination='" + destination + '\'' +
                ", prix=" + prix +
                '}';
    }
}
