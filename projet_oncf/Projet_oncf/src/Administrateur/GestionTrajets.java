package Administrateur;

import java.util.ArrayList;
import java.util.List;

public class GestionTrajets {
    private List<Trajet> trajets;

    public GestionTrajets() {
        this.trajets = new ArrayList<>();
    }

    public void ajouterTrajet(Trajet trajet) {
        trajets.add(trajet);
    }

    public void modifierTrajet(int index, Trajet nouveauTrajet) {
        trajets.set(index, nouveauTrajet);
    }

    public void supprimerTrajet(int index) {
        trajets.remove(index);
    }

    // Autres méthodes pour la gestion des trajets
    // ...

    // Getter pour la liste des trajets
    public List<Trajet> getTrajets() {
        return trajets;
    }
}
