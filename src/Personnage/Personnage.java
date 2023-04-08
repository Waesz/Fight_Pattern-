package Personnage;

import Decorateur.Medal.Decorator_medal;
import Stratégie_Arme.ARME;
import Stratégie_Arme.Lance_en_Argent;
import Stratégie_Arme.épée_acier;
import Stratégie_Arme.épée_bois;
import Simulateur.Utilitaire;
import Singleton.ScreenPrinter;


// chose à faire en plus :
// méthode pour gagner et perdre énergie & pièce d'or (po)
public abstract class Personnage extends Utilitaire implements PersonnageInterface {

   private ARME ARME;
   private String medal;
    // on peut rajouter une armure etc...

    private   int pv = 10;//point de vie

    private String name; // nom du personnage joueur ou non joueur
    public int po; // c'est l'argent avec laquelle il pourra changer d'arme ! (strategy) [ pas mit en place]


    public String arme_nom() {
        return ARME.arme_nom();
    }       // on applique le design pattern "strategy"

    public int arme_degat() {
        return ARME.arme_degat();
    }  // on applique le design pattern "strategy"


    public void changer_arme(int i) {  // change l'arme du personnage et la remplace par une arme aléatoire, dans l'arsenal.
        if (i == 0) {
            this.setARME(new épée_bois());
            printer.setColor(ScreenPrinter.BLUE);
            System.out.println("(DESIGN PATTERN STRATEGY) le personnage "+this.name+" a actuellement une " + "'" + this.arme_nom() + "'" + " et elle fait " + "'" + this.arme_degat() + "'" + " point de dégâts.");
        }
        else if (i == 1) {
            this.setARME(new épée_acier());
            printer.setColor(ScreenPrinter.BLUE);
            System.out.println("(DESIGN PATTERN STRATEGY) le personnage "+this.name+" a actuellement une " + "'" + this.arme_nom() + "'" + " et elle fait " + "'" + this.arme_degat() + "'" + " point de dégâts.");
        }
        else if (i == 2) {
            this.setARME(new Lance_en_Argent());
            printer.setColor(ScreenPrinter.BLUE);
            System.out.println("(DESIGN PATTERN STRATEGY) le personnage "+this.name+" a actuellement une " + "'" + this.arme_nom() + "'" + " et elle fait " + "'" + this.arme_degat() + "'" + " point de dégâts.");
        } else {
            printer.setColor(ScreenPrinter.RED);
            System.out.println("pas de changement d'arme ! (valeur d'identifiant d'arme incorrect !) ");
        }
    }




///////////////////////////////////// GETTER & SETTER ////////////////////////////////////////////////////////////////


    // setARME : permet de changer l'arme de l'utilisateur en appliquant le design Pattern Stratégie
    public void setARME(Stratégie_Arme.ARME ARME) {
        this.ARME = ARME;
    }
    public Stratégie_Arme.ARME getARME() {
        return ARME;
    }

    public String getMedal() {
        return this.medal;
    }
    public String setMedal(Decorator_medal medal){return null;} // je ne suis pas sur

    public void setMedal(String medal) {
        this.medal = medal;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {   // méthode pour modifier les pv d'un personnage
        this.pv = pv;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }




}
