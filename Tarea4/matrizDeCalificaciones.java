package Tarea4;

import java.util.Scanner;

public class matrizDeCalificaciones {

    private static String[] nombres = {
        "Ana", "Luis", "Maria", "Carlos"
    };

    private static double[][] parciales = {
        {8.5, 9.0, 7.5},
        {6.0, 5.5, 7.0},
        {9.0, 8.5, 9.5},
        {4.5, 6.0, 5.0}
    };

    public static void ejecutar() {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            mostrarMenu();

            System.out.print("Seleccione una opcion: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    mostrarReporteCompleto(nombres, parciales);
                    break;

                case 0:
                    return;

                default:
                    System.out.println("._.");
            }
        }
    }

    public static void mostrarReporteCompleto(
            String[] nombres,
            double[][] parciales) {

        double[] promedios = new double[nombres.length];

        int aprobados = 0;
        int reprobados = 0;

        int indiceMejor = 0;
        int indicePeor = 0;

        for (int i = 0; i < nombres.length; i++) {

            double suma = 0;

            for (int j = 0; j < parciales[i].length; j++) {
                suma += parciales[i][j];
            }

            promedios[i] = suma / parciales[i].length;

            if (promedios[i] >= 6.0) {
                aprobados++;
            } else {
                reprobados++;
            }

            if (promedios[i] > promedios[indiceMejor]) {
                indiceMejor = i;
            }

            if (promedios[i] < promedios[indicePeor]) {
                indicePeor = i;
            }
        }

        System.out.println("\n╔════════════╦════════════╦════════════╦════════════╦════════════╗");
        System.out.println("║ Estudiante ║ Parcial 1  ║ Parcial 2  ║ Parcial 3  ║ Promedio   ║");
        System.out.println("╠════════════╬════════════╬════════════╬════════════╬════════════╣");

        for (int i = 0; i < nombres.length; i++) {

            System.out.printf(
                    "║ %-10s ║ %-10.2f ║ %-10.2f ║ %-10.2f ║ %-10.2f ║%n",
                    nombres[i],
                    parciales[i][0],
                    parciales[i][1],
                    parciales[i][2],
                    promedios[i]
            );
        }

        System.out.println("╚════════════╩════════════╩════════════╩════════════╩════════════╝");

        System.out.println("\nPROMEDIO DE CADA PARCIAL");

        for (int parcial = 0; parcial < 3; parcial++) {

            double sumaParcial = 0;

            for (int estudiante = 0;
                    estudiante < parciales.length;
                    estudiante++) {

                sumaParcial += parciales[estudiante][parcial];
            }

            double promedioParcial = sumaParcial / parciales.length;

            System.out.printf(
                    "Promedio del parcial %d: %.2f%n",
                    parcial + 1,
                    promedioParcial
            );
        }

        System.out.printf(
                "%nMejor estudiante: %s - %.2f%n",
                nombres[indiceMejor],
                promedios[indiceMejor]
        );

        System.out.printf(
                "Peor estudiante: %s - %.2f%n",
                nombres[indicePeor],
                promedios[indicePeor]
        );

        System.out.println("Estudiantes aprobados: " + aprobados);
        System.out.println("Estudiantes reprobados: " + reprobados);
    }

    public static void mostrarMenu() {

        System.out.println("╔═══════════════════════════════════════╗");
        System.out.println("║       MENU DE CALIFICACIONES          ║");
        System.out.println("╠═══════════════════════════════════════╣");
        System.out.println("║ 1. Mostrar reporte completo           ║");
        System.out.println("║ 0. Salir                              ║");
        System.out.println("╚═══════════════════════════════════════╝");
    }
}