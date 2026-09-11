package Tarea3;

public class Main {

    public static void main(String[] args) {
        
        PersonalAdministrativo personalAdmin = new PersonalAdministrativo("Juan", "Perez", 123, 25000, "Recursos Humanos", "Asistente");
        PersonalMantenimiento personalMantenimiento = new PersonalMantenimiento("Maria", "Gomez", 456, 20000, "Equipos Electricos");
        Profesor profesor1 = new Profesor("Lariel", "Reynoso", 789, 15000, "Matematicas", 5);
        Profesor profesor2 = new Profesor("Sara", "Rodriguez", 900, 13000, "Español", 5);
        Profesor profesor3 = new Profesor("James", "Peña", 007, 16000, "Informatica", 5);
        Profesor profesor4 = new Profesor("Carmen", "Rosa", 000, 13000, "Frances", 5);
        Profesor profesor5 = new Profesor("Papolo", "Hazim", 999, 14000, "Ciencias Sociales", 5);
        Profesor profesor6 = new Profesor("Rubirosa", "Garcia", 606, 10500, "Ed. Fisica", 5);

        Empleado[] empleados = {personalAdmin, personalMantenimiento, profesor1, profesor2, profesor3, profesor4, profesor5, profesor6};

        for (Empleado empleado : empleados) {
            System.out.println(empleado.getClass());
            System.out.println("-" + empleado);
            if (empleado instanceof Bonificable) {
                double bono = ((Bonificable) empleado).calcularBono();
                System.out.println("El empleado " + empleado.getNombre() + " " + empleado.getApellido() + " ha recibido un bono de: " + bono);
            }
            System.out.println();
            empleado.trabajar();
            System.out.println();
        }

    
    }
    
}
