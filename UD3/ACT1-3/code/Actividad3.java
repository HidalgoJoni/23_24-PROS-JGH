package ud3_1al3;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Actividad3 {
	public static void main(String[] args) {
		try {
			// Si no se pasan parámetros, se muestran las direcciones IP locales
			if (args.length == 0) {
				InetAddress localHost = InetAddress.getLocalHost();
				System.out.println("Dirección IP: " + localHost.getHostAddress());
				System.out.println("Nombre: " + localHost.getHostName());

				InetAddress[] localAddresses = InetAddress.getAllByName(localHost.getHostName());
				for (InetAddress address : localAddresses) {
					System.out.println(address);
				}
			} else {
				// Si se pasan parámetros, se muestra la dirección IP del dominio especificado
				String domain = args[0];
				InetAddress[] addresses = InetAddress.getAllByName(domain);
				System.out.println("Dirección IP: " + addresses[0].getHostAddress());
				System.out.println("Nombre: " + addresses[0].getHostName());

				for (InetAddress address : addresses) {
					System.out.println(address);
				}
			}
		} catch (UnknownHostException e) {
			// Si no se puede encontrar el dominio o la dirección local, se imprime un
			// mensaje de error
			System.out.println("No se pudo encontrar el dominio o la dirección local especificada.");
		}
	}
}
