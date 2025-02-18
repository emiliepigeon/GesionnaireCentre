// Je déclare que cette classe fait partie du package gestionnaire
package gestionnaire;

// J'importe la classe List pour gérer la liste des formations
import java.util.List;
import java.util.ArrayList;

// Je crée la classe Stagiaire qui hérite de la classe Personne
public class Stagiaire extends Personne {
    // Je déclare l'attribut privé spécifique à un stagiaire
    private String identifiant;
    // J'ajoute un attribut pour stocker la formation suivie par le stagiaire
    private Formation formationSuivie;

    // Je crée un constructeur pour créer un nouveau stagiaire
    public Stagiaire(String nom, String prenom, String mail, Centre centre, String identifiant, Formation formationSuivie) {
        // J'appelle le constructeur de la classe parente (Personne)
        super(nom, prenom, mail, centre);
        // J'initialise l'identifiant spécifique au stagiaire
        this.identifiant = identifiant;
        // J'initialise la formation suivie par le stagiaire
        this.formationSuivie = formationSuivie;
    }

    // Je crée une méthode pour afficher les informations du stagiaire
    @Override
    public String toString() {
        // Je retourne une chaîne de caractères qui décrit le stagiaire
        return "Stagiaire : " + this.getPrenom() + " " + this.getNom() +
                " (ID: " + this.identifiant + ") - Centre : " + this.getCentre().getLibelle() +
                " - Formation : " + (this.formationSuivie != null ? this.formationSuivie.getLibelle() : "Non assignée");
    }

    // Je crée une méthode pour changer l'adresse e-mail du stagiaire
    public void changerMail(String nouveauMail) {
        // Je change l'e-mail
        this.mail = nouveauMail; // Si l'attribut mail est accessible
        // J'affiche un message pour confirmer le changement
        System.out.println("L'adresse e-mail de " + this.getPrenom() + " " + this.getNom() + " a été mise à jour.");
    }

    // Je crée un getter pour récupérer l'identifiant du stagiaire
    public String getIdentifiant() {
        return identifiant;
    }

    // Je crée un getter pour récupérer la formation suivie par le stagiaire
    public Formation getFormationSuivie() {
        return formationSuivie;
    }

    // Je crée une méthode pour définir la formation suivie par le stagiaire
    public void setFormationSuivie(Formation formation) {
        this.formationSuivie = formation;
    }
}
