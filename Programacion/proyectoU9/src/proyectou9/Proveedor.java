/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectou9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Persistence;
import static proyectou9.App.crearTabla;

/**
 *
 * @author matii
 */
@Entity
public class Proveedor {

    @Id
    private String id;
    private String nombre;
    @OneToMany(mappedBy = "prov", orphanRemoval = true, cascade = CascadeType.PERSIST)
    private List<Producto> prods;

    /**
     * constructor de un proveedor. Se comprueba si el proveedor existe en la bd
     * para evitar que salte la excepcion
     *
     * @param id id del proveedor
     * @param nombre nombre del proveedor
     */
    public Proveedor(String id, String nombre) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("proyectoU9PU");
        EntityManager em = emf.createEntityManager();
        if (idExiste(id, em)) {
            System.out.println("El proveedor ya existe en la base de datos");
        } else {
            // por que me da un log?

            this.id = id;
            this.nombre = nombre;
            this.prods = new LinkedList<>();
            persistir(em, this);
        }
    }

    public String getId() {
        return id;
    }

    public Proveedor() {

    }

    /**
     * metodo que carga el objeto en la bd
     *
     * @param em controlador de entidad
     * @param p proveedor a cargar
     */
    public static void persistir(EntityManager em, Proveedor p) {
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.detach(p);
    }

    /**
     * metodo que determina si un proveedor existe en la bd
     *
     * @param id id a buscar
     * @param em controlador de entidad
     * @return verdadero si existe, falso si no
     */
    public static boolean idExiste(String id, EntityManager em) {
        boolean existe;
        Proveedor p = em.find(Proveedor.class, id);
        existe = p != null;
        return existe;
    }

    public static Proveedor copia(EntityManager em, String id) {
        em.getTransaction().begin();
        Proveedor p = em.find(Proveedor.class, id);
        return p;
    }

    public List<Producto> getProds() {
        return prods;
    }

    //parametros para realizar la conexion
    private static final String URL = "jdbc:mysql://localhost:3306/proyU9";
    private static final String USUARIO = "penni";
    private static final String PASSWORD = "";
    //driver de mysql
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    //ruta al script con las tablas
    private static final String ESTRUCTURA = "/recursos/tablas.sql";

    public static void main(String[] args) {

        InputStream is = App.class.getResourceAsStream(ESTRUCTURA);
        String recurso = null;
        if (is != null) {
            try (InputStreamReader isr = new InputStreamReader(is); BufferedReader bfr = new BufferedReader(isr)) {
                recurso = bfr.lines().collect(Collectors.joining("\n"));
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
        System.out.println(recurso);
        
    }
}
