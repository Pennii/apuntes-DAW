
package ejercicio2;

import java.io.DataOutput;
import java.io.DataOutputStream;

/**
 * Clase que permite leer y escribir un objeto CAgendaContactos serializable en 
 * un archivo binario.
 * 
 * @author profe
 */

public class CAgendaContactosIO {
    /**
     * Ruta del archivo donde se lee y escribe el objeto CAgendaContactos
     */
    private String rutaArchivo;
    

    /**
     * Método constructor
     * @param archivo Ruta del archivo donde se lee y escribe el objeto CAgendaContactos
     */
    public CAgendaContactosIO(String archivo) {
        this.rutaArchivo = archivo;
    }
    
    // -----------------------------------------------------
    // Ejercicio 2: Métodos que debe implementar el alumnado
    // -----------------------------------------------------
    
    // 2.1. Método leer()
    /**
     * Método que lee, desde un archivo binario, un objeto CAgendaContactos serializado.
     * @return Objeto CAgendaContactos que estaba almacenado en el archivo binario.
     */
    public CAgendaContactos leer() {
       return null; // Sustituir este return por el código que resuelve el ejercicio 
    }
     
    // 2.2. Método escribir()
    /**
     * Método que escribe, en un archivo binario, un objeto CAgendaContactos serializable.
     * @param agenda Objeto CAgendaContactos serializable para almacenar en el archivo binario.
     */   
    public void escribir(CAgendaContactos agenda) {
        // Incluir el código que debe realizar el método
        
    }
}
