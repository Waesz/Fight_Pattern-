import Stratégie_Arme.épée_acier;
import Stratégie_Observateur.Combat;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main extends Utilitaire {

    static Combat combat_PNJ= new Combat();     // création de l'observeur pour les PNJ !
    static Combat combat_joueur= new Combat();  // création de l'observeur pour les personnages joueurs !
    static Joueur joueur = new Joueur(combat_joueur);   // création de l'objet joueur qui sera abonnée à l'observateur "combat_joueur"
    static PNJ PNJ = new PNJ(combat_PNJ);      // création de l'objet joueur qui sera abonnée à l'observateur "combat_PNJ"

    public static void bagarre(){     // méthode qui permettra de faire bagarrer le PNJ et le joueur
        Scanner scanner = new Scanner(System.in);
        System.out.println("");
        System.out.println("Vous allez combattre "+PNJ.name+" ses stats sont : // PV :"+PNJ.pv+" // son arme est "+"'"+PNJ.arme_nom()+"'"+", son arme fait "+"'"+PNJ.arme_degat()+"'"+" point de dégats.");
        System.out.println("");
        System.out.println("Voulez-vous lancer le combat ? ");
        System.out.println("Entrer n'importe qu'elle valeur pour lancer le combat");
        String str = scanner.next();
        System.out.println("");
        System.out.println("//////////////////////////////////////////////");
        System.out.println("////////  C'est l'heure du duel ! ////////////");
        System.out.println("//////////////////////////////////////////////");
        System.out.println("");

        try {
            Thread.sleep(2000);  // donne un délai avant de lancer le combat !
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    while (PNJ.getPv()> 0 && joueur.getPv() > 0) {         //on lance le 1er combat
        combat_PNJ.setData_personnage( (PNJ.degat (PNJ.pv, joueur.arme_degat()) ),0 );  // le joueur frappe le pnj
        combat_joueur.setData_personnage( (joueur.degat (joueur.pv, PNJ.arme_degat()) ),0 );  // le pnj frappe le joueur

        try {
            Thread.sleep(500);  // donne un délai entre chaque échange de coup !
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    }


/////////////////////////////////////////////////////////////// simulateur ///////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("******************************************************************************* LANCEMENT DU JEU *******************************************************************************");
        System.out.println("");

        System.out.println("                                            Bonjour et bienvenue dans votre jeu FIGHT PATTERN !");
        System.out.println("");

        boolean correct_name = false;
        while (correct_name ==false) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("Donner un nom a votre personnage :");
                String str = sc.next("[a-zA-Z]*");
                joueur.name = str;
                correct_name =true;
            } catch (InputMismatchException e) {
                System.out.println("Nom interdit, veuillez choisir un autre nom s'il vous plaît.");
            }
        }

        System.out.println("");
        System.out.println("Votre personnage s'appelle : "+ joueur.name);
        System.out.println("le joueur a actuellement une " + "'" + joueur.arme_nom() + "'" + " et elle fait " + "'" + joueur.arme_degat() + "'" + " point de dégats.");
        System.out.println("");

     ///////  Lancement du premier combat  ////////////
        Main.bagarre();
        System.out.println("");
        // fin du combat, on pourra gagner des po et changer d'arme !!
        System.out.println("bravo tu as gagné ton 1er combat !");
        System.out.println("");
     /////// Fin du premier combat

        while (joueur.getPv() > 0) {   ///////// on lance le jeu  /////////////

            // mise à jour du PNJ et changement d'arme pour le joueur et de PNJ //
            PNJ.setPv(20);
            PNJ.name= Main.joueur.nom_random();
            PNJ.changer_arme_aleatoire(random(3));
            System.out.println("");
            joueur.changer_arme_aleatoire(random(3));
            System.out.println("");
            // FIN mise à jour du PNJ et changement d'arme pour le joueur et de PNJ FIN //


            System.out.println("lancement d'un nouveau combat");
            System.out.println("");
            Main.bagarre();
            System.out.println("");
            System.out.println("Fin du combat");

            // mettre en place une boutique pour pouvoir acheter une nouvelle arme + acheter des pv puis parramétrer les futurs combats

            // faire un combat 2 joueur vs 2 pnj et utiliser suppimer abonnée OBSERVER


    }
        System.out.println("Ton personnage " + joueur.name + " est mort :(");
}}


