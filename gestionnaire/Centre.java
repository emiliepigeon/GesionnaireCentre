// Je déclare que cette classe fait partie du package gestionnaire
package gestionnaire;

// J'importe les classes ArrayList et List pour gérer mes listes
import java.util.ArrayList;
import java.util.List;

public class Centre {
    // Je déclare les attributs de la classe:
    private String numCentre;
    private String libelle;
    private String responsable;
    private String adresse;
    private String codePostal;
    private String ville;

    // Je crée un constructeur pour initialiser un centre avec toutes les informations
    public Centre(String numCentre, String libelle, String responsable, String adresse, String codePostal, String ville) {
        // J'utilise this pour différencier les attributs de la classe des paramètres du constructeur
        this.numCentre = numCentre;
        this.libelle = libelle;
        this.responsable = responsable;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
    }

    // Je crée une méthode pour afficher les informations du centre
    @Override
    public String toString() {
        return "Centre " + libelle + " (n°" + numCentre + ")";
    }

    // Je crée les getters pour accéder à mes attributs privés:
    public String getNumCentre() {
        return numCentre;
    }

    public String getLibelle() {
        return libelle;
    }

    // ... Ajoutez les autres getters si nécessaire
}
