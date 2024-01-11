
package actividadu3m;

/**
 *
 * @author matii
 */
import java.util.Scanner;
public class Natacion {
    public static void main(String[] args){
        
        float metc, mete, metb, km;
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("ingresa los largos");
        int largos = teclado.nextInt();
        System.out.println("indica la cantidad de metros de la piscina");
        float metros = teclado.nextFloat();
        
        metc = (largos/4+(largos%4>0?1:0))*metros;
        metb = (largos/4+(largos==3?1:0))*metros;
        mete = largos/2*metros;
        km = (metc + mete)/1000;
        
        System.out.println("la cantidad de metros recorridos en crol es "+metc);
        System.out.println("la cantidad de metros recorridos en brazo es "+metb);
        System.out.println("la cantidad de metros recorridos en espalda es "+mete);
        System.out.println("la cantidad de kilometros recorridos es "+km);
        
    }
}
