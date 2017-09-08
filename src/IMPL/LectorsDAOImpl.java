package IMPL;

import dao.LectorsDAO;
import dao.VallDAO;
import org.hibernate.Session;
import usedb.LectorsEnt;
import usedb.VallEnt;
import utils.HibernateUtil;
import webutils.Lectors;
import webutils.Vall;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YanVydra on 19.05.2017.
 */
public class LectorsDAOImpl {


    private static Session session = HibernateUtil.getSession();
    private static LectorsDAO lectorsDAO = new LectorsDAO(session);
    private static VallDAO vallDAO = new VallDAO(session);

    public static List<Lectors> getLectors() throws ClassNotFoundException {
        ArrayList<Lectors> lectors = new ArrayList<>();
        for (LectorsEnt o: lectorsDAO.list()) {
            lectors.add(new Lectors(o.getIdLec(), o.getFio(),o.getLlogin(), o.getLpassword()));
        }
        return lectors;
    }

    public static List<Vall> getVall(int il) throws ClassNotFoundException {
        ArrayList<Vall> vall = new ArrayList<>();
        int nord=0;
        for (VallEnt o: vallDAO.list()) {
            if(il == o.getIdLec()) //  Add only for this lectors
                vall.add(new Vall(++nord, o.getId(), o.getIdLec(), o.getIdCourse(), o.getIdStud()
                        , o.getFio(), o.getnCourse(), o.getSfio(), o.getMark()));

        }
        return vall;
    }
    public static int checkLectors(String tlogin, String tpassword)throws ClassNotFoundException { //удаление из таблицы
        int t=0;
        try{
            for (LectorsEnt o: lectorsDAO.list()) {
                if (tlogin.equals(o.getLlogin()) )
                    if(tpassword.equals(o.getLpassword())) t=o.getIdLec();
                    else t=-1;
            }
        } catch (NullPointerException e){
            e.printStackTrace();
        }
        return t;
    }

    public static void addLector(String lfio, String llogin, String lpass) throws  ClassNotFoundException{
        lectorsDAO.addLectors(lfio,llogin, lpass);
    }
    public  static void UpdateMark(int pid, int pmark) throws  ClassNotFoundException{
        vallDAO.updateMark(pid, pmark);
    }

    // for testing only
    public static void main(String[] args) throws ClassNotFoundException  {

        System.out.println(getVall(1));
        System.out.println(checkLectors("mat","123"));

    }

}
