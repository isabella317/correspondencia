/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Funciones;

import DAO.Funciones.exceptions.IllegalOrphanException;
import DAO.Funciones.exceptions.NonexistentEntityException;
import DAO.Tablas.Funcion;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import DAO.Tablas.Funcionrol;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ISABELLA
 */
public class DaoFuncion implements Serializable {

    public DaoFuncion(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Funcion funcion) {
        if (funcion.getFuncionrolCollection() == null) {
            funcion.setFuncionrolCollection(new ArrayList<Funcionrol>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Funcionrol> attachedFuncionrolCollection = new ArrayList<Funcionrol>();
            for (Funcionrol funcionrolCollectionFuncionrolToAttach : funcion.getFuncionrolCollection()) {
                funcionrolCollectionFuncionrolToAttach = em.getReference(funcionrolCollectionFuncionrolToAttach.getClass(), funcionrolCollectionFuncionrolToAttach.getId());
                attachedFuncionrolCollection.add(funcionrolCollectionFuncionrolToAttach);
            }
            funcion.setFuncionrolCollection(attachedFuncionrolCollection);
            em.persist(funcion);
            for (Funcionrol funcionrolCollectionFuncionrol : funcion.getFuncionrolCollection()) {
                Funcion oldIdFuncionOfFuncionrolCollectionFuncionrol = funcionrolCollectionFuncionrol.getIdFuncion();
                funcionrolCollectionFuncionrol.setIdFuncion(funcion);
                funcionrolCollectionFuncionrol = em.merge(funcionrolCollectionFuncionrol);
                if (oldIdFuncionOfFuncionrolCollectionFuncionrol != null) {
                    oldIdFuncionOfFuncionrolCollectionFuncionrol.getFuncionrolCollection().remove(funcionrolCollectionFuncionrol);
                    oldIdFuncionOfFuncionrolCollectionFuncionrol = em.merge(oldIdFuncionOfFuncionrolCollectionFuncionrol);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Funcion funcion) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Funcion persistentFuncion = em.find(Funcion.class, funcion.getId());
            Collection<Funcionrol> funcionrolCollectionOld = persistentFuncion.getFuncionrolCollection();
            Collection<Funcionrol> funcionrolCollectionNew = funcion.getFuncionrolCollection();
            List<String> illegalOrphanMessages = null;
            for (Funcionrol funcionrolCollectionOldFuncionrol : funcionrolCollectionOld) {
                if (!funcionrolCollectionNew.contains(funcionrolCollectionOldFuncionrol)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Funcionrol " + funcionrolCollectionOldFuncionrol + " since its idFuncion field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Funcionrol> attachedFuncionrolCollectionNew = new ArrayList<Funcionrol>();
            for (Funcionrol funcionrolCollectionNewFuncionrolToAttach : funcionrolCollectionNew) {
                funcionrolCollectionNewFuncionrolToAttach = em.getReference(funcionrolCollectionNewFuncionrolToAttach.getClass(), funcionrolCollectionNewFuncionrolToAttach.getId());
                attachedFuncionrolCollectionNew.add(funcionrolCollectionNewFuncionrolToAttach);
            }
            funcionrolCollectionNew = attachedFuncionrolCollectionNew;
            funcion.setFuncionrolCollection(funcionrolCollectionNew);
            funcion = em.merge(funcion);
            for (Funcionrol funcionrolCollectionNewFuncionrol : funcionrolCollectionNew) {
                if (!funcionrolCollectionOld.contains(funcionrolCollectionNewFuncionrol)) {
                    Funcion oldIdFuncionOfFuncionrolCollectionNewFuncionrol = funcionrolCollectionNewFuncionrol.getIdFuncion();
                    funcionrolCollectionNewFuncionrol.setIdFuncion(funcion);
                    funcionrolCollectionNewFuncionrol = em.merge(funcionrolCollectionNewFuncionrol);
                    if (oldIdFuncionOfFuncionrolCollectionNewFuncionrol != null && !oldIdFuncionOfFuncionrolCollectionNewFuncionrol.equals(funcion)) {
                        oldIdFuncionOfFuncionrolCollectionNewFuncionrol.getFuncionrolCollection().remove(funcionrolCollectionNewFuncionrol);
                        oldIdFuncionOfFuncionrolCollectionNewFuncionrol = em.merge(oldIdFuncionOfFuncionrolCollectionNewFuncionrol);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = funcion.getId();
                if (findFuncion(id) == null) {
                    throw new NonexistentEntityException("The funcion with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Funcion funcion;
            try {
                funcion = em.getReference(Funcion.class, id);
                funcion.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The funcion with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Funcionrol> funcionrolCollectionOrphanCheck = funcion.getFuncionrolCollection();
            for (Funcionrol funcionrolCollectionOrphanCheckFuncionrol : funcionrolCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Funcion (" + funcion + ") cannot be destroyed since the Funcionrol " + funcionrolCollectionOrphanCheckFuncionrol + " in its funcionrolCollection field has a non-nullable idFuncion field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(funcion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Funcion> findFuncionEntities() {
        return findFuncionEntities(true, -1, -1);
    }

    public List<Funcion> findFuncionEntities(int maxResults, int firstResult) {
        return findFuncionEntities(false, maxResults, firstResult);
    }

    private List<Funcion> findFuncionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Funcion.class));
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

    public Funcion findFuncion(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Funcion.class, id);
        } finally {
            em.close();
        }
    }

    public int getFuncionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Funcion> rt = cq.from(Funcion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
