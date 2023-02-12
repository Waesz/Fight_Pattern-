import Stratégie_Arme.épée_bois;
import Stratégie_Observateur.Combat;
import Stratégie_Observateur.Observateur;
import Stratégie_Observateur.Sujet;

public class Joueur extends Personnage implements Observateur {

    private Sujet combat;

    public Joueur(Sujet combat) {
        ARME = new épée_bois();
        name = "joueur";
        pv = 100;
        po= 0;

        this.combat = combat;
        combat.enregistrerObservateur(this);
    }

    public void afficher_combat() {System.out.println("(DESIGN PATTERN OBSERVER) point de vie du joueur " + "'"+this.name+"'"+ ": " + this.getPv());
    }

    public void afficher_combat_fin() {System.out.println("(DESIGN PATTERN OBSERVER) Bravo vous avez gagner votre combat. Les point de vie du joueur " + "'"+this.name+"'"+ ": " + this.getPv()+". Votre nombre de pièce d'or que possède le joueur: "+this.po);
    }
    public void afficher_po_gagner(int po){
        System.out.println(" (DESIGN PATTERN OBSERVER) Vous avez gagner "+po+" pièce d'or.");
    }

    @Override
    public void actualiser(int pv) {   //actualise ses pv et l'affiche; Design Pattern OBSERVER
        this.pv = pv;
        afficher_combat();
    }

    @Override
    public void actualiser(int pv, int po) {  //actualise ses pv et ses po puis l'affiche; Design Pattern OBSERVER
        this.pv=pv;
        this.po= this.po + po;
        afficher_po_gagner(po);
        afficher_combat_fin();
    }


}
