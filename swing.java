package swing;

import javax.swing.*;

public class MainForm {
    private JTextPane pricePane;
    private JTextPane taxPane;
    private JTextPane totalPane;
    private JButton buttonCalculate;

    public ActionListener botonPulsado(){
         return actionPerformed(ActionEvent e){

         }
    }

    public MainForm () {
        
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