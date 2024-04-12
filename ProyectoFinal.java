/* Taller Java Swing
* Autor: Juan Alejandro Rojas Valencia
* Objetivo: implementar un sistema básico de inicio de sesión y registro de usuarios utilizando Java Swing
*/

//Clases externas utilizadas
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//Clase Principal
public class ProyectoFinal {
    //Lista que almacena los datos de usuarios registrados en el 
    public static ArrayList<String[]> usuarios = new ArrayList<>();

    public static final int TIPO_IDENTIFICACION = 0;
    public static final int DOCUMENTO_IDENTIFICACION = 1;
    public static final int NOMBRES = 2;
    public static final int APELLIDOS = 3;
    public static final int CORREO_ELECTRONICO = 4;
    public static final int DIRECCION_RESIDENCIA = 5;
    public static final int CIUDAD_RESIDENCIA = 6;
    public static final int TELEFONO_CONTACTO = 7;
    public static final int CONTRASENA = 8;

    //Metodo principal
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                mostrarVentanaLogin();
            }
        });
    }

    //Metodo que muestra la ventana de inicio de sesion
    public static void mostrarVentanaLogin() {
        JFrame frame = new JFrame("Inicio de Sesión");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel labelCorreo = new JLabel("Correo electrónico:");
        JTextField campoCorreo = new JTextField(20);
        JLabel labelContrasena = new JLabel("Contraseña:");
        JPasswordField campoContrasena = new JPasswordField(20);

        JButton botonLogin = new JButton("Iniciar Sesión");
        JButton botonRegistro = new JButton("Registrarse como cliente");

        //Accion al presionar el boton de iniciar sesion
        botonLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String correo = campoCorreo.getText();
                String contrasena = new String(campoContrasena.getPassword());
                //Verificar credenciales
                if (iniciarSesion(correo, contrasena)) {
                    JOptionPane.showMessageDialog(null, "Bienvenido a MyHotel");
                } else {
                    JOptionPane.showMessageDialog(null, "Credenciales incorrectas, intente nuevamente.");
                }
            }
        });

        //Accion al presionar el boton de registro
        botonRegistro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarVentanaRegistro();
                frame.dispose(); // Cerrar la ventana de inicio de sesión
            }
        });

        //Anadir componentes al panel
        panel.add(labelCorreo);
        panel.add(campoCorreo);
        panel.add(labelContrasena);
        panel.add(campoContrasena);
        panel.add(botonLogin);
        panel.add(botonRegistro);

        //Anadir panel al frame y mostrar la ventana
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    //Metodo que muestra la ventana de registro de usuario
    public static void mostrarVentanaRegistro() {
        JFrame frame = new JFrame("Registro de Usuario");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        //Creacion de etiquetas y campos de texto para el formulario
        JLabel labelTipoIdentificacion = new JLabel("Tipo de identificación:");
        JTextField campoTipoIdentificacion = new JTextField(20);
        JLabel labelDocumentoIdentificacion = new JLabel("Documento de identificación:");
        JTextField campoDocumentoIdentificacion = new JTextField(20);
        JLabel labelNombres = new JLabel("Nombres:");
        JTextField campoNombres = new JTextField(20);
        JLabel labelApellidos = new JLabel("Apellidos:");
        JTextField campoApellidos = new JTextField(20);
        JLabel labelCorreoElectronico = new JLabel("Correo electrónico:");
        JTextField campoCorreoElectronico = new JTextField(20);
        JLabel labelDireccionResidencia = new JLabel("Dirección de residencia:");
        JTextField campoDireccionResidencia = new JTextField(20);
        JLabel labelCiudadResidencia = new JLabel("Ciudad de residencia:");
        JTextField campoCiudadResidencia = new JTextField(20);
        JLabel labelTelefonoContacto = new JLabel("Teléfono de contacto:");
        JTextField campoTelefonoContacto = new JTextField(20);
        JLabel labelContrasena = new JLabel("Contraseña:");
        JPasswordField campoContrasena = new JPasswordField(20);
        JLabel labelConfirmarContrasena = new JLabel("Confirmar Contraseña:");
        JPasswordField campoConfirmarContrasena = new JPasswordField(20);

        JButton botonRegistrar = new JButton("Registrar Usuario");

        //Accion al presionar el boton de registrar
        botonRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Obtener los valores de los campos de texto
                String tipoIdentificacion = campoTipoIdentificacion.getText();
                String documentoIdentificacion = campoDocumentoIdentificacion.getText();
                String nombres = campoNombres.getText();
                String apellidos = campoApellidos.getText();
                String correoElectronico = campoCorreoElectronico.getText();
                String direccionResidencia = campoDireccionResidencia.getText();
                String ciudadResidencia = campoCiudadResidencia.getText();
                String telefonoContacto = campoTelefonoContacto.getText();
                String contrasena = new String(campoContrasena.getPassword());
                String confirmarContrasena = new String(campoConfirmarContrasena.getPassword());

                //Validar contrasena y registro del usuario
                if (!contrasena.equals(confirmarContrasena)) {
                    JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden. Intente nuevamente.");
                } else {
                    registrarUsuario(tipoIdentificacion, documentoIdentificacion, nombres, apellidos,
                            correoElectronico, direccionResidencia, ciudadResidencia, telefonoContacto, contrasena);
                    JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente.");
                    frame.dispose(); // Cerrar la ventana de registro
                    mostrarVentanaLogin(); // Volver a la ventana de inicio de sesión
                }
            }
        });

        //Colocar los componentes al panel
        panel.add(labelTipoIdentificacion);
        panel.add(campoTipoIdentificacion);
        panel.add(labelDocumentoIdentificacion);
        panel.add(campoDocumentoIdentificacion);
        panel.add(labelNombres);
        panel.add(campoNombres);
        panel.add(labelApellidos);
        panel.add(campoApellidos);
        panel.add(labelCorreoElectronico);
        panel.add(campoCorreoElectronico);
        panel.add(labelDireccionResidencia);
        panel.add(campoDireccionResidencia);
        panel.add(labelCiudadResidencia);
        panel.add(campoCiudadResidencia);
        panel.add(labelTelefonoContacto);
        panel.add(campoTelefonoContacto);
        panel.add(labelContrasena);
        panel.add(campoContrasena);
        panel.add(labelConfirmarContrasena);
        panel.add(campoConfirmarContrasena);
        //Colocar boton de registro en el panel
        panel.add(botonRegistrar);

        //Anadir panel al frame y mostrar la ventana
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    //Metodo para registrar un nuevo usuario en la lista de usuarios
    public static void registrarUsuario(String tipoIdentificacion, String documentoIdentificacion, String nombres,
                                        String apellidos, String correoElectronico, String direccionResidencia,
                                        String ciudadResidencia, String telefonoContacto, String contrasena) {
        String[] usuario = new String[9];  
        usuario[TIPO_IDENTIFICACION] = tipoIdentificacion;
        usuario[DOCUMENTO_IDENTIFICACION] = documentoIdentificacion;
        usuario[NOMBRES] = nombres;
        usuario[APELLIDOS] = apellidos;
        usuario[CORREO_ELECTRONICO] = correoElectronico;
        usuario[DIRECCION_RESIDENCIA] = direccionResidencia;
        usuario[CIUDAD_RESIDENCIA] = ciudadResidencia;
        usuario[TELEFONO_CONTACTO] = telefonoContacto;
        usuario[CONTRASENA] = contrasena;
        usuarios.add(usuario);
    }

    //Metodo para iniciar sesion comparando correo electronico y contrasena con las registros existentes
    public static boolean iniciarSesion(String correoElectronico, String contrasena) {
        for (String[] usuario : usuarios) {
            if (usuario[CORREO_ELECTRONICO].equals(correoElectronico) && usuario[CONTRASENA].equals(contrasena)) {
                return true;
            }
        }
        return false;
    }
}
