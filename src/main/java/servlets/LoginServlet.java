package servlets;

import props.Admin;
import services.LoginService;
import utils.Util;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by OnKa on 25.07.2022.
 */

@WebServlet(name = "loginServlet", value = {"/login"})
public class LoginServlet extends HttpServlet
{

    final LoginService loginService;

    public LoginServlet()
    {
        this.loginService = new LoginService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember");

        Admin admin = loginService.login(email, password);
        if (admin != null)
        {
            //cookie create
            if (remember != null && remember.equals("on"))
            {
                Cookie cookie = new Cookie("user", email);
                cookie.setMaxAge(60 * 60);
                resp.addCookie(cookie);
            }

            // session create
            req.getSession().setAttribute("user", admin);
            resp.sendRedirect(Util.url + "dashboard.jsp");
        }
        else
        {
            //resp.sendRedirect(Util.url + "?error=true");

            req.setAttribute("loginError", "e-Mail or Password Fail");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/");
            dispatcher.forward(req, resp);
        }
    }
}
