package Tarea2;

import java.util.Scanner;

public class CalculadoraBasica {

    public static void ejecutar() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("╔═══════════════════════════════════════╗");
        System.out.println("║         CALCULADORA BÁSICA            ║");
        System.out.println("╠═══════════════════════════════════════╣");
        System.out.println("║ 1. Suma                               ║");
        System.out.println("║ 2. Resta                              ║");
        System.out.println("║ 3. Multiplicación                     ║");
        System.out.println("║ 4. División                           ║");
        System.out.println("║ 0. Salir                              ║");
        System.out.println("╚═══════════════════════════════════════╝");

        System.out.print("Seleccione una opcion: ");
        int opcion = scanner.nextInt();

        if (opcion == 0) {
            return;
        }

        System.out.print("Ingrese el primer numero: ");
        double num1 = scanner.nextDouble();

        System.out.print("Ingrese el segundo numero: ");
        double num2 = scanner.nextDouble();

        double resultado;

        switch (opcion) {

            case 1:
                resultado = num1 + num2;
                System.out.println("Resultado: " + resultado);
                break;

            case 2:
                resultado = num1 - num2;
                System.out.println("Resultado: " + resultado);
                break;

            case 3:
                resultado = num1 * num2;
                System.out.println("Resultado: " + resultado);
                break;

            case 4:
                if (num2 != 0 && num1 != 0) {
                    resultado = num1 / num2;
                    System.out.println("Resultado: " + resultado);
                } else {
                    System.out.println("Error: Division por cero.");
                }
                break;

            default:
                System.out.println("Mira las opciones.");
        }
    }
}


