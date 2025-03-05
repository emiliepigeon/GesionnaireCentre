package crud;

import java.util.List;

public interface CRUD<T> {
    /**
     * Crée une nouvelle entité.
     * @param entity L'entité à créer.
     */
    void create(T entity);

    /**
     * Lit une entité par son identifiant.
     * @param id L'identifiant de l'entité à lire.
     * @return L'entité trouvée, ou null si non trouvée.
     */
    T read(int id);

    /**
     * Lit toutes les entités.
     * @return Une liste de toutes les entités.
     */
    List<T> readAll();

    /**
     * Met à jour une entité existante.
     * @param entity L'entité à mettre à jour.
     */
    void update(T entity);

    /**
     * Supprime une entité par son identifiant.
     * @param id L'identifiant de l'entité à supprimer.
     */
    void delete(int id);
}
