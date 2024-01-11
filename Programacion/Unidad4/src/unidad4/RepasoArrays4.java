package unidad4;

import java.util.Arrays;

/**
 *
 * @author maniana
 */
public class RepasoArrays4 {

    public static void main(String[] args) {
        final int FILA = 9, COLUMNA = 4, NUMEROS = 19;
// SE ESTABLECEN VARIABLES, ARRAYS Y CONSTANTES
        String carton[][] = new String[FILA][COLUMNA], salida[] = new String[carton.length];
        int numerosCarton[] = {1, 2, 5, 9, 11, 15, 22, 29, 34, 47, 49, 55, 59,
            60, 61, 71, 75, 88, 90};
        int salidos[] = {1, 2, 5, 10, 11, 12, 14, 15, 22, 55, 56, 57, 59, 60, 61,
            66, 78, 89, 90};
        int espacios, num, conteo = 0, valor;
        boolean linea, encontrado;
// SE ESTABLECE LA CANTIDAD DE ESPACIOS EN "BLANCO" DEL CARTON, SE DEFINEN SUS
// VALORES Y SE MUESTRA EL CARTON EN PANTALLA, JUNTO LAS BOLAS YA SALIDAS
        espacios = FILA * COLUMNA - NUMEROS;
        for (int i = 0; i < FILA; i++) {
            for (int j = 0; j < COLUMNA; j++) {
                num = (int) Math.floor(Math.random() * 2);
                if ((num != 1 && espacios > 0) || conteo >= 19) {
                    carton[i][j] = "**";
                    espacios--;
                } else if (espacios <= 0 || num == 1 && conteo < 19) {
                    carton[i][j] = Integer.toString(numerosCarton[conteo++]);
                }
            }
        }
        for (int i = 0; i < FILA; i++) {
            for (int j = 0; j < COLUMNA; j++) {
                System.out.printf("%-2s ", carton[i][j]);
            }
            System.out.println("");
        }

        System.out.printf("\nHan salido las siguientes bolas: %s\n",
                Arrays.toString(salidos));

// SE RECORRE TODO EL CARTON BUSCANDO LAS LINEAS
        conteo = 0;
        for (int i = 0; i < FILA; i++) {
// LINEA EMPIEZA COMO TRUE PARA QUE AL MOMENTO EN QUE LINEA SEA FALSE SE SALTE
// DIRECTAMENTE A LA SIGUIENTE FILA, VALOR TIENE QUE SUMAR AL MENOS 1 VEZ PARA
// SABER SI TENEMOS UNA FILA LLENA DE *
            linea = true;
            valor = 0;
            for (int j = 0; j < COLUMNA && linea; j++) {
// SE RECORRE CADA COLUMNA DE LA FILA, POR CADA VALOR SE RECORRE TODO EL ARRAY
// DE SALIDOS, SI ENCUENTRA EL MISMO NUMERO SALE DEL BUCLE Y BUSCAMOS EL SIGUIENTE
// VALOR. AL MOMENTO DE NO ENCONTRAR UN NUMERO SALIMOS DEL BUCLE SUPERIOR Y PASAMOS
// A LA SIGUIENTE FILA
                if (carton[i][j].charAt(0) != '*') {
                    encontrado = false;
                    for (int k = 0; k < salidos.length && !encontrado; k++) {
                        encontrado = Integer.valueOf(carton[i][j]) == salidos[k];
                    }
                    linea = encontrado;
                    valor++;
                }
            }
// SEGUN EL VALOR FINAL DE LINEA SABREMOS SI HAY O NO UNA EN LA FILA           
            if (linea && valor > 0) {
                salida[i] = "La fila " + (i + 1) + " tiene linea";
            } else {
                salida[i] = "La fila " + (i + 1) + " no tiene linea";
            }
        }

        for (int i = 0; i < FILA; i++) {
            System.out.println(salida[i]);
        }

        System.out.println("FIN DEL PROGRAMA");
    }

}
