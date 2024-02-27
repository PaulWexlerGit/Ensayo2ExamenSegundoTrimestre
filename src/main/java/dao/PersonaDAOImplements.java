package dao;

import jakarta.persistence.NoResultException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import model.Persona;
import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class PersonaDAOImplements implements PersonaDAO {

    @Override
    public void createPersona(Persona persona) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(persona);
            transaction.commit();
        } catch (HibernateError exception) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println(exception.getMessage());
        }
    }

    @Override
    public void actualizaPersona(Persona persona) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(persona);
            transaction.commit();
        } catch (HibernateError exception) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println(exception.getMessage());
        }
    }

    @Override
    public Persona logIn(String nombreUsuario, String contrasegna) {
        Persona persona;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Persona> query = builder.createQuery(Persona.class);
            Root<Persona> UserTable = query.from(Persona.class);
            query.where(builder.and(builder.equal(UserTable.get("nombreUsuario"),
                    nombreUsuario)), builder.equal(UserTable.get("contrasegna"), contrasegna));
            persona = session.createQuery(query).getSingleResult();
            return persona;
        } catch (NoResultException exception) {
            System.err.println(exception.getMessage());
            return null;
        }
    }
}
