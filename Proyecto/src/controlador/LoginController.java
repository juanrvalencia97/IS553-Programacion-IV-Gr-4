/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Administrador;
import modelo.Usuario;

import java.util.ArrayList;

/**
 * Controlador para manejar la autenticación de usuarios y administradores.
 */
public class LoginController {
    private ArrayList<Usuario> usuariosRegistrados;
    private ArrayList<Administrador> administradoresRegistrados;

    /**
     * Constructor de la clase LoginController.
     * 
     * @param usuariosRegistrados Lista de usuarios registrados.
     * @param administradoresRegistrados Lista de administradores registrados.
     */
    public LoginController(ArrayList<Usuario> usuariosRegistrados, ArrayList<Administrador> administradoresRegistrados) {
        this.usuariosRegistrados = usuariosRegistrados;
        this.administradoresRegistrados = administradoresRegistrados;
    }

    /**
     * Autentica a un usuario.
     * 
     * @param correo Correo electrónico del usuario.
     * @param password Contraseña del usuario.
     * @return El usuario autenticado, o null si la autenticación falla.
     */
    public Usuario autenticarUsuario(String correo, String password) {
        for (Usuario usuario : usuariosRegistrados) {
            if (usuario.getCorreo().equals(correo) && usuario.getPassword().equals(password)) {
                return usuario;
            }
        }
        return null;
    }

    /**
     * Autentica a un administrador.
     * 
     * @param correo Correo electrónico del administrador.
     * @param password Contraseña del administrador.
     * @return El administrador autenticado, o null si la autenticación falla.
     */
    public Administrador autenticarAdministrador(String correo, String password) {
        for (Administrador administrador : administradoresRegistrados) {
            if (administrador.getCorreo().equals(correo) && administrador.getPassword().equals(password)) {
                return administrador;
            }
        }
        return null;
    }
}



