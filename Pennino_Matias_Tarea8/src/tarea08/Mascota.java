package tarea08;

import java.io.Serializable;
import java.util.Objects;

/**
 * Clase Mascota
 *
 * @author Profesor
 */
public class Mascota implements Serializable {

    private final String nombre;
    private final int edad;
    private final String tipo;
    private final String sexo;
    private final String raza;
    private static final long serialVersionUID = 42L;

    /**
     * Constructor
     *
     * @param nombre nombre de la mascota
     * @param edad edad de la mascota (en años)
     * @param tipo tipo de mascota (Perr@, Gat@)
     * @param sexo sexo de la mascota (Macho, Hembra)
     * @param raza raza de la mascota
     * 
     */
    public Mascota(String nombre, int edad, String tipo, String sexo, String raza) {
        this.nombre = nombre;
        this.edad = edad;
        this.tipo = tipo;
        this.sexo = sexo;
        this.raza = raza;
    }

    /**
     * Obtiene el nombre de la mascota
     * @return nombre
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Obtiene la edad de la mascota
     * @return edad
     */
    public int getEdad() {
        return this.edad;
    }

    /**
     * Obtiene el tipo de mascota (Perr@, Gat@)
     * @return tipo
     */
    public String getTipo() {
        return this.tipo;
    }

    /**
     * Obtiene el sexo de la mascota (Macho, Hembra)
     * @return tipo
     */
    public String getSexo() {
        return this.sexo;
    }
    
    /**
     * Obtiene la raza de la mascota
     * @return raza
     */
    public String getRaza() {
        return this.raza;
    }

    
    /**
     * Obtiene una representación textual de los datos de la mascota. Aparece encerrada
     * entre llaves ({...}). 
     * El primer elemento será el nombre de la mascota, seguido de edad, raza, sexo y tipo.
     * El resto de elementos, encerrados en unos corchetes,
     * y separados por comas, serán las características de la mascota.
     *
     * @return una representación textual de los datos de la mascota.
     */
    @Override
    public String toString() {
        return String.format("{%s, %s, %s, %s, %s}\n",
                this.getNombre(),
                this.getEdad(),
                this.getTipo(),
                this.getSexo(),
                this.getRaza()
                );
    }
    
    /**
     * Compara dos objetos de tipo mascota, dato por dato para comprobar si son iguales
     * @param o objeto de tipo mascota con el que se realiza la comparaci�n
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        
        boolean resultado=true;    
        Mascota animal = null;
        
        if (!(o instanceof Mascota)) {           
            resultado=false;
        } else {
            animal = (Mascota)o;
        
            resultado =(this.getNombre().equals(animal.getNombre()) &&
                    this.getEdad()== animal.getEdad() &&
                    this.getRaza().equals(animal.getRaza()) &&
                    this.getSexo().equals(animal.getSexo()) &&
                    this.getTipo().equals(animal.getTipo()));
        }
        return resultado;
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.nombre);
        hash = 89 * hash + this.edad;
        hash = 89 * hash + Objects.hashCode(this.tipo);
        hash = 89 * hash + Objects.hashCode(this.sexo);
        hash = 89 * hash + Objects.hashCode(this.raza);
        
        return hash;
    }
}
