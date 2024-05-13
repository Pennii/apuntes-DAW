/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectou9;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Persistence;

/**
 *
 * @author matii
 */
@Entity
public class Producto {

    @Id
    private String codigo;
    private String nombre;
    private int unidades;
    @ManyToOne(optional = false)
    private Proveedor prov;

    public Producto() {

    }

    /**
     * constructor de producto que verifica si el producto existe antes de
     * crearlo
     *
     * @param cod codigo de producto
     * @param nom nombre del producto
     * @param unidades stock del producto
     * @param prov proveedor del producto
     */
    public Producto(String cod, String nom, int unidades, Proveedor prov) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("proyectoU9PU");
        EntityManager em = emf.createEntityManager();
        if (prodExiste(cod, em)) {
            System.out.println("El producto ya existe en la base de datos");
        } else {
            this.codigo = cod;
            this.nombre = nom;
            this.prov = prov;
            this.unidades = unidades;
            persistir(em, this);
        }
    }

    /**
     * metodo que carga el objeto en la bd
     *
     * @param em controlador de entidad
     * @param p producto a cargar
     */
    public static void persistir(EntityManager em, Producto p) {
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.detach(p);
    }

    /**
     * metodo que determina si un proveedor existe en la bd
     *
     * @param cod codigo a buscar
     * @param em controlador de entidad
     * @return verdadero si existe, falso si no
     */
    public static boolean prodExiste(String cod, EntityManager em) {
        boolean existe;
        Producto p = em.find(Producto.class, cod);
        existe = p != null;
        return existe;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getUnidades() {
        return unidades;
    }

    /**
     * metodo que devuelve las unidades de un producto en la bd
     *
     * @param con conexion a la bd
     * @param cod codigo de producto
     * @return stock actual del producto
     */
    protected static int unidadesProd(Connection con, String cod) {
        int stock = -1;
        String query = "SELECT UNIDADES FROM PRODUCTO WHERE CODIGO = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, cod);
            ResultSet rs = ps.executeQuery();
            rs.next();
            stock = rs.getInt("unidades");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return stock;
    }

    /**
     * actualiza las unidades de un producto a 50
     *
     * @param prod codigo de producto
     * @param con conexion a la bd
     */
    protected static void agotado(String prod, Connection con) {
        String query = "UPDATE PRODUCTO SET UNIDADES = 50 WHERE CODIGO = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, prod);

            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    /**
     * metodo que crea un producto en la bd
     *
     * @param codigo codigo del producto
     * @param nombre nombre del producto
     * @param unidades unidades del producto
     * @return un porducto copia
     */
    public static Producto crearProducto(String codigo, String nombre, int unidades, String id) {
        Producto p;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("proyectoU9PU");
        EntityManager em = emf.createEntityManager();
        //actualiza correctamente la lista?
        Proveedor prov = Proveedor.copia(em, id);
        p = new Producto(codigo, nombre, unidades, prov);
        prov.getProds().add(p);
        return p;
    }
}
