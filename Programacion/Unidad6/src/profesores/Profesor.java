package profesores;

/**
 *
 * @author maniana
 */
public class Profesor {

    public static final int ANIOS_CONSOLIDADO_DEFAULT = 1;
    
    private String nombre;
    private int edad;
    private int aniosConsolidado;

    public Profesor(int edad, String nombre, int anios) {
        this.aniosConsolidado = anios;
        this.edad = edad;
        this.nombre = nombre;
    }

    public Profesor(int edad, String nombre) {
        this(edad, nombre, Profesor.ANIOS_CONSOLIDADO_DEFAULT);
    }

    public Profesor() {
        this.nombre = "";
        this.edad = 18;
        this.aniosConsolidado = Profesor.ANIOS_CONSOLIDADO_DEFAULT;
    }

    public int getAniosConsolidado() {
        return this.aniosConsolidado;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int e) {
        this.edad = e;
    }

    public void setAniosConsolidado(int e) {
        this.aniosConsolidado = e;
    }
    
    public void setNombre(String n){
        this.nombre = n;
    }
}
