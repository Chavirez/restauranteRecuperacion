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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author santi
 */
public class MesaNegocio {
    
    private final MesaDAO mesaDAO = new MesaDAO();

    public MesaNegocio() {
    }

    public List<MesaDTO> obtenerTodasLasMesas() throws NegocioException{
    
        List<MesaDTO> listaMesas = new ArrayList<>();
        
        try {
            
            
            for(Mesa mesa : mesaDAO.buscarTodasLasMesas()){
                
                MesaDTO mesaDTO = new MesaDTO(mesa.getCodigo(), mesa.getTipo(), mesa.getCapacidad(), mesa.getUbicacion());
                
                listaMesas.add(mesaDTO);
                
            }
            
            
            
            
        } catch (PersistenciaException ex) {
            System.out.println("Error al buscar todas las mesas en Negocio" + ex);
        }
        
        return listaMesas;
        
    }
    
    public void guardarMesa(MesaDTO mesa) throws NegocioException{
    
        try {
            
            Mesa mesaNueva = new Mesa();
            
            mesaNueva.setCapacidad(mesa.getCapacidad());
            mesaNueva.setTipo(mesa.getTipo());
            mesaNueva.setUbicacion(mesa.getUbicacion());
            
            //Creación de código único
            
            String ubicacion = mesa.getUbicacion().substring(0, 3).toUpperCase();
            String capacidad = String.valueOf(mesa.getCapacidad());
            
            String codigo;
            
            int numeroIncremental = 1;
            
           
            
            for(MesaDTO mesaDTO : obtenerTodasLasMesas()){
                
                if(!mesaDTO.getUbicacion().toUpperCase().startsWith(ubicacion))
                    continue;

                int numCodigoMesa = Integer.parseInt(mesaDTO.getCodigo().substring(7));
                
                if(numCodigoMesa != numeroIncremental)
                    break;

                numeroIncremental++;
                
            }
            
            codigo = ubicacion + "-" + capacidad + "-" + String.format("%03d", numeroIncremental);
            
            mesaNueva.setCodigo(codigo);
            
            mesaDAO.guardarMesa(mesaNueva);
            
        } catch (PersistenciaException ex) {
            System.out.println("Error al guardar mesa en Negocio" + ex);
        }
        
    }
    
    
}
