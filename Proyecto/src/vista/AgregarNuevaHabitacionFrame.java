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
 * Ventana para agregar una nueva habitación.
 * Proporciona una interfaz para que los administradores agreguen nuevas habitaciones al sistema.
 */
public class AgregarNuevaHabitacionFrame extends JFrame {

    private JTextField tipoHabitacionField;
    private JTextField capacidadField;
    private JTextField precioField;
    private JTextField comodidadesField;
    private JTextField codigoField;
    private JButton agregarButton;
    
    private HabitacionController habitacionController;
    /**
     * Constructor de la ventana para agregar una nueva habitación.
     */
    public AgregarNuevaHabitacionFrame() {
        setTitle("Agregar Nueva Habitación");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel tipoHabitacionLabel = new JLabel("Tipo de Habitación:");
        tipoHabitacionField = new JTextField();
        panel.add(tipoHabitacionLabel);
        panel.add(tipoHabitacionField);

        JLabel capacidadLabel = new JLabel("Capacidad:");
        capacidadField = new JTextField();
        panel.add(capacidadLabel);
        panel.add(capacidadField);

        JLabel precioLabel = new JLabel("Precio:");
        precioField = new JTextField();
        panel.add(precioLabel);
        panel.add(precioField);

        JLabel comodidadesLabel = new JLabel("Comodidades:");
        comodidadesField = new JTextField();
        panel.add(comodidadesLabel);
        panel.add(comodidadesField);

        JLabel codigoLabel = new JLabel("Código Único:");
        codigoField = new JTextField();
        panel.add(codigoLabel);
        panel.add(codigoField);

        agregarButton = new JButton("Agregar Habitación");
        
        habitacionController = new HabitacionController();

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipoHabitacion = tipoHabitacionField.getText();
                String capacidadStr = capacidadField.getText();
                String precioStr = precioField.getText();
                String comodidades = comodidadesField.getText();
                String codigo = codigoField.getText();

                if (tipoHabitacion.isEmpty() || capacidadStr.isEmpty() || precioStr.isEmpty() || comodidades.isEmpty() || codigo.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
                    return;
                }

                int capacidad = Integer.parseInt(capacidadStr);
                double precio = Double.parseDouble(precioStr);


                Habitacion habitacion = new Habitacion(tipoHabitacion, capacidad, precio, comodidades, codigo);

                if (habitacionController.agregarHabitacion(habitacion)) {
                    JOptionPane.showMessageDialog(null, "Habitación agregada exitosamente");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al agregar habitación");
                }        
                
            }
        });
        panel.add(agregarButton);

        add(panel);
        setVisible(true);
    }
}
