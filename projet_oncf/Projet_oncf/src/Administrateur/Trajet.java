package Administrateur;

public class Trajet {
    private int id_trajet;
    private String destination;
    private String horaire;
    private double tarif;

    public Trajet(int id_trajet, String destination, String horaire, double tarif) {
        this.id_trajet = id_trajet;
        this.destination = destination;
        this.horaire = horaire;
        this.tarif = tarif;
    }

    // Getters and setters

    public int getid_trajet() {
        return id_trajet;
    }

    public void setid_trajet(int id_trajet) {
        this.id_trajet = id_trajet;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getHoraire() {
        return horaire;
    }

    public void setHoraire(String horaire) {
        this.horaire = horaire;
    }

    public double getTarif() {
        return tarif;
    }

    public void setTarif(double tarif) {
        this.tarif = tarif;
    }

    @Override
    public String toString() {
        return "Destination: " + destination + ", Horaire: " + horaire + ", Tarif: " + tarif;
    }
}
