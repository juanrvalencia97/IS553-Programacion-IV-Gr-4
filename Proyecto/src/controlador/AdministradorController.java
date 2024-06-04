/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Administrador;

import java.util.ArrayList;

/**
 * Controlador para manejar la lista de adminstradores.
 */
public class AdministradorController {
    private static ArrayList<Administrador> administradoresRegistrados;

    /**
     * Constructor de la clase.
     * 
     * @param administradoresRegistrados la lista de adminstradores existentes
     */
    public AdministradorController(ArrayList<Administrador> administradoresRegistrados) {
        this.administradoresRegistrados = administradoresRegistrados;
    }

    /**
     * registrar un nuevo adminstrador
     * 
     * @param tipoIdentificacion el tipo de identificación del administrador.
     * @param documentoIdentificacion el documento de identificación del administrador.
     * @param nombres el nombre del adminstrador.
     * @param apellidos el apellido del adminstrador.
     * @param correo el correo del adminstrador.
     * @param password la contraseña del adminstrador para autenticarse.
     * 
     * @return booleano que confirma si el registro fue exitoso o no.
     * 
     */
    public boolean registrarAdministrador(String tipoIdentificacion, String documentoIdentificacion, String nombres, String apellidos, String correo, String password) {
        for (Administrador administrador : administradoresRegistrados) {
            if (administrador.getCorreo().equals(correo) || administrador.getDocumentoIdentificacion().equals(documentoIdentificacion)) {
                return false; // El administrador ya existe
            }
        }
        Administrador nuevoAdministrador = new Administrador(tipoIdentificacion, documentoIdentificacion, nombres, apellidos, correo, password);
        administradoresRegistrados.add(nuevoAdministrador);
        return true;
    }
}
