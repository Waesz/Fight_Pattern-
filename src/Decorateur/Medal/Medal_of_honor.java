package Decorateur.Medal;

import Personnage.Joueur;

public class Medal_of_honor extends Decorator_medal{

    public Medal_of_honor(Joueur joueur){
        super();
        super.setMedal(joueur.getMedal());
        super.combat=this.getCombat();
        super.joueur=joueur;}

    @Override
    public String medal() {
        return joueur.getMedal()+", Medal of Honor";
    }
}
