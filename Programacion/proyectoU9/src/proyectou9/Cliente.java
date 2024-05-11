/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectou9;

import javax.persistence.Entity;
import javax.persistence.Id;

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
}
