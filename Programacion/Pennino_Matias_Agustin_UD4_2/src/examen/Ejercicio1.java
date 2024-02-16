package examen;


public class Ejercicio1 {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        final int FILAS = 10, COLUMNAS = 10, FILAS_ENCUENTROS = 50,
                COLUMNAS_ENCUENTROS = 2;

        // Variables de entrada
        // Variables de salida
        char sopa[][];
        int encuentros[][];

        // Variables auxiliares
        int numRandom, numEncuentros = 0;


        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("EN BUSCA DEL PEZ");
        System.out.println("----------------------");
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        sopa = new char[FILAS][COLUMNAS];
        encuentros = new int[FILAS_ENCUENTROS][COLUMNAS_ENCUENTROS];

        for (int i = 0; i < sopa.length; i++) {
            for (int j = 0; j < sopa[i].length; j++) {
                numRandom = (int) (Math.random() * 4);
                switch (numRandom) {
                    case 0:
                        sopa[i][j] = 'A';
                        break;
                    case 1:
                        sopa[i][j] = 'O';
                        break;
                    case 2:
                        sopa[i][j] = 'B';
                        break;
                    default:
                        sopa[i][j] = 'Z';
                }
            }
        }

        for (int i = 0; i < sopa.length; i++) {
            for (int j = 1; j < sopa[i].length; j++) {
                if (sopa[i][j - 1] == 'O' && sopa[i][j] == 'Z') {
                    encuentros[numEncuentros][0] = i;
                    encuentros[numEncuentros++][1] = j - 1;
                }
            }
        }

        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADO");
        System.out.println("---------");
        System.out.print(" ");
        for (int i = 0; i < COLUMNAS; i++) {
            System.out.printf("%2d", i);
        }
        System.out.println("");
        for (int i = 0; i < sopa.length; i++) {
            System.out.printf("%d", i);
            for (int j = 0; j < sopa[i].length; j++) {
                System.out.printf("%2s", sopa[i][j]);
            }
            System.out.println("");
        }

        if (numEncuentros > 0) {
            System.out.printf("\nOZ se ha encontrado %d veces\n", numEncuentros);
        }
        for (int i = 0; i < numEncuentros; i++) {
            System.out.printf("En la fila %d columna %d\n", encuentros[i][0],
                    encuentros[i][1]);
        }

        System.out.println();
        System.out.println("Fin del programa.");
    }
}
