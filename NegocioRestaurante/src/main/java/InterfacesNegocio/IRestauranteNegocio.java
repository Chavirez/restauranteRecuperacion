/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfacesNegocio;

import DTO.RestauranteDTO;
import Excepcion.NegocioException;

/**
 * Esta interfaz define las operaciones de negocio relacionadas con la entidad Restaurante.
 * La interfaz proporciona métodos para guardar un restaurante y verificar si un restaurante ya existe en el sistema.
 * 
 * @author santi
 */
public interface IRestauranteNegocio {
    
    /**
     * Guarda un restaurante en el sistema.
     * Este método será implementado para realizar las validaciones y persistencia necesarias.
     * 
     * @throws NegocioException Si ocurre un error durante el proceso de guardado.
     */
    public void guardarRestaurante() throws NegocioException;
        
    /**
     * Verifica si un restaurante ya existe en el sistema.
     * Este método será implementado para comprobar la existencia de un restaurante 
     * en la base de datos u otro almacenamiento persistente.
     * 
     * @return true si el restaurante existe, false si no.
     * @throws NegocioException Si ocurre un error durante la verificación.
     */
    public boolean verificarSiExiste() throws NegocioException;
    
    /**
     * Busca un el restaurante del proyeto
     * 
     * @return RestauranteDTO el restaurante
     * @throws NegocioException Si ocurre un error al verificar la existencia del restaurante en la base de datos.
     */
    public RestauranteDTO buscarRestaurante() throws NegocioException;
    
    /**
     * Actualiza un restaurante
     * 
     * @param restauranteD el restaurante nuevo
     * @throws NegocioException Si ocurre un error durante el proceso de guardado del restaurante.
     */
    public void actualizarRestaurante(RestauranteDTO restauranteD) throws NegocioException;
    
}
