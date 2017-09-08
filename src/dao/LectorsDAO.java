package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import usedb.LectorsEnt;


import java.sql.CallableStatement;
import java.util.List;

//import usedb.PostsEnt;

/**
 * Created by YanVydra on 19.05.2017.
 */
public class LectorsDAO {
    private Session session;
    public LectorsDAO(Session session) {
        this.session = session;
    }

    // Метод возвращает список
    public List<LectorsEnt> list() {
        session.beginTransaction();
        List<LectorsEnt> result = session.createQuery(" FROM LectorsEnt ").list();
        session.getTransaction().commit();
        return result;
    }


    public void addLectors(String lfio,String llogin,String lpass) {
        Transaction t = null;
        try {
            t = session.beginTransaction();//shablon of vyzov procedura
            session.doWork( connection -> {
                try (CallableStatement function = connection.prepareCall(
                        "{ call lector_save(?,?,?) }" )) {
                    function.setString( 1, lfio );
                    function.setString( 2, llogin );
                    function.setString( 3, lpass );
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
