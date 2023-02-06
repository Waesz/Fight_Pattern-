import Stratégie_Arme.épée_acier;

public class Main {

    static Joueur joueur= new Joueur();

    public static void main(String[] args) {
        joueur.arme();
        joueur.test();
        System.out.println("********************* début changement d'arme ************************");
        joueur.setARME(new épée_acier());
        joueur.arme();
        System.out.println("********************* arme changer ? ***********************");

        while (joueur.getPv() >0){  // On joue tant que les pv du joueur atteint pas zéro !
            System.out.println("point de vie du joueur "+joueur.name+": "+joueur.getPv());
            joueur.setPv(joueur.pv, -5);
            joueur.setPv(joueur.pv, 8);
        }
        System.out.println("*********************************************************************************************");
        System.out.println(" ton personnage "+ joueur.name + " est mort :(");
    }
}