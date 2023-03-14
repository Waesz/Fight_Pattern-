package Stratégie_Observateur;

// cette interface sera implémenter par la class combat !
public interface Sujet {

    void enregistrerObservateur(Observateur o);

     void supprimerObservateur(Observateur o);
    void notiferObservateurs();


}
