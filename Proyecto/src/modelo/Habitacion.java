/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;
import java.util.ArrayList;


/**
 * Clase que representa una habitación del hotel.
 */
public class Habitacion {
    private String tipo;
    private int capacidad;
    private double precio;
    private String comodidades;
    private String codigo;
    private ArrayList<Reserva> reservas;

    /**
     * Constructor de la clase
     * 
     * @param tipo tipo de habitación.
     * @param capacidad numero máximo de personas que se pueden hospedar en la habitación.
     * @param precio valor por noche del hospedaje de la habitación.
     * @param comodidades algunos productos o servicios exclusivos.
     * @param codigo codigo único que identifica a la habitación.
     */
    public Habitacion(String tipo, int capacidad, double precio, String comodidades, String codigo) {
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.precio = precio;
        this.comodidades = comodidades;
        this.codigo = codigo;
        this.reservas = new ArrayList<>();
    }

    //getters y setters
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public int getCapacidad() { return capacidad; }
    public void setCapacidad(int capacidad) { this.capacidad = capacidad; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public String getComodidades() { return comodidades; }
    public void setComodidades(String comodidades) { this.comodidades = comodidades; }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public ArrayList<Reserva> getReservas() { return reservas; }

    
    /**
     * Verifica si la habitación está disponible
     * 
     * @param fechaInicio fecha de entrada a verificar.
     * @param fechaFin fecha de salida a verificar.
     * @return booleano que confirma si la habitación está disponible entre las fechas dadas.
     */
    public boolean estaDisponible(LocalDate fechaInicio, LocalDate fechaFin) {
        for (Reserva reserva : reservas) {
            if (reserva.getFechaLlegada().isBefore(fechaFin) && reserva.getFechaSalida().isAfter(fechaInicio) || reserva.getFechaLlegada().isEqual(fechaInicio) || reserva.getFechaLlegada().isEqual(fechaFin) || reserva.getFechaSalida().isEqual(fechaInicio) || reserva.getFechaSalida().isEqual(fechaFin)) {
                return false;
            }
        }
        return true;
    }

    /**
     * permite agregar una nueva reserva de la habitación
     * 
     * @param reserva la reserva a agregar
     */
    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
    }
}

    
