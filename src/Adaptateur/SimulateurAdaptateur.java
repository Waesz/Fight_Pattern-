package Adaptateur;

import Decorateur.weapon.A_lot_of_damage;
import Factory.Factory_Personnage;
import Factory.Factory_perso_concret;
import Personnage.PNJ;
import Personnage.PNJInterface;
import Personnage.PersonnageInterface;
import Simulateur.Utilitaire;

import java.util.List;
import java.util.Objects;

public class SimulateurAdaptateur extends Utilitaire {
    public static void main(String[] args) {
        Factory_Personnage usine = new Factory_perso_concret();
        //bagarre(usine.creer_list_personnage("joueur",3), usine.creer_list_personnage("animaux",3) );

       // System.out.println(usine.generator_list_animaux(3).toString());

        PNJInterface lion =  new AdaptateurAnimaux(new Lion(combat_PNJ));
        lion.afficher_combat();
        lion.changer_arme(2);
        lion.getARME();

        ((PNJ) lion).getName();

       // PNJ test = (Objects) lion;

        System.out.println("\n fin de la présentation de l'adaptateur.");
    }
}

    // List<PersonnageInterface> list = (List<PersonnageInterface>) new AdaptateurAnimaux(new Lion(combat_PNJ));