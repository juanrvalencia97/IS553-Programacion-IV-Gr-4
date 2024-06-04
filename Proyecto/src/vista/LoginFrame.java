/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import controlador.LoginController;
import modelo.Administrador;
import modelo.Usuario;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Ventana de login para la autenticación de usuarios y administradores.
 */
public class LoginFrame extends JFrame {
    private JTextField correoField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;
    private JLabel titleLabel;

    private ArrayList<Usuario> usuariosRegistrados;
    private ArrayList<Administrador> administradoresRegistrados;
    private LoginController loginController;

    /**
     * Constructor de la clase LoginFrame.
     * 
     * @param usuariosRegistrados Lista de usuarios registrados.
     * @param administradoresRegistrados Lista de administradores registrados.
     */
    public LoginFrame(ArrayList<Usuario> usuariosRegistrados, ArrayList<Administrador> administradoresRegistrados) {
        this.usuariosRegistrados = usuariosRegistrados;
        this.administradoresRegistrados = administradoresRegistrados;
        this.loginController = new LoginController(usuariosRegistrados, administradoresRegistrados);

        setTitle("Inicio de Sesión");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        titleLabel = new JLabel("Bienvenido a MyHotel");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Cambiar el tamaño y el estilo de la fuente
        panel.add(titleLabel);

        JLabel correoLabel = new JLabel("Correo:");
        correoField = new JTextField();
        panel.add(correoLabel);
        panel.add(correoField);

        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordField = new JPasswordField();
        panel.add(passwordLabel);
        panel.add(passwordField);

        loginButton = new JButton("Iniciar Sesión");
        loginButton.addActionListener(e -> {
            String correo = correoField.getText();
            String password = new String(passwordField.getPassword());

            Usuario usuario = loginController.autenticarUsuario(correo, password);
            if (usuario != null) {
                JOptionPane.showMessageDialog(null, "Login exitoso");
                dispose();
                new AccionesClienteFrame(usuariosRegistrados, administradoresRegistrados, usuario).setVisible(true);
            } else {
                Administrador administrador = loginController.autenticarAdministrador(correo, password);
                if (administrador != null) {
                    JOptionPane.showMessageDialog(null, "Login exitoso");
                    dispose();
                    new AccionesAdministradorFrame(usuariosRegistrados, administradoresRegistrados).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Correo o contraseña incorrectos");
                }
            }
        });
        panel.add(loginButton);

        registerButton = new JButton("Registrar");
        registerButton.addActionListener(e -> {
            new RegistroFrame(usuariosRegistrados, administradoresRegistrados).setVisible(true);
            dispose();
        });
        panel.add(registerButton);

        add(panel);
        setVisible(true);
    }
}




