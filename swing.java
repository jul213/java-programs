package swing;

import javax.swing.*;

public class MainForm {
    private JTextPane pricePane;
    private JTextPane taxPane;
    private JTextPane totalPane;
    private JButton Calculate;

    public ActionListener botonPulsado(){
         return actionPerformed(ActionEvent e){

         }
    }

    public MainForm () {
        Calculate.addActionListener(new ActionListener() {
            @override
            public void actionPerformed(ActionEvent e){
                boolean comprobacion = false;
                double precio = 0;

                while (!comprobacion){
                    try {
                        precio = Double.ParseDouble(pricePane.getText());
                        comprobacion = true;
                        pricePane.setText(precio);
                    } catch (NumberFormatException e){
                        System.out.println("error no se puede convertir texto en double tiene que digitar un numero tipo double con decimales");
                    }
                }

            }
        })
        pricePane.addKeyListener(new KeyAdapter() {
            @override // sobre escribe metodos genericos
            public void keyTyped(KeyEvent e){
                super.keyTypad(e);
                pricePane.getText();
                String valorPrecio = pricePane.getText() + "ñ";
                pricePane.setText(valorPrecio);
            }
        })
    }

    public static void main(string []args) {
        JFrame frame = new JFrame("swingTax");
        frame.setContentPane(new MainForm().taxPane);
        frame.setVisible(true);
    }
}