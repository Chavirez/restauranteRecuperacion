/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfacesDAO;

import Entidades.Mesa;
import Entidades.Reserva;
import Excepcion.PersistenciaException;
import java.util.List;

/**
 * Interfaz que define las operaciones relacionadas con la persistencia de la
 * entidad Reserva en la base de datos.
 * Esta interfaz proporciona el método necesario para guardar una reserva.
 * 
 * @author santi
 */
public interface IReservaDAO {
    
    /**
     * Guarda una entidad Reserva en la base de datos.
     * Este método debe ser implementado por las clases que gestionan el acceso
     * a la base de datos para la entidad Reserva.
     * 
     * @param reserva La entidad Reserva que se desea guardar en la base de datos.
     * @throws PersistenciaException Si ocurre un error al guardar la reserva
     * en la base de datos.
     */
    public void guardarReserva(Reserva reserva) throws PersistenciaException;
    
    /**
     * Elimina una entidad Reserva en la base de datos.
     * 
     * @param reserva La entidad Reserva que se desea eliminar en la base de datos.
     * @throws PersistenciaException Si ocurre un error durante el proceso de persistencia.
     */
    public void eliminarReserva(Reserva reserva) throws PersistenciaException;
 
    /**
     * Busca todas las reservas por mesa
     * 
     * @param mesa Mesa en cuestión
     * @return Una lista con todas las reservas con esa mesa.
     * @throws PersistenciaException Si ocurre un error al realizar la consulta.
     */
    public List<Reserva> buscarReservaPorMesa(Mesa mesa) throws PersistenciaException;
}
