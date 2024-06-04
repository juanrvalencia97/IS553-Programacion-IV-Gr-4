/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import modelo.Habitacion;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Ventana que muestra todas las habitaciones disponibles entre unas fechas determinadas.
 */
public class HabitacionesDisponiblesFrame extends JFrame {

    public HabitacionesDisponiblesFrame(ArrayList<Habitacion> habitacionesDisponibles) {
        setTitle("Habitaciones Disponibles");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        if (habitacionesDisponibles.isEmpty()) {
            panel.add(new JLabel("No hay habitaciones disponibles en las fechas seleccionadas."));
        } else {
            for (Habitacion habitacion : habitacionesDisponibles) {
                panel.add(new JLabel("Habitación: " + habitacion.getCodigo() + " - Tipo: " + habitacion.getTipo()));
            }
        }

        add(panel);
        setVisible(true);
    }
}

