package coche;

/**
 * clase donde se ejecutara el codigo de coche
 *
 * @author Matias Pennino
 */
public class Main {

    /**
     * metodo main de la clase
     *
     * @param args
     */
    public static void main(String[] args) {
        Coche miCoche_Pennino_Matias;
        int stockActual;

        miCoche_Pennino_Matias = new Coche("Opel", 12000, 1000);
        venderCoches(miCoche_Pennino_Matias);

        comprarCoche(miCoche_Pennino_Matias);
        stockActual = miCoche_Pennino_Matias.obtenerStock();
        System.out.println("El stock actual es" + stockActual);
    }

    /**
     * metodo que realiza la compra de autos
     * @param miCoche_Pennino_Matias modelo de auto que se utiliza para la compra
     */
    public static void comprarCoche(Coche miCoche_Pennino_Matias) {
        try {
            System.out.println("Compra de Coches");
            miCoche_Pennino_Matias.comprar(150);
        } catch (Exception e) {
            System.out.print("Fallo al ingresar");
        }
    }

    /**
     * metodo que realiza la venta de autos
     *
     * @param miCoche_Pennino_Matias modelo de auto que se utiliza para la venta
     */
    public static void venderCoches(Coche miCoche_Pennino_Matias) {
        try {
            System.out.println("Venta de Coches");
            miCoche_Pennino_Matias.vender(500);
        } catch (Exception e) {
            System.out.print("Fallo al vender");
        }
    }

}
