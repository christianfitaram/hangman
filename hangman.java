package hangman;

import java.util.Scanner;

/**
 *
 * @author christianramirez
 */
public class hangman {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String palabra;
        int longitud;
        int errores = 0;
        String palabraNueva = "";
        String registroInc = "";
        String registroCor = "";
        boolean control = true;
        char letraIn;

        System.out.println("Bienvenido al juego, introduce una palabra: ");
        palabra = in.nextLine();
        longitud = palabra.length();

        while (control == true) {

            System.out.println("Tienes " + (7 - errores) + " intentos");

            for (int i = 1; i <= longitud; i++) {
                palabraNueva += "-";

            }

            System.out.println("Introduce una letra: ");
            letraIn = in.nextLine().charAt(0);

            if (palabra.indexOf(letraIn) > -1) {
                registroCor = registroCor + letraIn;

                for (int i = 0; i < longitud; i++) {
                    if (palabra.charAt(i) == letraIn)
                        palabraNueva = palabraNueva.substring(0, i) + letraIn
                                + palabraNueva.substring((i + 1), (longitud));
                }
                System.out.println(palabraNueva);
            } else if (registroInc.indexOf(letraIn) > -1) {
                System.out.println("Ya has intentando con la letra " + letraIn + " prueba otra.");
            } else {
                errores++;
                registroInc += letraIn;
                System.out.println(errores);
            }
            if (errores == 7) {
                control = false;
            }
        }

    }
}
