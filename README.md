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
----------------------
Explication du schéma:
----------------------
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
Dans ce fichier, j'ai créé la classe principale de mon programme. C'est ici que tout commence !

J'ai choisi de mettre un simple message pour vérifier que mon programme fonctionne. 
Ensuite, j'ai créé un objet Centre pour tester si je peux utiliser ma classe Centre.

Je n'ai pas mis de package car Main.java est à la racine de mon projet.

----------------------------------
Suite modifications 14/02/2025
----------------------------------
J'ai mis à jour mon fichier Main.java pour utiliser le nouveau constructeur de la classe Centre.

Maintenant, quand je crée un objet Centre, je lui donne toutes les informations : numéro, 
libellé, responsable, adresse, code postal et ville.

J'ai ajouté un appel à la méthode afficherInfos() pour voir toutes les informations du centre 
que je viens de créer. Ça me permet de vérifier que tout fonctionne correctement.

J'ai gardé mon message "Mon programme fonctionne !" au début. Comme ça, je sais tout de suite 
si mon programme démarre bien.

Ce fichier Main.java me sert de point d'entrée pour tester mes autres classes. Je peux y ajouter 
d'autres tests au fur et à mesure que je développe mon projet.

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

----------------------------------
Suite modifications 14/02/2025
----------------------------------
J'ai ajouté de nouveaux attributs à ma classe Centre : responsable, adresse, codePostal et ville. 
Ça me permet d'avoir plus d'informations sur chaque centre.

J'ai aussi créé un nouveau constructeur qui prend tous ces attributs en paramètres. Comme ça, 
je peux initialiser un centre avec toutes ses informations dès sa création.

J'ai ajouté une méthode afficherInfos() qui me permet d'afficher facilement toutes les 
informations d'un centre. C'est pratique pour vérifier que tout est bien enregistré !

J'ai créé des getters pour tous les attributs, mais pas de setters. J'ai fait ce choix parce 
que je pense que ces informations ne devraient pas changer une fois le centre créé. Si on veut 
les modifier, il faudra créer un nouveau centre.

Toutes mes méthodes sont commentées pour que je puisse comprendre facilement ce qu'elles font 
quand je relirai mon code plus tard.


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
Comme Stagiaire, cette classe hérite de Personne.

J'ai ajouté un attribut matricule spécifique aux formateurs.

J'ai créé des méthodes pour gérer les formations (ajouter, modifier, archiver). 
Je n'ai pas implémenté toutes les méthodes pour simplifier l'exemple.

/////////////////////////////////////////////////////////////////////////////////////////////////