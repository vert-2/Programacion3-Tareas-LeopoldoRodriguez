package Tarea4;

import java.util.Scanner;
import java.util.StringTokenizer;

public class procesadorCSV {

    private static String datos =
            "Juan Perez,juanp@empresa.com,Sistemas,35000\n"
          + "Ana Lopez,anal@empresa.com,Contabilidad,28000\n"
          + "Carlos Ruiz,carlosr@gmail.com,Sistemas,42000\n"
          + "Maria Diaz,mariad@empresa.com,RRHH,31000\n"
          + "Luis Marte,luism@gmail.com,Sistemas,38000";

    public static void ejecutar() {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            mostrarMenu();

            System.out.print("Seleccione una opcion: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    mostrarTodosLosEmpleados(datos);
                    break;

                case 2:
                    mostrarEmpleadosSistemas(datos);
                    break;

                case 3:
                    mostrarCorreosEmpresa(datos);
                    break;
                
                case 4:
                    mostrarResumenSalarios(datos);
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Opcion no valida.");
            }
        }
    }

    public static String[] separarEmpleado(String fila) {

        StringTokenizer tokenizer =
                new StringTokenizer(fila, ",");

        String[] empleado = new String[4];

        int posicion = 0;

        while (tokenizer.hasMoreTokens()) {
            empleado[posicion] = tokenizer.nextToken();
            posicion++;
        }

        return empleado;
    }

    public static void mostrarTodosLosEmpleados(String datos) {

        String[] filas = datos.split("\\n");

        System.out.println("\nTODOS LOS EMPLEADOS");

        System.out.printf("%-20s %-25s %-18s %-10s%n",
                "Nombre", "Correo", "Departamento", "Salario");

        for (int i = 0; i < filas.length; i++) {

            String[] empleado = separarEmpleado(filas[i]);

            System.out.printf("%-20s %-25s %-18s $%-10.2f%n",
                    empleado[0].toUpperCase(),
                    empleado[1],
                    empleado[2],
                    Double.parseDouble(empleado[3]));
        }
    }

    public static void mostrarEmpleadosSistemas(String datos) {

        String[] filas = datos.split("\\n");

        System.out.println("\nEMPLEADOS DE SISTEMAS");

        for (int i = 0; i < filas.length; i++) {

            String[] empleado = separarEmpleado(filas[i]);

            if (empleado[2].equalsIgnoreCase("Sistemas")) {
                System.out.println("- " + empleado[0]);
            }
        }
    }

    public static void mostrarCorreosEmpresa(String datos) {

        String[] filas = datos.split("\\n");

        System.out.println("\nEMPLEADOS CON CORREO @empresa.com");

        for (int i = 0; i < filas.length; i++) {

            String[] empleado = separarEmpleado(filas[i]);

            if (empleado[1].endsWith("@empresa.com")) {
                System.out.println("- " + empleado[0]
                        + " - " + empleado[1]);
            }
        }
    }

    

    public static void mostrarResumenSalarios(String datos) {

        String[] filas = datos.split("\\n");

        double totalSalarios = 0;
        double salarioMayor = 0;
        double salarioMenor = 0;

        String empleadoMayor = "";
        String empleadoMenor = "";

        for (int i = 0; i < filas.length; i++) {

            String[] empleado = separarEmpleado(filas[i]);

            double salario = Double.parseDouble(empleado[3]);

            totalSalarios += salario;

            if (i == 0 || salario > salarioMayor) {
                salarioMayor = salario;
                empleadoMayor = empleado[0];
            }

            if (i == 0 || salario < salarioMenor) {
                salarioMenor = salario;
                empleadoMenor = empleado[0];
            }
        }

        double salarioPromedio = totalSalarios / filas.length;

        System.out.printf("%nSalario promedio: $%.2f%n",
                salarioPromedio);

        System.out.printf("Empleado que gana mas: %s - $%.2f%n",
                empleadoMayor, salarioMayor);

        System.out.printf("Empleado que gana menos: %s - $%.2f%n",
                empleadoMenor, salarioMenor);
    }

    public static void mostrarMenu() {

        System.out.println("\n╔══════════════════════════════════════════════╗");
        System.out.println("║             MENU DE DATOS CSV                ║");
        System.out.println("╠══════════════════════════════════════════════╣");
        System.out.println("║ 1. Mostrar todos los empleados               ║");
        System.out.println("║ 2. Mostrar empleados de Sistemas             ║");
        System.out.println("║ 3. Mostrar empleados con correo @empresa.com ║");
        System.out.println("║ 4. Resumen de salarios                       ║");
        System.out.println("║ 0. Salir                                     ║");
        System.out.println("╚══════════════════════════════════════════════╝");
    }
}
