package ud3_ejer8;

import java.net.*;
import java.nio.ByteBuffer;
import java.io.*;

public class Cliente {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(34568);
        InetAddress address = InetAddress.getByName("localhost");
        byte[] buf;

        try {
            int numero = 4; // Puedes cambiar este valor dentro del rango especificado
            buf = ByteBuffer.allocate(4).putInt(numero).array();
            DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 12346);
            socket.send(packet);
            System.out.println("Esperando respuesta...");

            packet = new DatagramPacket(buf, buf.length);
            socket.receive(packet);
            int resultado = ByteBuffer.wrap(packet.getData()).getInt();
            System.out.println("Esperando respuesta...: el cubo de " + numero + " es " + resultado);
        } finally {
            System.out.println("Adiós…");
            socket.close();
        }
    }
}
