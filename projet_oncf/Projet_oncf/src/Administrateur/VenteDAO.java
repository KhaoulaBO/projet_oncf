package Administrateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Voyageur.Billet;

public class VenteDAO {
    private static final String SELECT_ALL = "SELECT * FROM Vente";
    private static final String INSERT_VENTE = "INSERT INTO Vente (billet_id, montant) VALUES (?, ?)";
    private static final String DELETE_VENTE = "DELETE FROM Vente WHERE id_vente = ?";

    public List<Vente> getAllVentes() {
        List<Vente> ventes = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement statement = conn.prepareStatement(SELECT_ALL);
                ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id_vente = resultSet.getInt("id_vente");
                int billetId = resultSet.getInt("billet_id");
                double montant = resultSet.getDouble("montant");

                // Récupérer le billet associé à cette vente
                Billet billet = getBilletById(billetId);

                Vente vente = new Vente(id_vente, billet, montant);
                ventes.add(vente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ventes;
    }

    public void addVente(Vente vente) {
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement statement = conn.prepareStatement(INSERT_VENTE)) {

            statement.setInt(1, vente.getBillet().getId());
            statement.setDouble(2, vente.getMontant());

            statement.executeUpdate();

            System.out.println("La vente a été ajoutée avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeVente(Vente vente) {
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement statement = conn.prepareStatement(DELETE_VENTE)) {

            statement.setInt(1, vente.getId_vente());

            statement.executeUpdate();

            System.out.println("La vente a été supprimée avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode utilitaire pour récupérer un billet par son ID
    private Billet getBilletById(int id) {
        // Implémentez la logique pour récupérer un billet de la base de données par son
        // ID
        // et retournez-le
        return null;
    }
}
