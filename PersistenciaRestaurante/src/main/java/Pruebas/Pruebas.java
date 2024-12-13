/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Pruebas;

import DAO.ClienteDAO;
import DAO.MesaDAO;
import Entidades.Cliente;
import Excepcion.PersistenciaException;

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

        Cliente cli = new Cliente("6442259443", "Santiago Sánchez Chavira");

        System.out.println(c.buscarClientePorTelefono("6442259443"));
        
    }
    
}
