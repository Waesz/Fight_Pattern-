

public class Utilitaire {

    String[] nomList = {"Albert","Patrick","Nasser","Nabil","Marc","Wassim","Malek","Geoffrey","Jean","Marine","Elisabeth","Elise","Jessica","David","Cho-Set"};

    public static int random(int amplitude) {             // renvoie un nombre entre 0 et la valeur (amplitude - 1)
        return (int) (Math.random() * (amplitude));
    }

    public static int random(int min, int max) {         //renvoie un nombre entre la valeur min et la valeur (max-1)
        return min + (int) (Math.random() * (max - min));
    }

    public String nom_random(){
        //String nom = nomList[random(nomList.length)];
        String nom = nomList[random(nomList.length)];
        return nom;
    }




}


