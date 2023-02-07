package Stratégie_Arme;

public class Lance_en_Argent implements ARME{
    @Override
    public String arme_nom() {
        return "lance en Argent";
    }

    @Override
    public int arme_degat() {
        return 12;
    }
}
