import Stratégie_Arme.ARME;
import Stratégie_Arme.Lance_en_Argent;
import Stratégie_Arme.épée_acier;
import Stratégie_Arme.épée_bois;


// chose à faire en plus :
// méthode pour gagner et perdre énergie
public abstract class Personnage extends Utilitaire {

    ARME ARME;


    // on peut rajouter une armure etc...

    int pv = 10;//point de vie
    String name; // nom du personnage joueur ou non joueur
    int energie; // on verra si on met un système d'énergie
    int po; // c'est l'argent avec laquelle il pourra changer d'arme ! (stratégy) [ pas mit en place]
    public Personnage() {
    }


    public String arme_nom() {
        return ARME.arme_nom();
    }       // on applique le design pattern "strategy"

    public int arme_degat() {
        return ARME.arme_degat();
    }  // on applique le design pattern "strategy"


    public void changer_arme(int i) {  // change l'arme du personnage et la remplace par une arme aléatoire, dans l'arsenal.
        if (i == 0) {
            this.setARME(new épée_bois());
            System.out.println("(DESIGN PATTERN STRATEGY) le personnage "+this.name+" a actuellement une " + "'" + this.arme_nom() + "'" + " et elle fait " + "'" + this.arme_degat() + "'" + " point de dégats.");
        }
        else if (i == 1) {
            this.setARME(new épée_acier());
            System.out.println("(DESIGN PATTERN STRATEGY) le personnage "+this.name+" a actuellement une " + "'" + this.arme_nom() + "'" + " et elle fait " + "'" + this.arme_degat() + "'" + " point de dégats.");
        }
        else if (i == 2) {
            this.setARME(new Lance_en_Argent());
            System.out.println("(DESIGN PATTERN STRATEGY) le personnage "+this.name+" a actuellement une " + "'" + this.arme_nom() + "'" + " et elle fait " + "'" + this.arme_degat() + "'" + " point de dégats.");
        } else {
            System.out.println("pas de changement d'arme ! (valeur d'identifiant d'arme incorrect !) ");
        }
    }




///////////////////////////////////// GETTER & SETTER ////////////////////////////////////////////////////////////////


    // set arme; permet de changer l'arme de l'utilisateur en appliquant le design pattern Stratégie
    public void setARME(Stratégie_Arme.ARME ARME) {
        this.ARME = ARME;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {   // méthode pour modifier les pv d'un personnage
        this.pv = pv;
    }

//    public void setPv(int pv, int degat) {  // méthode pour faire subir des dégats à un personnage
//        this.pv = pv - degat;               // On peut mettre des valeurs négatives pour qu'il gagne des pv
//    }

    public int degat(int pv,int degat){  // méthode pour faire subir des dégats à un personnage (utiliser avec le design PATTERN OBSERVER)
        return  pv - degat;              // On peut mettre des valeurs négatives pour qu'il gagne des pv
    }

}
