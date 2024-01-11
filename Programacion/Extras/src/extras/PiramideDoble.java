package extras;

import java.util.Scanner;
public class PiramideDoble {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int base, ast = 1, espacios;
        String fila;
        System.out.println("ingresa la cantidad filas");
        base = in.nextInt();
        espacios = 0;
        for(int k = 2; k <= base; k++){
            ast+=2;
        }
        for (int i = 1; i <= base; i++){
            fila="";
            
            for (int l = 1; l <=espacios; l++){
                fila+=" ";
            }
            System.out.print(fila);
            //System.out.print(fila+=fila+"*");
            for(int j = 1; j<=ast; j++){
                System.out.print("*");
            }
            System.out.print("\n");
            ast-=2;
            espacios++;
        }
        espacios = 0;
        for (int j = 1; j <=base; j++){
                espacios++;
            }
        for (int i = 0; i <= base; i++){
            fila="";
            
            for (int l = 1; l <=espacios; l++){
                fila+=" ";
            }
            System.out.print(fila);
            //System.out.print(fila+=fila+"*");
            for(int j = 1; j<=ast; j++){
                System.out.print("*");
            }
            System.out.print("\n");
            ast+=2;
            espacios--;
        }
        
        System.out.println("FIN DEL PROGRAMA");
    }
    
}