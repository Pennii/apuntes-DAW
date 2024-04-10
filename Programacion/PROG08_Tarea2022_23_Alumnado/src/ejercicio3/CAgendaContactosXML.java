
package ejercicio3;

import com.thoughtworks.xstream.XStream;

/**
 * Clase que permite serializar un objeto CAgendaContactos al formato XML y 
 * viceversa.
 *   
 * @author profe
 */
public class CAgendaContactosXML {
    
     /**
     * Ruta del archivo donde se lee y escribe el objeto CAgendaContactos
     */
    private String rutaArchivo;
    
    /**
     * Objeto Xstream que permite la L/E con archivos XML
     */
    private XStream xstream;

    /**
     * Método constructor
     * @param nombreArchivo Ruta del archivo donde se lee y escribe el objeto CAgendaContactos
     */
    public CAgendaContactosXML(String nombreArchivo) {
        this.rutaArchivo = nombreArchivo;
        xstream = new XStream();
        
        //Permite asignar privilegios para poder operar con los archivos XML
        xstream.allowTypesByWildcard(new String[] { 
            "ejercicio3.**",
            "com.mydomain.utilitylibraries.**"
        });
    }

    
    // -----------------------------------------------------
    // Ejercicio 3: Métodos que debe implementar el alumnado
    // -----------------------------------------------------
    
    // 3.1. Método escribir()
    /**
     * Método que escribe, en un archivo de texto, un objeto CAgendaContactos serializable.
     * @param agenda Objeto CAgendaContactos serializable para almacenar en el archivo de texto.
     */
    public void escribir(CAgendaContactos agenda) {
        // Incluir el código que debe realizar el método
    }
    
     // 3.2. Método leer()
     /**
     * Método que lee, desde un archivo de texto, un objeto CAgendaContactos serializado.
     * @return Objecto CAgendaContactos que estaba almacenado en el archivo de texto.
     */
    public CAgendaContactos leer() {
        return null; // Sustituir este return por el código que resuelve el ejercicio 
    }
}
