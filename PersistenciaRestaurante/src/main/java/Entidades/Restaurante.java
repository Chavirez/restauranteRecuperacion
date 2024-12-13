package Entidades;

import java.io.Serializable;
import java.sql.Time;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Representa una entidad de restaurante con información sobre su horario de apertura y cierre,
 * así como sus ubicaciones.
 * Esta clase está mapeada a una tabla en la base de datos a través de JPA.
 * 
 * @author santi
 */
@Entity
public class Restaurante implements Serializable {

    /**
     * El identificador único del restaurante.
     * Este campo es generado automáticamente por la base de datos.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /**
     * La hora de apertura del restaurante.
     * Este campo es obligatorio y se almacena como un tipo de dato Time en la base de datos.
     */
    @Column(nullable = false)
    private Time horaApertura;
    
    /**
     * La hora de cierre del restaurante.
     * Este campo es obligatorio y se almacena como un tipo de dato Time en la base de datos.
     */
    @Column(nullable = false)
    private Time horaCierre;

    /**
     * Lista de ubicaciones del restaurante.
     * Este campo es obligatorio, pero en este caso, se asume que es una lista de cadenas
     * que representa las diferentes ubicaciones del restaurante.
     */
    @Column(nullable = false)
    private List<String> ubicaciones;

    /**
     * Constructor por defecto para la clase Restaurante.
     * Este constructor es necesario para la persistencia de la entidad en la base de datos.
     */
    public Restaurante() {
    }

    /**
     * Constructor de la clase Restaurante con parámetros.
     * 
     * @param horaApertura La hora de apertura del restaurante.
     * @param horaCierre La hora de cierre del restaurante.
     * @param ubicaciones La lista de ubicaciones del restaurante.
     */
    public Restaurante(Time horaApertura, Time horaCierre, List<String> ubicaciones) {
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
        this.ubicaciones = ubicaciones;
    }

    /**
     * Obtiene el identificador único del restaurante.
     * 
     * @return El identificador único del restaurante.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único del restaurante.
     * 
     * @param id El identificador único del restaurante.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene la hora de apertura del restaurante.
     * 
     * @return La hora de apertura del restaurante.
     */
    public Time getHoraApertura() {
        return horaApertura;
    }

    /**
     * Establece la hora de apertura del restaurante.
     * 
     * @param horaApertura La hora de apertura del restaurante.
     */
    public void setHoraApertura(Time horaApertura) {
        this.horaApertura = horaApertura;
    }

    /**
     * Obtiene la hora de cierre del restaurante.
     * 
     * @return La hora de cierre del restaurante.
     */
    public Time getHoraCierre() {
        return horaCierre;
    }

    /**
     * Establece la hora de cierre del restaurante.
     * 
     * @param horaCierre La hora de cierre del restaurante.
     */
    public void setHoraCierre(Time horaCierre) {
        this.horaCierre = horaCierre;
    }

    /**
     * Obtiene la lista de ubicaciones del restaurante.
     * 
     * @return La lista de ubicaciones del restaurante.
     */
    public List<String> getUbicaciones() {
        return ubicaciones;
    }

    /**
     * Establece la lista de ubicaciones del restaurante.
     * 
     * @param ubicaciones La lista de ubicaciones del restaurante.
     */
    public void setUbicaciones(List<String> ubicaciones) {
        this.ubicaciones = ubicaciones;
    }

    /**
     * Retorna una representación en formato String de la entidad Restaurante.
     * 
     * @return Una cadena que representa la entidad Restaurante.
     */
    @Override
    public String toString() {
        return "Restaurante{" + "id=" + id + ", horaApertura=" + horaApertura + ", horaCierre=" + horaCierre + ", ubicaciones=" + ubicaciones + '}';
    }
}
