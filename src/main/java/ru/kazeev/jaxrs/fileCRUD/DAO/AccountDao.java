package ru.kazeev.jaxrs.fileCRUD.DAO;


import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.kazeev.hibernate.HibernateSessionFactory;
import ru.kazeev.jaxrs.fileCRUD.models.AccountEntity;

import java.util.List;


public class AccountDao implements Dao<AccountEntity> {
    @Override
    public AccountEntity getById(int id) {
        return HibernateSessionFactory.getSessionFactory().openSession().get(AccountEntity.class, id);
    }

    @Override
    public List<AccountEntity> getAllById(int id) {
//        List<AccountEntity> accounts = (List<AccountEntity>) HibernateSessionFactory.getSessionFactory().openSession().createQuery("From AccountEntity").list();
//        return accounts;

        return null;
    }

    @Override
    public void save(AccountEntity accountEntity) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(accountEntity);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(AccountEntity accountEntity) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(accountEntity);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(AccountEntity accountEntity) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(accountEntity);
        tx1.commit();
        session.close();
    }
}
