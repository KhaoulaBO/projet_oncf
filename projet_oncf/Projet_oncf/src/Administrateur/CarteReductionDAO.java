package Administrateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class CarteReductionDAO {
    private static final String SELECT_ALL = "SELECT * FROM CarteReduction";
    private static final String SELECT_BY_ID = "SELECT * FROM CarteReduction WHERE id_carteReduction = ?";
    private static final String INSERT_CARTE = "INSERT INTO CarteReduction (numeroCarte, nomBeneficiaire) VALUES (?, ?)";

    public List<CarteReduction> getAllCartesReduction() {
        List<CarteReduction> cartes = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement statement = conn.prepareStatement(SELECT_ALL);
                ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id_carteReduction = resultSet.getInt("id_carteReduction");
                String numeroCarte = resultSet.getString("numeroCarte");
                String nomBeneficiaire = resultSet.getString("nomBeneficiaire");

                CarteReduction carte = new CarteReduction(id_carteReduction, numeroCarte, nomBeneficiaire);
                cartes.add(carte);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cartes;
    }

    public CarteReduction getCarteReductionById(int id_carteReduction) {
        CarteReduction carte = null;

        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement statement = conn.prepareStatement(SELECT_BY_ID)) {

            statement.setInt(1, id_carteReduction);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String numeroCarte = resultSet.getString("numeroCarte");
                String nomBeneficiaire = resultSet.getString("nomBeneficiaire");

                carte = new CarteReduction(id_carteReduction, numeroCarte, nomBeneficiaire);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return carte;
    }

    public void addCarteReduction(CarteReduction carte) {
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement statement = conn.prepareStatement(INSERT_CARTE)) {

            statement.setString(1, carte.getNumeroCarte());
            statement.setString(2, carte.getNomBeneficiaire());

            statement.executeUpdate();

            System.out.println("La carte de réduction a été ajoutée avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
