public class hilos extends Thread{
    private final int limite;
    private int maximoHilos;
    private int ConteoActual;


    public hilos(String str, int limite, int maximoHilos){
        super(str);
        this.limite = limite;
        this.maximoHilos = maximoHilos;
    }

    @Override
    public void run(){
        for(int contador=1; contador<=limite; contador++){
            System.out.println("hilo "+getName()+" iteracion: "+contador);
            if (maximoHilos < 5) {
                maximoHilos++;
                new hilos("hilo "+maximoHilos, limite, maximoHilos).start();
            }else {
                System.out.println("hilo" +getName()+" termino con "+contador+" iteraciones");
            }
        }
    }

    public static void main(String[] args) {
        new hilos("principal", 5, 0).start();
        System.out.println("hilo principal termino");
    }
}
