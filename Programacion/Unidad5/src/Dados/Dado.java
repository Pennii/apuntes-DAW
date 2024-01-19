/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dados;

import java.util.Arrays;

/**
 *
 * @author pennii
 */
public class Dado {

    private final static String resultados[] = {"UNO", "DOS", "TRES", "CUATRO",
        "CINCO", "SEIS", "SIETE", "OCHO", "NUEVE", "DIEZ", "ONCE", "DOCE",
        "TRECE", "CATORCE", "QUINCE", "DIECISEIS", "DIECISIETE", "DIECIOCHO",
        "DIECINUEVE", "VEINTE"};
    //Atributos de objeto
    private int lanzamientos;
    private int[] lanzamientosCara;

    /**
     *
     * @param c
     * @throws IllegalArgumentException
     */
    public Dado(int c) throws IllegalArgumentException {
        if (c != 4 && c != 6 && c != 12 && c != 20) {
            throw new IllegalArgumentException("caras invalidas");
        }
        this.lanzamientos = 0;
        lanzamientosCara = new int[c];
        Arrays.fill(lanzamientosCara, 0);
    }

    /**
     *
     */
    public Dado() {
        this.lanzamientos = 0;
        lanzamientosCara = new int[20];
        Arrays.fill(lanzamientosCara, 0);
    }

    /**
     *
     * @return
     */
    public int getNumeroCaras() {
        return this.lanzamientosCara.length;
    }

    /**
     *
     * @return
     */
    public int getNumLanzamientos() {
        return this.lanzamientos;
    }
    
    public int getLanzamientosCara( int n) throws IllegalArgumentException{
        if (n < 1 || n > this.lanzamientosCara.length) {
            throw new IllegalArgumentException("Caras invalidas");
        }
        return this.lanzamientosCara[n-1];
    }

    /**
     *
     * @return
     */
    public String lanzar() {
        int resultado;
        String escrito;
        resultado = (int) (1 + Math.random() * (this.lanzamientosCara.length));
        escrito = Dado.resultados[resultado - 1];
        this.lanzamientos++;
        this.lanzamientosCara[resultado - 1]++;
        return escrito;
    }
    
   

    /**
     *
     * @return
     */
    public String toString() {
        return String.format("Numero de caras: %d, numero de lanzamientos"
                + ": %d", this.lanzamientosCara.length, this.lanzamientos);
    }
}
