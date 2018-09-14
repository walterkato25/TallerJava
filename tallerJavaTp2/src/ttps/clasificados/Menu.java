package ttps.clasificados;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="Menu", urlPatterns = {"/menu"})
public class Menu extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rol = request.getAttribute("rol").toString();
        if(rol.equals("admin")){
            response.sendRedirect("menu.html");
        }else{
            response.sendRedirect("menuPublicador.html");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

