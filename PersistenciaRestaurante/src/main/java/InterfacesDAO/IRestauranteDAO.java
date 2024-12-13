package InterfacesDAO;

import Entidades.Restaurante;
import Excepcion.PersistenciaException;

/**
 * La interfaz IRestauranteDAO define los métodos para interactuar con la capa de persistencia de los datos relacionados con los restaurantes.
 * Específicamente, esta interfaz define un método para guardar la información de un restaurante en la base de datos.
 * 
 * Los métodos de esta interfaz están destinados a ser implementados por una clase que maneje la persistencia de los objetos Restaurante.
 * La excepción PersistenciaException se lanza si ocurre un error durante la operación de persistencia.
 * 
 * @author santi
 */
public interface IRestauranteDAO {

    /**
     * Guarda un objeto Restaurante en la base de datos.
     * 
     * @param restaurante El objeto Restaurante que se desea guardar en la base de datos.
     * @throws PersistenciaException Si ocurre un error durante el proceso de persistencia (por ejemplo, problemas con la conexión a la base de datos).
     */
    public void guardarRestaurante(Restaurante restaurante) throws PersistenciaException;
    /**
     * Encuentra un objeto Restaurante de la base de datos.
     * 
     * @return restaurante El objeto Restaurante que existe.
     * @throws PersistenciaException Si ocurre un error durante el proceso de persistencia (por ejemplo, problemas con la conexión a la base de datos).
     */
    public Restaurante buscarRestaurante() throws PersistenciaException;
}
