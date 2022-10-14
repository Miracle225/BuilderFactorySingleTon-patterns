/*package dao;
import models.AutoSeller;
import utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AutoSellerDao {
    public AutoSeller findById(int id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(AutoSeller.class,id);
    }
    public void save(AutoSeller autoSeller) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(autoSeller);
        tx1.commit();
        session.close();
    }

    public void update(AutoSeller autoSeller) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(autoSeller);
        tx1.commit();
        session.close();
    }

    public void delete(AutoSeller autoSeller) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(autoSeller);
        tx1.commit();
        session.close();
    }
    public List<AutoSeller> findAll() {
        List<AutoSeller> autoSellers = (List<AutoSeller>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From AutoSeller ").list();
        return autoSellers;
    }
}*/
