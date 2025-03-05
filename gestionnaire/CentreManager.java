package gestionnaire;

import crud.CRUD;
import java.util.ArrayList;
import java.util.List;

public class CentreManager implements CRUD<Centre> {
    private List<Centre> centres;

    public CentreManager() {
        this.centres = new ArrayList<>();
    }

    @Override
    public void create(Centre centre) {
        centres.add(centre);
    }

    @Override
    public Centre read(int id) {
        // Ici, on suppose que l'id est l'index dans la liste
        if (id >= 0 && id < centres.size()) {
            return centres.get(id);
        }
        return null;
    }

    @Override
    public List<Centre> readAll() {
        return new ArrayList<>(centres);
    }

    @Override
    public void update(Centre centre) {
        int index = centres.indexOf(centre);
        if (index != -1) {
            centres.set(index, centre);
        }
    }

    @Override
    public void delete(int id) {
        if (id >= 0 && id < centres.size()) {
            centres.remove(id);
        }
    }
}
