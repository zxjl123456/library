package bean;

import java.util.Date;
import java.util.Random;

public class Lend {
    private String Id;
    private String userName;
    private String title;
    private Date ltime;
    public Lend(String id, String userName, String title, Date ltime) {
        Id = id;
        this.userName = userName;
        this.title = title;
        this.ltime = ltime;
    }

    public Lend() {
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getLtime() {
        return ltime;
    }

    public void setLtime(Date ltime) {
        this.ltime = ltime;
    }

    @Override
    public String toString() {
        return "Lend{" +
                "Id=" + Id +
                ", userName='" + userName + '\'' +
                ", title='" + title + '\'' +
                ", ltime=" + ltime +
                '}';
    }
}
