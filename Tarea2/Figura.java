package Tarea2;
import java.util.Scanner;
public abstract class Figura {
    private static Scanner scanner = new Scanner(System.in);

    public abstract double calcularArea();

    public static void ejecutar() {
        Figura figura;

        do {
            mostrarMenu();
            System.out.print("Seleccione una opcion: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el radio:");
                    double radio = scanner.nextDouble();
                    figura = new Circulo(radio);
                    System.out.println("Area: " + figura.calcularArea());
                    break;

                case 2:
                    System.out.print("Ingrese la base:");
                    double base = scanner.nextDouble();
                    System.out.print("Ingrese la altura:");
                    double altura = scanner.nextDouble();
                    figura = new Triangulo(base, altura);
                    System.out.println("Area: " + figura.calcularArea());
                    break;    
            
                case 0:
                    System.out.println("Bai");
                    return;

                default:
                    System.out.println("Opcion en silla de ruedas.");    

            }

        } while (true);

    }

    static void mostrarMenu() {
        System.out.println("╔═══════════════════════════════════════╗");
        System.out.println("║         Calculo de Areas              ║");
        System.out.println("╠═══════════════════════════════════════╣");
        System.out.println("║ 1. Circulo                            ║");
        System.out.println("║ 2. Triangulo                          ║");
        System.out.println("║ 0. Salir                              ║");
        System.out.println("╚═══════════════════════════════════════╝");
    
    }


}
