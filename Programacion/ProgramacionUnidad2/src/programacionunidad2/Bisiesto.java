/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programacionunidad2;

/**
 *
 * @author maniana
 */
import java.util.Scanner;
public class Bisiesto {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        System.out.println("ingresa un año");
        int an = teclado.nextInt();
        
        if((an%4==0&&an%100!=0)||an%400==0){
            System.out.println("es bisiesto");
        }else{
            System.out.println("no es bisiesto");
        }
    }
    
}
