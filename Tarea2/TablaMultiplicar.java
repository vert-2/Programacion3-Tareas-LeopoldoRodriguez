package Tarea2;
import java.util.Scanner;

public class TablaMultiplicar {
   
    public static void ejecutar() {
        Scanner scanner = new Scanner(System.in);
        
            System.out.print("Ingrese un numero: ");
            int numero = scanner.nextInt();

            if (numero <= 0) {
                System.out.println("El numero debe ser positivo.");
                return;
            } else{
                System.out.println("Tabla de multiplicar del " + numero);
        
               for (int i = 1; i <= 10; i++) {
                int resultado = numero * i;
                System.out.println(numero + " x " + i + " = " + resultado);
              }


           }   
    }

}
