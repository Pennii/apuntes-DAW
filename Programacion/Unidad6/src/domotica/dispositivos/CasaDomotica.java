/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domotica.dispositivos;

import domotica.Domotica;

/**
 *
 * @author matii
 */
public class CasaDomotica {

    private Dispositivo dispositivos[];
    private String propietario;
    private String descripcion;

    public CasaDomotica(String prop, String desc, Dispositivo... disp) {
        this.propietario = prop;
        this.descripcion = desc;
        this.dispositivos = disp;

        this.dispositivos = new Dispositivo[disp.length];

        for (int i = 0; i < this.dispositivos.length; i++) {
            this.dispositivos[i] = disp[i];
        }
    }

    public int getNumDispositivos() {
        return this.dispositivos.length;
    }

    public int getNumBombillas() {
        int boms = 0;

        for (Dispositivo disp : this.dispositivos) {
            if (disp instanceof Bombilla) {
                boms++;
            }
        }
        return boms;
    }

    public int getNumCerraduras() {
        int cerr = 0;

        for (Dispositivo disp : this.dispositivos) {
            if (disp instanceof Cerradura) {
                cerr++;
            }
        }
        return cerr;
    }

    public int cerrar() {
        int cerradas = 0;
        for (int i = 0; i < this.dispositivos.length; i++) {
            if (this.dispositivos[i] instanceof Cerradura) {
                try {
                    ((Cerradura) this.dispositivos[i]).on();
                    cerradas++;
                } catch (Exception e) {
                }
            }
        }
        return cerradas;
    }

    public int activar() {
        int activadas = 0;

        for (int i = 0; i < this.dispositivos.length; i++) {
            if (this.dispositivos[i] instanceof Activable) {
                try {
                    ((Activable) this.dispositivos[i]).on();
                    activadas++;
                } catch (Exception e) {
                }
            }
        }
        return activadas;
    }

    public String toString() {
        String resultado;
        String estancia[] = new String[Domotica.MAX_UBICACION];
        int ubi;

        for (int i = 0; i < estancia.length; i++) {
            estancia[i] = String.format("ESTANCIA: %d\n", i + 1);
        }

        resultado = String.format("CASA DOMOTICA\nPROPIETARIO: %S\nDescripcion: %s\n",
                this.propietario, this.descripcion);
        for (int i = 0; i < this.dispositivos.length; i++) {
            ubi = this.dispositivos[i].getUbi() - 1;
            estancia[ubi] += this.dispositivos[i].toString() + "\n";
        }

        for (int i = 0; i < estancia.length; i++) {
            if (estancia[i].contains("tipo:")) {
                resultado += estancia[i] + "\n";
            }
        }
        return resultado;
    }

}
