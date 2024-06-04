/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import controlador.ReservaController;
import modelo.Reserva;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Ventana en la que se solicita al usuario el id de una reserva para abrir la ventana de editar detalles de esa reserva.
 */
public class ModificarReservaFrame extends JFrame {

    private JTextField idReservaField;
    private JButton buscarButton;
    private ReservaController reservaController;

    public ModificarReservaFrame() {
        setTitle("Modificar Reserva");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        reservaController = new ReservaController();

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel idReservaLabel = new JLabel("ID de la Reserva:");
        idReservaField = new JTextField();
        panel.add(idReservaLabel);
        panel.add(idReservaField);

        buscarButton = new JButton("Buscar Reserva");
        buscarButton.addActionListener(e -> {
            String idReserva = idReservaField.getText();
            if (!reservaController.reservaExiste(idReserva)) {
                JOptionPane.showMessageDialog(null, "No se encontró la reserva o está cancelada");
                dispose();
                return;
            }

            new EditarDetallesReservaFrame(idReserva, reservaController).setVisible(true);
            dispose();
        });
        panel.add(buscarButton);

        add(panel);
        setVisible(true);
    }
}



