package tienda;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.LinkedList;
import java.util.List;

/**
 * Clase que lee de un fichero binario, donde se grabó una list de objetos
 * Producto y muestra el contenido de lo leído por consola.
 */
public class BinarioProductosToConsola {

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

    public static void main(String[] args) throws ClassNotFoundException {
        List<Producto> lista;
        System.out.println("La lista es:");
        lista = BinarioProductosToConsola.cargar();
        for (Producto producto : lista) {
            System.out.println(producto);
        }
    }
}
