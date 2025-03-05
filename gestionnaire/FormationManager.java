package gestionnaire;

import crud.CRUD;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class FormationManager implements CRUD<Formation> {
    private List<Formation> formations;

    public FormationManager() {
        this.formations = new ArrayList<>();
    }

    @Override
    public void create(Formation formation) {
        formations.add(formation);
        System.out.println("Formation ajoutée : " + formation);
    }

    @Override
    public Formation read(int id) {
        if (id >= 0 && id < formations.size()) {
            return formations.get(id);
        }
        System.out.println("Formation non trouvée pour l'ID : " + id);
        return null;
    }

    @Override
    public List<Formation> readAll() {
        return new ArrayList<>(formations);
    }

    @Override
    public void update(Formation formation) {
        int index = findIndexByNumOffre(formation.getNumOffre());
        if (index != -1) {
            formations.set(index, formation);
            System.out.println("Formation mise à jour : " + formation);
        } else {
            System.out.println("Formation non trouvée pour la mise à jour : " + formation);
        }
    }

    @Override
    public void delete(int id) {
        if (id >= 0 && id < formations.size()) {
            Formation formation = formations.remove(id);
            System.out.println("Formation supprimée : " + formation);
        } else {
            System.out.println("Formation non trouvée pour la suppression, ID : " + id);
        }
    }

    // Méthodes supplémentaires spécifiques aux formations
    public Formation findByNumOffre(String numOffre) {
        for (Formation formation : formations) {
            if (formation.getNumOffre().equals(numOffre)) {
                return formation;
            }
        }
        System.out.println("Formation non trouvée pour le numéro d'offre : " + numOffre);
        return null;
    }

    public List<Formation> findByCentre(Centre centre) {
        List<Formation> formationsDuCentre = new ArrayList<>();
        for (Formation formation : formations) {
            if (formation.getCentre().equals(centre)) {
                formationsDuCentre.add(formation);
            }
        }
        return formationsDuCentre;
    }

    public List<Formation> findByDateRange(Date debut, Date fin) {
        List<Formation> formationsDansLaPeriode = new ArrayList<>();
        for (Formation formation : formations) {
            if (formation.getDateDebut().after(debut) && formation.getDateFin().before(fin)) {
                formationsDansLaPeriode.add(formation);
            }
        }
        return formationsDansLaPeriode;
    }

    private int findIndexByNumOffre(String numOffre) {
        for (int i = 0; i < formations.size(); i++) {
            if (formations.get(i).getNumOffre().equals(numOffre)) {
                return i;
            }
        }
        return -1;
    }
}
