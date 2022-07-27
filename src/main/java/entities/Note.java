package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by OnKa on 26.07.2022.
 */
@Entity
public class Note
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int nid;

    // Admin aid
    private int aid;

    private String title;
    private String detail;
    private String date;

    public int getNid()
    {
        return nid;
    }

    public void setNid(int nid)
    {
        this.nid = nid;
    }

    public int getAid()
    {
        return aid;
    }

    public void setAid(int aid)
    {
        this.aid = aid;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDetail()
    {
        return detail;
    }

    public void setDetail(String detail)
    {
        this.detail = detail;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }
}
