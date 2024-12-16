/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DAO.ReservaDAO;
import DTO.ClienteDTO;
import DTO.FechasDTO;
import DTO.MesaDTO;
import DTO.ReservaDTO;
import Entidades.Cliente;
import Entidades.Mesa;
import Entidades.Reserva;
import Excepcion.NegocioException;
import Excepcion.PersistenciaException;
import InterfacesDAO.IReservaDAO;
import InterfacesNegocio.IClienteNegocio;
import InterfacesNegocio.IMesaNegocio;
import InterfacesNegocio.IReservaNegocio;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
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
     * Método que guarda una nueva reserva en la base de datos.
     * 
     * 
     * @param reserva Datos de la reserva a realizar, representados por un objeto 
     *               de tipo ReservaDTO. Contiene la mesa y el cliente
     * @throws NegocioException Si ocurre un error en la lógica del negocio al 
     *                          procesar la reserva.
     */
    @Override
    public void guardarReserva(ReservaDTO reserva) throws NegocioException {
        
        // Se crean las entidades correspondientes a partir de los DTOs

        // Se crea la nueva reserva utilizando los datos proporcionados
        Reserva reservaNueva = new Reserva(reserva.getFechaHora(), reserva.getNumPersonas(), 
                                           reserva.getPrecioReserva(), reserva.getMesa(), reserva.getCliente(), reserva.getSeccion());
        
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
        Reserva reservaNueva = new Reserva(reserva.getId(), reserva.getFechaHora(), reserva.getNumPersonas(),reserva.getPrecioReserva(), reserva.getMesa(), reserva.getCliente(), reserva.getSeccion());
        
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
     * @return una lista de las reservas
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
            reservasEntidad.toString();
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
    
    
    /**
     * Método que retorna las reservas con una cliente especificado
     * 
     * @param cliente Cliente a buscar
     * @return una lista de las reservas
     * @throws NegocioException Si ocurre un error en la lógica del negocio al 
     *                          procesar la reserva.
     */
    @Override
    public List<ReservaDTO> buscarReservasPorCliente(ClienteDTO cliente) throws NegocioException {
        
        List<ReservaDTO> reservasEncontradas = new ArrayList<>();
        List<Reserva> reservasEntidad = new ArrayList<>();


        Cliente clienteFiltro = new Cliente(cliente.getId(), cliente.getNumTelefono(), cliente.getNombreCompleto());

        try {
            // Se guarda la reserva a través del DAO
            reservasEntidad = reservaDAO.buscarReservaPorCliente(clienteFiltro);
            
        } catch (PersistenciaException ex) {
            // Se maneja el error de persistencia
            System.out.println("Error al buscar las reservas" + ex);
        }
        
        if(reservasEntidad == null)
            return null;
        
        for(Reserva reserva : reservasEntidad){
        
            ReservaDTO reservaD = new ReservaDTO(reserva.getId(), reserva.getFechaHora(), reserva.getNumPersonas(), reserva.getNumPersonas(), reserva.getMesa(), reserva.getCliente(), reserva.getSeccion());
            reservasEncontradas.add(reservaD);
            
        }
        
        return reservasEncontradas;
        
    }
    
    /**
     * Método que retorna las reservas de una sección especificada, con las fechas especificadas
     * 
     * @param seccion Contiene la sección deseada
     * @param fechas las fechas desde y hasta
     * @return una lista de las reservas
     * @throws NegocioException Si ocurre un error en la lógica del negocio al 
     *                          procesar la reserva.
     */
    @Override
    public List<ReservaDTO> buscarReservasPorSeccion(ReservaDTO seccion, FechasDTO fechas) throws NegocioException {
        
        List<ReservaDTO> reservasEncontradas = new ArrayList<>();
        List<Reserva> reservasEntidad = new ArrayList<>();



        try {
            // Se guarda la reserva a través del DAO
            reservasEntidad = reservaDAO.buscarReservaPorSeccion(seccion.getSeccion(), fechas.getDesde(), fechas.getHasta());
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
    
    /**
     * Método que retorna las reservas de una sección especificada, con las fechas especificadas
     * 
     * @param tipo Contiene el tipo de mesa
     * @param fechas las fechas desde y hasta
     * @return una lista de las reservas
     * @throws NegocioException Si ocurre un error en la lógica del negocio al 
     *                          procesar la reserva.
     */
    @Override
    public List<ReservaDTO> buscarReservasPorTipo(ReservaDTO tipo, FechasDTO fechas) throws NegocioException {
        
        List<ReservaDTO> reservasEncontradas = new ArrayList<>();
        List<Reserva> reservasEntidad = new ArrayList<>();

        int cantMin = 0;
        int cantMax = 0;
        
        if(tipo.getNumPersonas() <= 2){
            cantMin = 1;
            cantMax = 2;
        }
        
        if(tipo.getNumPersonas() <= 4 && tipo.getNumPersonas() >= 3){
            cantMin = 3;
            cantMax = 4;
        }
        
        if(tipo.getNumPersonas() >= 5){
            cantMin = 5;
            cantMax = 8;
        }

        try {
            // Se guarda la reserva a través del DAO
            reservasEntidad = reservaDAO.buscarReservaPorTipo(cantMin, cantMax, fechas.getDesde(), fechas.getHasta());
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
    
    /**
     * Inserta reservas masivamente
     * @throws Excepcion.NegocioException
     */
    @Override
    public void llenarReservasMasivamente() throws NegocioException{
        
        try {
            
            IClienteNegocio clienteNegocio = new ClienteNegocio();
            IMesaNegocio mesaNegocio = new MesaNegocio();
            
            List<ClienteDTO> clientesDTO = clienteNegocio.obtenerClientes();
            List<Cliente> clientes = new ArrayList<>();
            
            for(ClienteDTO clienteDTO : clientesDTO){
            
                Cliente nuevoCliente = new Cliente(clienteDTO.getId(), clienteDTO.getNumTelefono(), clienteDTO.getNombreCompleto());
                clientes.add(nuevoCliente);
                
            }
            
            List<MesaDTO> mesasDTO = mesaNegocio.obtenerTodasLasMesas();
            List<Mesa> mesas = new ArrayList<>();
            
            for(MesaDTO mesaDTO : mesasDTO){
            
                Mesa nuevaMesa = new Mesa(mesaDTO.getCodigo(), mesaDTO.getTipo(), mesaDTO.getCapacidad(), mesaDTO.getUbicacion());
                mesas.add(nuevaMesa);
                
            }
            
            Calendar fechaReserva1 = Calendar.getInstance();
            fechaReserva1.set(2024, 11, 11, 11, 30);
            ReservaDTO reserva1 = new ReservaDTO(fechaReserva1, 2, 300, mesas.get(0), clientes.get(0), "General");
            
            Calendar fechaReserva2 = Calendar.getInstance();
            fechaReserva2.set(2024, 11, 11, 16, 30);
            ReservaDTO reserva2 = new ReservaDTO(fechaReserva2, 2, 300, mesas.get(0), clientes.get(1), "General");
            
            Calendar fechaReserva3 = Calendar.getInstance();
            fechaReserva3.set(2024, 11, 11, 21, 30);
            ReservaDTO reserva3 = new ReservaDTO(fechaReserva3, 2, 300, mesas.get(0), clientes.get(2), "General");
            
            Calendar fechaReserva4 = Calendar.getInstance();
            fechaReserva4.set(2024, 11, 11, 9, 15);
            ReservaDTO reserva4 = new ReservaDTO(fechaReserva4, 2, 300, mesas.get(16), clientes.get(0), "Terraza");
            
            Calendar fechaReserva5 = Calendar.getInstance();
            fechaReserva5.set(2024, 11, 11, 15, 45);
            ReservaDTO reserva5 = new ReservaDTO(fechaReserva5, 2, 300, mesas.get(16), clientes.get(1), "Terraza");
            
            Calendar fechaReserva6 = Calendar.getInstance();
            fechaReserva6.set(2024, 11, 11, 21, 59);
            ReservaDTO reserva6 = new ReservaDTO(fechaReserva6, 2, 300, mesas.get(16), clientes.get(2), "Terraza");
            
            Calendar fechaReserva7 = Calendar.getInstance();
            fechaReserva7.set(2024, 11, 01, 21, 15);
            ReservaDTO reserva7 = new ReservaDTO(fechaReserva7, 2, 300, mesas.get(25), clientes.get(7), "Ventana");
            
            Calendar fechaReserva8 = Calendar.getInstance();
            fechaReserva8.set(2024, 11, 13, 14, 15);
            ReservaDTO reserva8 = new ReservaDTO(fechaReserva8, 2, 300, mesas.get(24), clientes.get(6), "Ventana");
            
            Calendar fechaReserva9 = Calendar.getInstance();
            fechaReserva9.set(2024, 11, 2, 15, 45);
            ReservaDTO reserva9 = new ReservaDTO(fechaReserva9, 2, 300, mesas.get(8), clientes.get(5), "Patio");
            
            Calendar fechaReserva10 = Calendar.getInstance();
            fechaReserva10.set(2024, 11, 15, 9, 59);
            ReservaDTO reserva10 = new ReservaDTO(fechaReserva10, 2, 300, mesas.get(10), clientes.get(4), "Patio");
            
            Calendar fechaReserva11 = Calendar.getInstance();
            fechaReserva11.set(2024, 11, 11, 11, 30);
            ReservaDTO reserva11 = new ReservaDTO(fechaReserva11, 4, 500, mesas.get(3), clientes.get(3), "General");
            
            Calendar fechaReserva12 = Calendar.getInstance();
            fechaReserva12.set(2024, 11, 11, 16, 30);
            ReservaDTO reserva12 = new ReservaDTO(fechaReserva12, 4, 500, mesas.get(3), clientes.get(2), "General");
            
            Calendar fechaReserva13 = Calendar.getInstance();
            fechaReserva13.set(2024, 11, 11, 21, 30);
            ReservaDTO reserva13 = new ReservaDTO(fechaReserva13, 4, 500, mesas.get(3), clientes.get(1), "General");
            
            Calendar fechaReserva14 = Calendar.getInstance();
            fechaReserva14.set(2024, 11, 11, 9, 15);
            ReservaDTO reserva14 = new ReservaDTO(fechaReserva14, 4, 500, mesas.get(20), clientes.get(3), "Terraza");
            
            Calendar fechaReserva15 = Calendar.getInstance();
            fechaReserva15.set(2024, 11, 11, 15, 45);
            ReservaDTO reserva15 = new ReservaDTO(fechaReserva15, 4, 500, mesas.get(20), clientes.get(2), "Terraza");
            
            Calendar fechaReserva16 = Calendar.getInstance();
            fechaReserva16.set(2024, 11, 11, 21, 59);
            ReservaDTO reserva16 = new ReservaDTO(fechaReserva16, 4, 500, mesas.get(20), clientes.get(1), "Terraza");
            
            Calendar fechaReserva17 = Calendar.getInstance();
            fechaReserva17.set(2024, 11, 01, 21, 15);
            ReservaDTO reserva17 = new ReservaDTO(fechaReserva17, 4, 500, mesas.get(28), clientes.get(4), "Ventana");
            
            Calendar fechaReserva18 = Calendar.getInstance();
            fechaReserva18.set(2024, 11, 13, 14, 15);
            ReservaDTO reserva18 = new ReservaDTO(fechaReserva18, 4, 500, mesas.get(29), clientes.get(5), "Ventana");
            
            Calendar fechaReserva19 = Calendar.getInstance();
            fechaReserva19.set(2024, 11, 12, 15, 45);
            ReservaDTO reserva19 = new ReservaDTO(fechaReserva19, 4, 500, mesas.get(12), clientes.get(6), "Patio");
            
            Calendar fechaReserva20 = Calendar.getInstance();
            fechaReserva20.set(2024, 11, 15, 9, 59);
            ReservaDTO reserva20 = new ReservaDTO(fechaReserva20, 4, 500, mesas.get(13), clientes.get(7), "Patio");
            
            Calendar fechaReserva21 = Calendar.getInstance();
            fechaReserva21.set(2024, 11, 5, 11, 30);
            ReservaDTO reserva21 = new ReservaDTO(fechaReserva21, 8, 800, mesas.get(6), clientes.get(13), "General");
            
            Calendar fechaReserva22 = Calendar.getInstance();
            fechaReserva22.set(2024, 11, 4, 16, 30);
            ReservaDTO reserva22 = new ReservaDTO(fechaReserva22, 8, 800, mesas.get(6), clientes.get(12), "General");
            
            Calendar fechaReserva23 = Calendar.getInstance();
            fechaReserva23.set(2024, 11, 2, 21, 30);
            ReservaDTO reserva23 = new ReservaDTO(fechaReserva23, 8, 800, mesas.get(6), clientes.get(11), "General");
            
            Calendar fechaReserva24 = Calendar.getInstance();
            fechaReserva24.set(2024, 11, 5, 9, 15);
            ReservaDTO reserva24 = new ReservaDTO(fechaReserva24, 8, 800, mesas.get(23), clientes.get(13), "Terraza");
            
            Calendar fechaReserva25 = Calendar.getInstance();
            fechaReserva25.set(2024, 11, 8, 15, 45);
            ReservaDTO reserva25 = new ReservaDTO(fechaReserva25, 8, 800, mesas.get(23), clientes.get(12), "Terraza");
            
            Calendar fechaReserva26 = Calendar.getInstance();
            fechaReserva26.set(2024, 11, 4, 21, 59);
            ReservaDTO reserva26 = new ReservaDTO(fechaReserva26, 8, 800, mesas.get(23), clientes.get(11), "Terraza");
            
            Calendar fechaReserva27 = Calendar.getInstance();
            fechaReserva27.set(2024, 11, 01, 21, 15);
            ReservaDTO reserva27 = new ReservaDTO(fechaReserva27, 8, 800, mesas.get(30), clientes.get(14), "Ventana");
            
            Calendar fechaReserva28 = Calendar.getInstance();
            fechaReserva28.set(2024, 11, 7, 14, 15);
            ReservaDTO reserva28 = new ReservaDTO(fechaReserva28, 8, 800, mesas.get(31), clientes.get(15), "Ventana");
            
            Calendar fechaReserva29 = Calendar.getInstance();
            fechaReserva29.set(2024, 11, 13, 15, 45);
            ReservaDTO reserva29 = new ReservaDTO(fechaReserva29, 8, 800, mesas.get(15), clientes.get(16), "Patio");
            
            Calendar fechaReserva30 = Calendar.getInstance();
            fechaReserva30.set(2024, 11, 11, 9, 59);
            ReservaDTO reserva30 = new ReservaDTO(fechaReserva30, 8, 800, mesas.get(14), clientes.get(17), "Patio");

            guardarReserva(reserva1);
            guardarReserva(reserva2);
            guardarReserva(reserva3);
            guardarReserva(reserva4);
            guardarReserva(reserva5);
            guardarReserva(reserva6);
            guardarReserva(reserva7);
            guardarReserva(reserva8);
            guardarReserva(reserva9);
            guardarReserva(reserva10);
            guardarReserva(reserva11);
            guardarReserva(reserva12);
            guardarReserva(reserva13);
            guardarReserva(reserva14);
            guardarReserva(reserva15);
            guardarReserva(reserva16);
            guardarReserva(reserva17);
            guardarReserva(reserva18);
            guardarReserva(reserva19);
            guardarReserva(reserva20);
            guardarReserva(reserva21);
            guardarReserva(reserva22);
            guardarReserva(reserva23);
            guardarReserva(reserva24);
            guardarReserva(reserva25);
            guardarReserva(reserva26);
            guardarReserva(reserva27);
            guardarReserva(reserva28);
            guardarReserva(reserva29);
            guardarReserva(reserva30);
            
        } catch (NegocioException ex) {
            System.out.println("Error al insertar reservas masivamente");
        }

    }
    
    
}
