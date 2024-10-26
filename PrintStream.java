public class Main {
    public static void main(){
        try { 
            InputStream in = new FileInputStream("ruta del fichero a leer");
            byte []datos = in.readAllBytes();  //leer fichero
            in.close(); //buena practica cerrar fichero

            PrintSream out = new PrintStream("destino.txt"); // copiar fichero 
            out.write(datos);
            out.close(); // cerramos fichero

        } catch (Exception e){
            System.out.println("Excepcion" + e.getMessage());
        }
    }
}