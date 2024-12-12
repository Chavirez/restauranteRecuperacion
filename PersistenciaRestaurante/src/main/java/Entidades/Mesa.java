/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable; // Clase para la interfaz Serializable (opcional en este caso)
import javax.persistence.*; // Librería para las anotaciones de JPA

/**
 * Clase que representa la entidad "Mesa" en un sistema de persistencia JPA.
 * Incluye atributos básicos como código, tipo, capacidad y ubicación.
 * El código se genera automáticamente antes de persistir la entidad en la base de datos.
 * 
 * @author santi
 */

@Entity // Anotación que indica que esta clase es una entidad de JPA y se mapeará a una tabla en la base de datos.
public class Mesa {
    @Id
    private String codigo;
    
    private String tipo; // Tipo de mesa (por ejemplo, "Pequeña", "Mediana", "Grande").
    private int capacidad; // Capacidad de la mesa (número de personas que pueden sentarse).
    private String ubicacion; // Ubicación de la mesa (por ejemplo, "Interior", "Terraza").


    // Constructor vacío requerido por JPA.
    public Mesa() {
    }

    // Constructor que inicializa los atributos de la mesa.
    public Mesa(String tipo, int capacidad, String ubicacion) {
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.ubicacion = ubicacion;
    }

    // Métodos getter y setter para acceder y modificar los atributos de la clase.

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    // Método toString que devuelve una representación en texto de la entidad "Mesa".
    @Override
    public String toString() {
        return "Mesa{" + "codigo=" + codigo + ", tipo=" + tipo + ", capacidad=" + capacidad + ", ubicacion=" + ubicacion + '}';
    }   
}
