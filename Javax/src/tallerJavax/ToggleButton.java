
package tallerJavax;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ToggleButton {

    public static void main(String[] args) {
        JFrame ventana = new JFrame("ToggleButton");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(800, 400);
        ventana.setLayout(null);

        JToggleButton toggleButton = new JToggleButton("Switch");
        toggleButton.setBounds(100, 50, 200, 50);
        ventana.add(toggleButton);

        JLabel label = new JLabel("ON");
        label.setBounds(100, 110, 200, 30);
        ventana.add(label);

        toggleButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                // Verificar el estado del ToggleButton
                if (toggleButton.isSelected()) {
                    label.setText("ON");
                } else {
                    label.setText("OFF");
                }
            }
        });
        ventana.setVisible(true);
    }
}
