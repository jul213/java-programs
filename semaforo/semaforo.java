import java.util.Random;
class Semaforo implements Runnable {
    private String verde, rojo, amarillo, color;
    private String[] colores;
    public Semaforo() {
        verde = "verde";
        rojo = "rojo";
        amarillo = "amarillo";
        colores[] = {verde,rojo,amarillo};
        Random random = new Random();
    }
    
    private void cambiarCalor () {
        color = colores[random.nextInt(colores.length)];  
    }
    
    public void cambio () {
        if (color.equals("rojo")){
            System.out.println("no pueden pasar");
            thread.sleep(5000);
        }
        else if (color.equals("amarillo")){
            System.out.println("falta poco esperen");
            thread.sleep(3000);
        }
        else {
            System.out.println("pueden pasar");
            thread.sleep(5500)
        }

    }

    @override
    public void run(){
        try {
            while (true){
                cambiarCalor();
                cambio();
            }
        }
        catch (InterruptedException e) {
            thread.currentThread().interrupt();
        }
    }
}