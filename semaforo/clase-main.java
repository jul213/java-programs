
public class Main {

    public static void main(String []args){
        Semaforo semaforo = new semaforo();
        Thread thread = new Thread(semaforo);
        thread.start()
    }
}