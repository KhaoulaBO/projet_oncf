package Administrateur;

public class Reservation {
    private int id_reservation;
    private String client;
    private int trajetId; // Ajoutez cet attribut pour stocker l'identifiant du trajet

    // Constructeur
    public Reservation(int id_reservation, String client, int trajetId) {
        this.id_reservation = id_reservation;
        this.client = client;
        this.trajetId = trajetId;
    }

    // Getters
    public int getId_reservation() {
        return id_reservation;
    }

    public String getClient() {
        return client;
    }

    public int getTrajetId() {
        return trajetId;
    }
}
