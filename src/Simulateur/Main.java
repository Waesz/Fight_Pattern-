package Simulateur;

import Decorateur.weapon.A_lot_of_damage;
import Personnage.Joueur;
import Stratégie_Arme.ARME;

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

        list_de_joueurs= generator_list_joueur(list_de_joueurs.get(0),4);

        for (Joueur joueur: list_de_joueurs){
            joueur.changer_arme(random(3));
        }


        System.out.println("\n");
        // les armes sont décorées
        for (Joueur joueur: list_de_joueurs) {
            decorator_arme(joueur);
        }

        /*
        //des medailles pour les joueurs non fonctionnelles
        for (Joueur joueur2: list_de_joueurs){
            joueur2 = new Medal_of_honor(joueur2);
            joueur2.getMedal();
        }*/

/*        while (!list_de_joueurs.isEmpty()){

            System.out.println("\n Lancement d'un nouveau combat !\n");

            list_de_joueurs =bagarre (list_de_joueurs, generator_list_pnj(5));  // le groupe du joueur combat les pnj

            System.out.println("\n Fin du combat, vous avez gagner ! \n");
            for (Joueur joueur: list_de_joueurs){
                joueur.changer_arme(random(3));
            }
        }*/

        System.out.println("Il n'y a plus de combattant en vie dans votre groupe !");
    }}



