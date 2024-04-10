package ejercicio1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Ejercicio 1: Lectura/escritura de una agenda de contactos en ficheros de
 * texto.
 *
 * @author profe
 */
public class Ejercicio1 {

    /**
     * Método principal.
     *
     * @param args argumentos que recibe el método
     */
    public static void main(String args[]) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        
        // Variables de entrada
        // Ruta a los ficheros que almacenan el listado de contactos y de aficiones. Para poder
        // acceder a estas ubicaciones, usamos la llamada al sistema System.getProperty("user.dir"),
        // que nos devuelve la ruta absoluta a nuestro proyecto actual. Cada archivo se accede 
        // desde la carpeta recursos concatenada a dicha ruta.
        String rutaContactos = System.getProperty("user.dir") + "/recursos/ListadoContactos.txt";
        String rutaAficiones = System.getProperty("user.dir") + "/recursos/ListadoAficiones.txt";

        // Variables de salida
        // Ruta al fichero que almacenará los contactos (cada uno de ellos con un conjunto de 
        // aficiones aleatorias). Este fichero también se ubicará dentro de la carpeta recursos.
        String rutaAgenda = System.getProperty("user.dir") + "/recursos/BDCAgendaContactos.txt";
        
        // Variables auxiliares
        String cadena, nombre, direccion, telefono, tipoContacto;
        StringTokenizer tokenContactos, tokenContacto;
        LocalDate fechaNacimiento;
        CPersona p;
        String[] cadenaSeparada;
        List<String> aficiones = new ArrayList();
        // Objeto de tipo CAgendaContactos para albergar cada uno de los objetos CPersona (contactos).
        CAgendaContactos miAgenda = new CAgendaContactos();

        //----------------------------------------------
        //       Entrada de datos + Procesamiento
        //----------------------------------------------
        
        System.out.println("Abriendo archivo de aficiones...");                   
        System.out.println("Abriendo archivo de contactos...");
        
        // Abrimos los archivos de contactos y aficiones para la lectura. Aquí usamos la estructura
        // try-with-resources, que cierra los recursos de forma automática.
        try (BufferedReader brContactos = new BufferedReader(new FileReader(rutaContactos));
                BufferedReader brAficiones = new BufferedReader(new FileReader(rutaAficiones))) {

            // Leemos las aficiones del fichero y las almacenamos en una lista.
            while ((cadena = brAficiones.readLine()) != null) {
                aficiones.add(cadena);
            }

            // Leemos los contactos del fichero y vamos extrayendo cada uno de los campos.
            // Cada dato está separado por el carácter ';'. Utilizamos el método split para la extracción.
            while ((cadena = brContactos.readLine()) != null) {
                cadenaSeparada = cadena.split(";");
                nombre = cadenaSeparada[0].trim();
                direccion = cadenaSeparada[1].trim();
                telefono = cadenaSeparada[2].trim();
                fechaNacimiento = LocalDate.parse(cadenaSeparada[3].trim());
                tipoContacto = cadenaSeparada[4].trim();

                // Para cada contacto generamos un objeto de tipo CPersona.
                p = new CPersona(nombre, direccion, telefono, fechaNacimiento, tipoContacto);
                // Asignamos tres aficiones al azar al objeto CPersona.
                p.setAficiones(Utilidades.generarAficiones(aficiones));

                // Insertamos el objeto CPersona en la agenda (objeto CAgendaContactos).
                miAgenda.add(p);
            }
        } catch (FileNotFoundException e) {
            System.out.printf("Error de entrada/salida: %s\n", e.getMessage());
        } catch (IOException e) {
            System.out.printf("Error de entrada/salida: %s\n", e.getMessage());
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.printf(e.getMessage());
        }
        // Lectura y procesamiento finalizado: cerramos los archivos.
        // No es necesario brContactos.close() ni brAficiones.close porque se usa un try-with-resources.
        System.out.println("Cerrando archivo de aficiones...");
        System.out.println("Cerrando archivo de contactos...");

        System.out.println();

        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        
        // Antes de almacenar la información del objeto CAgendaContactos en el fichero de salida,
        // nos aseguramos de que contiene información (contactos).
        if (miAgenda.numPersonas() != 0) {
            
            System.out.println("Abriendo archivo de la agenda...");

            // Abrimos el archivo de salida para almacenar la información del objeto CAgendaContactos.
            // Aquí usamos de nuevo la estructura try-with-resources.
            try (PrintWriter pwAgenda = new PrintWriter(new FileWriter(rutaAgenda))) {

                // Escribimos la línea de cabecera con la estructura especificada.
                pwAgenda.printf("%s\t%-20s\t%-25s\t%-10s\t%-10s\t%-10s\t%s\n",
                        "ID.", "NOMBRE Y APELLIDOS", "DIRECCIÓN", "TELÉFONO", "FECHA NAC.", "TIPO CONTACTO", "AFICIONES");

                // Obtenemos la representación textual del objeto CAgendaContactos y extraemos cada contacto
                // usando StringTokenizer.
                tokenContactos = new StringTokenizer(miAgenda.toString(), "#");

                // Escribimos los campos de cada contacto en el fichero de salida con la estructura especificada.
                while (tokenContactos.hasMoreTokens()) {
                    String contacto = tokenContactos.nextToken();
                    // Para extraer cada campo dentro de un contacto, usamos de nuevo StringTokenizer. Recuerda 
                    // que los campos están separados por el carácter ';'.
                    tokenContacto = new StringTokenizer(contacto, ";");
                    pwAgenda.printf("[%s]\t%-20s\t%-25s\t%-10s\t%-10s\t%-10s\t%s\n",
                            tokenContacto.nextToken(), tokenContacto.nextToken(), tokenContacto.nextToken(), tokenContacto.nextToken(),
                            tokenContacto.nextToken(), tokenContacto.nextToken(), tokenContacto.nextToken());
                }
            } catch (IOException e) {
                System.out.printf("Error de entrada/salida: %s\n", e.getMessage());
            }
            // Escritura finalizada: cerramos el archivo.
            // No es necesario pwAgenda.close() porque se usa un try-with-resources.
            System.out.println("Cerrando archivo de la agenda...");

            System.out.println();
            System.out.println("Archivos cerrados y procesamiento finalizado");
            System.out.println("---------");
            System.out.println();
            System.out.println("Fin del programa.");
        }
        // Si el objeto CAgendaContactos no contiene ningún contacto, mostramos el mensaje correspondiente por pantalla.
        else{
            System.out.println("La agenda no tienen ningún contacto. El archivo 'BDCAgendaContactos.txt' no ha sido creado.");            
        }
    }
}
