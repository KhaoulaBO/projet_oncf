package Administrateur;

public class CarteReduction {
    private int id_carteReduction;
    private String numeroCarte;
    private String nomBeneficiaire;

    // Constructeur
    public CarteReduction(int id_carteReduction, String numeroCarte, String nomBeneficiaire) {
        this.id_carteReduction = id_carteReduction;
        this.numeroCarte = numeroCarte;
        this.nomBeneficiaire = nomBeneficiaire;
    }

    // Getters et setters
    public int getId() {
        return id_carteReduction;
    }

    public void setId(int id_carteReduction) {
        this.id_carteReduction = id_carteReduction;
    }

    public String getNumeroCarte() {
        return numeroCarte;
    }

    public void setNumeroCarte(String numeroCarte) {
        this.numeroCarte = numeroCarte;
    }

    public String getNomBeneficiaire() {
        return nomBeneficiaire;
    }

    public void setNomBeneficiaire(String nomBeneficiaire) {
        this.nomBeneficiaire = nomBeneficiaire;
    }

}
