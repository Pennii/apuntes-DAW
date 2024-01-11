/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programacionunidad3;

/**
 *
 * @author matii
 */
import java.util.Scanner;

public class Numero {

    private int valor = 0;

    public Numero() {
        valor = 0;
    }

    public void aniade(int v) {
        valor += v;
    }

    public void menos(int v) {
        valor -= v;
    }

    public int getValor() {
        return valor;
    }

    public int getDoble() {
        return valor * 2;
    }

    public int getTriple() {
        return valor * 3;
    }

    public void setNum(int v) {
        valor = v;
    }

    public static void main(String[] args) {
        Numero num1 = new Numero();
        Scanner teclado = new Scanner(System.in);
        int v, x;
        char p;
        System.out.println("ingresa el valor del numero");
        v = teclado.nextInt();

        num1.setNum(v);
        do {
            System.out.println("ingresa el numero a sumar o restar");
            x = teclado.nextInt();
            System.out.println("quieres sumar o restar? ('s' o 'm')");
            teclado.nextLine();
            p = teclado.nextLine().charAt(0);
            switch (p) {
                case 's' -> {
                    num1.aniade(x);
                    break;
                }
                case 'm' -> {
                    num1.menos(x);
                    break;
                }
                default -> {
                    System.out.println(p);
                }
            }
        } while (x != 0);
        System.out.println("el valor final es: " + num1.getValor());
        System.out.println("el doble del valor es: " + num1.getDoble());
        System.out.println("el triple del valor es: " + num1.getTriple());
    }
}
