import Stratégie_Observateur.Combat;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Utilitaire {

    static Combat combat_PNJ = new Combat();     // création de observer pour les PNJ !
    static Combat combat_joueur = new Combat();  // création de observer pour les personnages joueurs !
    static Joueur joueur_init = new Joueur(combat_joueur);   // création de l'objet joueur qui sera abonnée à l'observateur "combat_joueur"
    static PNJ pnj_init = new PNJ(combat_PNJ);      // création de l'objet joueur qui sera abonnée à l'observateur "combat_PNJ"
    static String[] nameList = {"Albert", "Patrick", "Nasser", "Nabil", "Marc", "Wassim", "Malek", "Geoffrey", "Jean", "Marine", "Elisabeth", "Elise", "Jessica", "David", "Cho-Set","Ayberk","Ashe","Vi","Brie","Gouda","Cerise","Figue","Prune","Mercure","Vénus","Mars","Neptune","Saturne","Sabrina","Pénélope","Cassandre","Berenys","Sarah","Christophe","Simon","Chris","David","Sar-ko","Sago","Hardy","Franck","Samir","Francky","Luffy","Nami","Robin","Ussop","Zorro","Brook","Sanji","Chopper","Louis"};

    public static int random(int amplitude) {             // renvoie un nombre entre 0 et la valeur (amplitude - 1) [valeur extremum compris]
        return (int) (Math.random() * (amplitude));
    }

    public static int random(int min, int amplitude) {             // renvoie un nombre entre min et la valeur (amplitude - 1)
        return (int) (Math.random() * (amplitude)) + min;
    }


    public static String name_random() {
        return nameList[random(nameList.length)];
    }

    public static List<Joueur> generator_list_joueur(Joueur joueur, Integer nombre_joueur){
        List<Joueur> list =  new ArrayList<>();
        list.add(joueur);

        for (int i=0; i<nombre_joueur ;i++){
            Joueur compagnon = new Joueur(combat_joueur);
            compagnon.name= name_random();
            compagnon.setPv(100);
            list.add(compagnon);
        }
        return list;
    }

    public static List<PNJ> generator_list_pnj(PNJ pnj, Integer nombre_PNJ){
        List<PNJ> list = new ArrayList<>();
        list.add(pnj);
        for (int i=0; i<nombre_PNJ ;i++){
            PNJ PNJ = new PNJ(combat_PNJ);
            PNJ.name= name_random();
            list.add(PNJ);
        }
        return list;
    }

    public static List<PNJ> generator_list_pnj(Integer nombre_PNJ){
        List<PNJ> list = new ArrayList<>();
        for (int i=0; i<nombre_PNJ ;i++){
            PNJ PNJ = new PNJ(combat_PNJ);
            PNJ.name= name_random();
            PNJ.pv=random(10,21);
            PNJ.changer_arme(random(3));
            list.add(PNJ);
        }
        return list;
    }

    public static List<Joueur> initialisation(){
        System.out.println("******************************************************************************* LANCEMENT DU JEU ******************************************************************************* \n");
        System.out.println("                                            Bonjour et bienvenue dans votre jeu FIGHT PATTERN ! \n");


        boolean correct_name = false;
        while (!correct_name) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("Donner un nom a votre personnage :");
                joueur_init.name = sc.next("[a-zA-Z]*");
                correct_name = true;
                System.out.println("\n");
            } catch (InputMismatchException e) {
                System.out.println("Nom interdit, veuillez choisir un autre nom s'il vous plaît.");
            }
        }


        System.out.println("Votre personnage s'appelle : "+ joueur_init.name);
        System.out.println("le joueur a actuellement une " + "'" + joueur_init.arme_nom() + "'" + " et elle fait " + "'" + joueur_init.arme_degat() + "'" + " point de dégâts. \n");

        List<Joueur> list = bagarre(generator_list_joueur(joueur_init,0),generator_list_pnj(pnj_init,0));
        System.out.println("\n bravo tu as gagné ton 1er combat ! \n");
        return list;
    }


    //////////////////////////  on va faire la bagarre  //////////////////////////


    public static List<Joueur> bagarre(List<Joueur> joueurList, List<PNJ> pnjList) {     // méthode qui permettra de faire bagarrer les PNJ et les joueurs
        Scanner scanner = new Scanner(System.in);

        List<PNJ> liste_pnj_mort= new ArrayList<>();
        List<Joueur> liste_joueur_mort= new ArrayList<>();

        System.out.println("\n");
        for (PNJ pnj : pnjList) {
            System.out.println("Vous allez combattre " + pnj.name + ", ses stats sont : // PV :" + pnj.pv + " // son arme est " + "'" + pnj.arme_nom() + "'" + ", son arme fait " + "'" + pnj.arme_degat() + "'" + " point de dégâts.\n");
        }
        System.out.println("Votre équipe se compose de :\n");

        for (Joueur joueur : joueurList) {
            System.out.println("nom: " + "'" + joueur.name + "'" + "," +"// PV: "+joueur.pv+"// ,"+ " nom de l'arme:" + "'" + joueur.arme_nom() + "'" + " et elle fait " + "'" + joueur.arme_degat() + "'" + " point de dégâts. \n");
        }

        System.out.println("Voulez-vous lancer le combat ? \n");
        System.out.println("Entrer n'importe qu'elle valeur pour lancer le combat \n");
        scanner.next();
        System.out.println("//////////////////////////////////////////////");
        System.out.println("////////  C'est l'heure du combat ! ////////////");
        System.out.println("//////////////////////////////////////////////");
        System.out.println("\n");

        try {
            Thread.sleep(3000);  // donne un délai avant de lancer le combat !
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        while (true) {
            int degat_total_joueur = 0;
            int degat_total_pnj = 0;


            for (Joueur joueur : joueurList) { // on calcule le nombre de points de dégâts que font les joueurs
                if (joueur.pv <= 0) liste_joueur_mort.add(joueur);
                else   degat_total_joueur = degat_total_joueur + joueur.arme_degat();
            }

            for (Joueur joueur:liste_joueur_mort){  // on retire les joueurs morts du jeu
                joueur.désabonner();
                joueurList.remove(joueur);
            }
            liste_joueur_mort.clear();
            if (joueurList.isEmpty()) break;

            System.out.println("dégâts totaux des joueurs: " + degat_total_joueur);



            for (PNJ pnj : pnjList) {  // on calcule le nombre de points de dégâts que font les pnj
                if (pnj.pv <= 0) { liste_pnj_mort.add(pnj);}
                else  degat_total_pnj = degat_total_pnj + pnj.arme_degat();
            }

            for (PNJ pnj:liste_pnj_mort){  // on retire les pnj morts du jeu
                pnj.désabonner();
                pnjList.remove(pnj);
            }
            liste_pnj_mort.clear();
            if (pnjList.isEmpty()) break;

            System.out.println("dégâts totaux des pnj: " + degat_total_pnj);


            combat_PNJ.setData_personnage((degat_total_joueur / combat_PNJ.observateursize()), 0);  // les joueurs frappent le pnjList


            combat_joueur.setData_personnage((degat_total_pnj / combat_joueur.observateursize()), 0);  // les pnjList frappent le joueurList


            try {
                Thread.sleep(200);  // donne un délai entre chaque échange de coup !
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }


        for (Joueur joueur : joueurList) { // Si l'équipe de pnj et certains joueurs sont morts en même temps
            if (joueur.pv <= 0) liste_joueur_mort.add(joueur);
        }
        for (Joueur joueur:liste_joueur_mort){  // on retire les joueurs morts du jeu
            joueur.désabonner();
            joueurList.remove(joueur);
        }
        liste_joueur_mort.clear();

        return joueurList;
    }
}

