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
        return "Stagiaire : " + this.getPrenom() + " " + this.getNom() + " (Identifiant : " + this.identifiant + ")";
    }

    // Je crée un getter pour récupérer l'identifiant du stagiaire
    public String getIdentifiant() {
        return identifiant;
    }

    // Je crée un getter pour récupérer l'e-mail du stagiaire
    public String getMail() {
        return mail;
    }

    // Les autres méthodes (ajouterFormation, historiqueFormations, changerMail) 
    // seront implémentées plus tard
}
