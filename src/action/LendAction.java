package action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import bean.Lend;
import org.apache.struts2.ServletActionContext;

import bean.Book;
import bean.User;

import com.opensymphony.xwork2.ActionSupport;

import dao.LendDao;

public class LendAction extends ActionSupport {
    private String message;
    private Book book;
    private User user;
    private Lend lend;
    private ArrayList<Lend> lends;
    private String condition = "";
    private String bookIntroContent = "";
    private LendDao lendDAO;

    public LendDao getLendDAO() {
        return lendDAO;
    }

    public String readFile(String path) {
        String content = "";
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path))));
            String buffer;
            while((buffer = br.readLine()) != null) {
                content = content + buffer + "<br>";
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    public String lend() {
        if (lendDAO.addLend(lend)) {
           // message = "借书成功：" + book.getTitle();
            return "success";
        } else {
            //message = "借书失败！";
            return "error";
        }
    }
   public String lendedList(){

           lends =lendDAO.getAll();
           if (!lends.isEmpty()) {
               System.out.println(lends);
               return SUCCESS;
           } else {
               return ERROR;
           }
       }
    public String returnBook() {
        if (lendDAO.returnBook(lend)) {
            return lendedList();
        } else {
            return ERROR;
        }
    }
    public String readBookIntro() {
        String path = ServletActionContext.getServletContext().getRealPath("/bookIntroFiles") + "\\" + book.getIntro();
        bookIntroContent = readFile(path);
        return "success";
    }

    //以下为属性的setter和getter方法=================================
    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getBookIntroContent() {
        return bookIntroContent;
    }
    //Spring设置注入
    public void setLendDAO(LendDao lendDAO) {
        this.lendDAO = lendDAO;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Lend getLend() {
        return lend;
    }

    public void setLend(Lend lend) {
        this.lend = lend;
    }

    public void setLends(ArrayList<Lend> lends) {
        this.lends = lends;
    }

    public ArrayList<Lend> getLends() {
        return lends;
    }
}
