package Tarea2;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
        
    do {
            mostrarMenu();
            System.out.print("Seleccione una opcion: ");
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    CalculadoraBasica.ejecutar();
                    break;
                case 2:
                    ParImpar.ejecutar();
                    break;
                case 3:
                    TablaMultiplicar.ejecutar();
                    break;
                case 4:
                    NumerosDel1Al100.ejecutar();
                    break;
                case 5:
                    Persona.ejecutar();
                    break;
                case 6:
                    Rectangulo.ejecutar();
                    break;
                case 7:
                    Empleado.ejecutar();
                    break;
                case 8:
                    Figura.ejecutar();
                    break;
                case 9:
                    ContadorVocales.ejecutar();
                    break;
                case 10:
                    Estudiante.ejecutar();
                    break;
                case 0:
                    System.out.println("Adieu");
                    return;
                default:
                    System.out.println("Muchacho eso no va.");
            }
        } while (true);
      }
    

        static void mostrarMenu() {
        System.out.println("╔═══════════════════════════════════════╗");
        System.out.println("║         MENU DE EJERCICIOS            ║");
        System.out.println("╠═══════════════════════════════════════╣");
        System.out.println("║ 1. Calculadora básica                 ║");
        System.out.println("║ 2. Par o impar                        ║");
        System.out.println("║ 3. Tabla de multiplicar               ║");
        System.out.println("║ 4. Números del 1 al 100               ║");
        System.out.println("║ 5. Clase Persona                      ║");
        System.out.println("║ 6. Clase Rectángulo                   ║");
        System.out.println("║ 7. Clase Empleado (herencia)          ║");
        System.out.println("║ 8. Clase Figura (polimorfismo)        ║");
        System.out.println("║ 9. Contador de vocales                ║");
        System.out.println("║ 10. Calculadora de notas              ║");
        System.out.println("║ 0. Salir                              ║");
        System.out.println("╚═══════════════════════════════════════╝");
    
    }
}
