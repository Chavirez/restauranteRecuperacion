/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DAO.MesaDAO;
import DTO.MesaDTO;
import Entidades.Mesa;
import Excepcion.NegocioException;
import Excepcion.PersistenciaException;
import InterfacesNegocio.IMesaNegocio;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase encargada de la lógica de negocio para la gestión de las mesas.
 * Implementa la interfaz {@link IMesaNegocio}.
 * Proporciona métodos para obtener, guardar, eliminar y actualizar mesas.
 * 
 * @author santi
 */
public class MesaNegocio implements IMesaNegocio{
    
    // Instancia del objeto DAO para la persistencia de datos de las mesas
    private final MesaDAO mesaDAO = new MesaDAO();

    /**
     * Constructor de la clase {@link MesaNegocio}.
     */
    public MesaNegocio() {
    }

    /**
     * Obtiene todas las mesas de la base de datos y las convierte a DTOs.
     * 
     * @return Una lista de objetos {@link MesaDTO} con las mesas obtenidas de la base de datos.
     * @throws NegocioException Si ocurre algún error en la capa de negocio al obtener las mesas.
     */
    @Override
    public List<MesaDTO> obtenerTodasLasMesas() throws NegocioException{
    
        // Lista donde se almacenarán los objetos MesaDTO
        List<MesaDTO> listaMesas = new ArrayList<>();
        
        try {
            // Se obtiene la lista de todas las mesas desde el DAO y se convierte a DTO
            for(Mesa mesa : mesaDAO.buscarTodasLasMesas()){
                
                MesaDTO mesaDTO = new MesaDTO(mesa.getCodigo(), mesa.getTipo(), mesa.getCapacidad(), mesa.getUbicacion());
                
                // Se agrega el DTO a la lista
                listaMesas.add(mesaDTO);
                
            }
        } catch (PersistenciaException ex) {
            // Se captura y muestra un mensaje si ocurre un error en la capa de persistencia
            System.out.println("Error al buscar todas las mesas en Negocio" + ex);
        }
        
        return listaMesas;
    }

    /**
     * Guarda una nueva mesa en la base de datos.
     * Genera un código único para la mesa basándose en la ubicación y la capacidad.
     * 
     * @param mesa El objeto {@link MesaDTO} con los datos de la mesa a guardar.
     * @throws NegocioException Si ocurre un error en la capa de negocio al guardar la mesa.
     */
    @Override
    public void guardarMesa(MesaDTO mesa) throws NegocioException{
    
        try {
            
            // Creación de una nueva instancia de la entidad Mesa
            Mesa mesaNueva = new Mesa();
            mesaNueva.setCapacidad(mesa.getCapacidad());
            mesaNueva.setTipo(mesa.getTipo());
            mesaNueva.setUbicacion(mesa.getUbicacion());
            
            // Generación de un código único para la mesa
            String ubicacion = mesa.getUbicacion().substring(0, 3).toUpperCase();
            String capacidad = String.valueOf(mesa.getCapacidad());
            
            String codigo;
            int numeroIncremental = 1;
            
            // Verificación del código único
            for(MesaDTO mesaDTO : obtenerTodasLasMesas()){
                if(!mesaDTO.getUbicacion().toUpperCase().startsWith(ubicacion))
                    continue;

                int numCodigoMesa = Integer.parseInt(mesaDTO.getCodigo().substring(7));
                if(numCodigoMesa != numeroIncremental)
                    break;

                numeroIncremental++;
            }
            
            // Construcción del código final
            codigo = ubicacion + "-" + capacidad + "-" + String.format("%03d", numeroIncremental);
            mesaNueva.setCodigo(codigo);
            
            // Guardado de la mesa en la base de datos a través del DAO
            mesaDAO.guardarMesa(mesaNueva);
            
        } catch (PersistenciaException ex) {
            // Captura y muestra de errores al guardar la mesa
            System.out.println("Error al guardar mesa en Negocio" + ex);
        }
    }

    /**
     * Elimina una mesa de la base de datos.
     * 
     * @param mesaDTO El objeto {@link MesaDTO} que representa la mesa a eliminar.
     * @throws NegocioException Si ocurre un error en la capa de negocio al eliminar la mesa.
     */
    @Override
    public void eliminarMesa(MesaDTO mesaDTO) throws NegocioException{
        
        // Se convierte el DTO a entidad Mesa
        Mesa mesa = new Mesa(mesaDTO.getCodigo(), mesaDTO.getTipo(), mesaDTO.getCapacidad(), mesaDTO.getUbicacion());
        
        try {
            // Se llama al DAO para eliminar la mesa de la base de datos
            mesaDAO.eliminarMesa(mesa);
        } catch (PersistenciaException ex) {
            // Captura y muestra de errores al eliminar la mesa
            System.out.println("Error al eliminar la siguiente mesa " + mesa.getCodigo() + " en negocio." );
        }
    }

    /**
     * Actualiza los datos de una mesa en la base de datos.
     * 
     * @param mesaVieja El objeto {@link MesaDTO} que representa la mesa a actualizar.
     * @param mesaNueva El objeto {@link MesaDTO} con los nuevos datos de la mesa.
     */
    @Override
    public void actualizarMesa(MesaDTO mesaVieja, MesaDTO mesaNueva){
        
        try {
            // Se elimina la mesa vieja y se guarda la nueva
            eliminarMesa(mesaVieja);
            guardarMesa(mesaNueva);
        } catch (NegocioException ex) {
            // Captura y muestra de errores al actualizar la mesa
            System.out.println("Error al editar la siguiente mesa " + mesaVieja.getCodigo() + " en negocio." );
        }
    }
}
