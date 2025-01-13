import java.lang.*;
import java.io.*;
import java.net.*;
import java.util.*

public class Servidor {

    public static void main(String []args){

        ServerSocket serverAddr = null;

        Socket sc = null;
        Byte op;
        int n1,n2;
        int respuesta;

        try {
            serverAddr = new ServerSocket(4200);
        } 
        catch (Exception e){
            System.out.println("error creando el socket" + e.getMessage());
        }

        while (true){
            try {
                sc = serverAddr.Accept(); //espera la conexion aceptada al servidor

                DataInputStream is = new DataInputStream(sc.getInputStream);
                DataOutputStream out = new DataOutputStream(sc.getOutputStream);

                op = is.readByte();
                n1 = is.readInt();
                n2 = is.readInt();

                if (op == 0){
                    respuesta = n1 + n2;
                } else {
                    respuesta = n1-n2;
                }

                out.flush();
                sc.close();


            } catch (Exception e) {
                    System.out.println("error en las operaciones" + e.getMessage());
            }
        }
    }


}