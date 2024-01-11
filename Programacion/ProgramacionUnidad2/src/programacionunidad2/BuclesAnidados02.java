package programacionunidad2;

import java.util.Scanner;

 public class BuclesAnidados02 {
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------

        // Constantes


        // Variables de entrada
        int a, b;
        
        // Variables de salida


        // Variables auxiliares
        boolean valido;
        int numMayor, numMenor;

        // Clase Scanner para petición de datos de entrada
        Scanner teclado= new Scanner (System.in);
        
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("PLANTILLA DE PROGRAMA ");
        System.out.println("----------------------");
        do{
            System.out.println("Ingresa el numero 'a':");
            a = teclado.nextInt();
            System.out.println("Ingresa el numero 'b':");
            b = teclado.nextInt();
            valido = ((a>=1 && a<=10)&&(b>=1 && b<=10));
        }while(!valido);

        
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        if(a>=b){
            numMayor = a;
            numMenor = b;
        }else{
            numMayor = b;
            numMenor = a;
        }
        for (int i = numMenor; i <= numMayor; i++){
            System.out.print("Numero "+i+": ");
            for(int j = 1; j <= 10; j++){
                System.out.print(i*j+" ");
            }
            System.out.println("");
        }

        
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