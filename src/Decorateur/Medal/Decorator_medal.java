package Decorateur.Medal;
import Personnage.Joueur;
import Stratégie_Observateur.Sujet;

public abstract class Decorator_medal extends Joueur {
    protected Joueur joueur;
    protected Sujet combat;

    public Decorator_medal() {
        super(null);
    }


    public abstract String medal();


}
