package Tarea3;

public class Profesor extends Empleado {

    private String materia;
    private int horasClase;

    public Profesor(String nombre, String apellido, int codigo, int salario, String materia, int horasClase){
        super(nombre,apellido,codigo,salario);
        this.materia = materia;
        this.horasClase = horasClase;


    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public int getHorasClase() {
        return horasClase;
    }

    public void setHorasClase(int horasClase) {
        this.horasClase = horasClase;
    }

    @Override 
    public void trabajar() {
        System.out.println("El profesor " + getNombre() + " " + getApellido() + " esta trabajando en la materia de " + getMateria() + " con un total de " + getHorasClase() + " horas de clase");
    }

    //El profesor no se llevo el bono en esta perdon profe

    @Override 
    public String toString() {
        return "[Profesor] Nombre: " + getNombre() + ", Apellido: " + getApellido() + ", Codigo:" + getCodigo() + ", Salario: " + getSalario() + ", Materia: " + getMateria() + ", Horas de clase: " + getHorasClase(); 
    }


}
