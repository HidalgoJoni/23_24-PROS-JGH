package ejer13_14;

public class Actividad16 {
    public static void main (String[] args) {
        // Se crea un objeto Contador con el valor inicial 100.
        Contador cont = new Contador (100);
        
        // Se crean dos hilos, uno para incrementar el contador y otro para decrementarlo.
        HiloA a = new HiloA("HiloA", cont);
        HiloB b = new HiloB("HiloB", cont);
        
        // Se inician los dos hilos.
        a.start();
        b.start(); 
    } 
}

class Contador {
    private int c = 0;
    private boolean incrementado = false;

    // Constructor que inicializa el contador con el valor pasado como parámetro.
    Contador (int c) { 
        this.c = c; 
    }

    // Método sincronizado para incrementar el contador.
    public synchronized void incrementa() {
        c = c + 1;
    }

    // Método sincronizado para decrementar el contador.
    public synchronized void decrementa() {
        c = c - 1;
    }

    public synchronized void setIncrementado() {
        incrementado = true;
        notifyAll();
    }

    public synchronized void waitForIncrement() {
        while (!incrementado) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
    }

    // Método para obtener el valor actual del contador.
    public int getValor() {
        return c; 
    }
}

class HiloA extends Thread {
    private Contador contador;

    // Constructor que inicializa el nombre del hilo y el objeto Contador.
    public HiloA (String n, Contador c) {
        setName(n);
        contador = c;
    }

    public void run () {
        // Se incrementa el contador 300 veces.
        for (int j = 0; j < 300; j++) {
            contador.incrementa();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {}
        }
        
        // Se imprime el valor actual del contador.
        System.out.println(getName() + " contador vale " + contador.getValor());
        contador.setIncrementado();
    }
}

class HiloB extends Thread {
    private Contador contador;

    // Constructor que inicializa el nombre del hilo y el objeto Contador.
    public HiloB (String n, Contador c) {
        setName(n);
        contador = c;
    }

    public void run () {
        contador.waitForIncrement();

        // Se decrementa el contador 300 veces.
        for (int j = 0; j < 300; j++) {
            contador.decrementa();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {}
        }
        
        // Se imprime el valor actual del contador.
        System.out.println(getName() + " contador vale " + contador.getValor());
    }
}

