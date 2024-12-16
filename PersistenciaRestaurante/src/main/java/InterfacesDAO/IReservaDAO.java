/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfacesDAO;

import Entidades.Cliente;
import Entidades.Mesa;
import Entidades.Reserva;
import Excepcion.PersistenciaException;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Calendar;
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
    
        
    /**
     * Busca todas las reservas por cliente
     * 
     * @param cliente el cliente en cuesttión
     * @return Una lista con todas las reservas con ese cliente
     * @throws PersistenciaException Si ocurre un error al realizar la consulta.
     */
    public List<Reserva> buscarReservaPorCliente(Cliente cliente) throws PersistenciaException;
    
    /**
     * Busca todas las reservas por seccion
     * 
     * @param seccion la sección en cuestión
     * @param desde
     * @param hasta
     * @return Una lista con todas las reservas con ese cliente
     * @throws PersistenciaException Si ocurre un error al realizar la consulta.
     */
    public List<Reserva> buscarReservaPorSeccion(String seccion, Calendar desde, Calendar hasta) throws PersistenciaException;
    
    /**
     * Busca todas las reservas por tipo de mesa
     * 
     * @param cantidadMinima la cantidadMin en cuestión
     * @param cantidadMaxima la cantidadMax en cuestión
     * @param desde desde
     * @param hasta hasta
     * @return Una lista con todas las reservas con ese cliente
     * @throws PersistenciaException Si ocurre un error al realizar la consulta.
     */
    public List<Reserva> buscarReservaPorTipo(int cantidadMinima, int cantidadMaxima, Calendar desde, Calendar hasta) throws PersistenciaException;
}
