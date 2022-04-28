package fr.diginamic.jdbc;

import fr.diginamic.jdbc.entites.Fournisseur;
import org.diginamic.fr.TestConnexionJdbc;
import org.diginamic.fr.dao.FournisseurDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TestSelect {

    public static void main(String[] args) {

        /**
         * Se connecter à la db puis requête qui extrait la liste de tous les fournisseurs. Les données recueillies de la base de données permettront de créer des instances
         * de fournisseurs qui seront stockées dans une ArrayList
         */

        Connection connection = null;
        List<Fournisseur>  listeFournisseurs = new ArrayList<>();
        try{
            connection = TestConnexionJdbc.getConnection();
            Statement stat = connection.createStatement();
            ResultSet curseur = stat.executeQuery("SELECT * FROM FOURNISSEUR");

            while(curseur.next()){
                Integer id = curseur.getInt("ID");
                String nom = curseur.getString("NOM");

                Fournisseur fou = new Fournisseur(id, nom);
                listeFournisseurs.add(fou);
            }
            stat.close();
            curseur.close();
        }
        catch(Exception ex){
            System.err.println(ex.getMessage());
        }
        finally {
            try {
                if (connection != null) connection.close();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
        
        for(Fournisseur fou : listeFournisseurs){
            System.out.println("Id : " + fou.getId() + " Nom : " + fou.getNom());
        }

    }
}
