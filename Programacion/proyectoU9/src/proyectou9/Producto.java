/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectou9;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author matii
 */
@Entity
public class Producto{
    @Id
    private String codigo;
    private String nombre;
    private int unidades;
    @ManyToOne
    private Proveedor prov;
    

    /**
     * 
     * @param cod
     * @param nom
     * @param unidades
     * @param prov 
     */
    public Producto(String cod, String nom, int unidades, Proveedor prov){
        this.codigo = cod;
        this.nombre = nom;
        this.prov = prov;
        this.unidades = unidades;
    }

    
}
