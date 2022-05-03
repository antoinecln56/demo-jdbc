package org.diginamic.fr.dao.impl;


import org.diginamic.fr.TestConnexionJdbc;
import org.diginamic.fr.dao.Idao;
import org.diginamic.fr.model.Articles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ArticlesIdao implements Idao<Articles>{

    private Connection connection = null;

    public ArticlesIdao() throws Exception{
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
    public List<Articles> extraire() {
        List<Articles> art = new ArrayList<Articles>();
        try {
            PreparedStatement stat = connection.prepareStatement("SELECT ID, REF, DESIGNATION, PRIX, ID_FOU FROM ARTICLE");
            ResultSet curseur = stat.executeQuery();

            while (curseur.next()) {
                Articles article = new Articles(curseur.getInt("ID"),curseur.getString("REF"),
                        curseur.getString("DESIGNATION"), curseur.getFloat("PRIX"), curseur.getInt("ID_FOU"));
                art.add(article);
            }
            curseur.close();
            stat.close();
        }
        catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        return art;
    }

    @Override
    public void insert(Articles data) {
        try {
            PreparedStatement stat = connection.prepareStatement("INSERT INTO ARTICLE (ID, REF, DESIGNATION, PRIX, ID_FOU) VALUES (?, ?, ?, ?, ?)");
            stat.setInt(1, data.getId());
            stat.setString(2, data.getRef());
            stat.setString(3, data.getDesignation());
            stat.setFloat(4, data.getPrix());
            stat.setInt(5, data.getIdFou());
            stat.executeUpdate();

            stat.close();
        }
        catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public int update(Articles ancienNom, Articles nouveauNom) {

        try {
            PreparedStatement stat = connection.prepareStatement("UPDATE ARTICLE SET REF = ?, DESIGNATION = ?, PRIX = ?, ID_FOU = ? WHERE ID = ?");
            stat.setInt(1, ancienNom.getId());
            stat.setString(2, nouveauNom.getRef());
            stat.setString(3, nouveauNom.getDesignation());
            stat.setFloat(4, nouveauNom.getPrix());
            stat.setInt(5, nouveauNom.getIdFou());

            stat.executeUpdate();

            stat.close();
        }
        catch(Exception ex) {
            System.err.println(ex.getMessage());
        }

        return 0;
    }

    @Override
    public boolean delete(Articles data) {
        try {
            PreparedStatement stat = connection.prepareStatement("DELETE FROM ARTICLE WHERE ID = ?");
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
