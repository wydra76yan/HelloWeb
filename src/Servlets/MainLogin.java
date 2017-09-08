package Servlets;

import IMPL.LectorsDAOImpl;
import IMPL.StudentsDAOImpl;
import webutils.Vall;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * Created by YanVydra on 19.05.2017.
 */
@WebServlet(name = "MainLogin", urlPatterns ="/MainLoginm")
public class MainLogin extends HttpServlet {
    public List<Vall> MVall;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try  {
            String logtxt = request.getParameter("login");
            String passtxt = request.getParameter("pass");
            // Update mark
              try{
                    if (!request.getParameter("id").isEmpty())
                    //    && !request.getParameter("nmark").isEmpty())
                    {
                            int id = Integer.parseInt(request.getParameter("id"));
                            int nmark = Integer.parseInt(request.getParameter("nmark"));
                            System.out.println("==  "+id + ' ' + nmark);
                            LectorsDAOImpl.UpdateMark(id, nmark);
                    }
              } catch (NullPointerException e) {
                  e.printStackTrace();
              }

            int t= LectorsDAOImpl.checkLectors( logtxt, passtxt);
            System.out.println(logtxt + ' ' + passtxt+' '+t);//для отслеживания
            switch (t) {
                case -1://pass wrong
                    System.out.println(logtxt + ' ' + passtxt+' '+t);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    break;
                case 0://login wrong  may be it is a student
                    try{
                        //добавляем студенту курс
                        if (!request.getParameter("pidcourse").isEmpty() && !request.getParameter("pidstud").isEmpty()){
                            int ic = Integer.parseInt(request.getParameter("pidcourse"));
                            int is = Integer.parseInt(request.getParameter("pidstud"));
                            System.out.println("==  "+ic + ' ' + is);
                            StudentsDAOImpl.AddStuding(ic, is);
                        }
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                    }

                    t= StudentsDAOImpl.checkStudents( logtxt, passtxt);
                    System.out.println(logtxt + ' ' + passtxt+' '+t);
                    switch (t) {
                        case -1:
                            System.out.println(logtxt + ' ' + passtxt+' '+t);
                            request.getRequestDispatcher("index.jsp").forward(request, response);
                            break;
                        case 0:
                            System.out.println(logtxt + ' ' + passtxt+' '+t);
                            request.getRequestDispatcher("index.jsp").forward(request, response);
                            break;
                        default:
                            request.setAttribute("lects", StudentsDAOImpl.getVall(t));
                            request.setAttribute("cours", StudentsDAOImpl.getVnall(t));
                            request.setAttribute("login", logtxt);
                            request.setAttribute("pass", passtxt);
                            request.getRequestDispatcher("WEB-INF/StudentLogin1.jsp").forward(request,response);
                            break;
                    }
                    break;
                default:

                    request.setAttribute("lects", LectorsDAOImpl.getVall(t));
                    request.setAttribute("login", logtxt);
                    request.setAttribute("pass", passtxt);
                    request.getRequestDispatcher("WEB-INF/LectorLogin1.jsp").forward(request,response);
                    break;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
