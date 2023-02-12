package Stratégie_Observateur;

// cette interface sera implémenter par la class combat !
public interface Sujet {

    public void enregistrerObservateur(Observateur o);
    public void supprimerObservateur(Observateur o);
    public void notiferObservateurs();

}
