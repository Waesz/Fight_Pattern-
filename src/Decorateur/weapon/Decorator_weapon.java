package Decorateur.weapon;

import Personnage.Personnage;
import Stratégie_Arme.ARME;

public abstract class Decorator_weapon implements ARME {

    protected ARME arme;

    public abstract int arme_degat();;
    public abstract String arme_nom();
}
