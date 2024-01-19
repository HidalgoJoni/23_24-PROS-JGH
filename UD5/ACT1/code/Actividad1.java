package ud5_ejer1;

import java.security.Provider;
import java.security.Security;
import java.util.Set;

public class Actividad1 {
    public static void main(String[] args) {
        // Obtener el proveedor SUN
        Provider sunProvider = Security.getProvider("SUN");

        // Comprobar si el proveedor SUN está disponible
        if (sunProvider == null) {
            System.out.println("El proveedor SUN no está disponible en esta máquina virtual Java.");
            return;
        }

        // Mostrar información del proveedor
        System.out.println("** Proveedor SUN, versión " + sunProvider.getVersion() + " **");

        // Obtener y mostrar los algoritmos de resumen de mensaje
        Set<Provider.Service> services = sunProvider.getServices();
        for (Provider.Service service : services) {
            if (service.getType().equalsIgnoreCase("MessageDigest")) {
                System.out.println("\tNombre del algoritmo: \"" + service.getAlgorithm() + "\"");
            }
        }
    }
}

