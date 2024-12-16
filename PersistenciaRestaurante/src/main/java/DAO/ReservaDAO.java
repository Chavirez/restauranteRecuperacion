/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entidades.Cliente;
import Entidades.Mesa;
import Entidades.Reserva;
import Excepcion.PersistenciaException;
import InterfacesDAO.IReservaDAO;
import conexion.ConexionBD;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

/**
 * Implementación de la interfaz IReservaDAO para interactuar con la base de datos
 * en relación con la entidad Reserva.
 * Esta clase proporciona el método para guardar una reserva en la base de datos.
 * 
 * @author santi
 */
public class ReservaDAO implements IReservaDAO {

    /**
     * Constructor de la clase ReservaDAO.
     * Inicializa la conexión a la base de datos a través de ConexionBD.
     */
    public ReservaDAO() {
    }
    
    /**
     * Guarda una entidad Reserva en la base de datos.
     * Este método utiliza el EntityManager para persistir la entidad Reserva.
     * Si ocurre algún error durante la persistencia, la transacción se revierte.
     * 
     * @param reserva La entidad Reserva que se desea guardar en la base de datos.
     * @throws PersistenciaException Si ocurre un error durante el proceso de persistencia.
     */
    @Override
    public void guardarReserva(Reserva reserva) throws PersistenciaException {

        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            // Obtiene el EntityManager para interactuar con la base de datos
            entityManager = ConexionBD.getEntityManager();
            // Inicia la transacción
            transaction = entityManager.getTransaction();
            transaction.begin();

            // Persiste la entidad reserva en la base de datos
            entityManager.persist(reserva);

            // Confirma la transacción
            transaction.commit();
        } catch (Exception e) {
            // Si ocurre un error, revierte la transacción
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("Error al guardar reserva en persistencia: " + e);
        } finally {
            // Cierra el EntityManager para liberar recursos
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
    
    /**
     * Elimina una entidad Reserva en la base de datos.
     * 
     * @param reserva La entidad Reserva que se desea eliminar en la base de datos.
     * @throws PersistenciaException Si ocurre un error durante el proceso de persistencia.
     */
    @Override
    public void eliminarReserva(Reserva reserva) throws PersistenciaException {

        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            // Obtiene el EntityManager para interactuar con la base de datos
            entityManager = ConexionBD.getEntityManager();
            // Inicia la transacción
            transaction = entityManager.getTransaction();
            transaction.begin();

            Reserva rAEliminar = entityManager.find(Reserva.class, reserva.getId());
            if (rAEliminar != null) {
                // Ahora la entidad es "managed" y puede ser eliminada
                entityManager.remove(rAEliminar);
            }
            
            // Confirma la transacción
            transaction.commit();
        } catch (Exception e) {
            // Si ocurre un error, revierte la transacción
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("Error al eliminar reserva en persistencia: " + e);
        } finally {
            // Cierra el EntityManager para liberar recursos
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
    
    /**
     * Busca todas las reservas por mesa
     * 
     * @param mesa la mesa en cuesttión
     * @return Una lista con todas las reservas con ese mesa
     * @throws PersistenciaException Si ocurre un error al realizar la consulta.
     */
    @Override
    public List<Reserva> buscarReservaPorMesa(Mesa mesa) throws PersistenciaException {

        EntityManager entityManager = null;

        List<Reserva> listaReservas = new ArrayList<>();
        
        try {
            entityManager = ConexionBD.getEntityManager();

            String jpql = "SELECT r FROM Reserva r " +
                          "WHERE r.mesa = :codigo";
            
            TypedQuery<Reserva> query = entityManager.createQuery(jpql, Reserva.class);

            query.setParameter("codigo", mesa);

            listaReservas = query.getResultList();


        } catch (Exception e) {

            System.out.println("Error al buscar las reservas en persistencia" + e);
            
        } finally {
            if (entityManager != null) {
                entityManager.close(); // Cierra el EntityManager.
            }
        }
        
        if(listaReservas == null || listaReservas.isEmpty())
            return null;
        
        return listaReservas;
        
    }
    
    /**
     * Busca todas las reservas por cliente
     * 
     * @param cliente el cliente en cuesttión
     * @return Una lista con todas las reservas con ese cliente
     * @throws PersistenciaException Si ocurre un error al realizar la consulta.
     */
    @Override
    public List<Reserva> buscarReservaPorCliente(Cliente cliente) throws PersistenciaException {

        EntityManager entityManager = null;

        List<Reserva> listaReservas = new ArrayList<>();
        
        try {
            entityManager = ConexionBD.getEntityManager();

            String jpql = "SELECT r FROM Reserva r " +
                          "WHERE r.cliente = :codigo";
            
            TypedQuery<Reserva> query = entityManager.createQuery(jpql, Reserva.class);

            query.setParameter("codigo", cliente);

            listaReservas = query.getResultList();


        } catch (Exception e) {

            System.out.println("Error al buscar las reservas en persistencia" + e);
            
        } finally {
            if (entityManager != null) {
                entityManager.close(); // Cierra el EntityManager.
            }
        }
        
        if(listaReservas == null || listaReservas.isEmpty())
            return null;
        
        return listaReservas;
        
    }
    
    
    /**
     * Busca todas las reservas por seccion
     * 
     * @param seccion la sección en cuestión
     * @param desde
     * @param hasta
     * @return Una lista con todas las reservas con esa seccion, en la fecha
     * @throws PersistenciaException Si ocurre un error al realizar la consulta.
     */
    @Override
    public List<Reserva> buscarReservaPorSeccion(String seccion, Calendar desde, Calendar hasta) throws PersistenciaException {

        EntityManager entityManager = null;

        List<Reserva> listaReservas = new ArrayList<>();
        
        try {
            entityManager = ConexionBD.getEntityManager();

            String jpql = "SELECT r FROM Reserva r " +
                          "WHERE r.seccion = :codigo"
                        + "AND r.fechaHora BETWEEN :desde AND :hasta";
            
            TypedQuery<Reserva> query = entityManager.createQuery(jpql, Reserva.class);

            query.setParameter("codigo", seccion);
            query.setParameter("desde", desde);
            query.setParameter("hasta", hasta);
            
            listaReservas = query.getResultList();


        } catch (Exception e) {

            System.out.println("Error al buscar las reservas en persistencia" + e);
            
        } finally {
            if (entityManager != null) {
                entityManager.close(); // Cierra el EntityManager.
            }
        }
        
        if(listaReservas == null || listaReservas.isEmpty())
            return null;
        
        return listaReservas;
        
    }
    
    /**
     * Busca todas las reservas por tipo de mesa
     * 
     * @param cantidadMinima la cantidadMin en cuestión
     * @param cantidadMaxima la cantidadMax en cuestión
     * @param desde desde
     * @param hasta hasta
     * @return Una lista con todas las reservas con ese tipo, en la fecha
     * @throws PersistenciaException Si ocurre un error al realizar la consulta.
     */
    @Override
    public List<Reserva> buscarReservaPorTipo(int cantidadMinima, int cantidadMaxima, Calendar desde, Calendar hasta) throws PersistenciaException {

        EntityManager entityManager = null;

        List<Reserva> listaReservas = new ArrayList<>();
        
        try {
            entityManager = ConexionBD.getEntityManager();

            String jpql = "SELECT r FROM Reserva r " +
                          "WHERE r.numpersonas <= :cantidadMinima AND r.numPersonas >= :cantidadMaxima"
                        + "AND r.fechaHora BETWEEN :desde AND :hasta";
            
            TypedQuery<Reserva> query = entityManager.createQuery(jpql, Reserva.class);

            query.setParameter("cantidadMinima", cantidadMinima);
            query.setParameter("cantidadMaxima", cantidadMaxima);
            query.setParameter("desde", desde);
            query.setParameter("hasta", hasta);

            listaReservas = query.getResultList();


        } catch (Exception e) {

            System.out.println("Error al buscar las reservas en persistencia" + e);
            
        } finally {
            if (entityManager != null) {
                entityManager.close(); // Cierra el EntityManager.
            }
        }
        
        if(listaReservas == null || listaReservas.isEmpty())
            return null;
        
        return listaReservas;
        
    }
    
    
}
