package Administrateur;

import java.util.Map;

public interface CarteReductionService {
    void ajouterIdCarteReduction(String numeroCarte, CarteReduction carteReduction);

    void supprimerIdCarteReduction(String numeroCarte);

    Map<String, CarteReduction> getIdCartesReduction();
}
