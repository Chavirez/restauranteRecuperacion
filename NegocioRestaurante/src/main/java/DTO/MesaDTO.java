/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 * Clase DTO (Data Transfer Object) que representa una mesa.
 * Se utiliza para transferir datos relacionados con las mesas entre capas de la aplicación.
 *
 * Contiene información sobre el código, tipo, capacidad y ubicación de la mesa.
 * 
 * @author santi
 */
public class MesaDTO {

    /**
     * Código único que identifica a la mesa.
     */
    private String codigo;

    /**
     * Tipo de mesa (por ejemplo, "Pequeña", "Mediana", "Grande").
     */
    private String tipo;

    /**
     * Capacidad de la mesa (número de personas que pueden sentarse).
     */
    private int capacidad;

    /**
     * Ubicación de la mesa (por ejemplo, "Interior", "Terraza").
     */
    private String ubicacion;

    /**
     * Constructor por defecto.
     * Crea una instancia vacía de MesaDTO.
     */
    public MesaDTO() {
    }

    /**
     * Constructor que inicializa casi todos los atributos de la mesa.
     *
     * @param tipo      El tipo de la mesa.
     * @param capacidad La capacidad de la mesa.
     * @param ubicacion La ubicación de la mesa.
     */
    public MesaDTO(String tipo, int capacidad, String ubicacion) {
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.ubicacion = ubicacion;
    }

    /**
     * Constructor que inicializa todos los atributos de la mesa.
     *
     * @param codigo    El código único de la mesa.
     * @param tipo      El tipo de la mesa.
     * @param capacidad La capacidad de la mesa.
     * @param ubicacion La ubicación de la mesa.
     */
    public MesaDTO(String codigo, String tipo, int capacidad, String ubicacion) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.ubicacion = ubicacion;
    }

    /**
     * Obtiene el código único de la mesa.
     *
     * @return El código de la mesa.
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Establece el código único de la mesa.
     *
     * @param codigo El nuevo código de la mesa.
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Obtiene el tipo de la mesa.
     *
     * @return El tipo de la mesa.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de la mesa.
     *
     * @param tipo El nuevo tipo de la mesa.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene la capacidad de la mesa.
     *
     * @return La capacidad de la mesa.
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     * Establece la capacidad de la mesa.
     *
     * @param capacidad La nueva capacidad de la mesa.
     */
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    /**
     * Obtiene la ubicación de la mesa.
     *
     * @return La ubicación de la mesa.
     */
    public String getUbicacion() {
        return ubicacion;
    }

    /**
     * Establece la ubicación de la mesa.
     *
     * @param ubicacion La nueva ubicación de la mesa.
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * Devuelve una representación en cadena de los atributos de la mesa.
     *
     * @return Una cadena que representa la mesa.
     */
    @Override
    public String toString() {
        return "MesaDTO{" +
                "codigo=" + codigo +
                ", tipo=" + tipo +
                ", capacidad=" + capacidad +
                ", ubicacion=" + ubicacion +
                '}';
    }
}
