// Main.java
// J'importe toutes les classes dont j'ai besoin pour mon programme
import gestionnaire.Centre;
import gestionnaire.Stagiaire;
import gestionnaire.Formateur;
import gestionnaire.Formation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

// Je crée ma classe principale qui s'appelle Main
public class Main {
    // La méthode main est le point d'entrée de mon programme
    public static void main(String[] args) {
        // Je crée mes deux centres de formation
        Centre centreCandau = new Centre("4001", "Candau", "Sabrina", "Boulevard Ferdinand de Candau", "40000", "Mont-de-Marsan");
        Centre centreBosquet = new Centre("4002", "Bosquet", "Sabrina", "Boulevard Ferdinand de Candau", "40000", "Mont-de-Marsan");

        // Je crée des Maps pour stocker les stagiaires et formateurs par centre
        Map<Centre, List<Stagiaire>> stagiaireParCentre = new HashMap<>();
        Map<Centre, List<Formateur>> formateurParCentre = new HashMap<>();

        // J'initialise les listes vides pour chaque centre dans mes Maps
        stagiaireParCentre.put(centreCandau, new ArrayList<>());
        stagiaireParCentre.put(centreBosquet, new ArrayList<>());
        formateurParCentre.put(centreCandau, new ArrayList<>());
        formateurParCentre.put(centreBosquet, new ArrayList<>());

        // Je crée une liste pour stocker mes formations
        List<Formation> formations = new ArrayList<>();

        // Je définis le format de date que je vais utiliser
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        // J'ajoute les formations à ma liste
        Formation adrn = null;
        Formation cda = null;
        Formation tai = null;
        Formation tssr = null;
        Formation remn = null;
        Formation gdp = null;
        Formation secuIncendie = null;
        Formation ais = null;

        try {
            cda = new Formation("010101", "CDA", dateFormat.parse("03/01/2025"), dateFormat.parse("03/06/2025"), centreCandau);
            formations.add(cda);

            adrn = new Formation("020202", "ADRN", dateFormat.parse("14/02/2025"), dateFormat.parse("14/05/2025"), centreCandau);
            formations.add(adrn);

            tai = new Formation("030303", "TAI", dateFormat.parse("12/04/2025"), dateFormat.parse("21/07/2025"), centreCandau);
            formations.add(tai);

            tssr = new Formation("040404", "TSSR", dateFormat.parse("27/05/2025"), dateFormat.parse("02/10/2025"), centreCandau);
            formations.add(tssr);

            remn = new Formation("070707", "REMN", dateFormat.parse("14/02/2025"), dateFormat.parse("14/05/2025"), centreBosquet);
            formations.add(remn);

            gdp = new Formation("060606", "GDP", dateFormat.parse("12/04/2025"), dateFormat.parse("21/07/2025"), centreBosquet);
            formations.add(gdp);

            secuIncendie = new Formation("050505", "Sécurité incendie", dateFormat.parse("29/05/2025"), dateFormat.parse("31/05/2025"), centreCandau);
            formations.add(secuIncendie);

            ais = new Formation("080808", "AIS", dateFormat.parse("01/01/2025"), dateFormat.parse("01/02/2025"), centreCandau);
            formations.add(ais);

        } catch (ParseException e) {
            System.err.println("Erreur lors de la conversion de date : " + e.getMessage());
        }

        // J'ajoute les stagiaires à leurs centres respectifs
        Stagiaire nemar = new Stagiaire("Némar", "Jean", "jean.nemar@fmail.wip", centreCandau, "010101", adrn);
        stagiaireParCentre.get(centreCandau).add(nemar);

        Stagiaire croche = new Stagiaire("Croche", "Sarah", "sarah.croche@fmail.wip", centreCandau, "010102", adrn);
        stagiaireParCentre.get(centreCandau).add(croche);

        Stagiaire pote = new Stagiaire("Pote", "Jacques", "jacques.pote@fmail.wip", centreCandau, "010103", adrn);
        stagiaireParCentre.get(centreCandau).add(pote);

        Stagiaire voyant = new Stagiaire("Voyant", "Claire", "claire.voyant@fmail.wip", centreCandau, "010104", cda);
        stagiaireParCentre.get(centreCandau).add(voyant);

        Stagiaire attes = new Stagiaire("Attes", "Tom", "tom.attes@fmail.wip", centreCandau, "010105", cda);
        stagiaireParCentre.get(centreCandau).add(attes);

        Stagiaire formatik = new Stagiaire("Formatik", "Alain", "alain.formatik@fmail.wip", centreCandau, "010106", cda);
        stagiaireParCentre.get(centreCandau).add(formatik);

        Stagiaire stique = new Stagiaire("Stiqué", "Sophie", "sophie.stique@fmail.wip", centreCandau, "010107", tssr);
        stagiaireParCentre.get(centreCandau).add(stique);

        Stagiaire mau = new Stagiaire("Mau", "Dyna", "dyna.mau@fmail.wip", centreCandau, "010108", tssr);
        stagiaireParCentre.get(centreCandau).add(mau);

        Stagiaire matique = new Stagiaire("Matique", "Mathieu", "mathieu.matique@fmail.wip", centreCandau, "010109", tssr);
        stagiaireParCentre.get(centreCandau).add(matique);

        Stagiaire heration = new Stagiaire("Hération", "Alex", "alex.heration@fmail.wip", centreCandau, "010110", tai);
        stagiaireParCentre.get(centreCandau).add(heration);

        Stagiaire tare = new Stagiaire("Tare", "Guy", "guy.tare@fmail.wip", centreCandau, "010111", tai);
        stagiaireParCentre.get(centreCandau).add(tare);

        Stagiaire hitic = new Stagiaire("Hitic", "Paul", "paul.hitic@fmail.wip", centreCandau, "010112", tai);
        stagiaireParCentre.get(centreCandau).add(hitic);

        Stagiaire fite = new Stagiaire("Fite", "Néo", "neo.fite@fmail.wip", centreBosquet, "010113", remn);
        stagiaireParCentre.get(centreBosquet).add(fite);

        Stagiaire pierre = new Stagiaire("Pierre", "Emma", "emma.pierre@fmail.wip", centreBosquet, "010114", remn);
        stagiaireParCentre.get(centreBosquet).add(pierre);

        Stagiaire javel = new Stagiaire("Javel", "Aude", "aude.javel@fmail.wip", centreBosquet, "010115", remn);
        stagiaireParCentre.get(centreBosquet).add(javel);

        Stagiaire tation = new Stagiaire("Tation", "Lévy", "levy.tation@fmail.wip", centreBosquet, "010116", gdp);
        stagiaireParCentre.get(centreBosquet).add(tation);

        Stagiaire verse = new Stagiaire("Verse", "Alain", "alain.verse@fmail.wip", centreBosquet, "010117", gdp);
        stagiaireParCentre.get(centreBosquet).add(verse);

        Stagiaire peplu = new Stagiaire("Peplu", "Jean", "jean.peplu@fmail.wip", centreBosquet, "010118", gdp);
        stagiaireParCentre.get(centreBosquet).add(peplu);

        // Je crée les formateurs
        //Je crée les formateurs en initialisant la liste des formations enseignées et suivies
        Formateur sanschaise = new Formateur("Sanschaise", "Mathieu", "mathieu.sanchez@afpa.fr", centreCandau, "010101");
        sanschaise.ajouterFormationEnseignee(adrn);
        sanschaise.ajouterFormationEnseignee(cda);
        formateurParCentre.get(centreCandau).add(sanschaise);

        Formateur podpod = new Formateur("Podpod", "Arnaud", "arnaud.podpod@afpa.fr", centreCandau, "020202");
        podpod.ajouterFormationEnseignee(tai);
        podpod.ajouterFormationEnseignee(tssr);
        formateurParCentre.get(centreCandau).add(podpod);

        Formateur leroc = new Formateur("Leroc", "Samson", "samson.leroc@afpa.fr", centreCandau, "030303");
        leroc.ajouterFormationSuivie(secuIncendie);
        leroc.ajouterFormationEnseignee(tssr);
        formateurParCentre.get(centreCandau).add(leroc);

        Formateur lebleu = new Formateur("Lebleu", "Vincent", "lebleu.vincent@afpa.fr", centreCandau, "040404");
        lebleu.ajouterFormationEnseignee(ais);
        lebleu.ajouterFormationEnseignee(cda);
        formateurParCentre.get(centreCandau).add(lebleu);

        Formateur doe = new Formateur("Doe", "John", "jd@secu-incendie.wip", centreBosquet, "INTERVENANT");
        doe.ajouterFormationEnseignee(secuIncendie);
        formateurParCentre.get(centreBosquet).add(doe);

        Formateur johnson = new Formateur("Johnson", "Diane", "dj@secu-incendie.wip", centreCandau, "INTERVENANT");
        johnson.ajouterFormationEnseignee(secuIncendie);
        formateurParCentre.get(centreCandau).add(johnson);

        Formateur ulaire = new Formateur("Ulaire", "Anne", "anne.ulaire@afpa.fr", centreBosquet, "050505");
        ulaire.ajouterFormationSuivie(secuIncendie);
        ulaire.ajouterFormationEnseignee(gdp);
        formateurParCentre.get(centreBosquet).add(ulaire);

        Formateur darbalete = new Formateur("Darbalète", "Janne", "janne.darbalete@afpa.fr", centreBosquet, "060606");
        darbalete.ajouterFormationSuivie(secuIncendie);
        darbalete.ajouterFormationEnseignee(remn);
        formateurParCentre.get(centreBosquet).add(darbalete);

        // J'affiche les formations pour vérifier que tout s'est bien passé
        System.out.println("\nListe des formations :");
        // System.out.println() : Affiche un message dans la console
        // "\nListe des formations :" : Le message que je veux afficher (avec un retour à la ligne au début)
        for (Formation formation : formations) {
            // Je parcours tous les éléments de la liste formations
            System.out.println(formation); // J'utilise la méthode toString de la classe Formation
            // System.out.println() : Affiche un message dans la console
            // formation : L'élément courant de la liste (un objet Formation)
            // toString() : Méthode de la classe Formation qui permet d'afficher les informations de la formation de manière lisible
        }

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
        // Je parcours tous les centres dans ma Map formateurParCentre
        for (Centre centre : formateurParCentre.keySet()) {
            // Pour chaque centre, j'affiche son nom
            System.out.println("Formateurs du centre " + centre.getLibelle() + ":");
            // Puis je parcours tous les formateurs de ce centre
            for (Formateur formateur : formateurParCentre.get(centre)) {
                // Et j'affiche les informations de chaque formateur
                System.out.println("  " + formateur.getPrenom() + " " + formateur.getNom() + " (Matricule: " + formateur.getMatricule() + ")");

                // Pour chaque formateur, j'affiche les formations qu'il anime
                System.out.println("Formations animées par " + formateur.getPrenom() + " " + formateur.getNom() + ":");
                // Je parcours la liste des formations animées par le formateur
                for (Formation formation : formateur.getFormationsEnseignees()) {
                    // Et j'affiche le nom de chaque formation
                    System.out.println("  - " + formation.getLibelle());
                }

                // Pour chaque formateur, j'affiche les formations qu'il suit
                System.out.println("Formations suivies par " + formateur.getPrenom() + " " + formateur.getNom() + ":");
                // Je parcours la liste des formations suivies par le formateur
                for (Formation formation : formateur.getFormationsSuivies()) {
                    // Et j'affiche le nom de chaque formation
                    System.out.println("  - " + formation.getLibelle());
                }
            }
            // J'ajoute une ligne vide pour la lisibilité
            System.out.println();
        }
    }
}
