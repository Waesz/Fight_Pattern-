

public class Utilitaire {


    public static int random(int amplitude) {             // renvoie un nombre entre 0 et la valeur (amplitude - 1)
        return (int) (Math.random() * (amplitude));
    }

    public static int random(int min, int max) {         //renvoie un nombre entre la valeur min et la valeur (max-1)
        return min + (int) (Math.random() * (max - min));
    }


}


