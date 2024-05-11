package ejemplo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.h2.tools.Server;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.stream.Collectors;

/*
  JDBC es una API Java que permite acceder a bases de datos relacionales cuando programamos con Java,
  pudiendo así utilizar SQL:
  -- Consta de un conjunto de clases e interfaces escritas en Java.
  -- Con JDBC, siempre usarás las mismas clases y métodos para almacenar datos en la BD, independientemente
     de la base de datos.

  La API JDBC viene distribuida en dos paquetes:
  -- java.sql, contiene las clases e interfaces principales de la API.
  -- javax.sql, contiene clases que complementan a las incluidas en java.sql.

  Para conectarnos a una base de datos específica, JDBC necesita un conector o driver adicional, que es un
  conjunto de clases que implementan las interfaces de la API JDBC necesarias para conectar a una BD específica.
  El conector es implementado por el fabricante del SGBD y consta de una o más librerías java (archivos .jar) 
  que debemos incorporar a nuestro proyecto.
  Por tanto, aunque el código de nuestra aplicación no depende del driver o conector, puesto que trabajaremos directamente
  con las paquetes java.sql y javax.sql, para ejecutar nuestra aplicación y que ésta pueda conectarse y usar la BD,
  sí que vamos a necesitar el conector que nos proporcionará el fabricante.

  1.- ¿QUÉ ES LO PRIMERO QUE TENEMOS QUE HACER PARA PODER REALIZAR CONSULTAS EN UNA BASE DE DATOS?
  LÓGICAMENTE, INSTALAR LA BASE DE DATOS.

  Por ahora, nosotros vamos a trabajar con H2. Se trata de una base de datos relacional que no necesita instalación.
  LO ÚNICO QUE HAY QUE HACER PARA UTILIZAR H2 ES AÑADIR A NUESTRO PROYECTO LA LIBRERÍA H2 (ARCHIVO .jar).
  H2 es software libre y es una BD ligera muy usada en la fase de desarrollo. 

  2. - ESTABLECIMIENTO DE CONEXIONES:
  Cuando queremos acceder a una BD para operar con ella, necesitamos que el conector JDBC esté configurado
  en nuestro proyecto a dos niveles:
  -- En un primer nivel es necesario añadir el conector JDBC (la librería .jar) en nuestro proyecto. H2 LO 
     LLEVA TODO INCLUIDO EN EL ARCHIVO .JAR (no tenemos que añadir el conector JDBC).
  -- En un segundo nivel, si estamos trabajando con una versión anterior a JDBC 4.0, es necesario registrar
     el conector JDBC antes de iniciar la conexión. 
     Aunque el proceso de registro del conector no es necesario en muchos casos, es una buena práctica por dos motivos:
         -- Por asegurar compatibilidad con versiones anteriores del JDK.
         -- Si al ejecutar la aplicación en el cliente no se encuentra el conector, podremos mostrar por pantalla 
            un mensaje amigable y evitar así una incómoda excepción.

*/


public class Aplicacion {
    
    /**
     * Nombre de la base de datos con la que queremos conectar. 
     */
    private static final String DB_NAME = "prueba1.h2db";
    
    /**
     * URL de JDBC que identifica a la base de datos con la que queremos realizar la conexión:
     * - jdbc indica que se trata de una URL que contiene la información para conectar usando JDBC
     * - h2 indica que se trata de una conexión a una base de datos H2
     * - nombre de la base de datos con la que queremos conectar. ES NECESARIO PONER LA RUTA COMPLETA
     * HASTA EL ARCHIVO. Si quieres crear una nueva, simplemente pon un nombre de base de datos que no 
     * exita. En este caso, la BD se va a crear en el directorio de trabajo.
     */
    private static final String CONNECTION_URL = "jdbc:h2:./" + DB_NAME;
    
    
    /**
     * Driver a utilizar para conectarse a la base de datos H2.
     * org.h2.Driver es la clase que implementa la interfaz java.sql.Driver definida por JDBC,
     * y que es la interfaz que todo conector debe implementar. Dicha clase se encuentra obviamente
     * dentro de la librería .jar del conector JDBC. Y en el caso de H2, dentro de la librería
     * h2-1.4.200.jar 
     */
    private static final String DRIVER = "org.h2.Driver";
    
