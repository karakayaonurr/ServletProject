package servlets;

import config.HibernateUtil;
import entities.Note;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import props.Admin;
import utils.Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by OnKa on 26.07.2022.
 */
@WebServlet(name = "noteServlet", value = {"/noteAdd}"})
public class NoteServlet extends HttpServlet
{
    SessionFactory sf = HibernateUtil.getSessionFactory();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {

        String title = req.getParameter("title");
        String detail = req.getParameter("detail");
        String date = req.getParameter("date");
        Admin admin = (Admin) req.getSession().getAttribute("user");
        Note note = new Note();
        note.setAid(admin.getAid());
        note.setDate(date);
        note.setDetail(detail);
        note.setTitle(title);


        // Hibernate Insert
        Session sesi = sf.openSession();
        Transaction tr = sesi.beginTransaction();

        sesi.save(note);
        tr.commit();
        sesi.close();

        resp.sendRedirect(Util.url + "dashboard.jsp");

    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {

        String snid = req.getParameter("nid");
        try
        {
            int nid = Integer.parseInt(snid);
            System.out.println("snid :" + nid);
        }
        catch (Exception ex)
        {

        }
        resp.sendRedirect(Util.url + "dashboard.jsp");

    }
}

