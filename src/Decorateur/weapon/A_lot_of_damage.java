package Decorateur.weapon;



public class A_lot_of_damage extends  Decorator_weapon{
    public  A_lot_of_damage(Stratégie_Arme.ARME arme){
        super.arme=arme;
    }

    @Override
    public String arme_nom() {
        return arme.arme_nom()+" qui est Booster!!";
    }

    @Override
    public int arme_degat() {
        return arme.arme_degat()+5;
    }
}
