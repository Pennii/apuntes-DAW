/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fubol;

import java.time.LocalDate;
import java.time.Month;
import java.util.Objects;

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
    /**
     * valor por defecto si no se ingresa en el constructor: 01/01/2005
     *
     *
     */
    public final static LocalDate FECHA_DEFAULT = LocalDate.of(2005, 01, 31);

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
     *
     * @param name
     * @param nacimiento
     * @param numero
     */
    public Fubolista(String name, LocalDate nacimiento, int numero) {
        this(name, name, nacimiento, numero);
    }

    /**
     * constructor de 2 parametros. La fecha de nacimiento sera
     *
     * @param name nombre y apodo
     * @param numero numero de camiseta
     */
    public Fubolista(String name, int numero) {
        this(name, name, Fubolista.FECHA_DEFAULT, numero);
    }

    /**
     * devuelve el nombre del jugador
     *
     * @return nombre
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * devuelve el apodo
     *
     * @return apodo
     */
    public String getApodo() {
        return this.apodo;
    }

    /**
     * devuelve el numero de camiseta
     *
     * @return numCamiseta
     */
    public int getNumCamiseta() {
        return this.numCamiseta;
    }

    /**
     * devuelve el valor del identificador
     *
     * @return identificador
     */
    public int getIdentificador() {
        return this.identificador;
    }

    /**
     * devuelve la fecha de nacimiento
     *
     * @return fNac
     */
    public LocalDate getFechaNacimiento() {
        return this.fNac;
    }

    /**
     * cambia el numero de camiseta del jugador
     *
     * @param numero numero nuevo
     * @throws IllegalArgumentException
     */
    public void setNumCamiseta(int numero) throws IllegalArgumentException {
        if (numero <= 0) {
            throw new IllegalArgumentException("numero de camiseta invalido");
        }

        this.numCamiseta = numero;
    }

    /**
     * metodo toString
     *
     * @return
     */
    @Override
    public String toString() {
        return String.format("Nombre: %s apodo: %s\nidentificador: %d "
                + "numero de camiseta: %d fecha de nacimiento: %s\n", this.nombre,
                this.apodo, this.identificador, this.numCamiseta,
                this.fNac.toString());
    }

    @Override
    public boolean equals(Object obj) {
        boolean resultado = false;
        if (obj != null) {
            if (this == obj) {
                resultado = true;
            } else if (getClass() == obj.getClass()) {
                final Fubolista other = (Fubolista) obj;
                resultado = this.apodo == other.apodo && this.nombre
                        == other.nombre && this.fNac == other.fNac;
            }

        }
        return resultado;
    }
}
