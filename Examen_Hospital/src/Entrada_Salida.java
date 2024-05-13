import java.util.Scanner;

/**
 * Entrada_Salida
 */
public class Entrada_Salida {

    static Scanner sc = new Scanner(System.in);
    
    public static int devolverInt(){
        int n = Integer.parseInt(devolverString());
        return n;
    }

    public static String devolverString(){
        return sc.nextLine();
    }
    
    public static double devolverDouble(){
        double n = Double.parseDouble(devolverString());
        return n;
    }

    public static char devolverChar(){
        return sc.next().charAt(0);
    }

    public static boolean devolverBoolean(){
        return sc.nextBoolean();
    }
}