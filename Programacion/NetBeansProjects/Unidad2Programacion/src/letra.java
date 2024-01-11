import java.util.Scanner;

public class letra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce una letra (A, B, C, etc.): ");
        char letra = scanner.next().charAt(0);

        if (Character.isLetter(letra)) {
            dibujarLetra(letra);
        } else {
            System.out.println("Por favor, introduce una letra válida.");
        }

        scanner.close();
    }

    public static void dibujarLetra(char letra) {
        switch (letra) {
            case 'A':
                System.out.println("  *  ");
                System.out.println(" * * ");
                System.out.println("*****");
                System.out.println("*   *");
                break;
            case 'B':
                // Dibujo de la letra B
                break;
            case 'C':
                // Dibujo de la letra C
                break;
            // Agrega más casos para otras letras
            default:
                System.out.println("Lo siento, no puedo dibujar esa letra.");
        }
    }
}
