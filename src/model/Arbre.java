package model;

public class Arbre {
    /* ETAT */
    private Etat etat;

    /*
     * Constructeur par défaut de l'arbre
     */
    public Arbre() {
        this.etat = Etat.INTACT;
    }

    /**
     * Constructeur de l'arbre avec un état spécifique.
     *
     * @param etat L'état de l'arbre (INTACT, EN_FEU, BRULE, etc.).
     */
    public Arbre(Etat etat) {
        this.etat = etat;
    }

    /*
     * Getter
     */
    public Etat getEtat() {
        return etat;
    }

    /**
     * Met à jour l'état de l'arbre.
     * 
     * @param etat
     */
    public void setEtat(Etat etat) {
        this.etat = etat;
    }
}
