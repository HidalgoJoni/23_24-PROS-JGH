package ud4_act2;

import org.apache.commons.net.ftp.FTPClient;
import java.io.IOException;

public class Actividad2 {
    public static void main(String[] args) {
        String server = "172.20.132.135"; // IP del servidor FTP
        String user = "dinux";
        String pass = "dinux";
        String apellido = "Garcia";
        String baseDir = "aplicacionweb" + apellido;
        String[] subDirs = {"html", "imagenes", "css"};

        FTPClient ftpClient = new FTPClient();
        try {
            System.out.println("Nos conectamos a " + server);
            ftpClient.connect(server);
            if (ftpClient.login(user, pass)) {
                System.out.println("Login correcto");
                System.out.println("Directorio actual: " + ftpClient.printWorkingDirectory());

                boolean success = ftpClient.makeDirectory(baseDir);
                if (success) {
                    for (String dir : subDirs) {
                        ftpClient.makeDirectory(baseDir + "/" + dir);
                    }
                    System.out.println("Directorios creados...");
                } else {
                    System.out.println("NO SE HAN PODIDO CREAR LOS DIRECTORIOS");
                }

                ftpClient.logout();
                System.out.println("Logout del servidor FTP...");
            } else {
                System.out.println("Login incorrecto...");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.disconnect();
                    System.out.println("Desconectado...");
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}

