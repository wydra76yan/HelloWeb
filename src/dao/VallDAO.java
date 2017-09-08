package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import usedb.VallEnt;

import java.sql.CallableStatement;
import java.util.List;

/**
 * Created by YanVydra on 19.05.2017.
 */
public class VallDAO {
    private Session session;
    public VallDAO(Session session) {
        this.session = session;
    }

    // Метод возвращает список
    public List<VallEnt> list() {
        session.beginTransaction();
            List<VallEnt> result = session.createQuery(" FROM VallEnt order by nCourse, fio, sfio", VallEnt.class).getResultList();
        session.getTransaction().commit();
        return result;
    }

    public void updateMark(int pidstuding, int pmark) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
           session.doWork( connection -> {
                try (CallableStatement function = connection.prepareCall(
                        "{ call save_mark(?,?) }" )) {
                    function.setInt( 1, pidstuding );
                    function.setInt( 2, pmark );
                    function.execute();
                }
            } );
//                session.flush();  // save changed from program
                session.clear();
              tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            tx.rollback();
        }
    }

}
