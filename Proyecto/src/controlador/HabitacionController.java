/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Habitacion;
import modelo.Reserva;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Controlador para manejar las acciones de la habitación.
 */
public class HabitacionController {

    //lista de habitaciones existentes
    private static ArrayList<Habitacion> habitaciones = new ArrayList<>();

    /**
     * agregar una nueva habitación.
     * 
     * @param habitacion la habitación a agregar.
     * 
     * @return booleano que confirma si la habitación fue agregada exitosamente o no.
     */
    public boolean agregarHabitacion(Habitacion habitacion) {
        for (Habitacion h : habitaciones) {
            if (h.getCodigo().equals(habitacion.getCodigo())) {
                return false;
            }
        }
        habitaciones.add(habitacion);
        return true;
    }
    
    /**
     * obtener todas las habitaciones disponibles entre unas fechas determinadas.
     * 
     * @param fechaInicio la fecha de inicio a consultar.
     * @param fechaFin la fecha de salida a consultar.
     * 
     * @return la lista de habitaciones disponibles entre esas fechas.
     */
    public ArrayList<Habitacion> obtenerHabitacionesDisponibles(LocalDate fechaInicio, LocalDate fechaFin) {
        ArrayList<Habitacion> habitacionesDisponibles = new ArrayList<>();

        for (Habitacion habitacion : habitaciones) {
            boolean disponible = true;
            for (Reserva reserva : habitacion.getReservas()) {
                if (!(fechaFin.isBefore(reserva.getFechaLlegada()) || fechaInicio.isAfter(reserva.getFechaSalida()))) {
                    disponible = false;
                    break;
                }
            }
            if (disponible) {
                habitacionesDisponibles.add(habitacion);
            }
        }
        return habitacionesDisponibles;
    }

    /**
     * obtener todas las habitaciones del inventario.
     * 
     *@return la lista completa de habitaciones.
     * 
     */
    public ArrayList<Habitacion> obtenerTodasLasHabitaciones() {
        return habitaciones;
    }

    
    /**
     * Buscar una habitación específica.
     * 
     * @param codigo el código único de la habitación a buscar.
     * 
     * @return la habitación si existe o un null si no existe.
     */
    public Habitacion buscarHabitacion(String codigo) {
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getCodigo().equals(codigo)) {
                return habitacion;
            }
        }
        return null;
    }

    /**
     * verificar si una una habitación específica está disponible entre dos fechas determinadas.
     * 
     * @param codigo el código único de la habitación.
     * @param fechaInicio fecha de entrada a consultar.
     * @param fechaFin fecha de salida a consultar.
     * 
     * @return booleano que confirma si la habitación existe y está disponible entre esas fecha o no.
     */
    public boolean verificarDisponibilidad(String codigo, LocalDate fechaInicio, LocalDate fechaFin) {
        Habitacion habitacion = buscarHabitacion(codigo);
        return habitacion != null && habitacion.estaDisponible(fechaInicio, fechaFin);
    }

    /**
     * editar los datos de una habitación determinada.
     * 
     * @param codigo el código único de la habitación determinada.
     * @param nuevaHabitacion un objeto habitación con los datos nuevos.
     * 
     * @return booleano que confirma si la habitación fue editada exitosamente o no.
     * 
     */
    public boolean editarHabitacion(String codigo, Habitacion nuevaHabitacion) {
        for (int i = 0; i < habitaciones.size(); i++) {
            if (habitaciones.get(i).getCodigo().equals(codigo)) {
                habitaciones.set(i, nuevaHabitacion);
                return true;
            }
        }
        return false;
    }

    /**
     * eliminar una habitación del inventario.
     * 
     * @param codigo el código único de la habitación.
     * 
     * @return booleano que confirma si la habitación fue eliminada exitosamente o no.
     * 
     */
    public boolean eliminarHabitacion(String codigo) {
        for (int i = 0; i < habitaciones.size(); i++) {
            if (habitaciones.get(i).getCodigo().equals(codigo)) {
                habitaciones.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * consultar si una habitación detemrinada existe o no.
     * 
     * @param codigo el código único de la habitación.
     * 
     * @return booleano que confirma si la habitación existe o no.
     * 
     */
    public boolean habitacionExiste(String codigo) {
        return buscarHabitacion(codigo) != null;
    }
}





