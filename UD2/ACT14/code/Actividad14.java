// Resolucion de problemas
// No he tenido ningun problema a la hora de realizar el ejercicio
package ejer14;

public class Actividad14 extends Thread{ 
    public static void main(String args[]) {
        Recurso a = new Recurso(); 
        Recurso b = new Recurso(); 
        Hilo h1 = new Hilo(a, b, "uno"); 
        Hilo h2 = new Hilo(a, b, "dos");  // Cambiamos el orden de los recursos a y b
        h1.start(); 
        h2.start(); 
    }
}
