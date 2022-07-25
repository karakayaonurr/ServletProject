package services;

/**
 * Created by TCOKARAKAYA on 25.07.2022.
 */
public class LoginService
{
    public boolean login(String email, String password)
    {
        boolean status = false;
        if (email.equals("aaa@aaa.com") && password.equals("bbb"))
        {
            status = true;
        }

        return status;
    }
}