    /**
     * Opciones de conexión:
     * - MODE, para decirle a H2 que desea imitar una base de datos en particular (MySQL)
     * - AUTO_RECONNECT, la función de reconexión automática hace que el controlador JDBC
     * se vuelva a conectar a la base de datos si se pierde la conexión.
     */
    private static final String CU_PARAMS = ";MODE=MySQL;AUTO_RECONNECT=TRUE";
    
    /**
     * Path al archivo que contiene la estructura de la base de datos.
     */
    public final static String ESTRUCTURA_DB="/resources/estructuradb.sql";  
    
    
    /**
     * Método principal de la aplicación. En él se realiza la preparación
     * del entorno antes de empezar. A destacar:
     * 
     * - Se carga el driver (Class.forName).
     * - Se establece una conexión con la base de datos (DriverManager.getConnection)
     * - Se crean las tablas, si no están creadas, invocando el método createTables.
     * - Se ejecuta una consulta de prueba
     * 
     * @param args 
     */
     public static void main(String[] args) {  
         
        /*
          REGISTRAR EL CONECTOR JDBC:
          Solo tienes que registrar el conector si vas a usar un JDK anterior a 1.6.
          Versiones como JDK 1.7, JDK 8 y posteriores, no necesitan registrar el conector,
          pero se considera una buena práctica hacerlo por dos motivos:
          1.- por asegurar compatibilidad con versiones anteriores del JDK
          2.- para controlar situaciones de error mostrando por pantalla un mensaje amigable
         */
        boolean driverCargado=false;
        
        try {
            Class.forName(DRIVER) ; 
            driverCargado=true;
        } catch (ClassNotFoundException e) {
            System.err.printf("No se encuentra el driver de la base de datos (%s)\n", DRIVER);
        }
         
        
        /* Para establecer una conexión con una BD, debemos utilizar el método getConnection() de la clase DriverManager.
           Este método recibe como parámetro la URL de JDBC que identifica a la BD con la que queremos realizar la conexión.
           La ejecución de este método devuelve un objeto Connection que representa la conexión con la base de datos. 
           NO DEBEMOS OLVIDAR CERRAR LA CONEXIÓN CUANDO YA NO SEA NECESARIA (recuerda las ventajas de utilizar try-with-resources)
        */
        if (driverCargado) {
                
            /*
              Lista de argumentos que le pasamos createWebServer para crear un nuevo servidor web.
              - browser : inicia un navegador conectándose al servidor web
              - baseDir: el directorio base para bases de datos H2
            */
            String[] wsArgs={"-baseDir",System.getProperty("user.dir"),"-browser"};
            
            // Establecemos la conexión con la base de datos. Necesitamos:
            // - URL de conexión, junto con las opciones de conexión
            // - El usuario y el password para acceder a la base de datos 
            try (Connection con = DriverManager.getConnection(CONNECTION_URL+CU_PARAMS,"","")) {
                
                // Iniciamos el servidor web (para H2)
                Server sr=Server.createWebServer(wsArgs);                              
                sr.start();
                
                System.out.println("¡¡Atención!!");                
                System.out.println();
                System.out.println("Mientras tu aplicación se esté ejecutando \n"
                        + "puedes acceder a la consola de la base de datos \n"
                        + "a través del navegador web.");    
                System.out.println();
                System.out.println("Página local: " + sr.getURL());     
                System.out.println();
                System.out.println("Datos de acceso");                
                System.out.println("---------------");
                System.out.println("Controlador: " + DRIVER);
                System.out.println("URL JDBC: "+CONNECTION_URL);
                System.out.println("Usuario: (no indicar nada)");                
                System.out.println("Password: (no indicar nada)");                
                
                
                /*
                  JDBC proporciona tres modelos de sentencias:
                  1.- Statement: para lanzar consultas sencillas en SQL.
                  2.- PreparedStatement: para lanzar consultas que tienen parámetros.
                  3.- CallableStatement: para lanzar la ejecución de procedimientos almacenados en la BD.
                
                  Además, JDBC distingue dos tipos de consultas:
                  1.- Consultas que permiten obtener datos almacenados (SELECT). Se emplea el método
                  ResultSet executeQuery(String sql), que devuelve los datos resultantes de la ejecución de la consulta.
                  2.- Consultas que permiten cambiar los datos almacenados (INSERT, UPDATE,DELETE). Se emplea
                  el método int executeUpdate(String sql), que devuelve el número de filas afectadas.
                
                */
                // Creamos las tablas y algunos datos de prueba si no existen                
                if (createTables(con)) {
                 
                    //Ejecutamos una consulta de prueba
                    try ( Statement consulta = con.createStatement()) {
                        if (consulta.execute("SELECT id,nombre,precio FROM producto")) {
                            ResultSet resultados = consulta.getResultSet();
                            while (resultados.next()) {
                                long id = resultados.getLong("id");
                                String nombre = resultados.getString("nombre");
                                double precio = resultados.getDouble("precio");
                                System.out.printf("%5d %-15s %10.2f\n", id, nombre, precio);
                            }
                        }
                    } catch (SQLException ex) {
                        System.err.printf("Se ha producio un error al ejecutar la consulta SQL.");
                    }

                    bloquearHastaPulsarTecla();
                    
                    System.out.println("Realizamos la inserción de un nuevo producto.");
                    nuevoProducto(con,"Producto 11", "91584881370381", 3.1234567);
                    
                    bloquearHastaPulsarTecla();
                    
                    System.out.println("Realizamos la inserción de un nuevo ticket.");
                    nuevoTicket(con);
                    
                    bloquearHastaPulsarTecla();
                    
                    System.out.println("Mostrar productos por encima de un precio mínimo.");
                    mostrarProductosPrecioMinimo (con, 5.0);
                    bloquearHastaPulsarTecla();
                    
                    System.out.println("Mostrar tickets no cerrados.");
                    mostrarTicketsNoCerrados (con);
                    bloquearHastaPulsarTecla();
                    
                    System.out.println("Actualizar precio de un producto.");
                    actualizarPrecioProducto (con,1, 100.0);
                    bloquearHastaPulsarTecla();
                    
                    System.out.println("Cerrar un ticket dado su id.");
                    cerrarTicket (con,1);
                    bloquearHastaPulsarTecla();
                    
                    System.out.println("Borrar un ticket dado su id.");
                    borrarProducto(con, 1);
                    bloquearHastaPulsarTecla();
                    
                    
                } else {
                    System.err.println("Problema creando las tablas.");

                }                                                        
                
                sr.stop();
                sr.shutdown();
            } catch (SQLException ex) {
                System.err.printf("No se pudo conectar a la base de datos (%s)\n", DB_NAME);
            }   
        }

    }
    
