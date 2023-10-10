package ejer4;

// Clase principal que crea y gestiona los hilos
public class Actividad4 {
    public static void main(String[] args) {
        // Crear dos objetos de la clase Posicion, uno para "Primero" y otro para "Segundo"
        Thread p = new Thread(new Posicion("Primero", 15));
        Thread s = new Thread(new Posicion("Segundo", 15));

        // Iniciar los hilos
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
