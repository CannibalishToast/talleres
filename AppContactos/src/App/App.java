package App;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class App extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private ArrayList<Contacto> contactos;
    private JTextField searchField;
    private JButton searchButton;

    // Componentes de la ventana de formulario
    private JDialog formDialog;
    private JTextField nameField, lastNameField, phoneField, emailField, addressField;
    private JRadioButton solteroButton, casadoButton, unionLibreButton, divorciadoButton;
    private ButtonGroup estadoCivilGroup;
    private JButton saveButton, editButton, deleteButton;

    public App() {
        setTitle("Gestor de Contactos");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        contactos = new ArrayList<>();
        
        // Menú
        setJMenuBar(new Menu(this));

        // Tabla de contactos
        String[] columnNames = {"Nombre", "Apellido", "Teléfono", "Email"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        JScrollPane tablePane = new JScrollPane(table);

        // Botones principales y campo de búsqueda
        JButton addButton = new JButton("Agregar");
        editButton = new JButton("Editar");
        deleteButton = new JButton("Eliminar");
        searchField = new JTextField(15);
        searchButton = new JButton("Buscar");

        addButton.addActionListener(e -> mostrarFormulario());
        editButton.addActionListener(e -> editarContacto());
        deleteButton.addActionListener(e -> eliminarContacto());
        searchButton.addActionListener(e -> buscarContacto());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(searchField);
        buttonPanel.add(searchButton);

        // Layout principal
        getContentPane().add(tablePane, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        // Atajos de teclado
        addKeyboardShortcuts();
    }

    // Método para mostrar el formulario en una nueva ventana
    public void mostrarFormulario() {
        formDialog = new JDialog(this, "Formulario de Contacto", true);
        formDialog.setSize(400, 300);
        formDialog.setLayout(new GridLayout(7, 2));
        
        // Campos del formulario
        nameField = new JTextField();
        lastNameField = new JTextField();
        phoneField = new JTextField();
        emailField = new JTextField();
        addressField = new JTextField();
        
        formDialog.add(new JLabel("Nombre:"));
        formDialog.add(nameField);
        formDialog.add(new JLabel("Apellido:"));
        formDialog.add(lastNameField);
        formDialog.add(new JLabel("Teléfono:"));
        formDialog.add(phoneField);
        formDialog.add(new JLabel("Email:"));
        formDialog.add(emailField);
        formDialog.add(new JLabel("Dirección:"));
        formDialog.add(addressField);
        
        // Estado Civil
        solteroButton = new JRadioButton("Soltero");
        casadoButton = new JRadioButton("Casado");
        unionLibreButton = new JRadioButton("Unión Libre");
        divorciadoButton = new JRadioButton("Divorciado");
        estadoCivilGroup = new ButtonGroup();
        estadoCivilGroup.add(solteroButton);
        estadoCivilGroup.add(casadoButton);
        estadoCivilGroup.add(unionLibreButton);
        estadoCivilGroup.add(divorciadoButton);
        
        JPanel estadoCivilPanel = new JPanel();
        estadoCivilPanel.add(solteroButton);
        estadoCivilPanel.add(casadoButton);
        estadoCivilPanel.add(unionLibreButton);
        estadoCivilPanel.add(divorciadoButton);
        
        formDialog.add(new JLabel("Estado Civil:"));
        formDialog.add(estadoCivilPanel);

        // Botón de Guardar
        saveButton = new JButton("Guardar");
        saveButton.addActionListener(e -> guardarContacto());

        formDialog.add(new JLabel());
        formDialog.add(saveButton);

        formDialog.setLocationRelativeTo(this);
        formDialog.setVisible(true);
    }

    // Método para guardar el contacto actual (funciona tanto para agregar como para actualizar)
    private void guardarContacto() {
        String nombre = nameField.getText();
        String apellido = lastNameField.getText();
        String telefono = phoneField.getText();
        String email = emailField.getText();
        String direccion = addressField.getText();
        String estadoCivil = getEstadoCivil();

        // Verificaciones
        if (nombre.isEmpty() || apellido.isEmpty() || telefono.isEmpty() || email.isEmpty() || direccion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!email.contains("@") || !email.endsWith(".com")) {
            JOptionPane.showMessageDialog(this, "El correo debe contener '@' y terminar en '.com'", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (telefono.length() <= 7 || !telefono.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "El teléfono debe contener más de 7 dígitos y solo números", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (estadoCivil.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un estado civil", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int selectedRow = table.getSelectedRow();
        
        if (selectedRow >= 0) { // Edición
            Contacto contacto = contactos.get(selectedRow);
            contacto.setNombre(nombre);
            contacto.setApellido(apellido);
            contacto.setTelefono(telefono);
            contacto.setEmail(email);
            contacto.setDireccion(direccion);
            contacto.setEstadoCivil(estadoCivil);

            tableModel.setValueAt(nombre, selectedRow, 0);
            tableModel.setValueAt(apellido, selectedRow, 1);
            tableModel.setValueAt(telefono, selectedRow, 2);
            tableModel.setValueAt(email, selectedRow, 3);
        } else { // Nuevo contacto
            Contacto contacto = new Contacto(nombre, apellido, telefono, email, direccion, estadoCivil);
            contactos.add(contacto);
            tableModel.addRow(new Object[]{nombre, apellido, telefono, email});
        }

        formDialog.dispose();
    }

    // Método para editar el contacto seleccionado
    private void editarContacto() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            Contacto contacto = contactos.get(selectedRow);
            mostrarFormulario();
            nameField.setText(contacto.getNombre());
            lastNameField.setText(contacto.getApellido());
            phoneField.setText(contacto.getTelefono());
            emailField.setText(contacto.getEmail());
            addressField.setText(contacto.getDireccion());
            
            switch (contacto.getEstadoCivil()) {
                case "Soltero" -> solteroButton.setSelected(true);
                case "Casado" -> casadoButton.setSelected(true);
                case "Unión Libre" -> unionLibreButton.setSelected(true);
                case "Divorciado" -> divorciadoButton.setSelected(true);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un contacto para editar", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para obtener el estado civil seleccionado
    private String getEstadoCivil() {
        if (solteroButton.isSelected()) return "Soltero";
        if (casadoButton.isSelected()) return "Casado";
        if (unionLibreButton.isSelected()) return "Unión Libre";
        if (divorciadoButton.isSelected()) return "Divorciado";
        return "";
    }

    // Método para eliminar el contacto seleccionado
    private void eliminarContacto() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar el contacto?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                contactos.remove(selectedRow);
                tableModel.removeRow(selectedRow);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un contacto para eliminar", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para añadir atajos de teclado
    private void addKeyboardShortcuts() {
        addKeyBinding(KeyEvent.VK_N, "Nuevo", e -> mostrarFormulario());
        addKeyBinding(KeyEvent.VK_E, "Editar", e -> editarContacto());
        addKeyBinding(KeyEvent.VK_D, "Eliminar", e -> eliminarContacto());
        addKeyBinding(KeyEvent.VK_ENTER, "Guardar", e -> guardarContacto());
    }

    // Método para asignar atajos de teclado
    private void addKeyBinding(int keyCode, String name, ActionListener action) {
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke(keyCode, 0), name);
        getRootPane().getActionMap().put(name, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action.actionPerformed(e);
            }
        });
    }

    // Método para buscar contacto por nombre o teléfono
    private void buscarContacto() {
        String searchText = searchField.getText().trim();
        if (searchText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el nombre o teléfono del contacto a buscar", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equalsIgnoreCase(searchText) || contacto.getTelefono().equals(searchText)) {
                JOptionPane.showMessageDialog(this, "Contacto encontrado:\n" + contacto, "Contacto Encontrado", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Contacto no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
    }
   
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            App app = new App();
            app.setVisible(true);
        });
}
}
