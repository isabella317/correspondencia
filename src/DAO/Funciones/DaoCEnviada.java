/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Funciones;

import static Controlador.GestionCorrespondencia.controladorAnularCorrespondencia.DeStringADate;
import static Controlador.GestionCorrespondencia.controladorExterno.DuDafuncionario;
import static Controlador.controladorInicioSesion.Conconexion;
import static Controlador.controladorInicioSesion.DuDaofuncionario;
import DAO.Funciones.exceptions.NonexistentEntityException;
import DAO.Tablas.CEnviada;
import DAO.Tablas.Funcionario;
import DAO.Tablas.FuncionarioExterno;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
public class DaoCEnviada implements Serializable {

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("correspondenciaPU");

    public DaoCEnviada(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CEnviada CEnviada) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(CEnviada);
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
            Object result = em.createNativeQuery("SELECT consecutivo_e FROM c_enviada ORDER BY consecutivo_e desc limit 1").getSingleResult();

            valor = Integer.parseInt(result.toString());
        } catch (javax.persistence.NoResultException ex) {
            valor = 0;

        }
        return valor;

    }

    public void edit(CEnviada CEnviada) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CEnviada = em.merge(CEnviada);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = CEnviada.getConsecutivoE();
                if (findCEnviada(id) == null) {
                    throw new NonexistentEntityException("The cEnviada with id " + id + " no longer exists.");
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
            CEnviada CEnviada;
            try {
                CEnviada = em.getReference(CEnviada.class, id);
                CEnviada.getConsecutivoE();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The CEnviada with id " + id + " no longer exists.", enfe);
            }
            em.remove(CEnviada);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CEnviada> findCEnviadaEntities() {
        return findCEnviadaEntities(true, -1, -1);
    }

    public List<CEnviada> findCEnviadaEntities(int maxResults, int firstResult) {
        return findCEnviadaEntities(false, maxResults, firstResult);
    }

    private List<CEnviada> findCEnviadaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CEnviada.class));
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

    public CEnviada findCEnviada(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CEnviada.class, id);
        } finally {
            em.close();
        }
    }

    public int getCEnviadaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CEnviada> rt = cq.from(CEnviada.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public List<CEnviada> getCorrespondenciaIntervalo(String fechaInicial, String fechaFinal) {
        EntityManager em = factory.createEntityManager();
        List<Object> result = em.createNativeQuery("SELECT * FROM c_enviada  where fecha between'" + fechaInicial + "'and'" + fechaFinal + "'and estado=true order by consecutivo_e asc").getResultList();
        List<CEnviada> listaCorrespondencia = new ArrayList<CEnviada>();

        Iterator itr = result.iterator();
        while (itr.hasNext()) {
            Object[] obj = (Object[]) itr.next();
            int consecutivo = (int) (obj[0]);
            String asunto = String.valueOf(obj[1]);
            String observaciones = String.valueOf(obj[2]);
            String tipocorreo = String.valueOf(obj[3]);
            String funcionario = String.valueOf(obj[4]);
            String funcionarioExt = String.valueOf(obj[5]);
            boolean estado = (boolean) (obj[6]);
            String encargado = String.valueOf(obj[7]);
            Date fecha = (Date) (obj[8]);

            DuDaofuncionario = new DaoFuncionario(Conconexion.getConexion());
            Funcionario func = DuDaofuncionario.findFuncionario(funcionario);

            DuDafuncionario = new DaoFuncionarioExterno(Conconexion.getConexion());
            FuncionarioExterno funcExt = DuDafuncionario.findFuncionarioExterno(funcionarioExt);

            CEnviada correspondencia = new CEnviada(consecutivo, fecha, asunto, observaciones, tipocorreo, func, funcExt, encargado, estado);
            listaCorrespondencia.add(correspondencia);
        }

        return listaCorrespondencia;
    }

}
