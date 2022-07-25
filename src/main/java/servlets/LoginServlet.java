package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by TCOKARAKAYA on 25.07.2022.
 */

@WebServlet(name = "loginServlet", value = {"/login"})
public class LoginServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException
    {
        String data = req.getParameter("data");
        System.out.println("doPost Call: " + data);
    }
}
