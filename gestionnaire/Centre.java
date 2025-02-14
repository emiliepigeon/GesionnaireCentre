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
    private List<Formation> formations;
    private List<Formateur> formateurs;
    private List<Stagiaire> stagiaires;

    // Je crée un constructeur pour initialiser un centre avec toutes les informations
    public Centre(String numCentre, String libelle, String responsable, String adresse, String codePostal, String ville) {
        // J'utilise this pour différencier les attributs de la classe des paramètres du constructeur
        this.numCentre = numCentre;
        this.libelle = libelle;
        this.responsable = responsable;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
        // J'initialise mes listes vides
        this.formations = new ArrayList<>();
        this.formateurs = new ArrayList<>();
        this.stagiaires = new ArrayList<>();
    }

    // Je crée une méthode pour afficher les informations du centre
    public void afficherInfos() {
        System.out.println("Centre n°" + numCentre + " : " + libelle);
        System.out.println("Responsable : " + responsable);
        System.out.println("Adresse : " + adresse + ", " + codePostal + " " + ville);
    }

    // Je crée les méthodes pour gérer mes listes:
    public List<Formation> listeFormations() {
        // Je retourne la liste des formations
        return formations;
    }

    public List<Formateur> listeFormateurs() {
        // Je retourne la liste des formateurs
        return formateurs;
    }

    public List<Stagiaire> listeStagiaires() {
        // Je retourne la liste des stagiaires
        return stagiaires;
    }

    public void ajouterFormation(Formation formation) {
        // J'ajoute une formation à ma liste
        formations.add(formation);
    }

    public void inscriptionFormateur(Formateur formateur) {
        // J'ajoute un formateur à ma liste
        formateurs.add(formateur);
    }

    public void inscriptionStagiaire(Stagiaire stagiaire) {
        // J'ajoute un stagiaire à ma liste
        stagiaires.add(stagiaire);
    }

    // Je crée les getters pour accéder à mes attributs privés:
    public String getNumCentre() {
        return numCentre;
    }

    public String getLibelle() {
        return libelle;
    }

    public String getResponsable() {
        return responsable;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public String getVille() {
        return ville;
    }

    // Je ne crée pas de setters car je ne veux pas que ces informations changent après la création du centre
}
