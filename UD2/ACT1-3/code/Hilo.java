package ejerciciosPROS;

class Hilo extends Thread {
    // Mensaje que se imprimirá en la consola, puede ser "Primero" o "Segundo"
    private final String mensaje;

    // Constructor que inicializa el mensaje
    public Hilo(String mensaje) {
        this.mensaje = mensaje;
    }

    // Método que se ejecuta cuando se inicia el hilo
    @Override
    public void run() {
        // Bucle que imprime el mensaje 20 veces
        for (int i = 1; i <= 20; i++) {
            System.out.println(mensaje + " " + i);
        }
    }
}