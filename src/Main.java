import Stratégie_Arme.ARME;
import Stratégie_Arme.épée_acier;

public class Main {

    static Joueur joueur= new Joueur();
    static PNJ1 PNJ= new PNJ1();

    public static void main(String[] args) {
        System.out.println("le joueur a actuellement une "+"'"+joueur.arme_nom()+"'"+" et elle fait "+"'"+joueur.arme_degat()+"'"+" point de dégats.");
        System.out.println("********************* début changement d'arme ************************");
        joueur.setARME(new épée_acier());
        System.out.println("le joueur a actuellement une "+"'"+joueur.arme_nom()+"'"+" et elle fait "+"'"+joueur.arme_degat()+"'"+" point de dégats.");


        System.out.println("****************************************************** LANCEMENT DU JEU ******************************************************");


        while (joueur.getPv() >0){  // On joue tant que les pv du joueur atteint pas zéro !
            System.out.println("point de vie du joueur "+joueur.name+": "+joueur.getPv());
            joueur.setPv(joueur.pv, -5);
            joueur.setPv(joueur.pv, 8);
        }
        System.out.println("*********************************************************************************************");
        System.out.println(" ton personnage "+ joueur.name + " est mort :(");

        System.out.println("*********************************************************************************************");
        System.out.println("****************************** Nouvelle partie *******************************");

        joueur.setPv(100);

        while (joueur.getPv()>0 ){ // on lance le jeu

            while (PNJ.getPv()>0 && joueur.getPv()>0){ //on lance le 1er combat
                System.out.println("point de vie du joueur "+joueur.name+": "+joueur.getPv());
                System.out.println("point de vie du PNJ "+PNJ.name+": "+PNJ.getPv());
                PNJ.setPv(PNJ.pv, joueur.arme_degat());
                joueur.setPv(joueur.pv, PNJ.arme_degat());
            }
            // fin du combat, on pourra gagner des po et changer d'arme !!
            System.out.println("bravo tu as gagné ton 1er combat !");
            System.out.println("point de vie du joueur "+joueur.name+": "+joueur.getPv());
            System.out.println("le joueur a actuellement une "+"'"+joueur.arme_nom()+"'"+" et elle fait "+"'"+joueur.arme_degat()+"'"+" point de dégats.");
            PNJ.setARME(new épée_acier());
            PNJ.setPv(21);

            System.out.println("*************** Lancement d'un nouveau combat ****************");

        }
        System.out.println(" ton personnage "+ joueur.name + " est mort :(");

    }
}