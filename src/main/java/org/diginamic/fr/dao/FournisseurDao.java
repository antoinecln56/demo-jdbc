package org.diginamic.fr.dao;


import org.diginamic.fr.TestConnexionJdbc;
import org.diginamic.fr.model.Fournisseur;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe va me permettre de lire en JDBC la table Fournisseur
 * et aussi d'avoir les méthodes CRUD et d'obtenir des objets de type Fournisseur
 */
public class FournisseurDao {

    /**
     * Retourne la liste des Fournisseurs de ma base de données.
     * @return
     */
    public static List<Fournisseur> getAll(){
        Connection connection = null;
        List<Fournisseur> listeFournisseurs = new ArrayList<>();
        try{
            connection = TestConnexionJdbc.getConnection();

            //java.sql
            Statement stat = connection.createStatement();
            ResultSet curseur = stat.executeQuery("SELECT * FROM FOURNISSEUR");

            while(curseur.next()){
                /**
                 * Récupère les colonnes ID et NOM de la table pour stocker dans objet Fournisseur
                 * et les mettre dans notre liste
                 */
                Fournisseur fou = new Fournisseur(curseur.getInt("ID"), curseur.getString("NOM"));
                listeFournisseurs.add(fou);
            }

            /**
             * Je ferme dans l'ordre mon ResultSet puis mon Statement.
             *
             */
            curseur.close();
            stat.close();
        }
        catch(Exception ex){
            System.err.println(ex.getMessage());
        }
        finally {
            try{
                if(connection != null) connection.close();
            }
            catch(Exception ex){
                System.err.println(ex.getMessage());
            }
        }

        return listeFournisseurs;
    }
}