    /**
     * Dada una conexión válida, lleva a cabo la creación de la estructura
     * de la base de datos, usando SQL, para la creación del contenido 
     * especificado en la constante ESTRUCTURA_DB
     * @param con conexión a la base de datos.
     * @see ESTRUCTURA_DB
     * @return true si se creo la estructura y false en caso contrario. 
     * 
     */
    public static boolean createTables (Connection con) {
        boolean ok = false ;            
        
        try (Statement st=con.createStatement())  {                   
            String sqlScript=loadResourceAsString(ESTRUCTURA_DB);
            if (sqlScript!=null) {
                st.execute(sqlScript);                  
                ok = true;
            } else {
                System.out.printf("Problema cargando el archivo: %s \n",ESTRUCTURA_DB);
            }            
        } catch (SQLException ex) {
            System.err.printf("Problema creando la estructura de la base de datos.\n");
        }
        return ok;        
    }        
    
    /**
      * Carga un recurso que estará dentro del JAR como cadena de texto.
      * @param resourceName Nombre del recurso dentro del JAR.
      * @return Cadena que contiene el contenido del archivo.
      * 
      * getResoruceAsStream --> encuentra un recurso con un nombre determinado
      * y devuelve un objeto InputStream
      * InputStream --> flujo de entrada de bytes
      * InputStreamReader --> lee bytes y los decodifica en caracteres
      * lines() --> devuelve un Stream cuyos elementos son líneas leídas del BufferedReader
      * collect() --> une todas las líneas en un único String usando como delimitador \n
      */
    public static String loadResourceAsString(String resourceName) {
        String resource = null;
        InputStream is = Aplicacion.class.getResourceAsStream(resourceName);
        if (is != null) {
            try (InputStreamReader isr = new InputStreamReader(is);  
                    BufferedReader br = new BufferedReader(isr);) {
                resource = br.lines().collect(Collectors.joining("\n"));
            } catch (IOException ex) {
                System.err.printf("Problema leyendo el recurso como cadena: %S\n ", resourceName);
            }
        }
        return resource;
    }
    
