// J'importe toutes les classes dont j'ai besoin pour mon programme
import gestionnaire.Centre;
import gestionnaire.Stagiaire;
import gestionnaire.Formateur;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

// Je crée ma classe principale qui s'appelle Main
public class Main {
    // La méthode main est le point d'entrée de mon programme
    public static void main(String[] args) {
        // Je crée mes deux centres de formation
        Centre centreCandau = new Centre("4001", "Candau", "Sabrina", "Boulevard Ferdinand de Candau", "40000", "Mont-de-Marsan");
        Centre centreBosquet = new Centre("4002", "Bosquet", "Sabrina", "Boulevard Ferdinand de Candau", "40000", "Mont-de-Marsan");

        // Je crée des Maps pour stocker les stagiaires et formateurs par centre
        // Une Map est comme un dictionnaire qui associe une clé (ici, le centre) à une valeur (ici, une liste de personnes)
        Map<Centre, List<Stagiaire>> stagiaireParCentre = new HashMap<>();
        Map<Centre, List<Formateur>> formateurParCentre = new HashMap<>();

        // J'initialise les listes vides pour chaque centre dans mes Maps
        // Cela me permettra d'ajouter des stagiaires et des formateurs à chaque centre
        stagiaireParCentre.put(centreCandau, new ArrayList<>());
        stagiaireParCentre.put(centreBosquet, new ArrayList<>());
        formateurParCentre.put(centreCandau, new ArrayList<>());
        formateurParCentre.put(centreBosquet, new ArrayList<>());

        // J'ajoute les stagiaires à leurs centres respectifs
        // Pour chaque nouveau stagiaire, je crée un objet Stagiaire et je l'ajoute à la liste du centre correspondant
        stagiaireParCentre.get(centreCandau).add(new Stagiaire("Némar", "Jean", "jean.nemar@fmail.wip", centreCandau, "010101"));
        stagiaireParCentre.get(centreCandau).add(new Stagiaire("Croche", "Sarah", "sarah.croche@fmail.wip", centreCandau, "010102"));
        stagiaireParCentre.get(centreCandau).add(new Stagiaire("Pote", "Jacques", "jacques.pote@fmail.wip", centreCandau, "010103"));
        stagiaireParCentre.get(centreCandau).add(new Stagiaire("Voyant", "Claire", "claire.voyant@fmail.wip", centreCandau, "010104"));
        stagiaireParCentre.get(centreCandau).add(new Stagiaire("Attes", "Tom", "tom.attes@fmail.wip", centreCandau, "010105"));
        stagiaireParCentre.get(centreCandau).add(new Stagiaire("Formatik", "Alain", "alain.formatik@fmail.wip", centreCandau, "010106"));
        stagiaireParCentre.get(centreCandau).add(new Stagiaire("Stiqué", "Sophie", "sophie.stique@fmail.wip", centreCandau, "010107"));
        stagiaireParCentre.get(centreCandau).add(new Stagiaire("Mau", "Dyna", "dyna.mau@fmail.wip", centreCandau, "010108"));
        stagiaireParCentre.get(centreCandau).add(new Stagiaire("Matique", "Mathieu", "mathieu.matique@fmail.wip", centreCandau, "010109"));
        stagiaireParCentre.get(centreCandau).add(new Stagiaire("Hération", "Alex", "alex.heration@fmail.wip", centreCandau, "010110"));
        stagiaireParCentre.get(centreCandau).add(new Stagiaire("Tare", "Guy", "guy.tare@fmail.wip", centreCandau, "010111"));
        stagiaireParCentre.get(centreCandau).add(new Stagiaire("Hitic", "Paul", "paul.hitic@fmail.wip", centreCandau, "010112"));
        stagiaireParCentre.get(centreBosquet).add(new Stagiaire("Fite", "Néo", "neo.fite@fmail.wip", centreBosquet, "010113"));
        stagiaireParCentre.get(centreBosquet).add(new Stagiaire("Pierre", "Emma", "emma.pierre@fmail.wip", centreBosquet, "010114"));
        stagiaireParCentre.get(centreBosquet).add(new Stagiaire("Javel", "Aude", "aude.javel@fmail.wip", centreBosquet, "010115"));
        stagiaireParCentre.get(centreBosquet).add(new Stagiaire("Tation", "Lévy", "levy.tation@fmail.wip", centreBosquet, "010116"));
        stagiaireParCentre.get(centreBosquet).add(new Stagiaire("Verse", "Alain", "alain.verse@fmail.wip", centreBosquet, "010117"));
        stagiaireParCentre.get(centreBosquet).add(new Stagiaire("Peplu", "Jean", "jean.peplu@fmail.wip", centreBosquet, "010118"));

        // J'ajoute les formateurs à leurs centres respectifs
        // Pour chaque nouveau formateur, je crée un objet Formateur et je l'ajoute à la liste du centre correspondant
        formateurParCentre.get(centreCandau).add(new Formateur("Sanschaise", "Mathieu", "mathieu.sanchez@afpa.fr", centreCandau, "010101"));
        formateurParCentre.get(centreCandau).add(new Formateur("Podpod", "Arnaud", "arnaud.podpod@afpa.fr", centreCandau, "020202"));
        formateurParCentre.get(centreCandau).add(new Formateur("Leroc", "Samson", "samson.leroc@afpa.fr", centreCandau, "030303"));
        formateurParCentre.get(centreCandau).add(new Formateur("Lebleu", "Vincent", "lebleu.vincent@afpa.fr", centreCandau, "040404"));
        formateurParCentre.get(centreBosquet).add(new Formateur("Doe", "John", "jd@secu-incendie.wip", centreBosquet, "INTERVENANT"));
        formateurParCentre.get(centreCandau).add(new Formateur("Johnson", "Diane", "dj@secu-incendie.wip", centreCandau, "INTERVENANT"));
        formateurParCentre.get(centreBosquet).add(new Formateur("Ulaire", "Anne", "anne.ulaire@afpa.fr", centreBosquet, "050505"));
        formateurParCentre.get(centreBosquet).add(new Formateur("Darbalète", "Janne", "janne.darbalete@afpa.fr", centreBosquet, "060606"));

        // J'affiche les stagiaires par centre
        // Je parcours tous les centres dans ma Map stagiaireParCentre
        for (Centre centre : stagiaireParCentre.keySet()) {
            // Pour chaque centre, j'affiche son nom
            System.out.println("Stagiaires du centre " + centre.getLibelle() + ":");
            // Puis je parcours tous les stagiaires de ce centre
            for (Stagiaire stagiaire : stagiaireParCentre.get(centre)) {
                // Et j'affiche les informations de chaque stagiaire
                System.out.println("  " + stagiaire);
            }
            // J'ajoute une ligne vide pour la lisibilité
            System.out.println();
        }

        // J'affiche les formateurs par centre
        // Je fais la même chose que pour les stagiaires, mais avec les formateurs
        for (Centre centre : formateurParCentre.keySet()) {
            System.out.println("Formateurs du centre " + centre.getLibelle() + ":");
            for (Formateur formateur : formateurParCentre.get(centre)) {
                System.out.println("  " + formateur);
            }
            System.out.println();
        }
    }
}
