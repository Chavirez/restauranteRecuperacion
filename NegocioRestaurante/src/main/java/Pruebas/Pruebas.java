/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Pruebas;

import DTO.ClienteDTO;
import DTO.MesaDTO;
import DTO.ReservaDTO;
import Entidades.Cliente;
import Entidades.Mesa;
import Entidades.Restaurante;
import Excepcion.NegocioException;
import Negocio.ClienteNegocio;
import Negocio.MesaNegocio;
import Negocio.ReservaNegocio;
import Negocio.RestauranteNegocio;
import java.util.Calendar;
/**
 *
 * 
 */
public class Pruebas {

    /**
     * 
     */
    public static void main(String[] args) throws NegocioException {
        // TODO code application logic here
        
        MesaNegocio mesaNegocio = new MesaNegocio();
        ClienteNegocio clienteNegocio = new ClienteNegocio();
        RestauranteNegocio restaurante = new RestauranteNegocio();
        ReservaNegocio reserva = new ReservaNegocio();
        
        MesaDTO mesaDTO = new MesaDTO("Grande", 8, "Ventana");
        
//        mesaNegocio.guardarMesa(mesaDTO);
//        System.out.println(mesaNegocio.obtenerTodasLasMesas().toString());
        
//        mesaNegocio.actualizarMesa(mesaNegocio.obtenerTodasLasMesas().get(1), mesaDTO);

        ClienteDTO clienteDTO = new ClienteDTO("6442259443", "Santiago Sánchez Chavira");
//
//        clienteNegocio.guardarCliente(clienteDTO);

//        restaurante.guardarRestaurante();
    

    }
    
}
