package actividadu3m;
import java.util.Scanner;

public class ExamenU1E4 {
 
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------

        // Constantes


        // Variables de entrada
        int precioProd, dinero;
        
        // Variables de salida
        int devuelto, monedas = 0;

        // Variables auxiliares
        int cambio, cantVeint, cantDiez, cantCinco, cantDos, cantUno;

        // Clase Scanner para petición de datos de entrada
        Scanner teclado= new Scanner (System.in);
        
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("PLANTILLA DE PROGRAMA ");
        System.out.println("----------------------");
        System.out.println("Ingresa el precio del producto en centavos");
        precioProd = teclado.nextInt();
        System.out.println("Ingresa con cuanto dinero pagaras (en centavos):");
        dinero = teclado.nextInt();

        
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        cambio = dinero - precioProd;
        devuelto = cambio;
        cantVeint = cambio/20;
        monedas += cantVeint > 0 ? cantVeint:0;
        cambio -= cantVeint * 20;
        cantDiez = cambio/10;
        monedas += cantDiez > 0 ? cantDiez:0;
        cambio -= cantDiez * 10;
        cantCinco = cambio/5;
        monedas += cantCinco > 0 ? cantCinco:0;
        cambio -= cantCinco * 5;
        cantDos = cambio/2;
        monedas += cantDos > 0 ? cantDos:0;
        cambio -= cantDos * 2;
        cantUno = cambio/1;
        monedas += cantUno > 0 ? cantUno:0;
        cambio -= cantUno;
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println ();
        System.out.println ("RESULTADO");
        System.out.println ("---------");
        System.out.println("Se devolvieron "+devuelto+" centimos");
        System.out.println("monedas de 20: "+cantVeint);
        System.out.println("monedas de 10: "+cantDiez);
        System.out.println("monedas de 5: "+cantCinco);
        System.out.println("monedas de 2: "+cantDos);
        System.out.println("monedas de 1: "+cantUno);
        System.out.println("monedas totales: "+monedas);
        
        System.out.println ();
        System.out.println ("Fin del programa.");        
    }    
}