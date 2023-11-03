package ud3_4y5;

import java.net.MalformedURLException;
import java.net.URL;

public class Actividad4 {

	public static void main(String[] args) {
		try {
			// Crear objetos URL utilizando diferentes constructores
			URL url1 = new URL("http://docs.oracle.com");
			URL url2 = new URL("http", "docs.oracle.com", "/javase/7");
			URL url3 = new URL("http", "docs.oracle.com", 80, "/javase/7");
			URL base = new URL("http://docs.oracle.com");
			URL url4 = new URL(base, "/javase/7/docs/api/java/net/URL.html");

			// Visualizar diferentes objetos URL
			System.out.println("Constructor simple para una URL:");
			Visualizar(url1);
			System.out.println("Constructor para protocolo, host y directorio:");
			Visualizar(url2);
			System.out.println("Constructor para protocolo, host, puerto y directorio:");
			Visualizar(url3);
			System.out.println("Constructor para un objeto URL y su directorio:");
			Visualizar(url4);

		} catch (MalformedURLException e) {
			System.out.println("URL mal formada: " + e.getMessage());
		}
	}

	public static void Visualizar(URL url) {
		// Mostrar los diferentes componentes de la URL
		System.out.println("\tMétodo toString():" + url.toString());
		System.out.println("\tMétodo getProtocol():" + url.getProtocol());
		System.out.println("\tMétodo getHost():" + url.getHost());
		System.out.println("\tMétodo getPort():" + url.getPort());
		System.out.println("\tMétodo getFile():" + url.getFile());
		System.out.println("\tMétodo getUserInfo():" + url.getUserInfo());
		System.out.println("\tMétodo getPath():" + url.getPath());
		System.out.println("\tMétodo getAuthority():" + url.getAuthority());
		System.out.println("\tMétodo getQuery():" + url.getQuery());
		System.out.println();
	}
}
