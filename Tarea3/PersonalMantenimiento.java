package Tarea3;

public class PersonalMantenimiento extends Empleado implements Bonificable{

    private String area;

    public PersonalMantenimiento(String nombre, String apellido, int codigo, int salario, String area){
        super(nombre,apellido,codigo,salario);
        this.area = area;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override 
    public void trabajar() {
        System.out.println("El personal de mantenimiento " + getNombre() + " " + getApellido() + " esta trabajando en el area de " + getArea());
    }

    @Override
    public double calcularBono() {
        return getSalario() * 0.10;
    }

    @Override 
    public String toString() {
        return "[PersonalMantenimiento] Nombre: " + getNombre() + ", Apellido: " + getApellido() + ", Codigo:" + getCodigo() + ", Salario: " + getSalario() + ", Area: " + getArea(); 
    }


}
