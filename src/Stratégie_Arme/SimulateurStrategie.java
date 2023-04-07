package Stratégie_Arme;

import Factory.Factory_perso_concret;
import Factory.Factory_Personnage;
import Personnage.Joueur;
import Simulateur.Utilitaire;

import java.util.List;

public class SimulateurStrategie extends Utilitaire {

    public static void main(String[] args) {
        int i =0;

        Factory_Personnage usine = new Factory_perso_concret();
        List<Joueur> list_de_joueurs =usine.creer_list_personnage("joueur", 4);
        System.out.println("Nous allons faire changer les armes des joueurs x fois pour appliquer le design pattern Stratégie. \n");
        while ( i <5){
            for (Joueur joueur : list_de_joueurs) {
                joueur.changer_arme(random(3));
            }
            System.out.println("\n \n");
            i= i+1;
        }
        System.out.println("\n Fin de présentation du patron de conception Stratégie ");
    }
}
