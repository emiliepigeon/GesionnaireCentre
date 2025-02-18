// Je déclare que cette classe fait partie du package gestionnaire
package gestionnaire;

import java.util.ArrayList;
import java.util.List;

public class Personne {
    // Je déclare les attributs de la classe:
    protected String nom;
    protected String prenom;
    protected String mail;
    protected Centre centre;
    protected List<Formation> formations;

    // Je crée un constructeur pour initialiser une personne
    public Personne(String nom, String prenom, String mail, Centre centre) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.centre = centre;
        this.formations = new ArrayList<>();
    }

    // Je crée les méthodes:
    @Override
    public String toString() {
        return prenom + " " + nom;
    }

    // Getters:
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getMail() {
        return mail;
    }

    public Centre getCentre() {
        return centre;
    }

    // Je n'ajoute pas tous les getters pour garder l'exemple simple
}
