package dao;

import jakarta.persistence.NoResultException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import model.Libro;
import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class LibroDAOImplements implements LibroDAO {
    @Override
    public void crateLibro(Libro libro) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(libro);
            transaction.commit();
        } catch (HibernateError exception) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println(exception.getMessage());
        }
    }

    @Override
    public List<Libro> getAllLibros() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Libro> query = builder.createQuery(Libro.class);
            Root<Libro> userRoot = query.from(Libro.class);
            return session.createQuery(query).getResultList();
        } catch (NoResultException error) {
            System.err.println(error.getMessage());
            return null;
        }
    }
}
