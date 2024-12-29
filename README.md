# SimulationFeuForet


### Description

**SimulationFeuForet** est une application qui simule la propagation du feu à travers une forêt en utilisant un modèle 2D, où chaque cellule représente un arbre avec des états tels que intact, en feu, ou brûlé, et applique un algorithme pour étendre le feu aux arbres voisins selon une probabilité définie, basée sur des configurations lues dans un fichier XML.


### Structure du projet

ForestFireSimulation/
├── src/
│   ├── model/
│   │   ├── Foret.java         // Classe représentant la forêt.
│   │   ├── Arbre.java         // Décrit un arbre avec ses différents états (intact, en feu, brûlé).
│   │   ├── Etat.java          // Enum pour les différents états des arbres.
│   │   └── Position.java      // Représente les coordonnées des arbres dans la forêt.
│   ├── utils/
│   │   └── ConfigReader.java  // Classe pour lire les paramètres depuis un fichier XML pour configurer les  paramètres de simulation.
│   ├── simulation/
│   │   └── Simulation.java    // Classe principale contenant la logique de simulation et d'affichage.
├── config/
│   └── simulation_config.xml  // Fichier de configuration


### Fonctionnalités principales

1. **Simulation du feu**  
   - Simule la propagation d’un incendie dans une forêt.
   - Le feu se propage aux arbres voisins selon une probabilité définie.

2. **Gestion des états des arbres**  
   - Les arbres peuvent avoir les états :  
     - **INTACT** : L'arbre est intact.  
     - **EN_FEU** : L'arbre en feu.  
     - **BRULE** : L'arbre a été totalement détruit par le feu.

3. **Configuration via fichier XML**  
   - Lecture des paramètres depuis un fichier XML :
     - Largeur et hauteur de la forêt.
     - Probabilité de propagation du feu.
     - Positions initiales des arbres en feu.

4. **Propagation du feu**  
   - Propagation du feu à travers la forêt à l'aide de la méthode `propagerFeu()`.

#### Lancer l'application

Pour lancer l'application, utilisez la fonction `main` de la classe `Simulation` située dans le dossier `src/simulation/`.
