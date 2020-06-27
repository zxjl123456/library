package dao;

import bean.Author;
import bean.Book;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import utils.DBConnection;
import utils.DBConnection;

import javax.imageio.spi.ServiceRegistry;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao{

    /**
     * 添加图书
     *
     * @param book * @return
     */


    public boolean addBookHibernate(Book book) {
        Configuration config = new Configuration().configure();
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        String id = (String) session.save(book);
        System.out.println("book=" + book);
        transaction.commit();
        session.close();
        sessionFactory.close();
        if (id != null) {
            return true;
        } else {
            return false;
        }
    }
    public boolean deleteHibernate(Book book) {
        Configuration config = new Configuration().configure();
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(book);
        transaction.commit();
        session.close();
        sessionFactory.close();
        return true;
    }


    /**
     * 根据书名查找图书
     *
     * @param title
     * @return
     */



    public List findHibernate(String title) {
        Configuration config = new Configuration().configure();
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
       // Book book = null;
        //String title=book.getTitle();
        String sql="from Book  where title=:title";
        Query query= session.createQuery(sql);
        query.setString("title",title);
        List list= query.list();
        transaction.commit();
        session.close();
        sessionFactory.close();
        return list;
    }



    public boolean updateHibernate(Book book) {
        Configuration config = new Configuration().configure();
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(book);
        transaction.commit();
        session.close();
       return true;
    }
    public ArrayList<Book> getAll() {
        Configuration config = new Configuration().configure();
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query=session.createQuery("from Book");
        ArrayList<Book> books= (ArrayList<Book>) query.list();
        Query query1=session.createQuery("from Author ");
        ArrayList<Author> authors= (ArrayList<Author>) query.list();
        transaction.commit();
        session.close();
        sessionFactory.close();

        return books;
    }
}
