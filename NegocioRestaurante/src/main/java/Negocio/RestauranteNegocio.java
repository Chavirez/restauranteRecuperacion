/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DAO.RestauranteDAO;
import DTO.RestauranteDTO;
import Entidades.Restaurante;
import Excepcion.NegocioException;
import Excepcion.PersistenciaException;
import InterfacesDAO.IRestauranteDAO;
import InterfacesNegocio.IRestauranteNegocio;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * La clase RestauranteNegocio contiene la lógica de negocio relacionada con la entidad Restaurante.
 * Permite verificar si un restaurante ya existe y guardar un nuevo restaurante si es necesario.
 * 
 * @author santi
 */
public class RestauranteNegocio implements IRestauranteNegocio{
    
    /**
     * Instancia de la interfaz IRestauranteDAO para realizar operaciones de persistencia sobre la entidad Restaurante.
     */
    private final IRestauranteDAO restauranteDAO = new RestauranteDAO();

    /**
     * Constructor vacío de la clase RestauranteNegocio.
     * Inicializa la instancia del DAO para interactuar con la base de datos.
     */
    public RestauranteNegocio(){
    }
    
    /**
     * Verifica si ya existe un restaurante en la base de datos.
     * Llama al método de persistencia para comprobar si el restaurante está registrado.
     * 
     * @return true si el restaurante existe en la base de datos, false si no existe.
     * @throws NegocioException Si ocurre un error al verificar la existencia del restaurante en la base de datos.
     */
    @Override
    public boolean verificarSiExiste() throws NegocioException{
    
        boolean respuesta = false;
        
        try {
            // Si el restaurante existe, se establece respuesta en true
            if(restauranteDAO.buscarRestaurante() != null)
                respuesta = true;
            
        } catch (PersistenciaException ex) {
            // Loguea el error si ocurre una excepción de persistencia
            System.out.println("Error al verificar la existencia de la BD");
        }
        
        return respuesta;
    }
    
    /**
     * Busca un el restaurante del proyeto
     * 
     * @return RestauranteDTO el restaurante
     * @throws NegocioException Si ocurre un error al verificar la existencia del restaurante en la base de datos.
     */
    @Override
    public RestauranteDTO buscarRestaurante() throws NegocioException{
    
        RestauranteDTO restaurante = null;
        Restaurante restauranteEntidad;
        
        try {
            // Si el restaurante existe, se establece respuesta en true
            restauranteEntidad = restauranteDAO.buscarRestaurante();
            
            restaurante = new RestauranteDTO(restauranteEntidad.getHoraApertura(),
                    restauranteEntidad.getHoraCierre(), restauranteEntidad.getUbicaciones());
            
            
        } catch (PersistenciaException ex) {
            // Loguea el error si ocurre una excepción de persistencia
            System.out.println("Error al verificar la existencia de la BD");
        }
        
        return restaurante;
    }
    
    /**
     * Guarda un nuevo restaurante en la base de datos si aún no existe.
     * Define valores por defecto para la hora de apertura, hora de cierre y ubicaciones del restaurante.
     * 
     * @throws NegocioException Si ocurre un error durante el proceso de guardado del restaurante.
     */
    @Override
    public void guardarRestaurante() throws NegocioException{
    
        // Si el restaurante ya existe, no se guarda otro
        if(verificarSiExiste())
            return;
            
        // Definir hora de apertura y cierre
        Time horaApertura = Time.valueOf("08:00:00");
        Time horaCierre = Time.valueOf("23:00:00");
        
        // Crear lista de ubicaciones disponibles para el restaurante
        List<String> ubicaciones = new ArrayList<>();
        ubicaciones.add("Terraza");
        ubicaciones.add("Ventana");
        ubicaciones.add("Patio");
        ubicaciones.add("General");
        
        // Crear instancia del restaurante
        Restaurante restaurante = new Restaurante(horaApertura, horaCierre, ubicaciones);
        
        try {
            // Llamar al DAO para guardar el restaurante en la base de datos
            restauranteDAO.guardarRestaurante(restaurante);
        } catch (PersistenciaException ex) {
            // Loguea el error si ocurre una excepción de persistencia
            System.out.println("Error al insertar restaurante");
        }
    }
}
