import gestionnaire.Centre;
import gestionnaire.Stagiaire;
import gestionnaire.Formateur;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Je crée un objet Centre avec toutes les informations
        Centre centreCandau = new Centre("4001", "Candau", "Sabrina", "Boulevard Ferdinand de Candau", "40000", "Mont-de-Marsan");
        Centre centreBosquet = new Centre("4002", "Bosquet", "Sabrina", "Boulevard Ferdinand de Candau", "40000", "Mont-de-Marsan");

        // J'affiche les informations du centre
        centreCandau.afficherInfos();
        centreBosquet.afficherInfos();

        // Je crée une liste pour stocker mes stagiaires
        List<Stagiaire> listeStagiaires = new ArrayList<>();

        // Je crée plusieurs stagiaires et je les ajoute à ma liste
        listeStagiaires.add(new Stagiaire("Némar", "Jean", "jean.nemar@fmail.wip", centreCandau, "010101"));
        listeStagiaires.add(new Stagiaire("Croche", "Sarah", "sarah.croche@fmail.wip", centreCandau, "010102"));
        listeStagiaires.add(new Stagiaire("Pote", "Jacques", "jacques.pote@fmail.wip", centreCandau, "010103"));
        listeStagiaires.add(new Stagiaire("Voyant", "Claire", "claire.voyant@fmail.wip", centreCandau, "010104"));
        listeStagiaires.add(new Stagiaire("Attes", "Tom", "tom.attes@fmail.wip", centreCandau, "010105"));
        listeStagiaires.add(new Stagiaire("Formatik", "Alain", "alain.formatik@fmail.wip", centreCandau, "010106"));
        listeStagiaires.add(new Stagiaire("Stiqué", "Sophie", "sophie.stique@fmail.wip", centreCandau, "010107"));
        listeStagiaires.add(new Stagiaire("Mau", "Dyna", "dyna.mau@fmail.wip", centreCandau, "010108"));
        listeStagiaires.add(new Stagiaire("Matique", "Mathieu", "mathieu.matique@fmail.wip", centreCandau, "010109"));
        listeStagiaires.add(new Stagiaire("Hération", "Alex", "alex.heration@fmail.wip", centreCandau, "010110"));
        listeStagiaires.add(new Stagiaire("Tare", "Guy", "guy.tare@fmail.wip", centreCandau, "010111"));
        listeStagiaires.add(new Stagiaire("Hitic", "Paul", "paul.hitic@fmail.wip", centreCandau, "010112"));
        listeStagiaires.add(new Stagiaire("Fite", "Néo", "neo.fite@fmail.wip", centreBosquet, "010113"));
        listeStagiaires.add(new Stagiaire("Pierre", "Emma", "emma.pierre@fmail.wip", centreBosquet, "010114"));
        listeStagiaires.add(new Stagiaire("Javel", "Aude", "aude.javel@fmail.wip", centreBosquet, "010115"));
        listeStagiaires.add(new Stagiaire("Tation", "Lévy", "levy.tation@fmail.wip", centreBosquet, "010116"));
        listeStagiaires.add(new Stagiaire("Verse", "Alain", "alain.verse@fmail.wip", centreBosquet, "010117"));
        listeStagiaires.add(new Stagiaire("Peplu", "Jean", "jean.peplu@fmail.wip", centreBosquet, "010118"));

        // J'affiche la liste des stagiaires
        System.out.println("Liste des stagiaires :");
        for (Stagiaire stagiaire : listeStagiaires) {
            System.out.println(stagiaire);
        }

        // Je crée une liste pour stocker mes formateurs
        List<Formateur> listeFormateurs = new ArrayList<>();

        // Je crée plusieurs formateurs et je les ajoute à ma listeiste
        listeFormateurs.add(new Formateur("Sanschaise", "Mathieu", "mathieu.sanchez@afpa.fr", centreCandau, "010101"));
        listeFormateurs.add(new Formateur("Podpod", "Arnaud", "arnaud.podpod@afpa.fr", centreCandau, "020202"));
        listeFormateurs.add(new Formateur("Leroc", "Samson", "samson.leroc@afpa.fr", centreCandau, "030303"));
        listeFormateurs.add(new Formateur("Lebleu", "Vincent", "lebleu.vincent@afpa.fr", centreCandau, "040404"));
        listeFormateurs.add(new Formateur("Doe", "John", "jd@secu-incendie.wip", centreBosquet, "INTERVENANT"));
        listeFormateurs.add(new Formateur("Johnson", "Diane", "dj@secu-incendie.wip", centreCandau, "INTERVENANT"));
        listeFormateurs.add(new Formateur("Ulaire", "Anne", "anne.ulaire@afpa.fr", centreBosquet, "050505"));
        listeFormateurs.add(new Formateur("Darbalète", "Janne", "janne.darbalete@afpa.fr", centreBosquet, "060606"));

        // J'affiche la liste des formateurs
        System.out.println("Liste des formateurs :");
        for (Formateur formateur : listeFormateurs) {
            System.out.println(formateur);
        }
    }
}
