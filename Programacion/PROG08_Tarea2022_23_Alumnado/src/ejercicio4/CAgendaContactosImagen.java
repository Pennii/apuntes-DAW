
package ejercicio4;


/**
 * Clase que permite leer archivos binarios que contienen imágenes y transformarlas
 * a una representación en forma de caracteres.
 * 
 * @author profe
 */
public class CAgendaContactosImagen {
     
    // Archivo donde se leen los nombres de la imágenes asociadas a las 
    // respectivas categorías.
    private String nombreArchivo;
    
    
    // Array donde se almacenan las diferentes líneas del archivo "nombreArchivo". 
    private String[] imagenes;
    
    
    // Indica el número máximo de categorías existentes.
    private int numCategorias;
    
    
    // Constante que indica la ruta donde se ubica el archivo "nombreArchivo" y las
    // imágenes asociadas a las categorías.
    private static final String rutaImagen = System.getProperty("user.dir") + "/recursos/";
    

    /**
     * Crea un objeto CAgendaContactosImagen. 
     *
     * @param nombreArchivo Archivo donde se leen los nombres de las imágenes
     * asociadas a las respectivas categorías.
     * @param numCategorias Número máximo de categorías existentes.
     */
    public CAgendaContactosImagen(String nombreArchivo, int numCategorias) {
        this.nombreArchivo = nombreArchivo;
        imagenes = new String[numCategorias];
        this.numCategorias = numCategorias;

        leerArchivoImagenes();
    }

    // -----------------------------------------------------
    // Ejercicio 4: Métodos que debe implementar el alumnado
    // -----------------------------------------------------
    
    // 4.1. Método leerArchivoImagenes()
    /*
     * Método que lee los nombres de las categorías y el de la imagen 
     * asociada a dichas categorías. Esta información la vuelca en el array 
     * imagenes.
     */
    private void leerArchivoImagenes() {
        // Abrimos el archivo que contiene cada categoría de contactos junto con 
        // el nombre del fichero con la imagen representativa de dicho contacto.
        
        
        // Almacenamos cada par "categoría;nombreArchivo.extensión" en el array 
        // imagenes.

    }
    
    // 4.2. Método leerImagen()
    /**
     * Método que lee una imagen correspondiente a una categoría específica.
     *
     * @param categoria nombre de la categoría de la que tiene que capturar la
     * imagen.
     * @return String Imagen correspondiente transformada a cadena de
     * caracteres.
     */
    public String leerImagen(String categoria) {
        // Obtenemos del array "imagenes" el nombre del archivo donde se encuentra
        // la imagen correspondiente a la categoría
            
        
        // Abrimos el archivo que contiene la imagen
            
        
        // Recorremos la imagen y convertimos cada pixel en un carácter. 
        // Cada carácter lo vamos agregando a una cadena de caracteres.
        
        
        return null; // Devolvemos la cadena de caracteres final
    }
}
