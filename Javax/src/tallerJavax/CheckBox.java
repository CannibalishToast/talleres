package tallerJavax;

import javax.swing.*;
import java.awt.event.*;

public class CheckBox {

    public static void main(String[] args) {
    JFrame ventana = new JFrame("Lista de Mercado");
    ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ventana.setSize(800, 500);
    ventana.setLayout(null);
    
    JLabel etiqueta = new JLabel("Vaya checkeando los productos adquiridos. ");
    etiqueta.setBounds(5, 5, 250, 50);
    ventana.add(etiqueta);

    JCheckBox check1=new JCheckBox();
    check1.setText("Pasta");
    check1.setBounds(20, 60, 120, 30);
    ventana.add(check1);
  
    JCheckBox check2=new JCheckBox();
    check2.setText("Salsa napolitana");
    check2.setBounds(20, 80, 120, 30);
    ventana.add(check2);
  
    JCheckBox check3=new JCheckBox();
    check3.setText("Queso");
    check3.setBounds(20, 110, 120, 30);
    ventana.add(check3);
    
    JCheckBox check4=new JCheckBox();
    check4.setText("Jamon");
    check4.setBounds(20, 130, 120, 30);
    ventana.add(check4);
    
    JCheckBox check5=new JCheckBox();
    check5.setText("Condimentos");
    check5.setBounds(20, 150, 120, 30);
    ventana.add(check5);
    
    JCheckBox check6=new JCheckBox();
    check6.setText("Aceite");
    check6.setBounds(20, 170, 120, 30);
    ventana.add(check6);
    
    JButton boton = new JButton("Terminé el mercado");
    boton.setBounds(50, 200, 100, 30);
    ventana.add(boton);
    
     boton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
        JOptionPane.showMessageDialog(null, "Mercado realizado! ;D");
            }
        }
     );
    
    ventana.setVisible(true);
      
    }
    
}
