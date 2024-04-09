package ejercicio1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


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
        final String RUTA_CONTACTOS = "recursos/ListadoContactos.txt";
        final String RUTA_AFICIONES = "recursos/ListadoAficiones.txt";
        // Variables de entrada
        List<String> aficiones = new LinkedList<>();
        CAgendaContactos agenda = new CAgendaContactos();
        // Variables de salida
        CPersona p;
        // Variables auxiliares
        String cadena, nombre, direccion, telefono, tipoContacto;
        String[] cadenaSeparada, listaContactos, elementosContacto;
        LocalDate fecNac;
        
        
        //----------------------------------------------
        //       Entrada de datos + Procesamiento
        //----------------------------------------------
        // Abrimos archivo de contactos ListadoContactos.txt
        System.out.println("Abriendo archivo de contactos...");
        try(BufferedReader buffContactos = new BufferedReader( new FileReader(RUTA_CONTACTOS));
                BufferedReader buffAficiones = new BufferedReader(new FileReader (RUTA_AFICIONES))){
            while ((cadena = buffAficiones.readLine())!=null){
                aficiones.add(cadena);
            }
            while((cadena = buffContactos.readLine())!= null){
                cadenaSeparada = cadena.split(";");
                nombre = cadenaSeparada[0].trim();
                direccion = cadenaSeparada[1].trim();
                telefono = cadenaSeparada[2].trim();
                fecNac = LocalDate.parse(cadenaSeparada[3].trim());
                tipoContacto = cadenaSeparada[4].trim();
                
                p = new CPersona(nombre, direccion, telefono, fecNac, tipoContacto);
                
                p.setAficiones(Utilidades.generarAficiones(aficiones));
                
                agenda.add(p);
            }
            
        }
        catch(FileNotFoundException e){
            System.out.println(e);
        }
        catch (IOException e){
            System.out.println(e);
        }
        catch (NullPointerException | IllegalArgumentException e){
            System.out.println(e);
        }
        
        
        
        // Abrimos archivo de aficiones ListadoAficiones.txt
        System.out.println("Abriendo archivo de aficiones...");
        
        
        
        
        

        System.out.println("Cerrando archivo de contactos...");
        System.out.println("Cerrando archivo de aficiones...");
        
        System.out.println();

        
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------

        // Abrimos el archivo de la agenda BDAgendaContactos.txt
        System.out.println("Abriendo archivo de la agenda...");
        try(PrintWriter pwAgenda = new PrintWriter(new FileWriter(RUTA_CONTACTOS+"copia.txt"))){
            pwAgenda.format("%-2s / %-40s / %-40s / %-9s / %-20s / %-15s / %s", 
                    "ID", "NOMBRE","DIRECCION","TELEFONO", "FECHA NACIMIENTO",
                    "TIPO", "AFICIONES");
            
            listaContactos = agenda.toString().split("#");
            for (int i = 0; i < listaContactos.length; i++) {
                System.out.println(listaContactos[i]);
            }
            for (int i = 1; i < listaContactos.length; i++) {
                elementosContacto = listaContactos[i].split(";");
                 pwAgenda.format("%-2s / %-40s / %-40s / %-9s / %-20s / %-15s / %s\n", 
                    elementosContacto[0], elementosContacto[1],elementosContacto[2],
                    elementosContacto[3], elementosContacto[4],elementosContacto[5],
                    elementosContacto[6]);
            }
        }
        catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        
        
        
        
        System.out.println("Cerrando archivo de la agenda... ");
        
        System.out.println();
        System.out.println("Archivos cerrados y procesamiento finalizado.");
        System.out.println("---------");
        System.out.println();
        System.out.println("Fin del programa.");
    }

}