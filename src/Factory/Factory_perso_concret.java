package Factory;

import Adaptateur.AdaptateurAnimaux;
import Adaptateur.Lion;
import Personnage.Joueur;
import Personnage.PNJ;
import Personnage.PNJInterface;
import Personnage.PersonnageInterface;

import java.util.ArrayList;
import java.util.List;

import static Simulateur.Utilitaire.*;

public class Factory_perso_concret extends Factory_Personnage{

    public List<Joueur> generator_list_joueur(Integer nombre_joueur){
        List<Joueur> list =  new ArrayList<>();


        for (int i=0; i<nombre_joueur ;i++){
            Joueur compagnon = new Joueur(combat_joueur);
            compagnon.setName(name_random());
            compagnon.setPv(100);
            list.add(compagnon);
        }
        return list;
    }

    public  List<PNJ> generator_list_pnj(Integer nombre_PNJ){
        List<PNJ> list = new ArrayList<>();
        for (int i=0; i<nombre_PNJ ;i++){
            PNJ PNJ = new PNJ(combat_PNJ);
            PNJ.setName(name_random());
            PNJ.setPv(random(15,10));
            PNJ.changer_arme(random(3));
            list.add(PNJ);
        }
        return list;
    }



    @Override
    public List<PNJ> generator_list_animaux(Integer nombre_animaux) {
        List<PNJ> list = new ArrayList<>();

        for (int i=0; i<nombre_animaux ;i++){
            PNJInterface lion =  new AdaptateurAnimaux(new Lion(combat_PNJ));
            list.add( (PNJ)lion); // problème de cast, la solution est de la contourner car en vrai le code peut se compiler !!

            System.out.println("son nom : "+ lion.getName()+" et ses pv :"+lion.getPv() );
        }
        System.out.println(list.size());
        return list;
    }


}
