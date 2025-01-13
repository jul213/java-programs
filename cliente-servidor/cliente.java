import java.lang.*;
import java.util.*;
import java.net.*;
import java.io.*;

public class cliente {

    public static void main(String []args) {
        Byte op;
        int n1,n2;
        int respuesta;

        if (args.length != 1) {
            System.out.println("Uso: cliente <Host>");
            System.exit(0);
        }

        try {
            String host = args[0];
            Socket sc = new Socket(host, 4200);

            DataInputStream inc = new DataInputStream(sc.getInputStream());
            DataOutputStream outc = new DataOutputStream(sc.getOutputStream());

            op = 0;
            n1 = 5;
            n2 = 2;

            outc.writeByte(op);
            outc.writeInt(n1);
            outc.writeInt(n2);
            outc.flush();

            respuesta = inc.readInt();

            System.out.println("la suma es" + respuesta);

            sc.close();
        } catch (Exception e) {
            System.out.println("error en cliente.java en el proceso de respuesta" + e.getMessage());
        }
    }
}
