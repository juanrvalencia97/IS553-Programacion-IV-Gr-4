/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import controlador.ReservaController;
import modelo.Reserva;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

/**
 * Ventana donde se muestran los detalles actuales de una reserva, y se permite editarlos. 
 */
public class EditarDetallesReservaFrame extends JFrame {

    private JTextField idField;
    private JTextField nombreField;
    private JTextField fechaLlegadaField;
    private JTextField fechaSalidaField;
    private JTextField numeroHuespedesField;
    private JButton editarButton;

    private ReservaController reservaController;
    private Reserva reserva;

    public EditarDetallesReservaFrame(String idReserva, ReservaController reservaController) {
        this.reservaController = reservaController;
        this.reserva = reservaController.buscarReserva(idReserva);

        if (reserva == null) {
            JOptionPane.showMessageDialog(null, "No se encontró la reserva");
            dispose();
            return;
        }

        setTitle("Editar Detalles de Reserva");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        JLabel idLabel = new JLabel("ID de la Reserva:");
        idField = new JTextField(reserva.getId());
        idField.setEditable(false);
        panel.add(idLabel);
        panel.add(idField);

        JLabel nombreLabel = new JLabel("Nombre:");
        nombreField = new JTextField(reserva.getNombre());
        panel.add(nombreLabel);
        panel.add(nombreField);

        JLabel fechaLlegadaLabel = new JLabel("Fecha de Llegada (dd-MM-yyyy):");
        fechaLlegadaField = new JTextField(reserva.getFechaLlegada().format(formatter));
        panel.add(fechaLlegadaLabel);
        panel.add(fechaLlegadaField);

        JLabel fechaSalidaLabel = new JLabel("Fecha de Salida (dd-MM-yyyy):");
        fechaSalidaField = new JTextField(reserva.getFechaSalida().format(formatter));
        panel.add(fechaSalidaLabel);
        panel.add(fechaSalidaField);

        JLabel numeroHuespedesLabel = new JLabel("Número de Huéspedes:");
        numeroHuespedesField = new JTextField(String.valueOf(reserva.getNumeroHuespedes()));
        panel.add(numeroHuespedesLabel);
        panel.add(numeroHuespedesField);

        editarButton = new JButton("Editar Reserva");
        editarButton.addActionListener(e -> {
            String nombre = nombreField.getText();
            String fechaLlegadaStr = fechaLlegadaField.getText();
            String fechaSalidaStr = fechaSalidaField.getText();
            int numeroHuespedes = Integer.parseInt(numeroHuespedesField.getText());

            if (nombre.isEmpty() || fechaLlegadaStr.isEmpty() || fechaSalidaStr.isEmpty() || numeroHuespedes <= 0) {
                JOptionPane.showMessageDialog(null, "Debe llenar todos los campos correctamente");
                return;
            }

            try {
                LocalDate fechaLlegada = LocalDate.parse(fechaLlegadaStr, formatter);
                LocalDate fechaSalida = LocalDate.parse(fechaSalidaStr, formatter);

                if (fechaLlegada.isAfter(fechaSalida)) {
                    JOptionPane.showMessageDialog(null, "La fecha de llegada debe ser anterior a la fecha de salida");
                    return;
                }

                ArrayList<Reserva> reservasExistentes = reservaController.obtenerReservas();
                for (Reserva r : reservasExistentes) {
                    if (!r.getId().equals(reserva.getId()) &&
                        r.getHabitacion().equals(reserva.getHabitacion()) &&
                        !(fechaSalida.isBefore(r.getFechaLlegada()) || fechaLlegada.isAfter(r.getFechaSalida()))) {
                        JOptionPane.showMessageDialog(null, "Las fechas ingresadas coinciden con otra reserva existente");
                        return;
                    }
                }

                reserva.setNombre(nombre);
                reserva.setFechaLlegada(fechaLlegada);
                reserva.setFechaSalida(fechaSalida);
                reserva.setNumeroHuespedes(numeroHuespedes);

                if (reservaController.editarReserva(reserva)) {
                    JOptionPane.showMessageDialog(null, "Reserva modificada exitosamente");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al modificar la reserva");
                }
            } catch (DateTimeParseException ex) {
                JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto. Use dd-MM-yyyy");
            }
        });
        panel.add(editarButton);

        add(panel);
        setVisible(true);
    }
}




