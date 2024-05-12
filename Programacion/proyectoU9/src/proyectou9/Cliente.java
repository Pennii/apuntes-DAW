/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectou9;

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
public class Cliente {

    @Id
    private String codigo;
    private String nombre;
    private int edad;

    public Cliente() {

    }

    public Cliente(String cod, String nom, int edad) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("proyectoU9PU");
        EntityManager em = emf.createEntityManager();
        if (clienExiste(cod, em)) {
            System.out.println("El cliente ya existe en la base de datos");
        } else {
            this.codigo = cod;
            this.edad = edad;
            this.nombre = nom;
            persistir(em, this);
        }
    }

    /**
     * metodo que carga el objeto en la bd
     *
     * @param em controlador de entidad
     * @param c cliente a cargar
     */
    public static void persistir(EntityManager em, Cliente c) {
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        em.detach(c);
    }

    /**
     * metodo que determina si un cliente existe en la bd
     *
     * @param cod codigo a buscar
     * @param em controlador de entidad
     * @return verdadero si existe, falso si no
     */
    public static boolean clienExiste(String cod, EntityManager em) {
        boolean existe;
        Cliente c = em.find(Cliente.class, cod);
        existe = c != null;
        return existe;
    }
}
