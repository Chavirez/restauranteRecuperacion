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
        
        Time horaApertura = Time.valueOf("07:00:00");
        Time horaCierre = Time.valueOf("23:00:00");
        
        // Crear lista de ubicaciones disponibles para el restaurante
        List<String> ubicaciones = new ArrayList<>();
        ubicaciones.add("Terraza");
        ubicaciones.add("Ventana");
        ubicaciones.add("Patio");
        ubicaciones.add("General");
        
        Restaurante res = new Restaurante(horaApertura, horaCierre, ubicaciones);
        res.setId((long) 1);
        
        re.actualizarRestaurante(res);
        
    }
    
}
