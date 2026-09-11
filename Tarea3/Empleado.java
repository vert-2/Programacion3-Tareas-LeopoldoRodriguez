package Tarea3;

public abstract class Empleado {

    private String nombre;
    private String apellido;
    private int codigo;
    private int salario;

    public Empleado(String nombre, String apellido, int codigo, int salario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigo = codigo;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public abstract void trabajar();

    @Override 
    public String toString() {
        return "[Empleado] Nombre: " + this.nombre + ", Apellido: " + this.apellido + ", Codigo:" + this.codigo + ", Salario: " + this.salario; 
    }

}
