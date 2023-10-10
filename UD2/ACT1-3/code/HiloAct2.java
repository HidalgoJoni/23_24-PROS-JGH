package ejer2;

//Clase Hilo que se encarga de imprimir el mensaje
class Hilo extends Thread {
	private final int numeroHilo; // Número del hilo

 // Constructor
	public Hilo(int numeroHilo) {
		this.numeroHilo = numeroHilo;
	}

 // Método que se ejecuta cuando el hilo empieza
	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println("Hilo " + numeroHilo); // Imprimir el mensaje
		}
	 }
}
