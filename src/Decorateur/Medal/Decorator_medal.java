package Decorateur.Medal;
import Personnage.Joueur;
import Stratégie_Observateur.Sujet;

public abstract class Decorator_medal extends Joueur {
    // ce n'est pas encore fonctionelle !
    protected Joueur joueur;
    protected Sujet combat;

    public Decorator_medal() {
        super(null);
    }


    public abstract String medal();


}
