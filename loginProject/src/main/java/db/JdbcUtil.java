package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

//데이터베이스 작업을 할 때 반복적으로 수행해야 하는 작업을 정의하는 클래스
public class JdbcUtil {

  public static Connection getConnection() {
    Connection con = null;
    try {
      Context initCtx = new InitialContext();
      Context envCtx = (Context) initCtx.lookup("java:comp/env");
      DataSource ds = (DataSource) envCtx.lookup("jdbc/jsptest");
      con = ds.getConnection();
      con.setAutoCommit(false);
      System.out.println("connect succes");
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return con;
  }

  public static void close(Connection con) {
    if (con != null) {
      try {
        con.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public static void close(Statement stmt) {
    if (stmt != null) {
      try {
        stmt.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public static void close(ResultSet rs) {
    if (rs != null) {
      try {
        rs.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public static void commit(Connection con) {
    if (con != null) {
      try {
        con.commit();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public static void rollback(Connection con) {
    if (con != null) {
      try {
        con.rollback();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}











