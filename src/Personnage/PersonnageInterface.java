package Personnage;

import Decorateur.Medal.Decorator_medal;
import Stratégie_Arme.Lance_en_Argent;
import Stratégie_Arme.épée_acier;
import Stratégie_Arme.épée_bois;

public interface PersonnageInterface {


    public String arme_nom();

    public int arme_degat() ;


    public void changer_arme(int i) ;

    public Stratégie_Arme.ARME getARME();
    public void setARME(Stratégie_Arme.ARME ARME);

    public String getMedal();

    public void setMedal(String medal);

    public int getPv();

    public void setPv(int pv);

    public String getName();

    public void setName(String name) ;







}
