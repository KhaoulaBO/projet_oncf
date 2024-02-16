package Administrateur;

import java.util.HashMap;
import java.util.Map;

public class GestionCartesReduction implements CarteReductionService {
    private Map<String, CarteReduction> cartesReduction;

    public GestionCartesReduction() {
        this.cartesReduction = new HashMap<>();
    }

    @Override
    public void ajouterIdCarteReduction(String numeroCarte, CarteReduction carteReduction) {
        cartesReduction.put(numeroCarte, carteReduction);
    }

    @Override
    public void supprimerIdCarteReduction(String numeroCarte) {
        cartesReduction.remove(numeroCarte);
    }

    @Override
    public Map<String, CarteReduction> getIdCartesReduction() {
        return cartesReduction;
    }
}
