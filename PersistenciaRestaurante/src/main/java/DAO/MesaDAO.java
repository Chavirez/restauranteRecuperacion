/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entidades.Mesa;
import Excepcion.PersistenciaException;
import conexion.ConexionBD;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author santi
 */
public class MesaDAO {

    private EntityManager entityManager;    
    
    public MesaDAO() {
        this.entityManager = ConexionBD.getEntityManager();
    }
    
    public void guardarMesa(Mesa mesa) throws PersistenciaException{

        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        
        
        try {
            entityManager = ConexionBD.getEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            entityManager.persist(mesa);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("Error al guardar mesa en persistencia" + e);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
    
    public List<Mesa> buscarTodasLasMesas() throws PersistenciaException{

        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        List<Mesa> listaMesas = new ArrayList<>();
        
        
        try {
            entityManager = ConexionBD.getEntityManager();

            listaMesas = entityManager.createQuery("SELECT m FROM Mesa m", Mesa.class).getResultList();

        } catch (Exception e) {

            System.out.println("Error al buscar todas las mesas en persistencia" + e);
            
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        
        return listaMesas;
        
    }
    
    
    
}
