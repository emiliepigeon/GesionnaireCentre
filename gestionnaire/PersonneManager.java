package gestionnaire;

import crud.CRUD;
import java.util.ArrayList;
import java.util.List;

public abstract class PersonneManager<T extends Personne> implements CRUD<T> {
    protected List<T> personnes;

    public PersonneManager() {
        this.personnes = new ArrayList<>();
    }

    @Override
    public void create(T personne) {
        personnes.add(personne);
        System.out.println("Personne ajoutée : " + personne);
    }

    @Override
    public T read(int id) {
        if (id >= 0 && id < personnes.size()) {
            return personnes.get(id);
        }
        System.out.println("Personne non trouvée pour l'ID : " + id);
        return null;
    }

    @Override
    public List<T> readAll() {
        return new ArrayList<>(personnes);
    }

    @Override
    public void update(T personne) {
        int index = personnes.indexOf(personne);
        if (index != -1) {
            personnes.set(index, personne);
            System.out.println("Personne mise à jour : " + personne);
        } else {
            System.out.println("Personne non trouvée pour la mise à jour : " + personne);
        }
    }

    @Override
    public void delete(int id) {
        if (id >= 0 && id < personnes.size()) {
            T personne = personnes.remove(id);
            System.out.println("Personne supprimée : " + personne);
        } else {
            System.out.println("Personne non trouvée pour la suppression, ID : " + id);
        }
    }

    // Méthodes supplémentaires spécifiques aux personnes
    public T findByEmail(String email) {
        for (T personne : personnes) {
            if (personne.getMail().equals(email)) {
                return personne;
            }
        }
        System.out.println("Personne non trouvée pour l'email : " + email);
        return null;
    }

    public List<T> findByCentre(Centre centre) {
        List<T> personnesDuCentre = new ArrayList<>();
        for (T personne : personnes) {
            if (personne.getCentre().equals(centre)) {
                personnesDuCentre.add(personne);
            }
        }
        return personnesDuCentre;
    }
}
