/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectou9;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.Persistence;

/**
 *
 * @author matii
 */
@Entity
public class Proveedor {

    @Id
    private String id;
    @Basic
    private String nombre;

    public Proveedor() {

    }

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
            persistir(em, this);
        }
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
     * @param id id a buscar
     * @param em controlador de entidad
     * @return verdadero si existe, falso si no
     */
    private boolean idExiste(String id, EntityManager em) {
        boolean existe;
        Proveedor p = em.find(Proveedor.class, id);
        existe = p != null;
        em.detach(p);
        return existe;
    }
    
//    public boolean proveer(String cod, String nom, int unidades){
//        boolean provee;
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("proyectoU9PU");
//        EntityManager em = emf.createEntityManager();
//        
//        Producto p = em.find(Producto.class, cod);
//        if (p != null) {
//            if (p.getProveedor().equals(this.id)){
//                p.setCodigo(cod);
//            }
//        }
//    }

}
