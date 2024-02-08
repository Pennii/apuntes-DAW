
package coche;

/**
 *
 * @author Fran
 */
public class Main {
    
      public static void main(String[] args) {
        Coche miCoche_Pennino_Matias;
        int stockActual;
        
        miCoche_Pennino_Matias = new Coche("Opel",12000,1000);
        try 
        {
            System.out.println("Venta de Coches");
            miCoche_Pennino_Matias.vender(500);
        } catch (Exception e)
        {
            System.out.print("Fallo al vender");
        }
        
        try
        {
            System.out.println("Compra de Coches");
            miCoche_Pennino_Matias.comprar(150);
        } catch (Exception e)
        {
            System.out.print("Fallo al ingresar");
        }
        stockActual = miCoche_Pennino_Matias.obtenerStock();
        System.out.println("El stock actual es"+ stockActual );
    }

}
    
