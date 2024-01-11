package pennino_matias_tarea03;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.InputMismatchException;
import java.util.Scanner;

 public class Ejercicio2 {
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------

        // Constantes
        final int ANIO_ACTUAL = LocalDate.now().getYear(), ANIO_MIN = 1900,
                MES_FIESTA = 4;

        // Variables de entrada
        int anio = 0;
        
        // Variables de salida
        int dia;
        LocalDate fecha;

        // Variables auxiliares
        boolean valido, fiesta;
        

        // Clase Scanner para petición de datos de entrada
        Scanner teclado= new Scanner (System.in);
        
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.printf("¡SABADO DE FIESTAS!\n");
        System.out.printf("------------------\n");
//        Se ingresa un año valido
        do {
            System.out.printf("Ingresa un año en el rango (%d-%d)\n",ANIO_MIN,
                    ANIO_ACTUAL);
//            Se evalua si el año es valido
            try {
            anio = teclado.nextInt();
            valido = anio >= ANIO_MIN && anio <= ANIO_ACTUAL;
//            Mensaje de salida si el año no esta en el rango correcto
            if (!valido) {
                System.out.printf("El año no es valido: Rango incorrecto\n");
            }
            } catch (InputMismatchException ex) {
//                Mensaje de salida si no se introdujo un numero entero
                System.out.printf("Error de la lectura de datos: Ingresa un numero\n");
                valido = false;
                teclado.nextLine();
            }
        } while (!valido);
        
        //-----------------------------------------------------
        //                 Procesamiento y salida de resultados
        //-----------------------------------------------------
        
        System.out.printf("RESULTADO\n");
        System.out.printf("----------\n");
//        Se inicia un bucle que recorre desde el año introducido hasta el actual
        for (int i = anio; i <= ANIO_ACTUAL; i++) {
//            Se establece la fecha a evaluar y decimos que no ha habido fiesta aun
            fecha = LocalDate.of(i, MES_FIESTA, 1);
            fiesta = false;
            for (int j = 30; j > 0 && !fiesta; j--) {
//                Se establece un dia y se busca si ese dia fue fiesta, en la 
//              primera coincidencia finalizara el bucle
                fecha = LocalDate.of(i, MES_FIESTA, j);
                if(fecha.getDayOfWeek()==DayOfWeek.SATURDAY){
                    fiesta = true;
                }
            }
//            Se informa la fecha del festivo
             System.out.printf("En el año %d, el sabado de fiestas fue el"
                    + "dia %d de abril.\n",i,fecha.getDayOfMonth());
        }

        
        System.out.printf ("Fin del programa.\n");        
    }    
}