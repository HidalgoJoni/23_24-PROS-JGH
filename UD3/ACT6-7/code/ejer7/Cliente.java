package ud3_ejer7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 6013;

        try (Socket socket = new Socket(host, puerto);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            System.out.println("PROGRAMA CLIENTE INICIANDO");

            String respuesta = in.readLine();
            System.out.println("Recibiendo mensaje del servidor:");
            System.out.println("\t" + respuesta);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

