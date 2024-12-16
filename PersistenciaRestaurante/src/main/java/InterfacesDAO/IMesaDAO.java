/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfacesDAO;

import Entidades.Mesa;
import Excepcion.PersistenciaException;
import java.util.Calendar;
import java.util.List;

/**
 * Esta interfaz define las operaciones básicas de acceso a datos para la entidad {@code Mesa}.
 * Incluye métodos para guardar, buscar y eliminar mesas en una base de datos.
 * Los métodos pueden lanzar excepciones de tipo {@link PersistenciaException} si ocurren errores durante la operación de persistencia.
 * 
 * @author santi
 */
public interface IMesaDAO {

    /**
     * Guarda una nueva mesa en la base de datos.
     * 
     * @param mesa La mesa que se desea guardar.
     * @throws PersistenciaException Si ocurre un error al intentar guardar la mesa en la base de datos.
     */
    public void guardarMesa(Mesa mesa) throws PersistenciaException;

    /**
     * Busca todas las mesas almacenadas en la base de datos.
     * 
     * @return Una lista de todas las mesas.
     * @throws PersistenciaException Si ocurre un error al intentar recuperar las mesas de la base de datos.
     */
    public List<Mesa> buscarTodasLasMesas() throws PersistenciaException;

    /**
     * Elimina una mesa de la base de datos.
     * 
     * @param mesa La mesa que se desea eliminar.
     * @throws PersistenciaException Si ocurre un error al intentar eliminar la mesa de la base de datos.
     */
    public void eliminarMesa(Mesa mesa) throws PersistenciaException;
    
    /**
     * Busca las mesas disponibles en un restaurante según su capacidad, ubicación y el tiempo desde la última reserva.
     * 
     * Este método realiza una consulta a la base de datos utilizando JPA para encontrar todas las mesas que cumplen con 
     * las condiciones de capacidad y ubicación proporcionadas, y que no han sido reservadas en las últimas 5 horas.
     * Se utiliza una subconsulta para verificar que no existan reservas en el rango de tiempo especificado.
     *
     * @param seccion La ubicación de las mesas que se está buscando (por ejemplo, "Terraza", "Ventana").
     * @param capacidad La capacidad mínima de las mesas que se desea buscar (por ejemplo, mesas para 4 personas o más).
     * @param fechaReserva La fecha de resreva
     * @return Una lista de objetos `Mesa` que cumplen con los criterios de disponibilidad. Si no se encuentran mesas
     *         disponibles, se devuelve una lista vacía.
     * @throws PersistenciaException
     */
    public List<Mesa> buscarMesasDisponibles(String seccion, int capacidad, Calendar fechaReserva) throws PersistenciaException;
    
    
    /**
     * Busca las mesas por seccion.
     * 
     * @param seccion la seccion
     * @return Una lista de objetos `Mesa` que cumplen con los criterios de disponibilidad. Si no se encuentran mesas
     *         disponibles, se devuelve una lista vacía.
     * @throws PersistenciaException
     */
    public List<Mesa> buscarMesasPorSeccion(String seccion) throws PersistenciaException;
    
    
}
