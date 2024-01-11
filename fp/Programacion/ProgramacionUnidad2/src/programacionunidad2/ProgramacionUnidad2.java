package programacionunidad2;

/**
 *
 * @author maniana
 */
import java.util.Scanner;

public class ProgramacionUnidad2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("introduce tu edad");
        int edad = teclado.nextInt();
        
        if (edad >= 18) {
            System.out.println("es mayor de edad");
        } else {
            System.out.println("es menor de edad");
        }
    }

}
