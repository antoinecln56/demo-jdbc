package org.diginamic.fr;

import org.diginamic.fr.dao.Idao;
import org.diginamic.fr.dao.impl.CompoIdao;
import org.diginamic.fr.model.Compo;


import java.util.ArrayList;
import java.util.List;

public class UseCompoIdao {

    public static void main(String[] args) {


        try {
            CompoIdao comp = new CompoIdao();
            //getAffiche(comp);
            //insert(comp);
            //update(comp);
            delete(comp);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static void getAffiche(Idao<Compo> o) {
        o.extraire().forEach(comp -> System.out.println("ID ARTICLE : " + comp.getIdArticle() + " ID BON : " + comp.getIdBon() + " QUANTITE : " + comp.getQte()));

    }


    public static void insert(Idao<Compo> o) {

        List<Compo> compos = new ArrayList<>();
        compos.add(new Compo(17, 5, 4, 12));
        compos.add(new Compo(18, 7, 2, 14));

        for (Compo co : compos) {
            o.insert(co);
        }
    }

    public static void update(Idao<Compo> o) {
        Compo ancienNom = new Compo(17, 5, 4, 12);
        Compo nouveauNom = new Compo(17, 7, 4, 10);
        o.update(ancienNom, nouveauNom);
    }

    public static void delete(Idao<Compo> o) {
        Compo compos = new Compo(17,7,4,10);
        o.delete(compos);
    }
}
