import java.net.*;
import java.io.*;

public class Address {
    public static void main(String []args){

        try {
            InetAddress host = InetAddress.getLocalHost();
            System.out.println("host: " + host.getHostName());

        } catch (UnknownHostException e) {
            System.out.println("error al obtener la direccion");
        }

        try {
            InetAddress host = InetAddress.getByName("www.google.es");
            System.out.println("Host: " + host.getHostAddress());

        } catch (UnknownHostException e) {
            System.out.println("error al obtener la direccion");
        }

        try {
            InetAddress host = InetAddress.getByName("170.50.10.130");
            System.out.println("Host: " + host.getHostName() );

        } catch (UnknownHostException e) {
            System.out.println("error al obtener la direccion");
        }
    }
}