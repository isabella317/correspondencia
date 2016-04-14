/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Funciones;

import DAO.Funciones.exceptions.IllegalOrphanException;
import DAO.Funciones.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import DAO.Tablas.Usuario;
import java.util.ArrayList;
import java.util.Collection;
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
public class DaoRol implements Serializable {

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("correspondenciaPU");

    public DaoRol(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Rol rol) {
        if (rol.getUsuarioCollection() == null) {
            rol.setUsuarioCollection(new ArrayList<Usuario>());
        }
        if (rol.getFuncionrolCollection() == null) {
            rol.setFuncionrolCollection(new ArrayList<Funcionrol>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Usuario> attachedUsuarioCollection = new ArrayList<Usuario>();
            for (Usuario usuarioCollectionUsuarioToAttach : rol.getUsuarioCollection()) {
                usuarioCollectionUsuarioToAttach = em.getReference(usuarioCollectionUsuarioToAttach.getClass(), usuarioCollectionUsuarioToAttach.getIdusuario());
                attachedUsuarioCollection.add(usuarioCollectionUsuarioToAttach);
            }
            rol.setUsuarioCollection(attachedUsuarioCollection);
            Collection<Funcionrol> attachedFuncionrolCollection = new ArrayList<Funcionrol>();
            for (Funcionrol funcionrolCollectionFuncionrolToAttach : rol.getFuncionrolCollection()) {
                funcionrolCollectionFuncionrolToAttach = em.getReference(funcionrolCollectionFuncionrolToAttach.getClass(), funcionrolCollectionFuncionrolToAttach.getId());
                attachedFuncionrolCollection.add(funcionrolCollectionFuncionrolToAttach);
            }
            rol.setFuncionrolCollection(attachedFuncionrolCollection);
            em.persist(rol);
            for (Usuario usuarioCollectionUsuario : rol.getUsuarioCollection()) {
                Rol oldIdRolOfUsuarioCollectionUsuario = usuarioCollectionUsuario.getIdRol();
                usuarioCollectionUsuario.setIdRol(rol);
                usuarioCollectionUsuario = em.merge(usuarioCollectionUsuario);
                if (oldIdRolOfUsuarioCollectionUsuario != null) {
                    oldIdRolOfUsuarioCollectionUsuario.getUsuarioCollection().remove(usuarioCollectionUsuario);
                    oldIdRolOfUsuarioCollectionUsuario = em.merge(oldIdRolOfUsuarioCollectionUsuario);
                }
            }
            for (Funcionrol funcionrolCollectionFuncionrol : rol.getFuncionrolCollection()) {
                Rol oldIdRolOfFuncionrolCollectionFuncionrol = funcionrolCollectionFuncionrol.getIdRol();
                funcionrolCollectionFuncionrol.setIdRol(rol);
                funcionrolCollectionFuncionrol = em.merge(funcionrolCollectionFuncionrol);
                if (oldIdRolOfFuncionrolCollectionFuncionrol != null) {
                    oldIdRolOfFuncionrolCollectionFuncionrol.getFuncionrolCollection().remove(funcionrolCollectionFuncionrol);
                    oldIdRolOfFuncionrolCollectionFuncionrol = em.merge(oldIdRolOfFuncionrolCollectionFuncionrol);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Rol rol) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Rol persistentRol = em.find(Rol.class, rol.getId());
            Collection<Usuario> usuarioCollectionOld = persistentRol.getUsuarioCollection();
            Collection<Usuario> usuarioCollectionNew = rol.getUsuarioCollection();
            Collection<Funcionrol> funcionrolCollectionOld = persistentRol.getFuncionrolCollection();
            Collection<Funcionrol> funcionrolCollectionNew = rol.getFuncionrolCollection();
            List<String> illegalOrphanMessages = null;
            for (Usuario usuarioCollectionOldUsuario : usuarioCollectionOld) {
                if (!usuarioCollectionNew.contains(usuarioCollectionOldUsuario)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Usuario " + usuarioCollectionOldUsuario + " since its idRol field is not nullable.");
                }
            }
            for (Funcionrol funcionrolCollectionOldFuncionrol : funcionrolCollectionOld) {
                if (!funcionrolCollectionNew.contains(funcionrolCollectionOldFuncionrol)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Funcionrol " + funcionrolCollectionOldFuncionrol + " since its idRol field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Usuario> attachedUsuarioCollectionNew = new ArrayList<Usuario>();
            for (Usuario usuarioCollectionNewUsuarioToAttach : usuarioCollectionNew) {
                usuarioCollectionNewUsuarioToAttach = em.getReference(usuarioCollectionNewUsuarioToAttach.getClass(), usuarioCollectionNewUsuarioToAttach.getIdusuario());
                attachedUsuarioCollectionNew.add(usuarioCollectionNewUsuarioToAttach);
            }
            usuarioCollectionNew = attachedUsuarioCollectionNew;
            rol.setUsuarioCollection(usuarioCollectionNew);
            Collection<Funcionrol> attachedFuncionrolCollectionNew = new ArrayList<Funcionrol>();
            for (Funcionrol funcionrolCollectionNewFuncionrolToAttach : funcionrolCollectionNew) {
                funcionrolCollectionNewFuncionrolToAttach = em.getReference(funcionrolCollectionNewFuncionrolToAttach.getClass(), funcionrolCollectionNewFuncionrolToAttach.getId());
                attachedFuncionrolCollectionNew.add(funcionrolCollectionNewFuncionrolToAttach);
            }
            funcionrolCollectionNew = attachedFuncionrolCollectionNew;
            rol.setFuncionrolCollection(funcionrolCollectionNew);
            rol = em.merge(rol);
            for (Usuario usuarioCollectionNewUsuario : usuarioCollectionNew) {
                if (!usuarioCollectionOld.contains(usuarioCollectionNewUsuario)) {
                    Rol oldIdRolOfUsuarioCollectionNewUsuario = usuarioCollectionNewUsuario.getIdRol();
                    usuarioCollectionNewUsuario.setIdRol(rol);
                    usuarioCollectionNewUsuario = em.merge(usuarioCollectionNewUsuario);
                    if (oldIdRolOfUsuarioCollectionNewUsuario != null && !oldIdRolOfUsuarioCollectionNewUsuario.equals(rol)) {
                        oldIdRolOfUsuarioCollectionNewUsuario.getUsuarioCollection().remove(usuarioCollectionNewUsuario);
                        oldIdRolOfUsuarioCollectionNewUsuario = em.merge(oldIdRolOfUsuarioCollectionNewUsuario);
                    }
                }
            }
            for (Funcionrol funcionrolCollectionNewFuncionrol : funcionrolCollectionNew) {
                if (!funcionrolCollectionOld.contains(funcionrolCollectionNewFuncionrol)) {
                    Rol oldIdRolOfFuncionrolCollectionNewFuncionrol = funcionrolCollectionNewFuncionrol.getIdRol();
                    funcionrolCollectionNewFuncionrol.setIdRol(rol);
                    funcionrolCollectionNewFuncionrol = em.merge(funcionrolCollectionNewFuncionrol);
                    if (oldIdRolOfFuncionrolCollectionNewFuncionrol != null && !oldIdRolOfFuncionrolCollectionNewFuncionrol.equals(rol)) {
                        oldIdRolOfFuncionrolCollectionNewFuncionrol.getFuncionrolCollection().remove(funcionrolCollectionNewFuncionrol);
                        oldIdRolOfFuncionrolCollectionNewFuncionrol = em.merge(oldIdRolOfFuncionrolCollectionNewFuncionrol);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = rol.getId();
                if (findRol(id) == null) {
                    throw new NonexistentEntityException("The rol with id " + id + " no longer exists.");
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
            Rol rol;
            try {
                rol = em.getReference(Rol.class, id);
                rol.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The rol with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Usuario> usuarioCollectionOrphanCheck = rol.getUsuarioCollection();
            for (Usuario usuarioCollectionOrphanCheckUsuario : usuarioCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Rol (" + rol + ") cannot be destroyed since the Usuario " + usuarioCollectionOrphanCheckUsuario + " in its usuarioCollection field has a non-nullable idRol field.");
            }
            Collection<Funcionrol> funcionrolCollectionOrphanCheck = rol.getFuncionrolCollection();
            for (Funcionrol funcionrolCollectionOrphanCheckFuncionrol : funcionrolCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Rol (" + rol + ") cannot be destroyed since the Funcionrol " + funcionrolCollectionOrphanCheckFuncionrol + " in its funcionrolCollection field has a non-nullable idRol field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(rol);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Rol> findRolEntities() {
        return findRolEntities(true, -1, -1);
    }

    public List<Rol> getRoles() {
        EntityManager em = factory.createEntityManager();
        List<Object> result = em.createNativeQuery("select * from rol where id>1;").getResultList();
        List<Rol> listaRol = new ArrayList<Rol>();

        Iterator itr = result.iterator();
        while (itr.hasNext()) {
            Object[] obj = (Object[]) itr.next();
            int identificacion = Integer.parseInt(String.valueOf(obj[0]));
            String nombre = String.valueOf(obj[1]);

            Rol f = new Rol();
            f.setId(identificacion);
            f.setTipo(nombre);

            listaRol.add(f);
        }

        return listaRol;
    }

    public List<Rol> findRolEntities(int maxResults, int firstResult) {
        return findRolEntities(false, maxResults, firstResult);
    }

    private List<Rol> findRolEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Rol.class));
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

    public List<Rol> obtenerRol(String tipo) {
        EntityManager em = factory.createEntityManager();
        List<Object> result = em.createNativeQuery("select * from rol where tipo='" + tipo+"'").getResultList();
        List<Rol> listaRoles = new ArrayList<Rol>();

        Iterator itr = result.iterator();
        while (itr.hasNext()) {
            Object[] obj = (Object[]) itr.next();
            int identificacion = Integer.parseInt(String.valueOf(obj[0]));
            String nombre = String.valueOf(obj[1]);

            Rol f = new Rol();
            f.setId(identificacion);
            f.setTipo(tipo);

            listaRoles.add(f);
        }
        return listaRoles;
    }

    public Rol findRol(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Rol.class, id);
        } finally {
            em.close();
        }
    }

    public int getRolCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Rol> rt = cq.from(Rol.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
