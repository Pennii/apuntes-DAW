package pennino_matias_agustin_tarea02;

import java.util.Scanner;

public class Ejercicio02 {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        final int ANIO_MIN = 1900, ANIO_MAX = 2100, MES_MIN = 1, MES_MAX = 12,
                DIA_MIN = 1;
        // Variables de entrada
        int anio, mes, dia;
        // Variables de salida
        String estacion;
        // Variables auxiliares
        int diaMax;
        boolean bisiesto, valido;
        // Clase Scanner para petición de datos de entrada
        Scanner teclado = new Scanner(System.in);
        //-------------------------------------------------
        //                Entrada de datos y procesamiento
        //-------------------------------------------------
        System.out.println("ESTACION DEL AÑO EN EL QUE NACISTE");
        System.out.println("----------------------");
//        SE INTRODUCE UN AÑO Y SE EVALUA SI ES VALIDO Y SI ES BISIESTO
        do {
            System.out.println("Ingresa el año en el que naciste [" + ANIO_MIN + " - " + ANIO_MAX + "]");
            anio = teclado.nextInt();
            valido = anio >= ANIO_MIN && anio <= ANIO_MAX;
            if (!valido) {
                System.out.println("El año no es valido");
            }
        } while (!valido);
        bisiesto = (anio % 4 == 0 && anio % 100 != 0) || (anio % 100 == 0 && anio % 400 == 0);
//        SE INGRESA Y EVALUA EL MES
        do {
            System.out.println("Igresa el mes en el que naciste [" + MES_MIN + " - " + MES_MAX + "]");
            mes = teclado.nextInt();
            valido = mes >= MES_MIN && mes <= MES_MAX;
            if (!valido) {
                System.out.println("El mes no es valido");
            }
        } while (!valido);
//        SE CALCULAN LOS DIAS MAXIMOS
        switch (mes) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                diaMax = 31;
                break;
            default:
                diaMax = 30;
        }
        if (bisiesto && mes == 2) {
            diaMax = 29;
        } else if (mes == 2) {
            diaMax = 28;
        }
        do {
            System.out.println("Ingresa el dia en el que naciste [1 - " + diaMax + "]");
            dia = teclado.nextInt();
            valido = dia >= DIA_MIN && dia <= diaMax;
            if (!valido) {
                System.out.println("El dia es invalido");
            }
        } while (!valido);
//        SE EVALUA LA ESTACION
        switch (mes) {
            case 3:
                estacion = dia >= 21 ? "PRIMAVERA" : "INVIERNO";
                break;
            case 4:
            case 5:
                estacion = "PRIMAVERA";
                break;
            case 6:
                estacion = dia >= 21 ? "PRIMAVERA" : "VERANO";
                break;
            case 7:
            case 8:
                estacion = "VERANO";
                break;
            case 9:
                estacion = dia >= 23 ? "OTOÑO" : "VERANO";
                break;
            case 10:
            case 11:
                estacion = "OTOÑO";
                break;
            case 12:
                estacion = dia >= 21 ? "INVIERNO" : "OTOÑO";
                break;
            default:
                estacion = "INVIERNO";
        }
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADO");
        System.out.println("---------");
        System.out.println("Naciste en: " + estacion);

        System.out.println();
        System.out.println("Fin del programa.");
    }
}
