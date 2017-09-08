package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import usedb.VnallEnt;

import java.sql.CallableStatement;
import java.util.List;

//import usedb.PostsEnt;

/**
 * Created by YanVydra on 19.05.2017.
 */
public class VnallDAO {
    private static Session session;
    public VnallDAO(Session session) {
        this.session = session;
    }

    // Метод возвращает список
    public  static List<VnallEnt> list() {
        session.beginTransaction();
        List<VnallEnt> result = session.createQuery(" FROM VnallEnt ").list();
        session.getTransaction().commit();
        return result;
    }

    public static void AddStuding(int pic, int pis) {
        Transaction t = null;
        try {
            t = session.beginTransaction();
            session.doWork( connection -> {
                try (CallableStatement function = connection.prepareCall(
                        "{ call studing_add(?,?) }" )) {
                    function.setInt( 1, pic );
                    function.setInt( 2, pis );
                    function.execute();
                }
            } );
            t.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
             t.rollback();
        }
    }

}
