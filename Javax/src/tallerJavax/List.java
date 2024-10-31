package tallerJavax;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class List {

    public static void main(String[] args) {
        JFrame ventana = new JFrame("Elementos del mercado adquiridos");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(800, 500);
        ventana.setLayout(null);
        
        DefaultListModel<String> lista = new DefaultListModel<>();
        lista.addElement("Queso");
        lista.addElement("Salsa napolitana");
        lista.addElement("Pasta");
        lista.addElement("Huevos");
        JList<String> jList = new JList<>(lista);
      
      
        
        JScrollPane scroll = new JScrollPane(jList);
        ventana.add(scroll);
        scroll.setBounds(10, 50, 300,300);
        
        
        JTextField campo = new JTextField();
        campo.setBounds(10, 10, 200, 30);
        ventana.add(campo);
        JButton boton = new JButton("añadir");
        boton.setBounds(250, 10, 100, 30);
        ventana.add(boton);
         boton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
               String nombre = campo.getText();
                if (!nombre.isEmpty()) {
                    lista.addElement(nombre);  
                    campo.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "El campo de texto está vacío");
                }
            }
        });
        ventana.setVisible(true);
        
    }

}
