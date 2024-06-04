/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 * Clase que representa a un usuario en el sistema.
 */
public class Usuario {
    private String tipoIdentificacion;
    private String documentoIdentificacion;
    private String nombres;
    private String apellidos;
    private String correo;
    private String direccion;
    private String ciudad;
    private String telefono;
    private String password;

    /**
     * Constructor de la clase Usuario.
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
     */
    public Usuario(String tipoIdentificacion, String documentoIdentificacion, String nombres, String apellidos, String correo, String direccion, String ciudad, String telefono, String password) {
        this.tipoIdentificacion = tipoIdentificacion;
        this.documentoIdentificacion = documentoIdentificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.password = password;
    }

    // Getters
    public String getTipoIdentificacion() { return tipoIdentificacion; }

    public String getDocumentoIdentificacion() { return documentoIdentificacion; }

    public String getNombres() { return nombres; }

    public String getApellidos() { return apellidos; }

    public String getCorreo() { return correo; }

    public String getDireccion() { return direccion; }

    public String getCiudad() { return ciudad; }

    public String getTelefono() { return telefono; }

    public String getPassword() { return password; }
}


