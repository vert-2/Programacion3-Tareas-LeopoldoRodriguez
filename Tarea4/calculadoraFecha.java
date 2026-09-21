package Tarea4;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class calculadoraFecha {

    public static void ejecutar() {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            mostrarMenu();

            System.out.print("Seleccione una opcion: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    mostrarReporte(scanner);
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Navidad de diciembre.");
            }
        }
    }

    public static void mostrarReporte(Scanner scanner) {

        Calendar ahora = Calendar.getInstance();

        System.out.println("\nFECHA Y HORA ACTUAL");
        System.out.println("--------------------");

        System.out.println("Formato 1: "
                + formatearFecha(ahora, "dd/MM/yyyy"));

        System.out.println("Formato 2: "
                + formatearFecha(ahora, "dd-MM-yyyy HH:mm:ss"));

        System.out.println("Formato 3: "
                + formatearFecha(ahora, "yyyy/MM/dd HH:mm"));

        Calendar enNoventaDias = (Calendar) ahora.clone();
        enNoventaDias.add(Calendar.DAY_OF_MONTH, 90);

        System.out.println("\nFecha en 90 dias: "
                + formatearFecha(enNoventaDias, "dd/MM/yyyy"));

        Calendar haceSeisMeses = (Calendar) ahora.clone();
        haceSeisMeses.add(Calendar.MONTH, -6);

        System.out.println("Fecha hace 6 meses: "
                + formatearFecha(haceSeisMeses, "dd/MM/yyyy"));

        System.out.print("\nIngrese su año de nacimiento: ");
        int anioNacimiento = scanner.nextInt();

        int anioActual = ahora.get(Calendar.YEAR);
        int edad = anioActual - anioNacimiento;

        System.out.println("Edad actual aproximada: " + edad + " años");

        Calendar hoy = (Calendar) ahora.clone();
        limpiarHora(hoy);

        Calendar finDeAnio = Calendar.getInstance();
        finDeAnio.set(Calendar.YEAR, anioActual);
        finDeAnio.set(Calendar.MONTH, Calendar.DECEMBER);
        finDeAnio.set(Calendar.DAY_OF_MONTH, 31);
        limpiarHora(finDeAnio);

        long diferencia = finDeAnio.getTimeInMillis()
                - hoy.getTimeInMillis();

        long diasFaltantes = diferencia / (1000 * 60 * 60 * 24);

        System.out.println("Dias que faltan para el 31 de diciembre: "
                + diasFaltantes);
    }

    public static String formatearFecha(
            Calendar fecha,
            String formato) {

        SimpleDateFormat formatoFecha =
                new SimpleDateFormat(formato);

        return formatoFecha.format(fecha.getTime());
    }

    public static void limpiarHora(Calendar fecha) {

        fecha.set(Calendar.HOUR_OF_DAY, 0);
        fecha.set(Calendar.MINUTE, 0);
        fecha.set(Calendar.SECOND, 0);
        fecha.set(Calendar.MILLISECOND, 0);
    }

    public static void mostrarMenu() {

    System.out.println("\n╔═══════════════════════════════════════╗");
    System.out.println("║       CALCULADORA DE FECHAS           ║");
    System.out.println("╠═══════════════════════════════════════╣");
    System.out.println("║ 1. Mostrar calculos de fechas         ║");
    System.out.println("║ 0. Salir                              ║");
    System.out.println("╚═══════════════════════════════════════╝");
    }
}
