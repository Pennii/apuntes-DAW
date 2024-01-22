package Videojuegos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author maniana
 */
public class CompraVideoJuegos {

    private static final String PLATAFORMAS = "PS5|XBOX|Switch";
    private static final String FORMATO_TICKET = "(([A-Z a-z0-9]+),(PS5|XBOX|Switch),([1-9][0-9\\.]{0,4})#?)+";

    private int cantPs5;
    private int cantXbox;
    private int cantSwitch;
    private double gastoPs5;
    private double gastoXbox;
    private double gastoSwitch;
    private double gastoTot;

    public CompraVideoJuegos(String ticket) throws IllegalArgumentException {
        Pattern patron = Pattern.compile(FORMATO_TICKET);
        Matcher valido = patron.matcher(ticket);
        if (!valido.find()) {
            throw new IllegalArgumentException("Patron invalido de ticket");
        }
        int pos = 0;
        String tickete[] = ticket.split("#");
        for (int i = 0; i < tickete.length; i++) {
            valido = patron.matcher(tickete[i]);
            if (valido.find()) {
                switch (valido.group(3)) {
                    case "PS5":
                        this.gastoPs5 += Double.parseDouble(valido.group(4));
                        this.cantPs5++;
                        break;
                    case "XBOX":
                        this.gastoXbox += Double.parseDouble(valido.group(4));
                        this.cantXbox++;
                        break;
                    default:
                        this.gastoSwitch += Double.parseDouble(valido.group(4));
                        this.cantSwitch++;
                }
                this.gastoTot += Double.parseDouble(valido.group(4));

            }

        }

    }

    public int getCantidad(String plataforma) throws IllegalArgumentException {
        if (!plataforma.matches(PLATAFORMAS)) {
            throw new IllegalArgumentException("Plataforma invalida");
        }
        switch (plataforma) {
            case "PS5":
                return this.cantPs5;
            case "XBOX":
                return this.cantXbox;
            default:
                return this.cantSwitch;
        }
    }

    public double getGasto(String plataforma) throws IllegalArgumentException {
        if (!plataforma.matches(PLATAFORMAS)) {
            throw new IllegalArgumentException("Plataforma invalida");
        }
        switch (plataforma) {
            case "PS5":
                return this.gastoPs5;
            case "XBOX":
                return this.gastoXbox;
            default:
                return this.gastoSwitch;
        }
    }

    public double getGastoTotal() {
        return this.gastoTot;
    }

    public String toString() {
        return String.format("%d videojuegos PS5 %.2f (%.2f iva incluido)\n"
                + "%d videojuegos XBOX %.2f (%.2f iva incluido)\n"
                + "%d videojuegos SWITCH %.2f (%.2f iva incluido)\n"
                + "---------------------------------------\n"
                + "Total: %.2f (%.2f iva incluido)", this.cantPs5,
                this.gastoPs5, this.gastoPs5 * 1.21,
                this.cantXbox, this.gastoXbox, this.gastoXbox * 1.21,
                this.cantSwitch, this.gastoSwitch, this.gastoSwitch * 1.21,
                this.gastoTot, this.gastoTot * 1.21);
    }
}
