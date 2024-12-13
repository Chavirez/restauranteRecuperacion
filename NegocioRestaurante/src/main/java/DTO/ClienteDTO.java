/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 * Clase que representa un objeto de transferencia de datos (DTO) para el cliente.
 * Un DTO es utilizado para transferir datos entre capas o componentes de la aplicación sin incluir lógica de negocio.
 * Esta clase almacena información básica sobre el cliente como su ID, número de teléfono y nombre completo.
 * 
 * <p>Un DTO es comúnmente usado en arquitecturas en capas para separar la lógica de negocio de la presentación.</p>
 * 
 * @author santi
 */
public class ClienteDTO {
    
    /** ID único del cliente (generalmente asignado por la base de datos). */
    private Long id;
    
    /** Número de teléfono del cliente. */
    private String numTelefono;
    
    /** Nombre completo del cliente. */
    private String nombreCompleto;

    /**
     * Constructor vacío necesario para frameworks que requieren un constructor sin parámetros,
     * como algunos marcos de trabajo de persistencia.
     */
    public ClienteDTO() {
    }

    /**
     * Constructor que inicializa los atributos del cliente: número de teléfono y nombre completo.
     * 
     * @param numTelefono El número de teléfono del cliente.
     * @param nombreCompleto El nombre completo del cliente.
     */
    public ClienteDTO(String numTelefono, String nombreCompleto) {
        this.numTelefono = numTelefono;
        this.nombreCompleto = nombreCompleto;
    }

    /**
     * Constructor que inicializa todos los atributos del cliente: ID, número de teléfono y nombre completo.
     * 
     * @param id El ID del cliente.
     * @param numTelefono El número de teléfono del cliente.
     * @param nombreCompleto El nombre completo del cliente.
     */
    public ClienteDTO(Long id, String numTelefono, String nombreCompleto) {
        this.id = id;
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
     * @param id El nuevo ID del cliente.
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
     * @param numTelefono El nuevo número de teléfono del cliente.
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
     * @param nombreCompleto El nuevo nombre completo del cliente.
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    /**
     * Devuelve una representación en formato de cadena del objeto ClienteDTO.
     * Este método es útil para depuración y visualización de objetos en texto plano.
     * 
     * @return Una cadena con los valores de los atributos del cliente.
     */
    @Override
    public String toString() {
        return "ClienteDTO{" + "id=" + id + ", numTelefono=" + numTelefono + ", nombreCompleto=" + nombreCompleto + '}';
    }
}
