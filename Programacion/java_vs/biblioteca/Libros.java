package biblioteca;

public class Libros {
    private int[] cantidad = new int[3];
    private int[] vendidos = new int[3];

    public Libros() {
        for (int i = 0; i < 3; i++) {
            cantidad[i] = 0;
            vendidos[i] = 0;
        }
    }

    public void agregarLibro(String g, int c, int v) {
        switch (g) {
            case "terror":
                cantidad[0] += c;
                break;
            case "comedia":
                cantidad[1] += c;

                break;
            case "drama":
                cantidad[2] += c;

                break;

            default:

                break;
        }
    }

    public String getGeneroVendido(int g) {
        String genero;
        for (int i = 0; i < 3; i++) {
            if (vendidos[i] > g) {
                g = vendidos[i];
            }

        }
        if (g == vendidos[0]) {
            genero = "Terror";
        } else if (g == vendidos[1]) {
            genero = "Comedia";
        } else if (g == vendidos[2]) {
            genero = "Drama";
        } else {
            genero = "ERROR";
        }
        return genero;
    }

    public int getTerror() {
        return cantidad[0];
    }

    public int getComedia() {
        return cantidad[1];
    }

    public int getDrama() {
        return cantidad[2];
    }
}
