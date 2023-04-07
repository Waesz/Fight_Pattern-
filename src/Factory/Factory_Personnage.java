package Factory;

import Adaptateur.AdaptateurAnimaux;
import Personnage.Joueur;
import Personnage.PNJ;
import Personnage.PersonnageInterface;

import java.util.List;

public abstract class Factory_Personnage {

    public <T> List<T> creer_list_personnage( String typepersonnage, Integer nombre_personnage){
        if (typepersonnage=="joueur"){
            return (List<T>) generator_list_joueur(nombre_personnage);
        } else if (typepersonnage == "pnj") {
            return (List<T>) generator_list_pnj(nombre_personnage);
        } else if (typepersonnage=="animal") {
            return (List<T>) generator_list_animaux(nombre_personnage);
        } else {
            System.out.println("type de personnage incorect"); // faire un message d'erreur + gestion de l'erreur
            return null;
        }
    }
    public abstract List<Joueur> generator_list_joueur(Integer nombre_joueur);

    public abstract   List<PNJ> generator_list_pnj( Integer nombre_PNJ);
    public abstract   List<PNJ> generator_list_animaux(Integer nombre_animaux);
}
