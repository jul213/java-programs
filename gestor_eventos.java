package swing;

import javax.swing.*;
import java.util.LinkedList;

interface Mensajero {
    void saludo();
}

class Emisor {
    private LinkedList<Mensajero> hola = new LinkedList<Mensajero>();

    public void receptor(Mensajero recep) {hola.add(recep);}

    public void saludo() {
        System.out.println("Hola!");

        for (Mensajero i : hola){
            i.saludo();

        }
    }
}

class Receptor implements Mensajero {
    @override
    public void saludo(){
        System.out.println("soy un receptor");
    }
}