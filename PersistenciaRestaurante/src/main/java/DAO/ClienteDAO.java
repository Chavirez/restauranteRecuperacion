/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entidades.Cliente;
import Entidades.Mesa;
import Excepcion.PersistenciaException;
import InterfacesDAO.IClienteDAO;
import conexion.ConexionBD;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author santi
 */
public class ClienteDAO implements IClienteDAO{

    
    /**
     * Constructor que inicializa el EntityManager usando la conexión definida en la clase ConexionBD.
     */
    public ClienteDAO() {

    }
    
    @Override
    public void guardarCliente(Cliente cliente) throws PersistenciaException {

        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            entityManager = ConexionBD.getEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            entityManager.persist(cliente); // Persiste la entidad Mesa.

            transaction.commit(); // Confirma la transacción.
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback(); // Revierte la transacción en caso de error.
            }
            System.out.println("Error al guardar cliente en persistencia" + e);
        } finally {
            if (entityManager != null) {
                entityManager.close(); // Cierra el EntityManager.
            }
        }
    }
    
    @Override
    public Cliente buscarClientePorTelefono(String telefono) throws PersistenciaException {

        EntityManager entityManager = null;
        Cliente cliente = null;

        try {
            entityManager = ConexionBD.getEntityManager();

            String query = "SELECT c FROM Cliente c WHERE c.numTelefono = :numTelefono";

            cliente = entityManager.createQuery(query, Cliente.class)
                    .setParameter("numTelefono", telefono)
                    .getSingleResult();
            

        } catch (Exception e) {

        } finally {
            if (entityManager != null) {
                entityManager.close(); // Cierra el EntityManager.
            }
        }
        
        return cliente;
        
    }
    
    
}
