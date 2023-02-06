import Stratégie_Arme.ARME;

// chose à faire : méthode qui fait perdre pv ou gagner
// méthode pour gagner et perdre énergie
//méthode qui fais gagner et perdre argent;
public abstract class Personnage {

    ARME ARME;

    // on peut rajouter une armure etc...

    int pv=10;//point de vie
    String name; // nom du personnage joueur ou non joueur;
    int energie; // on verra si on met un système d'énergie
    int po; // c'est l'argent avec laquelle il pourra changer d'arme ! (stratégy)

    public Personnage(){};

    public void arme(){
        ARME.arme();          // on applique le design pattern "strategy"
    }






///////////////////////////////////// GETTER & SETTER ////////////////////////////////////////////////////////////////
    // set arme; permet de changer l'arme de l'utilisateur en appliquant le design pattern Stratégie
    public void setARME(Stratégie_Arme.ARME ARME) {
        this.ARME = ARME;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {   // méthode pour modifier les pv d'un personnage
        this.pv = pv;
    }

    public void setPv(int pv, int degat) {  // méthode pour faire subir des dégats à un personnage
        this.pv = pv - degat;               // On peut mettre des valeurs négatifs pour qu'il gagne des pv
    }


}
