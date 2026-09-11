package Tarea3;

public class PersonalAdministrativo extends Empleado implements Bonificable {

    private String departamento;

    private String cargo;

    public PersonalAdministrativo(String nombre, String apellido, int codigo, int salario, String departamento, String cargo){

        super(nombre,apellido,codigo,salario);

        this.departamento = departamento;
        this.cargo = cargo;

    }

    public String getDepartamento() {
        return departamento;
    }



    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }



    public String getCargo() {
        return cargo;
    }



    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override 
    public void trabajar() {
        System.out.println("El personal administrativo " + getNombre() + " " + getApellido() + " esta trabajando en el departamento de " + getDepartamento() + " como " + getCargo());
    }

    @Override 
    public double calcularBono() {
        return getSalario() * 0.15;
    }

    @Override 
    public String toString() {
        return "[PersonalAdministrativo] Nombre: " + getNombre() + ", Apellido: " + getApellido() + ", Codigo:" + getCodigo() + ", Salario: " + getSalario() + ", Departamento: " + getDepartamento() + ", Cargo: " + getCargo(); 
    }

    



}
