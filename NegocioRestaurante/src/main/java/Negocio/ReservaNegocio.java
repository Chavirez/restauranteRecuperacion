/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DAO.ReservaDAO;
import DTO.ReservaDTO;
import Entidades.Reserva;
import Excepcion.NegocioException;
import Excepcion.PersistenciaException;
import InterfacesDAO.IReservaDAO;
import InterfacesNegocio.IReservaNegocio;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author santi
 */
public class ReservaNegocio implements IReservaNegocio{
    
    private final IReservaDAO reservaDAO = new ReservaDAO();

    public ReservaNegocio() {
    }
    
    public void guardarReserva(ReservaDTO reserva) throws NegocioException{
        
        Reserva reservaNueva = new Reserva(reserva.getFechaHora(), reserva.getNumPersonas()
                , reserva.getPrecioReserva(), reserva.getMesa(), reserva.getCliente(), reserva.getSeccion());
        
        try {
            reservaDAO.guardarReserva(reservaNueva);
        } catch (PersistenciaException ex) {
            System.out.println("Error al realizar la reserva");
        }
        
    }
    
}
