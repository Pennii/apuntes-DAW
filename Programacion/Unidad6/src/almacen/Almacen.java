/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package almacen;

/**
 *
 * @author matii
 */
public class Almacen {

    private Producto bebidas[];

    public Almacen(int cant) {
        this.bebidas = new Producto[cant];
    }

    public boolean agregar(Producto p) {
        boolean agregado = false;
        for (int i = 0; i < this.bebidas.length && !agregado; i++) {
            if (this.bebidas[i] == null) {
                this.bebidas[i] = p;
                agregado = true;
            }
        }
        return agregado;
    }

    public boolean eliminar(int id) {
        boolean eliminado = false;

        for (int i = 0; i < this.bebidas.length; i++) {
            if (this.bebidas[i].getId() == id) {
                this.bebidas[i] = null;
                eliminado = true;
            }
        }

        return eliminado;
    }
    
    public void mostrar(){
        String resultado = "";
        for (int i = 0; i < this.bebidas.length; i++) {
            if (this.bebidas[i] != null) {
                resultado+= this.bebidas[i].toString()+"\n";
            }
        }
        if (resultado.equals("")) {
            resultado = "AUN NO HAY BEBIDAS";
        }
        System.out.println(resultado);
    }
    
    public double calcularPrecio(){
        double precioTot = 0;
        
        for (int i = 0; i < this.bebidas.length; i++) {
            if (this.bebidas[i] != null) {
                precioTot += this.bebidas[i].precio;
            }
        }
        
        return precioTot;
    }

}
