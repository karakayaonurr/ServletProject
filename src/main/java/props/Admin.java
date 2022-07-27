package props;

/**
 * Created by OnKa on 26.07.2022.
 */
public class Admin {

    private int aid;
    private String name;
    private String email;

    public Admin(int aid, String name, String email) {
        this.aid = aid;
        this.name = name;
        this.email = email;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
