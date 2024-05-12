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
public class Repartidor {

    @Id
    private String codigo;
    private String nombre;
    private String vehiculo;

    public static final String VEHICULOS_ACEPTADOS[] = {"A", "M", "B"};

    public Repartidor() {
    }

    /**
     * constructor de repartidor
     *
     * @param codigo codigo de repartidor
     * @param nombre nombre del repartidor
     * @param vehiculo vehiculo, DEBE TENER LOS VALORES 'A', 'M' O 'B'
     * @throws IllegalArgumentException si el valor de vehiculo es incorrecto
     */
    public Repartidor(String codigo, String nombre, String vehiculo) throws IllegalArgumentException {
        boolean correcto = false;
        for (int i = 0; i < VEHICULOS_ACEPTADOS.length; i++) {
            if (vehiculo.equals(VEHICULOS_ACEPTADOS[i])) {
                correcto = true;
            }
        }
        if (!correcto) {
            throw new IllegalArgumentException("VEHICULO INCORRECTO");
        }
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("proyectoU9PU");
        EntityManager em = emf.createEntityManager();
        if (repExiste(codigo, em)) {
            System.out.println("El repartidor ya existe en la bd");
        } else {
            this.codigo = codigo;
            this.nombre = nombre;
            this.vehiculo = vehiculo;
            persistir(em, this);
        }
    }

    /**
     * metodo que carga el objeto en la bd
     *
     * @param em controlador de entidad
     * @param r repartidor a cargar
     */
    public static void persistir(EntityManager em, Repartidor r) {
        em.getTransaction().begin();
        em.persist(r);
        em.getTransaction().commit();
        em.detach(r);
    }

    /**
     * metodo que determina si un cliente existe en la bd
     *
     * @param cod codigo a buscar
     * @param em controlador de entidad
     * @return verdadero si existe, falso si no
     */
    public static boolean repExiste(String cod, EntityManager em) {
        boolean existe;
        Repartidor r = em.find(Repartidor.class, cod);
        existe = r != null;
        return existe;
    }

}
