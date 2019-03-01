/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorios;

import Clases.HibernateUtil;
import Entidades.Aspirante;
import Entidades.Categoria;
import Entidades.Competencia;
import Entidades.Escuela;
import java.util.AbstractList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Familia
 */
public class DAO {

    public DAO() {
    }

    public List<Competencia> ListarCompetencias() {
        List<Competencia> lista = null;

        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();

            Session s = sf.openSession();

            Transaction tx = s.beginTransaction();

            String consulta = "From Competencia";

            Query query = s.createQuery(consulta);

            lista = (List<Competencia>) query.list();

            tx.commit();

            s.close();

            return lista;
        } catch (Exception e) {
            return null;
        }

    }

    public List<Escuela> ListarEscuelas() {
        List<Escuela> lista = null;

        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();

            Session s = sf.openSession();

            Transaction tx = s.beginTransaction();

            String consulta = "From Escuela";

            Query query = s.createQuery(consulta);

            lista = (List<Escuela>) query.list();

            tx.commit();

            s.close();

            return lista;
        } catch (Exception e) {
            return null;
        }

    }

    public List<Categoria> ListarCategorias() {
        List<Categoria> lista = null;

        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();

            Session s = sf.openSession();

            Transaction tx = s.beginTransaction();

            String consulta = "From Categoria";

            Query query = s.createQuery(consulta);

            lista = (List<Categoria>) query.list();

            tx.commit();

            s.close();

            return lista;
        } catch (Exception e) {
            return null;
        }

    }

    public Boolean NuevoAspirante(Aspirante entidad) {
        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();

            Session s = sf.openSession();

            Transaction tx = s.beginTransaction();

            Integer id = (Integer) s.save(entidad);

            tx.commit();

            s.close();

            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public Categoria ObtenerCategoria(Integer idCategoria) {
        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();

            Session s = sf.openSession();

            Transaction tx = s.beginTransaction();

            String hql = "FROM Categoria C WHERE C.idCategoria =" + idCategoria;
            Query query = s.createQuery(hql);
            List results = query.list();

            tx.commit();

            s.close();

            return (Categoria) results.get(0);

        } catch (Exception e) {
            return null;
        }
    }

    public Escuela ObtenerEscuelaPorNombre(String nombre) {
        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Session s = sf.openSession();
            Transaction tx = s.beginTransaction();

            String hql = "FROM Escuela E WHERE E.nombre = '" + nombre + "'";
            Query query = s.createQuery(hql);
            List results = query.list();

            tx.commit();

            s.close();

            return (Escuela) results.get(0);

        } catch (HibernateException e) {
            return null;
        }
    }

    
      public Competencia ObtenerCompetenciaPorNombre(String nombre) {
        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Session s = sf.openSession();
            Transaction tx = s.beginTransaction();

            String hql = "FROM Competencia C WHERE C.nombre = '" + nombre + "'";
            Query query = s.createQuery(hql);
            List results = query.list();

            tx.commit();

            s.close();

            return (Competencia) results.get(0);

        } catch (HibernateException e) {
            return null;
        }
    }
    
    
    public List<Aspirante> ListarAspirantesPorEscuela(Integer idEscuela) {
        try {
            
            List<Aspirante> lista = null;
            
            SessionFactory sf = HibernateUtil.getSessionFactory();

            Session s = sf.openSession();

            Transaction tx = s.beginTransaction();

            String hql = "From Aspirante where idEscuela="+idEscuela;
            Query query = s.createQuery(hql);
            lista = (List<Aspirante>) query.list();

            tx.commit();

            s.close();

            return lista;

        } catch (HibernateException e) {
            return null;
        }
    }

    public Aspirante ObtenerAspirante(Integer idAspirante) {
        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();

            Session s = sf.openSession();

            Transaction tx = s.beginTransaction();

            String hql = "FROM Aspirante C WHERE C.idAspirante =" + idAspirante;
            Query query = s.createQuery(hql);
            List results = query.list();

            tx.commit();

            s.close();

            return (Aspirante) results.get(0);

        } catch (Exception e) {
            return null;
        }    
    }

}
