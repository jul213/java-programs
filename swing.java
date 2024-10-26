package swing;

import javax.swing.*;

public class MainForm {
    private JTextPane pricePane;
    private JTextPane taxPane;
    private JTextPane totalPane;
    private JButton buttonCalculate;

    public ActionListener botonPulsado(){
        System.out.println("soy un boton");
    }

    public MainForm () {
        
        buttonCalculate.addActionListener(botonPulsado());
    }

    public static void main(string []args) {
        JFrame frame = new JFrame("swingTax");
        frame.setContentPane(new MainForm().taxPane);
        frame.setVisible(true);
    }
}