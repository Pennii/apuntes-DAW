package programacionunidad2;

import java.util.Scanner;

 public class BaseAltura {
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------

        // Constantes


        // Variables de entrada
        int base, alt;
        
        // Variables de salida
        int area;

        // Variables auxiliares
        boolean valido;

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
           System.out.println("Ingresa base y altura sin unidades de medida ");
        base = teclado.nextInt();
        alt = teclado.nextInt();
        valido = (base>0 && alt>0)?true:false;
        }while(valido==false);
        
        area = base * alt;

        
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println ();
        System.out.println ("RESULTADO");
        System.out.println ("---------");
        System.out.println("El area es: "+ area + " unidades cuadradas");
        
        
        System.out.println ();
        System.out.println ("Fin del programa.");        
    }    
}