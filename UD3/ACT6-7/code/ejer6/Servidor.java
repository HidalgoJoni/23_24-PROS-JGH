package ud3_ejer6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        int puerto = 6010;

        try (ServerSocket serverSocket = new ServerSocket(puerto);
             Socket clientSocket = serverSocket.accept();
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            System.out.println("Esperando al cliente.....");
            
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                int numero = Integer.parseInt(inputLine);
                int resultado = numero * numero;
                out.println("El cuadrado del número " + numero + " es " + resultado);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

