package services;

import config.DB;
import props.Admin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by OnKa on 25.07.2022.
 */
public class LoginService
{
    public Admin login(String email, String password)
    {
        boolean status = false;
        DB db = new DB();
        try
        {
            String sql = "select * from admin where email = ? and password = ? ";
            PreparedStatement st = db.conn().prepareStatement(sql);
            st.setString(1, email);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            status = rs.next(); // data varsa true dön
            if (status)
            {
                int aid = rs.getInt("aid");
                String name = rs.getString("name");
                String mail = rs.getString("email");
                Admin admin = new Admin(aid, name, mail);
                return admin;
            }
        }
        catch (Exception ex)
        {
            System.err.println("login error : " + ex);
        }
        finally
        {
            db.close();
        }
        return null;
    }

    /*
    public boolean login( String email, String password ) {
        boolean status = false;
        DB db = new DB();
        try {
            String sql = "select * from admin where email = '"+email+"' and password = '"+password+"' ";
            System.out.println( sql );
            // select * from admin where email = 'q@q.com' and password = '' or 1 = 1 --'
            Statement st = db.conn().createStatement();
            ResultSet rs = st.executeQuery(sql);
            status = rs.next(); // data varsa true dön
        }catch (Exception ex ) {
            System.err.println("login error : " + ex);
        }finally {
            db.close();
        }
        return status;
    }
     */
}
