/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectou9;

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
     *constructor de producto que verifica si el producto existe antes de crearlo
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

}
