package Administrateur;

import Voyageur.Billet;

public class Vente {
    private int id_vente;
    private Billet billet;
    private double montant;

    public Vente(int id_vente, Billet billet, double montant) {
        this.id_vente = id_vente;
        this.billet = billet;
        this.montant = montant;
    }

    public int getId_vente() {
        return id_vente;
    }

    public Billet getBillet() {
        return billet;
    }

    public double getMontant() {
        return montant;
    }

    @Override
    public String toString() {
        return "Vente{" +
                "id_vente=" + id_vente +
                ", billet=" + billet +
                ", montant=" + montant +
                '}';
    }
}
