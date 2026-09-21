package Tarea4;
import java.util.Scanner;

public class gestionDeInventario {

    private String[] productos = {"Laptop", "Mouse", "Teclado", "Monitor", "Audifonos"}; 
    private double[] precios = {45000.0, 850.0, 1200.0, 12000.0, 2500.0}; 
    private int[] cantidades = {10, 50, 30, 8, 25};
    
    public static void ejecutar(){

        
        while(true){
            mostrarMenu();
            System.out.print("Seleccione una opcion: ");
            int opcion = new Scanner(System.in).nextInt();

            switch (opcion) {
                case 1:
                    mostrarReporteCompleto(new String[]{"Laptop", "Mouse", "Teclado", "Monitor", "Audifonos"},
                            new double[]{45000.0, 850.0, 1200.0, 12000.0, 2500.0},
                            new int[]{10, 50, 30, 8, 25});
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del producto a buscar: ");
                    String busqueda = new Scanner(System.in).nextLine();
                    buscarProducto(new String[]{"Laptop", "Mouse", "Teclado", "Monitor", "Audifonos"}, busqueda);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Pero mira las opciones ombe");
            }

            
        }
    }
    
    public static void mostrarReporteCompleto(String[] productos, double[] precios, int[] cantidades) {

        double totalGeneral = 0;
        int indiceMayor = 0;
        int indiceMenor = 0;

        
        for (int i = 0; i < productos.length; i++) {
            totalGeneral += precios[i] * cantidades[i];

            if (precios[i] > precios[indiceMayor]) {
                indiceMayor = i;
            }

            if (precios[i] < precios[indiceMenor]) {
                indiceMenor = i;
            }
        }

        String productoCaro = productos[indiceMayor];
        double precioCaro = precios[indiceMayor];

        String productoBarato = productos[indiceMenor];
        double precioBarato = precios[indiceMenor];

        
        for (int i = 0; i < precios.length - 1; i++) {
            for (int j = 0; j < precios.length - 1 - i; j++) {

                if (precios[j] < precios[j + 1]) {
                    double tempPrecio = precios[j];
                    precios[j] = precios[j + 1];
                    precios[j + 1] = tempPrecio;

                    String tempProducto = productos[j];
                    productos[j] = productos[j + 1];
                    productos[j + 1] = tempProducto;

                    int tempCantidad = cantidades[j];
                    cantidades[j] = cantidades[j + 1];
                    cantidades[j + 1] = tempCantidad;
                }
            }
        }

        
        System.out.println("\n╔══════════════╦══════════════╦═══════════╦══════════════════╗");
        System.out.println("║ Producto     ║ Precio       ║ Cantidad  ║ Valor total      ║");
        System.out.println("╠══════════════╬══════════════╬═══════════╬══════════════════╣");

        for (int i = 0; i < productos.length; i++) {
            double valorProducto = precios[i] * cantidades[i];

            System.out.printf(
                "║ %-12s ║ $%-11.2f ║ %-9d ║ $%-15.2f ║%n",
                productos[i], precios[i], cantidades[i], valorProducto
            );
        }

        System.out.println("╚══════════════╩══════════════╩═══════════╩══════════════════╝");

        System.out.printf("%nValor total del inventario: $%.2f%n", totalGeneral);
        System.out.printf("Producto mas caro: %s - $%.2f%n", productoCaro, precioCaro);
        System.out.printf("Producto mas barato: %s - $%.2f%n", productoBarato, precioBarato);

        System.out.println("\nProductos con inventario bajo:");

        boolean hayBajo = false;

        for (int i = 0; i < productos.length; i++) {
            if (cantidades[i] < 15) {
                System.out.println("- " + productos[i] + ": " + cantidades[i] + " unidades");
                hayBajo = true;
            }
        }

        if (!hayBajo) {
            System.out.println("No hay productos con inventario bajo.");
        }
    }

    public static int buscarProducto(
        String[] productos,
        String busqueda) {

    for (int i = 0; i < productos.length; i++) {

        if (productos[i].toLowerCase()
                .contains(busqueda.toLowerCase())) {

            System.out.println("Producto encontrado: " + productos[i]);
            System.out.println("Indice del producto: " + i);

            return i;
            }
        }

        System.out.println("Producto no encontrado.");
        return -1;
    }

    public static void mostrarMenu() {

        System.out.println("╔═══════════════════════════════════════╗");
        System.out.println("║         MENU DE INVENTARIO            ║");
        System.out.println("╠═══════════════════════════════════════╣");
        System.out.println("║ 1. Mostrar Inventario                 ║");
        System.out.println("║ 2. Buscar Producto                    ║");
        System.out.println("║ 0. Salir                              ║");
        System.out.println("╚═══════════════════════════════════════╝");

    }
}
