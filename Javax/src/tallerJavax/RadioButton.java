package tallerJavax;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

/**
 *
 * @author mundo joven
 */
public class RadioButton {

    public static void main(String[] args) {
        JFrame ventana = new JFrame("Registrar Sexo");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(800, 500);
        ventana.setLayout(null);
        
         JLabel etiqueta = new JLabel("Seleccione su sexo");
        etiqueta.setBounds(5, 5, 450, 50);
        ventana.add(etiqueta);

        JRadioButton rbtn1 = new JRadioButton("Masculino");
        JRadioButton rbtn2 = new JRadioButton("Femenino");
        ButtonGroup grupo1 = new ButtonGroup();
        
        grupo1.add(rbtn1);
        grupo1.add(rbtn2);
        
        ventana.add(rbtn1);
        ventana.add(rbtn2);

        rbtn1.setBounds(50, 50, 100, 30);
        rbtn2.setBounds(50, 80, 100, 30);
        ventana.setVisible(true);
    }
   }


