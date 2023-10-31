package ud3_1al3;

//Importamos la clase InetAddress del paquete java.net
import java.net.InetAddress;
import java.net.UnknownHostException;

//Definimos la clase principal Actividad2
public class Actividad2 {
// Método principal del programa
	public static void main(String[] args) {
		// Comprobamos si se ha pasado algún parámetro en la línea de comandos
		if (args.length == 0) {
			// Si no se ha pasado ningún parámetro, se imprime un mensaje de error
			System.out.println("Se necesita una URL para obtener su dirección");
		} else {
			// Si se ha pasado algún parámetro, se toma el primero como el dominio a
			// consultar
			String domain = args[0];

			try {
				// Obtenemos todas las direcciones IP asociadas al dominio proporcionado
				InetAddress[] addresses = InetAddress.getAllByName(domain);

				// Imprimimos las direcciones obtenidas
				System.out.println("Las direcciones asociadas a " + domain + " son:");
				for (InetAddress address : addresses) {
					System.out.println(address);
				}
			} catch (UnknownHostException e) {
				// Si no se puede encontrar el dominio, se imprime un mensaje de error
				System.out.println("No se pudo encontrar el dominio especificado.");
			}
		}
	}
}
