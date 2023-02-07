import Stratégie_Arme.épée_acier;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main extends Utilitaire {

    static Joueur joueur = new Joueur();
    static PNJ1 PNJ = new PNJ1();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("******************************************************************************* LANCEMENT DU JEU *******************************************************************************");
        System.out.println("");

        System.out.println("                                            Bonjour et bienvenue dans votre jeu FIGHT PATTERN !");
        System.out.println("");
        boolean a = true;
        while (a==true) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("Donner un nom a votre personnage :");
                String str = sc.next("[a-zA-Z]*");
                joueur.name = str;
                a=false;
            } catch (InputMismatchException e) {
                System.out.println("Nom interdit, veuillez choisir un autre nom s'il vous plaît.");

            }
        }

        System.out.println("");
        System.out.println("Votre personnage s'appelle : "+ joueur.name);
        System.out.println("le joueur a actuellement une " + "'" + joueur.arme_nom() + "'" + " et elle fait " + "'" + joueur.arme_degat() + "'" + " point de dégats.");
        System.out.println("");
        System.out.println("Vous allez combattre "+PNJ.name+" ses stats sont : // PV :"+PNJ.pv+" // son arme est "+"'"+PNJ.arme_nom()+"'"+", son arme fait "+"'"+PNJ.arme_degat()+"'"+" point de dégats.");
        System.out.println("");
        System.out.println("Voulez vous lancez le combat ? ");
        System.out.println("Entrer n'importe qu'elle valeur pour lancer le combat");
        String str = scanner.next();
        System.out.println("C'est l'heure du duel !");

        while (joueur.getPv() > 0) { // on lance le jeu

            while (PNJ.getPv() > 0 && joueur.getPv() > 0) { //on lance le 1er combat
                System.out.println("point de vie du joueur " + "'"+joueur.name+"'"+ ": " + joueur.getPv());
                System.out.println("point de vie du PNJ " + "'"+PNJ.name+"'" + ": " + PNJ.getPv());
                PNJ.setPv(PNJ.pv, joueur.arme_degat());
                joueur.setPv(joueur.pv, PNJ.arme_degat());

                try {
                    Thread.sleep(1000);  // donne un délai entre chaque échange de coup !
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
            // fin du combat, on pourra gagner des po et changer d'arme !!
            System.out.println("bravo tu as gagné ton 1er combat !");

            // mettre en place une boutique pour pouvoir acheter une nouvelle arme + acheter des pv puis parramétrer les futurs combats





/////////////////////////////////////////////////////////////   différents test ///////////////////////////////////////////////////////

        while (joueur.getPv() > 0) {  // On joue tant que les pv du joueur atteint pas zéro !
            System.out.println("point de vie du joueur " + joueur.name + ": " + joueur.getPv());
            joueur.setPv(joueur.pv, -5);
            joueur.setPv(joueur.pv, 8);
        }
        System.out.println("*********************************************************************************************");
        System.out.println(" ton personnage " + joueur.name + " est mort :(");

        System.out.println("*********************************************************************************************");
        System.out.println("****************************** Nouvelle partie *******************************");

        joueur.setPv(100);

        while (joueur.getPv() > 0) { // on lance le jeu

            while (PNJ.getPv() > 0 && joueur.getPv() > 0) { //on lance le 1er combat
                System.out.println("point de vie du joueur " + joueur.name + ": " + joueur.getPv());
                System.out.println("point de vie du PNJ " + PNJ.name + ": " + PNJ.getPv());
                PNJ.setPv(PNJ.pv, joueur.arme_degat());
                joueur.setPv(joueur.pv, PNJ.arme_degat());
            }
            // fin du combat, on pourra gagner des po et changer d'arme !!
            System.out.println("bravo tu as gagné ton 1er combat !");
            System.out.println("point de vie du joueur " + joueur.name + ": " + joueur.getPv());
            System.out.println("le joueur a actuellement une " + "'" + joueur.arme_nom() + "'" + " et elle fait " + "'" + joueur.arme_degat() + "'" + " point de dégats.");
            PNJ.setARME(new épée_acier());
            PNJ.setPv(21);

            System.out.println("*************** Lancement d'un nouveau combat ****************");

        }
        System.out.println(" ton personnage " + joueur.name + " est mort :(");


    }
}}