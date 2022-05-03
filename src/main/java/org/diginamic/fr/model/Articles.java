package org.diginamic.fr.model;

public class Articles {

    int id;
    String ref;
    String designation;
    float prix;
    int idFou;

    public Articles() { }

    public Articles(int id, String ref, String designation, float prix, int idFou) {
        this.id = id;
        this.ref = ref;
        this.designation = designation;
        this.prix = prix;
        this.idFou = idFou;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getIdFou() {
        return idFou;
    }

    public void setIdFou(int idFou) {
        this.idFou = idFou;
    }
}
