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

    // Je crée un constructeur pour initialiser un centre
    public Centre(String numCentre, String libelle) {
        this.numCentre = numCentre;
        this.libelle = libelle;
        this.formations = new ArrayList<>();
        this.formateurs = new ArrayList<>();
        this.stagiaires = new ArrayList<>();
    }

    // Je crée les méthodes:
    public List<Formation> listeFormations() {
        return formations;
    }

    public List<Formateur> listeFormateurs() {
        return formateurs;
    }

    public List<Stagiaire> listeStagiaires() {
        return stagiaires;
    }

    public void ajouterFormation(Formation formation) {
        formations.add(formation);
    }

    public void inscriptionFormateur(Formateur formateur) {
        formateurs.add(formateur);
    }

    public void inscriptionStagiaire(Stagiaire stagiaire) {
        stagiaires.add(stagiaire);
    }

    // Getters:
    public String getNumCentre() {
        return numCentre;
    }

    public String getLibelle() {
        return libelle;
    }

    // Je n'ajoute pas tous les getters pour garder l'exemple simple
}