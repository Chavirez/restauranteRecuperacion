/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 * Clase Data Transfer Object (DTO) utilizada para encapsular la información 
 * sobre la cantidad de mesas que se desea registrar, categorizadas por tamaño 
 * y secciones.
 * 
 * Esta clase actúa como un contenedor para transferir datos entre diferentes 
 * capas del sistema (como la capa de presentación y la capa de negocio).
 * 
 * @author santi
 */
public class MesasAGuardarDTO {
    
    /** Sección donde se ubican las mesas. */
    private String seccion;
    
    /** Cantidad de mesas pequeñas que se registrarán. */
    private int cantidadPequeñas;
    
    /** Cantidad de mesas medianas que se registrarán. */
    private int cantidadMedianas;
    
    /** Cantidad de mesas grandes que se registrarán. */
    private int cantidadGrandes;

    /**
     * Constructor sin argumentos.
     * Inicializa un objeto de la clase con valores por defecto.
     */
    public MesasAGuardarDTO() {
    }

    /**
     * Constructor con parámetros.
     * 
     * @param seccion La sección de las mesas.
     * @param cantidadPequeñas Cantidad de mesas pequeñas.
     * @param cantidadMedianas Cantidad de mesas medianas.
     * @param cantidadGrandes Cantidad de mesas grandes.
     */
    public MesasAGuardarDTO(String seccion, int cantidadPequeñas, int cantidadMedianas, int cantidadGrandes) {
        this.seccion = seccion;
        this.cantidadPequeñas = cantidadPequeñas;
        this.cantidadMedianas = cantidadMedianas;
        this.cantidadGrandes = cantidadGrandes;
    }

    /**
     * Obtiene la sección de las mesas.
     * 
     * @return La sección de las mesas.
     */
    public String getSeccion() {
        return seccion;
    }

    /**
     * Establece la sección de las mesas.
     * 
     * @param seccion La nueva sección de las mesas.
     */
    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    /**
     * Obtiene la cantidad de mesas pequeñas.
     * 
     * @return La cantidad de mesas pequeñas.
     */
    public int getCantidadPequeñas() {
        return cantidadPequeñas;
    }

    /**
     * Establece la cantidad de mesas pequeñas.
     * 
     * @param cantidadPequeñas La nueva cantidad de mesas pequeñas.
     */
    public void setCantidadPequeñas(int cantidadPequeñas) {
        this.cantidadPequeñas = cantidadPequeñas;
    }

    /**
     * Obtiene la cantidad de mesas medianas.
     * 
     * @return La cantidad de mesas medianas.
     */
    public int getCantidadMedianas() {
        return cantidadMedianas;
    }

    /**
     * Establece la cantidad de mesas medianas.
     * 
     * @param cantidadMedianas La nueva cantidad de mesas medianas.
     */
    public void setCantidadMedianas(int cantidadMedianas) {
        this.cantidadMedianas = cantidadMedianas;
    }

    /**
     * Obtiene la cantidad de mesas grandes.
     * 
     * @return La cantidad de mesas grandes.
     */
    public int getCantidadGrandes() {
        return cantidadGrandes;
    }

    /**
     * Establece la cantidad de mesas grandes.
     * 
     * @param cantidadGrandes La nueva cantidad de mesas grandes.
     */
    public void setCantidadGrandes(int cantidadGrandes) {
        this.cantidadGrandes = cantidadGrandes;
    }

    /**
     * Representa el objeto como una cadena de texto.
     * 
     * @return Una representación en texto de los atributos del objeto.
     */
    @Override
    public String toString() {
        return "MesasAGuardarDTO{" + 
               "seccion=" + seccion + 
               ", cantidadPequeñas=" + cantidadPequeñas + 
               ", cantidadMedianas=" + cantidadMedianas + 
               ", cantidadGrandes=" + cantidadGrandes + '}';
    }
}
