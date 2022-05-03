package org.diginamic.fr;

import org.diginamic.fr.dao.FournisseurDao1;
import org.diginamic.fr.model.Fournisseur;

import java.util.List;

public class App02 {

    public static void main(String[] args) {

        List<Fournisseur> maListe = FournisseurDao1.getAll();

        for(Fournisseur fou : maListe){
            System.out.println("Id : " + fou.getId() + " Nom : " + fou.getNom());
        }
    }
}
