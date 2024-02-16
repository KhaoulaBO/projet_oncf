package Administrateur;

import java.util.List;

public class Rapport {
    private List<Vente> ventes;
    private List<Reservation> reservations;
    // D'autres activités du guichet peuvent être ajoutées selon les besoins

    public Rapport(List<Vente> ventes, List<Reservation> reservations) {
        this.ventes = ventes;
        this.reservations = reservations;
    }

    // Méthode pour générer le rapport
    public void genererRapport() {
        System.out.println("Rapport sur les ventes :");
        for (Vente vente : ventes) {
            System.out.println(vente);
        }

        System.out.println("\nRapport sur les réservations :");
        for (Reservation reservation : reservations) {
            System.out.println(reservation);
        }

        // Génération de rapports pour d'autres activités du guichet
    }
}
