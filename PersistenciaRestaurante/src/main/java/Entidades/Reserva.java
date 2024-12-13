/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.*;

/**
 * La clase {@code Reserva} representa una reserva realizada por un cliente para una mesa en un sistema de gestión de reservas.
 * Esta clase se mapea a una tabla en la base de datos utilizando JPA (Java Persistence API).
 * La reserva contiene atributos como la fecha y hora, número de personas, precio y las relaciones con las entidades {@link Mesa} y {@link Cliente}.
 * 
 * @author santi
 */
@Entity // Indica que la clase es una entidad que se mapea a una tabla en la base de datos.
public class Reserva implements Serializable {

    /**
     * El identificador único de la reserva. Este valor se genera automáticamente antes de persistir la entidad.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /**
     * La fecha y hora de la reserva.
     * Este campo es obligatorio.
     */
    @Column(nullable = false)
    private Calendar fechaHora;

    /**
     * El número de personas para la reserva.
     * Este campo es obligatorio.
     */
    @Column(nullable = false)
    private int numPersonas;

    /**
     * El precio de la reserva.
     * Este campo es obligatorio.
     */
    @Column(nullable = false)
    private float precioReserva;

    /**
     * La mesa asociada a la reserva.
     * Relación muchos a uno con la entidad {@link Mesa}. Este campo es obligatorio.
     */
    @ManyToOne
    @JoinColumn(name = "id_mesa", nullable = false)
    private Mesa mesa;
    
    /**
     * El cliente que realiza la reserva.
     * Relación muchos a uno con la entidad {@link Cliente}. Este campo es obligatorio.
     */
    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    /**
     * Constructor vacío requerido por JPA. No inicializa los atributos.
     */
    public Reserva() {
    }

    /**
     * Constructor que inicializa todos los atributos de la reserva.
     * 
     * @param id El identificador único de la reserva.
     * @param fechaHora La fecha y hora de la reserva.
     * @param numPersonas El número de personas para la reserva.
     * @param precioReserva El precio de la reserva.
     * @param mesa La mesa asociada a la reserva.
     * @param cliente El cliente que realiza la reserva.
     */
    public Reserva(Long id, Calendar fechaHora, int numPersonas, float precioReserva, Mesa mesa, Cliente cliente) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.numPersonas = numPersonas;
        this.precioReserva = precioReserva;
        this.mesa = mesa;
        this.cliente = cliente;
    }

    /**
     * Constructor que inicializa todos los atributos de la reserva, sin el identificador.
     * 
     * @param fechaHora La fecha y hora de la reserva.
     * @param numPersonas El número de personas para la reserva.
     * @param precioReserva El precio de la reserva.
     * @param mesa La mesa asociada a la reserva.
     * @param cliente El cliente que realiza la reserva.
     */
    public Reserva(Calendar fechaHora, int numPersonas, float precioReserva, Mesa mesa, Cliente cliente) {
        this.fechaHora = fechaHora;
        this.numPersonas = numPersonas;
        this.precioReserva = precioReserva;
        this.mesa = mesa;
        this.cliente = cliente;
    }
    
    /**
     * Obtiene el identificador de la reserva.
     * 
     * @return El identificador de la reserva.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador de la reserva.
     * 
     * @param id El identificador de la reserva.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene la fecha y hora de la reserva.
     * 
     * @return La fecha y hora de la reserva.
     */
    public Calendar getFechaHora() {
        return fechaHora;
    }

    /**
     * Establece la fecha y hora de la reserva.
     * 
     * @param fechaHora La fecha y hora de la reserva.
     */
    public void setFechaHora(Calendar fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * Obtiene el número de personas para la reserva.
     * 
     * @return El número de personas para la reserva.
     */
    public int getNumPersonas() {
        return numPersonas;
    }

    /**
     * Establece el número de personas para la reserva.
     * 
     * @param numPersonas El número de personas para la reserva.
     */
    public void setNumPersonas(int numPersonas) {
        this.numPersonas = numPersonas;
    }

    /**
     * Obtiene el precio de la reserva.
     * 
     * @return El precio de la reserva.
     */
    public float getPrecioReserva() {
        return precioReserva;
    }

    /**
     * Establece el precio de la reserva.
     * 
     * @param precioReserva El precio de la reserva.
     */
    public void setPrecioReserva(float precioReserva) {
        this.precioReserva = precioReserva;
    }

    /**
     * Obtiene la mesa asociada a la reserva.
     * 
     * @return La mesa asociada a la reserva.
     */
    public Mesa getMesa() {
        return mesa;
    }

    /**
     * Establece la mesa asociada a la reserva.
     * 
     * @param mesa La mesa asociada a la reserva.
     */
    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    /**
     * Obtiene el cliente que realizó la reserva.
     * 
     * @return El cliente que realizó la reserva.
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Establece el cliente que realizó la reserva.
     * 
     * @param cliente El cliente que realizó la reserva.
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Devuelve una representación en texto de la entidad {@code Reserva}.
     * 
     * @return Una cadena que representa los atributos de la reserva.
     */
    @Override
    public String toString() {
        return "Reserva{" + "id=" + id + ", fechaHora=" + fechaHora + ", numPersonas=" + numPersonas + ", precioReserva=" + precioReserva + ", mesa=" + mesa + ", cliente=" + cliente + '}';
    }
}
