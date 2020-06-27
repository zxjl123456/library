package action;

import bean.Book;
import bean.Lend;
import bean.User;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.deploy.net.HttpRequest;
import dao.BookDao;
import org.apache.struts2.ServletActionContext;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStreamReader;
import java.io.IOException;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.HttpHeaderResult;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static com.sun.deploy.config.JREInfo.getAll;

public class BookAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
    private BookDao bookDao;
    private Book book;//用来接收表单数据域参数
    private String bookMessage;
    private ArrayList<Book> books;//所有书籍
    private String condition = "";//模糊查询条件
    private File bookIntro;//上传文件  由struts2拦截器初始化
    private String bookIntroFileName;//上传文件名， 由struts2拦截器初始化
    private String bookIntroContentType;//上传文件类型，由struts2拦截器初始化
    private String bookIntroContent;//存放从简介文件中读取的内容
    private Lend lend;
    private User user;

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

    public void setBookMessage(String bookMessage) {
        this.bookMessage = bookMessage;
    }

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public BookDao getBookDao() {
        return bookDao;
    }
    public BookAction() {
    }

    public BookAction(Book book) {
        this.book = book;
    }

    public String getBookMessage() {
        return bookMessage;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public String addBook() {
        book.setIntro(bookIntroFileName);
      /*  //Book book1 = new Book(book.getId(), book.getTitle(), book.getPrice(), book.getIntro(),book.);
        System.out.println(book);

        System.out.println("当前添加的书籍是：" + book.getTitle());
        BookDao bookDao = new BookDao();*/
        if (bookDao.addBookHibernate(book)) {
            System.out.println("成功添加书籍!");
            writeFile(bookIntro, bookIntroFileName);
            return "success";
        } else {
            return "error";
        }
    }
    public String findBook() {

        books = (ArrayList<Book>)bookDao.findHibernate(book.getTitle());
        if (book != null) {
            return SUCCESS;
        } else {
            bookMessage = "未找到书籍！";
            return ERROR;
        }
    }

    public String list() {
        books =bookDao.getAll();
        if (!books.isEmpty()) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    public String delete() {
        if (bookDao.deleteHibernate(book)) {
            return list();
        } else {
            return ERROR;
        }
    }

    public String updateBook() {
        book.setIntro(bookIntroFileName);
        //根据id获取book
        //将需要修改的 book 数据传入到修改页面
        if (bookDao.updateHibernate(book)) {
           // writeFile(bookIntro, bookIntroFileName);
           book.setBookMessage("修改书籍成功！");
        } else {
           book.setBookMessage("修改书籍失败！");
        }
        return SUCCESS;
    }

    public void writeFile(File file, String fileName) {
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(String.valueOf(file)));
            //ServletContext.getResourceAsStream("/WEB-INF/config/aa.config")方法。
            String path = ServletActionContext.getServletContext().getRealPath("/bookIntroFiles") + "\\" + fileName;
            //String path =request.getClass().getClassLoader().getResource("/bookIntroFiles").getPath()+"\\"+fileName;
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(path)));
            byte[] buffer = new byte[1024];
            while ((bis.read(buffer)) != -1) {
                bos.write(buffer);
            }
            bos.flush();
            bis.close();
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readFile(String path) {
        StringBuilder content =new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path))));
            String buffer;
            while ((buffer = br.readLine()) != null) {
                content.append(buffer).append("<br>") ;
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    public String updateForm() {
        return "success";
    }
    public String readBookIntro() {
        String path = ServletActionContext.getServletContext().getRealPath("/bookIntroFiles") + "\\" + book.getIntro();
        bookIntroContent = readFile(path);
        return "success";
    }

    public File getBookIntro() {
        return bookIntro;
    }

    public void setBookIntro(File bookIntro) {
        this.bookIntro = bookIntro;
    }

    public String getBookIntroFileName() {
        return bookIntroFileName;
    }

    public void setBookIntroFileName(String bookIntroFileName) {
        this.bookIntroFileName = bookIntroFileName;
    }

    public String getBookIntroContentType() {
        return bookIntroContentType;
    }

    public void setBookIntroContentType(String bookIntroContentType) {
        this.bookIntroContentType = bookIntroContentType;
    }

    public String getBookIntroContent() {
        return bookIntroContent;
    }

}



