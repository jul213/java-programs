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
            System.out.println("error creando el socket");
        }

        while (true){
            try {
                sc = serverAddr.Accept();

                DataInputStream is = new DataInputStream(sc.getInputStream);
                DataOutputStream out = new DataOutputStream(sc.getOutputStream);

            }
        }
    }


}