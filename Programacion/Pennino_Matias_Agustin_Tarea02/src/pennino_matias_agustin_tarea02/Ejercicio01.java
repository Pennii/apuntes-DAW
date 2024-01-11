package pennino_matias_agustin_tarea02;

import java.util.Scanner;

public class Ejercicio01 {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        final int NUM_DIGITOS = 6, NUM_FINAL = 4;

        // Variables de entrada
        int num;

        // Variables de salida
        int digitoMayor = 0, digitoMenor = 10;

        // Variables auxiliares
        boolean valido, cantidad, par, digito;
        int contador;

        // Clase Scanner para petición de datos de entrada
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("DIGITO MAYOR Y DIGITO MENOR");
        System.out.println("----------------------");
//        SE REALIZA LA ENTRADA DEL NUMERO
        do {
            contador = 0;
            System.out.println("Ingresa un numero entero positivo de 6 digitos:");
            num = teclado.nextInt();
//            SE COMPRUEBA LA CANTIDAD DE DIGITOS
            for (int i = num; i > 0; i /= 10) {
                contador++;
            }
            cantidad = contador == NUM_DIGITOS;
//            SE COMPRUEBA SI ES PAR
            par = num % 2 == 0;
//            SE COMPRUEBA SU ULTIMO DIGITO
            digito = num % 10 != NUM_FINAL;
//            TRAS ESTAS COMPROBACIONES SE EVALUA SI EL NUMERO ES VALIDO
            valido = cantidad && par && digito;
            if (!valido) {
                if (!cantidad) {
                    System.out.println("El numero no tiene " + NUM_DIGITOS + " digitos");
                } else if (!par) {
                    System.out.println("El numero no es par");
                } else if (!digito) {
                    System.out.println("El numero finaliza en " + NUM_FINAL);
                }
            }
        } while (!valido);

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
//        SE EVALUAN LOS DIGITOS MAYOR Y MENOR
        for (int i = num; i > 0; i /= 10) {
            if (i % 10 >= digitoMayor) {
                digitoMayor = i % 10;
            }
            if (i % 10 <= digitoMenor) {
                digitoMenor = i % 10;
            }
        }

        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADO");
        System.out.println("---------");
        System.out.println("El digito mayor es: " + digitoMayor);
        System.out.println("El digito menor es: " + digitoMenor);

        System.out.println();
        System.out.println("Fin del programa.");
    }
}
