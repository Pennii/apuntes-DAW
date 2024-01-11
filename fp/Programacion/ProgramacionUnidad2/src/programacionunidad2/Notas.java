package programacionunidad2;

/**
 *
 * @author maniana
 */
import java.util.Scanner;

public class Notas {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        String condicion;

        System.out.println("ingresa la nota");
        float nota = teclado.nextFloat();

        if (nota < 5 && nota >= 0) {
            condicion = "suspenso";
        } else if (nota < 6 && nota >= 5) {
            condicion = "suficiente";
        } else if (nota < 8 && nota >= 6) {
            condicion = "bien";
        } else if (nota < 9 && nota >= 8) {
            condicion = "notable";
        } else if (nota == 10 && nota >= 9) {
            condicion = "sobresaliente";
        } else {
            condicion = "no valido";
        }

        System.out.println("este alumno es " + condicion);
    }
}
