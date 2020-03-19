package ru.kazeev.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import ru.kazeev.jaxrs.fileCRUD.models.AccountEntity;
import ru.kazeev.jaxrs.fileCRUD.models.FileEntity;

public class HibernateSessionFactory {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactory() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(AccountEntity.class);
                configuration.addAnnotatedClass(FileEntity.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                System.out.println("Exception: " + e);
            }
        }

        return sessionFactory;
    }
}