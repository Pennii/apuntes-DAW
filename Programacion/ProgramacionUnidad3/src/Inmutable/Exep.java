package Inmutable;

/**
 *
 * @author maniana
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class Exep {

    public static void main(String[] args) {
        boolean valido = false;
        Scanner teclado = new Scanner(System.in);
        int num = 0;
        System.out.println("ingresalo:");
        while (!valido) {
            try {
                num = teclado.nextInt();
                valido = true;
            } catch (InputMismatchException ex) {
                System.err.println(ex.getMessage());
                teclado.nextLine();//borra el buffer, permitiendo reingresar un dato
            }
        }
        try{
        num = 1/0;
        }catch (ArithmeticException ex){
            System.out.println("error");
        }
        System.out.println("tu numero: " + num);
    }
}
