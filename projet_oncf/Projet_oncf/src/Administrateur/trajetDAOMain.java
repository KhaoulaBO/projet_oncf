package Administrateur;

import java.util.List;

public class trajetDAOMain {

    public static void main(String[] args) {
        TrajetDAO trajetDAO = new TrajetDAO();
        List<Trajet> trajets = trajetDAO.getAllTrajets();

        // Faites quelque chose avec les trajets récupérés, par exemple, les afficher
        for (Trajet trajet : trajets) {
            System.out.println(trajet);
        }
    }
}
