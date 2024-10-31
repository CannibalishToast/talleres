
package tallerJavax;

import javax.swing.*;
import java.awt.event.*;

public class TextArea {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Pruebas con textArea");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(800, 500);
        ventana.setLayout(null);

        JButton boton = new JButton("finalizar");
        boton.setBounds(50, 370, 100, 30);
        ventana.add(boton);
        
        JTextArea texto=new JTextArea();
        texto.setBounds(30,50,400,300);
        ventana.add(texto);
        texto.setText("Escriba su mensaje");
        
        boton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
               JOptionPane.showMessageDialog(null, "texto escrito: " + texto.getText());
            }
        });
        ventana.setVisible(true);
    }
}
