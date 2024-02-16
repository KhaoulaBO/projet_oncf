package Voyageur;

import java.util.ArrayList;
import java.util.List;

public class GestionnaireBillets {
    private List<Billet> billetsDisponibles;

    public GestionnaireBillets() {
        billetsDisponibles = new ArrayList<>();

    }

    public void vendreBillet(String classe, String destination) {
        for (Billet billet : billetsDisponibles) {
            if (billet.getClasse().equalsIgnoreCase(classe) && billet.getDestination().equalsIgnoreCase(destination)) {
                System.out.println("Billet vendu : " + billet);
                billetsDisponibles.remove(billet);
                return;
            }
        }
        System.out.println("Désolé, aucun billet n'est disponible pour les critères spécifiés.");
    }
}
