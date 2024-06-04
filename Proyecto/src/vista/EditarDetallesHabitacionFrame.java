/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import controlador.HabitacionController;
import modelo.Habitacion;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ventana donde se muestran los detalles de una habitación para editarlos.
 */
public class EditarDetallesHabitacionFrame extends JFrame {

    private JTextField tipoHabitacionField;
    private JTextField capacidadField;
    private JTextField precioField;
    private JTextField comodidadesField;
    private JButton editarButton;

    public EditarDetallesHabitacionFrame(Habitacion habitacion, HabitacionController habitacionController) {
        setTitle("Editar Detalles de Habitación");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel tipoHabitacionLabel = new JLabel("Tipo de Habitación:");
        tipoHabitacionField = new JTextField(habitacion.getTipo());
        panel.add(tipoHabitacionLabel);
        panel.add(tipoHabitacionField);

        JLabel capacidadLabel = new JLabel("Capacidad:");
        capacidadField = new JTextField(String.valueOf(habitacion.getCapacidad()));
        panel.add(capacidadLabel);
        panel.add(capacidadField);

        JLabel precioLabel = new JLabel("Precio:");
        precioField = new JTextField(String.valueOf(habitacion.getPrecio()));
        panel.add(precioLabel);
        panel.add(precioField);

        JLabel comodidadesLabel = new JLabel("Comodidades:");
        comodidadesField = new JTextField(habitacion.getComodidades());
        panel.add(comodidadesLabel);
        panel.add(comodidadesField);

        editarButton = new JButton("Editar Habitación");
        editarButton.addActionListener(e -> {
            String tipoHabitacion = tipoHabitacionField.getText();
            String capacidadStr = capacidadField.getText();
            String precioStr = precioField.getText();
            String comodidades = comodidadesField.getText();

            //evitar campos vacíos
            if (tipoHabitacion.isEmpty() || capacidadStr.isEmpty() || precioStr.isEmpty() || comodidades.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe llenar todos los campos correctamente");
                return;
            }

            int capacidad = Integer.parseInt(capacidadStr);
            double precio = Double.parseDouble(precioStr);

            Habitacion nuevaHabitacion = new Habitacion(tipoHabitacion, capacidad, precio, comodidades, habitacion.getCodigo());
            nuevaHabitacion.getReservas().addAll(habitacion.getReservas());

            if (habitacionController.editarHabitacion(habitacion.getCodigo(), nuevaHabitacion)) {
                JOptionPane.showMessageDialog(null, "Habitación editada exitosamente");
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Error al editar habitación");
            }
        });
        panel.add(editarButton);

        add(panel);
        setVisible(true);
    }
}
