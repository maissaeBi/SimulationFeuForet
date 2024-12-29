package simulation;

import java.util.logging.Logger;

import model.Foret;
import utils.ConfigReader;

public class Simulation {

    /** logger */
    private static Logger logger = Logger.getLogger(Simulation.class.getName());

    private static ConfigReader configReader = new ConfigReader();
    private static Foret foret;

    public static void main(String[] args) {
        try {
            // Lire les paramètres de configuration du fichier xml pour initialiser la forêt
            configReader.lireConfigurationsXML();
            foret = new Foret(configReader.getLargeur(), configReader.getHauteur(), configReader.getArbresEnFeu(),
                    configReader.getProbabilite());

            int t = 0;
            // On maintient la simulation tant qu'il reste des arbres en feu.
            while (foret.contientArbresEnFeu()) {
                System.out.println("# Itération : " + t);
                foret.afficherGrille();
                System.out.println();
                foret.propaguerFeu();
                t++;
            }
            System.out.println("Itération finale : " + t);
            foret.afficherGrille();
            System.out.println();
            System.out.println("#### Simulation terminée.#####");

        } catch (Exception e) {
            logger.severe("Une erreur est survenue lors de l'exécution de la simulation : " + e.getMessage());
        }

    }
}