    private static void bloquearHastaPulsarTecla() {
        System.out.println("Antes de terminar, puedes acceder a la consola de H2 para ver"
                + " y modificar la base de datos. Pulsa cualquier tecla para salir.");
        try {
            System.in.read();
        } catch (IOException e) {
        }
    }
    
    
    
    public static void nuevoProducto(Connection con, String nombre, String barcode, double precio) {
        
        //Una PreparedStatement necesita una consulta SQL que tenga parámetros, los parámetros se indican con '?'        
        String query = "INSERT INTO producto (nombre, barcode, precio) VALUES (?,?,?)";
        /*
          La consulta anterior tiene 3 parámetros, y cada parámetro es accesible por la posición que ocupa en la consulta,
          empezando a numerar el primero en uno y así sucesivamente...Después, se pueden reemplazar cómodamente con una
          serie de métodos que proporciona la clase PreparedStatement:
          - setDouble, setInt, setString, setDate, setTime, etc.
        */
        if (con != null) {

            try ( PreparedStatement consulta = con.prepareStatement(query)) {

                consulta.setString(1, nombre);
                consulta.setString(2, barcode);
                consulta.setDouble(3, precio);

                int registrosAfectados = consulta.executeUpdate();
                if (registrosAfectados > 0) {
                    System.out.println("Producto insertado correctamente.");
                } else {
                    System.out.println("El producto no ha podido ser insertado.");
                }
            } catch (SQLException ex) {
                System.err.printf("Se ha producido un error al ejecutar la consulta SQL.");
            } 
        }
    }
    
    public static long nuevoTicket(Connection con) {
        String query = "INSERT INTO ticket (fecha, hora, ticketcerrado) VALUES (?,?,true)";
        long id=-1;
        if (con != null) {
            // En la tabla ticket, tenemos un identificador que se genera de forma automática.
            // Si queremos obtener el identificador asignado al registro recién insertado, podemos
            // hacerlo de la siguiente forma:
            try ( PreparedStatement consulta = con.prepareStatement(query,
                                      Statement.RETURN_GENERATED_KEYS)) {

                java.sql.Date fecha=java.sql.Date.valueOf(LocalDate.now());
                java.sql.Time hora=java.sql.Time.valueOf(LocalTime.now());
                consulta.setDate(1, fecha);
                consulta.setTime(2, hora);

                int registrosAfectados = consulta.executeUpdate();
                if (registrosAfectados>0)
                {
                    ResultSet m=consulta.getGeneratedKeys();
                    if (m.next())
                    {
                        id=m.getLong(1);
                        System.out.printf("Ticket creado con ID=%d\n",id);                        
                    }
                } else {
                    System.out.println("El ticket no ha podido ser creado.");
                }

            } catch (SQLException ex) {
                System.err.printf("Se ha producio un error al ejecutar la consulta SQL.");
            }
        }
        return id;
    }
    
