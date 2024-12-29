package utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.*;
import model.Position;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.logging.Logger;

public class ConfigReader {
    /** logger */
    private static Logger logger = Logger.getLogger(ConfigReader.class.getName());

    private static final String configPath = "config/simulation_config.xml";
    private int largeur;
    private int hauteur;
    private double probabilite;
    private List<Position> arbresEnFeu;

    public int getLargeur() {
        return largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public double getProbabilite() {
        return probabilite;
    }

    public List<Position> getArbresEnFeu() {
        return arbresEnFeu;
    }

    /*
     * Lit le fichier XML de configuration contenant les paramètres de la simulation
     */
    public void lireConfigurationsXML() {
        try {
            File xmlFile = new File(configPath);

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            DocumentBuilder builder = factory.newDocumentBuilder();

            // Chargez le fichier XML
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();

            largeur = Integer.parseInt(document.getElementsByTagName("largeur").item(0).getTextContent());
            hauteur = Integer.parseInt(document.getElementsByTagName("hauteur").item(0).getTextContent());
            probabilite = Double.parseDouble(document.getElementsByTagName("probabilite").item(0).getTextContent());

            arbresEnFeu = new ArrayList<>();

            // Parcourez les positions des arbres en feu
            NodeList arbreNodes = document.getElementsByTagName("arbre");
            for (int i = 0; i < arbreNodes.getLength(); i++) {
                Element arbreElement = (Element) arbreNodes.item(i);
                int x = Integer.parseInt(arbreElement.getElementsByTagName("x").item(0).getTextContent());
                int y = Integer.parseInt(arbreElement.getElementsByTagName("y").item(0).getTextContent());
                arbresEnFeu.add(new Position(x, y));
            }

        } catch (Exception e) {
            logger.severe("Erreur critique lors de la lecture du fichier XML de configuration : "
                    + "Nom du fichier : 'simulation_config.xml', Détail de l'exception : " + e.getMessage());
        }
    }
}
