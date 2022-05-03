package fr.diginamic.jdbc;

import org.diginamic.fr.TestConnexionJdbc;
import org.diginamic.fr.model.Fournisseur;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TestInsertion {

    public static void main(String[] args) {

        Connection connection = null;
        try {
            System.out.println(TestConnexionJdbc.getConnection());
            connection = TestConnexionJdbc.getConnection();
            Statement stat = connection.createStatement();
            int nb = stat.executeUpdate("INSERT INTO FOURNISSEUR (ID,NOM) VALUES (7, 'La Maison de la Souye')");

            stat.close();

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }

        }

    }
}



