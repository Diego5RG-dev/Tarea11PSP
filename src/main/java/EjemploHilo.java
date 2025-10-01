public class EjemploHilo extends Thread {
    private int limiteCabreo;
    // Constructor que recibe el nombre del hilo
    public EjemploHilo(String str, int limite) {
        super(str);
        this.limiteCabreo = limite;
    }

    // Definimos lo que hace el hilo
    @Override
    public void run() {

        for (int contador = 1; contador <= this.limiteCabreo; contador++) {
            if (contador < this.limiteCabreo) {
                System.out.println(getName() + " su nivel de cabreo ha subido a " + contador);
            } else {
                System.out.println(getName() + " Cabreo MAXIMO, no voy a corregir mas " + contador);
            }
        }
    }

    public static void main(String[] args) {
        new EjemploHilo("Diego", 10).start();
        new EjemploHilo("Araujo", 2).start();
        new EjemploHilo("Damian", 5).start();
        new EjemploHilo("Manuel", 8).start();

        System.out.println("Termina hilo principal");
    }
}
