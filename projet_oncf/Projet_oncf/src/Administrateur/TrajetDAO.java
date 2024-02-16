package Administrateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrajetDAO {
    private static final String SELECT_ALL = "SELECT * FROM trajet";

    public List<Trajet> getAllTrajets() {
        List<Trajet> trajets = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement statement = conn.prepareStatement(SELECT_ALL);
                ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id_trajet = resultSet.getInt("id_trajet");
                String destination = resultSet.getString("destination");
                String horaire = resultSet.getString("horaire");
                double tarif = resultSet.getDouble("tarif");

                Trajet trajet = new Trajet(id_trajet, destination, horaire, tarif);
                trajets.add(trajet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return trajets;
    }
}
