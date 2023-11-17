package ud3_ejer8;

import java.net.*;
import java.nio.ByteBuffer;
import java.io.*;

public class Servidor {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(12346);
        byte[] buf = new byte[4];

        try {
            System.out.println("Esperando datagrama...");

            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            socket.receive(packet);
            int numero = ByteBuffer.wrap(packet.getData()).getInt();

            System.out.println("Vamos a calcular el cubo de: " + numero);
            System.out.println("IP de origen: /" + packet.getAddress().getHostAddress());
            System.out.println("Puerto de origen: " + packet.getPort());

            int resultado = numero * numero * numero;
            buf = ByteBuffer.allocate(4).putInt(resultado).array();
            InetAddress address = packet.getAddress();
            int port = packet.getPort();
            packet = new DatagramPacket(buf, buf.length, address, port);
            socket.send(packet);
            System.out.println("Enviamos el resultado..." + resultado);
        } finally {
            System.out.println("Adiósss");
            socket.close();
        }
    }
}

