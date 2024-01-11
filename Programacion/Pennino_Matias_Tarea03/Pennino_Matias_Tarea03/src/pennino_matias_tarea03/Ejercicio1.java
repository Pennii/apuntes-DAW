package pennino_matias_tarea03;

import aguadulce.Dado;
import java.util.Scanner;

public class Ejercicio1 {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        // Variables de entrada
        // Variables de salida
        String espacios = "         ";
        String guion = "-------------------";
        String lanzamiento1, lanzamiento2, ganador;
        int turnos = 1, puntuacion;

        // Variables auxiliares
        Dado dado1 = new Dado(8);
        Dado dado2 = new Dado(8);
        boolean pares, par1, par2;
        // Clase Scanner para petición de datos de entrada
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.printf("LANZAMIENTO DE DADOS:\n%s\n", guion);

        //----------------------------------------------
        //                 Procesamiento y salida de resultados
        //----------------------------------------------
//        Comienzan los lanzamientos
        System.out.printf("\n%sDADO1%sDADO2\n", espacios, espacios);
        System.out.printf("%s%s\n", espacios, guion);

//        Se ejecutan los lanzamientos
        do {
            espacios = "";
            lanzamiento1 = dado1.lanzar();
            lanzamiento2 = dado2.lanzar();
//            Se determina si es un lanzamiento par o impar
            switch (lanzamiento1) {
                case "UNO":
                case "CINCO":
                case "SIETE":
                case "TRES": {
                    par1 = false;
                    break;
                }
                default:
                    par1 = true;
            }
            switch (lanzamiento2) {
                case "UNO":
                case "CINCO":
                case "SIETE":
                case "TRES": {
                    par2 = false;
                    break;
                }
                default:
                    par2 = true;
            }
//            Se modifica el numero de espacios para el formato de salida
            for (int i = 1; i <= 13 - lanzamiento1.length(); i++) {
                espacios += " ";
            }
            System.out.printf("Turno %d: %s%s-%s\n", turnos, lanzamiento1,
                    espacios, lanzamiento2);
            turnos++;
            pares = par1 && par2;
        } while (!pares);

//        Se determina un ganador
        if (dado1.getSumaPuntuacionHistorica() >= dado2.getSumaPuntuacionHistorica()) {
            ganador = "dado 1";
            puntuacion = (int) dado1.getSumaPuntuacionHistorica();
        } else {
            ganador = "dado 2";
            puntuacion = (int) dado2.getSumaPuntuacionHistorica();

        }

//        Se muestran los resultados, primero el ganador de ambos jugadores
        System.out.printf("\nRESULTADO\n%s\n", guion);
        System.out.printf("El ganador ha sido el %s con una puntuacion de %d\n", ganador, puntuacion);
//        Luego se muestra la informacion de todos los dados, cuantos se crearon,
//      los lanzamientos, y cuantas veces aparece cada cara 
        System.out.printf("\nInformacion global \n%s\n", guion);
        System.out.printf("El numero total de dados creados es: %d\n",
                Dado.getNumeroDadosCreados());
        System.out.printf("El numero total de lanzamientos ha sido: %d\n",
                Dado.getNumeroLanzamientosGlobal());
//        Mediante el ciclo for se ve el caso de cada cara de forma individual
        for (int i = 1; i <= 8; i++) {
            System.out.printf("El numero de veces que ha salido %d ha sido: %d\n",
                    i, Dado.getNumeroVecesCaraGlobal(i));
        }

        System.out.printf("\nFin del programa.\n");
    }
}
