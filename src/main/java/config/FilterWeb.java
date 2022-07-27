package config;

import props.Admin;
import utils.Util;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by OnKa on 25.07.2022.
 */

// "*" her servlet için çalış demektir, servlet bazlı filter konulabilir
@WebFilter("*")
public class FilterWeb implements Filter
{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
        System.out.println(" Server UP ");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
    {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");

        String agent = req.getHeader("user-agent");
        System.out.println(agent);

        String ip = req.getRemoteAddr();
        System.out.println(ip);

        String sessionID = req.getSession().getId();
        System.out.println(sessionID);

        Enumeration<String> enumeration = req.getHeaderNames();
        while (enumeration.hasMoreElements())
        {
            String key = enumeration.nextElement();
            String val = req.getHeader(key);
            System.out.println(key + " : " + val);
        }


        String url = req.getRequestURI();
        url = url.replace(Util.sub_url, "");

        String[] urls = {"/", "/index.jsp", "/login"};
        boolean sessionStatus = true;
        for (String item : urls)
        {
            if (item.equals(url))
            {
                sessionStatus = false;
            }
        }

        if (sessionStatus == true)
        {
            cookieControl(req, res);
            boolean status = req.getSession().getAttribute("user") == null;
            if (status)
            {
                // oturum yok!
                res.sendRedirect(Util.url);
            }
            else
            {
                Admin admin = (Admin) req.getSession().getAttribute("user");
                req.setAttribute("admin", admin);
            }
        }

        filterChain.doFilter(req, res);
    }

    private void cookieControl(HttpServletRequest req, HttpServletResponse res)
    {
        if (req.getCookies() != null)
        {
            Cookie[] cookies = req.getCookies();
            for (Cookie item : cookies)
            {
                if (item.getName().equals("user"))
                {
                    String data = item.getValue();
                    req.getSession().setAttribute("user", data);
                    break;
                }
            }
        }
    }

    @Override
    public void destroy()
    {
        System.out.println(" Server DOWN ");
    }
}
