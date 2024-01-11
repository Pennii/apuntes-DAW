package unidad2programacion;
import java.util.Scanner;

public class IMC {
 
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------

        // Constantes


        // Variables de entrada
        float peso, altura;
        
        // Variables de salida
        float indice;

        // Variables auxiliares
        int cond;

        // Clase Scanner para petición de datos de entrada
        Scanner teclado= new Scanner (System.in);
        
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("PLANTILLA DE PROGRAMA ");
        System.out.println("----------------------");
        System.out.println("Ingresa un peso en kilogramos: ");
        peso = teclado.nextFloat();
        System.out.println("Ingresa una altura en metros: ");
        altura = teclado.nextFloat();

        
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        indice =  (float) (peso/Math.pow(altura, 2));

        cond = indice<16?1:indice<17?2:indice<18?3:indice<25?4:indice<30?5:
                indice<35?6:indice<40?7:8;
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println ();
        System.out.println ("RESULTADO");
        System.out.println ("---------");
        System.out.println("El indice de masa corporal es: "+ indice+"%");
        
        switch(cond){
            case 1 -> {
                System.out.println("Criterio de ingreso a hospital");
                break;
            }
            case 2 -> {
                System.out.println("Infrapeso");
                break;
            }
            case 3 -> {
                System.out.println("Bajo peso");
                break;
            }
            case 4 -> {
                System.out.println("Sludable");
                break;
            }
            case 5 -> {
                System.out.println("Sobrepeso");
                break;
            }
            case 6 -> {
                System.out.println("Sobrepeso cronico");
                break;
            }
            case 7 -> {
                System.out.println("Obesidad premorbida");
                break;
            }
            case 8 -> {
                System.out.println("Obesidad morbida");
                break;
            }
            default ->{ break;}
        }
        
        
        System.out.println ();
        System.out.println ("Fin del programa.");        
    }    
}