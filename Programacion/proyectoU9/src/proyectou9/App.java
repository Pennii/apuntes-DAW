/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectou9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Scanner;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
    private static final String URL = "jdbc:mysql://localhost:3306/proyU9";
    private static final String USUARIO = "penni";
    private static final String PASSWORD = "";
    //driver de mysql
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    //ruta al script con las tablas
    private static final String ESTRUCTURA = "/recursos/tablas.sql";

    /**
     * ejecuta todo el script de estructura y devolvera un resultado booleano si
     * se ejecuto correctamente
     *
     * @param con conexion a utilizar
     * @return verdadero si se creo correctamente, falso si no lo hizo
     */
    public static boolean crearTabla(Connection con) {
        boolean creada = false;

        try (Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM CLIENTE");
            rs.next();
//            if (!(rs.getInt("COUNT(*)") > 0)) {
                String sql = cargarRecurso(ESTRUCTURA);
                if (sql != null) {
                    /*
                El script deberia cargarse de forma completa al momento, pero
                da error al pasar de una sentencia a otra. La solucion que 
                encontre fue dividir la cadena en un array separado por ; para
                ejecutar cada sentencia una por una
                     */
                    String sqlDiv[] = sql.split(";");
                    for (int i = 0; i < sqlDiv.length; i++) {
                        st.execute(sqlDiv[i]);
                    }
                    creada = true;
                } else {
                    System.out.println("Problemas al cargar el script");
                }
            

        } catch (SQLException ex) {
            System.out.println(ex);;
        }

        return creada;
    }

    /**
     * pasada la ruta del recurso, carga su contenido como stream. el recurso es
     * pasado como InputStream gracias al getResourceAsStream, y si no es nulo
     * su contenido sera leido por lines, y luego almacenado como String gracias
     * al collect
     *
     * @param ruta donde se guarda el recurso a usar
     * @return el contenido del recurso como String
     */
    public static String cargarRecurso(String ruta) {
        InputStream is = App.class.getResourceAsStream(ruta);
        String recurso = null;
        if (is != null) {
            try (InputStreamReader isr = new InputStreamReader(is); BufferedReader bfr = new BufferedReader(isr)) {
                recurso = bfr.lines().collect(Collectors.joining("\n"));
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
        return recurso;
    }

    /**
     * elimina un producto de la tabla
     *
     * @param con conexion a usar
     * @param codigo codigo del producto a eliminar
     */
    public static void eliminarProducto(Connection con, String codigo) {
        String query = "DELETE FROM producto WHERE codigo = ?";

        if (con != null) {
            try (PreparedStatement consulta = con.prepareStatement(query)) {
                consulta.setString(1, codigo);

                int registrosAfectados = consulta.executeUpdate();
                if (registrosAfectados > 0) {
                    System.out.println("Producto eliminado");
                } else {
                    System.out.println("No se ha podido realizar la consulta");
                }
            } catch (SQLException ex) {
                System.out.println("Error al ejecutar consulta:\n\t" + ex);
            }
        }
    }

    /**
     * metodo que muestra todos los productos en la bd
     *
     * @param con conexion a la bd
     */
    public static void mostrarProductos(Connection con) {
        if (con != null) {
            try (Statement consulta = con.createStatement()) {
                String query = "SELECT codigo,nombre,unidades  FROM producto";
                ResultSet resultado;
                resultado = consulta.executeQuery(query);

                System.out.printf("%-8s%-10s%s\n", "CODIGO", "NOMBRE", "UNIDADES");
                while (resultado.next()) {
                    String codigo = resultado.getString("codigo");
                    String nombre = resultado.getString("nombre");
                    int unidades = resultado.getInt("unidades");

                    System.out.printf("%-8s%-10s%d\n", codigo, nombre, unidades);
                }
            } catch (SQLException ex) {
                System.out.println("Error al mostrar productos:\n\t" + ex);
            }
        }
    }

    /**
     * metodo que crea un producto en la bd
     *
     * @param codigo codigo del producto
     * @param nombre nombre del producto
     * @param unidades unidades del producto
     */
    public static void crearProducto(String codigo, String nombre, int unidades) {
        Scanner teclado = new Scanner(System.in);
        boolean correcto;
        System.out.println("id del proveedor");
        String id = teclado.nextLine();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("proyectoU9PU");
        EntityManager em = emf.createEntityManager();
        while (!Proveedor.idExiste(id, em)) {
            System.out.println("Error de id");
            id = teclado.nextLine();
        }
        //actualiza correctamente la lista?
        Proveedor prov = Proveedor.copia(em, id);
        Producto p = new Producto(codigo, nombre, unidades, prov);
        prov.getProds().add(p);

    }

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
                //SE CARGAN LAS TABLAS DEL SCRIPT
                crearTabla(con);
                mostrarProductos(con);
            } catch (SQLException ex) {
                System.out.println("no se encontro la bd " + ex);
            }
        }

    }
}
