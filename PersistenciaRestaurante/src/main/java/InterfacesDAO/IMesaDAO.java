/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfacesDAO;

import Entidades.Mesa;
import Excepcion.PersistenciaException;
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
}
