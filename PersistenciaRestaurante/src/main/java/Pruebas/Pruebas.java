/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Pruebas;

import DAO.ClienteDAO;
import DAO.MesaDAO;
import DAO.ReservaDAO;
import Entidades.Cliente;
import Excepcion.PersistenciaException;
import java.util.Calendar;

/**
 *
 * @author santi
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws PersistenciaException {
        // TODO code application logic here
        MesaDAO m = new MesaDAO();
        ClienteDAO c = new ClienteDAO();
        ReservaDAO r = new ReservaDAO();
        
        
        
        
        
        System.out.println(m.buscarMesasDisponibles("General", 2, Calendar.getInstance()).toString());
        
    }
    
}
