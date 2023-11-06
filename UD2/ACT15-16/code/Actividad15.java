package ejer13_14;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Actividad15 {

    public static void main(String[] args) {
        // Crear los hilos
        Thread hilo1 = new MiHilo("Hilo 1");
        Thread hilo2 = new MiHilo("Hilo 2");
        Thread hilo3 = new MiHilo("Hilo 3");

        // Iniciar los hilos
        hilo1.start();
        hilo2.start();
        hilo3.start();
    }

    // Clase estática interna MiHilo que hereda de Thread.
    static class MiHilo extends Thread {
        // Variable para almacenar el nombre del hilo.
        String nombre;

        // Constructor de la clase MiHilo.
        // Asigna el nombre pasado como parámetro a la variable de instancia 'nombre'.
        public MiHilo(String nombre) {
            this.nombre = nombre;
        }
        
        // Método run() que se ejecuta cuando se inicia el hilo.
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                // Obtener la hora actual
                String hora = new SimpleDateFormat("HH:mm:ss").format(new Date());

                // Mostrar el mensaje
                System.out.println(nombre + " - " + hora);

                // Esperar 1 segundo
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

