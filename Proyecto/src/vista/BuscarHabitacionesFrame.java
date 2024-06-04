/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import controlador.HabitacionController;
import modelo.Habitacion;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

/**
 * ventana para buscar habitaciones disponibles en un periodo de tiempo determinado.
 */
public class BuscarHabitacionesFrame extends JFrame {

    private JTextField fechaInicioField;
    private JTextField fechaFinField;
    private JButton buscarButton;

    private HabitacionController habitacionController;

    public BuscarHabitacionesFrame() {
        habitacionController = new HabitacionController();

        setTitle("Buscar Habitaciones Disponibles");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel fechaInicioLabel = new JLabel("Fecha de Inicio (dd-MM-yyyy):");
        fechaInicioField = new JTextField();
        panel.add(fechaInicioLabel);
        panel.add(fechaInicioField);

        JLabel fechaFinLabel = new JLabel("Fecha de Fin (dd-MM-yyyy):");
        fechaFinField = new JTextField();
        panel.add(fechaFinLabel);
        panel.add(fechaFinField);

        buscarButton = new JButton("Buscar");
        buscarButton.addActionListener(e -> {
            String fechaInicioStr = fechaInicioField.getText();
            String fechaFinStr = fechaFinField.getText();

            if (fechaInicioStr.isEmpty() || fechaFinStr.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
                return;
            }

            //formato de fecha
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            try {
                LocalDate fechaInicio = LocalDate.parse(fechaInicioStr, formatter);
                LocalDate fechaFin = LocalDate.parse(fechaFinStr, formatter);

                if (fechaInicio.isAfter(fechaFin)) {
                    JOptionPane.showMessageDialog(null, "La fecha de inicio debe ser anterior a la fecha de fin");
                    return;
                }

                ArrayList<Habitacion> habitacionesDisponibles = habitacionController.obtenerHabitacionesDisponibles(fechaInicio, fechaFin);
                new HabitacionesDisponiblesFrame(habitacionesDisponibles).setVisible(true);
            } catch (DateTimeParseException ex) {
                JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto. Use dd-MM-yyyy");
            }
        });
        panel.add(buscarButton);

        add(panel);
        setVisible(true);
    }
}




