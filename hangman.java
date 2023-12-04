package hangman;

import java.util.Scanner;

/**
 *
 * @author christianfita
 */
public class hangman {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        // boolean of contol initialized.
        boolean juego = true;

        // do while that contains the whole game.
        do {
            // Ask for a word.
            System.out.println("Bienvenido al juego, introduce una palabra: ");
            String palabra = in.nextLine();

            // Word is trimmed to avoid errors.
            palabra = palabra.trim();

            // lenght of word is stored
            int longitud = palabra.length();

            // boolean of control for loop that counts tries and errors
            boolean control = true;

            // variable that stores number of errors
            int errores = 0;

            // variable that stores incorrect letters
            String registroInc = "";

            // variable that stores correct letters
            String registroCor = "";

            // variable which stores dashes as much as there is letter the original word.
            String palabraNueva = "";
            for (int i = 1; i <= longitud; i++) {
                palabraNueva += '_';
            }
            System.out.println(palabraNueva);

            // loop of tries and errors
            while (control == true) {
                // print number of tries left.
                System.out.println("Tienes " + (7 - errores) + " intentos");

                // print a draw according numbers of mistakes.
                if (errores == 1) {

                    System.out.println("====");
                }
                if (errores == 2) {
                    System.out.println("====");
                    System.out.println(" |");
                    System.out.println(" |");
                }
                if (errores == 3) {
                    System.out.println("====");
                    System.out.println(" |");
                    System.out.println(" |");
                    System.out.println(" O");
                }
                if (errores == 4) {
                    System.out.println("====");
                    System.out.println(" |");
                    System.out.println(" |");
                    System.out.println(" O");
                    System.out.println(" |");
                }
                if (errores == 5) {
                    System.out.println("====");
                    System.out.println(" |");
                    System.out.println(" |");
                    System.out.println(" O");
                    System.out.println("/|");
                }

                if (errores == 6) {
                    System.out.println("====");
                    System.out.println(" |");
                    System.out.println(" |");
                    System.out.println(" O");
                    System.out.println("/|\\");
                }
                if (errores == 7) {
                    System.out.println("====");
                    System.out.println(" |");
                    System.out.println(" |");
                    System.out.println(" O");
                    System.out.println("/|\\");
                    System.out.println(" ^");
                }
                // Ask for a letter
                System.out.println("Introduce una letra: ");
                char letraIn = in.nextLine().charAt(0);
                // Verifyng that introduced letter is not empty.
                while (letraIn == ' ') {
                    System.out.println("Introduce un caracter válido");
                    letraIn = in.nextLine().charAt(0);
                }

                // Verifying that introduced letter is in the original word.
                if (palabra.indexOf(letraIn) > -1) {
                    registroCor = registroCor + letraIn;

                    // In case the letter is in the original word will replace dashes for said
                    // letter
                    for (int i = 0; i < longitud; i++) {
                        if (palabra.charAt(i) == letraIn)
                            palabraNueva = palabraNueva.substring(0, i) + letraIn
                                    + palabraNueva.substring((i + 1), (longitud));
                    }
                    // Shows replaced dashes for said letter
                    System.out.println(palabraNueva);
                    // In case this letter is incorrect and has already been introduced will show a
                    // message.
                } else if (registroInc.indexOf(letraIn) > -1) {
                    System.out.println("Ya has intentando con la letra " + letraIn + " prueba otra.");
                    // In case an incorrect letter is introduced for the first time will add an
                    // error and stores said letter.
                } else {
                    errores++;
                    registroInc += letraIn;
                    System.out.println("Letra equivocada.");
                }
                // In cases numbers of errors reach 7.
                if (errores == 7) {
                    System.out.println("Has agotado todos tus intentos");
                    System.out.println("La palabra era: " + palabra);
                    control = false;

                    // Ask if play again.
                    System.out.println("Deseas volver a jugar y/n");
                    String respuesta = in.nextLine();
                    respuesta = respuesta.toLowerCase();
                    char charRespuesta = respuesta.charAt(0);
                    //Verifyng if introduced character is valid.
                    while (charRespuesta == ' ' || (charRespuesta != 'y' && charRespuesta != 'n')) {
                        System.out.println("Introduce un caracter valido:");
                        respuesta = in.nextLine();
                        respuesta = respuesta.toLowerCase();
                        charRespuesta = respuesta.charAt(0);
                    }
                    //Exiting the game or play again
                    if (charRespuesta == 'y') {
                        juego = true;

                    } else if (charRespuesta == 'n') {
                        System.out.println("Muchas gracias por jugar. Adios");
                        juego = false;
                        control = false;
                    }

                }

                // If word is guessed
                if (palabra.equals(palabraNueva)) {
                    System.out.println("Has ganado");
                    System.out.println("La palabra era: " + palabra);
                    control = false;

                    // Ask if play again.
                    System.out.println("Deseas volver a jugar y/n");
                    String respuesta = in.nextLine();
                    respuesta = respuesta.toLowerCase();
                    char charRespuesta = respuesta.charAt(0);
                    //Verifyng if introduced character is valid.
                    while (charRespuesta == ' ' || (charRespuesta != 'y' && charRespuesta != 'n')) {
                        System.out.println("Introduce un caracter valido:");
                        respuesta = in.nextLine();
                        respuesta = respuesta.toLowerCase();
                        charRespuesta = respuesta.charAt(0);
                    }
                    //Exiting the game or play again
                    if (charRespuesta == 'y') {
                        juego = true;

                    } else if (charRespuesta == 'n') {
                        System.out.println("Muchas gracias por jugar. Adios");
                        juego = false;
                        control = false;
                    }
                }
            }
        } while (juego == true);

    }
}
