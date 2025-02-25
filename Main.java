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
        // Ici arraylist est un interface qui utilise les méthodes de la class java arraylist et ne s'instencie pas
        // il implémente list
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
        
        stagiaireParCentre.get(centreCandau).add(new Stagiaire("Némar", "Jean", "jean.nemar@fmail.wip", centreCandau, "010101", adrn));
        
        stagiaireParCentre.get(centreCandau).add(new Stagiaire("Croche", "Sarah", "sarah.croche@fmail.wip", centreCandau, "010102", adrn));
        stagiaireParCentre.get(centreCandau).add(new Stagiaire("Pote", "Jacques", "jacques.pote@fmail.wip", centreCandau, "010103", adrn));
        stagiaireParCentre.get(centreCandau).add(new Stagiaire("Voyant", "Claire", "claire.voyant@fmail.wip", centreCandau, "010104", cda));
        stagiaireParCentre.get(centreCandau).add(new Stagiaire("Attes", "Tom", "tom.attes@fmail.wip", centreCandau, "010105", cda));
        stagiaireParCentre.get(centreCandau).add(new Stagiaire("Formatik", "Alain", "alain.formatik@fmail.wip", centreCandau, "010106", cda));
        stagiaireParCentre.get(centreCandau).add(new Stagiaire("Stiqué", "Sophie", "sophie.stique@fmail.wip", centreCandau, "010107", tssr));
        stagiaireParCentre.get(centreCandau).add(new Stagiaire("Mau", "Dyna", "dyna.mau@fmail.wip", centreCandau, "010108", tssr));
        stagiaireParCentre.get(centreCandau).add(new Stagiaire("Matique", "Mathieu", "mathieu.matique@fmail.wip", centreCandau, "010109", tssr));
        stagiaireParCentre.get(centreCandau).add(new Stagiaire("Hération", "Alex", "alex.heration@fmail.wip", centreCandau, "010110", tai));
        stagiaireParCentre.get(centreCandau).add(new Stagiaire("Tare", "Guy", "guy.tare@fmail.wip", centreCandau, "010111", tai));
        stagiaireParCentre.get(centreCandau).add(new Stagiaire("Hitic", "Paul", "paul.hitic@fmail.wip", centreCandau, "010112", tai));
        stagiaireParCentre.get(centreBosquet).add(new Stagiaire("Fite", "Néo", "neo.fite@fmail.wip", centreBosquet, "010113", remn));
        stagiaireParCentre.get(centreBosquet).add(new Stagiaire("Pierre", "Emma", "emma.pierre@fmail.wip", centreBosquet, "010114", remn));
        stagiaireParCentre.get(centreBosquet).add(new Stagiaire("Javel", "Aude", "aude.javel@fmail.wip", centreBosquet, "010115", remn));
        stagiaireParCentre.get(centreBosquet).add(new Stagiaire("Tation", "Lévy", "levy.tation@fmail.wip", centreBosquet, "010116", gdp));
        stagiaireParCentre.get(centreBosquet).add(new Stagiaire("Verse", "Alain", "alain.verse@fmail.wip", centreBosquet, "010117", gdp));
        stagiaireParCentre.get(centreBosquet).add(new Stagiaire("Peplu", "Jean", "jean.peplu@fmail.wip", centreBosquet, "010118", gdp));

        // Je crée les formateurs
        System.out.println();

        Formateur sanschaise = new Formateur("Sanschaise", "Mathieu", "mathieu.sanchez@afpa.fr", centreCandau, "010101");
        sanschaise.ajouterFormationEnseignee(adrn);
        sanschaise.ajouterFormationEnseignee(cda);
        formateurParCentre.get(centreCandau).add(sanschaise);
        System.out.println();

        Formateur podpod = new Formateur("Podpod", "Arnaud", "arnaud.podpod@afpa.fr", centreCandau, "020202");
        podpod.ajouterFormationEnseignee(tai);
        podpod.ajouterFormationEnseignee(tssr);
        formateurParCentre.get(centreCandau).add(podpod);
        System.out.println();

        Formateur leroc = new Formateur("Leroc", "Samson", "samson.leroc@afpa.fr", centreCandau, "030303");
        leroc.ajouterFormationSuivie(secuIncendie);
        leroc.ajouterFormationEnseignee(tssr);
        formateurParCentre.get(centreCandau).add(leroc);
        System.out.println();

        Formateur lebleu = new Formateur("Lebleu", "Vincent", "lebleu.vincent@afpa.fr", centreCandau, "040404");
        lebleu.ajouterFormationEnseignee(ais);
        lebleu.ajouterFormationEnseignee(cda);
        formateurParCentre.get(centreCandau).add(lebleu);
        System.out.println();

        Formateur doe = new Formateur("Doe", "John", "jd@secu-incendie.wip", centreBosquet, "INTERVENANT");
        doe.ajouterFormationEnseignee(secuIncendie);
        formateurParCentre.get(centreBosquet).add(doe);
        System.out.println();

        Formateur johnson = new Formateur("Johnson", "Diane", "dj@secu-incendie.wip", centreCandau, "INTERVENANT");
        johnson.ajouterFormationEnseignee(secuIncendie);
        formateurParCentre.get(centreCandau).add(johnson);
        System.out.println();

        Formateur ulaire = new Formateur("Ulaire", "Anne", "anne.ulaire@afpa.fr", centreBosquet, "050505");
        ulaire.ajouterFormationSuivie(secuIncendie);
        ulaire.ajouterFormationEnseignee(gdp);
        formateurParCentre.get(centreBosquet).add(ulaire);
        System.out.println();

        Formateur darbalete = new Formateur("Darbalète", "Janne", "janne.darbalete@afpa.fr", centreBosquet, "060606");
        darbalete.ajouterFormationSuivie(secuIncendie);
        darbalete.ajouterFormationEnseignee(remn);
        formateurParCentre.get(centreBosquet).add(darbalete);
        System.out.println();

        // Organisation de l'affichage par centre
        afficherInfosCentre(centreCandau, formations, stagiaireParCentre, formateurParCentre);
        System.out.println("\n"); // Ajoute une ligne vide pour séparer les centres
        afficherInfosCentre(centreBosquet, formations, stagiaireParCentre, formateurParCentre);
    }

