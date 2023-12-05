package ud3_ejer10;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;

public class Servidor {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(12348);
        System.out.println("Esperando datagrama.......");

        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        socket.receive(packet);

        ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Tenista tenista = (Tenista) ois.readObject();

        System.out.println("Recibo el objeto: " + tenista);
        System.out.println("IP de origen: " + packet.getAddress());
        System.out.println("Puerto de origen: " + packet.getPort());

        // Modificamos el objeto
        tenista.setApellido("Karlovic");
        tenista.setAltura(208);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(tenista);
        byte[] data = baos.toByteArray();

        InetAddress address = packet.getAddress();
        int port = packet.getPort();
        packet = new DatagramPacket(data, data.length, address, port);
        socket.send(packet);

        System.out.println("Envío el objeto: " + tenista);
        System.out.println("Fin del servidor");

        socket.close();
    }
}

