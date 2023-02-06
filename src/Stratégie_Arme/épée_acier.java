package Stratégie_Arme;

public class épée_acier implements ARME {


    @Override
    public String arme_nom() {
        return "épée en acier";
    }

    @Override
    public int arme_degat() {
        return 10;
    }
}
