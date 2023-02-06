import Stratégie_Arme.épée_bois;

public class Joueur extends Personnage {

    public Joueur() {
        ARME = new épée_bois();
        name = "Albert"; // peut-être faire ça avec un setter pour laisser le choix au joueur du nom de son perso
        pv = 100;
    }

    public void test() {
        System.out.println("je suis le joueur");
    }


}
