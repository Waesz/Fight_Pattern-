package Personnage;

import Decorateur.Medal.Decorator_medal;

public interface PNJInterface {

    public void afficher_combat() ;
    public void actualiser(int degats);
    public void actualiser(int degats, int po) ;
    public void désabonner();

    ///////////////////////////////// SUPER //////////////////////////

    public void setARME(Stratégie_Arme.ARME ARME) ;
    public Stratégie_Arme.ARME getARME() ;

    public String getMedal();
    public String setMedal(Decorator_medal medal);


    public int getPv() ;

    public void setPv(int pv) ;

    public String getName();

    public void setName(String name) ;


    public String arme_nom();

    public int arme_degat() ;

    public void changer_arme(int i);

}

