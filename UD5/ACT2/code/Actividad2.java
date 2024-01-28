package ud5_ejer2;

import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

public class Actividad2 {
    public static void main(String[] args) {
        try {
            // Leer la clave pública del archivo
            byte[] keyBytes = Files.readAllBytes(Paths.get("ud5_ejer2/Clave.publica"));
            X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("DSA");
            PublicKey publicKey = keyFactory.generatePublic(spec);

            // Leer el fichero de la firma
            FileInputStream sigfis = new FileInputStream("ud5_ejer2/FICHERO.FIRMA");
            byte[] sigToVerify = new byte[sigfis.available()];
            sigfis.read(sigToVerify);
            sigfis.close();

            // Inicializar el objeto Signature
            Signature sig = Signature.getInstance("SHA1withDSA");
            sig.initVerify(publicKey);

            // Leer el fichero de datos
            FileInputStream datafis = new FileInputStream("ud5_ejer2/FICHERO.DAT");
            byte[] buffer = new byte[1024];
            int len;
            while ((len = datafis.read(buffer)) > 0) {
                sig.update(buffer, 0, len);
            }
            datafis.close();

            // Verificar la firma
            boolean verifies = sig.verify(sigToVerify);

            // Mostrar el resultado de la verificación
            System.out.println(verifies ? "LOS DATOS SE CORRESPONDEN CON SU FIRMA" : "LOS DATOS NO SE CORRESPONDEN CON SU FIRMA");
        } catch (Exception e) {
            System.err.println("Se produjo un error durante la verificación de la firma: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
