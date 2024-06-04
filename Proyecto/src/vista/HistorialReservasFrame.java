/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import controlador.ReservaController;
import modelo.Reserva;
import modelo.Usuario;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Ventana en la que se muestran los datos de todas las reservas que ha hecho un usuario.
 */
public class HistorialReservasFrame extends JFrame {

    private JTextArea resultadoArea;

    public HistorialReservasFrame(List<Reserva> reservasDelCliente) {
        setTitle("Historial de Reservas");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        resultadoArea = new JTextArea();
        resultadoArea.setEditable(false);
        panel.add(new JScrollPane(resultadoArea));

        add(panel);
        setVisible(true);

        mostrarReservas(reservasDelCliente);
    }

    private void mostrarReservas(List<Reserva> reservasDelCliente) {
        resultadoArea.setText("");
        for (Reserva reserva : reservasDelCliente) {
            resultadoArea.append("ID: " + reserva.getId() + "\n");
            resultadoArea.append("Nombre: " + reserva.getNombre() + "\n");
            resultadoArea.append("Fecha de Llegada: " + reserva.getFechaLlegada() + "\n");
            resultadoArea.append("Fecha de Salida: " + reserva.getFechaSalida() + "\n");
            resultadoArea.append("Número de Huéspedes: " + reserva.getNumeroHuespedes() + "\n");
            resultadoArea.append("Código de la Habitación: " + reserva.getHabitacion().getCodigo() + "\n");
            resultadoArea.append("Estado de la Reserva: " + reserva.getEstado() + "\n");
            resultadoArea.append("\n");
        }
    }
}




