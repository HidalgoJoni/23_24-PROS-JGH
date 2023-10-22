package pros;

public class Actividad10 {
    public static void main(String[] args) {
        Thread main = Thread.currentThread();
        main.setPriority(5);

        Hilo hilo1 = new Hilo("Hilo-prioridad 3");
        Hilo hilo2 = new Hilo("Hilo-prioridad 7");

        hilo1.setPriority(3);
        hilo2.setPriority(7);

        hilo1.start();
        hilo2.start();

        System.out.println(main.getName() + " tiene la prioridad " + main.getPriority());
        System.out.println(hilo1.getName() + " tiene la prioridad " + hilo1.getPriority());
        System.out.println(hilo2.getName() + " tiene la prioridad " + hilo2.getPriority());
    }
}