// Je déclare que cette classe fait partie du package gestionnaire
package gestionnaire;

// J'importe la classe ArrayList pour gérer la liste des formations
import java.util.ArrayList;
import java.util.List;

// Je crée la classe Formateur qui hérite de la classe Personne
public class Formateur extends Personne {
    // Je déclare les attributs spécifiques à un formateur
    private String matricule;
    
    // Je crée un constructeur pour initialiser un formateur
    public Formateur(String nom, String prenom, String mail, Centre centre, String matricule) {
        // J'appelle le constructeur de la classe parente (Personne)
        super(nom, prenom, mail, centre);
        // J'initialise le matricule spécifique au formateur
        this.matricule = matricule;
    }

    // Je crée une méthode pour afficher les informations du formateur
    @Override
    public String toString() {
        return "Formateur : " + this.getPrenom() + " " + this.getNom() + " (Matricule : " + this.matricule + ")";
    }

    // Je crée un getter pour récupérer le matricule du formateur
    public String getMatricule() {
        return matricule;
    }

    // Les autres méthodes (ajouterFormation, modifierFormation, archiverFormation) 
    // seront implémentées plus tard
}
