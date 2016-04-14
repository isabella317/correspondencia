/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Funciones;

import DAO.Funciones.exceptions.NonexistentEntityException;
import DAO.Funciones.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import DAO.Tablas.Funcionario;
import DAO.Tablas.Rol;
import DAO.Tablas.Usuario;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ISABELLA
 */
public class DaoUsuario implements Serializable {

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("correspondenciaPU");

    public DaoUsuario(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Usuario usuario) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Funcionario idFuncionario = usuario.getIdFuncionario();
            if (idFuncionario != null) {
                idFuncionario = em.getReference(idFuncionario.getClass(), idFuncionario.getIdentificacion());
                usuario.setIdFuncionario(idFuncionario);
            }
            Rol idRol = usuario.getIdRol();
            if (idRol != null) {
                idRol = em.getReference(idRol.getClass(), idRol.getId());
                usuario.setIdRol(idRol);
            }
            em.persist(usuario);
            if (idFuncionario != null) {
                idFuncionario.getUsuarioCollection().add(usuario);
                idFuncionario = em.merge(idFuncionario);
            }
            if (idRol != null) {
                idRol.getUsuarioCollection().add(usuario);
                idRol = em.merge(idRol);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findUsuario(usuario.getIdusuario()) != null) {
                throw new PreexistingEntityException("Usuario " + usuario + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Usuario usuario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario persistentUsuario = em.find(Usuario.class, usuario.getIdusuario());
            Funcionario idFuncionarioOld = persistentUsuario.getIdFuncionario();
            Funcionario idFuncionarioNew = usuario.getIdFuncionario();
            Rol idRolOld = persistentUsuario.getIdRol();
            Rol idRolNew = usuario.getIdRol();
            if (idFuncionarioNew != null) {
                idFuncionarioNew = em.getReference(idFuncionarioNew.getClass(), idFuncionarioNew.getIdentificacion());
                usuario.setIdFuncionario(idFuncionarioNew);
            }
            if (idRolNew != null) {
                idRolNew = em.getReference(idRolNew.getClass(), idRolNew.getId());
                usuario.setIdRol(idRolNew);
            }
            usuario = em.merge(usuario);
            if (idFuncionarioOld != null && !idFuncionarioOld.equals(idFuncionarioNew)) {
                idFuncionarioOld.getUsuarioCollection().remove(usuario);
                idFuncionarioOld = em.merge(idFuncionarioOld);
            }
            if (idFuncionarioNew != null && !idFuncionarioNew.equals(idFuncionarioOld)) {
                idFuncionarioNew.getUsuarioCollection().add(usuario);
                idFuncionarioNew = em.merge(idFuncionarioNew);
            }
            if (idRolOld != null && !idRolOld.equals(idRolNew)) {
                idRolOld.getUsuarioCollection().remove(usuario);
                idRolOld = em.merge(idRolOld);
            }
            if (idRolNew != null && !idRolNew.equals(idRolOld)) {
                idRolNew.getUsuarioCollection().add(usuario);
                idRolNew = em.merge(idRolNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = usuario.getIdusuario();
                if (findUsuario(id) == null) {
                    throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.");
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
            Usuario usuario;
            try {
                usuario = em.getReference(Usuario.class, id);
                usuario.getIdusuario();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.", enfe);
            }
            Funcionario idFuncionario = usuario.getIdFuncionario();
            if (idFuncionario != null) {
                idFuncionario.getUsuarioCollection().remove(usuario);
                idFuncionario = em.merge(idFuncionario);
            }
            Rol idRol = usuario.getIdRol();
            if (idRol != null) {
                idRol.getUsuarioCollection().remove(usuario);
                idRol = em.merge(idRol);
            }
            em.remove(usuario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Usuario> findUsuarioEntities() {
        return findUsuarioEntities(true, -1, -1);
    }

    public List<Funcionario> funcionarioXApellidos() {
        EntityManager em = factory.createEntityManager();
        List<Object> result = em.createNativeQuery("select * from usuario inner join funcionario on  usuario.idusuario=funcionario.identificacion order by apellido").getResultList();
        List<Funcionario> listaFuncionario = new ArrayList<Funcionario>();

        Iterator itr = result.iterator();
        while (itr.hasNext()) {
            Object[] obj = (Object[]) itr.next();
            String identificacion = String.valueOf(obj[5]);
            String nombre = String.valueOf(obj[7]);
            String apellido = String.valueOf(obj[8]);
            String telefono = String.valueOf(obj[10]);
            String correo = String.valueOf(obj[11]);
            String sede = String.valueOf(obj[13]);

            Funcionario f = new Funcionario();
            f.setIdentificacion(identificacion);
            f.setNombre(nombre);
            f.setApellido(apellido);
            f.setTelefono(telefono);
            f.setEmail(correo);
            f.setSede(sede);

            listaFuncionario.add(f);
        }

        return listaFuncionario;
    }

    public List<Usuario> findUsuarioEntities(int maxResults, int firstResult) {
        return findUsuarioEntities(false, maxResults, firstResult);
    }

    private List<Usuario> findUsuarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuario.class));
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

    public Usuario findUsuario(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuario.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usuario> rt = cq.from(Usuario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
