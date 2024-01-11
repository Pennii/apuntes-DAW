package programacionunidad2;

import java.util.Scanner;

public class Ejer4CondicionalesConArray {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        // Variables de entrada
        int num;

        // Variables de salida
        String[] meses = new String[3];
        String estacion;
        // Variables auxiliares

        // Clase Scanner para petición de datos de entrada
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("PLANTILLA DE PROGRAMA ");
        System.out.println("----------------------");
        System.out.println("Ingresa la estacion del año como un numero "
                + "1(invierno), 2(primavera), 3(verano) o 4(otoño)");
        num = teclado.nextInt();

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        switch (num) {
            case 1 -> {
                estacion = "invierno";
                meses[0] = "junio";
                meses[1] = "julio";
                meses[2] = "agosto";
                break;
            }
            case 2 -> {
                estacion = "primavera";
                meses[0] = "septiembre";
                meses[1] = "octubre";
                meses[2] = "noviembre";
                break;
            }
            case 3 -> {
                estacion = "verano";
                meses[0] = "diciembre";
                meses[1] = "enero";
                meses[2] = "febrero";
                break;
            }
            case 4 -> {
                estacion = "otoño";
                meses[0] = "marzo";
                meses[1] = "abril";
                meses[2] = "mayo";
                break;
            }
            default -> {
                estacion = "invalida";
            }
        }
        System.out.println("La estacion es: " + estacion);
        for (int i = 0; i < 3; i++) {
            System.out.println("el mes " + (i + 1) + " de la estacion es: " + meses[i]);
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
