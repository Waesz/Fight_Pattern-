package Adaptateur;

import Simulateur.Utilitaire;
import Stratégie_Observateur.Sujet;

public abstract class Animaux extends Utilitaire {

        String medal; // pas mit en place

        public int pv ;//point de vie
        public String name; // nom de l'animal
        public String source_de_degat;   // griffe, croc, patte, etc.....
        public Integer degats;

        public abstract Sujet getcombat();


    }
