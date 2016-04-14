/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Funciones;

import static Controlador.ControladorInicioSesion.listaPermisos;
import DAO.Funciones.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import DAO.Tablas.Funcion;
import DAO.Tablas.Funcionrol;
import DAO.Tablas.Rol;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ISABELLA
 */
public class DaoFuncionrol implements Serializable {

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("correspondenciaPU");

    public DaoFuncionrol(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Funcionrol funcionrol) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Funcion idFuncion = funcionrol.getIdFuncion();
            if (idFuncion != null) {
                idFuncion = em.getReference(idFuncion.getClass(), idFuncion.getId());
                funcionrol.setIdFuncion(idFuncion);
            }
            Rol idRol = funcionrol.getIdRol();
            if (idRol != null) {
                idRol = em.getReference(idRol.getClass(), idRol.getId());
                funcionrol.setIdRol(idRol);
            }
            em.persist(funcionrol);
            if (idFuncion != null) {
                idFuncion.getFuncionrolCollection().add(funcionrol);
                idFuncion = em.merge(idFuncion);
            }
            if (idRol != null) {
                idRol.getFuncionrolCollection().add(funcionrol);
                idRol = em.merge(idRol);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Funcionrol funcionrol) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Funcionrol persistentFuncionrol = em.find(Funcionrol.class, funcionrol.getId());
            Funcion idFuncionOld = persistentFuncionrol.getIdFuncion();
            Funcion idFuncionNew = funcionrol.getIdFuncion();
            Rol idRolOld = persistentFuncionrol.getIdRol();
            Rol idRolNew = funcionrol.getIdRol();
            if (idFuncionNew != null) {
                idFuncionNew = em.getReference(idFuncionNew.getClass(), idFuncionNew.getId());
                funcionrol.setIdFuncion(idFuncionNew);
            }
            if (idRolNew != null) {
                idRolNew = em.getReference(idRolNew.getClass(), idRolNew.getId());
                funcionrol.setIdRol(idRolNew);
            }
            funcionrol = em.merge(funcionrol);
            if (idFuncionOld != null && !idFuncionOld.equals(idFuncionNew)) {
                idFuncionOld.getFuncionrolCollection().remove(funcionrol);
                idFuncionOld = em.merge(idFuncionOld);
            }
            if (idFuncionNew != null && !idFuncionNew.equals(idFuncionOld)) {
                idFuncionNew.getFuncionrolCollection().add(funcionrol);
                idFuncionNew = em.merge(idFuncionNew);
            }
            if (idRolOld != null && !idRolOld.equals(idRolNew)) {
                idRolOld.getFuncionrolCollection().remove(funcionrol);
                idRolOld = em.merge(idRolOld);
            }
            if (idRolNew != null && !idRolNew.equals(idRolOld)) {
                idRolNew.getFuncionrolCollection().add(funcionrol);
                idRolNew = em.merge(idRolNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = funcionrol.getId();
                if (findFuncionrol(id) == null) {
                    throw new NonexistentEntityException("The funcionrol with id " + id + " no longer exists.");
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
            Funcionrol funcionrol;
            try {
                funcionrol = em.getReference(Funcionrol.class, id);
                funcionrol.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The funcionrol with id " + id + " no longer exists.", enfe);
            }
            Funcion idFuncion = funcionrol.getIdFuncion();
            if (idFuncion != null) {
                idFuncion.getFuncionrolCollection().remove(funcionrol);
                idFuncion = em.merge(idFuncion);
            }
            Rol idRol = funcionrol.getIdRol();
            if (idRol != null) {
                idRol.getFuncionrolCollection().remove(funcionrol);
                idRol = em.merge(idRol);
            }
            em.remove(funcionrol);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Funcionrol> findFuncionrolEntities() {
        return findFuncionrolEntities(true, -1, -1);
    }

    public List<Funcionrol> findFuncionrolEntities(int maxResults, int firstResult) {
        return findFuncionrolEntities(false, maxResults, firstResult);
    }

    private List<Funcionrol> findFuncionrolEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Funcionrol.class));
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

    public Funcionrol findFuncionrol(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Funcionrol.class, id);
        } finally {
            em.close();
        }
    }

    public void findFuncionrolXIdRol(int id_rol) {
        EntityManager em = factory.createEntityManager();
        List<Object> result = em.createNativeQuery("select * from funcionrol where id_rol=" + id_rol).getResultList();

        Iterator itr = result.iterator();
        while (itr.hasNext()) {
            Object[] obj = (Object[]) itr.next();
            int idfuncion = Integer.parseInt(String.valueOf(obj[1]));
            System.out.println(idfuncion);
            listaPermisos.add(idfuncion);

        }
    }

    public int getFuncionrolCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Funcionrol> rt = cq.from(Funcionrol.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
