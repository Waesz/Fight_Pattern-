package Stratégie_Observateur;

//cette interface est implémenté par la class joueur et la class PNJ qui vont voir certaine de leur stat changer
public interface Observateur {
    public void actualiser(int pv); // actualise les pv des abonnées

    public void actualiser(int pv, int po); // actualise les pv des abonnées et leurs piéce d'or
}
