/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import controlador.HabitacionController;
import modelo.Habitacion;
import modelo.Reserva;

import javax.swing.*;
import java.awt.*;

/**
 * Ventana para mostrar los detalles de una habitación.
 */
public class DetallesHabitacionFrame extends JFrame {

    private JTextField codigoHabitacionField;
    private JTextArea detallesArea;
    private JButton buscarButton;

    private HabitacionController habitacionController;

    /**
     * Constructor de la clase DetallesHabitacionFrame.
     */
    public DetallesHabitacionFrame() {
        habitacionController = new HabitacionController();

        setTitle("Detalles de Habitación");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        // Panel superior para el ingreso del código de la habitación
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JLabel codigoHabitacionLabel = new JLabel("Código de la Habitación:");
        topPanel.add(codigoHabitacionLabel);

        codigoHabitacionField = new JTextField(10); // Hacer el campo más pequeño
        topPanel.add(codigoHabitacionField);

        buscarButton = new JButton("Buscar");
        buscarButton.addActionListener(e -> mostrarDetallesHabitacion());
        topPanel.add(buscarButton);

        mainPanel.add(topPanel, BorderLayout.NORTH);

        // Area para mostrar los detalles de la habitación
        detallesArea = new JTextArea();
        detallesArea.setEditable(false);
        detallesArea.setLineWrap(true);
        detallesArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(detallesArea);

        mainPanel.add(scrollPane, BorderLayout.CENTER);

        add(mainPanel);
        setVisible(true);
    }

    private void mostrarDetallesHabitacion() {
        String codigoHabitacion = codigoHabitacionField.getText();
        if (codigoHabitacion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar el código de la habitación");
            return;
        }

        Habitacion habitacion = habitacionController.buscarHabitacion(codigoHabitacion);
        if (habitacion == null) {
            detallesArea.setText("No se encontró la habitación con el código especificado");
        } else {
            detallesArea.setText("Tipo: " + habitacion.getTipo() + "\n"
                                + "Capacidad: " + habitacion.getCapacidad() + "\n"
                                + "Precio: " + habitacion.getPrecio() + "\n"
                                + "Comodidades: " + habitacion.getComodidades() + "\n"
                                + "Reservas: " + habitacion.getReservas().size() + "\n");
            detallesArea.append("Fecha(s):\n");
                for (Reserva reserva : habitacion.getReservas()) {
                    detallesArea.append(" - " + reserva.getFechaLlegada() + " a " + reserva.getFechaSalida() + "\n");
                }
        }
    }
}

