package services;

import config.HibernateUtil;
import entities.Note;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import props.Admin;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by TCOKARAKAYA on 27.07.2022.
 */
public class NoteService
{
    SessionFactory sf = HibernateUtil.getSessionFactory();

    public List<Note> allNote(HttpServletRequest request)
    {
        Admin admin = (Admin) request.getSession().getAttribute("user");
        Session sesi = sf.openSession();
        List<Note> list = sesi
                .createQuery("from Note where aid = ?1 ")
                .setParameter(1, admin.getAid())
                .list();
        return list;
    }
}
