/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectofinal;

import modelo.Administrador;
import modelo.Usuario;
import vista.LoginFrame;

import java.util.ArrayList;

/**
 * Clase principal del proyecto que inicializa la aplicación.
 */
public class ProyectoFinal {

    /**
     * Método principal que inicializa las listas de usuarios y administradores, y lanza la ventana de login.
     * 
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        // Inicializar la lista de usuarios registrados
        ArrayList<Usuario> usuariosRegistrados = new ArrayList<>();
        ArrayList<Administrador> administradoresRegistrados = new ArrayList<>();

        // Agregar un administrador predeterminado
        administradoresRegistrados.add(new Administrador("cedula", "1088826110", "juan", "rojas", "juanrojas@myhotel.com", "1234"));

        // Crear y mostrar la ventana de login
        new LoginFrame(usuariosRegistrados, administradoresRegistrados).setVisible(true);
    }
}