    public static void mostrarProductosPrecioMinimo (Connection con, double precioMinimo)
    {
        String query="SELECT id,nombre,precio FROM producto WHERE precio>=?";
        if (con!=null) {
         try ( PreparedStatement consulta = con.prepareStatement(query)) {
                consulta.setDouble(1, precioMinimo);
                if (consulta.execute()) {
                    ResultSet resultados = consulta.getResultSet();
                    while (resultados.next()) {
                        long id = resultados.getLong("id");
                        String nombre = resultados.getString("nombre");
                        double precio = resultados.getDouble("precio");
                        System.out.printf("%5d %-15s %10.2f\n", id, nombre, precio);
                    }
                }
            } catch (SQLException ex) {
                System.err.printf("Se ha producido un error al ejecutar la consulta SQL.");
            }
        }
    }
    
    public static void mostrarTicketsNoCerrados (Connection con)
    {
        String query="SELECT id,fecha,hora FROM ticket WHERE TICKETCERRADO=false";
        if (con!=null) {
         try ( Statement consulta = con.createStatement()) {                
                    ResultSet resultados = consulta.executeQuery(query);                    
                    while (resultados.next()) {
                        long id = resultados.getLong("id");
                        LocalDate fecha = resultados.getDate("fecha").toLocalDate();
                        LocalTime hora = resultados.getTime("hora").toLocalTime();
                        System.out.printf("%5d %-15s %-15s\n", id, fecha.toString(), hora.toString());
                    }
            } catch (SQLException ex) {
                System.err.printf("Se ha producido un error al ejecutar la consulta SQL.");
            }
        }
    }
    
    public static void actualizarPrecioProducto(Connection con, long id,double precio) {
        String query = "UPDATE producto SET precio=? WHERE id=?;";
        if (con != null) {

            try ( PreparedStatement consulta = con.prepareStatement(query)) {

                consulta.setDouble(1, precio);
                consulta.setLong(2, id);

                int registrosAfectados = consulta.executeUpdate();
                if (registrosAfectados>0)
                {
                    System.out.println("El precio del producto se ha modificado." + precio);
                } else {
                    System.out.println("El precio del producto no se ha modificado, producto no encontrado.");
                }

            } catch (SQLException ex) {
                System.err.printf("Se ha producio un error al ejecutar la consulta SQL.");
            }
        }
    }
    
    public static void cerrarTicket(Connection con, long id) {
        String query = "UPDATE ticket SET ticketcerrado=true WHERE id=?";
        if (con != null) {

            try ( PreparedStatement consulta = con.prepareStatement(query)) {

                consulta.setLong(1, id);

                int registrosAfectados = consulta.executeUpdate();
                if (registrosAfectados>0)
                {
                    System.out.printf("El ticket con id %d ha sido cerrado.\n",id);                   
                } else {
                    System.out.printf("El ticket con id %d no ha podido ser cerrado, no existe.\n",id);
                }

            } catch (SQLException ex) {
                System.err.printf("Se ha producio un error al ejecutar la consulta SQL.\n");
            }
        }
    }
    
    public static void borrarProducto(Connection con, long id) {
        String queryDelete = "DELETE FROM producto WHERE id=?";
        if (con != null) {
            try ( PreparedStatement consultaDelete = con.prepareStatement(queryDelete)) {
                consultaDelete.setLong(1, id);
                int registrosAfectados = consultaDelete.executeUpdate();
                if (registrosAfectados > 0) {
                    System.out.println("El producto ha sido eliminado correctamente");
                } else {
                    System.out.println("El producto no ha sido eliminado, porque no existe.");
                }
            } catch (SQLException ex) {
                System.err.printf("Se ha producio un error al ejecutar la consulta SQL.");
            }
        }
    }
}
