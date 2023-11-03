package ud3_4y5;

import java.net.URL;
import java.net.URLConnection;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Actividad5 {

	public static void main(String[] args) {
		try {
			// Establecer la conexión con la URL
			URL url = new URL("http://www.vitoria-gasteiz.org");
			URLConnection conexion = url.openConnection();

			// Visualizar la información de la conexión
			System.out.println("Conexión con www.vitoria-gasteiz.org");
			System.out.println("==========================");
			VisualizarConexion(conexion);

		} catch (IOException e) {
			System.out.println("Error al establecer conexión con la URL: " + e.getMessage());
		}
	}

	private static void VisualizarConexion(URLConnection conexion) throws IOException {
		// Asegúrate de conectar antes de recuperar datos
		conexion.connect();

		// Mostrar información básica
		System.out.println("\tMétodo toString():" + conexion.toString());
		System.out.println("\tMétodo Fecha():" + conexion.getDate());
		System.out.println("\tMétodo getContentType():" + conexion.getContentType());
		System.out.println();

		// Mostrar campos de cabecera con getHeaderField
		System.out.println("Campos Cabecera con getHeaderField:");
		System.out.println("====================================");
		for (int i = 0;; i++) {
			String headerName = conexion.getHeaderFieldKey(i);
			String headerValue = conexion.getHeaderField(i);

			if (headerName == null && headerValue == null) {
				break;
			}
			if (headerName == null) {
				System.out.println("\t\tLinea " + (i + 1) + ":" + headerValue);
				continue;
			}
			System.out.println("\t\t" + headerName + ":" + headerValue);
		}
		System.out.println();

		// Mostrar campos de cabecera con getHeaderFields
		System.out.println("Campos Cabecera con getHeaderFields:");
		System.out.println("====================================");
		Map<String, List<String>> headerFields = conexion.getHeaderFields();
		for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
			System.out.println(entry.getKey() + ":\t" + entry.getValue());
		}
	}
}
