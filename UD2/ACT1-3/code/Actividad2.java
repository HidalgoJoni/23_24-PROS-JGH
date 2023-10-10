package ejer2;

import java.util.Scanner;  // Importar la clase Scanner para leer la entrada del usuario

// Clase principal que crea y gestiona los hilos
public class Actividad2 {
    public static void main(String[] args) {
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Pedir al usuario que introduzca el número de hilos
        System.out.print("Introduce el número de hilos: ");
        int n = scanner.nextInt();  // Leer el número de hilos

        // Array para almacenar los hilos
        Thread[] hilos = new Thread[n];

        // Crear y empezar los hilos
        for (int i = 0; i < n; i++) {
            hilos[i] = new Hilo(i + 1); // Crear un nuevo hilo
            hilos[i].start(); // Empezar el hilo
        }

        // Esperar a que todos los hilos terminen
        for (int i = 0; i < n; i++) {
            try {
                hilos[i].join(); // Esperar a que el hilo termine
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Imprimir el mensaje final
        System.out.println("Final Programa");
        
        // Cerrar el objeto Scanner para liberar los recursos asociados
        scanner.close();
    }
}