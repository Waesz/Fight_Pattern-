import Stratégie_Arme.épée_bois;
import Stratégie_Observateur.Observateur;
import Stratégie_Observateur.Sujet;

public class PNJ extends Personnage implements Observateur {

    private Sujet combat;

    public PNJ(Sujet combat){
        ARME = new épée_bois();
        name = "Rocky";
        pv = 20;

        this.combat = combat;
        combat.enregistrerObservateur(this);
    }

    public void afficher_combat() {System.out.println("(DESIGN PATTERN OBSERVER) point de vie du PNJ " + "'"+this.name+"'"+ ": " + this.getPv());
    }

    @Override
    public void actualiser(int pv) { //actualise ses pv et l'affiche; Design Pattern OBSERVER
        this.pv = pv;
        afficher_combat();
    }

    @Override
    public void actualiser(int pv, int po) {
        System.out.println("(DESIGN PATTERN OBSERVER) ha gros, il y a un problème un PNJ ne peut pas voir ses po, être modifier !");
    }
}
