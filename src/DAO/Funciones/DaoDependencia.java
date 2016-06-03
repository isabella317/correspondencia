/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Funciones;

import static Controlador.controladorInicioSesion.listaPermisos;
import DAO.Funciones.exceptions.IllegalOrphanException;
import DAO.Funciones.exceptions.NonexistentEntityException;
import DAO.Tablas.Dependencia;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import DAO.Tablas.Funcionario;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ISABELLA
 */
public class DaoDependencia implements Serializable {

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("correspondenciaPU");

    public DaoDependencia(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Dependencia dependencia) {
        if (dependencia.getFuncionarioCollection() == null) {
            dependencia.setFuncionarioCollection(new ArrayList<Funcionario>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Funcionario> attachedFuncionarioCollection = new ArrayList<Funcionario>();
            for (Funcionario funcionarioCollectionFuncionarioToAttach : dependencia.getFuncionarioCollection()) {
                funcionarioCollectionFuncionarioToAttach = em.getReference(funcionarioCollectionFuncionarioToAttach.getClass(), funcionarioCollectionFuncionarioToAttach.getIdentificacion());
                attachedFuncionarioCollection.add(funcionarioCollectionFuncionarioToAttach);
            }
            dependencia.setFuncionarioCollection(attachedFuncionarioCollection);
            em.persist(dependencia);
            for (Funcionario funcionarioCollectionFuncionario : dependencia.getFuncionarioCollection()) {
                Dependencia oldIdDependenciaOfFuncionarioCollectionFuncionario = funcionarioCollectionFuncionario.getIdDependencia();
                funcionarioCollectionFuncionario.setIdDependencia(dependencia);
                funcionarioCollectionFuncionario = em.merge(funcionarioCollectionFuncionario);
                if (oldIdDependenciaOfFuncionarioCollectionFuncionario != null) {
                    oldIdDependenciaOfFuncionarioCollectionFuncionario.getFuncionarioCollection().remove(funcionarioCollectionFuncionario);
                    oldIdDependenciaOfFuncionarioCollectionFuncionario = em.merge(oldIdDependenciaOfFuncionarioCollectionFuncionario);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Dependencia dependencia) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Dependencia persistentDependencia = em.find(Dependencia.class, dependencia.getId());
            Collection<Funcionario> funcionarioCollectionOld = persistentDependencia.getFuncionarioCollection();
            Collection<Funcionario> funcionarioCollectionNew = dependencia.getFuncionarioCollection();
            List<String> illegalOrphanMessages = null;
            for (Funcionario funcionarioCollectionOldFuncionario : funcionarioCollectionOld) {
                if (!funcionarioCollectionNew.contains(funcionarioCollectionOldFuncionario)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Funcionario " + funcionarioCollectionOldFuncionario + " since its idDependencia field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Funcionario> attachedFuncionarioCollectionNew = new ArrayList<Funcionario>();
            for (Funcionario funcionarioCollectionNewFuncionarioToAttach : funcionarioCollectionNew) {
                funcionarioCollectionNewFuncionarioToAttach = em.getReference(funcionarioCollectionNewFuncionarioToAttach.getClass(), funcionarioCollectionNewFuncionarioToAttach.getIdentificacion());
                attachedFuncionarioCollectionNew.add(funcionarioCollectionNewFuncionarioToAttach);
            }
            funcionarioCollectionNew = attachedFuncionarioCollectionNew;
            dependencia.setFuncionarioCollection(funcionarioCollectionNew);
            dependencia = em.merge(dependencia);
            for (Funcionario funcionarioCollectionNewFuncionario : funcionarioCollectionNew) {
                if (!funcionarioCollectionOld.contains(funcionarioCollectionNewFuncionario)) {
                    Dependencia oldIdDependenciaOfFuncionarioCollectionNewFuncionario = funcionarioCollectionNewFuncionario.getIdDependencia();
                    funcionarioCollectionNewFuncionario.setIdDependencia(dependencia);
                    funcionarioCollectionNewFuncionario = em.merge(funcionarioCollectionNewFuncionario);
                    if (oldIdDependenciaOfFuncionarioCollectionNewFuncionario != null && !oldIdDependenciaOfFuncionarioCollectionNewFuncionario.equals(dependencia)) {
                        oldIdDependenciaOfFuncionarioCollectionNewFuncionario.getFuncionarioCollection().remove(funcionarioCollectionNewFuncionario);
                        oldIdDependenciaOfFuncionarioCollectionNewFuncionario = em.merge(oldIdDependenciaOfFuncionarioCollectionNewFuncionario);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = dependencia.getId();
                if (findDependencia(id) == null) {
                    throw new NonexistentEntityException("The dependencia with id " + id + " no longer exists.");
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
            Dependencia dependencia;
            try {
                dependencia = em.getReference(Dependencia.class, id);
                dependencia.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The dependencia with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Funcionario> funcionarioCollectionOrphanCheck = dependencia.getFuncionarioCollection();
            for (Funcionario funcionarioCollectionOrphanCheckFuncionario : funcionarioCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Dependencia (" + dependencia + ") cannot be destroyed since the Funcionario " + funcionarioCollectionOrphanCheckFuncionario + " in its funcionarioCollection field has a non-nullable idDependencia field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(dependencia);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Dependencia> findDependenciaEntities() {
        return findDependenciaEntities(true, -1, -1);
    }

    public List<Dependencia> findDependenciaEntities(int maxResults, int firstResult) {
        return findDependenciaEntities(false, maxResults, firstResult);
    }

    private List<Dependencia> findDependenciaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Dependencia.class));
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

    public Dependencia findDependencia(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Dependencia.class, id);
        } finally {
            em.close();
        }
    }


    public int getDependenciaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Dependencia> rt = cq.from(Dependencia.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
