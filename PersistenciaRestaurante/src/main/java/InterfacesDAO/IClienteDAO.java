/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfacesDAO;

import Entidades.Cliente;
import Excepcion.PersistenciaException;

/**
 * Interfaz IClienteDAO define los métodos necesarios para interactuar con la base de datos
 * relacionados con la entidad Cliente. Esta interfaz incluye métodos para guardar un cliente
 * y buscar un cliente por su número de teléfono.
 * 
 * @author santi
 */
public interface IClienteDAO {
    
    /**
     * Guarda un objeto Cliente en la base de datos.
     * Este método persiste el objeto Cliente en la base de datos utilizando un gestor de persistencia.
     * 
     * @param cliente El objeto Cliente que se desea guardar en la base de datos.
     * @throws PersistenciaException Si ocurre un error durante el proceso de persistencia.
     */
    public void guardarCliente(Cliente cliente) throws PersistenciaException;
    
    /**
     * Busca un cliente en la base de datos utilizando su número de teléfono.
     * Este método ejecuta una consulta para encontrar un cliente por su número de teléfono.
     * Si no se encuentra ningún cliente con el número de teléfono proporcionado, el método
     * retorna null.
     * 
     * @param telefono El número de teléfono del cliente que se desea buscar.
     * @return El objeto Cliente que coincide con el número de teléfono, o null si no se encuentra.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda.
     */
    public Cliente buscarClientePorTelefono(String telefono) throws PersistenciaException;
}
