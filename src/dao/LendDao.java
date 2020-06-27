package dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import org.hibernate.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import bean.Book;
import bean.Lend;
import bean.User;

public class LendDao {

    //借书
    public boolean addLend(Lend lend) {
        Configuration config = new Configuration().configure();
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
               // Lend lend = new Lend(book.getId(),user.getUserName(),book.getId(),book.getTitle(),new Date());
        lend.setLtime(new Date());
        System.out.println(lend);
       String id= (String) session.save(lend);
               transaction.commit();

                session.close();
                sessionFactory.close();
                if (id!=null) {
                    return true;
                } else {
                    return false;
                }

    }

    /**
     * 已借图书
     * @return
     */
    public ArrayList<Lend> getAll() {
        Configuration config = new Configuration().configure();
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query=session.createQuery("from Lend ");
        ArrayList<Lend> lends= (ArrayList<Lend>) query.list();
        transaction.commit();
        session.close();
        sessionFactory.close();
        return lends;
    }

    public boolean returnBook (Lend lend ) {
        Configuration config = new Configuration().configure();
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(lend);
        transaction.commit();
        session.close();
        return true;
    }
  /*  @SuppressWarnings("unchecked")
    public ArrayList<Book> findLendedBook(User user) {
        ArrayList<Book> books = new ArrayList<Book>();
        String hql;
        Session session = null;
        Transaction transaction = null;
        Query query = null;
        try {
            session = sessionFactory.openSession();;
            transaction = session.beginTransaction();
            if (user != null) {
                hql = "from Book as book where book.id in (select isbn from Lend where name=:name)";
                query = session.createQuery(hql).setString("name", user.getUserName());
                books = (ArrayList<Book>)query.list();
                transaction.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null)
                session.close();
        }
        return books;
    }*/
}
