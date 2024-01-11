package unidad2programacion;

import java.util.Scanner;

public class PrimoPosPrev {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        // Variables de entrada
        int num;

        // Variables de salida
        int primopos = 0, primoprev = 0;

        // Variables auxiliares
        boolean primo = true;

        // Clase Scanner para petición de datos de entrada
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("PLANTILLA DE PROGRAMA ");
        System.out.println("----------------------");
        System.out.println("Ingrese un numero ");
        num = teclado.nextInt();

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        //primo posterior
        while (primo) {
            primopos = 0;
            num++;
            for (int i = 2; i < num; i++) {
                if (num%i == 0) {
                    
                    primopos++;
                }
            }
            if(primopos == 0){
                primo = false;
                primopos = num;
            }
        }
        System.out.println("El numero primo posterior es: " + primopos);

        //primo previo
        primo = true;
        while ((primo) && (num != 0)) {
            primoprev = 0;
            num--;
            for (int i = 2; i < num; i++) {
                if (num % i == 0) {
                    
                    primoprev++;
                }
            }
                 if(primoprev == 0){
                primo = false;
                primoprev = num;
            }
        }
        if (primoprev == 0) {
            System.out.println("Este numero no tiene un numero primo previo");
        } else {
            System.out.println("El numero primo previo es: " + primoprev);
        }

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
