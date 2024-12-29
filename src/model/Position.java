package model;

public class Position {
    /* Coordonnée x (colonne) */
    private final int x;
    /* Coordonnée y (ligne) */
    private final int y;

    // Constructeur
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Getters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    /**
     * Vérifie si une position donnée est adjacente à la postion actuelle.
     * 
     * Une position est considérée adjacente si elle se trouve à un cran horizontal, vertical.
     * 
     * @param position La position à comparer avec la position actuelle.
     * @return `true` si les positions sont adjacentes, sinon `false`.
     */
    public Boolean estAdjacente(Position position) {
        // Calculer la différence absolue entre les coordonnées x et y des deux positions
        int dx = Math.abs(this.x - position.x);
        int dy = Math.abs(this.y - position.y);

        // Vérifier l'adjacence horizontale, verticale
        return dx <= 1 && dy <= 1; 
    }
}
