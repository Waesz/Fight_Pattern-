package Factory;


import Personnage.Joueur;
import Personnage.PNJ;
import Simulateur.Utilitaire;

import java.util.List;


public class SimulateurFactory extends Utilitaire {

    public static void main(String[] args) {
        Factory_Personnage usine = new Factory_perso_concret();
        bagarre(usine.creer_list_personnage("joueur",3),usine.creer_list_personnage("pnj",3));
        System.out.println("\n fin de la présentation de la fabrique.");
    }

}


  // autre test possible:
    //List<Joueur> list = usine.creer_list_personnage("joueur",5);
        //for (Joueur joueur : list){System.out.println(joueur.getName());}