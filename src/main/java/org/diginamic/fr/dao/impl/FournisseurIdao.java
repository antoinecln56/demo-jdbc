package org.diginamic.fr.dao.impl;

import org.diginamic.fr.TestConnexionJdbc;
import org.diginamic.fr.dao.Idao;
import org.diginamic.fr.model.Fournisseur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FournisseurIdao implements Idao<Fournisseur> {

    private Connection connection = null;

    public FournisseurIdao() throws Exception{
        connection = TestConnexionJdbc.getConnection();
    }

    private void close() throws Exception{
        if(connection != null && connection.isClosed() == false){
            connection.close();
        }
    }

    @Override
    protected void finalize() throws Throwable {
        close();
    }

    @Override
    public List<Fournisseur> extraire() {
        List<Fournisseur> listeDesFournisseurs = new ArrayList<Fournisseur>();
        try {

            PreparedStatement stat = connection.prepareStatement("SELECT ID,NOM FROM FOURNISSEUR");
            ResultSet curseur = stat.executeQuery();
            while(curseur.next()) {

                Fournisseur fo = new Fournisseur(curseur.getInt("ID"),
                        curseur.getString("NOM"));
                listeDesFournisseurs.add(fo);

            }
            curseur.close();
            stat.close();
        }
        catch(Exception ex) {
            System.err.println(ex.getMessage());
        }

        return listeDesFournisseurs;
    }


    @Override
    public void insert(Fournisseur data) {

        try {
            PreparedStatement stat = connection.prepareStatement("INSERT INTO FOURNISSEUR (ID,NOM) VALUES (?,?)");
            stat.setInt(1,data.getId());
            stat.setString(2, data.getNom());
            stat.executeUpdate();

            stat.close();

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public int update(Fournisseur ancienNom, Fournisseur nouveauNom) {

        try {
            PreparedStatement stat = connection.prepareStatement("UPDATE FOURNISSEUR SET NOM =? WHERE ID=?");
            stat.setString(1, nouveauNom.getNom());
            stat.setInt(2, ancienNom.getId());
            stat.executeUpdate();

            stat.close();

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return 0;
    }

    @Override
    public boolean delete(Fournisseur data) {

        try{
            PreparedStatement stat = connection.prepareStatement("DELETE FROM FOURNISSEUR WHERE ID=?");
            stat.setInt(1,data.getId());
            stat.executeUpdate();

            stat.close();

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }
}
