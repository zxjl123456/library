package dao;
import bean.Book;
import bean.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class UserDao {
    private  DBConnection dbConnection;
    public  UserDao(){
        dbConnection=new DBConnection();
    }
    public User Validate(String userName,String passWord){
        User user=null;
        String sql="select * from user where userName='"+userName+"'and password='"+passWord+"'";
        ResultSet resultSet=dbConnection.executeQuery(sql);
        try {
            if (resultSet!=null&&resultSet.next()){
               user=new User(userName,passWord);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dbConnection.closeDb();
        return user;
    }
    public User getUser(String userName) {
        User user = null;
        String sql = "select * from user where userName='" + userName + "'";
        ResultSet resultSet = dbConnection.executeQuery(sql);
        try {
            if (resultSet != null && resultSet.next()) {
                user = new User( userName, resultSet.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dbConnection.closeDb();
        return user;
    }
}
