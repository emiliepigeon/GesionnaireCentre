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