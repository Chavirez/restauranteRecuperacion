/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Pruebas;

import DAO.ClienteDAO;
import DAO.MesaDAO;
import DAO.ReservaDAO;
import DAO.RestauranteDAO;
import Entidades.Cliente;
import Entidades.Reserva;
import Entidades.Restaurante;
import Excepcion.PersistenciaException;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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
        RestauranteDAO re = new RestauranteDAO();
        
        Calendar fechaDesde = Calendar.getInstance();
        fechaDesde.set(2021, 11, 13, 14, 15);
        Calendar fechaHasta = Calendar.getInstance();
        fechaHasta.set(2031, 11, 13, 14, 15);
        
        
//        System.out.println(r.buscarReservaPorSeccion("Terraza", fechaDesde, fechaHasta));
        System.out.println(r.buscarReservaPorTipo(1,2, fechaDesde, fechaHasta));
        
    }
    
}
