/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DAO.ClienteDAO;
import DTO.ClienteDTO;
import DTO.FechasDTO;
import Entidades.Cliente;
import Excepcion.NegocioException;
import Excepcion.PersistenciaException;
import InterfacesDAO.IClienteDAO;
import InterfacesNegocio.IClienteNegocio;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.EncriptacionTelefono;

/**
 * Clase que gestiona las operaciones de negocio relacionadas con los clientes.
 * Implementa la interfaz {@link IClienteNegocio} y proporciona métodos para obtener, guardar y gestionar la información de los clientes.
 * La clase interactúa con el {@link ClienteDAO} para realizar las operaciones de persistencia de datos.
 * 
 * <p>Esta clase se encarga de la lógica de negocio y validaciones relacionadas con los clientes.</p>
 * 
 * @author santi
 */
public class ClienteNegocio implements IClienteNegocio {

    private final IClienteDAO clienteDAO = new ClienteDAO();
    
    /**
     * Constructor de la clase ClienteNegocio.
     * Inicializa el acceso al DAO de clientes.
     */
    public ClienteNegocio() {
    }
    
    /**
     * Obtiene un cliente en base a su número de teléfono.
     * Si el cliente existe en la base de datos, se convierte en un {@link ClienteDTO} y se retorna.
     * Si no se encuentra el cliente, se retorna null.
     * 
     * @param cliente El objeto {@link ClienteDTO} con el número de teléfono del cliente a buscar.
     * @return Un {@link ClienteDTO} que representa al cliente encontrado, o null si no se encuentra.
     * @throws NegocioException Si ocurre un error durante la operación.
     */
    @Override
    public ClienteDTO obtenerClientePorTelefono(ClienteDTO cliente) throws NegocioException {
        
        String telefonoEncriptado = new String();
        try {
            telefonoEncriptado = EncriptacionTelefono.encriptarTelefono(cliente.getNumTelefono());
        } catch (Exception ex) {
            System.out.println("Error al encriptar teléfono");
        }
        Cliente clienteRecibido = new Cliente();
        
        try {
            clienteRecibido = clienteDAO.buscarClientePorTelefono(telefonoEncriptado);
        } catch (PersistenciaException ex) {
            System.out.println("Error al buscar cliente por el siguiente teléfono " + cliente.getNumTelefono() + " en negocio.");
        }
        
        if(clienteRecibido == null)
            return null;
        
        ClienteDTO clienteConvertido = new ClienteDTO(clienteRecibido.getId(), clienteRecibido.getNumTelefono(), clienteRecibido.getNombreCompleto());
        
        return clienteConvertido;
        
    }
    
    /**
     * Obtiene clientes en base a su nombre.
     * Si el cliente existe en la base de datos, se convierte en un {@link ClienteDTO} y se retorna.
     * Si no se encuentra el cliente, se retorna null.
     * 
     * @param cliente El objeto {@link ClienteDTO} con el nombre del cliente a buscar.
     * @return Una lista de {@link ClienteDTO} que representa a los clientes encontrado, o null si no se encuentra.
     * @throws NegocioException Si ocurre un error durante la operación.
     */
    @Override
    public List<ClienteDTO> obtenerClientesPorNombre(ClienteDTO cliente) throws NegocioException {
        

        List<Cliente> clientesEntidadRecibidos = null;
        List<ClienteDTO> clientesDTORecibidos = new ArrayList<>();
        
        try {
            clientesEntidadRecibidos = clienteDAO.buscarClientesPorNombre(cliente.getNombreCompleto());
        } catch (PersistenciaException ex) {
            System.out.println("Error al buscar cliente por el siguiente teléfono " + cliente.getNombreCompleto() + " en negocio.");
        }
        
        if(clientesEntidadRecibidos == null)
            return null;
        
        for(Cliente clienteEntidad : clientesEntidadRecibidos){
            ClienteDTO clienteConvertido = new ClienteDTO(clienteEntidad.getId(), clienteEntidad.getNumTelefono(), clienteEntidad.getNombreCompleto());
            clientesDTORecibidos.add(clienteConvertido);
        }
        return clientesDTORecibidos;
        
    }
    
    /**
     * Obtiene clientes en base a si tiene reservas en la fecha especificada.
     * Si el cliente existe en la base de datos, se convierte en un {@link ClienteDTO} y se retorna.
     * Si no se encuentra el cliente, se retorna null.
     * 
     * @param fechas las fechas desde y hasta
     * @return Una lista de {@link ClienteDTO} que representa a los clientes encontrado, o null si no se encuentra.
     * @throws NegocioException Si ocurre un error durante la operación.
     */
    @Override
    public List<ClienteDTO> obtenerClientesPorFecha(FechasDTO fechas) throws NegocioException {
        

        List<Cliente> clientesEntidadRecibidos = null;
        List<ClienteDTO> clientesDTORecibidos = new ArrayList<>();
        
        try {
            clientesEntidadRecibidos = clienteDAO.buscarClientesPorFecha(fechas.getDesde(), fechas.getHasta());
        } catch (PersistenciaException ex) {
            System.out.println("Error al buscar cliente por fechas" + ex);
        }
        
        if(clientesEntidadRecibidos == null)
            return null;
        
        for(Cliente clienteEntidad : clientesEntidadRecibidos){
            ClienteDTO clienteConvertido = new ClienteDTO(clienteEntidad.getId(), clienteEntidad.getNumTelefono(), clienteEntidad.getNombreCompleto());
            clientesDTORecibidos.add(clienteConvertido);
        }
        return clientesDTORecibidos;
        
    }
    
