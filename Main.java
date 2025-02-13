// Je suis le fichier principal qui lance mon programme
// J'importe le package.fichier nécessaire
import gestionnaire.Centre;

public class Main {
    // La méthode main est le point de départ de mon programme
    public static void main(String[] args) {
        // J'appelle System.out.println() pour vérifier la syntaxe minimale
        System.out.println("Mon programme fonctionne !");
        
        // Je crée un objet Centre pour tester
        Centre monCentre = new Centre("001", "Centre Candau");
        System.out.println("J'ai créé un centre : " + monCentre.getLibelle());
    }
}
