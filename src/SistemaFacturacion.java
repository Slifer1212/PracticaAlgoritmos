import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class SistemaFacturacion {

    // Constantes
    private static final int DIAS_SEMANA = 7;
    private static final String[] NOMBRES_DIAS = {
            "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"
    };

    // Atributos
    private BigDecimal[] ventasSemanales;
    private Scanner scanner;
    private boolean datosIngresados;

    /**
     * Constructor que inicializa el sistema
     */
    public SistemaFacturacion() {
        this.ventasSemanales = new BigDecimal[DIAS_SEMANA];
        this.scanner = new Scanner(System.in);
        this.datosIngresados = false;
    }


    public void ejecutar() {
        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            procesarOpcion(opcion);
        } while (opcion != 5);
    }

    /**
     * Muestra el menú principal
     */
    private void mostrarMenu() {
        System.out.println("\n==============================");
        System.out.println("   SISTEMA DE FACTURACIÓN");
        System.out.println("==============================");
        System.out.println("1. Ingresar ventas semanales");
        System.out.println("2. Ver suma total");
        System.out.println("3. Ver promedio");
        System.out.println("4. Ver venta máxima");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    /**
     * Procesa la opción seleccionada por el usuario
     * @param opcion opción del menú
     */
    private void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                ingresarVentas();
                break;
            case 2:
                mostrarSumaTotal();
                break;
            case 3:
                mostrarPromedio();
                break;
            case 4:
                mostrarVentaMaxima();
                break;
            case 5:
                System.out.println("Saliendo del sistema... ");
                break;
            default:
                System.out.println("Opción inválida");
        }
    }

    /**
     * Solicita al usuario ingresar las ventas de la semana
     */
    private void ingresarVentas() {
        System.out.println("\n--- INGRESO DE VENTAS SEMANALES ---");
        int contador = 0;
        while (contador < ventasSemanales.length) {
            System.out.print("Ingrese lo vendido el " + NOMBRES_DIAS[contador] + ": $");
            BigDecimal valor = scanner.nextBigDecimal();

            if (valor.compareTo(BigDecimal.ZERO) < 0) {
                System.out.println("No se aceptan valores negativos. Intente nuevamente.");
            } else {
                ventasSemanales[contador] = valor;
                contador++;
            }
        }
        datosIngresados = true;
        System.out.println("Ventas registradas exitosamente");
    }

    /**
     * Muestra la suma total de ventas
     */
    private void mostrarSumaTotal() {
        if (!verificarDatosIngresados()) return;
        System.out.println("Suma total: $" + calcularSuma());
    }

    /**
     * Muestra el promedio de ventas
     */
    private void mostrarPromedio() {
        if (!verificarDatosIngresados()) return;
        System.out.println("Promedio: $" + calcularPromedio());
    }

    /**
     * Muestra la venta máxima
     */
    private void mostrarVentaMaxima() {
        if (!verificarDatosIngresados()) return;
        System.out.println("Venta máxima: $" + calcularMaximo());
    }

    private boolean verificarDatosIngresados() {
        if (!datosIngresados) {
            System.out.println("Debe ingresar las ventas primero (opción 1)");
            return false;
        }
        return true;
    }

    /**
     * Calcula la suma total de ventas
     * @return suma total
     */
    private BigDecimal calcularSuma() {
        return Arrays.stream(ventasSemanales)
                .filter(Objects::nonNull)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    /**
     * Calcula el promedio de ventas
     * @return promedio de ventas
     */
    private BigDecimal calcularPromedio() {
        long contador = Arrays.stream(ventasSemanales)
                .filter(Objects::nonNull)
                .count();

        if (contador == 0) return BigDecimal.ZERO;

        BigDecimal suma = calcularSuma();
        return suma.divide(
                BigDecimal.valueOf(contador),
                2,
                RoundingMode.HALF_UP
        );
    }

    /**
     * Encuentra la venta máxima
     * @return venta máxima
     */
    private BigDecimal calcularMaximo() {
        return Arrays.stream(ventasSemanales)
                .filter(Objects::nonNull)
                .max(BigDecimal::compareTo)
                .orElse(BigDecimal.ZERO);
    }

    /**
     * Cierra el scanner
     */
    public void cerrar() {
        scanner.close();
    }


    public static void main(String[] args) {
        SistemaFacturacion sistema = new SistemaFacturacion();
        sistema.ejecutar();
        sistema.cerrar();
    }
}