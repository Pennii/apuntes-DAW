/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package churrero;

/**
 *
 * @author maniana
 */
public class TestChurrero {
    
    public static void main(String[] args) {
        Producto lista[] = new Producto[5];
        
        for (int i = 0; i < 5; i++) {
            if (i % 2 == 0) {
                lista[i] = new Perecedero("manzana", 1, 1);
            }else{
                lista[i] = new NoPerecedero("lata", 1, "Comida");
            }
        }
        
        System.out.println("Se calculara el precio de cada producto, la cantidad sera su posicion + 1");
        
        for (int i = 0; i < 5; i++) {
            System.out.printf("%s\n%.2f\n",lista[i].toString(), lista[i].calcular(i+1));
        }
        
        for (Producto carro : lista){
            if (carro instanceof Perecedero ) {
                System.out.print("Dias a caducar: ");
                System.out.println(((Perecedero) carro).getDias());
            } else if (carro instanceof NoPerecedero) {
                System.out.print("Tipo: ");
                System.out.println(((NoPerecedero) carro).getTipo());
            }
   
        }
    }
    
}
