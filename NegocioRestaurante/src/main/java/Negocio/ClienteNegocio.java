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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author santi
 */
public class ClienteNegocio {

    ClienteDAO clienteDAO = new ClienteDAO();
    
    public ClienteNegocio() {
    }
    
    public ClienteDTO obtenerClientePorTelefono(ClienteDTO cliente) throws NegocioException{
    
        String telefono = cliente.getNumTelefono();
        Cliente clienteRecibido = new Cliente();
        
        try {
            clienteRecibido = clienteDAO.buscarClientePorTelefono(telefono);
        } catch (PersistenciaException ex) {
            System.out.println("Error al buscar cliente por el siguiente teléfono " + cliente.getNumTelefono() + " en negocio.");
        }
        
        if(clienteRecibido == null)
            return null;
        
        ClienteDTO clienteConvertido = new ClienteDTO(clienteRecibido.getId(), clienteRecibido.getNumTelefono(), clienteRecibido.getNombreCompleto());
        
        return clienteConvertido;
        
    }
    
    
    public void guardarCliente(ClienteDTO cliente) throws NegocioException{
        
        Cliente clienteNuevo = new Cliente(cliente.getNumTelefono(), cliente.getNombreCompleto());
        
        if(obtenerClientePorTelefono(cliente) != null)
            return;
        
        try {
            clienteDAO.guardarCliente(clienteNuevo);
        } catch (PersistenciaException ex) {
            System.out.println("Error al guardar cliente nuevo en negocio.");
        }
        
        
    }
    
    
}
