/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repasoExamen3;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author matii
 */
public class Main {

    public static void main(String[] args) {
        Peleador peleador1 = new Peleador("gojo satoru", "seis ojos", 1, LocalDate.of(2018, 12, 24));
        Peleador peleador2 = new Peleador("sukuna", "10 sombras", 1, LocalDate.of(2018, 12, 24));
        Peleador peleador3 = new Peleador("son goku", "tortuga", 3, LocalDate.of(1998, 6, 5));
        Peleador peleador4 = new Peleador("vegeta", "saiyan", 3, LocalDate.of(1998, 6, 5));
        Peleador peleador5 = new Peleador("simon", "espiral", 1, LocalDate.of(2007, 11, 10));
        Peleador peleador6 = new Peleador("anti-espiral", "anti-espiral", 0, LocalDate.of(2007, 11, 10));
        Peleador peleador7 = new Peleador("buda", "baculo", 2, LocalDate.of(2023, 7, 6));
        Peleador peleador8 = new Peleador("hajun", "castigo divino", 0, LocalDate.of(2023, 7, 6));

        Set<Peleador> peleadores = new LinkedHashSet<>();
        
        peleadores.add(peleador1);
        peleadores.add(peleador2);
        peleadores.add(peleador3);
        peleadores.add(peleador4);
        peleadores.add(peleador5);
        peleadores.add(peleador6);
        peleadores.add(peleador7);
        peleadores.add(peleador8);
        
        for(Peleador pelea : peleadores){
            System.out.println(pelea);
        }
        Peleas peleas = new Peleas("rivales");
        
        for(Peleador luchador : peleadores){
            if (!peleas.getEncuentros().containsKey(luchador.getFecha())) {
                peleas.getEncuentros().put(luchador.getFecha(), new TreeSet<>());
            }
            peleas.getEncuentros().get(luchador.getFecha()).add(luchador);
        }
        peleas.getEncuentros().get(LocalDate.of(2018, 12, 24)).add(peleador2);
        System.out.print(peleas);
    }

}
