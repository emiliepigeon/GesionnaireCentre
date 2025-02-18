// Je déclare que cette classe fait partie du package gestionnaire
package gestionnaire;

// Je crée la classe Stagiaire qui hérite de la classe Personne
public class Stagiaire extends Personne {
    // Je déclare l'attribut privé spécifique à un stagiaire
    private String identifiant;

    // Je crée un constructeur pour créer un nouveau stagiaire
    public Stagiaire(String nom, String prenom, String mail, Centre centre, String identifiant) {
        // J'appelle le constructeur de la classe parente (Personne)
        super(nom, prenom, mail, centre);
        // J'initialise l'identifiant spécifique au stagiaire
        this.identifiant = identifiant;
    }

    // Je crée une méthode pour afficher les informations du stagiaire
    @Override
    public String toString() {
        // Je retourne une chaîne de caractères qui décrit le stagiaire
        return "Stagiaire : " + this.getPrenom() + " " + this.getNom() + 
                " (ID: " + this.identifiant + ") - Centre : " + this.getCentre().getLibelle();
    }

    // Je crée une méthode pour changer l'adresse e-mail du stagiaire
    public void changerMail(String nouveauMail) {
        // Je change l'e-mail
        this.mail = nouveauMail; // Si l'attribut mail est accessible
        // J'affiche un message pour confirmer le changement
        System.out.println("L'adresse e-mail de " + this.getPrenom() + " " + this.getNom() + " a été mise à jour.");
    }

    // Je crée un getter pour récupérer l

}
