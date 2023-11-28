package ud3_ejer11;

import java.io.*;
import java.net.*;

public class Cliente {
    public static void main(String[] args) throws IOException {
        InetAddress direccionServidor = InetAddress.getByName("localhost");
        Socket socketCliente = new Socket(direccionServidor, 6000);

        try {
            BufferedReader entradaTeclado = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter salida = new PrintWriter(socketCliente.getOutputStream(), true);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));

            String userInput;
            System.out.println("PROGRAMA CLIENTE INICIANDO\nIntroduce una cadena:");
            while ((userInput = entradaTeclado.readLine()) != null) {
                salida.println(userInput);
                System.out.println("=>Respuesta: " + entrada.readLine());
                if (userInput.equals("*")) {
                    System.out.println("Fin del envío....");
                    break;
                }
                System.out.println("Introduce cadena:");
            }
        } finally {
            socketCliente.close();
        }
    }
}