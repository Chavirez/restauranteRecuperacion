/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfacesNegocio;

import DTO.ClienteDTO;
import DTO.MesaDTO;
import DTO.ReservaDTO;
import Excepcion.NegocioException;
import java.util.List;

/**
 *
 * @author santi
 */
public interface IReservaNegocio {
    
    /**
     * Método que guarda una nueva reserva en la base de datos.
     * 
     * @param reserva Datos de la reserva a realizar, representados por un objeto 
     *               de tipo ReservaDTO.
     * @param cliente Datos del cliente que realiza la reserva, representados 
     *               por un objeto de tipo ClienteDTO.
     * @param mesa Datos de la mesa reservada, representados por un objeto de 
     *             tipo MesaDTO.
     * @throws NegocioException Si ocurre un error en la lógica del negocio al 
     *                          procesar la reserva.
     */
    public void guardarReserva(ReservaDTO reserva, ClienteDTO cliente, MesaDTO mesa) throws NegocioException;
 
    /**
     * Método que elimina una reserva en la base de datos.
     * 
     * @param reserva Reserva que se va a eliminar
     * @throws NegocioException Si ocurre un error en la lógica del negocio al 
     *                          procesar la reserva.
     */
    public void eliminarReserva(ReservaDTO reserva) throws NegocioException;
    
    
    
    /**
     * Método que retorna las reservas con una mesa especificada
     * 
     * @param mesa Mesa a buscar
     * @return una lista de las reservas
     * @throws NegocioException Si ocurre un error en la lógica del negocio al 
     *                          procesar la reserva.
     */
    public List<ReservaDTO> buscarReservasPorMesa(MesaDTO mesa) throws NegocioException;

    /**
     * Inserta reservas masivamente
     * @throws Excepcion.NegocioException
     */
    public void llenarReservasMasivamente() throws NegocioException;
    
    /**
     * Método que guarda una nueva reserva en la base de datos.
     * 
     * 
     * @param reserva Datos de la reserva a realizar, representados por un objeto 
     *               de tipo ReservaDTO. Contiene la mesa y el cliente
     * @throws NegocioException Si ocurre un error en la lógica del negocio al 
     *                          procesar la reserva.
     */
    public void guardarReserva(ReservaDTO reserva) throws NegocioException;

}
