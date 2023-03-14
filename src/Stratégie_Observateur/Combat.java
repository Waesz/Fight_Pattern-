package Stratégie_Observateur;

import java.util.ArrayList;
import java.util.List;

public class Combat implements Sujet{

    private List<Observateur> observateurs = new ArrayList<>();
    private int degats;
    private int po;// piéce d'or

    @Override
    public void enregistrerObservateur(Observateur o) {
        observateurs.add(o);
    }

    @Override
    public void supprimerObservateur(Observateur o) {
        observateurs.remove(o);
    }

    @Override
    public void notiferObservateurs() {
        if (po == 0){ // permet de modifier seulement les pv et pas (po + pv)
            for ( Observateur observateur: observateurs) {
                observateur.actualiser(degats);}
        }

        else{ // sinon modifie pv et po
            for ( Observateur observateur: observateurs) {
            observateur.actualiser(degats, po);}
        }
    }

    public void setData_personnage(int degat, int po) { // Si on veut mettre à jour que les pv, on met la valeur 0 à la variable po !
        this.degats = degat;
        this.po = po;
        notiferObservateurs();
    }

    public int observateursize(){
        return observateurs.size();
    }
}
