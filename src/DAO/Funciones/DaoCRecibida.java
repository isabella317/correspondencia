/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Funciones;

import DAO.Funciones.exceptions.NonexistentEntityException;
import DAO.Tablas.CRecibida;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author ISABELLA
 */
public class DaoCRecibida implements Serializable {

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("correspondenciaPU");

    public DaoCRecibida(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CRecibida CRecibida) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(CRecibida);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public int getUltimoRegistro() {
        int valor = 0;

        EntityManager em = factory.createEntityManager();
        try {
            Object result = em.createNativeQuery("SELECT consecutivo_r FROM c_recibida ORDER BY consecutivo_r desc limit 1").getSingleResult();

            valor = Integer.parseInt(result.toString());
        } catch (javax.persistence.NoResultException ex) {
            valor = 0;

        }
        return valor;

    }

    public void edit(CRecibida CRecibida) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CRecibida = em.merge(CRecibida);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = CRecibida.getConsecutivoR();
                if (findCRecibida(id) == null) {
                    throw new NonexistentEntityException("The cRecibida with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CRecibida CRecibida;
            try {
                CRecibida = em.getReference(CRecibida.class, id);
                CRecibida.getConsecutivoR();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The CRecibida with id " + id + " no longer exists.", enfe);
            }
            em.remove(CRecibida);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CRecibida> findCRecibidaEntities() {
        return findCRecibidaEntities(true, -1, -1);
    }

    public List<CRecibida> findCRecibidaEntities(int maxResults, int firstResult) {
        return findCRecibidaEntities(false, maxResults, firstResult);
    }

    private List<CRecibida> findCRecibidaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CRecibida.class));
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

    public CRecibida findCRecibida(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CRecibida.class, id);
        } finally {
            em.close();
        }
    }

    public int getCRecibidaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CRecibida> rt = cq.from(CRecibida.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
