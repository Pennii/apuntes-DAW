/*Aplicación que determina si un entero recibido por teclado es positivo par o impar
 */
package entornos;

import java.util.Scanner;

public class Entornos {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Introduce un número: ");

        int a = s.nextInt();

        if (a > 0) {
            if (a % 2 == 0) {
                System.out.println(a + " es positivo y par");
            } else {
                System.out.println(a + " es positivo e impar");
            }
        } else if (a < 0) {

            if (a % 2 == 0) {
                System.out.println(a + " es negativo y par");
            } else {
                System.out.println(a + " es negativo e impar");
            }
        } else {
            System.out.println(a + " es cero");
        }
    }
}
