/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import controlador.AdministradorController;

import javax.swing.*;
import java.awt.*;

/**
 * Ventana para agregar un nuevo administrador.
 */
public class AgregarNuevoAdminFrame extends JFrame {
    private JTextField tipoIdentificacionField;
    private JTextField documentoIdentificacionField;
    private JTextField nombresField;
    private JTextField apellidosField;
    private JTextField correoField;
    private JPasswordField passwordField;
    private JButton registerButton;

    private AdministradorController administradorController;

    /**
     * Constructor de la clase AgregarNuevoAdminFrame.
     * 
     * @param administradorController Controlador de administradores.
     */
    public AgregarNuevoAdminFrame(AdministradorController administradorController) {
        this.administradorController = administradorController;

        setTitle("Agregar Nuevo Administrador");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(new JLabel("Tipo de Identificación:"));
        tipoIdentificacionField = new JTextField();
        panel.add(tipoIdentificacionField);

        panel.add(new JLabel("Documento de Identificación:"));
        documentoIdentificacionField = new JTextField();
        panel.add(documentoIdentificacionField);

        panel.add(new JLabel("Nombres:"));
        nombresField = new JTextField();
        panel.add(nombresField);

        panel.add(new JLabel("Apellidos:"));
        apellidosField = new JTextField();
        panel.add(apellidosField);

        panel.add(new JLabel("Correo Electrónico:"));
        correoField = new JTextField();
        panel.add(correoField);

        panel.add(new JLabel("Contraseña:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        registerButton = new JButton("Registrar");
        registerButton.addActionListener(e -> {
            String tipoIdentificacion = tipoIdentificacionField.getText();
            String documentoIdentificacion = documentoIdentificacionField.getText();
            String nombres = nombresField.getText();
            String apellidos = apellidosField.getText();
            String correo = correoField.getText();
            String password = new String(passwordField.getPassword());

            if (tipoIdentificacion.isEmpty() || documentoIdentificacion.isEmpty() || nombres.isEmpty() || apellidos.isEmpty() || correo.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
                return;
            }

            if (administradorController.registrarAdministrador(tipoIdentificacion, documentoIdentificacion, nombres, apellidos, correo, password)) {
                JOptionPane.showMessageDialog(null, "Administrador registrado exitosamente");
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "El administrador ya existe");
            }
        });
        panel.add(registerButton);

        add(panel);
        setVisible(true);
    }
}

