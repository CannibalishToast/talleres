package App;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JMenuBar {
    private App app;

    public Menu(App app) {
        this.app = app;

        // Menú Archivo
        JMenu fileMenu = new JMenu("Archivo");
        JMenuItem newItem = new JMenuItem("Nuevo");
        newItem.addActionListener(e -> app.mostrarFormulario());
        
        JMenuItem exitItem = new JMenuItem("Salir");
        exitItem.addActionListener(e -> System.exit(0));

        fileMenu.add(newItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        // Menú Ayuda
        JMenu helpMenu = new JMenu("Ayuda");
        JMenuItem aboutItem = new JMenuItem("Acerca de");
        aboutItem.addActionListener(e -> mostrarAcercaDe());

        helpMenu.add(aboutItem);

        // Agregar los menús a la barra de menús
        add(fileMenu);
        add(helpMenu);
    }

    private void mostrarAcercaDe() {
        JOptionPane.showMessageDialog(app, "Gestor de Contactos v1.0\nDesarrollado con Java Swing.", "Acerca de", JOptionPane.INFORMATION_MESSAGE);
    }
}
