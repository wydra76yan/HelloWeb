package Servlets;

import IMPL.LectorsDAOImpl;
import IMPL.StudentsDAOImpl;
//import webutils.DIO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by YanVydra on 19.05.2017.
 */
@WebServlet(name = "StudentMainServlet", urlPatterns ="/StudRegistration")
public class StudentMainServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String lfio = request.getParameter("sfio");
        String llogin = request.getParameter("slogin");
        String lpass = request.getParameter("spass");
        System.out.println("  ===  "+lfio+" "+llogin+" "+lpass);

        if( !(lfio.isEmpty() || llogin.isEmpty() || lpass.isEmpty())) {
            try {
                StudentsDAOImpl.addStudent(lfio, llogin, lpass);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        response.sendRedirect("/StudRegistration");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try  {
            request.setAttribute("mystudents", StudentsDAOImpl.getStudents());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("WEB-INF/StudRegistration.jsp").forward(request,response);
    }
}
