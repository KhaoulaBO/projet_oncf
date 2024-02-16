package Voyageur;

public class TicketPrinter {
    public void imprimerBillet(Billet billet) {
        System.out.println("----- Billet d'embarquement -----");
        System.out.println("Destination : " + billet.getDestination());
        System.out.println("Classe : " + billet.getClasse());
        System.out.println("Prix : " + billet.getPrix() + "€");
        System.out.println("----------------------------------");
    }
}
