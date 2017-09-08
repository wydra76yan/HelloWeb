package Servlets;

import IMPL.LectorsDAOImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



/**
 * Created by YanVydra on 19.05.2017.
 */
@WebServlet(name = "LectorsList", urlPatterns ="/lectorslistone")
public class LectorsList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String lfio = request.getParameter("lfio");
        String llogin = request.getParameter("llogin");
        String lpass = request.getParameter("lpass");
        System.out.println("  ===  "+lfio+" "+llogin+" "+lpass);

        if( !(lfio.isEmpty() || llogin.isEmpty() || lpass.isEmpty())) {
            try {
                LectorsDAOImpl.addLector(lfio, llogin, lpass);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        response.sendRedirect("/lectorslistone");
//        response.sendRedirect("WEB-INF/lectorslistone.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try  {//вывод списка
            request.setAttribute("lecs", LectorsDAOImpl.getLectors());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("WEB-INF/lectorslistone.jsp").forward(request,response);
    }
}
