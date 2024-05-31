/* anagramas ejercisio 2 programa
 * Escribe una función que reciba dos palabras (String) y retorne
 * verdadero o falso (Bool) según sean o no anagramas.
 * - Un Anagrama consiste en formar una palabra reordenando TODAS
 *   las letras de otra palabra inicial.
 * - NO hace falta comprobar que ambas palabras existan.
 * - Dos palabras exactamente iguales no son anagrama.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class problema2{
    public static boolean esAnagrama(String f1, String f2) {
        f1 = f1.toLowerCase().trim();
        f2 = f2.toLowerCase().trim();



        Map<Character,Integer> contadorPalabras = new HashMap<>();

        for(char letra: f1.toCharArray()){
            int conteoActual = contadorPalabras.getOrDefault(letra, 0);
            contadorPalabras.put(letra, conteoActual + 1 );
        }

        for(char letra: f2.toCharArray()){
            int conteoActual = contadorPalabras.getOrDefault(letra, 0);
            if (conteoActual == 0){ // significa que  la letra de conteo actual es inexistente por lo que no se usa en f2;
                return false;
            }
            contadorPalabras.put(letra, conteoActual - 1);
        }

        for(int conteo : contadorPalabras.values()){
            if (conteo != 0){ // si hay un conteo es mayor que 0 significa que una letra de f1 no se uso por lo cual no es un anagrama;
                return false;
            }
        return true;
        }
        return false;
        }


        public static void main(String[] args) {
            Scanner entrada = new Scanner(System.in);
            System.out.println("ingrese la primera palabra ususario");
            String f1 = entrada.nextLine();

            System.out.println("ingrese la segunda palabra usuario");
            String f2 = entrada.nextLine();

            if(esAnagrama(f1, f2)){
                System.out.println(f1 + "y" + f2 + " son anagramas");
            } else{
                System.out.println(f1 + "y" + f2 + " no son anagramas");
            }


        }
    

    
    
}
