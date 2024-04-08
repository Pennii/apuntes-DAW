package ejerciciosunidad8;

import java.io.*;

/*
 Seg�n el tipo de informaci�n que manejan, podemos distinguir dos tipos de ficheros:los de texto
 y los binarios.
 1. Los ficheros binarios almacenan la informaci�n en bytes, codificada en binario, pudiendo ser de 
 cualquier tipo: fotograf�as, m�sica, archivos ejecutables, etc.
    -- Para leer datos de un fichero binario, Java proporciona la clase FileInputStream.
    -- Para escribir datos a un fichero binario, contamos con la clase FileOutputStream.

 2. En los ficheros de texto la informaci�n se guarda como caracteres. Esos caracteres est�n codificados
 en Unicode, o en ASCII u otras codificaciones de texto.
    -- Para leer datos de un fichero de texto, tenemos la clase FileReader.
    -- Para escribir en archivos de texto, existe la clase FileWriter.

Un flujo puede ser envuelto por otro flujo para tratar el flujo de datos de forma m�s c�moda. Por 
este motivo, es muy com�n trabajar con las siguientes clases:
    -- BufferedReader: utiliza un buffer interno que mejora el rendimiento. Nos proporciona el m�todo
       readLine(), que recupera una l�nea completa del buffer.
    -- PrintWriter: a�ade m�todos como print, printf y println para imprimir contenidos de forma similar
       a como hace System.out, pero hasta que no se ejecuta el m�todo flush() o close() los contenidos no
       son escritos.

IMPORTANTE: hay que recordar que cada vez que se llama a un constructor se abre el flujo de datos y es 
necesario cerrarlo cuando no lo necesitemos. Para ello, tenemos el m�todo close().
Tambi�n es cierto que, a partir de Java 7 se introdujo un nuevo mecanismo de gesti�n de errores conocido
como "try-with-resources" que facilita cerrar recursos que se utilizan en un bloque try-catch. De esta forma,
nos ahorramos tenemos que cerrar los flujos de manera expl�cita...
Todo esto lo veremos a lo largo de este ejercicio.
*/

public class Ejercicio1 {
    
    public static void main(String args[]){

        //----------------------------------------------
        //          Declaraci�n de variables 
        //----------------------------------------------

        // Constantes

        // Variables de entrada
        String rutaCoeficientes = "recursos/coeficientes.txt";
        String rutaListado = "recursos/listadoAlumnos.txt";
        
        // Variables de salida
        String rutaActa =  "recursos/acta.txt";

        // Variables auxiliares
        String cadena, nombre, dni, notaActa;
        double coefTeoria=0, coefPractica=0,aprobado=0,notable=0,
                sobresaliente=0, notaTeoria, notaPractica, notaFinal;
        String[] cadenaSeparada;
   
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("Abriendo el archivo de coeficientes...");
        
        // Aqu� tenemos la estructura try-with-resources. De esta forma, nos ahorramos tener que 
        // cerrar los flujos de manera expl�cita con la sentencia close()
        try ( 
            // Aqu� envolvemos el FileReader en un BufferedReader para poder utilizar el m�todo readLine.
            BufferedReader brCoef = new BufferedReader(new FileReader(rutaCoeficientes));){
            cadena = brCoef.readLine();
            
            cadenaSeparada = cadena.split(";");
            coefTeoria=Double.parseDouble(cadenaSeparada[0]);
            coefPractica=Double.parseDouble(cadenaSeparada[1]);
            aprobado=Double.parseDouble(cadenaSeparada[2]);
            notable=Double.parseDouble(cadenaSeparada[3]);
            sobresaliente=Double.parseDouble(cadenaSeparada[4]);
   
        }catch (FileNotFoundException e) {
            System.out.println("Error: archivo�no encontrado.");
        } catch(IOException e){
            System.err.printf("Error de entrada/salida: %s\n",e.getMessage());
        }
        System.out.println("Cerrando el archivo de coeficientes...");
        
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        System.out.println("Abriendo los archivos con los alumnos y el acta...");
        try ( 
            BufferedReader brListado = new BufferedReader(new FileReader(rutaListado));
            // Aqu� envolvemos el FileWriter en un PrintWriter para poder utilizar el m�todo printf
            PrintWriter pwActa = new PrintWriter(new FileWriter(rutaActa));){
            pwActa.printf(" %-30s \t %-10s \t %-10s \t %-10s \t %-10s\t %-10s\n",
                    "Nombre y apellidos","DNI","Nota teor�a","Nota pr�ct.",
                    "Nota final","Nota acta");
            
            while((cadena = brListado.readLine()) != null){
                cadenaSeparada = cadena.split(";");
                nombre = cadenaSeparada[0];
                dni = cadenaSeparada[1];
                notaTeoria = Double.parseDouble(cadenaSeparada[2]);
                notaPractica = Double.parseDouble(cadenaSeparada[3]);
               
                notaFinal = Ejercicio1.calcularNotaFinal(notaTeoria,notaPractica,coefTeoria, coefPractica);
                notaActa=Ejercicio1.calcularNotaActa(notaFinal,aprobado,notable,sobresaliente);
                pwActa.printf(" %-30s \t %-10s \t %-10.2f \t %-10.2f \t %-10.2f\t %-10s\n",nombre,dni,notaTeoria,notaPractica,notaFinal,notaActa);
            }
            
        }catch (FileNotFoundException e) {
            System.out.println("Error: archivo " + rutaListado + "�no encontrado.");
        } catch(IOException e){
            System.err.printf("Error de entrada/salida: %s\n",e.getMessage());
        }
        System.out.println("Cerrando los archivos con los alumnos y el acta..." );
        
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        
        System.out.println ();
	System.out.println ("Archivos cerrados y procesamento finalizado");
	System.out.println ("---------");
        
        
        System.out.println ();
	System.out.println ("Fin del programa.");
    }
    
    /**
     * 
     * @param notaT Nota de teor�a que ha obtenido el alumno.
     * @param notaP Nota de las pr�cicas del alumno.
     * @param cT Coeficiente de lo que punt�a la teor�a.
     * @param cP Coeficiente de lo que punt�an las pr�cticas.
     * @return Nota final del alumno.
     */
    public  static double calcularNotaFinal(double notaT, double notaP, double cT, double cP){
        return (notaT*cT)/100 + (notaP*cP)/100;
    }
    
    /**
     * 
     * @param nota Nota final de un alumno.
     * @param aprobado Valor umbral entre el suspenso y el aprobado.
     * @param notable Valor umbral entre el aprobado y el notable.
     * @param sobresaliente Valor umbral entre el notable y el sobresaliente.
     * @return Nota del acta (Suspenso, Aprobado, Notable o Sobresaliente).
     */
    public static String calcularNotaActa(double nota, double aprobado, double notable, double sobresaliente){
    String resultado;
        if(nota<aprobado)
            resultado="Suspenso";
        else if(nota<notable)
            resultado="Aprobado";
        else if(nota<sobresaliente)
            resultado= "Notable";
        else
            resultado= "Sobresaliente";
        return resultado;               
    }
}
