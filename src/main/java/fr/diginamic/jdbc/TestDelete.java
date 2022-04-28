package fr.diginamic.jdbc;

import org.diginamic.fr.TestConnexionJdbc;

import java.sql.Connection;
import java.sql.Statement;

public class TestDelete {

    public static void main(String[] args) {

        Connection connection = null;

        try {

            System.out.println(TestConnexionJdbc.getConnection());
            connection = TestConnexionJdbc.getConnection();
            Statement stat = connection.createStatement();
            int nb = stat.executeUpdate("DELETE FROM FOURNISSEUR WHERE NOM = 'La Maison des Peintures'");

            stat.close();

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        } finally {
            try {
                if (connection != null) connection.close();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }

        }
    }
}
