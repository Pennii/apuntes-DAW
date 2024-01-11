
package actividadu3m;
import java.util.Scanner;

public class Tv {
    public static void main(String[] args){
        String nom, ape, appe;
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("ingrese el nombre");
        nom = teclado.nextLine();
        System.out.println("ingrese el primer apellido");
        ape = teclado.nextLine();
        System.out.println("ingrese el segundo apellido");
        appe = teclado.nextLine();
        
        nom = nom.toLowerCase();
        System.out.println("la persona es "+ (nom.charAt(0)==nom.charAt(nom.length()-1)
        &&ape.length() == appe.length()?"apta":"no apta"));
    }
}
