package Stratégie_Arme;

public class épée_bois implements ARME {

    @Override
    public String arme_nom() {
        return "épée en bois";
    }

    @Override
    public int arme_degat() {
        return 2;
    }
}
