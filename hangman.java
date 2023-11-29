package hangman;
import java.util.Scanner;

/**
 *
 * @author christianramirez
 */
public class hangman {
    public static void main(String[] args) {
        String palabra = "animal";
        String palabraNueva = "";
        int longitud = palabra.length();
        
        for(int i=1 ; i<=longitud; i++ ){
        palabraNueva+="-";
        
        }
        System.out.println(palabraNueva);
    }
    
}