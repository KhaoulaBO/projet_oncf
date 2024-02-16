package Administrateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Voyageur.Billet;

public class RapportDAO {
    private static final String SELECT_ALL_VENTES = "SELECT * FROM Vente";
    private static final String SELECT_ALL_RESERVATIONS = "SELECT * FROM Reservation";

    public List<Vente> getAllVentes() {
        List<Vente> ventes = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement statement = conn.prepareStatement(SELECT_ALL_VENTES);
                ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Billet billet = getBilletById(resultSet.getInt("billet_id"));
                double montant = resultSet.getDouble("montant");
                Vente vente = new Vente(id, billet, montant);
                ventes.add(vente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ventes;
    }

    public List<Reservation> getAllReservations() {
        List<Reservation> reservations = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement statement = conn.prepareStatement(SELECT_ALL_RESERVATIONS);
                ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String client = resultSet.getString("client");
                int trajetId = resultSet.getInt("trajet_id");
                Reservation reservation = new Reservation(id, client, trajetId);
                reservations.add(reservation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reservations;
    }
}
