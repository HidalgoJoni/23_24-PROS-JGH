package ejer5;

// Clase principal que crea y gestiona los hilos
public class Actividad5 {
    public static void main(String[] args) {
        Primero p = new Primero();
        Segundo s = new Segundo();
        p.start();
        s.start();

        try {
            // Esperar a que ambos hilos terminen
            p.join();
            s.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Imprimir el mensaje final
        System.out.println("Fin programa");
    }
}
