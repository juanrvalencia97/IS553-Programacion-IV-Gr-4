/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import controlador.AdministradorController;
import modelo.Administrador;
import modelo.Usuario;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Ventana para las acciones del administrador.
 */
public class AccionesAdministradorFrame extends JFrame {
    private AdministradorController administradorController;

    /**
     * Constructor de la clase AccionesAdministradorFrame.
     * 
     * @param usuariosRegistrados Lista de usuarios registrados.
     * @param administradoresRegistrados Lista de administradores registrados.
     */
    public AccionesAdministradorFrame(ArrayList<Usuario> usuariosRegistrados, ArrayList<Administrador> administradoresRegistrados) {
        administradorController = new AdministradorController(administradoresRegistrados);

        setTitle("Acciones del Administrador");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1));
        panel.setBackground(Color.BLUE);

        String[] acciones = {"Verificar Disponibilidad de Habitaciones", "Agregar Nueva Habitación al Inventario", "Editar Habitación del Inventario", "Eliminar Habitación del Inventario", "Agregar Nuevo Administrador", "Salir"};
        for (String accion : acciones) {
            JButton button = new JButton(accion);
            button.setFont(new Font("Arial", Font.BOLD, 14));
            button.setPreferredSize(new Dimension(200, 50));
            button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            button.addActionListener(e -> {
                switch (accion) {
                    case "Verificar Disponibilidad de Habitaciones":
                        new VerificarDisponibilidadHabitacionesFrame().setVisible(true);
                        break;
                    case "Agregar Nueva Habitación al Inventario":
                        new AgregarNuevaHabitacionFrame().setVisible(true);
                        break;
                    case "Editar Habitación del Inventario":
                        new EditarHabitacionFrame().setVisible(true);
                        break;
                    case "Eliminar Habitación del Inventario":
                        new EliminarHabitacionFrame().setVisible(true);
                        break;
                    case "Agregar Nuevo Administrador":
                        new AgregarNuevoAdminFrame(administradorController).setVisible(true);
                        break;
                    case "Salir":
                        dispose();
                        new LoginFrame(usuariosRegistrados, administradoresRegistrados).setVisible(true);
                        break;
                }
            });

            panel.add(button);
        }

        add(panel);
        setVisible(true);
    }
}



