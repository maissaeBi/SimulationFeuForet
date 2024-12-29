# SimulationFeuForet


### Description

**SimulationFeuForet** est une application qui simule la propagation du feu à travers une forêt en utilisant un modèle 2D, où chaque cellule représente un arbre avec des états tels que intact, en feu, ou brûlé, et applique un algorithme pour étendre le feu aux arbres voisins selon une probabilité définie, basée sur des configurations lues dans un fichier XML.


Vous avez dit :
dans mon fichier readme j'ai la ctrucutre de proget affcheir d'une maniere bizarre comme ça  Structure du projet
ForestFireSimulation/ ├── src/ │ ├── model/ │ │ ├── Foret.java // Classe représentant la forêt. │ │ ├── Arbre.java // Décrit un arbre avec ses différents états (intact, en feu, brûlé). │ │ ├── Etat.java // Enum pour les différents états des arbres. │ │ └── Position.java // Représente les coordonnées des arbres dans la forêt. │ ├── utils/ │ │ └── ConfigReader.java // Classe pour lire les paramètres depuis un fichier XML pour configurer les paramètres de simulation. │ ├── simulation/ │ │ └── Simulation.java // Classe principale contenant la logique de simulation et d'affichage. ├── config/ │ └── simulation_config.xml // Fichier de configuration
ChatGPT a dit :
ChatGPT

Votre structure semble correcte, mais elle est présentée de manière peu claire dans votre fichier README. Voici une version plus structurée et visuellement nette pour améliorer la lisibilité :

Structure du projet
-------------------

- **ForestFireSimulation/**
  ├── **src/**
  │   ├── **model/**
  │   │   ├── **Foret.java**              // Classe représentant la forêt.
  │   │   ├── **Arbre.java**              // Décrit un arbre avec ses différents états (intact, en feu, brûlé).
  │   │   ├── **Etat.java**               // Enum pour les différents états des arbres.
  │   │   └── **Position.java**           // Représente les coordonnées des arbres dans la forêt.
  │   ├── **utils/**
  │   │   └── **ConfigReader.java**       // Classe pour lire les paramètres depuis un fichier XML pour configurer les paramètres de simulation.
  │   ├── **simulation/**
  │   │   └── **Simulation.java**         // Classe principale contenant la logique de simulation et d'affichage.
  ├── **config/**
  │   └── **simulation_config.xml**      // Fichier de configuration

Points notés :

    Les sous-dossiers et fichiers sont listés en format hiérarchique.
    Chaque fichier ou répertoire est accompagné d'une courte description pour une meilleure compréhension.

Ainsi, la structure est plus propre et facile à parcourir.
Vous avez dit :
mais comment le fichier readme respecte les espaces au lieu de l'ecrire dans une seule ligne
ChatGPT a dit :
ChatGPT

Pour formater correctement votre fichier README avec des espaces pour une présentation hiérarchique claire, vous devez ajouter des espaces ou des tabulations en début de ligne pour indenter les sous-dossiers ou fichiers. Voici un exemple avec des espaces indentés :

Structure du projet
-------------------

- **ForestFireSimulation/**
  ├── **src/**
      ├── **model/**
      │   ├── **Foret.java**              // Classe représentant la forêt.
      │   ├── **Arbre.java**              // Décrit un arbre avec ses différents états (intact, en feu, brûlé).
      │   ├── **Etat.java**               // Enum pour les différents états des arbres.
      │   └── **Position.java**           // Représente les coordonnées des arbres dans la forêt.
      ├── **utils/**
      │   └── **ConfigReader.java**       // Classe pour lire les paramètres depuis un fichier XML pour configurer les paramètres de simulation.
      ├── **simulation/**
      │   └── **Simulation.java**         // Classe principale contenant la logique de simulation et d'affichage.
  ├── **config/**
      └── **simulation_config.xml**      // Fichier de configuration


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


# Lancer l'application

Pour lancer l'application, utilisez la fonction `main` de la classe `Simulation` située dans le dossier `src/simulation/`.