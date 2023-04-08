package Adaptateur;

import Decorateur.Medal.Decorator_medal;
import Personnage.PNJInterface;
import Singleton.ScreenPrinter;
import Stratégie_Arme.ARME;
import Stratégie_Observateur.Observateur;
import Stratégie_Observateur.Sujet;

// c'est impossible car le fait de passer par des interfaces pour l'adaptation rend impossible l'utilisation directement des variables de class
// OR le code utilise ses variables car elle était public ! Solution: tout mettre en private + GETTERS & SETTERS !!

// en plus du fait qu'un PNJ hérite de plusieurs méthodes !

// IL est ici beaucoup plus simple de refaire une méthode "bagarre" pour l'adapter à la class animaux !

// On ne peut pas avoir des varibles  !! il faut avoir que des méthodes !!

public class AdaptateurAnimaux implements PNJInterface, Observateur {
    public ScreenPrinter printer = ScreenPrinter.getInstance();
    Animaux animal;
    private Sujet combat;

    public AdaptateurAnimaux(Animaux animal){
        this.animal=animal;
       this.combat=animal.getcombat();
       combat.enregistrerObservateur(this);
    }


    @Override
    public void afficher_combat() {
        printer.setColor(ScreenPrinter.GREEN);
        {System.out.println("(DESIGN PATTERN OBSERVER) point de vie de l'animal" + "'"+animal.name+"'"+ ": " + animal.pv);}
    }

    @Override
    public void actualiser(int degats) {
        this.animal.pv = this.animal.pv - degats;
        afficher_combat();
    }

    @Override
    public void actualiser(int degats, int po) {
        printer.setColor(ScreenPrinter.RED);
        System.out.println("(DESIGN PATTERN OBSERVER) Un animal ne peut pas avoir de pièce d'or");
    }

    @Override
    public void désabonner() {
        this.animal.getcombat().supprimerObservateur(this);
    }

    @Override
    public void setARME(ARME ARME) {

    }

    @Override
    public ARME getARME() {
        printer.setColor(ScreenPrinter.RED);
        System.out.println("ne peut pas sortir un type ARME !");
        // faut faire appelle a un adaotaeur de arme !
        return null;
    }

    @Override
    public String getMedal() {
        return "";
    }

    @Override
    public String setMedal(Decorator_medal medal) {
        return null;
    }

    @Override
    public int getPv() {
        return animal.pv;
    }

    @Override
    public void setPv(int pv) {
        animal.pv=pv;
    }

    @Override
    public String getName() {
        return animal.name;
    }

    @Override
    public void setName(String name) {
        animal.name=name;
    }

    @Override
    public String arme_nom() {
        return animal.source_de_degat;
    }

    @Override
    public int arme_degat() {
        return animal.degats;
    }

    @Override
    public void changer_arme(int i) {
        printer.setColor(ScreenPrinter.RED);
        System.out.println("un animal de change pas de source de dégât");
    }
}

