package Tarea2;
import java.util.Scanner;

public class ParImpar {
  
    public static void ejecutar() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese un numero entero:");
        int numero = scanner.nextInt();

        if (numero % 2 == 0) {
            System.out.println("El numero " + numero + " es par.");
        } else {
            System.out.println("El numero " + numero + " es impar.");
        }
    
        if (numero > 0) {
        System.out.println("El numero " + numero + " es positivo.");
        } else if (numero < 0) {
        System.out.println("El numero " + numero + " es negativo.");
        } else {
        System.out.println("El numero es cero.");
       }
    }
}
