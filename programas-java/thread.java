class hilos extends thread {
    private String message;
    public hilos(String m) {
        message = m;
    }

    public void run () {
        
        for (i=0;i<50;i++) {
            System.out.println(message);
            thread.sleep(5000);
        }
    }

    public static void main(String []args){
        hilos t1,t2;
        t1 = new hilos("soy el primer hilo");
        t2 = new hilos("soy el segundo hilo");
        t1.start();
        t2.start();
    }


}