package io.wisoft.tutorial.chapter01.user.dao;

import io.github.cdimascio.dotenv.Dotenv;
import io.wisoft.tutorial.chapter01.user.domain.User;

import java.sql.*;

public class UserDao {
  Dotenv dotenv = Dotenv.load();

  public void add(User user) throws ClassNotFoundException, SQLException {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tobySpring", dotenv.get("ID"), dotenv.get("PASSWORD"));

    PreparedStatement ps = c.prepareStatement(
            "insert into users(id,name, password) values(?,?,?)");
    ps.setString(1, user.getId());
    ps.setString(2, user.getName());
    ps.setString(3, user.getPassword());

    ps.executeUpdate();

    ps.close();
    c.close();
  }

  public User get(String id) throws ClassNotFoundException, SQLException {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tobySpring", dotenv.get("ID"), dotenv.get("PASSWORD"));

    PreparedStatement ps = c.prepareStatement(
            "select * from users where id = ?");
    ps.setString(1, id);

    ResultSet rs = ps.executeQuery();
    rs.next();

    User user = new User();
    user.setId(rs.getString("id"));
    user.setName(rs.getString("name"));
    user.setPassword(rs.getString("password"));

    rs.close();
    ps.close();
    c.close();

    return user;
  }
}
