package Decorateur.weapon;

import Stratégie_Arme.ARME;

public class emousser extends Decorator_weapon{

    public emousser(ARME arme){
        super.arme=arme;
    }

    @Override
    public int arme_degat() {
        return arme.arme_degat()-1;
    }

    @Override
    public String arme_nom() {
        return arme.arme_nom() +" émousser";
    }
}
