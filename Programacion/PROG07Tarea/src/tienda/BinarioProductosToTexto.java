package tienda;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

/**
 * Carga en memoria una lista objetos de tipo Producto a partir del fichero
 * binario proporcionado y los muestra por consola tal y como se indica en el
 * ejemplo. El fichero .dat que te proporcionamos contiene una estructura de
 * tipo LinkedList serializada con esos diez productos de ejemplo. Una vez que
 * se tengan los productos en memoria, se generará el archivo de texto
 * productos_salida.txt donde cada producto estará representado por una línea.
 *
 * @author Profesor
 */
public class BinarioProductosToTexto {

    private static final String NOMBRE_ARCHIVO_ENTRADA_BIN_DEFAULT = "productos_entrada.dat";

    public static LinkedList cargar() throws ClassNotFoundException {
        LinkedList<Producto> lista = new LinkedList<>();

        try (FileInputStream file = new FileInputStream(NOMBRE_ARCHIVO_ENTRADA_BIN_DEFAULT); ObjectInputStream ois = new ObjectInputStream(file) {
        }) {
            lista = (LinkedList<Producto>) ois.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println();
        } catch (IOException ex) {
            System.out.println(ex);
        }

        return lista;
    }
    
    public static void escribir(List<Producto> lista){
        String texto;
        try(FileWriter fw = new FileWriter("productos_salida.txt"); BufferedWriter bw = new BufferedWriter(fw)){
            for (Producto prod : lista) {
                texto = String.format("id:%s#nombre:%s#descripcion:%s#precio:%.2f\n", 
                        prod.getId(), prod.getNombre(), prod.getDescripcion(), prod.getPrecio());
                bw.write(texto);
            }
        }
        catch(IOException ex){
            System.out.println(ex);
        }
    }

    /**
     * Programa principal de prueba de escritura de productos en un archivo de
     * texto
     *
     * @param args argumentos de la línea de ordenes
     */
    public static void main(String[] args) throws ClassNotFoundException {
        List<Producto> lista;
        System.out.println("La lista es:");
        lista = BinarioProductosToTexto.cargar();
        BinarioProductosToTexto.escribir(lista);
    }
}
