/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import javax.persistence.*; // Librería para las anotaciones de JPA

/**
 * La clase {@code Mesa} representa una mesa en un sistema de gestión de mesas.
 * Esta clase se mapea a una tabla en la base de datos utilizando JPA (Java Persistence API).
 * La mesa tiene atributos como código, tipo, capacidad y ubicación.
 * 
 * <p>El código de la mesa se genera automáticamente antes de persistirla en la base de datos.</p>
 * 
 * @author santi
 */
@Entity // Indica que la clase es una entidad que se mapea a una tabla en la base de datos.
public class Mesa {
    
    /**
     * El código único de la mesa. Este atributo es la clave primaria de la entidad.
     * Este valor se genera automáticamente antes de persistir la entidad.
     */
    @Id
    private String codigo;
    
    /**
     * El tipo de la mesa (por ejemplo, "Pequeña", "Mediana", "Grande").
     * Este campo es obligatorio y tiene una longitud máxima de 50 caracteres.
     */
    @Column(nullable = false, length = 50)
    private String tipo;
    
    /**
     * La capacidad de la mesa, representando el número de personas que pueden sentarse en ella.
     * Este campo es obligatorio.
     */
    @Column(nullable = false, length = 50)
    private int capacidad;
    
    /**
     * La ubicación de la mesa, indicando el área donde se encuentra (por ejemplo, "Interior", "Terraza").
     * Este campo es obligatorio y tiene una longitud máxima de 50 caracteres.
     */
    @Column(nullable = false, length = 50)
    private String ubicacion;

    /**
     * Constructor vacío requerido por JPA. No inicializa los atributos.
     */
    public Mesa() {
    }

    /**
     * Constructor que inicializa todos los atributos de la mesa.
     * 
     * @param tipo Tipo de mesa (por ejemplo, "Pequeña", "Mediana", "Grande").
     * @param capacidad Capacidad de la mesa, es decir, el número de personas que pueden sentarse.
     * @param ubicacion Ubicación de la mesa (por ejemplo, "Interior", "Terraza").
     */
    public Mesa(String tipo, int capacidad, String ubicacion) {
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.ubicacion = ubicacion;
    }

    /**
     * Constructor que inicializa todos los atributos de la mesa.
     * 
     * @param codigo código de mesa.
     * @param tipo Tipo de mesa (por ejemplo, "Pequeña", "Mediana", "Grande").
     * @param capacidad Capacidad de la mesa, es decir, el número de personas que pueden sentarse.
     * @param ubicacion Ubicación de la mesa (por ejemplo, "Interior", "Terraza").
     */
    public Mesa(String codigo, String tipo, int capacidad, String ubicacion) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.ubicacion = ubicacion;
    }

    /**
     * Obtiene el código de la mesa.
     * 
     * @return El código de la mesa.
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Establece el código de la mesa.
     * 
     * @param codigo El código de la mesa.
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
     * @param tipo El tipo de la mesa (por ejemplo, "Pequeña", "Mediana", "Grande").
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene la capacidad de la mesa.
     * 
     * @return La capacidad de la mesa, es decir, el número de personas que pueden sentarse.
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     * Establece la capacidad de la mesa.
     * 
     * @param capacidad La capacidad de la mesa.
     */
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    /**
     * Obtiene la ubicación de la mesa.
     * 
     * @return La ubicación de la mesa (por ejemplo, "Interior", "Terraza").
     */
    public String getUbicacion() {
        return ubicacion;
    }

    /**
     * Establece la ubicación de la mesa.
     * 
     * @param ubicacion La ubicación de la mesa.
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * Devuelve una representación en texto de la entidad {@code Mesa}.
     * 
     * @return Una cadena que representa los atributos de la mesa.
     */
    @Override
    public String toString() {
        return "Mesa{" + "codigo=" + codigo + ", tipo=" + tipo + ", capacidad=" + capacidad + ", ubicacion=" + ubicacion + '}';
    }   
}
