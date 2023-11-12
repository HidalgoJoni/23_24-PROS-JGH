package ud3_ejer6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) {
        int puerto = 6010;
        String direccion = "localhost";

        try (Socket socket = new Socket(direccion, puerto);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("PROGRAMA CLIENTE INICIANDO");
            System.out.print("Introduce un número: ");
            String numero = stdIn.readLine();
            out.println(numero);

            String respuesta = in.readLine();
            System.out.println("Recibiendo mensaje del servidor:");
            System.out.println("\t" + respuesta);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

