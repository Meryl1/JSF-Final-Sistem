
package sistem.impl;

import sistem.dao.CityDAO;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sistem.modelo.City;
import sistem.util.HibernateUtil;

/**
 *
 * @author Meryli
 */
public class CityDAOImpl implements CityDAO{
    @Override
    public List<City> select() {
        List<City> ciudades = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        String hql = "FROM City";
        try {
            ciudades = session.createQuery(hql).list();
            trans.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            trans.rollback();
        } finally {
            session.close();
        }
        return ciudades;
    }

    @Override
    public void insert(City ciudad) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(ciudad);
            session.getTransaction().commit();
        } catch (Exception ex) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(City ciudad) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(ciudad);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(City ciudad) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(ciudad);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            if (session != null && session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
}
