/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package almacen;

/**
 *
 * @author matii
 */
public class TestAlmacen {
    
    public static void main(String[] args) {
        Almacen miAlmacen = new Almacen(5);
        Azucarada cokitacola= new Azucarada(4, 1, "cokita", 10, true);
        AguaMineral awita = new AguaMineral(2, 2, "zum", "manantial");
        
        miAlmacen.agregar(cokitacola);
        miAlmacen.agregar(awita);
        miAlmacen.agregar(awita);
        miAlmacen.agregar(cokitacola);
        miAlmacen.agregar(cokitacola);
        
        System.out.printf("Precio total: %.2f\n",miAlmacen.calcularPrecio());
        
        miAlmacen.mostrar();
    }
    
}
