/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Usuario;

import java.util.ArrayList;

/**
 * Controlador para manejar el registro de nuevos usuarios.
 */
public class RegistroController {
    private ArrayList<Usuario> usuariosRegistrados;

    /**
     * Constructor de la clase RegistroController.
     * 
     * @param usuariosRegistrados Lista de usuarios registrados.
     */
    public RegistroController(ArrayList<Usuario> usuariosRegistrados) {
        this.usuariosRegistrados = usuariosRegistrados;
    }

    /**
     * Registra un nuevo usuario.
     * 
     * @param tipoIdentificacion Tipo de identificación del usuario.
     * @param documentoIdentificacion Documento de identificación del usuario.
     * @param nombres Nombres del usuario.
     * @param apellidos Apellidos del usuario.
     * @param correo Correo electrónico del usuario.
     * @param direccion Dirección de residencia del usuario.
     * @param ciudad Ciudad de residencia del usuario.
     * @param telefono Teléfono de contacto del usuario.
     * @param password Contraseña del usuario.
     * @return true si el registro fue exitoso, false si el usuario ya existe.
     */
    public boolean registrarUsuario(String tipoIdentificacion, String documentoIdentificacion, String nombres, String apellidos, String correo, String direccion, String ciudad, String telefono, String password) {
        for (Usuario usuario : usuariosRegistrados) {
            if (usuario.getCorreo().equals(correo) || usuario.getDocumentoIdentificacion().equals(documentoIdentificacion)) {
                return false; // El usuario ya existe
            }
        }
        Usuario nuevoUsuario = new Usuario(tipoIdentificacion, documentoIdentificacion, nombres, apellidos, correo, direccion, ciudad, telefono, password);
        usuariosRegistrados.add(nuevoUsuario);
        return true;
    }
}



