/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Usuario;

import java.util.ArrayList;

/**
 * Controlador para manejar la lista de usuarios y la autenticación.
 */
public class UsuarioController {

    private static ArrayList<Usuario> usuariosRegistrados;

    /**
     * Constructor de la clase UsuarioController.
     * 
     * @param usuariosRegistrados Lista de usuarios registrados.
     */
    public UsuarioController(ArrayList<Usuario> usuariosRegistrados) {
        this.usuariosRegistrados = usuariosRegistrados;
    }

    /**
     * Autentica a un usuario.
     * 
     * @param username Nombre de usuario.
     * @param password Contraseña del usuario.
     * @return El usuario autenticado, o null si la autenticación falla.
     */
    public Usuario autenticarUsuario(String username, String password) {
        for (Usuario usuario : usuariosRegistrados) {
            if (usuario.getCorreo().equals(username) && usuario.getPassword().equals(password)) {
                return usuario;
            }
        }
        return null;
    }
}

