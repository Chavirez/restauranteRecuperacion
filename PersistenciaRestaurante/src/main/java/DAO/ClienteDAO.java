/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entidades.Cliente;
import Excepcion.PersistenciaException;
import InterfacesDAO.IClienteDAO;
import conexion.ConexionBD;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * La clase ClienteDAO implementa la interfaz IClienteDAO y proporciona la implementación de los métodos
 * necesarios para interactuar con la base de datos relacionados con la entidad Cliente.
 * Contiene métodos para guardar un cliente y buscar un cliente por su número de teléfono.
 * 
 * @author santi
 */
public class ClienteDAO implements IClienteDAO {

    /**
     * Constructor vacío de la clase ClienteDAO.
     * Inicializa el EntityManager mediante la clase ConexionBD para interactuar con la base de datos.
     */
    public ClienteDAO() {
    }
    
    /**
     * Guarda un objeto Cliente en la base de datos.
     * Inicia una transacción, persiste el objeto Cliente y confirma la transacción.
     * Si ocurre un error durante el proceso, revierte la transacción.
     * 
     * @param cliente El objeto Cliente que se desea guardar en la base de datos.
     * @throws PersistenciaException Si ocurre un error al guardar el cliente en la base de datos.
     */
    @Override
    public void guardarCliente(Cliente cliente) throws PersistenciaException {

        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            entityManager = ConexionBD.getEntityManager();  // Obtiene el EntityManager para la conexión.
            transaction = entityManager.getTransaction();   // Inicia una nueva transacción.
            transaction.begin();                            // Comienza la transacción.

            entityManager.persist(cliente); // Persiste el objeto Cliente.

            transaction.commit(); // Confirma la transacción si no hay errores.
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback(); // Revierte la transacción en caso de error.
            }
            System.out.println("Error al guardar cliente en persistencia: " + e);
        } finally {
            if (entityManager != null) {
                entityManager.close(); // Cierra el EntityManager después de realizar la operación.
            }
        }
    }
    
    /**
     * Busca un cliente en la base de datos utilizando su número de teléfono.
     * Si se encuentra un cliente con el número de teléfono proporcionado, lo devuelve.
     * Si no se encuentra ningún cliente o ocurre un error, devuelve null.
     * 
     * @param telefono El número de teléfono del cliente que se desea buscar.
     * @return Un objeto Cliente que coincide con el número de teléfono proporcionado, o null si no se encuentra.
     * @throws PersistenciaException Si ocurre un error al realizar la búsqueda.
     */
    @Override
    public Cliente buscarClientePorTelefono(String telefono) throws PersistenciaException {

        EntityManager entityManager = null;
        Cliente cliente = null;

        try {
            entityManager = ConexionBD.getEntityManager();  // Obtiene el EntityManager para la conexión.

            // Crea una consulta JPQL para buscar un cliente por su número de teléfono.
            String query = "SELECT c FROM Cliente c WHERE c.numTelefono = :numTelefono";

            // Ejecuta la consulta con el número de teléfono como parámetro y obtiene el resultado único.
            cliente = entityManager.createQuery(query, Cliente.class)
                    .setParameter("numTelefono", telefono)
                    .getSingleResult();
            
        } catch (Exception e) {
            // Manejo de excepciones (puede incluir logging o tratamiento de errores adicionales).
        } finally {
            if (entityManager != null) {
                entityManager.close(); // Cierra el EntityManager después de realizar la operación.
            }
        }

        return cliente; // Retorna el cliente encontrado o null si no se encuentra.
    }
}
