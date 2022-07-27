package config;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by OnKa on 26.07.2022.
 */
public class DB
{
    private final String driver = "org.h2.Driver";
    private final String url = "jdbc:h2:file:~/turkcell_pro;OLD_INFORMATION_SCHEMA=TRUE";
    private final String user = "sa";
    private final String password = "";

    private Connection con = null;

    public Connection conn()
    {
        try
        {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connection Success");
        }
        catch (Exception ex)
        {
            System.err.println("Conn Error : " + ex);
        }

        return con;
    }

    public void close()
    {
        try
        {
            if (con != null && !con.isClosed())
            {
                conn().close();
            }
        }
        catch (Exception ex)
        {
            System.err.println("Close Error : " + ex);
        }
    }
}
