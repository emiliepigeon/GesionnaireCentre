// Je déclare que cette classe fait partie du package gestionnaire
package gestionnaire;

public class Stagiaire extends Personne {
    // Je déclare les attributs de la classe:
    private String identifiant;

    // Je crée un constructeur pour initialiser un stagiaire
    public Stagiaire(String nom, String prenom, String mail, Centre centre, String identifiant) {
        super(nom, prenom, mail, centre);
        this.identifiant = identifiant;
    }

    // Je crée les méthodes:
    public void historiqueFormations() {
        System.out.println("Historique des formations pour " + this.toString() + ":");
        for (Formation formation : formations) {
            System.out.println("- " + formation.toString());
        }
    }

    public void changerMail(String nouveauMail) {
        this.mail = nouveauMail;
        System.out.println("Adresse e-mail mise à jour pour " + this.toString());
    }

    // Getters:
    public String getIdentifiant() {
        return identifiant;
    }
}
