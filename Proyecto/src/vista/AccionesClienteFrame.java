/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package vista;

import controlador.ReservaController;
import modelo.Administrador;
import modelo.Reserva;
import modelo.Usuario;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Ventana para las acciones del cliente.
 */
public class AccionesClienteFrame extends JFrame {
    private ReservaController reservaController = new ReservaController();
    private ArrayList<Usuario> usuariosRegistrados;
    private ArrayList<Administrador> administradoresRegistrados;
    private Usuario usuario;

    /**
     * Constructor de la clase AccionesClienteFrame.
     * 
     * @param usuariosRegistrados Lista de usuarios registrados.
     * @param administradoresRegistrados Lista de administradores registrados.
     */
    public AccionesClienteFrame(ArrayList<Usuario> usuariosRegistrados, ArrayList<Administrador> administradoresRegistrados, Usuario usuario) {
        this.usuariosRegistrados = usuariosRegistrados;
        this.administradoresRegistrados = administradoresRegistrados;
        this.usuario = usuario;

        setTitle("Acciones del Cliente");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 1));
        panel.setBackground(Color.BLUE);

        String[] acciones = {"Buscar habitaciones disponibles", "Ver detalles de habitación", "Realizar una reserva", "Modificar reserva", "Cancelar reserva", "Historial de reservas", "Salir"};
        for (String accion : acciones) {
            JButton button = new JButton(accion);
            button.addActionListener(e -> {
                switch (accion) {
                    case "Buscar habitaciones disponibles":
                        new BuscarHabitacionesFrame().setVisible(true);
                        break;
                    case "Ver detalles de habitación":
                        new DetallesHabitacionFrame().setVisible(true);
                        break;
                    case "Realizar una reserva":
                        new RealizarReservaFrame(usuario).setVisible(true);
                        break;
                    case "Modificar reserva":
                        new ModificarReservaFrame().setVisible(true);
                        break;
                    case "Cancelar reserva":
                        new CancelarReservaFrame().setVisible(true);
                        break;
                    case "Historial de reservas":
                        ArrayList<Reserva> reservasUsuario = reservaController.obtenerReservasPorUsuario(usuario);
                        new HistorialReservasFrame(reservasUsuario).setVisible(true);
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



