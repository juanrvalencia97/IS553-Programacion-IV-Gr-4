/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Clase que representa una reserva realizada por un cliente.
 */
public class Reserva {
    private String id;
    private String nombre;
    private LocalDate fechaLlegada;
    private LocalDate fechaSalida;
    private int numeroHuespedes;
    private Habitacion habitacion;
    private String estado;
    private Usuario usuario;

    /**
     * Constructor de la clase 
     * 
     * @param nombre nombre due quien realiza la reserva.
     * @param fechaLlegada fecha de inicio de la reserva
     * @param fechaSalida fecha de finalización de la reserva.
     * @param numeroHuespedes numero de personas que se hospedarán en la habitación.
     * @param habitacion objeto tipo habitacion que representa la habitación reservada.
     * @param usuario objeto usuario que representa el usuario que ha realizado la reserva.
     */
    
    public Reserva(String nombre, LocalDate fechaLlegada, LocalDate fechaSalida, int numeroHuespedes, Habitacion habitacion, Usuario usuario) {
        this.id = UUID.randomUUID().toString(); // Generar un UUID
        this.nombre = nombre;
        this.fechaLlegada = fechaLlegada;
        this.fechaSalida = fechaSalida;
        this.numeroHuespedes = numeroHuespedes;
        this.habitacion = habitacion;
        this.estado = "Activa";
        this.usuario = usuario;
    }

    //getters y setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public LocalDate getFechaLlegada() { return fechaLlegada; }
    public void setFechaLlegada(LocalDate fechaLlegada) { this.fechaLlegada = fechaLlegada; }

    public LocalDate getFechaSalida() { return fechaSalida; }
    public void setFechaSalida(LocalDate fechaSalida) { this.fechaSalida = fechaSalida; }

    public int getNumeroHuespedes() { return numeroHuespedes; }
    public void setNumeroHuespedes(int numeroHuespedes) { this.numeroHuespedes = numeroHuespedes; }

    public Habitacion getHabitacion() { return habitacion; }
    public void setHabitacion(Habitacion habitacion) { this.habitacion = habitacion; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
}

