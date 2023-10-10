package ejer5;

// Clase Primero que extiende la clase Thread
class Primero extends Thread {
    public void run() {
        for (int i = 1; i <= 15; i++) {
            System.out.println("Primero " + i);

            try {
                // Dormir durante 100 milisegundos
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
