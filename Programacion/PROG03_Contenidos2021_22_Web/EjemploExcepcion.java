package ejemploexcepcion;

import java.util.Scanner;

/**
 * 
 * @author JJBH
 */
public class EjemploExcepcion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("Escriba un n�mero entero: ");
        try {
            Scanner teclado = new Scanner(System.in) ;
            int numero = teclado.nextInt() ;
            System.out.println("El n�mero tecleado es: " + numero);
                
        } catch (Exception e) {
             System.err.println("Error: No es un n�mero entero v�lido. ");
        }
    }
    
}
