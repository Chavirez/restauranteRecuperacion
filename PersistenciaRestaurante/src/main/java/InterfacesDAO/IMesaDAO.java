/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfacesDAO;

import Entidades.Mesa;
import Excepcion.PersistenciaException;
import java.util.List;

/**
 *
 * @author santi
 */
public interface IMesaDAO {
    
    public void guardarMesa(Mesa mesa) throws PersistenciaException;
    
    public List<Mesa> buscarTodasLasMesas() throws PersistenciaException;
    
    public void eliminarMesa(Mesa mesa) throws PersistenciaException;
    
}
