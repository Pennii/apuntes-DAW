package actividadu3m;

import java.util.Scanner;

public class ExamenU1E5 {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        // Variables de entrada
        int num;

        // Variables de salida
//        int numRev;
        // Variables auxiliares
        int l = 0, cont;
//        int decimal;
        // Clase Scanner para petición de datos de entrada
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("PLANTILLA DE PROGRAMA ");
        System.out.println("----------------------");
        System.out.println("Ingresa tu numero");
        num = teclado.nextInt();
        
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        cont = num;
        for (int j = 0; cont!=0;j++ ){
            l++;
            cont/=10;
        }
        int[] numRev = new int[l];
        System.out.println("Tu numero es: " + num);
        for (int i = 0; i < l; i++) {
            numRev[i] = num % 10;
            num /= 10;
        }
        System.out.print("El numero al reves es: ");
        for (int i = 0; i < l; i++) {
            System.out.print(numRev[i]);
        }
//
//        decimal = num % 10;
//        numRev = decimal * 10000;
//        num /= 10;
//        decimal = num % 10;
//        numRev += decimal * 1000;
//        num /= 10;
//        decimal = num % 10;
//        numRev += decimal * 100;
//        num /= 10;
//        decimal = num % 10;
//        numRev += decimal * 10;
//        num /= 10;
//        decimal = num % 10;
//        numRev += decimal;
//        num /= 10;
//        System.out.println("el numero al reves es: " + numRev);

        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADO");
        System.out.println("---------");

        System.out.println();
        System.out.println("Fin del programa.");
    }
}
