package ud3_ejer10;

import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

public class Cliente {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(34567);
        InetAddress address = InetAddress.getByName("localhost");

        Tenista tenista = new Tenista("del Potro", 198);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(tenista);
        byte[] data = baos.toByteArray();

        DatagramPacket packet = new DatagramPacket(data, data.length, address, 12348);
        socket.send(packet);
        System.out.println("Envío el objeto: " + tenista);

        System.out.println("Esperando datagrama.......");
        packet = new DatagramPacket(new byte[1024], 1024);
        socket.receive(packet);

        ByteArrayInputStream bais = new ByteArrayInputStream(packet.getData());
        ObjectInputStream ois = new ObjectInputStream(bais);
        Tenista modifiedTenista = (Tenista) ois.readObject();
        System.out.println("He recibido el objeto: " + modifiedTenista);

        System.out.println("Fin del cliente");
        socket.close();
    }
}

