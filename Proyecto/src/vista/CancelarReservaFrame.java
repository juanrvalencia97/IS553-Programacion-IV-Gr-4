/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import controlador.ReservaController;
import modelo.Reserva;

import javax.swing.*;
import java.awt.*;

/**
 * ventana para cancelar reservas existentes.
 */
public class CancelarReservaFrame extends JFrame {

    private JTextField idReservaField;
    private JButton cancelarButton;

    private ReservaController reservaController;

    public CancelarReservaFrame() {
        setTitle("Cancelar Reserva");
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

        cancelarButton = new JButton("Cancelar Reserva");
        cancelarButton.addActionListener(e -> {
            String idReserva = idReservaField.getText();
            Reserva reserva = reservaController.buscarReserva(idReserva);

            if (reserva == null || "Cancelada".equals(reserva.getEstado())) {
                JOptionPane.showMessageDialog(null, "No se encontró la reserva o ya está cancelada");
                return;
            }

            int respuesta = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea cancelar esta reserva?", "Confirmar cancelación", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION) {
                reservaController.cancelarReserva(reserva);
                JOptionPane.showMessageDialog(null, "Reserva cancelada exitosamente");
                dispose();
            }
        });
        panel.add(cancelarButton);

        add(panel);
        setVisible(true);
    }
}


