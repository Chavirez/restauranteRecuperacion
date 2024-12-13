package DTO;

import Entidades.Cliente;
import Entidades.Mesa;
import java.util.Calendar;

/**
 * Clase que representa una reserva en el sistema, con detalles sobre la mesa,
 * el cliente, el número de personas, la fecha y hora de la reserva, y el precio.
 * 
 * Esta clase es utilizada para transferir información entre las capas de la aplicación.
 * 
 * @author santi
 */
public class ReservaDTO {

    private Long id;
    private Calendar fechaHora;
    private int numPersonas;
    private float precioReserva;
    private Mesa mesa;
    private Cliente cliente;

    /**
     * Constructor vacío de la clase ReservaDTO.
     * Este constructor es utilizado por frameworks de persistencia, como JPA.
     */
    public ReservaDTO() {
    }

    /**
     * Constructor que inicializa una instancia de ReservaDTO con los parámetros proporcionados.
     * 
     * @param fechaHora La fecha y hora en que se realiza la reserva.
     * @param numPersonas El número de personas que ocupan la mesa reservada.
     * @param precioReserva El precio asociado a la reserva.
     * @param mesa La mesa asociada a la reserva.
     * @param cliente El cliente que realiza la reserva.
     */
    public ReservaDTO(Calendar fechaHora, int numPersonas, float precioReserva, Mesa mesa, Cliente cliente) {
        this.fechaHora = fechaHora;
        this.numPersonas = numPersonas;
        this.precioReserva = precioReserva;
        this.mesa = mesa;
        this.cliente = cliente;
    }

    /**
     * Constructor que inicializa una instancia de ReservaDTO con los parámetros proporcionados,
     * incluyendo el identificador único de la reserva.
     * 
     * @param id El identificador único de la reserva.
     * @param fechaHora La fecha y hora en que se realiza la reserva.
     * @param numPersonas El número de personas que ocupan la mesa reservada.
     * @param precioReserva El precio asociado a la reserva.
     * @param mesa La mesa asociada a la reserva.
     * @param cliente El cliente que realiza la reserva.
     */
    public ReservaDTO(Long id, Calendar fechaHora, int numPersonas, float precioReserva, Mesa mesa, Cliente cliente) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.numPersonas = numPersonas;
        this.precioReserva = precioReserva;
        this.mesa = mesa;
        this.cliente = cliente;
    }

    /**
     * Obtiene el identificador único de la reserva.
     * 
     * @return El identificador de la reserva.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único de la reserva.
     * 
     * @param id El identificador único de la reserva.
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
     * Obtiene el número de personas asociadas a la reserva.
     * 
     * @return El número de personas en la reserva.
     */
    public int getNumPersonas() {
        return numPersonas;
    }

    /**
     * Establece el número de personas asociadas a la reserva.
     * 
     * @param numPersonas El número de personas en la reserva.
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
     * Retorna una representación en cadena de caracteres de la instancia de ReservaDTO.
     * 
     * @return Una cadena de texto con los valores de los atributos de la reserva.
     */
    @Override
    public String toString() {
        return "ReservaDTO{" + "id=" + id + ", fechaHora=" + fechaHora + ", numPersonas=" + numPersonas + ", precioReserva=" + precioReserva + ", mesa=" + mesa + ", cliente=" + cliente + '}';
    }
}
