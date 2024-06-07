import java.util.Scanner;
import java.util.Random;
public class ahorcado {
 public static void main(String[] args){

    Scanner entrada = new Scanner(System.in);

    String[] palabrasSecretas = {"intelligencia", "java", "mundo", "universo" , "melancolia", "amor"};
    int maxIntentos = 10;
    int intentos = 0;
    boolean palabraRevelada = false;

  // seleccion diferente de palabras a traves de Random
  Random random = new Random();
  String secret = palabrasSecretas[random.nexInt(palabrasSecretas.length)];

    //arreglos:

    char[] letrasAdivinadas = new char[Secret.length()];

    for (int i = 0; i < letrasAdivinadas.length; i++) {
        letrasAdivinadas[i] = '_';
    } 

    while(!palabraRevelada && intentos < maxIntentos){

        System.out.println("Palabra a adivinar " + String.valueOf(letrasAdivinadas));

        System.out.print("Introduce una letra, por favor: ");
        char letra = Character.toLowerCase(entrada.next().charAt(0));

        boolean letraCorrecta = false;
        for (int i = 0; i < Secret.length(); i++) {
            if(Secret.charAt(i) == letra){
                letrasAdivinadas[i] = letra;
                letraCorrecta = true;
            }
        }
       if(!letraCorrecta){
        intentos++;
        System.out.println("Incorrecto te quedan " + (maxIntentos - intentos) + " intentos.");
       }

       if (String.valueOf(letrasAdivinadas).equals(Secret)){
         palabraRevelada = true;
         System.out.println("Felicidades, has adivinado la palabra secreta: " + Secret);
       }

    }

    if(!palabraRevelada){
        System.out.println("Has perdido, te has quedado sin intentos. GAME OVER");
    }

    entrada.close();
   
 }


}
