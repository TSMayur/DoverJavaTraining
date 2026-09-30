package com.training.employee.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;

public final class HibernateUtil {
    private static final SessionFactory SESSION_FACTORY = buildSessionFactory();

    private HibernateUtil() {}

    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }

    public static void shutdown() {
        if (!SESSION_FACTORY.isClosed()) {
            SESSION_FACTORY.close();
        }
    }

    private static SessionFactory buildSessionFactory() {
        Properties db = new Properties();
        try (InputStream input = HibernateUtil.class.getClassLoader().getResourceAsStream("db.properties")) {
            if (input == null) throw new IllegalStateException("Create db.properties from db.properties.example.");
            db.load(input);
        } catch (IOException exception) {
            throw new ExceptionInInitializerError(exception);
        }
        return new Configuration().configure()
                .setProperty(AvailableSettings.URL, db.getProperty("db.url"))
                .setProperty(AvailableSettings.USER, db.getProperty("db.username"))
                .setProperty(AvailableSettings.PASS, db.getProperty("db.password"))
                .buildSessionFactory();
    }
}
