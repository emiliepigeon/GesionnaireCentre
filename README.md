/////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////// 25/02/2025 //////////////////////////////////////////////////

Question de Mathieu:
------------------------------------------------------------------------------------------------
1/ réfléchir au rôle de chaque classes
------------------------------------------------------------------------------------------------
Structure actuelle (phase1) de mon premier projet Gestionnaire de centre
Organisation des fichiers :

1. La classe `Main.java` à la racine = point d'entrée du programme.

2. L'utilisation d'un package `gestionnaire` pour regrouper les classes liées = organisation du code (pour moi c'est plus clair).

3. La hiérarchie des classes avec:
- `Personne` comme classe mère de `Stagiaire` et `Formateur`= utilisation de l'héritage en POO.

## Classes principales

- `Centre.java` : la classe qui gère l'ensemble du centre de formation.
- `Formation.java` : Représente les formations proposées.
- `Personne.java` : Classe de base pour les individus dans le système.
    => une méthode présentation peut être ajoutée pour afficher les informations de la personne. Quelque soit sont rang (stagiaire / formateur / responsable......)
    => l'utilisation de la class abstraite car Personne est une classe de base et ne peut pas être instanciée directement, mais les classes filles peuvent l'être. C'est une sorte de moule....
- `Stagiaire.java` : Représente un apprenant, hérite de `Personne`.
- `Formateur.java` : Représente un enseignant, hérite également de `Personne`.

## Relations entre les classes

1. `Centre` et `Formation` sont liés, chaque Centre gérent plusieurs Formations.
2. `Formation` contient des listes de `Stagiaire` et de `Formateur`.
3. `Stagiaire` et `Formateur` héritent des attributs et méthodes de `Personne`, tout en ayant leurs propres spécificités.

------------------------------------------------------------------------------------------------
2/ réfléchir aux interfaces qui peuvent être implémentées dans le projet
------------------------------------------------------------------------------------------------

 L'ajout d'interfaces pour définir des comportements communs et améliorer la flexibilité et la structure de mon code (et du projet = du programme).

 J'ai pensé à créer l'interface Gestion de service 'GestionService' pour définir de méthodes communes entre les classes de gestion (Stagiaire, Formateur..... responsable).
 Cette Interface 'GestionService' pour standardiser les opérations CRUD :
 -CREAT (inscrire un stagiaire à un parcours de formation ou un formateur)
 -READ (afficher les informations d'un stagiaire ou d'un formateur)
 -UPDATE (mettre à jour si changement dans les données => ex email...)
 -DELETE (supprimer un stagiaire ou un formateur)

 public interface GestionService<T> {
    void ajouter(T element);
    T obtenir(int id);
    List<T> obtenirTous();
    void modifier(T element);
    void supprimer(int id);
}
// Le T dans l'interface GestionService<T> est un paramètre de type générique. 

 EX de class qui implémente cette interface (pour chaque type d'entité) :
 public class GestionStagiaire implements GestionService<Stagiaire> {
    private List<Stagiaire> stagiaires = new ArrayList<>();

    @Override
    public void ajouter(Stagiaire stagiaire) {
        stagiaires.add(stagiaire);
    }

    @Override
    public Stagiaire obtenir(int id) {
        return stagiaires.get(id);
    }

    @Override
    public List<Stagiaire> obtenirTous() {
        return new ArrayList<>(stagiaires);
    }

    @Override
    public void modifier(Stagiaire stagiaire) {
        // Logique de modification
    }

    @Override
    public void supprimer(int id) {
        stagiaires.remove(id);
    }
}

// Similairement pour GestionFormateur voir => GestionFormation

-------

 Pour plus de logique je renomme mes classes:
 - 'Personne.java' = "GestionPersonne.java" => classe mère
 - 'Stagiaire.java' = "GestionStagiaire.java" => class fille de 'GestionPersonne.java'
 - 'Formateur.java' = "GestionFormateur.java" => class fille de 'GestionPersonne.java"

Ensuite, je fais en sorte que mes classes comme GestionStagiaire et GestionFormateur "implémentent" cette interface. Cela signifie qu'elles doivent avoir toutes ces méthodes.

L'avantage, c'est que je peux maintenant traiter tous mes services de gestion de la même manière, peu importe s'il s'agit de stagiaires ou de formateurs. C'est comme si je créais un "contrat" que toutes ces classes doivent respecter.

La logique derrière cela est de rendre mon code plus uniforme et plus facile à comprendre. Si je veux ajouter un nouveau type de personne plus tard, comme un "Administrateur", je sais exactement quelles méthodes je dois inclure.

Je peux aussi créer plusieurs types d'interfaces au besoin si il y a des comportements différents entre les classes de gestion.
Une classe peut implémenter plusieurs interfaces.

En clair : certaines classes peuvent avoir besoin de méthodes spécifiques qui ne s'appliquent pas aux autres. Dans ce cas, je peux soit ajouter ces méthodes en plus de celles de l'interface, soit créer des interfaces plus spécifiques pour ces cas particuliers.
Car je pense qu'il faut faire attention à ne pas trop généraliser.

En résumé, utiliser des interfaces me permet de mieux organiser mon code, de le rendre plus cohérent et plus facile à étendre à l'avenir. C'est un peu comme créer un plan standard pour toutes mes classes de gestion, tout en gardant la possibilité d'ajouter des particularités quand c'est nécessaire.

------------------------------------------------------------------------------------------------
3/ réfléchir a l'intégration d'une base de données (quel package Java est utilisé, qui va gérer les interactions, comment intégrer ca au projet, etc)
------------------------------------------------------------------------------------------------

Alors j'ai cherché et d'après les indices donnés (SQLite en utilisant le gestionnaire de dépances Maven).

JDBC (Java Database Connectivity) est une API Java qui permet aux développeurs d'interagir avec des bases de données relationnelles.

Pour établir une connexion à une base de données SQLite en utilisant Maven comme gestionnaire de dépendances, suivez ces étapes:

1. Ajoutez la dépendance SQLite JDBC à votre fichier `pom.xml` :
2. Dans le code Java, utiliser le pilote JDBC pour SQLite pour établir la connexion :
..... à partir de là j'ai une vague idée (de dev web)...
"chemin/vers/votre/base.db" par le chemin réel vers votre fichier de base de données SQLite.

## Persistance des données

1. Utilisez JDBC pour vous connecter à votre base de données SQLite.
2. Implémentez les méthodes CRUD de l'interface GestionService pour chaque entité.

//////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
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

18/02/2025 -----------------------------------------------------

public Centre(String numCentre, String libelle, String responsable, String adresse, String codePostal, String ville) {
    this.numCentre = numCentre;
    this.libelle = libelle;
    this.responsable = responsable;
    this.adresse = adresse;
    this.codePostal = codePostal;
    this.ville = ville;
}

    Rôle : Ce constructeur est utilisé pour créer un nouveau centre de formation. C'est comme si je remplissais un formulaire pour enregistrer un nouveau centre dans mon programme. Il a besoin de toutes ces informations : numCentre (le numéro du centre), libelle (son nom), responsable (le nom du responsable), adresse, codePostal, et ville.

    Fonctionnement : Il prend toutes ces informations et les range dans les variables de l'objet Centre. J'utilise this pour dire que je parle bien des variables de l'objet, et non des variables que je reçois en paramètre. C'est un peu comme si j'avais des étagères (les variables de l'objet) et que je rangeais les informations dessus.

    Commentaire : C'est bien de commenter, ça m'aide à me souvenir de ce que fait chaque partie du code.



-------------------------------------------------------------------------------------------------
Formation.java:
-------------------------------------------------------------------------------------------------
Cette classe représente une formation donnée dans un centre.

J'ai utilisé la classe Date pour les dates de début et de fin. 
Je devrai peut-être importer 
java.util.Date pour que ça fonctionne.

J'ai créé une méthode toString() pour afficher facilement les informations d'une formation.

Comme pour la classe Centre, j'utilise des listes pour les formateurs et stagiaires.

18/02/2025-----------------------------------------------

public Formation(String numOffre, String libelle, Date dateDebut, Date dateFin, Centre centre) {
    this.numOffre = numOffre;
    this.libelle = libelle;
    this.dateDebut = dateDebut;
    this.dateFin = dateFin;
    this.centre = centre;
    this.formateurs = new ArrayList<>();
    this.stagiaires = new ArrayList<>();
}

    Rôle : Ce constructeur sert à créer une nouvelle formation. Il a besoin du numOffre (le numéro de l'offre de formation), du libelle (le nom de la formation), des dates de début et de fin (dateDebut, dateFin), et du centre où se déroule la formation.

    Fonctionnement : Il range toutes ces informations dans les variables de l'objet Formation. Il crée aussi deux listes vides : formateurs et stagiaires. Comme pour la classe Personne, c'est une bonne idée de créer ces listes ici pour éviter les erreurs plus tard.

    Commentaire : OK, je comprends pourquoi initialiser les listes ici, c'est plus sûr !


-------------------------------------------------------------------------------------------------
Personne.java:
-------------------------------------------------------------------------------------------------
C'est ma classe mère pour Stagiaire et Formateur.

J'ai mis les attributs en protected pour que les classes filles puissent y accéder directement.

J'ai créé une méthode toString() qui sera héritée par Stagiaire et Formateur, ce qui me fait 
gagner du temps !

18/02/2025-----------------------------------------------------

public Personne(String nom, String prenom, String mail, Centre centre) {
    this.nom = nom;
    this.prenom = prenom;
    this.mail = mail;
    this.centre = centre;
    this.formations = new ArrayList<>();
}

    Rôle : Ce constructeur sert à créer une nouvelle personne, que ce soit un stagiaire ou un formateur. Il a besoin du nom, du prenom, du mail et du centre où travaille la personne.

    Fonctionnement : Il range les informations dans les variables de l'objet Personne. Il crée aussi une nouvelle liste vide formations. C'est important de le faire ici, sinon ma liste de formations pourrait être vide (null), et ça causerait des problèmes plus tard.

    Commentaire : Bien pensé d'initialiser formations ici !


-------------------------------------------------------------------------------------------------
Stagiaire.java:
-------------------------------------------------------------------------------------------------
Cette classe hérite de Personne. J'utilise "extends Personne" pour ça.

J'ai ajouté un attribut identifiant qui est spécifique aux stagiaires.

J'ai créé une méthode historiqueFormations() qui affiche toutes les formations du stagiaire. 
C'est pratique pour voir son parcours !

18/02/2025--------------------------------------------------

// Je crée un constructeur pour créer un nouveau stagiaire

public Stagiaire(String nom, String prenom, String mail, Centre centre, String identifiant) {
    // J'appelle le constructeur de la classe parente (Personne)
    super(nom, prenom, mail, centre);
    // J'initialise l'identifiant spécifique au stagiaire
    this.identifiant = identifiant;
}

    Rôle : Ce constructeur sert à créer un nouvel objet Stagiaire. Il a besoin de toutes les informations de base d'une personne (nom, prénom, email, centre), et en plus, il a besoin de l'identifiant unique du stagiaire.

    Fonctionnement : D'abord, il utilise le mot-clé super() pour appeler le constructeur de la classe Personne (la classe parente). Cela permet d'initialiser les attributs nom, prenom, mail et centre qui sont définis dans Personne. Ensuite, il initialise l'attribut identifiant spécifique à la classe Stagiaire.

    Pourquoi c'est important : C'est essentiel d'appeler le constructeur de la classe parente avec super() pour s'assurer que tous les attributs hérités sont correctement initialisés. Si on ne le fait pas, on risque d'avoir des erreurs ou un comportement inattendu.



-------------------------------------------------------------------------------------------------
Formateur.java:
-------------------------------------------------------------------------------------------------
Comme Stagiaire, cette classe hérite de Personne.

J'ai ajouté un attribut matricule spécifique aux formateurs.

J'ai créé des méthodes pour gérer les formations (ajouter, modifier, archiver). 
Je n'ai pas implémenté toutes les méthodes pour simplifier l'exemple.

18/02/2025-----------------------------------------------------------------

public Formateur(String nom, String prenom, String mail, Centre centre, String matricule) {
    super(nom, prenom, mail, centre);
    this.matricule = matricule;
}

    Rôle : Ce constructeur sert à créer un nouveau formateur. Il a besoin des mêmes informations qu'une personne normale (nom, prenom, mail, centre), mais aussi du matricule spécifique au formateur.

    Fonctionnement : Il appelle d'abord le constructeur de la classe Personne (avec super()) pour ranger les informations communes. Ensuite, il range le matricule dans la variable de l'objet Formateur. C'est important d'appeler super() en premier, sinon je risque d'avoir des problèmes !

    Commentaire : Je me souviendrai d'appeler super() en premier !

18/02/2025--------------- MES CONSTRUCTEURS ---------------------------------

En résumé :

    Mes constructeurs servent à créer de nouveaux objets de chaque classe.

    Ils ont besoin de différentes informations pour bien initialiser les objets.

    J'ai appris à utiliser this et super() correctement.


/////////////////////////////////////////////////////////////////////////////////////////////////

Suite du projet => toujours donnéesen dur dans le code et affichage uniquement en console
17 et 18/02/2025

Gestionnaire de Centre de Formation
Description

Ce projet est un petit programme que j'ai créé pour apprendre à gérer des centres de formation en Java. Il me permet de manipuler des concepts comme les classes, les objets, les listes et les maps. Avec ce programme, je peux gérer des stagiaires et des formateurs associés à différents centres de formation.
Fonctionnalités

Voici ce que mon programme peut faire pour l'instant :

    Créer des Centres : Je peux créer des centres de formation avec des informations comme le nom, le responsable, l'adresse, etc.

    Ajouter des Stagiaires : Je peux ajouter des stagiaires à chaque centre avec leurs informations personnelles (nom, prénom, email, identifiant).

    Ajouter des Formateurs : Je peux ajouter des formateurs à chaque centre avec leurs informations personnelles (nom, prénom, email, matricule).

    Afficher les Informations : Mon programme affiche tous les stagiaires et formateurs associés à chaque centre.

Structure du Projet

J'ai organisé mon projet en plusieurs fichiers Java pour bien séparer les responsabilités de chaque classe. Voici comment il est structuré :

    Main.java : C'est le point d'entrée de mon programme. C'est ici que je crée mes centres, mes stagiaires et mes formateurs. Ensuite, je les affiche.

    Centre.java : Cette classe représente un centre de formation. Elle contient des informations comme le numéro du centre, son nom (libellé), son responsable et son adresse.

    Formation.java : Cette classe représente une formation dans un centre. Elle permet d'ajouter des stagiaires et des formateurs à une formation.

    Personne.java : C'est une classe parent qui regroupe les informations communes aux stagiaires et aux formateurs (comme le nom, le prénom et l'email).

    Stagiaire.java : Cette classe hérite de Personne et ajoute un identifiant unique pour chaque stagiaire.

    Formateur.java : Cette classe hérite aussi de Personne et ajoute un matricule unique pour chaque formateur.

Installation

Voici comment je fais pour exécuter mon programme :

    Je m'assure d'avoir Java installé sur mon ordinateur. Si ce n'est pas déjà fait, je peux télécharger Java ici.

    Je place tous mes fichiers .java dans un dossier.

    J'ouvre un terminal ou une invite de commande (par exemple PowerShell ou Bash....).

    Je vais dans le dossier où se trouvent mes fichiers Java avec la commande cd.

    Je compile mon programme avec cette commande :


    javac Main.java

Une fois que tout est compilé sans erreur, j'exécute mon programme avec cette commande :

    
    java Main

Utilisation

Quand j'exécute mon programme, il affiche dans la console tous les stagiaires et formateurs associés à chaque centre. C'est simple et pratique pour vérifier que tout fonctionne correctement !
Ce que j'ai appris

En travaillant sur ce projet, j'ai appris plusieurs choses importantes en Java :

    Comment créer des classes et utiliser l'héritage (extends) pour réutiliser du code.

    Comment manipuler des listes (ArrayList) et des maps (HashMap) pour organiser mes données.

    Comment structurer un projet en plusieurs fichiers pour qu'il soit plus clair.

Problèmes rencontrés

Comme je débute en Java, j'ai rencontré quelques problèmes pendant que je codais ce projet :

    Les accolades manquantes : J'ai parfois oublié de fermer mes accolades { }, ce qui a causé des erreurs "reached end of file while parsing". Maintenant, je vérifie toujours que chaque accolade ouvrante a bien une accolade fermante.

    Les méthodes non trouvées : J'avais oublié d'ajouter certaines méthodes dans mes classes (comme setMail()), ce qui a causé des erreurs "cannot find symbol". J'ai appris à bien vérifier que toutes les méthodes nécessaires sont définies.

Ce que je veux améliorer

Voici quelques idées pour améliorer mon projet à l'avenir :

    Ajouter une interface utilisateur simple (par exemple, avec une interaction via la console) pour permettre d'ajouter ou de modifier les centres, stagiaires et formateurs sans changer le code.

    Gérer les dates dans les formations (par exemple, la date de début et la date de fin) pour rendre le programme plus réaliste.

    Ajouter une validation sur les emails ou d'autres champs pour éviter les erreurs.

C'est tout pour l'instant ! Ce projet m'aide beaucoup à comprendre les bases de la programmation orientée objet en Java. Si vous avez des suggestions ou si vous voulez m'aider à l'améliorer, n'hésitez pas ! 😊

SUITE-------------------------------------------------------------------------------------------
Mon projet est une application console Java qui gère des centres de formation, des stagiaires et des formateurs. Voici comment il est structuré et comment il fonctionne :

    Structure du projet :

        Main.java : C'est le point d'entrée de mon programme. Il contient la méthode main().

        Centre.java : Définit la classe Centre avec ses attributs (numéro, libellé, responsable, adresse, etc.).

        Personne.java : Une classe abstraite qui sert de base pour Stagiaire et Formateur.

        Stagiaire.java : Hérite de Personne et ajoute un identifiant unique.

        Formateur.java : Hérite de Personne et ajoute un matricule.

        Formation.java : Représente une formation avec une liste de stagiaires et de formateurs.

    Fonctionnement :
    Dans Main.java, je crée d'abord des objets Centre. Ensuite, j'utilise des Map<Centre, List<Stagiaire>> et Map<Centre, List<Formateur>> pour associer des listes de stagiaires et de formateurs à chaque centre.

    Je crée ensuite des objets Stagiaire et Formateur et les ajoute aux listes correspondantes dans les Map.

    Enfin, j'affiche tous les stagiaires et formateurs par centre en parcourant ces Map.

    Points clés :

        J'utilise l'héritage pour factoriser le code commun entre Stagiaire et Formateur dans la classe Personne.

        Les Map me permettent d'organiser facilement les stagiaires et formateurs par centre.

        J'utilise des boucles for-each pour parcourir les Map et afficher les informations.

    Améliorations possibles :

        Ajouter des méthodes pour ajouter/supprimer des stagiaires et formateurs dynamiquement.

        Implémenter une interface utilisateur simple pour interagir avec le programme.

        Ajouter des validations pour les entrées (par exemple, vérifier le format des emails).

Ce projet m'a permis de pratiquer les concepts de base de la programmation orientée objet en Java, comme les classes, l'héritage, et l'utilisation de collections.

-----------------------------------------------------------------------------------------------
Mom main.java en détailles


    Structure générale :
    Mon Main.java est la classe principale de mon programme. Elle contient la méthode main(), qui est le point d'entrée de l'application.

    Imports :
    Au début du fichier, j'importe les classes nécessaires, notamment Centre, Stagiaire, Formateur, ainsi que les classes utilitaires comme ArrayList, List, Map, et HashMap.

    Création des centres :
    Dans la méthode main(), je commence par créer deux objets Centre : centreCandau et centreBosquet. Chaque centre est initialisé avec ses informations spécifiques (numéro, libellé, responsable, adresse, etc.).

    Initialisation des Map :
    Je crée ensuite deux Map :

        stagiaireParCentre : pour associer chaque centre à sa liste de stagiaires

        formateurParCentre : pour associer chaque centre à sa liste de formateurs
        Ces Map utilisent Centre comme clé et une List<Stagiaire> ou List<Formateur> comme valeur.

    Ajout des stagiaires et formateurs :
    J'ajoute ensuite plusieurs stagiaires et formateurs à chaque centre en utilisant la méthode add() sur les listes obtenues via get() sur les Map.

    Affichage des informations :
    Enfin, j'utilise deux boucles for imbriquées pour afficher les informations :

        La boucle externe parcourt les centres (clés des Map)

        La boucle interne parcourt les stagiaires ou formateurs de chaque centre

    Points d'apprentissage :

        J'ai appris à utiliser des structures de données complexes comme Map et List.

        J'ai pratiqué la création d'objets et leur ajout dans des collections.

        J'ai utilisé des boucles for-each pour parcourir efficacement mes collections.

Ce Main.java me permet de simuler la gestion de centres de formation avec leurs stagiaires et formateurs associés, tout en affichant ces informations de manière organisée.

///// Réorganisation du code du main pour l'affichage en console /////
## Améliorations de l'organisation des sorties en console

J'ai réorganisé les sorties en console pour une meilleure lisibilité et une présentation plus structurée des informations. Désormais, j'affiche les informations regroupées par centre de formation, avec les sections suivantes pour chaque centre :

1.  **Formations proposées :** Je liste les formations dispensées dans le centre.

2.  **Formateurs :** J'affiche la liste des formateurs affectés au centre.

3.  **Stagiaires :** Je présente un tableau formaté avec les noms, prénoms et adresses e-mail des stagiaires inscrits au centre.

4.  **Formations suivies par les formateurs :** Je liste les formations suivies par chaque formateur du centre.

Je pense que cette réorganisation facilite la consultation des informations relatives à chaque centre et améliore l'expérience utilisateur lors de l'exécution du programme.

**Fichiers modifiés et raisons :**

*   **`Main.java` :** J'ai introduit une nouvelle méthode, `afficherInfosCentre`, qui prend en charge l'affichage des informations pour un centre donné. Cette méthode permet de regrouper les données pertinentes (formations, formateurs, stagiaires, formations suivies) et de les présenter de manière cohérente. J'ai également modifié la méthode `main` pour appeler cette nouvelle méthode pour chaque centre, assurant ainsi une organisation uniforme des sorties.

*   **`Formation.java` :** J'ai ajouté un getter pour récupérer le centre associé à une formation (`getCentre()`). Cette modification est essentielle pour permettre à la méthode `afficherInfosCentre` de déterminer quelles formations sont proposées dans chaque centre.





