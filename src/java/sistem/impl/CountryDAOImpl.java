
package sistem.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sistem.dao.CountryDAO;
import sistem.modelo.Country;
import sistem.util.HibernateUtil;

/**
 *
 * @author Meryli
 */
public class CountryDAOImpl implements CountryDAO {

    @Override
    public List<Country> select() {
        List<Country> paises = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        String hql = "FROM Country";
        try {
            paises = session.createQuery(hql).list();
            trans.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            trans.rollback();
        } finally {
            session.close();
        }
        return paises;
    }

    @Override
    public void insert(Country pais) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(pais);
            session.getTransaction().commit();
        } catch (Exception ex) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Country pais) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(pais);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(Country pais) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(pais);
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
