/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import controlador.HabitacionController;
import controlador.ReservaController;
import modelo.Habitacion;
import modelo.Reserva;
import modelo.Usuario;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Ventana para realizar una reserva.
 */
public class RealizarReservaFrame extends JFrame {

    private JTextField nombreField;
    private JTextField fechaLlegadaField;
    private JTextField fechaSalidaField;
    private JTextField numeroHuespedesField;
    private JTextField codigoHabitacionField;
    private JButton reservarButton;

    private HabitacionController habitacionController;
    private ReservaController reservaController;
    private Usuario usuario;

    /**
     * Constructor de la clase RealizarReservaFrame.
     * 
     * @param usuario El usuario que realiza la reserva.
     */
    public RealizarReservaFrame(Usuario usuario) {
        this.usuario = usuario;

        setTitle("Realizar Reserva");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        habitacionController = new HabitacionController();
        reservaController = new ReservaController();

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel nombreLabel = new JLabel("Nombre:");
        nombreField = new JTextField();
        panel.add(nombreLabel);
        panel.add(nombreField);

        JLabel fechaLlegadaLabel = new JLabel("Fecha de Llegada (dd-MM-yyyy):");
        fechaLlegadaField = new JTextField();
        panel.add(fechaLlegadaLabel);
        panel.add(fechaLlegadaField);

        JLabel fechaSalidaLabel = new JLabel("Fecha de Salida (dd-MM-yyyy):");
        fechaSalidaField = new JTextField();
        panel.add(fechaSalidaLabel);
        panel.add(fechaSalidaField);

        JLabel numeroHuespedesLabel = new JLabel("Número de Huéspedes:");
        numeroHuespedesField = new JTextField();
        panel.add(numeroHuespedesLabel);
        panel.add(numeroHuespedesField);

        JLabel codigoHabitacionLabel = new JLabel("Código de la Habitación:");
        codigoHabitacionField = new JTextField();
        panel.add(codigoHabitacionLabel);
        panel.add(codigoHabitacionField);

        reservarButton = new JButton("Reservar");
        reservarButton.addActionListener(e -> {
            String nombre = nombreField.getText();
            String fechaLlegadaStr = fechaLlegadaField.getText();
            String fechaSalidaStr = fechaSalidaField.getText();
            String numeroHuespedesStr = numeroHuespedesField.getText();
            String codigoHabitacion = codigoHabitacionField.getText();

            if (nombre.isEmpty() || fechaLlegadaStr.isEmpty() || fechaSalidaStr.isEmpty() || numeroHuespedesStr.isEmpty() || codigoHabitacion.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
                return;
            }

            int numeroHuespedes = Integer.parseInt(numeroHuespedesStr);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            try {
                LocalDate fechaLlegada = LocalDate.parse(fechaLlegadaStr, formatter);
                LocalDate fechaSalida = LocalDate.parse(fechaSalidaStr, formatter);

                if (fechaLlegada.isAfter(fechaSalida)) {
                    JOptionPane.showMessageDialog(null, "La fecha de llegada debe ser anterior a la fecha de salida");
                    return;
                }

                Habitacion habitacion = habitacionController.buscarHabitacion(codigoHabitacion);

                if (habitacion != null && habitacion.estaDisponible(fechaLlegada, fechaSalida) && numeroHuespedes <= habitacion.getCapacidad()) {
                    Reserva reserva = new Reserva(nombre, fechaLlegada, fechaSalida, numeroHuespedes, habitacion, usuario);
                    if (reservaController.agregarReserva(reserva)) {
                        JOptionPane.showMessageDialog(null, "Reserva realizada exitosamente. ID de Reserva: " + reserva.getId() + ". Puede consultarlo en su historial de reservas.");
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo realizar la reserva");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo realizar la reserva. La habitación no está disponible o excede la capacidad.");
                }
            } catch (DateTimeParseException ex) {
                JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto. Use dd-MM-yyyy");
            }
        });
        panel.add(reservarButton);

        add(panel);
        setVisible(true);
    }
}




