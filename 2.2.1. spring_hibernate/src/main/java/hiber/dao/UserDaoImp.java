package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   private final SessionFactory sessionFactory;

   public UserDaoImp(SessionFactory sessionFactory) {
      this.sessionFactory = sessionFactory;

   }

   @Transactional
   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   public List<User> listUsers() {
      TypedQuery<User> query = sessionFactory.openSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public List<User> findByModelAndSeries(String model, int series) {
      TypedQuery<User> query = sessionFactory.openSession().createQuery("from User where car.model = :model and car.series = :series");
      query.setParameter("model", model);
      query.setParameter("series", series);
      return query.getResultList();
   }
}
