package Simulateur;

import Factory.Factory_perso_concret;
import Factory.Factory_Personnage;
import Personnage.Joueur;

import java.util.ArrayList;

import java.util.List;


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/* to do list avoir un décorateur : des bonus joueurs qui vont lui modifier ses pv (il va recevoir un objet magique qui lui donne des pv !)

Mise en place d'une boutique à la fin de chaque bagarre ?

Mettre en private les champs dans la class personnage
 */

public class Main extends Utilitaire {

static List<Joueur> list_de_joueurs = new ArrayList<>();
    public static void main(String[] args) {

        list_de_joueurs = initialisation();

        Factory_Personnage usine= new Factory_perso_concret();
        list_de_joueurs.get(0).setPv(150);
        list_de_joueurs.addAll(usine.creer_list_personnage("joueur",4))  ;

        System.out.println( "\n On arme votre équipe de joueur et on décore leur arme !\n");
        for (Joueur joueur: list_de_joueurs){
            joueur.changer_arme(random(3));
        }


        System.out.println("\n");
        // les armes sont décorées
        for (Joueur joueur: list_de_joueurs) {
            decorator_arme(joueur);
        }

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

            System.out.println("\n Lancement d'un nouveau combat !\n");

            list_de_joueurs =bagarre (list_de_joueurs, usine.generator_list_pnj(5));  // le groupe du joueur combat les pnj

            System.out.println("\n Fin du combat, vous avez gagner ! \n");

           System.out.println( "\n On arme votre équipe de joueur et on décore leur arme !\n");
            for (Joueur joueur: list_de_joueurs){
                joueur.changer_arme(random(3));
            }
            System.out.println("\n");
           for (Joueur joueur: list_de_joueurs) {
               decorator_arme(joueur);
           }
           System.out.println("\nFin de l'armement \n");



        }

        System.out.println("Il n'y a plus de combattant en vie dans votre groupe !");
    }}



