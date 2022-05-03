package org.diginamic.fr.dao.impl;

import org.diginamic.fr.TestConnexionJdbc;
import org.diginamic.fr.dao.Idao;
import org.diginamic.fr.model.Compo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CompoIdao implements Idao<Compo> {

    private Connection connection = null;

    public CompoIdao() throws Exception{
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
    public List<Compo> extraire() {
        List<Compo> comp = new ArrayList<Compo>();
        try {
            PreparedStatement stat = connection.prepareStatement("SELECT ID, ID_ART, ID_BON, QTE FROM COMPO");
            ResultSet curseur = stat.executeQuery();

            while (curseur.next()) {
                Compo article = new Compo(curseur.getInt("ID"),	curseur.getInt("ID_ART"),
                        curseur.getInt("ID_BON"), curseur.getInt("QTE"));
                comp.add(article);
            }
            curseur.close();
            stat.close();
        }
        catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        return comp;
    }

    @Override
    public void insert(Compo data) {
        try {
            PreparedStatement stat = connection.prepareStatement("INSERT INTO COMPO (ID, ID_ART, ID_BON, QTE) VALUES (?, ?, ?, ?)");
            stat.setInt(1, data.getId());
            stat.setInt(2, data.getIdArticle());
            stat.setInt(3, data.getIdBon());
            stat.setInt(4, data.getQte());
            stat.executeUpdate();

            stat.close();
        }
        catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    }

    @Override
    public int update(Compo ancienNom, Compo nouveauNom) {

        try {
            PreparedStatement stat = connection.prepareStatement("UPDATE COMPO SET ID_ART = ?, ID_BON = ?, QTE = ? WHERE ID = ?");
            stat.setInt(1, nouveauNom.getIdArticle());
            stat.setInt(2, nouveauNom.getIdBon());
            stat.setInt(3, nouveauNom.getQte());
            stat.setInt(4, ancienNom.getId());
            stat.executeUpdate();
        }
        catch(Exception ex) {
            System.err.println(ex.getMessage());
        }

        return 0;
    }

    @Override
    public boolean delete(Compo data) {

        try {
            PreparedStatement stat = connection.prepareStatement("DELETE FROM COMPO WHERE ID = ?");
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
