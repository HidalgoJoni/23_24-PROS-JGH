package ejer3;

// Clase principal que crea y gestiona los hilos
public class Actividad3 {
    public static void main(String[] args) {
        // Crear un hilo
        Thread hilo = new Thread(() -> {
            // Imprimir el nombre y la prioridad inicial del hilo
            System.out.println("El nombre del hilo es " + Thread.currentThread().getName() +
                               " y tiene la prioridad " + Thread.currentThread().getPriority());

            // Cambiar el nombre y la prioridad del hilo
            Thread.currentThread().setName("SUPER-HILO-DM2");
            Thread.currentThread().setPriority(6);

            // Imprimir el nombre y la prioridad modificados del hilo
            System.out.println("Ahora el nombre del hilo es " + Thread.currentThread().getName() +
                               " y tiene la prioridad " + Thread.currentThread().getPriority());
        });

        // Iniciar el hilo
        hilo.start();

        try {
            // Esperar a que el hilo termine
            hilo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Imprimir el mensaje final
        System.out.println("Final programa");
    }
}
