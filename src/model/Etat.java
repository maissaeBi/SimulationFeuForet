package model;

public enum Etat {
    /* Arbre intact */
    INTACT("vert"),
    /*  Arbre en feu */
    EN_FEU("rouge"),
    /* Arbre brûlé (cendre) */
    BRULE("gris");

    /* Couleur associée à l'état */
    private final String couleur;


    Etat(String couleur) {
        this.couleur = couleur;
    }

    public String getCouleur() {
        return couleur;
    }
}