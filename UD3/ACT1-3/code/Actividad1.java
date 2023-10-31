package ud3_1al3;

//Importamos la clase InetAddress del paquete java.net
import java.net.InetAddress;
import java.net.UnknownHostException;

//Definimos la clase principal Actividad1
public class Actividad1 {
// Método principal del programa
	public static void main(String[] args) {
		try {
			// Obtenemos todas las direcciones IP asociadas al dominio "www.spotify.com"
			InetAddress[] addresses = InetAddress.getAllByName("www.spotify.com");

			// Imprimimos las direcciones obtenidas
			System.out.println("Direcciones asociadas a Spotify:");
			for (InetAddress address : addresses) {
				System.out.println(address);
			}
		} catch (UnknownHostException e) {
			// Si no se puede encontrar el dominio, se imprime un mensaje de error
			System.out.println("No se pudo encontrar el dominio especificado.");
		}
	}
}
