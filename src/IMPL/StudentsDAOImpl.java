package IMPL;


import dao.StudentsDAO;
import dao.VallDAO;
import dao.VnallDAO;
import org.hibernate.Session;
import usedb.StudentsEnt;
import usedb.VallEnt;
import usedb.VnallEnt;
import utils.HibernateUtil;
import webutils.Students;
import webutils.Vall;
import webutils.Vnall;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by YanVydra on 19.05.2017.
 */
public class StudentsDAOImpl {

    private static Session session = HibernateUtil.getSession();
    private static StudentsDAO studentsDAO = new StudentsDAO(session);
    private static VallDAO vallDAO = new VallDAO(session);
    private static VnallDAO vnallDAO = new VnallDAO(session);

    public static List<Students> getStudents() throws ClassNotFoundException {
        ArrayList<Students> students = new ArrayList<>();
        for (StudentsEnt o: studentsDAO.list()) {
            students.add(new Students(o.getIdStud(), o.getSfio(),o.getLlogin(),o.getLpassword()));
        }
        return students;
    }

    public static List<Vall> getVall(int is) throws ClassNotFoundException {
        ArrayList<Vall> vall = new ArrayList<>();
        int nord=0;
        for (VallEnt o: vallDAO.list()) {
            if(is == o.getIdStud()) { //  Add only for this student
                vall.add(new Vall(++nord, o.getId(), o.getIdLec(), o.getIdCourse(), o.getIdStud()
                        , o.getFio(), o.getnCourse(), o.getSfio(), o.getMark()));
            }
        }
        return vall;
    }

    //получить списко по коду студента
    public static List<Vnall> getVnall(int is) throws ClassNotFoundException {
        ArrayList<Vnall> vnall = new ArrayList<>();
        int nord =0;
        for (VnallEnt o: vnallDAO.list()) {
            System.out.println(o.getIdStud());
            System.out.println(o.getSfio());
            if(is == o.getIdStud()) { //  Add only for this student
                vnall.add(new Vnall(++nord, o.getIdCourse(), o.getIdLec(), o.getIdStud(), o.getnCourse(), o.getSfio()));
            }
        }
        return vnall;
    }
    //password proverd
    public static int checkStudents(String tlogin, String tpassword)throws ClassNotFoundException {
        int t=0;
        try {
            for (StudentsEnt o : studentsDAO.list()) {
                if (tlogin.equals(o.getLlogin()))
                    if (tpassword.equals(o.getLpassword())) t = o.getIdStud();
                    else t = -1;
            }
        } catch (NullPointerException e){
            e.printStackTrace();
        }
        return t;
    }

// register for curs
   public static void AddStuding(int pic, int pis) throws  ClassNotFoundException{
       vnallDAO.AddStuding(pic, pis);
//       session.refresh(vallDAO);
   }
//register student
    public static void addStudent(String sfio,String slogin,String spass) throws  ClassNotFoundException{
        studentsDAO.addStudents(sfio, slogin, spass);
        //session.refresh(vnallDAO);
    }

    // for testing only
    public static void main(String[] args) throws ClassNotFoundException  {
        System.out.println(getStudents());
    }

}
