/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfacesNegocio;

import DTO.ClienteDTO;
import Excepcion.NegocioException;

/**
 * Interfaz que define las operaciones de negocio relacionadas con los clientes.
 * Esta interfaz proporciona métodos para obtener y guardar la información de los clientes.
 * 
 * <p>Las implementaciones de esta interfaz son responsables de la lógica de negocio relacionada
 * con los clientes, como la búsqueda por teléfono y el almacenamiento de nuevos clientes.</p>
 * 
 * @author santi
 */
public interface IClienteNegocio {
    
    /**
     * Obtiene un cliente a partir de su número de teléfono.
     * 
     * @param cliente El objeto {@link ClienteDTO} que contiene el número de teléfono del cliente a buscar.
     * @return Un objeto {@link ClienteDTO} con la información del cliente encontrado, o null si no se encuentra.
     * @throws NegocioException Si ocurre un error durante la operación.
     */
    public ClienteDTO obtenerClientePorTelefono(ClienteDTO cliente) throws NegocioException;
    
    /**
     * Guarda un nuevo cliente en el sistema.
     * Si el cliente ya existe (según su número de teléfono), no se guarda.
     * 
     * @param cliente El objeto {@link ClienteDTO} que representa al cliente a guardar.
     * @throws NegocioException Si ocurre un error durante la operación.
     */
    public void guardarCliente(ClienteDTO cliente) throws NegocioException;

}
