package ru.kazeev.jaxrs.fileCRUD.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.kazeev.hibernate.HibernateSessionFactory;
import ru.kazeev.jaxrs.fileCRUD.models.AccountEntity;
import ru.kazeev.jaxrs.fileCRUD.models.FileEntity;

import java.util.List;

public class FileDao implements Dao<FileEntity> {
    @Override
    public FileEntity getById(int id) {
        return HibernateSessionFactory.getSessionFactory().openSession().get(FileEntity.class, id);
    }

    @Override
    public List<FileEntity> getAllById(int id) {
//        List<FileEntity> accounts = (List<FileEntity>) HibernateSessionFactory.getSessionFactory().openSession().createQuery("From FileEntity").list();
//        return accounts;

        return null;
    }

    @Override
    public void save(FileEntity fileEntity) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(fileEntity);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(FileEntity fileEntity) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(fileEntity);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(FileEntity fileEntity) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(fileEntity);
        tx1.commit();
        session.close();
    }
}
