public class Buscaminas {
    private static final int FILAS = 5;
    private static final int COLUMNAS = 7;
    private static final char CELDA_OCULTA = '-';

    private char[][] tableroVisual;

    public static void main(String[] args) {
        new Buscaminas().iniciar();
    }

    public void iniciar() {
        inicializarTablero();
        System.out.println("=== EXAMEN DE MINAS ===");
        imprimirTablero();
    }

    private void inicializarTablero() {
        tableroVisual = new char[FILAS][COLUMNAS];
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                tableroVisual[i][j] = CELDA_OCULTA;
            }
        }
    }

    private void imprimirTablero() {
        System.out.println("================");
        System.out.print("  ");

        for (int i = 0; i < FILAS; i++) {
            System.out.print((i + 1) + " "); 
            for (int j = 0; j < COLUMNAS; j++) {
                System.out.print(tableroVisual[i][j] + " ");
            }
        }
        System.out.println("================");
    }
}