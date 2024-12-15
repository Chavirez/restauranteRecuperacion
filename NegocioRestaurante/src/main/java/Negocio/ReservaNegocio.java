/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DAO.ReservaDAO;
import DTO.ClienteDTO;
import DTO.MesaDTO;
import DTO.ReservaDTO;
import Entidades.Cliente;
import Entidades.Mesa;
import Entidades.Reserva;
import Excepcion.NegocioException;
import Excepcion.PersistenciaException;
import InterfacesDAO.IReservaDAO;
import InterfacesNegocio.IReservaNegocio;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase encargada de gestionar las reservas de mesas. Implementa la interfaz 
 * IReservaNegocio para definir el comportamiento de los servicios relacionados 
 * con las reservas de mesas.
 * 
 * @author santi
 */
public class ReservaNegocio implements IReservaNegocio {
    
    // Instancia del DAO que maneja la persistencia de las reservas.
    private final IReservaDAO reservaDAO = new ReservaDAO();

    /**
     * Constructor de la clase ReservaNegocio.
     * Inicializa los componentes necesarios para la gestión de reservas.
     */
    public ReservaNegocio() {
    }
    
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
    @Override
    public void guardarReserva(ReservaDTO reserva, ClienteDTO cliente, MesaDTO mesa) throws NegocioException {
        
        // Se crean las entidades correspondientes a partir de los DTOs
        Cliente clienteE = new Cliente(cliente.getId(), cliente.getNumTelefono(), cliente.getNombreCompleto());
        Mesa mesaE = new Mesa(mesa.getCodigo(), mesa.getTipo(), mesa.getCapacidad(), mesa.getUbicacion());
        
        // Se crea la nueva reserva utilizando los datos proporcionados
        Reserva reservaNueva = new Reserva(reserva.getFechaHora(), reserva.getNumPersonas(), 
                                           reserva.getPrecioReserva(), mesaE, clienteE, reserva.getSeccion());
        
        try {
            // Se guarda la reserva a través del DAO
            reservaDAO.guardarReserva(reservaNueva);
        } catch (PersistenciaException ex) {
            // Se maneja el error de persistencia
            System.out.println("Error al realizar la reserva");
        }
        
    }
    
    /**
     * Método que elimina una reserva en la base de datos.
     * 
     * @param reserva Reserva que se va a eliminar
     * @throws NegocioException Si ocurre un error en la lógica del negocio al 
     *                          procesar la reserva.
     */
    @Override
    public void eliminarReserva(ReservaDTO reserva) throws NegocioException {
        
        // Se crea la nueva reserva utilizando los datos proporcionados
        Reserva reservaNueva = new Reserva(reserva.getFechaHora(), reserva.getNumPersonas(),reserva.getPrecioReserva(), reserva.getMesa(), reserva.getCliente(), reserva.getSeccion());
        
        try {
            // Se guarda la reserva a través del DAO
            reservaDAO.eliminarReserva(reservaNueva);
        } catch (PersistenciaException ex) {
            // Se maneja el error de persistencia
            System.out.println("Error al eliminar la reserva");
        }
        
    }
    
    /**
     * Método que retorna las reservas con una mesa especificada
     * 
     * @param mesa Mesa a buscar
     * @returns una lista de las reservas
     * @throws NegocioException Si ocurre un error en la lógica del negocio al 
     *                          procesar la reserva.
     */
    @Override
    public List<ReservaDTO> buscarReservasPorMesa(MesaDTO mesa) throws NegocioException {
        
        List<ReservaDTO> reservasEncontradas = new ArrayList<>();
        List<Reserva> reservasEntidad = new ArrayList<>();


        Mesa mesaFiltro = new Mesa();
        mesaFiltro.setCodigo(mesa.getCodigo());
        mesaFiltro.setCapacidad(mesa.getCapacidad());
        mesaFiltro.setTipo(mesa.getTipo());
        mesaFiltro.setUbicacion(mesa.getUbicacion());

        try {
            // Se guarda la reserva a través del DAO
            reservasEntidad = reservaDAO.buscarReservaPorMesa(mesaFiltro);
        } catch (PersistenciaException ex) {
            // Se maneja el error de persistencia
            System.out.println("Error al buscar las reservas");
        }
        
        if(reservasEntidad == null)
            return null;
        
        for(Reserva reserva : reservasEntidad){
        
            ReservaDTO reservaD = new ReservaDTO(reserva.getId(), reserva.getFechaHora(), reserva.getNumPersonas(), reserva.getNumPersonas(), reserva.getMesa(), reserva.getCliente(), reserva.getSeccion());
            reservasEncontradas.add(reservaD);
            
        }
        
        return reservasEncontradas;
        
    }
    
}
