package profesores;

/**
 *
 * @author maniana
 */
public class ProfesorEmerito extends Profesor {
   
    private int aniosEmerito;
    
    public ProfesorEmerito(int edad, String nombre, int anio){
        super(edad, nombre, anio);
    }
    
    public ProfesorEmerito(int edad, String nombre){
        super(edad, nombre);
    }
    
    public double getSueldoBase(){
        double sueldo;
        sueldo = 925 + this.getAniosConsolidado() * 33.25 + 47.80 * this.aniosEmerito;
        return sueldo;
    }
}
