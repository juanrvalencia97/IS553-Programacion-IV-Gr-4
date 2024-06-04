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
 * Ventana en la que el adminstrador verifica las habitaciones disponibles entre unas fechas determinadas.
 */
public class VerificarDisponibilidadHabitacionesFrame extends JFrame {

    private JTextField fechaInicioField;
    private JTextField fechaFinField;
    private JButton verificarButton;

    private HabitacionController habitacionController;

    public VerificarDisponibilidadHabitacionesFrame() {
        habitacionController = new HabitacionController();

        setTitle("Verificar Disponibilidad de Habitaciones");
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

        verificarButton = new JButton("Verificar");
        verificarButton.addActionListener(e -> {
            String fechaInicioStr = fechaInicioField.getText();
            String fechaFinStr = fechaFinField.getText();

            if (fechaInicioStr.isEmpty() || fechaFinStr.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
                return;
            }

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
        panel.add(verificarButton);

        add(panel);
        setVisible(true);
    }
}




