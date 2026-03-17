public class Fraccion {
    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador) {
        assert denominador != 0 : "El denominador no puede ser cero.";
        
        if (denominador < 0) {
            numerador = -numerador;
            denominador = -denominador;
        }

        int mcd = calcularMCD(valorAbsoluto(numerador), valorAbsoluto(denominador));
        this.numerador = numerador / mcd;
        this.denominador = denominador / mcd;
    }

    private int valorAbsoluto(int numero) {
        if (numero < 0) {
            return -numero;
        }
        return numero;
    }

    private int calcularMCD(int a, int b) {
        while (b != 0) {
            int temporal = b;
            b = a % b;
            a = temporal;
        }
        return a; 
    }

}