import Stratégie_Arme.ARME;
import Stratégie_Arme.Lance_en_Argent;
import Stratégie_Arme.épée_acier;
import Stratégie_Arme.épée_bois;

// chose à faire : méthode qui fait perdre pv ou gagner
// méthode pour gagner et perdre énergie
//méthode qui fais gagner et perdre argent;
public abstract class Personnage extends Utilitaire {

    ARME ARME;

    // on peut rajouter une armure etc...

    int pv = 10;//point de vie
    String name; // nom du personnage joueur ou non joueur;
    int energie; // on verra si on met un système d'énergie
    int po; // c'est l'argent avec laquelle il pourra changer d'arme ! (stratégy)

    public Personnage() {
    }


    public String arme_nom() {
        return ARME.arme_nom();
    }       // on applique le design pattern "strategy"

    public int arme_degat() {
        return ARME.arme_degat();
    }  // on applique le design pattern "strategy"


    public void changer_arme_aleatoire(int i) {  // change l'arme du personnage et la remplace par une arme aléatoire, dans l'arsenal.
        i = random(i + 1);
        if (i == 0) {
            this.setARME(new épée_bois());
        }
        if (i == 1) {
            this.setARME(new épée_acier());
        }
        if (i == 2) {
            this.setARME(new Lance_en_Argent());
        } else {
            System.out.println("pas de changement d'arme ! (valeur d'identifiant d'arme incorrect !)");
        }
    }

    public void changer_arme(Joueur j, int i) {      // Change l'arme du personnage joueur pour lui donner une arme en particulier.
        if (i == 0) {
            j.setARME(new épée_bois());
            System.out.println("le joueur a actuellement une " + "'" + j.arme_nom() + "'" + " et elle fait " + "'" + j.arme_degat() + "'" + " point de dégats.");
        }
        if (i == 1) {
            j.setARME(new épée_acier());
            System.out.println("le joueur a actuellement une " + "'" + j.arme_nom() + "'" + " et elle fait " + "'" + j.arme_degat() + "'" + " point de dégats.");
        }
        if (i == 2) {
            j.setARME(new Lance_en_Argent());
            System.out.println("le joueur a actuellement une " + "'" + j.arme_nom() + "'" + " et elle fait " + "'" + j.arme_degat() + "'" + " point de dégats.");
        } else {
            System.out.println("pas de changement d'arme ! (valeur d'identifiant d'arme incorrect !)");
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

    public void setPv(int pv, int degat) {  // méthode pour faire subir des dégats à un personnage
        this.pv = pv - degat;               // On peut mettre des valeurs négatives pour qu'il gagne des pv
    }


}
