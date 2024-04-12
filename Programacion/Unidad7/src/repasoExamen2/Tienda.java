/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repasoExamen2;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author matii
 */
public class Tienda {
        
    private String nombre;
    private Map<String, Set<Comic>> listado;

    public Tienda(String nombre) {
        this.nombre = nombre;
        this.listado = new HashMap<>();
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setClave(String clave){
        this.getListado().put(clave, new TreeSet<>());
    }
    
    public Set<String> getClaves(){
        return getListado().keySet();
    }
    
    public void setElemento(String clave, Comic comic){
        getListado().get(clave).add(comic);
    }

    /**
     * @return the listado
     */
    public Map<String, Set<Comic>> getListado() {
        return listado;
    }
    
}
