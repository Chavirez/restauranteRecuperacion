/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfacesDAO;

import Entidades.Cliente;
import Excepcion.PersistenciaException;
import java.sql.Time;
import java.util.List;

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
    
    
    /**
     * Busca clientes en la base de datos utilizando su nombre.
     * Si se encuentra un cliente con el nombre proporcionado, lo devuelve.
     * Si no se encuentra ningún cliente o ocurre un error, devuelve null.
     * 
     * @param nombre El nombre  del cliente que se desea buscar.
     * @return Un objeto Clientes que coincide con el número de teléfono proporcionado, o null si no se encuentra.
     * @throws PersistenciaException Si ocurre un error al realizar la búsqueda.
     */
    public List<Cliente> buscarClientesPorNombre(String nombre) throws PersistenciaException;
    
    
    /**
     * Busca todos los clientes
     * Si no se encuentra ningún cliente o ocurre un error, devuelve null.
     * 
     * @return Un objeto Clientes.
     * @throws PersistenciaException Si ocurre un error al realizar la búsqueda.
     */
    public List<Cliente> buscarClientes() throws PersistenciaException;
    
    
    /**
     * Busca un cliente en la base de datos con reservas en la fecha especificada.
     * Si se encuentra un cliente con el fecha proporcionada, lo devuelve.
     * Si no se encuentra ningún cliente o ocurre un error, devuelve null.
     * 
     * @param desde fecha inicial.
     * @param hasta fecha final.
     * @return Un objeto Clientes que coincide con el número de teléfono proporcionado, o null si no se encuentra.
     * @throws PersistenciaException Si ocurre un error al realizar la búsqueda.
     */
    public List<Cliente> buscarClientesPorFecha(Time desde, Time hasta) throws PersistenciaException;
    
}
