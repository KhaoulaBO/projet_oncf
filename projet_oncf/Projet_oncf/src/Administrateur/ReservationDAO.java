package Administrateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAO {
    private static final String SELECT_ALL = "SELECT * FROM Reservation";
    private static final String INSERT_RESERVATION = "INSERT INTO Reservation (client, trajet_id) VALUES (?, ?)";

    public List<Reservation> getAllReservations() {
        List<Reservation> reservations = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement statement = conn.prepareStatement(SELECT_ALL);
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

    public void addReservation(Reservation reservation) {
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement statement = conn.prepareStatement(INSERT_RESERVATION)) {

            statement.setString(1, reservation.getClient());
            statement.setInt(2, reservation.getTrajetId());

            statement.executeUpdate();

            System.out.println("La réservation a été ajoutée avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
