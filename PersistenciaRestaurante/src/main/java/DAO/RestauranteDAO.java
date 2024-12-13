package DAO;

import Entidades.Restaurante;
import Excepcion.PersistenciaException;
import InterfacesDAO.IRestauranteDAO;
import conexion.ConexionBD;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

/**
 * La clase RestauranteDAO implementa la interfaz IRestauranteDAO y se encarga de manejar las operaciones de persistencia de la entidad Restaurante.
 * Utiliza JPA (Java Persistence API) para interactuar con la base de datos y realizar transacciones de almacenamiento de los datos.
 * Esta clase proporciona un método para guardar la información de un restaurante en la base de datos.
 * 
 * @author santi
 */
public class RestauranteDAO implements IRestauranteDAO {

    /**
     * Constructor de la clase RestauranteDAO.
     * Inicializa la instancia del DAO sin necesidad de parámetros adicionales.
     */
    public RestauranteDAO() {
    }
    
    /**
     * Guarda un objeto Restaurante en la base de datos. Inicia una transacción para persistir el restaurante y, en caso de error, revierte los cambios.
     * 
     * @param restaurante El objeto Restaurante que se desea guardar en la base de datos.
     * @throws PersistenciaException Si ocurre un error durante el proceso de persistencia, como problemas de conexión a la base de datos o fallos en la transacción.
     */
    @Override
    public void guardarRestaurante(Restaurante restaurante) throws PersistenciaException {

        // Declaración de objetos para manejar la transacción y el EntityManager.
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            // Obtiene el EntityManager para interactuar con la base de datos.
            entityManager = ConexionBD.getEntityManager();
            transaction = entityManager.getTransaction();
            
            // Inicia la transacción de persistencia.
            transaction.begin();

            // Persiste la entidad Restaurante.
            entityManager.persist(restaurante);

            // Confirma la transacción si la persistencia fue exitosa.
            transaction.commit();
        } catch (Exception e) {
            // Si ocurre un error, revierte la transacción.
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            // Registra el error en consola.
            System.out.println("Error al guardar restaurante en persistencia: " + e);
            // Lanza la excepción de persistencia.
            throw new PersistenciaException("Error al guardar el restaurante", e);
        } finally {
            // Asegura el cierre del EntityManager en el bloque final.
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
    /**
     * Guarda un objeto Restaurante en la base de datos. Inicia una transacción para persistir el restaurante y, en caso de error, revierte los cambios.
     * 
     * @return restaurante El objeto Restaurante que se desea guardar en la base de datos.
     * @throws PersistenciaException Si ocurre un error durante el proceso de persistencia, como problemas de conexión a la base de datos o fallos en la transacción.
     */
    @Override
    public Restaurante buscarRestaurante() throws PersistenciaException {

        // Declaración de objetos para manejar la transacción y el EntityManager.
        EntityManager entityManager = null;
        Restaurante restaurante = null;
        

        try {
            // Obtiene el EntityManager para interactuar con la base de datos.
            entityManager = ConexionBD.getEntityManager();

            // Persiste la entidad Restaurante.
            String jpql = "SELECT r FROM Restaurante r";
            TypedQuery<Restaurante> query = entityManager.createQuery(jpql, Restaurante.class);

            restaurante = query.getSingleResult();
            
        } catch (Exception e) {
        } finally {
            // Asegura el cierre del EntityManager en el bloque final.
            if (entityManager != null) {
                entityManager.close();
            }
        }
        
        return restaurante;
        
    }
}