////////////////////////////////////////////////////////////////////////
    // Méthode pour afficher les informations d'un centre
    public static void afficherInfosCentre(Centre centre, List<Formation> formations, Map<Centre, List<Stagiaire>> stagiaireParCentre, Map<Centre, List<Formateur>> formateurParCentre) {
        System.out.println();

        System.out.println("Centre " + centre.getLibelle() + " (n°" + centre.getNumCentre() + "):");

        // 1. Formations du centre
        System.out.println("\nFormations proposées:");
        for (Formation formation : formations) {
            if (formation.getCentre().equals(centre)) {
                System.out.println("  - " + formation.getLibelle());
            }
        }

        // Formateurs du centre
        System.out.println("\nFormateurs:");
        List<Formateur> formateursDuCentre = formateurParCentre.get(centre);
        if (formateursDuCentre != null && !formateursDuCentre.isEmpty()) {
            for (Formateur formateur : formateursDuCentre) {
                System.out.println("  - " + formateur.getPrenom() + " " + formateur.getNom() + " (Matricule: " + formateur.getMatricule() + ")");
            }
        } else {
            System.out.println("  Aucun formateur dans ce centre.");
        }

        // 2. Stagiaires (Tableau)
        System.out.println("\nStagiaires:");
        List<Stagiaire> stagiairesDuCentre = stagiaireParCentre.get(centre);
        if (stagiairesDuCentre != null && !stagiairesDuCentre.isEmpty()) {
            // Créer un tableau formaté
            System.out.println( "\033[31m" + "coucou");
            System.out.println(String.format("%-10s %-25s %-35s", "Nom", "Prénom", "Email"));
            System.out.println("----------------------------------------------------------------------------------------------------");
            for (Stagiaire stagiaire : stagiairesDuCentre) {
                System.out.println(String.format("%-10s %-25s %-35s", stagiaire.getNom(), stagiaire.getPrenom(), stagiaire.getMail()));
            }
        } else {
            System.out.println("  Aucun stagiaire dans ce centre.");
        }

        // 3. Formations suivies par les formateurs du centre
        System.out.println("\nFormations suivies par les formateurs:");
        if (formateursDuCentre != null && !formateursDuCentre.isEmpty()) {
            for (Formateur formateur : formateursDuCentre) {
                System.out.println("  - " + formateur.getPrenom() + " " + formateur.getNom() + ":");
                if (formateur.getFormationsSuivies() != null && !formateur.getFormationsSuivies().isEmpty()) {
                    for (Formation formation : formateur.getFormationsSuivies()) {
                        System.out.println("    - " + formation.getLibelle());
                    }
                } else {
                    System.out.println("    Aucune formation suivie.");
                }
            }
        } else {
            System.out.println("  Aucun formateur dans ce centre.");
        }
    }
}
