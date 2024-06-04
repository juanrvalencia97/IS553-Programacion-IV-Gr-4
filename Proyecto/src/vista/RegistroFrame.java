/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import controlador.RegistroController;
import modelo.Administrador;
import modelo.Usuario;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Ventana para el registro de nuevos usuarios.
 */
public class RegistroFrame extends JFrame {
    private JTextField tipoIdentificacionField;
    private JTextField documentoIdentificacionField;
    private JTextField nombresField;
    private JTextField apellidosField;
    private JTextField correoField;
    private JTextField direccionField;
    private JTextField ciudadField;
    private JTextField telefonoField;
    private JPasswordField passwordField;
    private JPasswordField confirmarPasswordField;
    private JButton registerButton;

    private RegistroController registroController;

    /**
     * Constructor de la clase RegistroFrame.
     * 
     * @param usuariosRegistrados Lista de usuarios registrados.
     * @param administradoresRegistrados Lista de administradores registrados.
     */
    public RegistroFrame(ArrayList<Usuario> usuariosRegistrados, ArrayList<Administrador> administradoresRegistrados) {
        registroController = new RegistroController(usuariosRegistrados);

        setTitle("Registro");
        setSize(400, 500);
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

        panel.add(new JLabel("Dirección de Residencia:"));
        direccionField = new JTextField();
        panel.add(direccionField);

        panel.add(new JLabel("Ciudad de Residencia:"));
        ciudadField = new JTextField();
        panel.add(ciudadField);

        panel.add(new JLabel("Teléfono de Contacto:"));
        telefonoField = new JTextField();
        panel.add(telefonoField);

        panel.add(new JLabel("Contraseña:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        panel.add(new JLabel("Confirmar Contraseña:"));
        confirmarPasswordField = new JPasswordField();
        panel.add(confirmarPasswordField);

        registerButton = new JButton("Registrar");
        registerButton.addActionListener(e -> {
            String tipoIdentificacion = tipoIdentificacionField.getText();
            String documentoIdentificacion = documentoIdentificacionField.getText();
            String nombres = nombresField.getText();
            String apellidos = apellidosField.getText();
            String correo = correoField.getText();
            String direccion = direccionField.getText();
            String ciudad = ciudadField.getText();
            String telefono = telefonoField.getText();
            String password = new String(passwordField.getPassword());
            String confirmarPassword = new String(confirmarPasswordField.getPassword());

            if (tipoIdentificacion.isEmpty() || documentoIdentificacion.isEmpty() || nombres.isEmpty() || apellidos.isEmpty() || correo.isEmpty() || direccion.isEmpty() || ciudad.isEmpty() || telefono.isEmpty() || password.isEmpty() || confirmarPassword.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
                return;
            }

            if (!password.equals(confirmarPassword)) {
                JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
                return;
            }

            if (registroController.registrarUsuario(tipoIdentificacion, documentoIdentificacion, nombres, apellidos, correo, direccion, ciudad, telefono, password)) {
                JOptionPane.showMessageDialog(null, "Registro exitoso");
                dispose();
                new LoginFrame(usuariosRegistrados, administradoresRegistrados).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "El usuario ya existe");
            }
        });
        panel.add(registerButton);

        add(panel);
        setVisible(true);
    }
}

