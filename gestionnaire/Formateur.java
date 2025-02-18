// Je déclare que cette classe fait partie du package gestionnaire
package gestionnaire;

// Je crée la classe Formateur qui hérite de la classe Personne
public class Formateur extends Personne {
    // Je déclare l'attribut privé spécifique à un formateur
    private String matricule;

    // Je crée un constructeur pour créer un nouveau formateur
    public Formateur(String nom, String prenom, String mail, Centre centre, String matricule) {
        // J'appelle le constructeur de la classe parente (Personne)
        super(nom, prenom, mail, centre);
        // J'initialise le matricule spécifique au formateur
        this.matricule = matricule;
    }

    // Je surcharge la méthode toString pour afficher les informations du formateur
    @Override
    public String toString() {
        // Je retourne une chaîne de caractères qui décrit le formateur
        return "Formateur : " + getPrenom() + " " + getNom() + " (Matricule: " + matricule + ")";
    }

    // Je crée un getter pour récupérer le matricule du formateur
    public String getMatricule() {
        return matricule;
    }

    // Je crée une méthode pour ajouter une formation au formateur
    public void ajouterFormation(Formation formation) {
        // J'ajoute la formation à la liste des formations du formateur
        formations.add(formation);
        System.out.println(this.getPrenom() + " " + this.getNom() + " a été assigné à la formation : " + formation.getLibelle());
    }

    // Je crée une méthode pour modifier une formation (à implémenter plus tard)
    public void modifierFormation(Formation formation) {
        // Code pour modifier une formation (à compléter)
        System.out.println("Formation " + formation.getLibelle() + " modifiée par " + this.getPrenom() + " " + this.getNom());
    }

    // Je crée une méthode pour archiver (supprimer) une formation
    public void archiverFormation(Formation formation) {
        // Je retire la formation de la liste des formations du formateur
        formations.remove(formation);
        System.out.println("Formation " + formation.getLibelle() + " archivée par " + this.getPrenom() + " " + this.getNom());
    }

    // Les autres méthodes spécifiques aux formateurs peuvent être ajoutées ici
}