    /**
     * Obtiene clientes.
     * 
     * @return Una lista de {@link ClienteDTO} que representa a los clientes encontrado, o null si no se encuentra.
     * @throws NegocioException Si ocurre un error durante la operación.
     */
    @Override
    public List<ClienteDTO> obtenerClientes() throws NegocioException {
        

        List<Cliente> clientesEntidadRecibidos = null;
        List<ClienteDTO> clientesDTORecibidos = new ArrayList<>();
        
        try {
            clientesEntidadRecibidos = clienteDAO.buscarClientes();
        } catch (PersistenciaException ex) {
            System.out.println("Error al buscar clientes en negocio.");
        }
        
        if(clientesEntidadRecibidos == null)
            return null;
        
        for(Cliente clienteEntidad : clientesEntidadRecibidos){
            ClienteDTO clienteConvertido = new ClienteDTO(clienteEntidad.getId(), clienteEntidad.getNumTelefono(), clienteEntidad.getNombreCompleto());
            clientesDTORecibidos.add(clienteConvertido);
        }
        return clientesDTORecibidos;
        
    }
    
    /**
     * Guarda un nuevo cliente en la base de datos.
     * Si el cliente ya existe (basado en el número de teléfono), no se guarda.
     * 
     * @param cliente El objeto {@link ClienteDTO} que representa al cliente a guardar.
     * @throws NegocioException Si ocurre un error durante la operación.
     */
    @Override
    public void guardarCliente(ClienteDTO cliente) throws NegocioException {
        
        try {
            
            Cliente clienteNuevo = new Cliente(EncriptacionTelefono.encriptarTelefono(cliente.getNumTelefono()), cliente.getNombreCompleto());
            
            if(obtenerClientePorTelefono(cliente) != null)
                return;
            
            try {
                clienteDAO.guardarCliente(clienteNuevo);
            } catch (PersistenciaException ex) {
                System.out.println("Error al guardar cliente nuevo en negocio.");
            }
        } catch (Exception ex) {
           System.out.println("Error al encriptar teléfono " + cliente.getNumTelefono());
        }
    }    
    
    /**
     * Inserta clientes masivamente
     * @throws Excepcion.NegocioException
     */
    @Override
    public void llenarClientesMasivamente() throws NegocioException{

        try {
            // mesas terraza
            ClienteDTO cliente1 = new ClienteDTO("6442259443", "Santiago Sánchez");
            ClienteDTO cliente2 = new ClienteDTO("6441157843", "Romina Meza");
            ClienteDTO cliente3 = new ClienteDTO("6443345987", "José Pérez");
            ClienteDTO cliente4 = new ClienteDTO("6449987754", "Ana González");
            ClienteDTO cliente5 = new ClienteDTO("6447761123", "Carlos Ramírez");
            ClienteDTO cliente6 = new ClienteDTO("6445547869", "Laura Fernández");
            ClienteDTO cliente7 = new ClienteDTO("6448889976", "Miguel Torres");
            ClienteDTO cliente8 = new ClienteDTO("6442233445", "Paula Mendoza");
            ClienteDTO cliente9 = new ClienteDTO("6446677889", "Luis Morales");
            ClienteDTO cliente10 = new ClienteDTO("6449900112", "Andrea Vargas");
            ClienteDTO cliente11 = new ClienteDTO("6445432178", "Fernando Castillo");
            ClienteDTO cliente12 = new ClienteDTO("6447765432", "Claudia Reyes");
            ClienteDTO cliente13 = new ClienteDTO("6448800113", "Juan Herrera");
            ClienteDTO cliente14 = new ClienteDTO("6446654321", "Lucía Ríos");
            ClienteDTO cliente15 = new ClienteDTO("6449988997", "Sofía Martínez");
            ClienteDTO cliente16 = new ClienteDTO("6443344567", "Diego Romero");
            ClienteDTO cliente17 = new ClienteDTO("6442233456", "Camila Cruz");
            ClienteDTO cliente18 = new ClienteDTO("6447788991", "Javier Navarro");
            ClienteDTO cliente19 = new ClienteDTO("6441144556", "Valeria Peña");
            ClienteDTO cliente20 = new ClienteDTO("6449981122", "Emilio Ortega");

            
            guardarCliente(cliente1);
            guardarCliente(cliente2);
            guardarCliente(cliente3);
            guardarCliente(cliente4);
            guardarCliente(cliente5);
            guardarCliente(cliente6);
            guardarCliente(cliente7);
            guardarCliente(cliente8);
            guardarCliente(cliente9);
            guardarCliente(cliente10);
            guardarCliente(cliente11);
            guardarCliente(cliente12);
            guardarCliente(cliente13);
            guardarCliente(cliente14);
            guardarCliente(cliente15);
            guardarCliente(cliente16);
            guardarCliente(cliente17);
            guardarCliente(cliente18);
            guardarCliente(cliente19);
            guardarCliente(cliente20);

            
        } catch (NegocioException ex) {
            System.out.println("Error al insertar clientes masivamente");
        }

    }
    
}

