package Personnage;

import Decorateur.Medal.Decorator_medal;
import Singleton.ScreenPrinter;
import Stratégie_Arme.épée_bois;
import Stratégie_Observateur.Observateur;
import Stratégie_Observateur.Sujet;

public class PNJ extends Personnage implements Observateur,PNJInterface {

    private Sujet combat;



    public PNJ(Sujet combat){
        this.setARME(new épée_bois());
        setName("pnj");
        setPv(20);
        this.combat = combat;
        combat.enregistrerObservateur(this);

    }

    public void afficher_combat() {
        printer.setColor(ScreenPrinter.PURPLE);
        System.out.println("(DESIGN PATTERN OBSERVER) point de vie du Personnage.PNJ " + "'"+this.getName()+"'"+ ": " + this.getPv());
    }

    @Override
    public void actualiser(int degats) { //actualise ses pv et l'affiche; Design Pattern OBSERVER
        this.setPv(this.getPv()-degats);
        afficher_combat();
    }

    @Override
    public void actualiser(int degats, int po) {
        printer.setColor(ScreenPrinter.RED);
        System.out.println("(DESIGN PATTERN OBSERVER) Un Personnage de type PNJ ne peut pas voir son nombre de pièce d'or être modifier !");
    }

    @Override
    public void désabonner() {
        combat.supprimerObservateur(this);
    }

    ///////////////////////////////// SUPER //////////////////////////

    public void setARME(Stratégie_Arme.ARME ARME) {
         super.setARME(ARME);
    }
    public Stratégie_Arme.ARME getARME() {
        return super.getARME();
    }

    public String getMedal() {

        return  super.getMedal();
    }
    public String setMedal(Decorator_medal medal){
        return super.setMedal(medal);
    }

    public int getPv() {
        return super.getPv();
    }

    public void setPv(int pv) {   // méthode pour modifier les pv d'un personnage
        super.setPv(pv);
    }

    public String getName() {
        return super.getName();
    }

    public void setName(String name) {
        super.setName(name);
    }


    public String arme_nom() {
        return super.arme_nom();
    }

    public int arme_degat() {return super.arme_degat();}

    public void changer_arme(int i){super.changer_arme(i);}

}
