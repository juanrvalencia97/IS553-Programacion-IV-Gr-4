/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import controlador.HabitacionController;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Ventana donde se le permite al adminstrador eliminar una habitación existente.
 */
public class EliminarHabitacionFrame extends JFrame {

    private JTextField codigoField;
    private JButton eliminarButton;

    private HabitacionController habitacionController;

    public EliminarHabitacionFrame() {
        setTitle("Eliminar Habitación");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        habitacionController = new HabitacionController();

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel codigoLabel = new JLabel("Código de la Habitación:");
        codigoField = new JTextField();
        panel.add(codigoLabel);
        panel.add(codigoField);

        eliminarButton = new JButton("Eliminar Habitación");
        eliminarButton.addActionListener(e -> {
            String codigo = codigoField.getText();

            if (habitacionController.eliminarHabitacion(codigo)) {
                JOptionPane.showMessageDialog(null, "Habitación eliminada exitosamente");
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar habitación");
            }
        });
        panel.add(eliminarButton);

        add(panel);
        setVisible(true);
    }
}


