package service.impl;

import model.Feedback;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import service.PictureOfDayService;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

public class IPictureOfDay implements PictureOfDayService {

    public static EntityManager entityManager;
    public static SessionFactory sessionFactory;
    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Feedback> getAllFeedback() {
        String queryStr = "SELECT c FROM Feedback AS c";
        TypedQuery<Feedback> query = entityManager.createQuery(queryStr, Feedback.class);
        return query.getResultList();
    }

    @Override
    public Feedback addFeedback(Feedback feedback) {
        Session session = null;
        Transaction transaction = null;
        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Feedback handler = new Feedback();
            handler.setAuthor(feedback.getAuthor());
            handler.setComment(feedback.getComment());
            handler.setStar(feedback.getStar());
            handler.setTime( new Date());
            session.save(handler);
            transaction.commit();
            return handler;
        }catch (Exception e){
            e.printStackTrace();
            if(transaction!=null){
                transaction.rollback();
            }
        }finally {
            if (session != null){
                session.close();
            }
        }
        return null;
    }

    @Override
    public void updateById(int id, Feedback feedback) {
        Session session = null;
        Transaction transaction = null;
        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Feedback handler = getById(feedback.getId());
            handler.setNumberOfLike(handler.getNumberOfLike()+1);
            session.saveOrUpdate(handler);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            if(transaction!=null){
                transaction.rollback();
            }
        }finally {
            if (session != null){
                session.close();
            }
        }
    }

    @Override
    public Feedback getById(int id) {
        Feedback handler;
        String queryStr = "select c from Feedback as c where c.id = :id";
        TypedQuery<Feedback> query = entityManager.createQuery(queryStr,Feedback.class);
        query.setParameter("id",id);
        handler = query.getSingleResult();
        return handler;
    }
}
