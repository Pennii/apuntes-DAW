/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programacionunidad3;

/**
 *
 * @author maniana
 */
public class Coche {
    
    private int velocidad;
    
    Coche(){velocidad = 0;}
    
    public int getVelocidad(){
        return velocidad;
    }
    public void acelera(int mas){
        velocidad += mas; 
    }
    public void frena(int menos){
        velocidad -= menos;
    }
    public static void main(String[] args){
        Coche auto = new Coche();
        
        auto.acelera(54);
        auto.frena(15);
        auto.acelera(4);
        System.out.println(auto.getVelocidad());
    }
}
