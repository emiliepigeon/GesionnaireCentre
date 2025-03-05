package gestionnaire;

import java.util.ArrayList;
import java.util.List;

public class StagiaireManager extends PersonneManager<Stagiaire> {

    public StagiaireManager() {
        super();
    }

    // Méthode spécifique pour trouver un stagiaire par son identifiant
    public Stagiaire findByIdentifiant(String identifiant) {
        for (Stagiaire stagiaire : personnes) {
            if (stagiaire.getIdentifiant().equals(identifiant)) {
                return stagiaire;
            }
        }
        System.out.println("Stagiaire non trouvé pour l'identifiant : " + identifiant);
        return null;
    }

    // Méthode pour trouver tous les stagiaires d'une formation spécifique
    public List<Stagiaire> findByFormation(Formation formation) {
        List<Stagiaire> stagiairesDeFormation = new ArrayList<>();
        for (Stagiaire stagiaire : personnes) {
            if (stagiaire.getFormationSuivie() != null && stagiaire.getFormationSuivie().equals(formation)) {
                stagiairesDeFormation.add(stagiaire);
            }
        }
        return stagiairesDeFormation;
    }

    // Méthode pour changer la formation d'un stagiaire
    public void changerFormation(Stagiaire stagiaire, Formation nouvelleFormation) {
        stagiaire.setFormationSuivie(nouvelleFormation);
        System.out.println("Formation changée pour " + stagiaire.getPrenom() + " " + stagiaire.getNom() + 
                           " : " + nouvelleFormation.getLibelle());
    }

    // Surcharge de la méthode create pour s'assurer que l'identifiant est unique
    @Override
    public void create(Stagiaire stagiaire) {
        if (findByIdentifiant(stagiaire.getIdentifiant()) == null) {
            super.create(stagiaire);
        } else {
            System.out.println("Un stagiaire avec cet identifiant existe déjà : " + stagiaire.getIdentifiant());
        }
    }

    // Surcharge de la méthode update pour mettre à jour en fonction de l'identifiant
    @Override
    public void update(Stagiaire stagiaire) {
        Stagiaire existingStagiaire = findByIdentifiant(stagiaire.getIdentifiant());
        if (existingStagiaire != null) {
            int index = personnes.indexOf(existingStagiaire);
            personnes.set(index, stagiaire);
            System.out.println("Stagiaire mis à jour : " + stagiaire);
        } else {
            System.out.println("Stagiaire non trouvé pour la mise à jour : " + stagiaire);
        }
    }
}
