package ejer4;

//Clase Posicion que implementa Runnable para poder ser utilizada en un hilo
class Posicion implements Runnable {
	private final String nombre; // Nombre del hilo, puede ser "Primero" o "Segundo"
	private final int veces; // Número de veces que se imprimirá el mensaje

 // Constructor que inicializa el nombre y el número de veces
	public Posicion(String nombre, int veces) {
		this.nombre = nombre;
		this.veces = veces;
	}

 // Método que se ejecuta cuando se inicia el hilo
	@Override
	public void run() {
		for (int i = 1; i <= veces; i++) {
			System.out.println(nombre + " " + i); // Imprimir el mensaje
		}	
	}
}
