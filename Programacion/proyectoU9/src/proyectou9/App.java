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
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
            // se comprueba si las tablas y sus valores ya estan cargados
            ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM CLIENTE");
            rs.next();
            //si el conteo es mayor a 0 significa que ya lo estan
            if (!(rs.getInt("COUNT(*)") > 0)) {

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
            }

        } catch (SQLException ex) {
            System.out.println(ex);
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
     * elimina una entidad de la tabla. Cada una tiene asignado un numero en su
     * menu, en funcion de ese numero se le asigna un query y se elimina
     * buscando por su clave primaria
     *
     * @param con conexion a usar
     * @param ent valor de entidad asignado a cada entidad en su menu
     * @param clav clave primaria de la entidad
     * @return verdadero si la entidad se borro, falso si no
     */
    public static boolean eliminar(Connection con, int ent, String clav) {
        boolean borrado = false;
        String query = null;
        String clave = clav;
        switch (ent) {
            case 1:
                query = "DELETE FROM PROVEEDOR WHERE ID = ?";
                break;
            case 2:
                query = "DELETE FROM CLIENTE WHERE CODIGO = ?";
                break;
            case 3:
                query = "DELETE FROM REPARTIDOR WHERE CODIGO = ?";
                break;
            case 4:
                query = "DELETE FROM PRODUCTO WHERE CODIGO = ?";
                break;
            default:
                query = null;
        }

        try (PreparedStatement consulta = con.prepareStatement(query)) {
            consulta.setString(1, clave);

            int registrosAfectados = consulta.executeUpdate();
            borrado = registrosAfectados > 0;
        } catch (SQLException ex) {
            System.out.println("Error al ejecutar consulta:\n\t" + ex);

        }
        return borrado;
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
     * metodo que muestra todos los proveedores en la bd
     *
     * @param con conexion a la bd
     */
    public static void mostrarProveedores(Connection con) {
        if (con != null) {
            try (Statement consulta = con.createStatement()) {
                String query = "SELECT id,nombre  FROM proveedor";
                ResultSet resultado;
                resultado = consulta.executeQuery(query);

                System.out.printf("%-8s%-10s\n", "ID", "NOMBRE");
                while (resultado.next()) {
                    String codigo = resultado.getString("id");
                    String nombre = resultado.getString("nombre");

                    System.out.printf("%-8s%-10s\n", codigo, nombre);
                }
            } catch (SQLException ex) {
                System.out.println("Error al mostrar proveedores:\n\t" + ex);
            }
        }
    }

    /**
     * metodo que muestra todos los clientes en la bd
     *
     * @param con conexion a la bd
     */
    public static void mostrarClientes(Connection con) {
        if (con != null) {
            try (Statement consulta = con.createStatement()) {
                String query = "SELECT codigo,nombre,edad  FROM cliente";
                ResultSet resultado;
                resultado = consulta.executeQuery(query);

                System.out.printf("%-8s%-10s%s\n", "CODIGO", "NOMBRE", "EDAD");
                while (resultado.next()) {
                    String codigo = resultado.getString("codigo");
                    String nombre = resultado.getString("nombre");
                    int edad = resultado.getInt("edad");

                    System.out.printf("%-8s%-10s%d\n", codigo, nombre, edad);
                }
            } catch (SQLException ex) {
                System.out.println("Error al mostrar productos:\n\t" + ex);
            }
        }
    }

    /**
     * metodo que muestra todos los repartidores en la bd
     *
     * @param con conexion a la bd
     */
    public static void mostrarRepartidores(Connection con) {
        if (con != null) {
            try (Statement consulta = con.createStatement()) {
                String query = "SELECT codigo,nombre,vehiculo  FROM repartidor";
                ResultSet resultado;
                resultado = consulta.executeQuery(query);

                System.out.printf("%-8s%-10s%s\n", "CODIGO", "NOMBRE", "VEHICULO");
                while (resultado.next()) {
                    String codigo = resultado.getString("codigo");
                    String nombre = resultado.getString("nombre");
                    String vehiculo = resultado.getString("vehiculo");

                    System.out.printf("%-8s%-10s%s\n", codigo, nombre, vehiculo);
                }
            } catch (SQLException ex) {
                System.out.println("Error al mostrar productos:\n\t" + ex);
            }
        }
    }

    /**
     * metodo que muestra todos los pedidos en la bd
     *
     * @param con conexion a la bd
     */
    public static void mostrarPedidos(Connection con) {
        if (con != null) {
            try (Statement consulta = con.createStatement()) {
                String query = "SELECT prod,clien,fecha  FROM pedido";
                ResultSet resultado;
                resultado = consulta.executeQuery(query);

                System.out.printf("%-10s%-10s%s\n", "PRODUCTO", "CLIENTE", "FECHA");
                while (resultado.next()) {
                    String producto = resultado.getString("prod");
                    String cliente = resultado.getString("clien");
                    String fecha = resultado.getString("fecha");

                    System.out.printf("%-10s%-10s%s\n", producto, cliente, fecha);
                }
            } catch (SQLException ex) {
                System.out.println("Error al mostrar productos:\n\t" + ex);
            }
        }
    }

    /**
     * metodo que muestra todos los repartos en la bd
     *
     * @param con conexion a la bd
     */
    public static void mostrarRepartos(Connection con) {
        if (con != null) {
            try (Statement consulta = con.createStatement()) {
                String query = "SELECT repartidor,producto,fecha  FROM reparto";
                ResultSet resultado;
                resultado = consulta.executeQuery(query);

                System.out.printf("%-12s%-10s%s\n", "REPARTIDOR", "PRODUCTO", "FECHA");
                while (resultado.next()) {
                    String rep = resultado.getString("repartidor");
                    String prod = resultado.getString("producto");
                    String fec = resultado.getString("fecha");

                    System.out.printf("%-12s%-10s%s\n", rep, prod, fec);
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

                menu(con);
            } catch (SQLException ex) {
                System.out.println("no se encontro la bd " + ex);
            }
        }

    }

    /**
     * menu principal donde se accedera a los submenu de cada entidad
     */
    private static void menu(Connection con) {
        Scanner teclado = new Scanner(System.in);
        int op;
        boolean valido = false;
        System.out.println("BIENVENIDO AL MENU PRINCIPAL");
        System.out.println("¿QUE DESEAS HACER?");
        System.out.println("1.Proveedores 2.Clientes 3.Repartidores 4.Productos 5.Terminar");
        do {
            try {
                op = teclado.nextInt();
                valido = true;
                switch (op) {
                    case 1:
                        menuProv(con);
                        break;
                    case 2:
                        menuClien(con);
                        break;
                    case 3:
                        menuRep(con);
                        break;
                    case 4:

                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("Operacion invalida, ingresa una opcion"
                                + " correcta");
                        valido = false;
                }
            } catch (InputMismatchException ex) {
                System.out.println("Error al ingresar operacion, por favor "
                        + "ingresa una opcion valida");
                teclado.nextLine();
            }

        } while (!valido);
    }

    /**
     * menu de operaciones para proveedor
     *
     * @param con conexion de la base de datos
     */
    private static void menuProv(Connection con) {
        int ent = 1;
        Scanner teclado = new Scanner(System.in);
        int op;
        boolean valido = false, volver = false;
        String id, nom;
        System.out.println("BIENVENIDO AL MENU DE PROVEEDORES");
        System.out.println("¿QUE DESEAS HACER?");
        System.out.println("1.Ver los proveedores 2.Agregar proveedor 3.Borrar proveedor 4.Volver");
        do {
            try {
                op = teclado.nextInt();
                valido = true;
                teclado.nextLine();
                switch (op) {
                    case 1:
                        mostrarProveedores(con);
                        break;
                    case 2:
                        System.out.println("Ingresa el id y el nombre del proveedor:");
                        id = teclado.nextLine();
                        nom = teclado.nextLine();
                        Proveedor p = null;
                        p = new Proveedor(id, nom);
                        if (p.getId() != null) {
                            System.out.println("Proveedor agregado con exito");
                        }
                        break;
                    case 3:
                        System.out.println("Ingresa el id del proveedor a eliminar");
                        id = teclado.nextLine();
                        if (eliminar(con, ent, id)) {
                            System.out.println("Proveedor eliminado");
                        } else {
                            System.out.println("Error al eliminar proveedor");
                        }
                        break;
                    case 4:
                        volver = true;
                        menu(con);
                        break;
                    default:
                        System.out.println("Operacion invalida, ingresa una opcion"
                                + " correcta");
                        valido = false;
                }
                if (!volver) {
                    System.out.println("1.Continuar operaciones 2.Menu principal");
                    boolean correcto = false;
                    while (!correcto) {
                        op = teclado.nextInt();
                        switch (op) {
                            case 1:
                                menuProv(con);
                                correcto = true;
                                break;
                            case 2:
                                menu(con);
                                correcto = true;
                                break;
                            default:
                                System.out.println("op invalida");
                        }
                    }
                }

            } catch (InputMismatchException ex) {
                System.out.println("Error al ingresar operacion, por favor "
                        + "ingresa una opcion valida");
                teclado.nextLine();
            }

        } while (!valido);
    }

    /**
     * menu de operaciones de clientes
     *
     * @param con conexion a la bd
     */
    private static void menuClien(Connection con) {
        int ent = 2;
        Scanner teclado = new Scanner(System.in);
        int op, edad;
        boolean valido = false, volver = false;
        String codigo, nombre;
        System.out.println("BIENVENIDO AL MENU DE CLIENTES");
        System.out.println("¿QUE DESEAS HACER?");
        System.out.println("1.Ver clientes 2.Agregar cliente 3.Borrar cliente 4.Volver");
        do {
            try {
                op = teclado.nextInt();
                teclado.nextLine();
                valido = true;
                switch (op) {
                    case 1:
                        mostrarClientes(con);
                        break;
                    case 2:
                        System.out.println("Ingresa el codigo, nombre y edad del cliente:");
                        codigo = teclado.nextLine();
                        nombre = teclado.nextLine();
                        edad = teclado.nextInt();
                        Cliente c = null;
                        c = new Cliente(codigo, nombre, edad);
                        if (c.getCodigo() != null) {
                            System.out.println("Cliente agregado con exito");
                        }
                        break;
                    case 3:
                        System.out.println("Ingresa el codigo del cliente a eliminar:");
                        codigo = teclado.nextLine();
                        if (eliminar(con, ent, codigo)) {
                            System.out.println("Cliente eliminado");
                        } else {
                            System.out.println("No se pudo eliminar al cliente");
                        }
                        break;
                    case 4:
                        menu(con);
                        volver = true;
                        break;
                    default:
                        System.out.println("Operacion invalida, ingresa una opcion"
                                + " correcta");
                        valido = false;
                }
                if (!volver) {
                    System.out.println("1.Continuar operaciones 2.Menu principal");
                    boolean correcto = false;
                    while (!correcto) {
                        op = teclado.nextInt();
                        switch (op) {
                            case 1:
                                menuClien(con);
                                correcto = true;
                                break;
                            case 2:
                                menu(con);
                                correcto = true;
                                break;
                            default:
                                System.out.println("op invalida");
                        }
                    }
                }
            } catch (InputMismatchException ex) {
                System.out.println("Error al ingresar operacion, por favor "
                        + "ingresa una opcion valida");
                teclado.nextLine();
            }
        } while (!valido);
    }

    private static void menuRep(Connection con) {
        int ent = 3;
        Scanner teclado = new Scanner(System.in);
        int op;
        boolean valido = false, volver = false;
        String codigo, nombre, vehiculo;
        System.out.println("BIENVENIDO AL MENU DE REPARTIDORES");
        System.out.println("¿QUE DESEAS HACER?");
        System.out.println("1.Ver repartidores 2.Agregar repartidor 3.Borrar "
                + "repartidor 4.Ver historial de entregas 5.Volver");
        do {
            try {
                op = teclado.nextInt();
                teclado.nextLine();
                valido = true;
                switch (op) {
                    case 1:
                        mostrarRepartidores(con);
                        break;
                    case 2:
                        System.out.println("Ingresa el codigo, nombre y vehiculo del repartidor:");
                        codigo = teclado.nextLine();
                        nombre = teclado.nextLine();
                        vehiculo = teclado.nextLine();
                        Repartidor r = null;
                        r = new Repartidor(codigo, nombre, vehiculo);
                        if (r.getCodigo() != null) {
                            System.out.println("Repartidor agregado con exito");
                        }
                        break;
                    case 3:
                        System.out.println("Ingresa el codigo del repartidor a eliminar:");
                        codigo = teclado.nextLine();
                        if (eliminar(con, ent, codigo)) {
                            System.out.println("Repartidor eliminado");
                        } else {
                            System.out.println("No se pudo eliminar al repartidor");
                        }
                        break;
                    case 4:
                        mostrarRepartos(con);
                        break;
                    case 5:
                        menu(con);
                        volver = true;
                        break;
                    default:
                        System.out.println("Operacion invalida, ingresa una opcion"
                                + " correcta");
                        valido = false;
                }
                if (!volver) {
                    System.out.println("1.Continuar operaciones 2.Menu principal");
                    boolean correcto = false;
                    while (!correcto) {
                        op = teclado.nextInt();
                        switch (op) {
                            case 1:
                                menuRep(con);
                                correcto = true;
                                break;
                            case 2:
                                menu(con);
                                correcto = true;
                                break;
                            default:
                                System.out.println("op invalida");
                        }
                    }
                }
            } catch (InputMismatchException ex) {
                System.out.println("Error al ingresar operacion, por favor "
                        + "ingresa una opcion valida");
                teclado.nextLine();
            }
        } while (!valido);
    }
}
