package Adaptateur;

import Stratégie_Observateur.Observateur;
import Stratégie_Observateur.Sujet;

public class Lion extends Animaux implements Observateur {

    private Sujet combat;

    public Lion(Sujet combat){
        pv=21;
        name="Lion";
        source_de_degat="patte";
        degats=4;
        this.combat=combat;
        combat.enregistrerObservateur(this);
    }


    public void afficher_combat() {
        System.out.println("(DESIGN PATTERN OBSERVER) point de vie de l'animal " + "'" + this.name + "'" + ": " + this.pv);
    }


    @Override
    public void actualiser(int degats) {   //actualise ses pv et l'affiche; Design Pattern OBSERVER
        this.pv =this.pv-degats;
        afficher_combat();
    }

    @Override
    public void actualiser(int degats, int po) {
        System.out.println("(DESIGN PATTERN OBSERVER) ha gros, il y a un problème un animal de type Lion ne peut pas voir ses po être modifier !");
    }

    @Override
    public void désabonner() {
        combat.supprimerObservateur(this);
    }

    @Override
    public Sujet getcombat() {
        return combat;
    }
}
