package programacionunidad2;

import java.util.Scanner;
import java.util.ArrayList;
public class WhileDo {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        // Variables de entrada
        int a = 0, b = 0;
        // Variables de salida
        int suma;
        // Variables auxiliares
        int i=0;
        ArrayList<Integer> nums = new  ArrayList<>();
        // Clase Scanner para petición de datos de entrada
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("PLANTILLA DE PROGRAMA ");
        System.out.println("----------------------");
        System.out.println(" ");

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        while (a >= 0 && b >= 0) {
            int z = 0, y = 0;
            a = 0;
            b = 0;
            System.out.println("ingresa dos numeros");
            a = teclado.nextInt();
            b = teclado.nextInt();
            suma = a + b;
            System.out.println("la suma de estos numeros es: " + suma);
           if (i==0){
               nums.add(a);
               nums.add(b);
           }else{
               for(int j = 0; j<=i;j++){
                   if(nums.get(j)==a){
                       z++;
                   }else if(nums.get(j)!=b){
                       y++;
                   }
               }
               if(z==i){
                   nums.add(a);
               }
               if(y==i){
                   nums.add(b);
               }
           }
            i++;
            

        }
        for(int j=0;j<=i;j++){
            System.out.println(nums.get(j));
        }
        //        while(i<10){
        //            System.out.println(i);
        //            i++;
        //        }
        //        do{
        //            i = teclado.nextInt();
        //            if (i>=10){
        //                
        //            }else{
        //            System.out.println("tu num es "+i);
        //            }
        //        }while(i<10);
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADO");
        System.out.println("---------");

        System.out.println();
        System.out.println("Fin del programa.");
    }
}
