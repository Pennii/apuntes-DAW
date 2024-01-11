
package actividadu3m;

/**
 *
 * @author matii
 */
import java.util.Scanner;
public class Colores {
    public static void main(String[] args){
        
        Scanner teclado = new Scanner(System.in);
        
        int rojo, verde, azul;
        
        System.out.println("indica la cantidad de hojas");
        int hojas = teclado.nextInt();
        
        if(hojas%3==0){
            rojo = hojas/3;
            verde = hojas/3;
            azul = hojas/3;
            System.out.println("hojas rojas: "+ rojo);
            System.out.println("hojas verdes: "+ verde);
            System.out.println("hojas azules: "+azul);
                    
        }
        if(hojas%3==1){
            rojo = hojas/3+1;
            verde = hojas/3;
            azul = hojas/3;
            System.out.println("hojas rojas: "+ rojo);
            System.out.println("hojas verdes: "+ verde);
            System.out.println("hojas azules: "+azul);
        }
        if(hojas%3==2){
            rojo = hojas/3+1;
            verde = hojas/3+1;
            azul = hojas/3;
            System.out.println("hojas rojas: "+ rojo);
            System.out.println("hojas verdes: "+ verde);
            System.out.println("hojas azules: "+azul);
        }
    }
}
