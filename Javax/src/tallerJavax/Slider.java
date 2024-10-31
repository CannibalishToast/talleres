package tallerJavax;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class Slider extends JFrame {

    public Slider() {
        setTitle("Ejemplo de JSlider");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear un panel para organizar los componentes
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Crear el JSlider
        JSlider slider = new JSlider(0, 100, 50); 
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5); 
        slider.setPaintTicks(true); 
        slider.setPaintLabels(true);

        // Crear una etiqueta para mostrar el valor del slider
        JLabel label = new JLabel("Valor del slider: " + slider.getValue(), SwingConstants.CENTER);

        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = slider.getValue();
                label.setText("Valor del slider: " + value);
            }
        });

        // Agregar el slider y la etiqueta al panel
        panel.add(slider, BorderLayout.CENTER);
        panel.add(label, BorderLayout.SOUTH);

        // Agregar el panel al JFrame
        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Slider example = new Slider();
                example.setVisible(true);
            }
        });
    }
}
