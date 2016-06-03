/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Funciones;

import DAO.Funciones.exceptions.NonexistentEntityException;
import DAO.Funciones.exceptions.PreexistingEntityException;
import DAO.Tablas.FuncionarioExterno;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author ISABELLA
 */
public class FuncionarioExternoJpaController implements Serializable {

    public FuncionarioExternoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(FuncionarioExterno funcionarioExterno) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(funcionarioExterno);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findFuncionarioExterno(funcionarioExterno.getIdentificacion()) != null) {
                throw new PreexistingEntityException("FuncionarioExterno " + funcionarioExterno + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(FuncionarioExterno funcionarioExterno) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            funcionarioExterno = em.merge(funcionarioExterno);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = funcionarioExterno.getIdentificacion();
                if (findFuncionarioExterno(id) == null) {
                    throw new NonexistentEntityException("The funcionarioExterno with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            FuncionarioExterno funcionarioExterno;
            try {
                funcionarioExterno = em.getReference(FuncionarioExterno.class, id);
                funcionarioExterno.getIdentificacion();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The funcionarioExterno with id " + id + " no longer exists.", enfe);
            }
            em.remove(funcionarioExterno);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<FuncionarioExterno> findFuncionarioExternoEntities() {
        return findFuncionarioExternoEntities(true, -1, -1);
    }

    public List<FuncionarioExterno> findFuncionarioExternoEntities(int maxResults, int firstResult) {
        return findFuncionarioExternoEntities(false, maxResults, firstResult);
    }

    private List<FuncionarioExterno> findFuncionarioExternoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(FuncionarioExterno.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public FuncionarioExterno findFuncionarioExterno(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(FuncionarioExterno.class, id);
        } finally {
            em.close();
        }
    }

    public int getFuncionarioExternoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<FuncionarioExterno> rt = cq.from(FuncionarioExterno.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
