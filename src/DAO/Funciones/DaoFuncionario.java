/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Funciones;

import DAO.Funciones.exceptions.IllegalOrphanException;
import DAO.Funciones.exceptions.NonexistentEntityException;
import DAO.Funciones.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import DAO.Tablas.Dependencia;
import DAO.Tablas.Funcionario;
import DAO.Tablas.Usuario;
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
public class DaoFuncionario implements Serializable {

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("correspondenciaPU");

    public DaoFuncionario(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Funcionario funcionario) throws PreexistingEntityException, Exception {
        if (funcionario.getUsuarioCollection() == null) {
            funcionario.setUsuarioCollection(new ArrayList<Usuario>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Dependencia idDependencia = funcionario.getIdDependencia();
            if (idDependencia != null) {
                idDependencia = em.getReference(idDependencia.getClass(), idDependencia.getId());
                funcionario.setIdDependencia(idDependencia);
            }
            Collection<Usuario> attachedUsuarioCollection = new ArrayList<Usuario>();
            for (Usuario usuarioCollectionUsuarioToAttach : funcionario.getUsuarioCollection()) {
                usuarioCollectionUsuarioToAttach = em.getReference(usuarioCollectionUsuarioToAttach.getClass(), usuarioCollectionUsuarioToAttach.getIdusuario());
                attachedUsuarioCollection.add(usuarioCollectionUsuarioToAttach);
            }
            funcionario.setUsuarioCollection(attachedUsuarioCollection);
            em.persist(funcionario);
            if (idDependencia != null) {
                idDependencia.getFuncionarioCollection().add(funcionario);
                idDependencia = em.merge(idDependencia);
            }
            for (Usuario usuarioCollectionUsuario : funcionario.getUsuarioCollection()) {
                Funcionario oldIdFuncionarioOfUsuarioCollectionUsuario = usuarioCollectionUsuario.getIdFuncionario();
                usuarioCollectionUsuario.setIdFuncionario(funcionario);
                usuarioCollectionUsuario = em.merge(usuarioCollectionUsuario);
                if (oldIdFuncionarioOfUsuarioCollectionUsuario != null) {
                    oldIdFuncionarioOfUsuarioCollectionUsuario.getUsuarioCollection().remove(usuarioCollectionUsuario);
                    oldIdFuncionarioOfUsuarioCollectionUsuario = em.merge(oldIdFuncionarioOfUsuarioCollectionUsuario);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findFuncionario(funcionario.getIdentificacion()) != null) {
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Funcionario funcionario) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Funcionario persistentFuncionario = em.find(Funcionario.class, funcionario.getIdentificacion());
            Dependencia idDependenciaOld = persistentFuncionario.getIdDependencia();
            Dependencia idDependenciaNew = funcionario.getIdDependencia();
            Collection<Usuario> usuarioCollectionOld = persistentFuncionario.getUsuarioCollection();
            Collection<Usuario> usuarioCollectionNew = funcionario.getUsuarioCollection();
            List<String> illegalOrphanMessages = null;
            for (Usuario usuarioCollectionOldUsuario : usuarioCollectionOld) {
                if (!usuarioCollectionNew.contains(usuarioCollectionOldUsuario)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Usuario " + usuarioCollectionOldUsuario + " since its idFuncionario field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idDependenciaNew != null) {
                idDependenciaNew = em.getReference(idDependenciaNew.getClass(), idDependenciaNew.getId());
                funcionario.setIdDependencia(idDependenciaNew);
            }
            Collection<Usuario> attachedUsuarioCollectionNew = new ArrayList<Usuario>();
            for (Usuario usuarioCollectionNewUsuarioToAttach : usuarioCollectionNew) {
                usuarioCollectionNewUsuarioToAttach = em.getReference(usuarioCollectionNewUsuarioToAttach.getClass(), usuarioCollectionNewUsuarioToAttach.getIdusuario());
                attachedUsuarioCollectionNew.add(usuarioCollectionNewUsuarioToAttach);
            }
            usuarioCollectionNew = attachedUsuarioCollectionNew;
            funcionario.setUsuarioCollection(usuarioCollectionNew);
            funcionario = em.merge(funcionario);
            if (idDependenciaOld != null && !idDependenciaOld.equals(idDependenciaNew)) {
                idDependenciaOld.getFuncionarioCollection().remove(funcionario);
                idDependenciaOld = em.merge(idDependenciaOld);
            }
            if (idDependenciaNew != null && !idDependenciaNew.equals(idDependenciaOld)) {
                idDependenciaNew.getFuncionarioCollection().add(funcionario);
                idDependenciaNew = em.merge(idDependenciaNew);
            }
            for (Usuario usuarioCollectionNewUsuario : usuarioCollectionNew) {
                if (!usuarioCollectionOld.contains(usuarioCollectionNewUsuario)) {
                    Funcionario oldIdFuncionarioOfUsuarioCollectionNewUsuario = usuarioCollectionNewUsuario.getIdFuncionario();
                    usuarioCollectionNewUsuario.setIdFuncionario(funcionario);
                    usuarioCollectionNewUsuario = em.merge(usuarioCollectionNewUsuario);
                    if (oldIdFuncionarioOfUsuarioCollectionNewUsuario != null && !oldIdFuncionarioOfUsuarioCollectionNewUsuario.equals(funcionario)) {
                        oldIdFuncionarioOfUsuarioCollectionNewUsuario.getUsuarioCollection().remove(usuarioCollectionNewUsuario);
                        oldIdFuncionarioOfUsuarioCollectionNewUsuario = em.merge(oldIdFuncionarioOfUsuarioCollectionNewUsuario);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = funcionario.getIdentificacion();
                if (findFuncionario(id) == null) {
                    throw new NonexistentEntityException("The funcionario with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Funcionario> funcionarioXApellidos() {
        EntityManager em = factory.createEntityManager();
        List<Object> result = em.createNativeQuery("SELECT * FROM funcionario WHERE   (identificacion IN (select id_funcionario	FROM usuario where id_rol<>1 order by apellido))").getResultList();
        List<Funcionario> listaFuncionario = new ArrayList<Funcionario>();

        Iterator itr = result.iterator();
        while (itr.hasNext()) {
            Object[] obj = (Object[]) itr.next();
            String identificacion = String.valueOf(obj[0]);
            String nombre = String.valueOf(obj[2]);
            String apellido = String.valueOf(obj[3]);
            String telefono = String.valueOf(obj[5]);
            String correo = String.valueOf(obj[6]);
            String sede = String.valueOf(obj[8]);

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

    public List<Funcionario> ultimosRegistrarCorrespondencia() {
        EntityManager em = factory.createEntityManager();
        List<Object> result = em.createNativeQuery("select * from (select DISTINCT ON(identificacion) identificacion,nombre,apellido,telefono,email,consecutivo_e FROM funcionario JOIN c_enviada ON funcionario.identificacion=c_enviada.id_funcionario limit 10 )as foo order by consecutivo_e desc").getResultList();
        List<Funcionario> listaFuncionario = new ArrayList<Funcionario>();

        Iterator itr = result.iterator();
        while (itr.hasNext()) {
            Object[] obj = (Object[]) itr.next();
            String identificacion = String.valueOf(obj[0]);
            String nombre = String.valueOf(obj[1]);
            String apellido = String.valueOf(obj[2]);
            String telefono = String.valueOf(obj[3]);
            String correo = String.valueOf(obj[4]);
            String sede = String.valueOf(obj[5]);

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
    
    public List<Funcionario> noUsuarios() {
        EntityManager em = factory.createEntityManager();
        List<Object> result = em.createNativeQuery("SELECT * FROM funcionario WHERE SEDE=" + "'YUMBO'  " + "  and NOT(identificacion in (select id_funcionario	FROM usuario))").getResultList();
        List<Funcionario> listaFuncionario = new ArrayList<Funcionario>();

        Iterator itr = result.iterator();
        while (itr.hasNext()) {
            Object[] obj = (Object[]) itr.next();
            String identificacion = String.valueOf(obj[0]);
            String nombre = String.valueOf(obj[2]);
            String apellido = String.valueOf(obj[3]);
            String telefono = String.valueOf(obj[5]);
            String correo = String.valueOf(obj[6]);
            String sede = String.valueOf(obj[8]);

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

    public void destroy(String id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Funcionario funcionario;
            try {
                funcionario = em.getReference(Funcionario.class, id);
                funcionario.getIdentificacion();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The funcionario with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Usuario> usuarioCollectionOrphanCheck = funcionario.getUsuarioCollection();
            for (Usuario usuarioCollectionOrphanCheckUsuario : usuarioCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Funcionario (" + funcionario + ") cannot be destroyed since the Usuario " + usuarioCollectionOrphanCheckUsuario + " in its usuarioCollection field has a non-nullable idFuncionario field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Dependencia idDependencia = funcionario.getIdDependencia();
            if (idDependencia != null) {
                idDependencia.getFuncionarioCollection().remove(funcionario);
                idDependencia = em.merge(idDependencia);
            }
            em.remove(funcionario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Funcionario> findFuncionarioEntities() {
        return findFuncionarioEntities(true, -1, -1);
    }

    public List<Funcionario> findFuncionarioEntities(int maxResults, int firstResult) {
        return findFuncionarioEntities(false, maxResults, firstResult);
    }

    public List<Funcionario> getPaginacion(int noregistro, int paginacion) {

        EntityManager em = factory.createEntityManager();
        List<Object> result = em.createNativeQuery("SELECT * FROM funcionario order by apellido LIMIT '" + paginacion + "'OFFSET '" + noregistro + "'").getResultList();
        List<Funcionario> listaFuncionario = new ArrayList<Funcionario>();

        Iterator itr = result.iterator();
        while (itr.hasNext()) {
            Object[] obj = (Object[]) itr.next();
            String identificacion = String.valueOf(obj[0]);
            String nombre = String.valueOf(obj[2]);
            String apellido = String.valueOf(obj[3]);
            String telefono = String.valueOf(obj[5]);
            String correo = String.valueOf(obj[6]);
            String sede = String.valueOf(obj[8]);

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

    public int getPaginacionUsuarioContar() {

        EntityManager em = factory.createEntityManager();
        Object result = em.createNativeQuery(" SELECT count(*) FROM funcionario WHERE   (identificacion IN (select id_funcionario FROM usuario where id_rol<>1))").getSingleResult();
        int valor = 0;

        valor = Integer.parseInt(result.toString());

        return valor;

    }

    public List<Funcionario> getPaginacionUsuario(int noregistro, int paginacion) {

        EntityManager em = factory.createEntityManager();
        List<Object> result = em.createNativeQuery("SELECT * FROM funcionario WHERE   (identificacion IN (select id_funcionario FROM usuario where id_rol<>1 ))order by apellido  LIMIT '" + paginacion + "'OFFSET '" + noregistro + "'").getResultList();
        List<Funcionario> listaFuncionario = new ArrayList<Funcionario>();

        Iterator itr = result.iterator();
        while (itr.hasNext()) {
            Object[] obj = (Object[]) itr.next();
            String identificacion = String.valueOf(obj[0]);
            String nombre = String.valueOf(obj[2]);
            String apellido = String.valueOf(obj[3]);
            String telefono = String.valueOf(obj[5]);
            String correo = String.valueOf(obj[6]);
            String sede = String.valueOf(obj[8]);

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

    public List<Funcionario> findFuncionarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Funcionario.class));
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

    public Funcionario findFuncionario(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Funcionario.class, id);
        } finally {
            em.close();
        }
    }

    public int getFuncionarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Funcionario> rt = cq.from(Funcionario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
