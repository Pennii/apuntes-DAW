/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package animales;

/**
 *
 * @author maniana
 */
public class main {

    public static void main(String[] args) {
        Animal lista[] = new Animal[4];

        /*
        con este ejemplo se puede ver mas claramente la ligadura dinamica,
        que consiste en que java llamara a los metodos de la clase dinamica, 
        esto con el objetivo de llamar a los metodos mas adecuados
         */
        for (int i = 0; i < lista.length; i++) {
            if (i % 2 == 0) {
                lista[i] = new Perro("marron");

            } else {
                lista[i] = new Gato("blanco");
            }
            if (i == 3) {
                lista[i] = new Pez("rojo");
            }
        }

        /*
          si tenemos un array de una clase que contenga clases distintas, debo
          hacer un casting para ver los metodos de esas clases. Para hacer los 
          castings debo hacer un instanceof, que devolvera true si el elemento
          del array pertenece a la clase de la derecha
         */
        for (Animal animal : lista) {
            animal.hacerRuido();
            if (animal instanceof Perro) {
                System.out.println(((Perro) animal).getPelo());
            } else if (animal instanceof Pez) {
                System.out.println(((Pez) animal).getEscamas());
            } else if (animal instanceof Gato) {
                System.out.println(((Gato) animal).getPelo());
            }
        }
    }

}
