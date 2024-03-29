package Simulateur;

import Decorateur.weapon.A_lot_of_damage;
import Decorateur.weapon.Rubis;
import Decorateur.weapon.emousser;
import Factory.Factory_perso_concret;
import Factory.Factory_Personnage;
import Personnage.Joueur;
import Personnage.PNJ;
import Singleton.ScreenPrinter;
import Stratégie_Observateur.Combat;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javax.print.event.PrintEvent;

public class Utilitaire {

    public ScreenPrinter printer = ScreenPrinter.getInstance();

    public static Combat combat_PNJ = new Combat();     // création de observer pour les Personnage.PNJ !
    public static Combat combat_joueur = new Combat();  // création de observer pour les personnages joueurs !
    static Joueur joueur_init = new Joueur(combat_joueur);   // création de l'objet joueur qui sera abonnée à l'observateur "combat_joueur"
    //static PNJ pnj_init = new PNJ(combat_PNJ);      // création de l'objet joueur qui sera abonnée à l'observateur "combat_PNJ"
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

/*
///////////////////////////////////// pseudo-usine ////////////////////////////////////////////////
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

     //list_de_joueurs= generator_list_joueur(list_de_joueurs.get(0),4);  [code présent dans le main]

///////////////////////////////////// pseudo-usine ////////////////////////////////////////////////
 */

    public static void decorator_arme(Joueur joueur){
        int i =random(3);

        if (i==0){joueur.setARME(new A_lot_of_damage(joueur.getARME()));}
        else if (i==1) { joueur.setARME(new Rubis(joueur.getARME()));}
        else {joueur.setARME(new emousser(joueur.getARME()));}
        ScreenPrinter printer = ScreenPrinter.getInstance();
        printer.setColor(ScreenPrinter.BLUE);
        System.out.println("(Design Pattern Décorateur ) Nom : "+joueur.getName()+" // Arme : "+joueur.arme_nom()+" // dégâts : "+joueur.arme_degat());
    }

