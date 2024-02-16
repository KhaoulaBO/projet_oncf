package Voyageur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Administrateur.CarteReductionDAO; // Import de la classe CarteReduction
import Administrateur.CarteReduction;

public class BilletDAO {
    private static final String SELECT_ALL = "SELECT * FROM Billet";
    private static final String INSERT_BILLET = "INSERT INTO Billet (id, classe, destination, prix, id_carteReduction) VALUES (?, ?, ?, ?, ?)";
    private static final String DELETE_BILLET = "DELETE FROM Billet WHERE id = ?";

    public List<Billet> getAllBillets() {
        List<Billet> billets = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement statement = conn.prepareStatement(SELECT_ALL);
                ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String classe = resultSet.getString("classe");
                String destination = resultSet.getString("destination");
                double prix = resultSet.getDouble("prix");
                int id_carteReduction = resultSet.getInt("id_carteReduction"); // Ajout de la récupération de l'ID de la
                                                                               // carte de réduction

                // Récupération de la carte de réduction associée
                CarteReductionDAO carteReductionDAO = new CarteReductionDAO();
                CarteReduction carteReduction = carteReductionDAO.getCarteReductionById(id_carteReduction);

                Billet billet = new Billet(id, classe, destination, prix, carteReduction);
                billets.add(billet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return billets;
    }

    public void addBillet(Billet billet) {
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement statement = conn.prepareStatement(INSERT_BILLET)) {

            statement.setInt(1, billet.getId());
            statement.setString(2, billet.getClasse());
            statement.setString(3, billet.getDestination());
            statement.setDouble(4, billet.getPrix());
            if (billet.getIdCarteReduction() != null) {
                statement.setInt(5, billet.getIdCarteReduction().getId());
            } else {
                statement.setNull(5, java.sql.Types.INTEGER);
            }

            statement.executeUpdate();

            System.out.println("Le billet a été ajouté avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeBillet(Billet billet) {
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement statement = conn.prepareStatement(DELETE_BILLET)) {

            statement.setInt(1, billet.getId());

            statement.executeUpdate();

            System.out.println("Le billet a été supprimé avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
