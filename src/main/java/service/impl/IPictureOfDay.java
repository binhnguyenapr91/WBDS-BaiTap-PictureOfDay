package service.impl;

import model.Feedback;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import service.PictureOfDayService;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class IPictureOfDay implements PictureOfDayService {
    public static EntityManager entityManager;
    public static SessionFactory sessionFactory;
    static {
        try {
            SessionFactory sessionFactory = new Configuration()
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
}
