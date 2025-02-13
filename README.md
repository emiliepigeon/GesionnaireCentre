13/02/2025 

Début TP = Appliction de gestion de centre

Schéma de hiérarchisation du projet:

```
textMonProjet/
│
├── Main.java
│
└── gestionnaire/
    ├── Centre.java
    ├── Formation.java
    ├── Personne.java
    ├── Stagiaire.java
    └── Formateur.java
```

Explication du schéma:

J'ai mis Main.java à la racine de mon projet car c'est le point d'entrée de mon programme.

Toutes les autres classes sont dans un package (comme un dossier) appelé "gestionnaire".

Ça me permet de bien organiser mon code et d'éviter les conflits de noms.
Personne est la classe mère de Stagiaire et Formateur. 

On appelle ça de l'héritage en programmation orientée objet. 

Ça veut dire que Stagiaire et Formateur ont toutes les caractéristiques de Personne, plus leurs propres spécificités.

Centre et Formation sont des classes indépendantes, mais elles sont liées aux autres classes car elles contiennent des listes de Formateurs et de Stagiaires.

-------------------------------------------------------------------------------------------------
Main.java:
-------------------------------------------------------------------------------------------------


-------------------------------------------------------------------------------------------------
PACKAGE: gestionnaire
-------------------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------------------
Centre.java:
-------------------------------------------------------------------------------------------------
Cette classe représente un centre de formation.

J'ai choisi d'utiliser des listes (ArrayList) pour stocker les formations, formateurs et stagiaires 
car je ne sais pas à l'avance combien il y en aura.

J'ai créé des méthodes pour ajouter des formations, formateurs et stagiaires, ainsi que pour obtenir 
leurs listes. Ça me permettra de gérer facilement le contenu de mon centre.

J'ai mis les attributs en privé (private) pour les protéger et j'ai créé des getters pour y accéder.

-------------------------------------------------------------------------------------------------
Formation.java:
-------------------------------------------------------------------------------------------------
Cette classe représente une formation donnée dans un centre.

J'ai utilisé la classe Date pour les dates de début et de fin. 
Je devrai peut-être importer 
java.util.Date pour que ça fonctionne.

J'ai créé une méthode toString() pour afficher facilement les informations d'une formation.

Comme pour la classe Centre, j'utilise des listes pour les formateurs et stagiaires.

-------------------------------------------------------------------------------------------------
Personne.java:
-------------------------------------------------------------------------------------------------
C'est ma classe mère pour Stagiaire et Formateur.

J'ai mis les attributs en protected pour que les classes filles puissent y accéder directement.

J'ai créé une méthode toString() qui sera héritée par Stagiaire et Formateur, ce qui me fait 
gagner du temps !

-------------------------------------------------------------------------------------------------
Stagiaire.java:
-------------------------------------------------------------------------------------------------
Cette classe hérite de Personne. J'utilise "extends Personne" pour ça.

J'ai ajouté un attribut identifiant qui est spécifique aux stagiaires.

J'ai créé une méthode historiqueFormations() qui affiche toutes les formations du stagiaire. 
C'est pratique pour voir son parcours !

-------------------------------------------------------------------------------------------------
Formateur.java:
-------------------------------------------------------------------------------------------------