package Decorateur.weapon;

import Personnage.Personnage;
import Stratégie_Arme.ARME;

public abstract class Decorator_weapon implements ARME {

    // ce décorateur a pour but de modifier les caractéristiques de l'arme (change son nom et ses dégâts)

    protected ARME arme;

    public abstract int arme_degat();;
    public abstract String arme_nom();
}
