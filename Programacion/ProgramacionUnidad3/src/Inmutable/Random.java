package Inmutable;

import java.util.Scanner;

public class Random {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        // Variables de entrada
        // Variables de salida
        int num1, num2, num3;
        // Variables auxiliares
        boolean valido;

        // Clase Scanner para petición de datos de entrada
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("PLANTILLA DE PROGRAMA ");
        System.out.println("----------------------");

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
/*
        Para obtener el rango de numeros random se coloca el numero maximo, si
        lo incluimos sumamos un numero, si queremos modificar el valor minimo
        restamos ese numero al numero maximo
         */
        System.out.println("1:");
        System.out.println(Math.random());
        System.out.println("2:");
        for (int i = 1; i <= 5; i++) {
            System.out.println(Math.random());
        }
        System.out.println("3:");
        for (int i = 1; i <= 5; i++) {
            System.out.println((int) (Math.random() * 5));
        }
        System.out.println("4:");
        for (int i = 1; i <= 5; i++) {
            System.out.println((int) (Math.random() * 6));
        }
        System.out.println("5:");
        for (int i = 1; i <= 5; i++) {
            System.out.println((int) (1 + Math.random() * 5));
        }
        System.out.println("6: ");
        for (int i = 1; i <= 5; i++) {
            System.out.println((int) (1 + Math.random() * 5));
        }
        System.out.println("7: ");
        for (int i = 1; i <= 5; i++) {
            System.out.println((int) (20 + Math.random() * 11));
        }
        System.out.println("8: ");
        for (int i = 1; i <= 5; i++) {
            System.out.println((int) (Math.random() * 11)-5);
        }
        System.out.println("9: ");
        for (int i = 1; i <= 5; i++) {
            System.out.print(" " + (int) (-2 + Math.random() * 11));
        }
        System.out.println("");
        System.out.println("10: ");
        for (int i = 1; i <= 5; i++) {
            System.out.print(" " + (int) (1 + Math.random() * 100));
        }
        System.out.println("");
        System.out.println("11: ");
        for (int i = 1; i <= 5; i++) {
            do {
                num1 = (int) (10 + Math.random() * 91);
                valido = num1 % 10 == 0;
            } while (!valido);
            System.out.print(num1 + " ");
        }
        System.out.println("");
        System.out.println("12: ");

        do {
            num2 = (int) (Math.random() * 5 + 1);
            num3 = (int) (Math.random() * 5 + 1);
            valido = num2 != num3;
        } while (!valido);
        System.out.println(num2);
        System.out.println(num3);
        System.out.println("13: ");
        do {
            num1 = (int)(Math.random()*5)+1;
            num2 = (int)(Math.random()*5)+1;
            num3 = (int)(Math.random()*5)+1;
            valido = num1 != num2 && num1 != num3 && num2 != num3;
        }while (!valido);
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num3);
        System.out.println("");
        System.out.println("16: ");
        for (int i = 1; i <= 5; i++){
            num1 = (int)(Math.random()*2);
            System.out.println((num1 == 0 ? "cara":"cruz"));
        }
        System.out.println("17: ");
        for (int i = 1; i <= 5; i++){
            num1 = (int)(Math.random()*6);
            switch (num1){
                case 1: System.out.println("1");
                break;
                case 2: System.out.println("2");
                break;
                case 3: System.out.println("3");
                break;
                case 4: System.out.println("4");
                break;
                case 5: System.out.println("5");
                break;
                default: System.out.println("6");
            }
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
