/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfacesNegocio;

import DTO.MesaDTO;
import Excepcion.NegocioException;
import java.util.List;

/**
 * Interfaz que define los métodos necesarios para la gestión de mesas en la capa de negocio.
 * Esta interfaz es implementada por las clases encargadas de la lógica de negocio relacionada con las mesas.
 * 
 * Proporciona métodos para obtener, guardar, eliminar y actualizar mesas.
 * 
 * @author santi
 */
public interface IMesaNegocio {
    
    /**
     * Obtiene todas las mesas registradas en el sistema.
     * 
     * @return Una lista de objetos {@link MesaDTO} con los datos de las mesas.
     * @throws NegocioException Si ocurre un error durante la obtención de las mesas en la capa de negocio.
     */
    public List<MesaDTO> obtenerTodasLasMesas() throws NegocioException;
    
    /**
     * Guarda una nueva mesa en el sistema.
     * 
     * @param mesa El objeto {@link MesaDTO} con los datos de la mesa a guardar.
     * @throws NegocioException Si ocurre un error durante el proceso de guardado de la mesa.
     */
    public void guardarMesa(MesaDTO mesa) throws NegocioException;
    
    /**
     * Elimina una mesa del sistema.
     * 
     * @param mesaDTO El objeto {@link MesaDTO} que representa la mesa a eliminar.
     * @throws NegocioException Si ocurre un error durante la eliminación de la mesa.
     */
    public void eliminarMesa(MesaDTO mesaDTO) throws NegocioException;
    
    /**
     * Actualiza los datos de una mesa existente en el sistema.
     * Primero elimina la mesa vieja y luego guarda la nueva mesa con los cambios.
     * 
     * @param mesaVieja El objeto {@link MesaDTO} que representa la mesa a actualizar.
     * @param mesaNueva El objeto {@link MesaDTO} con los nuevos datos de la mesa.
     */
    public void actualizarMesa(MesaDTO mesaVieja, MesaDTO mesaNueva);
}
