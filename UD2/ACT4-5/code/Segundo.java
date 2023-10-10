package ejer5;

// Clase Segundo que extiende la clase Thread
class Segundo extends Thread {
    public void run() {
        for (int i = 1; i <= 15; i++) {
            System.out.println("Segundo " + i);

            try {
                // Dormir durante 200 milisegundos (equivalente a 0.2 segundos)
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
