package Tarea2;

public class ContadorVocales {

    public static void ejecutar(){

        System.out.print("Ingrese un texto: ");
        String texto = System.console().readLine();

        int contador = 0;
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                contador++;
            }
        }

        System.out.println("El numero de vocales en este string es: " + contador);

    }
}


