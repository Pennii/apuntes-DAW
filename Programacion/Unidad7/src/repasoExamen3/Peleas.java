/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repasoExamen3;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author matii
 */
public class Peleas {
    
    private Map<LocalDate, Set<Peleador>> encuentros;
    private String titulo;

    public Peleas(String titulo) {
        this.titulo = titulo;
        this.encuentros = new TreeMap<>();
    }

    /**
     * @return the encuentros
     */
    public Map<LocalDate, Set<Peleador>> getEncuentros() {
        return encuentros;
    }

    /**
     * @param encuentros the encuentros to set
     */
    public void setEncuentros(Map<LocalDate, Set<Peleador>> encuentros) {
        this.encuentros = encuentros;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    
    @Override
    public String toString() {
        String peleas = "";
        
        for(LocalDate fecha : this.encuentros.keySet()){
            peleas += "Pelean el "+fecha.toString()+":\n";
            for(Peleador peleadores : this.encuentros.get(fecha)){
                peleas += peleadores.toString()+"\n";
            }
            peleas += "\n";
        }
        
        return peleas;
    }
    
    
}
