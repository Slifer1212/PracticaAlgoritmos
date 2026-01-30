public class InversorArray {

    // Atributos
    private int[] arrayOriginal;
    private int[] arrayInvertido;

    /**
     * Constructor que recibe el array original
     * @param array array a invertir
     */
    public InversorArray(int[] array) {
        this.arrayOriginal = array;
        this.arrayInvertido = null;
    }

    /**
     * Constructor por defecto con array de ejemplo
     */
    public InversorArray() {
        this(new int[]{1, 2, 3, 4, 5, 6});
    }

    /**
     * Invierte el array creando uno nuevo
     */
    public void invertirConNuevoArray() {
        arrayInvertido = new int[arrayOriginal.length];

        for (int i = 0; i < arrayOriginal.length; i++) {
            arrayInvertido[i] = arrayOriginal[arrayOriginal.length - i - 1];
        }
    }

    /**
     * Invierte el array in-place (sin crear nuevo array)
     */
    public void invertirInPlace() {
        for (int i = 0; i < arrayOriginal.length / 2; i++) {
            int temp = arrayOriginal[i];
            arrayOriginal[i] = arrayOriginal[arrayOriginal.length - i - 1];
            arrayOriginal[arrayOriginal.length - i - 1] = temp;
        }
    }

    /**
     * Muestra el array original
     */
    public void mostrarArrayOriginal() {
        System.out.println("\n=== ARRAY ORIGINAL ===");
        imprimirArray(arrayOriginal);
    }

    /**
     * Muestra el array invertido
     */
    public void mostrarArrayInvertido() {
        System.out.println("\n=== ARRAY INVERTIDO ===");
        if (arrayInvertido != null) {
            imprimirArray(arrayInvertido);
        } else {
            System.out.println("Primero debe invertir el array");
        }
    }

    /**
     * Muestra el array original después de inversión in-place
     */
    public void mostrarResultadoInPlace() {
        System.out.println("\n=== ARRAY DESPUÉS DE INVERSIÓN IN-PLACE ===");
        imprimirArray(arrayOriginal);
    }

    /**
     * Imprime los elementos de un array
     * @param array array a imprimir
     */
    private void imprimirArray(int[] array) {
        for (int elemento : array) {
            System.out.println(elemento);
        }
    }

    /**
     * Imprime array en una sola línea
     * @param array array a imprimir
     */
    private void imprimirArrayLinea(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    /**
     * Obtiene el array original
     * @return array original
     */
    public int[] getArrayOriginal() {
        return arrayOriginal;
    }

    /**
     * Obtiene el array invertido
     * @return array invertido o null si no se ha invertido
     */
    public int[] getArrayInvertido() {
        return arrayInvertido;
    }

    /**
     * Establece un nuevo array original
     * @param array nuevo array
     */
    public void setArrayOriginal(int[] array) {
        this.arrayOriginal = array;
        this.arrayInvertido = null; // Reset del array invertido
    }

    /**
     * Método main para demostrar el funcionamiento
     */
    public static void main(String[] args) {
        // Ejemplo 1: Inversión con nuevo array
        System.out.println("╔════════════════════════════════════╗");
        System.out.println("║  MÉTODO 1: Nuevo Array (O(n))     ║");
        System.out.println("╚════════════════════════════════════╝");

        InversorArray inversor1 = new InversorArray();
        inversor1.mostrarArrayOriginal();
        inversor1.invertirConNuevoArray();
        inversor1.mostrarArrayInvertido();

    }
}