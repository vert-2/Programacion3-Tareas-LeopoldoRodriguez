package Tarea2;
import java.util.Scanner;

public class Rectangulo {

    private double base;
    private double altura;

    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double calcularArea() {
        return base * altura;
    }

    public double calcularPerimetro() {
        return 2 * (base + altura);
    }

    public static void ejecutar() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la base del rectangulo: ");
        double base = scanner.nextDouble();

        System.out.print("Ingrese la altura del rectangulo: ");
        double altura = scanner.nextDouble();

        Rectangulo rectangulo = new Rectangulo(base, altura);

        System.out.println("Area: " + rectangulo.calcularArea());
        System.out.println("Perimetro: " + rectangulo.calcularPerimetro());
    }

}
