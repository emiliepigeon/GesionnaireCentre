package gestionnaire;

import crud.CRUD;
import java.util.ArrayList;
import java.util.List;

public class FormateurManager implements CRUD<Formateur> {
    private List<Formateur> formateurs;

    public FormateurManager() {
        this.formateurs = new ArrayList<>();
    }

    @Override
    public void create(Formateur formateur) {
        formateurs.add(formateur);
        System.out.println("Formateur ajouté : " + formateur);
    }

    @Override
    public Formateur read(int id) {
        if (id >= 0 && id < formateurs.size()) {
            return formateurs.get(id);
        }
        System.out.println("Formateur non trouvé pour l'ID : " + id);
        return null;
    }

    @Override
    public List<Formateur> readAll() {
        return new ArrayList<>(formateurs);
    }

    @Override
    public void update(Formateur formateur) {
        int index = formateurs.indexOf(formateur);
        if (index != -1) {
            formateurs.set(index, formateur);
            System.out.println("Formateur mis à jour : " + formateur);
        } else {
            System.out.println("Formateur non trouvé pour la mise à jour : " + formateur);
        }
    }

    @Override
    public void delete(int id) {
        if (id >= 0 && id < formateurs.size()) {
            Formateur formateur = formateurs.remove(id);
            System.out.println("Formateur supprimé : " + formateur);
        } else {
            System.out.println("Formateur non trouvé pour la suppression, ID : " + id);
        }
    }

    // Méthodes supplémentaires spécifiques aux formateurs
    public Formateur findByMatricule(String matricule) {
        for (Formateur formateur : formateurs) {
            if (formateur.getMatricule().equals(matricule)) {
                return formateur;
            }
        }
        System.out.println("Formateur non trouvé pour le matricule : " + matricule);
        return null;
    }

    public List<Formateur> findByFormation(Formation formation) {
        List<Formateur> formateursDeLaFormation = new ArrayList<>();
        for (Formateur formateur : formateurs) {
            if (formateur.getFormationsEnseignees().contains(formation)) {
                formateursDeLaFormation.add(formateur);
            }
        }
        return formateursDeLaFormation;
    }
}
