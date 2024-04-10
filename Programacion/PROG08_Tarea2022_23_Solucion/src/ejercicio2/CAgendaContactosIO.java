
package ejercicio2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 * La serialización es un proceso por el que un objeto se convierte en una secuencia de bytes con la que más tarde
 * se podrá reconstruir el valor de sus variables. Esto permite guardar un objeto en un archivo.
 * Para serializar un objeto:
 * 1. Este objeto debe implementar el interface java.io.Serializable. Este interface no tiene métodos, solo se usa para
 * informar a la JVM (Java Virtual Machine) que un objeto va a ser serializado.
 * 2. Todos los objetos incluidos en él tienen que implementar el interfaz Serializable.
 * 
 * Todos los tipos primitivos en Java son serializables por defecto. (Al igual que los arrays y otros muchos tipos estándar).
 * Para leer y escribir objetos serializables a un stream se utilizan las clases java: 
 * -- ObjectInputStream
 * -- ObjectOutuputStream
 * En el siguiente ejemplo se puede ver cómo leer un objeto serializado que se guardó antes. En este caso, se trata de un
 * String serializado:
 * 
 * FileInputStream fichero = new FileInputStream("str.out");
 * ObjectInputStream objetoStream = new ObjectInputStream(fichero);
 * Object objeto = objetoStream.readObject();
 * 
 * Así vemos que readObject lee un objeto desde el flujo de entrada fichero. Cuando se leen objetos desde un flujo, se debe
 * tener en cuenta qué tipo de objetos se esperan en el flujo, y se han de leer en el mismo orden en que se guardaron.
 * 
 * Una cuestión importante a tener en cuenta en una clase serializable es declarar un atributo que se debe llamar: serialVersionUID
 * y que debemos definir como static, final y de tipo long. Oracle recomienda encarecidamente que toda clase serializable declare
 * explícitamente un valor serialVersionUID, para evitar InvalidClassExceptions inserperados durante la deserialización. También se
 * recomienda encarecidamente que las declaraciones explícitas serialVersionUID utilicen el modificador private siempre que sea
 * posible.
 * 
 * Así, por ejemplo, en una clase serializable, tendremos:
 *                                                     private static final long serialVersionUID = 42L;
 * 
 * 
 */
public class CAgendaContactosIO {
    
    // Ruta del archivo donde se lee y escribe el objeto CAgendaContactos
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
        // Declaración del objeto de tipo CAgendaContactos
        CAgendaContactos agenda = null;

        try ( // Abrimos el archivo para lectura
                ObjectInputStream oisCAgenda = new ObjectInputStream(new FileInputStream(rutaArchivo));) {

            // Cargamos el contenido completo del archivo en el objeto CAgendaContactos
            agenda = (CAgendaContactos) oisCAgenda.readObject();

        // Con try-with-resources los flujos se cierran de forma automática.
        } catch (FileNotFoundException e) {
            System.out.println("Error: archivo " + rutaArchivo + "·no encontrado.");
        } catch (IOException e) {
            System.out.println("Error: fallo en el acceso al archivo: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error: el contenido del archivo no se corresponde con lo que se esperaba.");
        } catch (ClassCastException e) {
            System.out.println("Error: el archivo no contiene una agenda de contactos.");
        }
        // Devolvemos el objeto CAgendaContactos que estaba almacenado en el archivo binario.
        return agenda;
    }
    
   
    // 2.2. Método escribir()
    /**
     * Método que escribe, en un archivo binario, un objeto CAgendaContactos serializable.
     * @param agenda Objeto CAgendaContactos serializable para almacenar en el archivo binario.
     */   
    public void escribir(CAgendaContactos agenda) {

        try ( //Abrimos los flujos de datos serializados de salida.
                ObjectOutputStream oosCAgenda = new ObjectOutputStream(new FileOutputStream(rutaArchivo));) {

            // Escribimos en archivo binario los datos serializados.
            oosCAgenda.writeObject(agenda);

        // Con try-with-resources los flujos se cierran de forma automática.
        } catch (IOException e) {
            System.out.println("Error: fallo en el acceso al archivo: " + e.getMessage());
        }
    }
}
