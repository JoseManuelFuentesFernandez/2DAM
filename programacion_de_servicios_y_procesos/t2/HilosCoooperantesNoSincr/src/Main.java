public class Main {
    public static void main(String[] args) {
        int inicial = 0;
        int nHilos = 5;
        int meta = 100;
        int inc = meta / nHilos;

        Contador contador = new Contador(inicial);
        Thread[] hilos = new Thread[nHilos];

        for (int i = 0; i < nHilos; i++) {
            hilos[i] = new Hilo(contador, inc);
            hilos[i].start();
        }

        for (Thread hilo : hilos) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Valor final del contador: " + contador.getContador());
    }
}