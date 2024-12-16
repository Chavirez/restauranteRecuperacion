/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Calendar;

/**
 * Clase DTO (Data Transfer Object) para representar un rango de tiempo 
 * definido por dos instantes: desde y hasta.
 * 
 * Esta clase se utiliza para encapsular y transferir datos relacionados 
 * con intervalos de tiempo.
 * 
 * @author santi
 */
public class FechasDTO {
    
    /**
     * Hora de inicio del intervalo.
     */
    private Calendar desde;
    
    /**
     * Hora de finalización del intervalo.
     */
    private Calendar hasta;

    /**
     * Constructor por defecto.
     */
    public FechasDTO() {
    }

    /**
     * Constructor con parámetros.
     * 
     * @param desde Hora de inicio del intervalo.
     * @param hasta Hora de finalización del intervalo.
     */
    public FechasDTO(Calendar desde, Calendar hasta) {
        this.desde = desde;
        this.hasta = hasta;
    }

    /**
     * Obtiene la hora de inicio del intervalo.
     * 
     * @return Hora de inicio como objeto {@link Calendar}.
     */
    public Calendar getDesde() {
        return desde;
    }

    /**
     * Establece la hora de inicio del intervalo.
     * 
     * @param desde Hora de inicio como objeto {@link Calendar}.
     */
    public void setDesde(Calendar desde) {
        this.desde = desde;
    }

    /**
     * Obtiene la hora de finalización del intervalo.
     * 
     * @return Hora de finalización como objeto {@link Calendar}.
     */
    public Calendar getHasta() {
        return hasta;
    }

    /**
     * Establece la hora de finalización del intervalo.
     * 
     * @param hasta Hora de finalización como objeto {@link Calendar}.
     */
    public void setHasta(Calendar hasta) {
        this.hasta = hasta;
    }

    /**
     * Representación en formato de texto del objeto {@code FechasDTO}.
     * 
     * @return Cadena que contiene la hora de inicio y la hora de finalización
     *         del intervalo.
     */
    @Override
    public String toString() {
        return "FechasDTO{" + "desde=" + desde + ", hasta=" + hasta + '}';
    }
}
