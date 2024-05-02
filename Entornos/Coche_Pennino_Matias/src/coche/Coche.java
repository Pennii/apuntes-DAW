
package coche;

/**
 * Clase que simula el comportamiento de una empresa de compra y venta de autos
 * @author Matias Pennino
 */
public class Coche {

    private String nombre;
    private double precio;
    private double precioIVA;
    private int stock;

    /**
     * Constructor sin parametros
     */
    public Coche ()
    {
    }
   
    /**
     * constructor con tres parametros
     * @param nom nombre del auto
     * @param precio precio del auto
     * @param stock cantidad de autos
     */
    public Coche (String nom, double precio, int stock)
    {
        this.nombre =nom;
        this.precio=precio;
        this.stock=stock;
    }
   
    /**
     * metodo que asigna un nombre a un auto
     * @param nom nombre a asignar
     */
    public void asignarNombre(String nom)
    {
        nombre=nom;
    }
    
    /**
     * metodo que devuelve el nombre del auto
     * @return nombre del auto
     */
    public String obtenerNombre()
    {
        return nombre;
    }

    /**
     * metodo que devuelve la cantidad de autos que hay en stock de ese modelo
     * @return cantidad de ese modelo
     */
     public int obtenerStock ()
    {
        return stock;
    }

    /**
     * metodo que modifica la cantidad de autos, simulando la compra de estos
     * @param cantidad autos a comprar
     * @throws Exception si la cantidad es negativa
     */
    public void comprar(int cantidad) throws Exception
    {
        if (cantidad<0)
            throw new Exception("No se puede comprar un nº negativo de coches");
        stock = stock + cantidad;
    }

    /**
     * metodo que modifica la cantidad de autos, simulando la venta de estos
     * @param cantidad autos a vender
     * @throws Exception si la cantidad es igual o menor a 0, o si no hay la 
     * cantidad suficiente de autos
     */
    public void vender (int cantidad) throws Exception
    {
        if (cantidad <= 0)
            throw new Exception ("No se puede vender una cantidad negativa de coches");
        if (obtenerStock()< cantidad)
            throw new Exception ("No se hay suficientes coches para vender");
        stock = stock - cantidad;
    }
    
}  
   
    

