/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectou9;


import java.sql.*;
//import java.sql.DriverManager;
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.sql.Statement;

/**
 *
 * @author matii
 */
public class App {

    //parametros para realizar la conexion
    private static final String URL = "jdbc:mysql://localhost:3306/proyectoU9";
    private static final String USUARIO = "penni";
    private static final String PASSWORD = "123";
    //driver de mysql
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String ESTRUCTURA = "/recursos/tablas.sql";

//    /**
//     * ejecuta todo el script de estructura y devolvera un resultado booleano si
//     * se ejecuto correctamente
//     *
//     * @param con conexion a utilizar
//     * @return verdadero si se creo correctamente, falso si no lo hizo
//     */
//    public static boolean crearTabla(Connection con) {
//        boolean creada = false;
//
//        try (Statement st = con.createStatement()) {
//            String sql = cargarRecurso(ESTRUCTURA);
//            if (sql != null) {
//                /*
//                El script deberia cargarse de forma completa al momento, pero
//                da error al pasar de una sentencia a otra. La solucion que 
//                encontre fue dividir la cadena en un array separado por ; para
//                ejecutar cada sentencia una por una
//                */
//                String sqlDiv[] = sql.split(";");
//                for (int i = 0; i < sqlDiv.length; i++) {
//                    st.execute(sqlDiv[i]);
//                    creada = true;
//                }
//
//            } else {
//                System.out.println("Problemas al cargar el script");
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return creada;
//    }
//
//    /**
//     * pasada la ruta del recurso, carga su contenido como stream. el recurso es
//     * pasado como InputStream gracias al getResourceAsStream, y si no es nulo
//     * su contenido sera leido por lines, y luego almacenado como String gracias
//     * al collect
//     *
//     * @param ruta donde se guarda el recurso a usar
//     * @return el contenido del recurso como String
//     */
//    public static String cargarRecurso(String ruta) {
//        InputStream is = App.class.getResourceAsStream(ruta);
//        String recurso = null;
//        if (is != null) {
//            try (InputStreamReader isr = new InputStreamReader(is); BufferedReader bfr = new BufferedReader(isr)) {
//                recurso = bfr.lines().collect(Collectors.joining("\n"));
//            } catch (IOException ex) {
//                System.out.println(ex);
//            }
//        }
//        return recurso;
//    }
//    /**
//     * agrega un producto en la tabla
//     *
//     * @param con conexion a usar
//     * @param codigo codigo de producto
//     * @param nombre nombre del producto
//     * @param cantidad unidades del producto
//     */
//    public static void nuevoProducto(Connection con, String codigo, String nombre, int cantidad) {
//
//        /*
//        Para ejecutar la sentencia usaremos un PreparedStatement, para ello
//        primero crearemos un String con la misma
//        */
//        String query = "INSERT INTO producto (codigo, nombre, unidades) VALUES (?,?,?)";
//        /*
//        se escribe la consulta sql pasando como valores ? por cada parametro,
//        a cada ? se le asignara un valor usando los metodos de PreparedStatement
//        - setDouble, setInt, setString, setDate, setTime, etc.
//         */
//        if (con != null) {
//
//            try (PreparedStatement consulta = con.prepareStatement(query)) {
//
//                consulta.setString(1, codigo);
//                consulta.setString(2, nombre);
//                consulta.setInt(3, cantidad);
//
//                int registrosAfectados = consulta.executeUpdate();
//                if (registrosAfectados > 0) {
//                    System.out.println("Producto insertado correctamente.");
//                } else {
//                    System.out.println("El producto no ha podido ser insertado.");
//                }
//            } catch (SQLException ex) {
//                System.out.println("Se ha producido un error al ejecutar la consulta SQL:\n\t"+ex);
//            }
//        }
//    }
//    /**
//     * elimina un producto de la tabla
//     * @param con conexion a usar
//     * @param codigo codigo del producto a eliminar
//     */
//    public static void eliminarProducto(Connection con, String codigo){
//        String query = "DELETE FROM producto WHERE codigo = ?";
//        
//        if (con != null){
//            try(PreparedStatement consulta = con.prepareStatement(query)){
//                consulta.setString(1, codigo);
//                
//                int registrosAfectados = consulta.executeUpdate();
//                if (registrosAfectados > 0) {
//                    System.out.println("Producto eliminado");
//                }else{
//                    System.out.println("No se ha podido realizar la consulta");
//                }
//            }
//            catch(SQLException ex){
//                System.out.println("Error al ejecutar consulta:\n\t"+ex);
//            }
//        }
//    }
//    
//    public static void mostrarProductos(Connection con){
//        if (con != null) {
//            try (Statement consulta = con.createStatement()){
//                String query = "SELECT codigo,nombre,unidades  FROM producto";
//                ResultSet resultado;
//                resultado = consulta.executeQuery(query);
//                
//                while(resultado.next()){
//                    String codigo = resultado.getString("codigo");
//                    String nombre = resultado.getString("nombre");
//                    int unidades = resultado.getInt("unidades");
//                    
//                    System.out.printf("%-5s%-10s%d\n",codigo,nombre,unidades);
//                }
//            }
//            catch(SQLException ex){
//                System.out.println("Error al mostrar productos:\n\t"+ex);
//            }
//        }
//    }
    public static void main(String[] args) {

        boolean driverCargado = false;

        //se carga el driver
        try {
            Class.forName(DRIVER).newInstance();
            driverCargado = true;
        } catch (ClassNotFoundException ex) {
            System.out.println("driver no cargado");
        } catch (IllegalAccessException ex) {
            System.out.println("driver no iniciado");
        } catch (InstantiationException ex) {
            System.out.println("driver no iniciado");
        }

        //si el driver se cargo correctamente se realiza la conexion
        if (driverCargado) {
            try (Connection con = DriverManager.getConnection(URL, USUARIO, PASSWORD)) {
                Proveedor p = new Proveedor("0011", "adrian");
            } catch (SQLException ex) {
                System.out.println("no se encontro la bd " + ex);
            }
        }

    }
}
