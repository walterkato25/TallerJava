package ttps.clasificados;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "ttps.clasificados.Login",urlPatterns = {"/login"})

public class Login extends HttpServlet {
    Map<String,String> users;
    Map<String,String> usersRol;


    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        users = new HashMap<>();
        usersRol = new HashMap<>();
        users.put("ezequiel@gmail.com","123");
        users.put("andres@gmail.com","123");
        users.put("kato@gmail.com","123");
        users.put("franco@gmail.com","123");
        usersRol.put("ezequiel@gmail.com","publicador");
        usersRol.put("andres@gmail.com","publicador");
        usersRol.put("kato@gmail.com","admin");
        usersRol.put("franco@gmail.com","admin");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mail = request.getParameter("email");
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/menu");
        if(users.containsKey(request.getParameter("email"))){
            if(request.getParameter("password").equals(users.get(request.getParameter("email")))){

                request.setAttribute("rol",usersRol.get(request.getParameter("email")));
                dispatcher.forward(request, response);



            }else{
                response.sendRedirect("error.html");
            }
        }
        else response.sendRedirect("error.html");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/login.html");
    }
}
