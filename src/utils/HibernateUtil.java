package utils;

/**
 * Created by vydra on 01.05.2017.
 */

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;


public class HibernateUtil {

    private static final SessionFactory ourSessionFactory;//for work with db

    static{
        try {
            Configuration cfg = new Configuration();
            cfg.configure(new File("hibernate.cfg.xml")); //hibernate config xml file name//for db
            cfg.getProperties().setProperty("connection.url","jdbc:mysql://localhost:3306/YanDB");
            cfg.getProperties().setProperty("connection.driver_class","com.mysql.jdbc.Driver");
            cfg.getProperties().setProperty("hibernate.connection.username","useryan");
            cfg.getProperties().setProperty("hibernate.connection.password","123456");
            ourSessionFactory = cfg.buildSessionFactory();
        } catch (Throwable e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory(){ return ourSessionFactory;  }

    public static Session getSession() throws HibernateException {return ourSessionFactory.openSession(); }

    public static void shutDown(){
        getSessionFactory().close();
    }
}
