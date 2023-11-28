package ud3_ejer11;

import java.net.*;
import java.io.*;

public class HiloServidor extends Thread {
    private Socket socketCliente;

    public HiloServidor(Socket socket) {
        this.socketCliente = socket;
    }

    public void run() {
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
            PrintWriter salida = new PrintWriter(socketCliente.getOutputStream(), true);

            String inputLine;
            while ((inputLine = entrada.readLine()) != null) {
                System.out.println("Comunico con: " + socketCliente);
                salida.println(inputLine.equals("*") ? "*" : inputLine.toUpperCase());
                if (inputLine.equals("*")) {
                    System.out.println("Fin de la conexión con: " + socketCliente);
                    break;
                }
            }

            salida.close();
            entrada.close();
            socketCliente.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
