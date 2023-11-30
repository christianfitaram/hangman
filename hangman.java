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
        boolean control = true, juego = true;
        do {
            System.out.println("Bienvenido al juego, introduce una palabra: ");
            palabra = in.nextLine();
            longitud = palabra.length();
            control = true;
            String palabraNueva = "";
            int errores = 0;
            String registroInc = "";
            String registroCor = "";
            char letraIn;
            for (int i = 1; i <= longitud; i++) {
                palabraNueva += "-";
            }
            while (control == true) {

                System.out.println("Tienes " + (7 - errores) + " intentos");

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
                    System.out.println("Letra equivocada.");
                }
                if (errores == 7) {
                    System.out.println("Has agotado todos tus intentos");
                    control = false;
                    System.out.println("Deseas volver a jugar y/n");
                    char respuesta = in.nextLine().charAt(0);
                    if (respuesta == 'y' || respuesta == 'Y') {
                        juego = true;
                        
                    } else if (respuesta == 'n' || respuesta == 'N') {
                        System.out.println("Muchas gracias por jugar. Adios");
                        juego = false;
                        control = false;
                    }

                }
                if (palabra.equals(palabraNueva)) {
                    System.out.println("Has ganado");
                    System.out.println("La palabra era: " + palabra);
                    control = false;
                    System.out.println("Deseas volver a jugar y/n");
                    char respuesta = in.nextLine().charAt(0);
                    if (respuesta == 'y' || respuesta == 'Y') {
                        juego = true;

                    } else if (respuesta == 'n' || respuesta == 'N') {
                        System.out.println("Muchas gracias por jugar. Adios");
                        juego = false;
                        control = false;
                    }
                }
            }
        } while (juego == true);

    }
}
