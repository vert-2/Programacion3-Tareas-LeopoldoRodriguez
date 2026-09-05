package Tarea2;
import java.util.Scanner;

public class Estudiante {

    private String nombre;
    private double[] notas;

    public Estudiante(String nombre, double[] notas) {
        this.nombre = nombre;
        this.notas = notas;
    }

    public double calcularPromedio() {
        double suma = 0;
        for (double nota : notas) {
            suma += nota;
        }
        return suma / notas.length;
    }

    public String obtenerCalificacion(){
        if(calcularPromedio() >= 60){
            return "Aprobado";
        } else {
            return "Reprobado";
        }
    }

    public static void ejecutar() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del estudiante: ");
        String nombre = scanner.nextLine();

        double[] notas = new double[5];

        for (int i = 0; i < 5; i++) {

            System.out.print("Ingrese la nota " + (i + 1) + ": ");
            notas[i] = scanner.nextDouble();
        }

        Estudiante estudiante = new Estudiante(nombre, notas);

        System.out.println("\nNombre del estudiante: " + estudiante.nombre);
        System.out.println("Promedio: " + estudiante.calcularPromedio());
        System.out.println("Calificacion: " + estudiante.obtenerCalificacion());
    }

}
