package Decorateur.weapon;

import Stratégie_Arme.ARME;

public class Rubis extends Decorator_weapon{

    public Rubis(ARME arme){
        super.arme=arme;
    }

    @Override
    public int arme_degat() {
        return arme.arme_degat();
    }

    @Override
    public String arme_nom() {
        return arme.arme_nom() + " avec des rubis";
    }
}
