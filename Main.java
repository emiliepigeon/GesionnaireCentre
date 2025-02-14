// J'importe la classe Centre du package gestionnaire
import gestionnaire.Centre;

public class Main {
    // La méthode main est le point de départ de mon programme
    public static void main(String[] args) {
        // J'affiche un message pour vérifier que mon programme fonctionne
        System.out.println("Mon programme fonctionne !");
        
        // Je crée un objet Centre avec toutes les informations
        Centre monCentre = new Centre("001", "Centre Candau", "Marie Dupont", "3 rue des Fleurs", "40000", "Mont-de-Marsan");
        
        // J'affiche les informations du centre
        monCentre.afficherInfos();
    }
}
