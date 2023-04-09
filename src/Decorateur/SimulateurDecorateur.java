package Decorateur;

import Decorateur.Medal.Medal_of_honor;
import Decorateur.weapon.A_lot_of_damage;
import Factory.Factory_perso_concret;
import Factory.Factory_Personnage;
import Personnage.Joueur;
import Simulateur.Utilitaire;

import java.util.ArrayList;
import java.util.List;

public class SimulateurDecorateur extends Utilitaire {

    static List<Joueur> list_de_joueurs = new ArrayList<>();

    public static void main(String[] args) {
       // list_de_joueurs = initialisation();

        //list_de_joueurs= generator_list_joueur(list_de_joueurs.get(0),4);

        Factory_Personnage usine = new Factory_perso_concret();
        System.out.println("\n");
        list_de_joueurs.addAll(usine.creer_list_personnage("joueur", 1));
        for (Joueur joueur : list_de_joueurs) {
            joueur.changer_arme(random(3));
        }


        System.out.println("\n");
        // les armes sont décorées
        for (Joueur joueur : list_de_joueurs) {
            decorator_arme(joueur);
        }



    }

}
