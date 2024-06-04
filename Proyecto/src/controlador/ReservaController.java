/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Habitacion;
import modelo.Reserva;
import modelo.Usuario;

import java.util.ArrayList;
import java.util.List;

public class ReservaController {

    private static ArrayList<Reserva> reservas = new ArrayList<>();

    public boolean agregarReserva(Reserva reserva) {
        Habitacion habitacion = reserva.getHabitacion();
        if (habitacion.estaDisponible(reserva.getFechaLlegada(), reserva.getFechaSalida())) {
            habitacion.agregarReserva(reserva);
            reservas.add(reserva);
            return true;
        }
        return false;
    }

    public ArrayList<Reserva> obtenerReservas() {
        return reservas;
    }

    public ArrayList<Reserva> obtenerReservasPorUsuario(Usuario usuario) {
        ArrayList<Reserva> reservasUsuario = new ArrayList<>();
        for (Reserva reserva : reservas) {
            if (reserva.getUsuario().equals(usuario)) {
                reservasUsuario.add(reserva);
            }
        }
        return reservasUsuario;
    }

    public Reserva buscarReserva(String id) {
        for (Reserva reserva : reservas) {
            if (reserva.getId().equals(id)) {
                return reserva;
            }
        }
        return null;
    }

    public void cancelarReserva(Reserva reserva) {
        reserva.setEstado("Cancelada");
        reserva.getHabitacion().getReservas().remove(reserva);
    }

    public boolean editarReserva(Reserva reservaActualizada) {
        for (int i = 0; i < reservas.size(); i++) {
            if (reservas.get(i).getId().equals(reservaActualizada.getId())) {
                reservas.set(i, reservaActualizada);
                return true;
            }
        }
        return false;
    }

    public boolean reservaExiste(String id) {
        Reserva reserva = buscarReserva(id);
        return reserva != null && !"Cancelada".equals(reserva.getEstado());
    }
}





