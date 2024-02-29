package churrero;

public abstract class Producto {

    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return this.nombre;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double calcular(int cantidad){
        double precioFinal;
        
        precioFinal = this.precio * cantidad;
        return precioFinal;
    }
    
    public String toString() {
        return String.format("nombre: %s, precio: %.2f", this.nombre,
                this.precio);
    }
}
