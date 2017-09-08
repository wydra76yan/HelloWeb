package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import usedb.StudentsEnt;

import java.sql.CallableStatement;
import java.util.List;

/**
 * Created by YanVydra on 19.05.2017.
 */
public class StudentsDAO {
    private Session session;
    public StudentsDAO(Session session) {
        this.session = session;
    }

    // Метод возвращает список
    public List<StudentsEnt> list() {
        session.beginTransaction();
        List<StudentsEnt> result = session.createQuery(" FROM StudentsEnt ").list();
        session.getTransaction().commit();
        return result;
    }


    public void addStudents(String sfio,String slogin,String spass) {
        Transaction t = null;
        //      PostsEnt post1 = new PostsEnt();
        try {
            t = session.beginTransaction();
            session.doWork( connection -> {
                try (CallableStatement function = connection.prepareCall(
                        "{ call student_save(?,?,?) }" )) {
                    function.setString( 1, sfio );
                    function.setString( 2, slogin );
                    function.setString( 3, spass );
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
