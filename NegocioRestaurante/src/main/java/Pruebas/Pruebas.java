/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Pruebas;

import DTO.MesaDTO;
import Excepcion.NegocioException;
import Negocio.MesaNegocio;

/**
 *
 * @author santi
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NegocioException {
        // TODO code application logic here
        
        MesaNegocio mesaNegocio = new MesaNegocio();
        
        MesaDTO mesaDTO = new MesaDTO("Grande", 8, "Ventana");
        
        mesaNegocio.guardarMesa(mesaDTO);
//        System.out.println(mesaNegocio.obtenerTodasLasMesas().toString());
        
        
    }
    
}
