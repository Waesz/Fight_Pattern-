package Stratégie_Observateur;

import java.util.ArrayList;
import java.util.List;

public class Combat implements Sujet{

    private List<Observateur> observateurs = new ArrayList();
    private int pv;
    private int po;

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
            for ( Observateur obs: observateurs) {
                obs.actualiser(pv);}
        }
        else{
            for ( Observateur obs: observateurs) {
            obs.actualiser(pv,po);}
        }
    }

    public void setData_personnage(int pv, int po) { // Si on veut mettre à jour que les pv, on met la valeur 0 à po à zero !
        this.pv = pv;
        this.po = po;
        notiferObservateurs();
    }
}
