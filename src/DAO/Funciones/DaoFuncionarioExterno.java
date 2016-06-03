/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Funciones;

import DAO.Funciones.exceptions.NonexistentEntityException;
import DAO.Funciones.exceptions.PreexistingEntityException;
import DAO.Tablas.Funcionario;
import DAO.Tablas.FuncionarioExterno;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
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
public class DaoFuncionarioExterno implements Serializable {

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("correspondenciaPU");

    public DaoFuncionarioExterno(EntityManagerFactory emf) {
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

    public List<FuncionarioExterno> ultimosRegistrarCorrespondencia() {

        EntityManager em = factory.createEntityManager();
        List<Object> result = em.createNativeQuery("select * from (select DISTINCT ON(identificacion) identificacion,nombre,apellido,lugar,direccion,consecutivo_r FROM funcionario_externo JOIN c_recibida ON funcionario_externo.identificacion=c_recibida.id_funcionario_externo limit 10 )as foo order by consecutivo_r desc").getResultList();
        List<FuncionarioExterno> listaFuncionario = new ArrayList<FuncionarioExterno>();

        Iterator itr = result.iterator();
        while (itr.hasNext()) {
            Object[] obj = (Object[]) itr.next();
            String identificacion = String.valueOf(obj[0]);
            String nombre = String.valueOf(obj[1]);
            String apellido = String.valueOf(obj[2]);
            String lugar = String.valueOf(obj[3]);
            String direccion = String.valueOf(obj[4]);

            FuncionarioExterno f = new FuncionarioExterno();
            f.setIdentificacion(identificacion);
            f.setNombre(nombre);
            f.setApellido(apellido);
            f.setLugar(lugar);
            f.setDireccion(direccion);

            listaFuncionario.add(f);
        }

        return listaFuncionario;
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
