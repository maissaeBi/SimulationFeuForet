package model;

import java.util.List;

public class Foret {

    /* GRILLE */
    private Arbre[][] grille;
    /* LARGEUR */
    private int largeur;
    /* HAUTEUR */
    private int hauteur;
    /* PROBABILITE */
    private double probabilite;
    /* ARBRESENFEU */
    private List<Position> arbresEnFeu;

    /**
     * Cette méthode initialise une simulation d'une forêt contenant une grille 2D
     * d'arbres,
     * où chaque arbre peut avoir un état représentant son statut (Par défaut un
     * arbre a un staut "INTACT")
     * 
     * @param largeur     La largeur de la grille représentant la forêt.
     * @param hauteur     La hauteur de la grille représentant la forêt.
     * @param arbresEnFeu Une liste de positions représentant les arbres
     *                    initialement en feu.
     * @param probabilite La probabilité avec laquelle un arbre adjacent prend feu.
     */
    public Foret(int largeur, int hauteur, List<Position> arbresEnFeu, double probabilite) {
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.arbresEnFeu = arbresEnFeu;
        this.probabilite = probabilite;
        this.grille = new Arbre[hauteur][largeur];
        initialiserGrille();
    }

    /**
     * 
     * Initialise la grille 2D avec des arbres, en marquant les positions des arbres
     * en feu.
     */
    private void initialiserGrille() {
        for (int i = 0; i < hauteur; i++) {
            for (int j = 0; j < largeur; j++) {
                grille[i][j] = new Arbre();
                // Vérification des positions d'arbres en feu à partir du fichier XML
                for (Position position : arbresEnFeu) {
                    if (position.getX() == j && position.getY() == i) {
                        grille[i][j].setEtat(Etat.EN_FEU);
                    }
                }
            }

        }
    }

    /**
     * Propagation du feu à travers la forêt.
     * Cette méthode met à jour les états des arbres en fonction de leur voisinage
     * et d'une probabilité d'extension du feu.
     */
    public void propaguerFeu() {
        Arbre[][] grilleTemp = new Arbre[hauteur][largeur];

        // Copier la grille actuelle dans une nouvelle grille temporaire
        for (int i = 0; i < hauteur; i++) {
            for (int j = 0; j < largeur; j++) {
                grilleTemp[i][j] = new Arbre(grille[i][j].getEtat());
            }
        }

        // Parcourir la grille pour propager le feu
        for (int i = 0; i < hauteur; i++) {
            for (int j = 0; j < largeur; j++) {
                Position positionActuelle = new Position(i, j);

                if (grille[i][j].getEtat() == Etat.EN_FEU) {
                    // Vérifier les voisins adjacents
                    for (int di = -1; di <= 1; di++) {
                        for (int dj = -1; dj <= 1; dj++) {
                            // Calculer la position du voisin
                            int voisinX = i + di;
                            int voisinY = j + dj;

                            // Vérifier si la position du voisin apartien au dimension de la grille
                            if (voisinX >= 0 && voisinX < hauteur && voisinY >= 0 && voisinY < largeur) {
                                Position voisin = new Position(voisinX, voisinY);

                                // Vérifier si le voisin est adjacent et intact
                                if (positionActuelle.estAdjacente(voisin) &&
                                        grille[voisinX][voisinY].getEtat() == Etat.INTACT) {

                                    // Propager le feu avec une probabilité ( d'une manière aléatoire)
                                    if (Math.random() < probabilite) {
                                        grilleTemp[voisinX][voisinY].setEtat(Etat.EN_FEU);
                                    }
                                }
                            }
                        }
                    }

                    // L'arbre actuel devient brûlé
                    grilleTemp[i][j].setEtat(Etat.BRULE);
                }
            }
        }
        grille = grilleTemp;
    }

    /**
     * Affiche la grille de la forêt avec des couleurs représentant les différents
     * états des arbres.
     */

    public void afficherGrille() {
        for (int i = 0; i < hauteur; i++) {
            for (int j = 0; j < largeur; j++) {
                System.out.print(grille[i][j].getEtat().getCouleur() + "\t");
            }
            System.out.println();
        }
    }
    

    /**
     * Vérifie si la forêt contient encore des arbres en feu.
     * 
     * @return `true` s'il existe des arbres en feu, sinon `false`.
     */
    public boolean contientArbresEnFeu() {
        for (int i = 0; i < hauteur; i++) {
            for (int j = 0; j < largeur; j++) {
                if (grille[i][j].getEtat() == Etat.EN_FEU) {
                    return true;
                }
            }
        }
        return false;
    }

}
