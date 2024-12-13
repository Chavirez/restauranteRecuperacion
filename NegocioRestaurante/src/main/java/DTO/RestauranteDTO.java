package DTO;

import java.sql.Time;
import java.util.List;

/**
 * La clase RestauranteDTO es un objeto de transferencia de datos (DTO) que 
 * contiene la información de un restaurante. Este DTO se utiliza para transferir 
 * los datos de un restaurante entre diferentes capas de la aplicación, 
 * como la capa de persistencia y la capa de presentación.
 * 
 * La clase incluye los horarios de apertura y cierre del restaurante, 
 * así como una lista de ubicaciones asociadas al restaurante.
 * 
 * @author santi
 */
public class RestauranteDTO {
    
    /**
     * El identificador único del restaurante.
     * Es utilizado para identificar de manera única el restaurante en el sistema.
     */
    private Long id;
    
    /**
     * La hora de apertura del restaurante, representada como un objeto de tipo Time.
     * Se utiliza para almacenar la hora en que el restaurante abre.
     */
    private Time horaApertura;
    
    /**
     * La hora de cierre del restaurante, representada como un objeto de tipo Time.
     * Se utiliza para almacenar la hora en que el restaurante cierra.
     */
    private Time horaCierre;
    
    /**
     * Una lista de ubicaciones asociadas al restaurante.
     * Cada ubicación es una cadena de texto que describe una ubicación en particular.
     */
    private List<String> ubicaciones;

    /**
     * Constructor vacío de la clase RestauranteDTO.
     * Este constructor es utilizado para crear una instancia sin inicializar los atributos.
     */
    public RestauranteDTO() {
    }

    /**
     * Constructor de la clase RestauranteDTO.
     * Este constructor es utilizado para crear una instancia de RestauranteDTO
     * con los atributos proporcionados.
     * 
     * @param horaApertura La hora de apertura del restaurante.
     * @param horaCierre La hora de cierre del restaurante.
     * @param ubicaciones Las ubicaciones asociadas al restaurante.
     */
    public RestauranteDTO(Time horaApertura, Time horaCierre, List<String> ubicaciones) {
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
        this.ubicaciones = ubicaciones;
    }

    /**
     * Obtiene el identificador único del restaurante.
     * 
     * @return El id del restaurante.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único del restaurante.
     * 
     * @param id El id a establecer.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene la hora de apertura del restaurante.
     * 
     * @return La hora de apertura.
     */
    public Time getHoraApertura() {
        return horaApertura;
    }

    /**
     * Establece la hora de apertura del restaurante.
     * 
     * @param horaApertura La hora de apertura a establecer.
     */
    public void setHoraApertura(Time horaApertura) {
        this.horaApertura = horaApertura;
    }

    /**
     * Obtiene la hora de cierre del restaurante.
     * 
     * @return La hora de cierre.
     */
    public Time getHoraCierre() {
        return horaCierre;
    }

    /**
     * Establece la hora de cierre del restaurante.
     * 
     * @param horaCierre La hora de cierre a establecer.
     */
    public void setHoraCierre(Time horaCierre) {
        this.horaCierre = horaCierre;
    }

    /**
     * Obtiene la lista de ubicaciones asociadas al restaurante.
     * 
     * @return Una lista de ubicaciones.
     */
    public List<String> getUbicaciones() {
        return ubicaciones;
    }

    /**
     * Establece las ubicaciones asociadas al restaurante.
     * 
     * @param ubicaciones La lista de ubicaciones a establecer.
     */
    public void setUbicaciones(List<String> ubicaciones) {
        this.ubicaciones = ubicaciones;
    }

    /**
     * Representación en cadena de la clase RestauranteDTO.
     * 
     * @return Una cadena que contiene los atributos del restaurante.
     */
    @Override
    public String toString() {
        return "RestauranteDTO{" + "id=" + id + ", horaApertura=" + horaApertura + ", horaCierre=" + horaCierre + ", ubicaciones=" + ubicaciones + '}';
    }
}
