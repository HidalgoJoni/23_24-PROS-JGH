package ejerciciosPROS;

public class Actividad1 {
    public static void main(String[] args) {
        // Creación de dos objetos de la clase Hilo, uno para imprimir "Primero" y otro para "Segundo"
        Hilo hilo1 = new Hilo("Primero");
        Hilo hilo2 = new Hilo("Segundo");
        
        // Inicio de los hilos
        hilo1.start();
        hilo2.start();

        try {
            // El hilo principal espera a que hilo1 termine su ejecución
            hilo1.join();
            // El hilo principal espera a que hilo2 termine su ejecución
            hilo2.join();
        } catch (InterruptedException e) {
            // Imprime el error en caso de una excepción
            e.printStackTrace();
        }

        // Imprime "Fin programa" en la consola una vez que ambos hilos han terminado
        System.out.print("Fin programa");
    }
}
