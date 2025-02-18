// Je déclare que cette classe fait partie du package gestionnaire
package gestionnaire;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Formation {
    // Je déclare les attributs de la classe:
    private String numOffre;
    private String libelle;
    private Date dateDebut;
    private Date dateFin;
    private Centre centre;
    private List<Formateur> formateurs;
    private List<Stagiaire> stagiaires;

    // Je crée un CONSTRUCTEUR pour initialiser une formation
    public Formation(String numOffre, String libelle, Date dateDebut, Date dateFin, Centre centre) {
        this.numOffre = numOffre;
        this.libelle = libelle;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.centre = centre;
        this.formateurs = new ArrayList<>();
        this.stagiaires = new ArrayList<>();
    }

    // Je crée les méthodes:
    @Override
    public String toString() {
        return "Formation " + libelle + " (n°" + numOffre + ")";
    }

    public List<Formateur> listeFormateurs() {
        return formateurs;
    }

    public List<Stagiaire> listeStagiaires() {
        return stagiaires;
    }

    public void inscriptionFormateur(Formateur formateur) {
        formateurs.add(formateur);
    }

    public void inscriptionStagiaire(Stagiaire stagiaire) {
        stagiaires.add(stagiaire);
    }

    // Getters:
    public String getNumOffre() {
        return numOffre;
    }

    public String getLibelle() {
        return libelle;
    }

    // Je n'ajoute pas tous les getters pour garder l'exemple simple
}
