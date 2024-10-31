package tallerJavax;

import javax.swing.*;
import java.awt.event.*;

public class ProgressBar {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Cargar Archivo");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(1000, 150);
        ventana.setLayout(null);

        JProgressBar progressBar;
        progressBar = new JProgressBar(0, 100);
        progressBar.setValue(0);
        progressBar.setBounds(100, 50, 800, 50);
        ventana.add(progressBar);
        
        JButton cargar = new JButton("Cargar (paso a paso)");
        cargar.setBounds(400, 10, 200, 30);
        ventana.add(cargar);

        cargar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) { 
                progressBar.setValue(progressBar.getValue()+10);
            }
        });
        ventana.setVisible(true);
    }

}
