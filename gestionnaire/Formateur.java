// Je déclare que cette classe fait partie du package gestionnaire
package gestionnaire;

public class Formateur extends Personne {
    // Je déclare les attributs de la classe:
    private String matricule;

    // Je crée un constructeur pour initialiser un formateur
    public Formateur(String nom, String prenom, String mail, Centre centre, String matricule) {
        super(nom, prenom, mail, centre);
        this.matricule = matricule;
    }

    // Je crée les méthodes:
    public void ajouterFormation(Formation formation) {
        formations.add(formation);
        System.out.println(this.toString() + " a été ajouté à la formation " + formation.getLibelle());
    }

    public void modifierFormation(Formation formation) {
        // Code pour modifier une formation
        System.out.println("Formation " + formation.getLibelle() + " modifiée");
    }

    public void archiverFormation(Formation formation) {
        formations.remove(formation);
        System.out.println("Formation " + formation.getLibelle() + " archivée");
    }

    // Je n'implémente pas toutes les méthodes pour garder l'exemple simple

    // Getters:
    public String getMatricule() {
        return matricule;
    }
}
