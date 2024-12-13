/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entidades.Mesa;
import Excepcion.PersistenciaException;
import InterfacesDAO.IMesaDAO;
import conexion.ConexionBD;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

/**
 * Clase DAO para gestionar la persistencia de las entidades Mesa en la base de datos.
 * Implementa la interfaz IMesaDAO para definir las operaciones CRUD sobre las mesas.
 * 
 * @author santi
 */
public class MesaDAO implements IMesaDAO {


    
    /**
     * Constructor por defecto
     */
    public MesaDAO() {

    }
    
    /**
     * Guarda una nueva mesa en la base de datos.
     * 
     * @param mesa La entidad Mesa que se desea persistir.
     * @throws PersistenciaException Si ocurre un error al guardar la mesa.
     */
    @Override
    public void guardarMesa(Mesa mesa) throws PersistenciaException {

        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            entityManager = ConexionBD.getEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            entityManager.persist(mesa); // Persiste la entidad Mesa.

            transaction.commit(); // Confirma la transacción.
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback(); // Revierte la transacción en caso de error.
            }
            System.out.println("Error al guardar mesa en persistencia" + e);
        } finally {
            if (entityManager != null) {
                entityManager.close(); // Cierra el EntityManager.
            }
        }
    }
    
    /**
     * Busca todas las mesas almacenadas en la base de datos.
     * 
     * @return Una lista con todas las mesas registradas.
     * @throws PersistenciaException Si ocurre un error al realizar la consulta.
     */
    @Override
    public List<Mesa> buscarTodasLasMesas() throws PersistenciaException {

        EntityManager entityManager = null;

        List<Mesa> listaMesas = new ArrayList<>();
        
        try {
            entityManager = ConexionBD.getEntityManager();

            // Consulta todas las entidades Mesa en la base de datos.
            listaMesas = entityManager.createQuery("SELECT m FROM Mesa m", Mesa.class).getResultList();

        } catch (Exception e) {

            System.out.println("Error al buscar todas las mesas en persistencia" + e);
            
        } finally {
            if (entityManager != null) {
                entityManager.close(); // Cierra el EntityManager.
            }
        }
        
        return listaMesas;
        
    }
    
    /**
     * Elimina una mesa específica de la base de datos.
     * 
     * @param mesa La entidad Mesa que se desea eliminar.
     * @throws PersistenciaException Si ocurre un error al eliminar la mesa.
     */
    @Override
    public void eliminarMesa(Mesa mesa) throws PersistenciaException {
    
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            entityManager = ConexionBD.getEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            
            Mesa mesaReal = entityManager.find(Mesa.class, mesa.getCodigo());

            entityManager.remove(mesaReal); // Elimina la entidad Mesa.

            transaction.commit(); // Confirma la transacción.
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback(); // Revierte la transacción en caso de error.
            }
            System.out.println("Error al eliminar la mesa" + mesa.getCodigo() + " en persistencia" + e);
        } finally {
            if (entityManager != null) {
                entityManager.close(); // Cierra el EntityManager.
            }
        }
 
    }
    
    /**
     * Busca las mesas disponibles en un restaurante según su capacidad, ubicación y el tiempo desde la última reserva.
     * 
     * Este método realiza una consulta a la base de datos utilizando JPA para encontrar todas las mesas que cumplen con 
     * las condiciones de capacidad y ubicación proporcionadas, y que no han sido reservadas en las últimas 5 horas.
     * Se utiliza una subconsulta para verificar que no existan reservas en el rango de tiempo especificado.
     *
     * @param seccion La ubicación de las mesas que se está buscando (por ejemplo, "Terraza", "Ventana").
     * @param capacidad La capacidad mínima de las mesas que se desea buscar (por ejemplo, mesas para 4 personas o más).
     * @param fechaHora La fecha
     * @return Una lista de objetos `Mesa` que cumplen con los criterios de disponibilidad. Si no se encuentran mesas
     *         disponibles, se devuelve una lista vacía.
     * @throws PersistenciaException
     */
    @Override
    public List<Mesa> buscarMesasDisponibles(String seccion, int capacidad, Calendar fechaHora) throws PersistenciaException{
    
        EntityManager entityManager = null;
        List<Mesa> mesasDisponibles = null;

        try {
            entityManager = ConexionBD.getEntityManager();

            String jpql = "SELECT m FROM Mesa m " +
                          "WHERE m.capacidad >= :capacidad " +
                          "AND m.ubicacion = :ubicacion " +
                          "AND m.codigo NOT IN (" +
                          "    SELECT r.mesa.codigo FROM Reserva r " +
                          "    WHERE r.fechaHora BETWEEN :inicioRango AND :finRango" +
                          ")";
            
            
            

            Calendar ahora = Calendar.getInstance();            
            ahora.setTimeInMillis(fechaHora.toInstant().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
            
            Calendar cincoHorasDespues = fechaHora;
            cincoHorasDespues.add(Calendar.HOUR, 5);    
            
            TypedQuery<Mesa> query = entityManager.createQuery(jpql, Mesa.class);
            query.setParameter("capacidad", capacidad);
            query.setParameter("ubicacion", seccion);
            query.setParameter("inicioRango", ahora);
            query.setParameter("finRango", cincoHorasDespues);

            mesasDisponibles = query.getResultList();


        } catch (Exception e) {

            System.out.println("Error al buscar mesas disponibles "+ " en persistencia" + e);
        } finally {
            if (entityManager != null) {
                entityManager.close(); // Cierra el EntityManager.
            }
        }
        
        return mesasDisponibles;
        
    }
    
}
