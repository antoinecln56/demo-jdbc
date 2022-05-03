package org.diginamic.fr;

import org.diginamic.fr.dao.impl.ArticlesIdao;
import org.diginamic.fr.dao.Idao;
import org.diginamic.fr.model.Articles;
import org.diginamic.fr.model.Fournisseur;

import java.util.ArrayList;
import java.util.List;

public class UseArticlesIdao {

    public static void main(String[] args) {

        try {
            ArticlesIdao art = new ArticlesIdao();
            //getAffiche(art);
            //insert(art);
            //update(art);
            delete(art);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }


    }

    public static void getAffiche(Idao<Articles> o) {
        o.extraire().forEach(art -> System.out.println("REF : " + art.getRef() + " DESIGNATION : " + art.getDesignation() + " PRIX : " + art.getPrix()));

    }


    public static void insert(Idao<Articles> o) {

        List<Articles> articles = new ArrayList<>();
        articles.add(new Articles(11, "E02", "Peinture jaune", 37, 4));
        articles.add(new Articles(12, "E03", "Peinture noire", 40, 4));
        articles.add(new Articles(13, "G05", "Grande vis", 8, 4));
        articles.add(new Articles(14, "G07", "Tourne-vis", 7, 4));

        for (Articles article : articles) {
            o.insert(article);
        }
    }

    public static void update(Idao<Articles> o) {
        Articles ancienNom = new Articles(3, "F02", "Boulon laiton 5 x 40 mm (sachet de 10)", (float) 4.45, 2);
        Articles nouveauNom = new Articles(3,"F05", "Ciment", 30, 2);
        o.update(ancienNom, nouveauNom);
    }

    public static void delete(Idao<Articles> o) {
        Articles article = new Articles(14, "G07", "Tourne-vis", 7, 4);
        o.delete(article);
    }
}
