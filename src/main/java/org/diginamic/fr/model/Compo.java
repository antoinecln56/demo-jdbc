package org.diginamic.fr.model;

public class Compo {

    int id;
    int idArticle;
    int idBon;
    int qte;

    public Compo() { }

    public Compo(int id, int idArticle, int idBon, int qte) {
        this.id = id;
        this.idArticle = idArticle;
        this.idBon = idBon;
        this.qte = qte;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    public int getIdBon() {
        return idBon;
    }

    public void setIdBon(int idBon) {
        this.idBon = idBon;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }
}
