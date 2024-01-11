package unidad4;

public class SopaLetras {

    public static void main(String[] args) {

        final int FILAS = 5, COLUMNAS = 5;

        String palabras[] = {"Hola", "sol", "AMOR", "ARA", "Casa", "dos"}, auxiliar;
        char sopa[][] = new char[FILAS][COLUMNAS];
        int cara, cont, pal = 0, letra;
        boolean espacio, escrito;

//        LA SOPA DE LETRAS EMPEZARA CON TODOS SUS VALORES EN *
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                sopa[i][j] = '*';
            }
        }

        do {
//            EL MATH RANDOM DIRA SI LA PALABRA APARECERA DE FORMA HORIZONTAL
//            O VERTICAL
            cara = (int) Math.floor(Math.random() * 2);
            escrito = false;
//            SI EL RANDOM ES IGUAL A 1 SE INTENTARA ESCRIBIR EN HORIZONTAL
            if (cara == 1) {
                for (int i = 0; i < FILAS && !escrito; i++) {
                    espacio = true;
                    cont = 0;
//                    VEREMOS SI HAY ESPACIO PARA ESCRIBIR, SI SE LLEGA AL FINAL
//                    DE LA FILA Y NO HAY, SE PASARA A VER LA SIGUIENTE FILA
                    for (int j = 0; j < COLUMNAS && espacio; j++) {
                        espacio = sopa[i][j] == '*';
                        if (espacio) {
                            cont++;
                        }
                    }
//                    SI HAY ESPACIO SE ESCRIBIRA LA PALABRA
                    if (cont >= palabras[pal].length()) {
                        for (int j = 0; j < palabras[pal].length(); j++) {
                            sopa[i][j] = palabras[pal].charAt(j);
                        }
                        escrito = true;
                        pal++;
                    }
                }
            } else {
//              SI EL RANDOM ES 0 SE REALIZARA EL MISMO PROCESO PERO EN COLUMNAS
                for (int i = 0; i < COLUMNAS && !escrito; i++) {
                    espacio = true;
                    cont = 0;
                    for (int j = 0; j < FILAS && espacio; j++) {
                        espacio = sopa[j][i] == '*';
                        if (espacio) {
                            cont++;
                        }
                    }
                    if (cont >= palabras[pal].length()) {
                        for (int j = 0; j < palabras[pal].length(); j++) {
                            sopa[j][i] = palabras[pal].charAt(j);
                        }
                        escrito = true;
                        pal++;
                    }
                }
            }
//            CADA VEZ QUE SE ESCRIBA UNA PALABRA pal SUMA, AL SER IGUAL AL LARGO
//           DEL ARRAY DE PALABRAS SALIMOS DEL BUCLE
        } while (pal < palabras.length);
//        TERMINAMOS DE RELLENAR LA SOPA CON LETRAS
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if (sopa[i][j] == '*') {
                    letra = (int) Math.floor(Math.random() * 27);
                    switch (letra) {
                        case 0 -> {
                            sopa[i][j] = 'A';
                        }
                        case 1 -> {
                            sopa[i][j] = 'B';
                        }
                        case 2 -> {
                            sopa[i][j] = 'C';
                        }
                        case 3 -> {
                            sopa[i][j] = 'D';
                        }
                        case 4 -> {
                            sopa[i][j] = 'E';
                        }
                        case 5 -> {
                            sopa[i][j] = 'F';
                        }
                        case 6 -> {
                            sopa[i][j] = 'G';
                        }
                        case 7 -> {
                            sopa[i][j] = 'H';
                        }
                        case 8 -> {
                            sopa[i][j] = 'I';
                        }
                        case 9 -> {
                            sopa[i][j] = 'J';
                        }
                        case 10 -> {
                            sopa[i][j] = 'K';
                        }
                        case 11 -> {
                            sopa[i][j] = 'L';
                        }
                        case 12 -> {
                            sopa[i][j] = 'M';
                        }
                        case 13 -> {
                            sopa[i][j] = 'N';
                        }
                        case 14 -> {
                            sopa[i][j] = 'Ñ';
                        }
                        case 15 -> {
                            sopa[i][j] = 'O';
                        }
                        case 16 -> {
                            sopa[i][j] = 'P';
                        }
                        case 17 -> {
                            sopa[i][j] = 'Q';
                        }
                        case 18 -> {
                            sopa[i][j] = 'R';
                        }
                        case 19 -> {
                            sopa[i][j] = 'S';
                        }
                        case 20 -> {
                            sopa[i][j] = 'T';
                        }
                        case 21 -> {
                            sopa[i][j] = 'U';
                        }
                        case 22 -> {
                            sopa[i][j] = 'V';
                        }
                        case 23 -> {
                            sopa[i][j] = 'W';
                        }
                        case 24 -> {
                            sopa[i][j] = 'X';
                        }
                        case 25 -> {
                            sopa[i][j] = 'Y';
                        }
                        default -> {
                            sopa[i][j] = 'Z';
                        }
                    }
                }
            }
        }
//        PROCEDEMOS A MOSTRAR LA SOPA Y DONDE ESTAN LAS PALABRAS
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                sopa[i][j] = Character.toUpperCase(sopa[i][j]);
                System.out.print(sopa[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
        for (int i = 0; i < FILAS; i++) {
            auxiliar = new String(sopa[i]);
            for (int j = 0; j < palabras.length; j++) {
                if (auxiliar.contains(palabras[j].toUpperCase())) {
                    System.out.printf("En la fila %d se encuentra la palabra"
                            + " %s\n", i + 1, palabras[j]);
                }
            }
        }
        System.out.println("");
        for (int i = 0; i < COLUMNAS; i++) {
            auxiliar = "";
            for (int j = 0; j < FILAS; j++) {
                auxiliar += sopa[j][i];
            }
            for (int j = 0; j < palabras.length; j++) {
                if (auxiliar.contains(palabras[j].toUpperCase())) {
                    System.out.printf("En la columna %d se encuentra"
                            + " la plabra %s\n", i + 1, palabras[j]);
                }
            }
        }
    }
}
