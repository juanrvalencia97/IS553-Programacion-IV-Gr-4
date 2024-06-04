/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 * Clase que representa a un administrador en el sistema.
 */
public class Administrador {
    private String tipoIdentificacion;
    private String documentoIdentificacion;
    private String nombres;
    private String apellidos;
    private String correo;
    private String password;

    /**
     * Constructor de la clase Administrador.
     * 
     * @param tipoIdentificacion Tipo de identificación del administrador.
     * @param documentoIdentificacion Documento de identificación del administrador.
     * @param nombres Nombres del administrador.
     * @param apellidos Apellidos del administrador.
     * @param correo Correo electrónico del administrador.
     * @param password Contraseña del administrador.
     */
    public Administrador(String tipoIdentificacion, String documentoIdentificacion, String nombres, String apellidos, String correo, String password) {
        this.tipoIdentificacion = tipoIdentificacion;
        this.documentoIdentificacion = documentoIdentificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.password = password;
    }

    //Getters
    public String getTipoIdentificacion() { return tipoIdentificacion; }

    public String getDocumentoIdentificacion() { return documentoIdentificacion; }

    public String getNombres() { return nombres; }

    public String getApellidos() { return apellidos; }

    public String getCorreo() { return correo; }

    public String getPassword() { return password; }
}

