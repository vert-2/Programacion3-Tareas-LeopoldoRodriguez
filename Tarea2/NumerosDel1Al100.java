package Tarea2;


public class NumerosDel1Al100 {

    public static void ejecutar() {
       

       System.out.println("Numeros del 1 al 100:");

      for (int i = 1; i <= 100; i++) {

        if (i % 3 == 0 && i % 5 == 0) {
            System.out.println(i + " FizzBuzz ");

        } else if (i % 3 == 0) {
            System.out.println(i + " Fizz ");

        } else if (i % 5 == 0) {
            System.out.println(i + " Buzz ");

        } else {
            System.out.println(i);
        }
      }

      
   }
}
