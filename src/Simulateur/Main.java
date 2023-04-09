package Simulateur;

import Factory.Factory_perso_concret;
import Factory.Factory_Personnage;
import Personnage.Joueur;
import Singleton.ScreenPrinter;

import java.util.ArrayList;

import java.util.List;



/*
Mise en place d'une boutique à la fin de chaque bagarre ?
 */

public class Main extends Utilitaire {

static List<Joueur> list_de_joueurs = new ArrayList<>();
    public static void main(String[] args) {

        list_de_joueurs = initialisation();
        ScreenPrinter printer = ScreenPrinter.getInstance();

        Factory_Personnage usine= new Factory_perso_concret();
        list_de_joueurs.get(0).setPv(150);
        list_de_joueurs.addAll(usine.creer_list_personnage("joueur",4))  ;

        printer.setColor(ScreenPrinter.YELLOW);
        System.out.println( "\n On arme votre équipe de joueur et on décore leur arme !\n");
        for (Joueur joueur: list_de_joueurs){
            joueur.changer_arme(random(3));
        }


        System.out.println("\n");
        // les armes sont décorées
        for (Joueur joueur: list_de_joueurs) {
            decorator_arme(joueur);
        }

        printer.setColor(ScreenPrinter.YELLOW);
        System.out.println("\nFin de l'armement \n");

        /*
        //des medailles pour les joueurs non fonctionnelles
        for (Joueur joueur2: list_de_joueurs){
            joueur2 = new Medal_of_honor(joueur2);
            joueur2.getMedal();
        }*/


       while (!list_de_joueurs.isEmpty()){

           try {
               Thread.sleep(1000);  // donne un délai entre chaque combat
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }

           printer.setColor(ScreenPrinter.YELLOW);
            System.out.println("\n Lancement d'un nouveau combat !\n");

            list_de_joueurs =bagarre (list_de_joueurs, usine.generator_list_pnj(5));  // le groupe du joueur combat les pnj

            printer.setColor(ScreenPrinter.YELLOW);
            System.out.println("\n Fin du combat, vous avez gagner ! \n");

            printer.setColor(ScreenPrinter.YELLOW);
           System.out.println( "\n On arme votre équipe de joueur et on décore leur arme !\n");
            for (Joueur joueur: list_de_joueurs){
                joueur.changer_arme(random(3));
            }
            System.out.println("\n");
           for (Joueur joueur: list_de_joueurs) {
               decorator_arme(joueur);
           }
           printer.setColor(ScreenPrinter.YELLOW);
           System.out.println("\nFin de l'armement \n");



        }

        printer.setColor(ScreenPrinter.YELLOW);
        System.out.println("Il n'y a plus de combattant en vie dans votre groupe !");
    }}



