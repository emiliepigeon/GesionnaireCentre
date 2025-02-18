// Main.java
// J'importe toutes les classes dont j'ai besoin pour mon programme
import gestionnaire.Centre; // J'importe la classe Centre pour gérer les centres de formation
import gestionnaire.Stagiaire; // J'importe la classe Stagiaire pour gérer les stagiaires
import gestionnaire.Formateur; // J'importe la classe Formateur pour gérer les formateurs
import gestionnaire.Formation; // J'importe la classe Formation pour gérer les formations
import java.util.ArrayList; // J'importe la classe ArrayList pour créer des listes dynamiques
import java.util.List; // J'importe l'interface List pour utiliser les listes
import java.util.Map; // J'importe l'interface Map pour utiliser les maps
import java.util.HashMap; // J'importe la classe HashMap pour créer des maps
import java.text.SimpleDateFormat; // J'importe SimpleDateFormat pour formater les dates
import java.util.Date; // J'importe Date pour manipuler les dates
import java.text.ParseException; // J'importe ParseException pour gérer les erreurs de format de date

// Je crée ma classe principale qui s'appelle Main
public class Main {
    // La méthode main est le point d'entrée de mon programme
    public static void main(String[] args) {
        // Je crée mes deux centres de formation
        Centre centreCandau = new Centre("4001", "Candau", "Sabrina", "Boulevard Ferdinand de Candau", "40000", "Mont-de-Marsan");
        // Centre centreCandau : Je déclare une variable de type Centre pour stocker le centre Candau
        // new Centre(...) : Je crée un nouvel objet Centre en utilisant le constructeur de la classe
        // "4001" : Numéro du centre
        // "Candau" : Nom du centre
        // "Sabrina" : Responsable du centre
        // "Boulevard Ferdinand de Candau" : Adresse du centre
        // "40000" : Code postal du centre
        // "Mont-de-Marsan" : Ville du centre

        Centre centreBosquet = new Centre("4002", "Bosquet", "Sabrina", "Boulevard Ferdinand de Candau", "40000", "Mont-de-Marsan");
        // Centre centreBosquet : Je déclare une variable de type Centre pour stocker le centre Bosquet
        // new Centre(...) : Je crée un nouvel objet Centre en utilisant le constructeur de la classe
        // "4002" : Numéro du centre
        // "Bosquet" : Nom du centre
        // "Sabrina" : Responsable du centre
        // "Boulevard Ferdinand de Candau" : Adresse du centre
        // "40000" : Code postal du centre
        // "Mont-de-Marsan" : Ville du centre

        // Je crée des Maps pour stocker les stagiaires et formateurs par centre
        // Une Map est comme un dictionnaire qui associe une clé (ici, le centre) à une valeur (ici, une liste de personnes)
        Map<Centre, List<Stagiaire>> stagiaireParCentre = new HashMap<>();
        // Map<Centre, List<Stagiaire>> : Je déclare une Map qui associe des objets Centre à des List de Stagiaire
        //   - Centre : Type de la clé, chaque entrée de la Map correspond à un centre de formation
        //   - List<Stagiaire> : Type de la valeur, une liste qui contiendra tous les stagiaires d'un centre
        // stagiaireParCentre : Nom de la variable, décrit son contenu (stagiaires organisés par centre)
        // new HashMap<>() : Je crée une nouvelle instance de HashMap, qui implémente l'interface Map
        //   - HashMap est choisi pour sa performance en lecture/écriture avec des clés uniques
        // Cette structure me permettra d'organiser efficacement mes stagiaires par centre de formation
        Map<Centre, List<Formateur>> formateurParCentre = new HashMap<>();
        // Map<Centre, List<Formateur>> : Je déclare une Map qui associe des objets Centre à des List de Formateur
        //   - Centre : Type de la clé, chaque entrée de la Map correspond à un centre de formation
        //   - List<Formateur> : Type de la valeur, une liste qui contiendra tous les formateurs d'un centre
        // formateurParCentre : Nom de la variable, décrit son contenu (formateurs organisés par centre)
        // new HashMap<>() : Je crée une nouvelle instance de HashMap pour les formateurs
        // Cette structure me permettra d'organiser efficacement mes formateurs par centre de formation

        // J'initialise une liste vide de stagiaires pour le centre Candau dans ma Map stagiaireParCentre
        // Cela me permettra d'ajouter des stagiaires à ce centre plus tard
        stagiaireParCentre.put(centreCandau, new ArrayList<>());
        // stagiaireParCentre : C'est ma Map qui associe chaque Centre à sa liste de Stagiaires
        // .put() : C'est une méthode de Map qui ajoute une nouvelle paire clé-valeur
        // centreCandau : C'est la clé, un objet Centre que j'ai créé précédemment
        // new ArrayList<>() : C'est la valeur, une nouvelle liste vide qui contiendra les Stagiaires
        // Cette ligne prépare une liste vide pour le centre Candau, prête à recevoir des stagiaires
        stagiaireParCentre.put(centreBosquet, new ArrayList<>());
        // J'initialise une liste vide de stagiaires pour le centre Bosquet
        formateurParCentre.put(centreCandau, new ArrayList<>());
        // J'initialise une liste vide de formateurs pour le centre Candau
        formateurParCentre.put(centreBosquet, new ArrayList<>());
        // J'initialise une liste vide de formateurs pour le centre Bosquet

        // Je crée une liste pour stocker mes formations
        List<Formation> formations = new ArrayList<>();
        // List<Formation> : Je déclare une liste qui contiendra des objets de type Formation
        // formations : Nom de la variable, cette liste contiendra toutes les formations
        // new ArrayList<>() : Je crée une nouvelle instance d'ArrayList, qui implémente l'interface List
        // Cette structure me permettra d'organiser et de gérer mes formations

        // Je définis le format de date que je vais utiliser
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        // SimpleDateFormat : Classe qui permet de formater et de parser des dates
        // "dd/MM/yyyy" : Le format de date que je vais utiliser (jour/mois/année)
        // Je crée un objet SimpleDateFormat pour pouvoir convertir mes chaînes de caractères en dates

        // J'ajoute les formations à ma liste
        Formation adrn = null;
        Formation cda = null;
        Formation tai = null;
        Formation tssr = null;
        Formation remn = null;
        Formation gdp = null;

        try {
            // Je dois utiliser un try-catch car la conversion de String à Date peut échouer
            cda = new Formation("010101", "CDA", dateFormat.parse("03/01/2025"), dateFormat.parse("03/06/2025"), centreCandau);
            // new Formation(...) : Je crée un nouvel objet Formation en utilisant le constructeur de la classe
            // "010101" : Numéro de l'offre de formation
            // "CDA" : Libellé de la formation
            // dateFormat.parse("03/01/2025") : Date de début de la formation (convertie depuis une chaîne de caractères)
            // dateFormat.parse("03/06/2025") : Date de fin de la formation (convertie depuis une chaîne de caractères)
            // centreCandau : Centre de formation où se déroule la formation
            formations.add(cda); // J'ajoute la formation à la liste des formations

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

            Formation secIncendieCandau = new Formation("050505", "Sécurité incendie", dateFormat.parse("29/05/2025"), dateFormat.parse("31/05/2025"), centreCandau);
            formations.add(secIncendieCandau);

            Formation secIncendieBosquet = new Formation("050506", "Sécurité incendie", dateFormat.parse("29/05/2025"), dateFormat.parse("31/05/2025"), centreBosquet);
            formations.add(secIncendieBosquet);

        } catch (ParseException e) {
            // Si la conversion de date échoue, j'affiche un message d'erreur
            System.err.println("Erreur lors de la conversion de date : " + e.getMessage());
            // System.err.println() : Affiche un message d'erreur dans la console
            // e.getMessage() : Récupère le message d'erreur de l'exception
        }

         // J'ajoute les stagiaires à leurs centres respectifs
        // Pour chaque nouveau stagiaire, je crée un objet Stagiaire et je l'ajoute à la liste du centre correspondant
        Stagiaire nemar = new Stagiaire("Némar", "Jean", "jean.nemar@fmail.wip", centreCandau, "010101", adrn);
        // new Stagiaire(...) : Je crée un nouvel objet Stagiaire en utilisant le constructeur de la classe
        //   - "Némar" : Nom du stagiaire
        //   - "Jean" : Prénom du stagiaire
        //   - "jean.nemar@fmail.wip" : Email du stagiaire
        //   - centreCandau : Centre auquel le stagiaire est rattaché
        //   - "010101" : Identifiant unique du stagiaire
        //   - adrn : Formation suivie par le stagiaire
        stagiaireParCentre.get(centreCandau).add(nemar); // J'ajoute le stagiaire à la liste des stagiaires du centre Candau

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
        Formateur sanschaise = new Formateur("Sanschaise", "Mathieu", "mathieu.sanchez@afpa.fr", centreCandau, "010101");
        Formateur podpod = new Formateur("Podpod", "Arnaud", "arnaud.podpod@afpa.fr", centreCandau, "020202");
        Formateur leroc = new Formateur("Leroc", "Samson", "samson.leroc@afpa.fr", centreCandau, "030303");
        Formateur lebleu = new Formateur("Lebleu", "Vincent", "lebleu.vincent@afpa.fr", centreCandau, "040404");
        Formateur doe = new Formateur("Doe", "John", "jd@secu-incendie.wip", centreBosquet, "INTERVENANT");
        Formateur johnson = new Formateur("Johnson", "Diane", "dj@secu-incendie.wip", centreCandau, "INTERVENANT");
        Formateur ulaire = new Formateur("Ulaire", "Anne", "anne.ulaire@afpa.fr", centreBosquet, "050505");
        Formateur darbalete = new Formateur("Darbalète", "Janne", "janne.darbalete@afpa.fr", centreBosquet, "060606");

        // J'ajoute les formateurs à leurs centres respectifs
        formateurParCentre.get(centreCandau).add(sanschaise);
        formateurParCentre.get(centreCandau).add(podpod);
        formateurParCentre.get(centreCandau).add(leroc);
        formateurParCentre.get(centreCandau).add(lebleu);
        formateurParCentre.get(centreBosquet).add(doe);
        formateurParCentre.get(centreCandau).add(johnson);
        formateurParCentre.get(centreBosquet).add(ulaire);
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
