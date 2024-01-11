package programacionunidad2;

import java.util.Scanner;

public class NotasSwitch {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        // Variables de entrada
        int nota;

        // Variables de salida
        String sit;

        // Variables auxiliares
        // Clase Scanner para petición de datos de entrada
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("PLANTILLA DE PROGRAMA ");
        System.out.println("----------------------");
        System.out.println("Ingresa tu nota ");
        nota = teclado.nextInt();

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        switch ((nota >= 0 & nota < 5) ? 1 : (nota >= 5 & nota < 6) ? 2 : (nota >= 6 & nota < 8) ? 3 : (nota >= 8 & nota <= 9) ? 4 : nota == 10 ? 5 : 0) {
            case 1:
                sit = "suspenso";
                break;
            case 2:
                sit = "suficiente";
                break;
            case 3:
                sit = "bien";
                break;
            case 4:
                sit = "notable";
                break;
            case 5:
                sit = "sobresaliente";
                break;
            default:
                sit = "no valido";
        }

        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADO");
        System.out.println("---------");
        System.out.println(sit);

        System.out.println();
        System.out.println("Fin del programa.");
    }
}
