import java.util.Random;
import java.util.Scanner;

public class Buscaminas {
    private static final int FILAS = 5;
    private static final int COLUMNAS = 7;
    private static final char CELDA_OCULTA = '-';
    private static final int TOTAL_MINAS = 5;
    private boolean[][] mapaMinas;
    private Scanner scanner = new Scanner(System.in);

    private char[][] tableroVisual;

    public static void main(String[] args) {
        new Buscaminas().iniciar();
    }

    private void colocarMinas() {
        Random random = new Random();
        int minasColocadas = 0;
        
        while (minasColocadas < TOTAL_MINAS) {
            int f = random.nextInt(FILAS);
            int c = random.nextInt(COLUMNAS);

            if (!mapaMinas[f][c]) {
                mapaMinas[f][c] = true;
                minasColocadas++;
            }
        }
    }

    public void iniciar() {
        inicializarTablero();
        colocarMinas();
        System.out.println("=== EXAMEN DE MINAS ===");
        imprimirTablero();
    }

    private void inicializarTablero() {
        tableroVisual = new char[FILAS][COLUMNAS];
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                tableroVisual[i][j] = CELDA_OCULTA;
                mapaMinas = new boolean[FILAS][COLUMNAS];
            }
        }
    }

    private void imprimirTablero() {
        System.out.println("================");
        System.out.print("  ");
        for (int j = 1; j <= COLUMNAS; j++) { 
            System.out.print(j + " ");
        }
        System.out.println();

        for (int i = 0; i < FILAS; i++) {
            System.out.print((i + 1) + " "); 
            for (int j = 0; j < COLUMNAS; j++) {
                System.out.print(tableroVisual[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("================");
    }

    private void realizarJugada() {
        int fila = leerNumero("Fila (X)", FILAS);
        int col = leerNumero("Columna (Y)", COLUMNAS);
    
        procesarCelda(fila - 1, col - 1); 
    }

    private int leerNumero(String dato, int max) {
        int valor = -1;
        while (true) {
            System.out.println("Ingrese " + dato + " (1-" + max + "):");
            if (scanner.hasNextInt()) {
                valor = scanner.nextInt();
                if (valor >= 1 && valor <= max) return valor;
            } else {
                scanner.next();
            }
            System.out.println("Error: Número inválido.");
        }
    }

    private void procesarCelda(int f, int c) {
        System.out.println("Analizando celda: " + f + "," + c);
    }
}