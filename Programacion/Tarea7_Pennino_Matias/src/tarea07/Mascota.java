package tarea07;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Clase Mascota
 *
 * @author Profesor
 */
public class Mascota {

    private final String nombre;
    private final int edad;
    private final String tipo;
    private final String sexo;
    private final String raza;
    private final List<String> caracteristicas;

    /**
     * Constructor
     *
     * @param nombre nombre de la mascota
     * @param edad edad de la mascota (en años)
     * @param tipo tipo de mascota (Perr@, Gat@)
     * @param sexo sexo de la mascota (Macho, Hembra)
     * @param raza raza de la mascota
     * @param caracteristicas características de la mascota
     */
    public Mascota(String nombre, int edad, String tipo, String sexo, String raza, String... caracteristicas) {
        this.nombre = nombre;
        this.edad = edad;
        this.tipo = tipo;
        this.sexo = sexo;
        this.raza = raza;
        this.caracteristicas = new LinkedList<>();
        this.caracteristicas.addAll(Arrays.asList(caracteristicas));
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
     * Obtiene la lista de características de la mascota
     * @return caracteristicas
     */
    public List<String> getCaracteristicas() {
        return this.caracteristicas;
    }
    
    /**
     * Obtiene una representaci�n textual de los datos de la mascota. Aparece encerrada
     * entre llaves ({...}). 
     * El primer elemento ser� el nombre de la mascota, seguido de edad, raza, sexo y tipo.
     * El resto de elementos, encerrados en unos corchetes,
     * y separados por comas, ser�n las caracter�sticas de la mascota.
     *
     * @return una representaci�n textual de los datos de la mascota.
     */
    @Override
    public String toString() {
        return String.format("{\"%s\", %s, %s, %s, %s, %s}\n",
                this.getNombre(),
                this.getEdad(),
                this.getRaza(),
                this.getSexo(),
                this.getTipo(),
                this.getCaracteristicas()
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
                    this.getTipo().equals(animal.getTipo()) &&
                    this.getCaracteristicas().equals(animal.getCaracteristicas()));
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
        hash = 89 * hash + Objects.hashCode(this.caracteristicas);
        return hash;
    }
}
