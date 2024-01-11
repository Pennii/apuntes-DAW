package programacionunidad2;

import java.util.Scanner;

 public class Tabla {
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------

        // Constantes


        // Variables de entrada
        int num;
        
        // Variables de salida
        char car;

        // Variables auxiliares
        boolean cont;

        // Clase Scanner para petición de datos de entrada
        Scanner teclado= new Scanner (System.in);
        
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("PLANTILLA DE PROGRAMA ");
        System.out.println("----------------------");
        

        
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
       do{
           do{
            System.out.println("Ingresa tu numero: ");
            num = teclado.nextInt();
        }while(num>10||num<=0);
        
        for (int i = 1; i<=10; i++){
            System.out.print((i*num)+" ");
        }
        System.out.println("");
        System.out.println("desea ingresar otro numero? (pulse 's' o 'S' para si)");
        car = teclado.next().charAt(0);
        cont = (car=='s'||car=='S')?true:false;
       }while(cont == true);
        

        
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println ();
        System.out.println ("RESULTADO");
        System.out.println ("---------");
        
        
        System.out.println ();
        System.out.println ("Fin del programa.");        
    }    
}