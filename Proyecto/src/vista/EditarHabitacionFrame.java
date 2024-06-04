/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import controlador.HabitacionController;
import modelo.Habitacion;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Ventana donde se le permite al adminstrador editar los datos de una habtiación existente.
 */
public class EditarHabitacionFrame extends JFrame {

    private JTextField codigoField;
    private JButton buscarButton;
    private HabitacionController habitacionController;

    public EditarHabitacionFrame() {
        setTitle("Editar Habitación");
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

        buscarButton = new JButton("Buscar Habitación");
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = codigoField.getText();
                Habitacion habitacion = habitacionController.buscarHabitacion(codigo);

                if (habitacion != null) {
                    // Si se encuentra la habitación, abrir una nueva ventana para editarla
                    new EditarDetallesHabitacionFrame(habitacion, habitacionController).setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró la habitación");
                }
            }
        });
        panel.add(buscarButton);

        add(panel);
        setVisible(true);
    }
}