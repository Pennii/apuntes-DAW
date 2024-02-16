package examen;


public class Ejercicio2 {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        final int FILAS = 5, COLUMNAS = 5;

        // Variables de entrada
        // Variables de salida
        int matriz[][];

        // Variables auxiliares
        int numRandom, usados[], contador = 0, sumaPrincipal = 0, sumaInversa = 0,
                contadorInverso;
        boolean repetido;


        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("MATRIZ NUMEROS DISTINTOS");
        System.out.println("----------------------");
        System.out.println(" ");
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        matriz = new int[FILAS][COLUMNAS];
        usados = new int[FILAS * COLUMNAS];

        contadorInverso = 0;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length;) {
                repetido = false;
                numRandom = (int) (Math.random() * 25 + 1);
                for (int k = 0; k < usados.length && !repetido; k++) {
                    repetido = numRandom == usados[k];
                }
                if (!repetido) {
                    matriz[i][j] = numRandom;
                    usados[contador++] = numRandom;
                    if (i == j) {
                        sumaPrincipal += matriz[i][j];
                    }
                    if (j == FILAS - 1 - contadorInverso) {
                        sumaInversa += matriz[i][j];
                        contadorInverso++;
                    }
                    j++;
                }
            }
        }

        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADO");
        System.out.println("---------");

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf("%2d ", matriz[i][j]);
            }
            System.out.println("");
        }
        System.out.printf("La suma de la diagonal principal es: %d\n", sumaPrincipal);
        System.out.printf("La suma de la diagonal inversa es: %d\n", sumaInversa);
        System.out.println();
        System.out.println("Fin del programa.");
    }
}
