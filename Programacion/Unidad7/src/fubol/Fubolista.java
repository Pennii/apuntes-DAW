/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fubol;

import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author maniana
 */
public class Fubolista {

    /**
     * año minimo de nacimiento para un jugador
     */
    public static final int MIN_YEAR = 2000;
    /**
     * año maximo de nacimiento para un jugador
     */
    public static final int MAX_YEAR = 2009;
    public static final LocalDate FECHA_DEFAULT = LocalDate.of(2005, 01, 31);

    private static int id = 0;

    private String apodo;
    private int identificador;
    private int numCamiseta;
    private final String nombre;
    private final LocalDate fNac;

    /**
     * constructor de cuatro parametros
     *
     * @param name nombre
     * @param nickName apodo
     * @param nacimiento fecha nacimiento
     * @param numero numero de camiseta
     * @throws IllegalArgumentException
     */
    public Fubolista(String name, String nickName, LocalDate nacimiento, int numero) throws IllegalArgumentException {
        if (nacimiento.getYear() < MIN_YEAR || nacimiento.getYear() > MAX_YEAR) {
            throw new IllegalArgumentException(String.format(
                    "AÑO INVALIDO: %d", nacimiento.getYear()));
        }

        this.nombre = name;
        this.apodo = nickName;
        this.identificador = ++Fubolista.id;
        this.numCamiseta = numero;
        this.fNac = nacimiento;
    }

    /**
     * constructor de 3 parametros
     * @param name nombre y apodo
     * @param nacimiento fecha nacimiento
     * @param numero numero camiseta
     */
    public Fubolista(String name, LocalDate nacimiento, int numero) {
        this(name, name, nacimiento, numero);
    }
    /**
     * constructor de 2 parametros. La fecha de nacimiento sera 
     * @param name nombre y apodo
     * @param numero numero de camiseta
     */
    public Fubolista(String name, int numero){
        this(name, name, Fubolista.FECHA_DEFAULT, numero);
    }

    /**
     * devuelve el nombre del jugador
     *
     * @return
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * devuelve el apodo
     *
     * @return
     */
    public String getApodo() {
        return this.apodo;
    }

    /**
     * devuelve el numero de camiseta
     *
     * @return
     */
    public int getNumCamiseta() {
        return this.numCamiseta;
    }
}
