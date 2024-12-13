/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DAO.MesaDAO;
import DTO.MesaDTO;
import DTO.ReservaDTO;
import Entidades.Mesa;
import Excepcion.NegocioException;
import Excepcion.PersistenciaException;
import InterfacesDAO.IMesaDAO;
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
    private final IMesaDAO mesaDAO = new MesaDAO();

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
    
    /**
     * Se buscan las mesas disponibles
     * @param reserva El objeto ReservaDTO con los datos necesarios para la busqueda
     * @return List<MesaDTO> lista de mesas
     */
    @Override
    public List<MesaDTO> buscarMesasDisponibles(ReservaDTO reserva) throws NegocioException{
    
        List<MesaDTO> mesasDisponibles = new ArrayList<>();
        List<Mesa>  mesasEntidad = new ArrayList<>();
        
        try {
            mesasEntidad = mesaDAO.buscarMesasDisponibles(reserva.getSeccion(), reserva.getNumPersonas(), reserva.getFechaHora());
        } catch (PersistenciaException ex) {
            System.out.println("Error al buscar" + ex);
        }
        
        for(Mesa mesa : mesasEntidad){
        
            MesaDTO mesaD = new MesaDTO(mesa.getCodigo(), mesa.getTipo(), mesa.getCapacidad(), mesa.getUbicacion());
            
            mesasDisponibles.add(mesaD);
            
        }
        
        if(mesasDisponibles.isEmpty())
            return null;
        
        return mesasDisponibles;
        
    }
    
    /**
     * Inserta mesas masivamente
     */
    @Override
    public void llenarMesasPrueba() throws NegocioException{

        try {
            // mesas terraza
            MesaDTO mesa1t = new MesaDTO("Pequeña", 2, "Terraza");
            MesaDTO mesa2t = new MesaDTO("Pequeña", 2, "Terraza");
            MesaDTO mesa3t = new MesaDTO("Pequeña", 2, "Terraza");
            MesaDTO mesa4t = new MesaDTO("Mediana", 4, "Terraza");
            MesaDTO mesa5t = new MesaDTO("Mediana", 4, "Terraza");
            MesaDTO mesa6t = new MesaDTO("Mediana", 4, "Terraza");
            MesaDTO mesa7t = new MesaDTO("Grande", 8, "Terraza");
            MesaDTO mesa8t = new MesaDTO("Grande", 8, "Terraza");
            
            guardarMesa(mesa1t);
            guardarMesa(mesa2t);
            guardarMesa(mesa3t);
            guardarMesa(mesa4t);
            guardarMesa(mesa5t);
            guardarMesa(mesa6t);
            guardarMesa(mesa7t);
            guardarMesa(mesa8t);
            
            MesaDTO mesa1v = new MesaDTO("Pequeña", 2, "Ventana");
            MesaDTO mesa2v = new MesaDTO("Pequeña", 2, "Ventana");
            MesaDTO mesa3v = new MesaDTO("Pequeña", 2, "Ventana");
            MesaDTO mesa4v = new MesaDTO("Mediana", 4, "Ventana");
            MesaDTO mesa5v = new MesaDTO("Mediana", 4, "Ventana");
            MesaDTO mesa6v = new MesaDTO("Mediana", 4, "Ventana");
            MesaDTO mesa7v = new MesaDTO("Grande", 8, "Ventana");
            MesaDTO mesa8v = new MesaDTO("Grande", 8, "Ventana");
            
            guardarMesa(mesa1v);
            guardarMesa(mesa2v);
            guardarMesa(mesa3v);
            guardarMesa(mesa4v);
            guardarMesa(mesa5v);
            guardarMesa(mesa6v);
            guardarMesa(mesa7v);
            guardarMesa(mesa8v);
            
            MesaDTO mesa1g = new MesaDTO("Pequeña", 2, "General");
            MesaDTO mesa2g = new MesaDTO("Pequeña", 2, "General");
            MesaDTO mesa3g = new MesaDTO("Pequeña", 2, "General");
            MesaDTO mesa4g = new MesaDTO("Mediana", 4, "General");
            MesaDTO mesa5g = new MesaDTO("Mediana", 4, "General");
            MesaDTO mesa6g = new MesaDTO("Mediana", 4, "General");
            MesaDTO mesa7g = new MesaDTO("Grande", 8, "General");
            MesaDTO mesa8g = new MesaDTO("Grande", 8, "General");
            
            guardarMesa(mesa1g);
            guardarMesa(mesa2g);
            guardarMesa(mesa3g);
            guardarMesa(mesa4g);
            guardarMesa(mesa5g);
            guardarMesa(mesa6g);
            guardarMesa(mesa7g);
            guardarMesa(mesa8g);
            
            MesaDTO mesa1p = new MesaDTO("Pequeña", 2, "Patio");
            MesaDTO mesa2p = new MesaDTO("Pequeña", 2, "Patio");
            MesaDTO mesa3p = new MesaDTO("Pequeña", 2, "Patio");
            MesaDTO mesa4p = new MesaDTO("Mediana", 4, "Patio");
            MesaDTO mesa5p = new MesaDTO("Mediana", 4, "Patio");
            MesaDTO mesa6p = new MesaDTO("Mediana", 4, "Patio");
            MesaDTO mesa7p = new MesaDTO("Grande", 8, "Patio");
            MesaDTO mesa8p = new MesaDTO("Grande", 8, "Patio");
            
            guardarMesa(mesa1p);
            guardarMesa(mesa2p);
            guardarMesa(mesa3p);
            guardarMesa(mesa4p);
            guardarMesa(mesa5p);
            guardarMesa(mesa6p);
            guardarMesa(mesa7p);
            guardarMesa(mesa8p);
            
        } catch (NegocioException ex) {
            System.out.println("Error al insertar mesas masivamente");
        }
        
        
        

    }
}
