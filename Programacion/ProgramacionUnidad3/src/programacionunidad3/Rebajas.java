/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programacionunidad3;

/**
 *
 * @author maniana
 * Crea una clase Rebajas con un método descubrePorcentaje() que
descubra el descuento aplicado en un producto. El método recibe el
precio original del producto y el rebajado y halla el porcentaje
 */
import java.util.Scanner;
public class Rebajas {
    private float precio;
    private float descuento;
    private float precioFinal;
    
    public void setPrecio(float p){
        precio = p;
    }
    
    public void setDescuento(float d){
        descuento = d;
    }
    
    public float descubreporcentaje(){
        precioFinal = precio - precio * (descuento/100);
        return precioFinal;
    }
    
    public static void main(String[] args){
        Rebajas producto = new Rebajas();
        Scanner teclado = new Scanner(System.in);
        float precio, desc;
        System.out.println("Ingresa el precio del producto");
        precio = teclado.nextFloat();
        producto.setPrecio(precio);
        System.out.println("Ingresa el descuento del producto");
        desc = teclado.nextFloat();
        producto.setDescuento(desc);
        System.out.println("el precio final sera: "+ producto.descubreporcentaje());
    }
}
