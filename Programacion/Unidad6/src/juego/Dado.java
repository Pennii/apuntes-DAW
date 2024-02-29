/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

/**
 *
 * @author matii
 */
public class Dado extends ElementoJuego implements Azar{

    public static final int NUM_CARAS[] = {4, 6, 8, 12, 20};
    public static final int DEFAULT_CARAS = 6;

    public final int caras;

    public Dado(String nombre, int caras) {
        super(nombre);

        boolean valido = false;
        for (int i = 0; i < NUM_CARAS.length && !valido; i++) {
            valido = NUM_CARAS[i] == caras;
        }
        if (valido) {
            this.caras = caras;
        } else {
            this.caras = DEFAULT_CARAS;
        }
    }

    public String toString(){
        return String.format("%s, Caras: %d", super.toString(), this.caras);
    }

    @Override
    public String lanzar() {
        int lanzamiento;
        String resultado;
        lanzamiento =  (int) (Math.random() * this.caras+1);
        
        switch(lanzamiento){
            case 1 -> {
                resultado = "UNO";
            }
            case 2 ->{
                resultado = "DOS";
            }
            case 3 ->{
                resultado = "TRES";
            }
            case 4 ->{
                resultado = "CUATRO";
            }
            case 5 ->{
                resultado = "CINCO";
            }
            case 6 ->{
                resultado = "SEIS";
            }
            case 7 ->{
                resultado = "SIETE";
            }
            case 8 ->{
                resultado = "OCHO";
            }
            case 9 ->{
                resultado = "NUEVE";
            }
            case 10 ->{
                resultado = "DIEZ";
            }
            case 11 ->{
                resultado = "ONCE";
            }
            case 12 ->{
                resultado = "DOCE";
            }
            case 13 ->{
                resultado = "TRECE";
            }
            case 14 ->{
                resultado = "CATORCE";
            }
            case 15 ->{
                resultado = "QUINCE";
            }
            case 16 ->{
                resultado = "DIECISEIS";
            }
            case 17 ->{
                resultado = "DIECISIETE";
            }
            case 18 ->{
                resultado = "DIECIOCHO";
            }
            case 19 ->{
                resultado = "DIECINUEVE";
            }
            default ->{
                resultado = "VEINTE";
            }
        }
        return resultado;
    }
}
