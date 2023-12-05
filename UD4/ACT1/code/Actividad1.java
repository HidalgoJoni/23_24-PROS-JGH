package ud4_actividad1;

import org.apache.commons.net.ftp.FTPClient;

public class Actividad1 {
    public static void main(String[] args) {
        FTPClient ftpClient = new FTPClient();
        try {
            System.out.println("Nos conectamos a ftp.rediris.es");
            ftpClient.connect("ftp.rediris.es");
            boolean login = ftpClient.login("anonymous", "dm2");

            if (login) {
                System.out.println("Login correcto");

                // Mostrar directorio actual
                String currentDirectory = ftpClient.printWorkingDirectory();
                System.out.println("Directorio actual:" + currentDirectory);

                // Intentar crear directorio
                String dirToCreate = "DM2PROS";
                boolean created = ftpClient.makeDirectory(dirToCreate);

                if (created) {
                    System.out.println("Directorio creado....");
                } else {
                    System.out.println("NO SE HA PODIDO CREAR EL DIRECTORIO");
                }

                // Hacer logout
                if (ftpClient.logout()) {
                    System.out.println("Logout del servidor FTP...");
                } else {
                    System.out.println("Error al hacer logout…");
                }
            } else {
                System.out.println("Login incorrecto...");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ftpClient.isConnected()) {
                try {
                    ftpClient.disconnect();
                    System.out.println("Desconectado...");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

