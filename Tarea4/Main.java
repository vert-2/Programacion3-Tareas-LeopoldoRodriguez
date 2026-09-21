package Tarea4;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        while (true) {
            mostrarMenu();
            System.out.print("Seleccione una opcion: ");
            int opcion = new java.util.Scanner(System.in).nextInt();
            switch (opcion) {
                case 1:
                    gestionDeInventario.ejecutar();
                    break;
                case 2:
                    matrizDeCalificaciones.ejecutar();
                    break;
                case 3:
                    procesadorCSV.ejecutar();
                    break;
                case 4:
                    validadorDeDatos.ejecutar();
                    break;
                case 5:
                    calculadoraFecha.ejecutar();
                    break;
                case 0:
                    System.out.println("Bon soir");
                    return;
                default:
                    System.out.println("Pero mira bien mi hijo.");
            }
        }

        
        
    }

    static void mostrarMenu() {
        System.out.println("╔═══════════════════════════════════════╗");
        System.out.println("║         MENU DE EJERCICIOS            ║");
        System.out.println("╠═══════════════════════════════════════╣");
        System.out.println("║ 1. Gestion de Inventario              ║");
        System.out.println("║ 2. Matriz de Calificaciones           ║");
        System.out.println("║ 3. Procesador de datos CSV            ║");
        System.out.println("║ 4. Validador de datos                 ║");
        System.out.println("║ 5. Calculadora de fechas              ║");
        System.out.println("║ 0. Salir                              ║");
        System.out.println("╚═══════════════════════════════════════╝");
    
    }

}
