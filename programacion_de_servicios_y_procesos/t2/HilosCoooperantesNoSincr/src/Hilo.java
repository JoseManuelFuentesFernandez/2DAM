public class Hilo extends Thread implements Runnable{
    public static int i=0;
    public int id;
    private Contador contador;
    private int incrementos;

    public Hilo(Contador contador, int incrementos) {
        this.id = ++i;
        this.contador = contador;
        this.incrementos = incrementos;
    }

    @Override
    public void run() {
        for (int i = 0; i < incrementos; i++) {
            int previo = contador.contador;
            contador.incrementar();
            System.out.println(this+": incrementó de "+previo+" a "+contador.contador);
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Hilo ");
        sb.append(id);
        return sb.toString();
    }
}
