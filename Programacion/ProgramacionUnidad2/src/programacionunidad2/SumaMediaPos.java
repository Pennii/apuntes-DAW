package programacionunidad2;

import java.util.Scanner;

public class SumaMediaPos {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        // Variables de entrada
        int num;

        // Variables de salida
        float media;
        int inc = 0;
        // Variables auxiliares
        int i, j, suma=0;
        boolean valido;

        // Clase Scanner para petición de datos de entrada
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("PLANTILLA DE PROGRAMA ");
        System.out.println("----------------------");
        System.out.println("¿cuantos numeros positivos quieres leer?");
        i = teclado.nextInt();

        //----------------------------------------------
        //                 Procesamiento 
        //---------------------------------; j <= i; j++) {-------------
        for (j = 1; j <= i; j++) {
            do{
                System.out.println("ingresa el numero "+j+":");
                num = teclado.nextInt();
                valido = num>0;
                if (!valido){
                    System.out.println("el numero no es valido ingresalo devuelta");
                    inc++;
                }
            }while (!valido);
            suma +=num;
        }
        media = (float) suma/i;
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADO");
        System.out.println("---------");
        System.out.println("La media de estos numeros es: "+media);
        System.out.println("La suma de estos numeros es: "+suma);
        System.out.println(inc+" numeros fueron incorrectos");
        

        System.out.println();
        System.out.println("Fin del programa.");
    }
}
