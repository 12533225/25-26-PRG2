import java.util.*;

public class Mano {
    private List<Carta> cartas = new ArrayList<>();

    public void agregarCarta(Carta carta) {
        cartas.add(carta);
    }

    public int calcularPuntaje() {
        return 0;
    }

    public String mostrar() {
        return cartas.toString();
    }
}