    public static List<Joueur> initialisation(){
        ScreenPrinter printer = ScreenPrinter.getInstance();
        printer.setColor(ScreenPrinter.YELLOW);
        System.out.println("******************************************************************************* LANCEMENT DU JEU ******************************************************************************* \n");
        System.out.println("                                            Bonjour et bienvenue dans votre jeu FIGHT PATTERN ! \n");


        boolean correct_name = false;
        while (!correct_name) {
            try {
                Scanner sc = new Scanner(System.in);
                printer.setColor(ScreenPrinter.YELLOW);
                System.out.println("Donner un nom a votre personnage :");
                printer.setColor(ScreenPrinter.RESET);
                joueur_init.setName(sc.next("[a-zA-Z]*"));
                correct_name = true;
                System.out.println("\n");
            } catch (InputMismatchException e) {
                printer.setColor(ScreenPrinter.RED);
                System.out.println("Nom interdit, veuillez choisir un autre nom s'il vous plaît.");
            }
        }


        printer.setColor(ScreenPrinter.YELLOW);
        System.out.println("Votre personnage s'appelle : "+ joueur_init.getName());
        printer.setColor(ScreenPrinter.BLUE);
        System.out.println("le joueur a actuellement une " + "'" + joueur_init.arme_nom() + "'" + " et elle fait " + "'" + joueur_init.arme_degat() + "'" + " point de dégâts. \n");

        List<Joueur> liste_de_joueur= new ArrayList<>();
        Factory_Personnage usine = new Factory_perso_concret();
        liste_de_joueur.add(joueur_init);
        liste_de_joueur =bagarre(liste_de_joueur, usine.creer_list_personnage("pnj",1));

        printer.setColor(ScreenPrinter.YELLOW);
        System.out.println("\n bravo tu as gagné ton 1er combat ! \n");

        try {
            Thread.sleep(2000);  // donne un délai
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return liste_de_joueur;
    }


    //////////////////////////  on va faire la bagarre  //////////////////////////


    public static List<Joueur> bagarre(List<Joueur> joueurList, List<PNJ> pnjList) {     // méthode qui permettra de faire bagarrer les Personnage.PNJ et les joueurs
        Scanner scanner = new Scanner(System.in);
        ScreenPrinter printer = ScreenPrinter.getInstance();

        List<PNJ> liste_pnj_mort= new ArrayList<>();
        List<Joueur> liste_joueur_mort= new ArrayList<>();

        printer.setColor(ScreenPrinter.PURPLE);
        System.out.println("\n");
        for (PNJ pnj : pnjList) {
            System.out.println("Vous allez combattre " + pnj.getName() + ", ses stats sont : // PV :" + pnj.getPv() + " // son arme est " + "'" + pnj.arme_nom() + "'" + ", son arme fait " + "'" + pnj.arme_degat() + "'" + " point de dégâts.\n");
        }
        printer.setColor(ScreenPrinter.YELLOW);
        System.out.println("Votre équipe se compose de :\n");

        printer.setColor(ScreenPrinter.BLUE);
        for (Joueur joueur : joueurList) {
            System.out.println("nom: " + "'" + joueur.getName() + "'" + "," +"// PV: "+joueur.getPv()+"// ,"+ " nom de l'arme:" + "'" + joueur.arme_nom() + "'" + " et elle fait " + "'" + joueur.arme_degat() + "'" + " point de dégâts. \n");
        }

        printer.setColor(ScreenPrinter.YELLOW);
        System.out.println("Voulez-vous lancer le combat ? \n");
        System.out.println("Entrer n'importe qu'elle valeur pour lancer le combat \n");
        printer.setColor(ScreenPrinter.RESET);
        scanner.next();
        printer.setColor(ScreenPrinter.YELLOW);
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
                if (joueur.getPv() <= 0) liste_joueur_mort.add(joueur);
                else   degat_total_joueur = degat_total_joueur + joueur.arme_degat();
            }

            for (Joueur joueur:liste_joueur_mort){  // on retire les joueurs morts du jeu
                joueur.désabonner();
                joueurList.remove(joueur);
            }
            liste_joueur_mort.clear();
            if (joueurList.isEmpty()) break;

            printer.setColor(ScreenPrinter.YELLOW);
            System.out.println("dégâts totaux des joueurs: " + degat_total_joueur);



            for (PNJ pnj : pnjList) {  // on calcule le nombre de points de dégâts que font les pnj
                if (pnj.getPv() <= 0) { liste_pnj_mort.add(pnj);}
                else  degat_total_pnj = degat_total_pnj + pnj.arme_degat();
            }

            for (PNJ pnj:liste_pnj_mort){  // on retire les pnj morts du jeu
                pnj.désabonner();
                pnjList.remove(pnj);
            }
            liste_pnj_mort.clear();
            if (pnjList.isEmpty()) break;

            printer.setColor(ScreenPrinter.YELLOW);
            System.out.println("dégâts totaux des pnj: " + degat_total_pnj);


            combat_PNJ.setData_personnage((degat_total_joueur / combat_PNJ.observateursize()), 0);  // les joueurs frappent les pnj


            combat_joueur.setData_personnage((degat_total_pnj / combat_joueur.observateursize()), 0);  // les pnj frappent les joueurs


            try {
                Thread.sleep(500);  // donne un délai entre chaque échange de coup !
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }


        for (Joueur joueur : joueurList) { // Si l'équipe de pnj et certains joueurs sont morts en même temps
            if (joueur.getPv() <= 0) liste_joueur_mort.add(joueur);
        }
        for (Joueur joueur:liste_joueur_mort){  // on retire les joueurs morts du jeu
            joueur.désabonner();
            joueurList.remove(joueur);
        }
        liste_joueur_mort.clear();

        try {
            Thread.sleep(2000);  // donne un délai avant chaque cycle
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return joueurList;
    }


}


