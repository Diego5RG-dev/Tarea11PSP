import java.util.Random;

public class hilos extends Thread {
    private final int totalHilos = 5;
    private int identificadorHilos;
    private hilos siguienteHilo = null;

    public hilos(int index) {
        super("Hilo-" + index);
        this.identificadorHilos = index;
    }

    @Override
    public void run() {
        if (identificadorHilos < totalHilos) {
            siguienteHilo = new hilos(identificadorHilos + 1);
            siguienteHilo.start();
        }
        Random random = new Random();
        for (int contador = 1; contador <= 5; contador++) {
            System.out.println("Soy el [" + getName() + "] iteración: " + contador);
            try {
                int waitTime = 100 + random.nextInt(501);
                Thread.sleep(waitTime);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        if (siguienteHilo != null) {
            try {
                siguienteHilo.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Acabó hilo " + getName());
    }
    public static void main(String[] args) {
        new hilos(1).start();
    }
}
