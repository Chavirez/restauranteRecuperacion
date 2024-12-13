/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * La clase {@code Cliente} representa a un cliente en el sistema de reservas.
 * Un cliente tiene un identificador único, un número de teléfono y un nombre completo.
 * Esta clase se mapea a una tabla en la base de datos utilizando JPA (Java Persistence API).
 * 
 * @author santi
 */
@Entity // Indica que la clase es una entidad que se mapea a una tabla en la base de datos.
public class Cliente implements Serializable {

    /**
     * El identificador único del cliente. Este valor se genera automáticamente antes de persistir la entidad.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * El número de teléfono del cliente.
     * Este campo es obligatorio y único.
     */
    @Column(nullable = false, unique = true)
    private String numTelefono;

    /**
     * El nombre completo del cliente.
     * Este campo es obligatorio.
     */
    @Column(nullable = false)
    private String nombreCompleto;

    /**
     * Constructor vacío requerido por JPA. No inicializa los atributos.
     */
    public Cliente() {
    }

    /**
     * Constructor que inicializa todos los atributos de un cliente.
     * 
     * @param id El identificador único del cliente.
     * @param numTelefono El número de teléfono del cliente.
     * @param nombreCompleto El nombre completo del cliente.
     */
    public Cliente(Long id, String numTelefono, String nombreCompleto) {
        this.id = id;
        this.numTelefono = numTelefono;
        this.nombreCompleto = nombreCompleto;
    }

    /**
     * Constructor que inicializa el número de teléfono y el nombre completo del cliente.
     * 
     * @param numTelefono El número de teléfono del cliente.
     * @param nombreCompleto El nombre completo del cliente.
     */
    public Cliente(String numTelefono, String nombreCompleto) {
        this.numTelefono = numTelefono;
        this.nombreCompleto = nombreCompleto;
    }
    /**
     * Obtiene el ID del cliente.
     * 
     * @return El ID del cliente.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID del cliente.
     * 
     * @param id El ID a establecer para el cliente.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el número de teléfono del cliente.
     * 
     * @return El número de teléfono del cliente.
     */
    public String getNumTelefono() {
        return numTelefono;
    }

    /**
     * Establece el número de teléfono del cliente.
     * 
     * @param numTelefono El número de teléfono a establecer para el cliente.
     */
    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }

    /**
     * Obtiene el nombre completo del cliente.
     * 
     * @return El nombre completo del cliente.
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * Establece el nombre completo del cliente.
     * 
     * @param nombreCompleto El nombre completo a establecer para el cliente.
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    
    /**
     * Devuelve una representación en texto de la entidad {@code Cliente}.
     * 
     * @return Una cadena que representa los atributos del cliente.
     */
    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", numTelefono=" + numTelefono + ", nombreCompleto=" + nombreCompleto + '}';
    }
}
