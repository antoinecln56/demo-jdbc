package org.diginamic.fr;

import org.diginamic.fr.dao.Idao;
import org.diginamic.fr.dao.impl.FournisseurIdao;
import org.diginamic.fr.model.Fournisseur;

public class UseFournisseurIdao {

    public static void main(String[] args) {
        /**
         * Utiliser classe FournisseurIdao pour afficher la liste des fournisseurs
         */
        try{
            FournisseurIdao foi = new FournisseurIdao();
            //getAffiche(foi);
            //insert(foi);
            //update(foi);
            delete(foi);
        }
        catch (Exception ex){
            System.err.println(ex.getMessage());
        }

    }

    /**
     * Methode qui gère un objet de type Idao
     */
    public static void getAffiche(Idao<Fournisseur> o) {
        o.extraire().forEach(fo ->System.out.println(fo.getNom()));
    }

    public static void insert(Idao<Fournisseur> o) {
        Fournisseur fournisseur = new Fournisseur(8, "Le Petit Jojo");
        o.insert(fournisseur);
    }

    public static void update(Idao<Fournisseur> o) {
        Fournisseur ancienNom = new Fournisseur(5, "La Maison");
        Fournisseur nouveauNom = new Fournisseur(5, "La Grande Maison");
        o.update(ancienNom, nouveauNom);
    }

    public static void delete(Idao<Fournisseur> o) {
        Fournisseur fournisseur = new Fournisseur(8, "Le Petit Jojo");
        o.delete(fournisseur);
    }
}
