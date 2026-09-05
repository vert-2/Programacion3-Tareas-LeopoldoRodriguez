package Tarea2;
import java.util.Scanner;
public class Empleado extends Persona{
     
    private double salario;

    public Empleado(String nombre, int edad, String correo, double salario) {
        super(nombre, edad, correo);
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void mostrarDatos(){
        System.out.println("Nombre: " + getNombre());
        System.out.println("Edad: " + getEdad());
        System.out.println("Correo: " + getCorreo());
        System.out.println("Salario: " + getSalario());
        System.out.println("Bono: " + calcularBono());
    }

    public double calcularBono(){
        return salario * 0.10;
    }

    public static void ejecutar() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese el nombre del empleado: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese la edad del empleado: ");
        int edad = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el correo del empleado: ");
        String correo = scanner.nextLine();

        System.out.print("Ingrese el salario del empleado: ");
        double salario = scanner.nextDouble();

        Empleado empleado = new Empleado(nombre, edad, correo, salario);
        System.out.println("Datos del empleado:");
        empleado.mostrarDatos();
    }
}
