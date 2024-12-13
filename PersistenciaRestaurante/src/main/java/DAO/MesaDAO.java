/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entidades.Mesa;
import Excepcion.PersistenciaException;
import InterfacesDAO.IMesaDAO;
import conexion.ConexionBD;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

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
    
}
