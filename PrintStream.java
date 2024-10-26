public class Main {
    public static void main(){
        try { 
            InputStream in = new FileInputStream("ruta del fichero a leer");
            byte []datos = in.readAllBytes();  //leer fichero

            PrintSream out = new PrintStream("destino.txt"); // copiar fichero 
            out.write(datos);

        } catch (Exception e){
            System.out.println("Excepcion" + e.getMessage());
        }
    }
}