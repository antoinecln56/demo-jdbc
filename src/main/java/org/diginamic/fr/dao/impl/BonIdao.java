package org.diginamic.fr.dao.impl;

import org.diginamic.fr.TestConnexionJdbc;
import org.diginamic.fr.dao.Idao;
import org.diginamic.fr.model.Bon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BonIdao implements Idao<Bon> {

    private Connection connection = null;

    public BonIdao() throws Exception{
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
    public List<Bon> extraire() {
        List<Bon> bon = new ArrayList<Bon>();
        try {
            PreparedStatement stat = connection.prepareStatement("SELECT ID, NUMERO, DATE_CMDE, DELAI, ID_FOU FROM BON");
            ResultSet curseur = stat.executeQuery();

            while (curseur.next()) {
                Bon article = new Bon(curseur.getInt("ID"),	curseur.getInt("NUMERO"),
                        curseur.getTimestamp("DATE_CMDE"), curseur.getInt("DELAI"), curseur.getInt("ID_FOU"));
                bon.add(article);
            }
            curseur.close();
            stat.close();
        }
        catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        return bon;
    }

    @Override
    public void insert(Bon data) {
        try {
            PreparedStatement stat = connection.prepareStatement("INSERT INTO BON (ID, NUMERO, DATE_CMDE, DELAI, ID_FOU) VALUES (?, ?, ?, ?, ?)");
            stat.setInt(1, data.getId());
            stat.setInt(2, data.getNumero());
            stat.setTimestamp(3, data.getDateCmde());
            stat.setInt(4, data.getDelai());
            stat.setInt(5, data.getIdFou());
            stat.executeUpdate();
        }
        catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    }

    @Override
    public int update(Bon ancienNom, Bon nouveauNom) {

        try {
            PreparedStatement stat = connection.prepareStatement("UPDATE BON SET NUMERO = ?, DATE_CMDE = ?, DELAI = ?, ID_FOU = ? WHERE ID = ?");
            stat.setInt(1, nouveauNom.getNumero());
            stat.setTimestamp(2, nouveauNom.getDateCmde());
            stat.setInt(3, nouveauNom.getDelai());
            stat.setInt(4, nouveauNom.getIdFou());
            stat.setInt(5, ancienNom.getId());
            stat.executeUpdate();

            stat.close();
        }
        catch(Exception ex) {
            System.err.println(ex.getMessage());
        }

        return 0;
    }

    @Override
    public boolean delete(Bon data) {

        try {
            PreparedStatement stat = connection.prepareStatement("DELETE FROM BON WHERE ID = ?");
            stat.setInt(1, data.getId());
            stat.executeUpdate();

            stat.close();
        }
        catch(Exception ex) {
            System.err.println(ex.getMessage());
        }

        return false;
    }



}
