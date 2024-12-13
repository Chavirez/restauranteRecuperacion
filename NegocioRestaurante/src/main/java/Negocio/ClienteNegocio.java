/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DAO.ClienteDAO;
import DTO.ClienteDTO;
import Entidades.Cliente;
import Excepcion.NegocioException;
import Excepcion.PersistenciaException;
import InterfacesDAO.IClienteDAO;
import InterfacesNegocio.IClienteNegocio;
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
}

