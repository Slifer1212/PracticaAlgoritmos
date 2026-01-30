
import java.util.Arrays;
import java.util.Scanner;

public class AnalizadorTemperaturas {

    // Constantes
    private static final int CANTIDAD_TEMPERATURAS = 10;
    private static final double TEMPERATURA_UMBRAL = 30.0;

    // Atributos
    private double[] temperaturas;
    private Scanner scanner;


    public AnalizadorTemperaturas() {
        this.temperaturas = new double[CANTIDAD_TEMPERATURAS];
        this.scanner = new Scanner(System.in);
    }

    public void ejecutar() {
        ingresarTemperaturas();
        mostrarResultados();
    }

    /**
     * Solicita al usuario ingresar las temperaturas
     */
    private void ingresarTemperaturas() {
        System.out.println("Introduzca las " + CANTIDAD_TEMPERATURAS + " últimas temperaturas de su ciudad:");
        for (int i = 0; i < temperaturas.length; i++) {
            System.out.print("Temperatura " + (i + 1) + ": ");
            temperaturas[i] = scanner.nextDouble();
        }
    }

    /**
     * Muestra los resultados calculados
     */
    private void mostrarResultados() {
        System.out.println("\n=== RESULTADOS ===");
        System.out.println("Temperatura máxima: " + calcularMaximo() + "°C");
        System.out.println("Temperatura mínima: " + calcularMinimo() + "°C");
        System.out.println("Promedio de temperaturas: " + calcularPromedio() + "°C");
        System.out.println("Temperaturas mayores a " + TEMPERATURA_UMBRAL + "°C: " + contarMayoresUmbral());
    }

    /**
     * Calcula la temperatura máxima
     * @return temperatura máxima
     */
    private double calcularMaximo() {
        double max = temperaturas[0];
        for (double temp : temperaturas) {
            if (temp > max) {
                max = temp;
            }
        }
        return max;
    }


    private double calcularMinimo() {
        double min = temperaturas[0];
        for (double temp : temperaturas) {
            if (temp < min) {
                min = temp;
            }
        }
        return min;
    }


    private double calcularPromedio() {
        return Arrays.stream(temperaturas).sum() / temperaturas.length;
    }


    private int contarMayoresUmbral() {
        int contador = 0;
        for (double temp : temperaturas) {
            if (temp > TEMPERATURA_UMBRAL) {
                contador++;
            }
        }
        return contador;
    }


    public void cerrar() {
        scanner.close();
    }


    public static void main(String[] args) {
        AnalizadorTemperaturas analizador = new AnalizadorTemperaturas();
        analizador.ejecutar();
        analizador.cerrar();
    }
}