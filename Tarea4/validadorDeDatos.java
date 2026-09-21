package Tarea4;

import java.util.Scanner;

public class validadorDeDatos {
    
    public static void ejecutar() {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            mostrarMenu();

            System.out.print("Seleccione una opcion: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    probarCasos();
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Epagueti blanco");
            }
        }
    }

    public static String validarEstudiante(String nombre,String matricula,String correo) {
        String errores = "";

        if (nombre == null || nombre.trim().isEmpty()) {
            errores += "- El nombre no puede estar vacio.\n";
        } else {
            String[] palabras = nombre.trim().split("\\s+");

            if (palabras.length < 2) {
                errores += "- El nombre debe tener al menos 2 palabras.\n";
            }
        }

        
        if (matricula == null
                || !matricula.startsWith("202")
                || matricula.length() != 9) {

            errores += "- La matricula debe comenzar con 202 "
                    + "y tener exactamente 9 caracteres.\n";
        }

        
        if (correo == null
                || !correo.contains("@")
                || !correo.endsWith(".edu")) {

            errores += "- El correo debe contener @ "
                    + "y terminar en .edu.\n";
        }

        if (errores.isEmpty()) {
            return "Datos validos.";
        }

        return "Datos invalidos:\n" + errores;
    }

    public static void probarCasos() {

        System.out.println("\n========== CASO 1 ==========");

        System.out.println(validarEstudiante("Juan Perez","2024-1234","juan@universidad.edu"));

        System.out.println("\n========== CASO 2 ==========");

        System.out.println(validarEstudiante("Ana","2024-1234","ana@universidad.edu"));

        System.out.println("\n========== CASO 3 ==========");

        System.out.println(validarEstudiante("Carlos Ruiz","1234-5678","carlos@gmail.com"));  
        
        
    }

    public static void mostrarMenu() {

        System.out.println("╔═══════════════════════════════════════╗");
        System.out.println("║       MENU DE VALIDACION              ║");
        System.out.println("╠═══════════════════════════════════════╣");
        System.out.println("║ 1. Probar casos de estudiantes        ║");
        System.out.println("║ 0. Salir                              ║");
        System.out.println("╚═══════════════════════════════════════╝");
    }
}

