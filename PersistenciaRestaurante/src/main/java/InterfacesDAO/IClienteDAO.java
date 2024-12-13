/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfacesDAO;

import Entidades.Cliente;
import Excepcion.PersistenciaException;

/**
 *
 * @author santi
 */
public interface IClienteDAO {
    
    public void guardarCliente(Cliente cliente) throws PersistenciaException;
    
    public Cliente buscarClientePorTelefono(String telefono) throws PersistenciaException;
    
    
}
