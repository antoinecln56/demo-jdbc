package org.diginamic.fr;

import org.diginamic.fr.dao.Idao;
import org.diginamic.fr.dao.impl.ArticlesIdao;
import org.diginamic.fr.dao.impl.BonIdao;
import org.diginamic.fr.model.Articles;
import org.diginamic.fr.model.Bon;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UseBonIdao {

    public static void main(String[] args) {


        try {
            BonIdao bo = new BonIdao();
            //getAffiche(bo);
            insert(bo);
            //update(bo);
            //delete(bo);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }


    }

    public static void getAffiche(Idao<Bon> o) {
        o.extraire().forEach(art -> System.out.println("NUMERO : " + art.getNumero() + " DATE COMMANDE : " + art.getDateCmde() + " DELAI : " + art.getDelai()));

    }


    public static void insert(Idao<Bon> o) {

        List<Bon> bo = new ArrayList<>();
        bo.add(new Bon(7, 7, Timestamp.valueOf(LocalDateTime.now()), 8, 4));
        bo.add(new Bon(8, 8, Timestamp.valueOf(LocalDateTime.now()), 12, 4));

        for (Bon bon : bo) {
            o.insert(bon);
        }
    }

}
