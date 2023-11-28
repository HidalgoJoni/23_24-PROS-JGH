package ud3_ejer11;

import java.net.*;
import java.io.*;

public class Servidor {
    public static void main(String[] args) throws IOException {
        ServerSocket servidor = new ServerSocket(6000);
        System.out.println("Servidor iniciado...");

        try {
            while (true) {
                Socket socketCliente = servidor.accept();
                System.out.println("Cliente Conectado.....");
                new HiloServidor(socketCliente).start();
            }
        } finally {
            servidor.close();
        }
    }
}