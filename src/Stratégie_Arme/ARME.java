package Stratégie_Arme;

public interface ARME {
    String arme_nom();

    int arme_degat();

    //possibilité d'évolution, le rajout d'affinité; si j'ai une épée de type feu je fais plus de dégat contre type bois
    //c'est le même système que pokémon.

}
