package programacionunidad3;

/**
 *
 * @author maniana
 */
import java.util.Scanner;
public class Temperatura {
    
//    atributos
    private String uni;
    private double cant;
    
//    definicion de metodos
    public double celsiusToFarenheit(double c){
        cant = c * 9/5 + 32;
        return cant;
    }
    public double farenheitToCelsius(double c){
        cant = (c - 32) * 5/9;
        return cant;
    }
    public String valor(char un, double c){
        if(un == 'c'|| un == 'C'){
            celsiusToFarenheit(c);
            uni = "Celsius";
            return uni;
        }else{
            farenheitToCelsius(c);
            uni = "Farenheit";
            return uni;
        }
    }
    public void printResult(){
            System.out.println("La temperatura se transformo desde "+uni);
            System.out.println("la temperatura transformada es: "+cant);
    }
    
    public static void main(String[] args){
        double c;
        char u;
        Temperatura nueva = new Temperatura();
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Ingresa 'f' para transformar de farenheit a celsius o 'c' para hacer de celsius a farenheit");
        u = teclado.nextLine().charAt(0);
        System.out.println("ingresa la temperatura");
        c = teclado.nextDouble();
        nueva.valor(u, c);
        nueva.printResult();
    }
}
